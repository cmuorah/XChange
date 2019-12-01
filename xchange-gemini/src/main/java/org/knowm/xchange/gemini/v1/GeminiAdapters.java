package org.knowm.xchange.gemini.v1;

import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.Order.OrderStatus;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.Fee;
import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.marketdata.Trades.TradeSortType;
import org.knowm.xchange.dto.meta.CurrencyMetaData;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.meta.ExchangeMetaData;
import org.knowm.xchange.dto.trade.*;
import org.knowm.xchange.exceptions.NotYetImplementedForExchangeException;
import org.knowm.xchange.gemini.v1.dto.account.GeminiBalancesResponse;
import org.knowm.xchange.gemini.v1.dto.account.GeminiTrailingVolumeResponse;
import org.knowm.xchange.gemini.v1.dto.account.GeminiTransfer;
import org.knowm.xchange.gemini.v1.dto.marketdata.*;
import org.knowm.xchange.gemini.v1.dto.trade.GeminiOrderStatusResponse;
import org.knowm.xchange.gemini.v1.dto.trade.GeminiTradeResponse;
import org.knowm.xchange.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.Map.Entry;

public final class GeminiAdapters {

    public static final Logger LOG = LoggerFactory.getLogger(GeminiAdapters.class);

    private GeminiAdapters() {
    }

    public static List<CurrencyPair> adaptCurrencyPairs(Collection<String> GeminiSymbol) {

        List<CurrencyPair> currencyPairs = new ArrayList<>();
        for (String symbol : GeminiSymbol) {
            currencyPairs.add(adaptCurrencyPair(symbol));
        }
        return currencyPairs;
    }

    public static CurrencyPair adaptCurrencyPair(String GeminiSymbol) {

        String tradableIdentifier = GeminiSymbol.substring(0, 3).toUpperCase();
        String transactionCurrency = GeminiSymbol.substring(3).toUpperCase();
        return new CurrencyPair(tradableIdentifier, transactionCurrency);
    }

    public static String adaptCurrencyPair(CurrencyPair pair) {

        return (pair.base.getCurrencyCode() + pair.counter.getCurrencyCode()).toLowerCase();
    }

    public static OrderBook adaptOrderBook(GeminiDepth btceDepth, CurrencyPair currencyPair) {
        OrdersContainer asksOrdersContainer = adaptOrders(btceDepth.getAsks(), currencyPair, OrderType.ASK);
        OrdersContainer bidsOrdersContainer = adaptOrders(btceDepth.getBids(), currencyPair, OrderType.BID);
        return new OrderBook(Math.max(asksOrdersContainer.getTimestamp(), bidsOrdersContainer.getTimestamp()), asksOrdersContainer.getLimitOrders(), bidsOrdersContainer.getLimitOrders());
    }

    public static OrdersContainer adaptOrders(
            GeminiLevel[] GeminiLevels, CurrencyPair currencyPair, OrderType orderType) {

        Double maxTimestamp = (double) Long.MIN_VALUE;
        List<LimitOrder> limitOrders = new ArrayList<>(GeminiLevels.length);

        for (GeminiLevel GeminiLevel : GeminiLevels) {
            if (GeminiLevel.getTimestamp().compareTo(maxTimestamp) > 0) {
                maxTimestamp = GeminiLevel.getTimestamp();
            }

            Date timestamp = convertDoubleTimestampToDate(GeminiLevel.getTimestamp());
            limitOrders.add(adaptOrder(GeminiLevel.getAmount(), GeminiLevel.getPrice(), currencyPair, orderType, timestamp));
        }

        long maxTimestampInMillis = Math.round(maxTimestamp * ((double) 1000L));
        return new OrdersContainer(maxTimestampInMillis, limitOrders);
    }

