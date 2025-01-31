package org.knowm.xchange.wex.v3;

import net.openhft.chronicle.core.Maths;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderStatus;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.marketdata.Trades.TradeSortType;
import org.knowm.xchange.dto.meta.CurrencyMetaData;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.meta.ExchangeMetaData;
import org.knowm.xchange.dto.meta.RateLimit;
import org.knowm.xchange.dto.trade.*;
import org.knowm.xchange.utils.DateUtils;
import org.knowm.xchange.wex.v3.dto.account.WexAccountInfo;
import org.knowm.xchange.wex.v3.dto.marketdata.WexExchangeInfo;
import org.knowm.xchange.wex.v3.dto.marketdata.WexPairInfo;
import org.knowm.xchange.wex.v3.dto.marketdata.WexTicker;
import org.knowm.xchange.wex.v3.dto.marketdata.WexTrade;
import org.knowm.xchange.wex.v3.dto.meta.WexMetaData;
import org.knowm.xchange.wex.v3.dto.trade.WexOrder;
import org.knowm.xchange.wex.v3.dto.trade.WexOrderInfoResult;
import org.knowm.xchange.wex.v3.dto.trade.WexTradeHistoryResult;
import org.knowm.xchange.wex.v3.dto.trade.WexTransHistoryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

/**
 * Various adapters for converting from Wex DTOs to XChange DTOs
 */
public final class WexAdapters {

    public static final Logger log = LoggerFactory.getLogger(WexAdapters.class);

    /**
     * private Constructor
     */
    private WexAdapters() {
    }

    public static List<LimitOrder> adaptOrders(List<Double[]> bTCEOrders, CurrencyPair currencyPair, String orderTypeString, String id) {
        List<LimitOrder> limitOrders = new ArrayList<>();
        OrderType orderType = orderTypeString.equalsIgnoreCase("bid") ? OrderType.BID : OrderType.ASK;
        for (Double[] btceOrder : bTCEOrders) {
            limitOrders.add(adaptOrder(btceOrder[1], btceOrder[0], currencyPair, orderType, id));
        }
        return limitOrders;
    }

    public static LimitOrder adaptOrder(Double amount, Double price, CurrencyPair currencyPair, OrderType orderType, String id) {
        return new LimitOrder(orderType, amount, currencyPair, id, null, price);
    }

    /**
     * Adapts a BTCETradeV3 to a Trade Object
     *
     * @param bTCETrade    Wex trade object v.3
     * @param currencyPair the currency pair
     * @return The XChange Trade
     */
    public static Trade adaptTrade(WexTrade bTCETrade, CurrencyPair currencyPair) {

        OrderType orderType =
                bTCETrade.getTradeType().equalsIgnoreCase("bid") ? OrderType.BID : OrderType.ASK;
        Double amount = bTCETrade.getAmount();
        Double price = bTCETrade.getPrice();
        Long date = bTCETrade.getDate() * 1000L;

        final String tradeId = String.valueOf(bTCETrade.getTid());
        return new Trade(orderType, amount, currencyPair, price, date, tradeId);
    }

    /**
     * Adapts a BTCETradeV3[] to a Trades Object
     *
     * @param bTCETrades   The Wex trade data returned by API v.3
     * @param currencyPair the currency pair
     * @return The trades
     */
    public static Trades adaptTrades(WexTrade[] bTCETrades, CurrencyPair currencyPair) {

        List<Trade> tradesList = new ArrayList<>();
        long lastTradeId = 0;
        for (WexTrade bTCETrade : bTCETrades) {
            // Date is reversed order. Insert at index 0 instead of appending
            long tradeId = bTCETrade.getTid();
            if (tradeId > lastTradeId) {
                lastTradeId = tradeId;
            }
            tradesList.add(0, adaptTrade(bTCETrade, currencyPair));
        }
        return new Trades(tradesList, lastTradeId, TradeSortType.SortByID);
    }


    public static Ticker adaptTicker(WexTicker bTCETicker, CurrencyPair currencyPair) {

        Double last = bTCETicker.getLast();
        Double bid = bTCETicker.getSell();
        Double ask = bTCETicker.getBuy();
        Double high = bTCETicker.getHigh();
        Double low = bTCETicker.getLow();
        Double avg = bTCETicker.getAvg();
        Double volume = bTCETicker.getVolCur();
        Long timestamp = bTCETicker.getUpdated() * 1000L;

        return new Ticker.Builder()
                .currencyPair(currencyPair)
                .last(last)
                .bid(bid)
                .ask(ask)
                .high(high)
                .low(low)
                .vwap(avg)
                .volume(volume)
                .timestamp(timestamp)
                .build();
    }