    public static Order adaptOrder(GeminiOrderStatusResponse geminiOrderStatusResponse) {

        long id = geminiOrderStatusResponse.getId();
        CurrencyPair currencyPair = adaptCurrencyPair(geminiOrderStatusResponse.getSymbol());
        Double averageExecutionPrice = geminiOrderStatusResponse.getAvgExecutionPrice();
        Double executedAmount = geminiOrderStatusResponse.getExecutedAmount();
        Double originalAmount = geminiOrderStatusResponse.getOriginalAmount();
        OrderType orderType =
                (geminiOrderStatusResponse.getSide().equals("buy")) ? OrderType.BID : OrderType.ASK;
        OrderStatus orderStatus = adaptOrderstatus(geminiOrderStatusResponse);
        Date timestamp = new Date(geminiOrderStatusResponse.getTimestampms() / 1000);

        if (geminiOrderStatusResponse.getType().contains("limit")) {

            Double limitPrice = geminiOrderStatusResponse.getPrice();

            return new LimitOrder(
                    orderType,
                    originalAmount,
                    currencyPair,
                    Long.toString(id),
                    timestamp.getTime(),
                    limitPrice,
                    averageExecutionPrice,
                    executedAmount,
                    null,
                    orderStatus);

        } else if (geminiOrderStatusResponse.getType().contains("market")) {

            return new MarketOrder(
                    orderType,
                    originalAmount,
                    currencyPair,
                    Long.toString(id),
                    timestamp.getTime(),
                    averageExecutionPrice,
                    executedAmount,
                    null,
                    orderStatus);
        }

        throw new NotYetImplementedForExchangeException();
    }

    private static OrderStatus adaptOrderstatus(GeminiOrderStatusResponse geminiOrderStatusResponse) {

        if (geminiOrderStatusResponse.isCancelled()) return OrderStatus.CANCELED;

        if (geminiOrderStatusResponse.getRemainingAmount().equals(0.0)) return OrderStatus.FILLED;

        if (geminiOrderStatusResponse.getRemainingAmount().compareTo(0.0) > 0)
            return OrderStatus.PARTIALLY_FILLED;

        throw new NotYetImplementedForExchangeException();
    }

    public static LimitOrder adaptOrder(
            Double amount, Double price, CurrencyPair currencyPair, OrderType orderType, Date timestamp) {

        return new LimitOrder(orderType, amount, currencyPair, "", timestamp.getTime(), price);
    }

    public static List<FixedRateLoanOrder> adaptFixedRateLoanOrders(
            GeminiLendLevel[] orders, String currency, String orderType, String id) {

        List<FixedRateLoanOrder> loanOrders = new ArrayList<>(orders.length);

        for (GeminiLendLevel order : orders) {
            if ("yes".equalsIgnoreCase(order.getFrr())) {
                continue;
            }

            // Bid orderbook is reversed order. Insert at reversed indices
            if (orderType.equalsIgnoreCase("loan")) {
                loanOrders.add(
                        0,
                        adaptFixedRateLoanOrder(
                                currency, order.getAmount(), order.getPeriod(), orderType, id, order.getRate()));
            } else {
                loanOrders.add(
                        adaptFixedRateLoanOrder(
                                currency, order.getAmount(), order.getPeriod(), orderType, id, order.getRate()));
            }
        }

        return loanOrders;
    }

    public static FixedRateLoanOrder adaptFixedRateLoanOrder(
            String currency, Double amount, int dayPeriod, String direction, String id, Double rate) {

        OrderType orderType = direction.equalsIgnoreCase("loan") ? OrderType.BID : OrderType.ASK;

        return new FixedRateLoanOrder(orderType, currency, amount, dayPeriod, id, null, rate);
    }

    public static List<FloatingRateLoanOrder> adaptFloatingRateLoanOrders(
            GeminiLendLevel[] orders, String currency, String orderType, String id) {

        List<FloatingRateLoanOrder> loanOrders = new ArrayList<>(orders.length);

        for (GeminiLendLevel order : orders) {
            if ("no".equals(order.getFrr())) {
                continue;
            }

            // Bid orderbook is reversed order. Insert at reversed indices
            if (orderType.equalsIgnoreCase("loan")) {
                loanOrders.add(
                        0,
                        adaptFloatingRateLoanOrder(
                                currency, order.getAmount(), order.getPeriod(), orderType, id, order.getRate()));
            } else {
                loanOrders.add(
                        adaptFloatingRateLoanOrder(
                                currency, order.getAmount(), order.getPeriod(), orderType, id, order.getRate()));
            }
        }

        return loanOrders;
    }

    public static FloatingRateLoanOrder adaptFloatingRateLoanOrder(
            String currency, Double amount, int dayPeriod, String direction, String id, Double rate) {

        OrderType orderType = direction.equalsIgnoreCase("loan") ? OrderType.BID : OrderType.ASK;

        return new FloatingRateLoanOrder(orderType, currency, amount, dayPeriod, id, null, rate);
    }

    public static Trade adaptTrade(GeminiTrade trade, CurrencyPair currencyPair) {

        OrderType orderType = trade.getType().equals("buy") ? OrderType.BID : OrderType.ASK;
        Double amount = trade.getAmount();
        Double price = trade.getPrice();
        Date date = DateUtils.fromMillisUtc(trade.getTimestamp() * 1000L); // Gemini uses Unix timestamps
        final String tradeId = String.valueOf(trade.getTradeId());
        return new Trade(orderType, amount, currencyPair, price, date.getTime(), tradeId);
    }

    public static Trades adaptTrades(GeminiTrade[] trades, CurrencyPair currencyPair) {

        List<Trade> tradesList = new ArrayList<>(trades.length);
        long lastTradeId = 0;
        for (GeminiTrade trade : trades) {
            long tradeId = trade.getTradeId();
            if (tradeId > lastTradeId) {
                lastTradeId = tradeId;
            }
            tradesList.add(adaptTrade(trade, currencyPair));
        }
        return new Trades(tradesList, lastTradeId, TradeSortType.SortByID);
    }

    public static Ticker adaptTicker(GeminiTicker GeminiTicker, CurrencyPair currencyPair) {

        Double last = GeminiTicker.getLast();
        Double bid = GeminiTicker.getBid();
        Double ask = GeminiTicker.getAsk();
        Double volume = GeminiTicker.getVolume().getBaseVolume(currencyPair);

        Date timestamp = DateUtils.fromMillisUtc(GeminiTicker.getVolume().getTimestampMS());

        return new Ticker.Builder()
                .currencyPair(currencyPair)
                .last(last)
                .bid(bid)
                .ask(ask)
                .volume(volume)
                .timestamp(timestamp.getTime())
                .build();
    }

    public static Wallet adaptWallet(GeminiBalancesResponse[] response) {

        Map<String, Double[]> balancesByCurrency = new HashMap<>(); // {total, available}

        // for each currency we have multiple balances types: exchange, trading, deposit.
        // each of those may be partially frozen/available
        for (GeminiBalancesResponse balance : response) {
            String currencyName = balance.getCurrency().toUpperCase();
            Double[] balanceDetail = balancesByCurrency.get(currencyName);
            if (balanceDetail == null) {
                balanceDetail = new Double[]{balance.getAmount(), balance.getAvailable()};
            } else {
                balanceDetail[0] = balanceDetail[0] + (balance.getAmount());
                balanceDetail[1] = balanceDetail[1] + (balance.getAvailable());
            }
            balancesByCurrency.put(currencyName, balanceDetail);
        }

        List<Balance> balances = new ArrayList<>(balancesByCurrency.size());
        for (Entry<String, Double[]> entry : balancesByCurrency.entrySet()) {
            String currencyName = entry.getKey();
            Double[] balanceDetail = entry.getValue();
            Double balanceTotal = balanceDetail[0];
            Double balanceAvailable = balanceDetail[1];
            balances.add(new Balance(Currency.getInstance(currencyName), balanceTotal, balanceAvailable));
        }

        return Wallet.Builder.from(balances).build();
    }

    public static OpenOrders adaptOrders(GeminiOrderStatusResponse[] activeOrders) {

        List<LimitOrder> limitOrders = new ArrayList<>(activeOrders.length);

        for (GeminiOrderStatusResponse order : activeOrders) {
            OrderType orderType = order.getSide().equalsIgnoreCase("buy") ? OrderType.BID : OrderType.ASK;
            CurrencyPair currencyPair = adaptCurrencyPair(order.getSymbol());
            Date timestamp = convertDoubleTimestampToDate(new Double(order.getTimestamp()));

            OrderStatus status = OrderStatus.NEW;

            if (order.isCancelled()) {
                status = OrderStatus.CANCELED;
            } else if (order.getExecutedAmount() > 0
                    && order.getExecutedAmount().compareTo(order.getOriginalAmount()) < 0) {
                status = OrderStatus.PARTIALLY_FILLED;
            } else if (order.getExecutedAmount().compareTo(order.getOriginalAmount()) == 0) {
                status = OrderStatus.FILLED;
            }

            LimitOrder limitOrder =
                    new LimitOrder(
                            orderType,
                            order.getOriginalAmount(),
                            currencyPair,
                            String.valueOf(order.getId()),
                            timestamp.getTime(),
                            order.getPrice(),
                            order.getAvgExecutionPrice(),
                            order.getExecutedAmount(),
                            null,
                            status);

            limitOrders.add(limitOrder);
        }

        return new OpenOrders(limitOrders);
    }