    public static Wallet adaptWallet(WexAccountInfo wexAccountInfo) {

        List<Balance> balances = new ArrayList<>();
        Map<String, Double> funds = wexAccountInfo.getFunds();

        for (String lcCurrency : funds.keySet()) {
            /* BTC-E signals DASH as DSH. This is a different coin. Translate in correct DASH name */
            Double fund = funds.get(lcCurrency);

            Currency currency = adaptCurrencyIn(lcCurrency);
            balances.add(new Balance(currency, fund));
        }
        return Wallet.Builder.from(balances).build();
    }

    public static OpenOrders adaptOrders(Map<Long, WexOrder> btceOrderMap) {

        List<LimitOrder> limitOrders = new ArrayList<>();
        for (Long id : btceOrderMap.keySet()) {
            WexOrder bTCEOrder = btceOrderMap.get(id);
            OrderType orderType =
                    bTCEOrder.getType() == WexOrder.Type.buy ? OrderType.BID : OrderType.ASK;
            Double price = bTCEOrder.getRate();
            Long timestamp = bTCEOrder.getTimestampCreated() * 1000L;
            CurrencyPair currencyPair = adaptCurrencyPair(bTCEOrder.getPair());

            limitOrders.add(
                    new LimitOrder(
                            orderType, bTCEOrder.getAmount(), currencyPair, Long.toString(id), timestamp, price));
        }
        return new OpenOrders(limitOrders);
    }

    public static UserTrades adaptTradeHistory(Map<Long, WexTradeHistoryResult> tradeHistory) {

        List<UserTrade> trades = new ArrayList<>(tradeHistory.size());
        for (Entry<Long, WexTradeHistoryResult> entry : tradeHistory.entrySet()) {
            WexTradeHistoryResult result = entry.getValue();
            OrderType type =
                    result.getType() == WexTradeHistoryResult.Type.buy ? OrderType.BID : OrderType.ASK;
            Double price = result.getRate();
            Double originalAmount = result.getAmount();
            Long timeStamp = result.getTimestamp() * 1000L;
            String orderId = String.valueOf(result.getOrderId());
            String tradeId = String.valueOf(entry.getKey());
            CurrencyPair currencyPair = adaptCurrencyPair(result.getPair());
            trades.add(
                    new UserTrade(
                            type,
                            originalAmount,
                            currencyPair,
                            price,
                            timeStamp,
                            tradeId,
                            orderId,
                            null,
                            null));
        }
        return new UserTrades(trades, TradeSortType.SortByTimestamp);
    }


    public static LimitOrder adaptOrderInfo(String orderId, WexOrderInfoResult orderInfo) {
        OrderType orderType = orderInfo.getType() == WexOrderInfoResult.Type.buy ? OrderType.BID : OrderType.ASK;
        Double price = orderInfo.getRate();
        Long timestamp = orderInfo.getTimestampCreated() * 1000L;
        CurrencyPair currencyPair = adaptCurrencyPair(orderInfo.getPair());
        OrderStatus orderStatus = null;
        switch (orderInfo.getStatus()) {
            case 0:
                if (orderInfo.getAmount().compareTo(orderInfo.getStartAmount()) == 0) {
                    orderStatus = OrderStatus.NEW;
                } else {
                    orderStatus = OrderStatus.PARTIALLY_FILLED;
                }
                break;
            case 1:
                orderStatus = OrderStatus.FILLED;
                break;
            case 2:
            case 3:
                orderStatus = OrderStatus.CANCELED;
                break;
        }

        return new LimitOrder(
                orderType,
                orderInfo.getStartAmount(),
                currencyPair,
                orderId,
                timestamp,
                price,
                price,
                orderInfo.getStartAmount() - (orderInfo.getAmount()),
                null,
                orderStatus);
    }

    public static CurrencyPair adaptCurrencyPair(String btceCurrencyPair) {

        String[] currencies = btceCurrencyPair.split("_");
        return new CurrencyPair(adaptCurrencyIn(currencies[0]), adaptCurrencyIn(currencies[1]));
    }

    public static List<CurrencyPair> adaptCurrencyPairs(Iterable<String> btcePairs) {

        List<CurrencyPair> pairs = new ArrayList<>();
        for (String btcePair : btcePairs) {
            pairs.add(adaptCurrencyPair(btcePair));
        }

        return pairs;
    }

    public static ExchangeMetaData toMetaData(
            WexExchangeInfo wexExchangeInfo, WexMetaData wexMetaData) {

        // Initialize with the static meta-data
        Map<CurrencyPair, CurrencyPairMetaData> currencyPairs =
                new HashMap<>(wexMetaData.getCurrencyPairs());
        Map<Currency, CurrencyMetaData> currencies = new HashMap<>(wexMetaData.getCurrencies());

        // Override entries if relevant real-time exchange data is provided
        if (wexExchangeInfo != null) {
            for (Entry<String, WexPairInfo> e : wexExchangeInfo.getPairs().entrySet()) {
                CurrencyPair pair = adaptCurrencyPair(e.getKey());
                CurrencyPairMetaData marketMetaData = toMarketMetaData(e.getValue(), wexMetaData);
                currencyPairs.put(pair, marketMetaData);

                addCurrencyMetaData(pair.base, currencies, wexMetaData);
                addCurrencyMetaData(pair.counter, currencies, wexMetaData);
            }
        }

        RateLimit[] publicRateLimits =
                new RateLimit[]{new RateLimit(wexMetaData.publicInfoCacheSeconds, 1, TimeUnit.SECONDS)};
        return new ExchangeMetaData(currencyPairs, currencies, publicRateLimits, null, false);
    }

    private static void addCurrencyMetaData(
            Currency symbol, Map<Currency, CurrencyMetaData> currencies, WexMetaData wexMetaData) {
        if (!currencies.containsKey(symbol)) {
            Double withdrawalFee =
                    wexMetaData.getCurrencies().get(symbol) == null
                            ? null
                            : wexMetaData.getCurrencies().get(symbol).getWithdrawalFee();
            currencies.put(symbol, new CurrencyMetaData(wexMetaData.amountScale, withdrawalFee));
        }
    }

    public static CurrencyPairMetaData toMarketMetaData(WexPairInfo info, WexMetaData wexMetaData) {
        int priceScale = info.getDecimals();
        Double minimumAmount = withScale(info.getMinAmount(), wexMetaData.amountScale);
        Double feeFraction = info.getFee() / 100;

        return new CurrencyPairMetaData(feeFraction, minimumAmount, null, priceScale, null);
    }

    private static Double withScale(Double value, int priceScale) {
        /*
         * Last time I checked BTC-e returned an erroneous JSON result, where the minimum price for LTC/EUR was .0001 and the price scale was 3
         */
        try {
            return Maths.roundN(value, priceScale);
        } catch (ArithmeticException e) {
            log.debug("Could not round {} to {} decimal places: {}", value, priceScale, e.getMessage());
            return Maths.roundN(value, priceScale);
        }
    }

    public static String getPair(CurrencyPair currencyPair) {
        /* BTC-E signals DASH as DSH. This is a different coin. Translate in correct DASH name */
        String base = adaptCurrencyOut(currencyPair.base);
        String counter = adaptCurrencyOut(currencyPair.counter);
        return (base + "_" + counter);
    }

    public static LimitOrder createLimitOrder(
            MarketOrder marketOrder, WexExchangeInfo wexExchangeInfo) {
        WexPairInfo wexPairInfo =
                wexExchangeInfo.getPairs().get(getPair(marketOrder.getCurrencyPair()));
        Double limitPrice =
                marketOrder.getType() == OrderType.BID
                        ? wexPairInfo.getMaxPrice()
                        : wexPairInfo.getMinPrice();
        return LimitOrder.Builder.from(marketOrder).limitPrice(limitPrice).build();
    }

    public static List<FundingRecord> adaptFundingRecords(Map<Long, WexTransHistoryResult> map) {
        List<FundingRecord> fundingRecords = new ArrayList<>();

        for (Long key : map.keySet()) {
            WexTransHistoryResult result = map.get(key);

            FundingRecord.Status status = FundingRecord.Status.COMPLETE;

            if (result
                    .getStatus()
                    .equals(
                            WexTransHistoryResult.Status
                                    .entered)) // looks like the enum has the wrong name maybe?
                status = FundingRecord.Status.FAILED;
            else if (result.getStatus().equals(WexTransHistoryResult.Status.waiting))
                status = FundingRecord.Status.PROCESSING;

            FundingRecord.Type type; // todo
            if (result.getType().equals(WexTransHistoryResult.Type.BTC_deposit))
                type = FundingRecord.Type.DEPOSIT;
            else if (result.getType().equals(WexTransHistoryResult.Type.BTC_withdrawal))
                type = FundingRecord.Type.WITHDRAWAL;
            else continue;

            Date date = DateUtils.fromUnixTime(result.getTimestamp());
            fundingRecords.add(
                    new FundingRecord(
                            null,
                            date.getTime(),
                            adaptCurrencyIn(result.getCurrency()),
                            result.getAmount(),
                            String.valueOf(key),
                            null,
                            type,
                            status,
                            null,
                            null,
                            result.getDescription()));
        }
        return fundingRecords;
    }

    public static String adaptCurrencyOut(Currency currency) {
        String result = currency.getCurrencyCode();
        if (result.equals("DASH")) {
            result = "DSH";
        }
        return result.toLowerCase();
    }

    public static Currency adaptCurrencyIn(String currency) {

        /* BTC-E signals DASH as DSH. This is a different coin. Translate in correct DASH name */
        if (currency.toLowerCase().equals("dsh")) {
            currency = "dash";
        }
        return Currency.getInstance(currency);
    }
}