    public static UserTrades adaptTradeHistory(GeminiTradeResponse[] trades, String symbol) {

        List<UserTrade> pastTrades = new ArrayList<>(trades.length);
        CurrencyPair currencyPair = adaptCurrencyPair(symbol);

        for (GeminiTradeResponse trade : trades) {
            OrderType orderType = trade.getType().equalsIgnoreCase("buy") ? OrderType.BID : OrderType.ASK;
            Date timestamp = convertDoubleTimestampToDate(trade.getTimestamp());
            final Double fee = trade.getFeeAmount();
            pastTrades.add(
                    new UserTrade(
                            orderType,
                            trade.getAmount(),
                            currencyPair,
                            trade.getPrice(),
                            timestamp.getTime(),
                            trade.getTradeId(),
                            trade.getOrderId(),
                            fee,
                            Currency.getInstance(trade.getFeeCurrency())));
        }

        return new UserTrades(pastTrades, TradeSortType.SortByTimestamp);
    }

    private static Date convertDoubleTimestampToDate(Double timestampInSeconds) {

        return new Date((long) Math.floor(timestampInSeconds * 1000));
    }

    public static ExchangeMetaData adaptMetaData(
            List<CurrencyPair> currencyPairs, ExchangeMetaData metaData) {

        Map<CurrencyPair, CurrencyPairMetaData> pairsMap = metaData.getCurrencyPairs();
        Map<Currency, CurrencyMetaData> currenciesMap = metaData.getCurrencies();
        for (CurrencyPair c : currencyPairs) {
            if (!pairsMap.containsKey(c)) {
                pairsMap.put(c, null);
            }
            if (!currenciesMap.containsKey(c.base)) {
                currenciesMap.put(c.base, null);
            }
            if (!currenciesMap.containsKey(c.counter)) {
                currenciesMap.put(c.counter, null);
            }
        }

        return metaData;
    }

    public static Map<CurrencyPair, Fee> AdaptDynamicTradingFees(
            GeminiTrailingVolumeResponse volumeResponse, List<CurrencyPair> currencyPairs) {
        Map<CurrencyPair, Fee> result = new Hashtable<>();
        double bpsToFraction = 1d / 10000d;
        Fee feeAcrossCurrencies =
                new Fee(
                        volumeResponse.apiMakerFeeBPS * (bpsToFraction),
                        volumeResponse.apiTakerFeeBPS * (bpsToFraction));
        for (CurrencyPair currencyPair : currencyPairs) {
            result.put(currencyPair, feeAcrossCurrencies);
        }

        return result;
    }

    public static FundingRecord adapt(GeminiTransfer transfer) {
        FundingRecord.Status status = FundingRecord.Status.PROCESSING;
        if (transfer.status.equals("Complete")) status = FundingRecord.Status.COMPLETE;
        if (transfer.status.equals("Advanced")) status = FundingRecord.Status.COMPLETE;

        String description = "";
        if (transfer.purpose != null) description = transfer.purpose;

        if (transfer.method != null) description += " " + transfer.method;

        description = description.trim();

        FundingRecord.Type type =
                transfer.type.equals("Withdrawal")
                        ? FundingRecord.Type.WITHDRAWAL
                        : FundingRecord.Type.DEPOSIT;

        return new FundingRecord.Builder()
                .setStatus(status)
                .setType(type)
                .setInternalId(transfer.eid)
                .setAddress(transfer.destination)
                .setCurrency(Currency.getInstance(transfer.currency))
                .setDate(DateUtils.fromMillisUtc(transfer.timestamp).getTime())
                .setAmount(transfer.amount)
                .setBlockchainTransactionHash(transfer.txnHash)
                .setDescription(description)
                .build();
    }

    public static class OrdersContainer {

        private final long timestamp;
        private final List<LimitOrder> limitOrders;

        /**
         * Constructor
         *
         * @param timestamp
         * @param limitOrders
         */
        public OrdersContainer(long timestamp, List<LimitOrder> limitOrders) {

            this.timestamp = timestamp;
            this.limitOrders = limitOrders;
        }

        public long getTimestamp() {

            return timestamp;
        }

        public List<LimitOrder> getLimitOrders() {

            return limitOrders;
        }
    }
}
