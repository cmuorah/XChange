package org.knowm.xchange.gateio;

import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.dto.account.FundingRecord.Status;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.marketdata.Trades.TradeSortType;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.meta.ExchangeMetaData;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.OpenOrders;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.dto.trade.UserTrades;
import org.knowm.xchange.gateio.dto.GateioOrderType;
import org.knowm.xchange.gateio.dto.account.GateioDepositsWithdrawals;
import org.knowm.xchange.gateio.dto.account.GateioFunds;
import org.knowm.xchange.gateio.dto.marketdata.GateioDepth;
import org.knowm.xchange.gateio.dto.marketdata.GateioMarketInfoWrapper.GateioMarketInfo;
import org.knowm.xchange.gateio.dto.marketdata.GateioPublicOrder;
import org.knowm.xchange.gateio.dto.marketdata.GateioTicker;
import org.knowm.xchange.gateio.dto.marketdata.GateioTradeHistory;
import org.knowm.xchange.gateio.dto.trade.GateioOpenOrder;
import org.knowm.xchange.gateio.dto.trade.GateioOpenOrders;
import org.knowm.xchange.gateio.dto.trade.GateioTrade;

import java.util.*;
import java.util.Map.Entry;

/**
 * Various adapters for converting from Bter DTOs to XChange DTOs
 */
public final class GateioAdapters {

    /**
     * private Constructor
     */
    private GateioAdapters() {
    }

    public static CurrencyPair adaptCurrencyPair(String pair) {

        final String[] currencies = pair.toUpperCase().split("_");
        return new CurrencyPair(currencies[0], currencies[1]);
    }

    public static Ticker adaptTicker(CurrencyPair currencyPair, GateioTicker gateioTicker) {

        Double ask = gateioTicker.getLowestAsk();
        Double bid = gateioTicker.getHighestBid();
        Double last = gateioTicker.getLast();
        Double low = gateioTicker.getLow24hr();
        Double high = gateioTicker.getHigh24hr();
        // Looks like gate.io vocabulary is inverted...
        Double baseVolume = gateioTicker.getQuoteVolume();
        Double quoteVolume = gateioTicker.getBaseVolume();

        return new Ticker.Builder()
                .currencyPair(currencyPair)
                .ask(ask)
                .bid(bid)
                .last(last)
                .low(low)
                .high(high)
                .volume(baseVolume)
                .quoteVolume(quoteVolume)
                .build();
    }

    public static LimitOrder adaptOrder(
            GateioPublicOrder order, CurrencyPair currencyPair, OrderType orderType) {

        return new LimitOrder(orderType, order.getAmount(), currencyPair, "", null, order.getPrice());
    }

    public static List<LimitOrder> adaptOrders(
            List<GateioPublicOrder> orders, CurrencyPair currencyPair, OrderType orderType) {

        List<LimitOrder> limitOrders = new ArrayList<>();

        for (GateioPublicOrder bterOrder : orders) {
            limitOrders.add(adaptOrder(bterOrder, currencyPair, orderType));
        }

        return limitOrders;
    }

    public static OrderBook adaptOrderBook(GateioDepth depth, CurrencyPair currencyPair) {

        List<LimitOrder> asks =
                GateioAdapters.adaptOrders(depth.getAsks(), currencyPair, OrderType.ASK);
        Collections.reverse(asks);
        List<LimitOrder> bids =
                GateioAdapters.adaptOrders(depth.getBids(), currencyPair, OrderType.BID);

        return new OrderBook(null, asks, bids);
    }

    public static LimitOrder adaptOrder(
            GateioOpenOrder order, Collection<CurrencyPair> currencyPairs) {

        String[] currencyPairSplit = order.getCurrencyPair().split("_");
        CurrencyPair currencyPair = new CurrencyPair(currencyPairSplit[0], currencyPairSplit[1]);
        return new LimitOrder(
                order.getType().equals("sell") ? OrderType.ASK : OrderType.BID,
                order.getAmount(),
                currencyPair,
                order.getOrderNumber(),
                null,
                order.getRate());
    }

    public static OpenOrders adaptOpenOrders(
            GateioOpenOrders openOrders, Collection<CurrencyPair> currencyPairs) {

        List<LimitOrder> adaptedOrders = new ArrayList<>();
        for (GateioOpenOrder openOrder : openOrders.getOrders()) {
            adaptedOrders.add(adaptOrder(openOrder, currencyPairs));
        }

        return new OpenOrders(adaptedOrders);
    }

    public static OrderType adaptOrderType(GateioOrderType cryptoTradeOrderType) {

        return (cryptoTradeOrderType.equals(GateioOrderType.BUY)) ? OrderType.BID : OrderType.ASK;
    }

    public static Trade adaptTrade(
            GateioTradeHistory.GateioPublicTrade trade, CurrencyPair currencyPair) {

        OrderType orderType = adaptOrderType(trade.getType());
        long timestamp = trade.getDate() * 1000L;

        return new Trade(
                orderType,
                trade.getAmount(),
                currencyPair,
                trade.getPrice(),
                timestamp,
                trade.getTradeId());
    }

    public static Trades adaptTrades(GateioTradeHistory tradeHistory, CurrencyPair currencyPair) {

        List<Trade> tradeList = new ArrayList<>();
        long lastTradeId = 0;
        for (GateioTradeHistory.GateioPublicTrade trade : tradeHistory.getTrades()) {
            String tradeIdString = trade.getTradeId();
            if (!tradeIdString.isEmpty()) {
                long tradeId = Long.parseLong(tradeIdString);
                if (tradeId > lastTradeId) {
                    lastTradeId = tradeId;
                }
            }
            Trade adaptedTrade = adaptTrade(trade, currencyPair);
            tradeList.add(adaptedTrade);
        }

        return new Trades(tradeList, lastTradeId, TradeSortType.SortByTimestamp);
    }

    public static Wallet adaptWallet(GateioFunds bterAccountInfo) {

        List<Balance> balances = new ArrayList<>();
        for (Entry<String, Double> funds : bterAccountInfo.getAvailableFunds().entrySet()) {
            Currency currency = Currency.getInstance(funds.getKey().toUpperCase());
            Double amount = funds.getValue();
            Double locked = bterAccountInfo.getLockedFunds().get(currency.toString());

            balances.add(new Balance(currency, null, amount, locked == null ? 0d : locked));
        }
        for (Entry<String, Double> funds : bterAccountInfo.getLockedFunds().entrySet()) {
            Currency currency = Currency.getInstance(funds.getKey().toUpperCase());
            if (balances.stream().noneMatch(balance -> balance.getCurrency().equals(currency))) {
                Double amount = funds.getValue();
                balances.add(new Balance(currency, null, 0d, amount));
            }
        }

        return Wallet.Builder.from(balances).build();
    }

    public static UserTrades adaptUserTrades(List<GateioTrade> userTrades) {

        List<UserTrade> trades = new ArrayList<>();
        for (GateioTrade userTrade : userTrades) {
            trades.add(adaptUserTrade(userTrade));
        }

        return new UserTrades(trades, TradeSortType.SortByTimestamp);
    }

    public static UserTrade adaptUserTrade(GateioTrade gateioTrade) {

        OrderType orderType = adaptOrderType(gateioTrade.getType());
        long timestamp = gateioTrade.getTimeUnix() * 1000L;
        CurrencyPair currencyPair = adaptCurrencyPair(gateioTrade.getPair());

        return new UserTrade(
                orderType,
                gateioTrade.getAmount(),
                currencyPair,
                gateioTrade.getRate(),
                timestamp,
                gateioTrade.getTradeID(),
                gateioTrade.getOrderNumber(),
                null,
                (Currency) null);
    }

    public static ExchangeMetaData adaptToExchangeMetaData(Map<CurrencyPair, GateioMarketInfo> currencyPair2BTERMarketInfoMap) {
        Map<CurrencyPair, CurrencyPairMetaData> currencyPairs = new HashMap<>();
        for (Entry<CurrencyPair, GateioMarketInfo> entry : currencyPair2BTERMarketInfoMap.entrySet()) {
            CurrencyPair currencyPair = entry.getKey();
            GateioMarketInfo btermarketInfo = entry.getValue();

            CurrencyPairMetaData currencyPairMetaData =
                    new CurrencyPairMetaData(
                            btermarketInfo.getFee(),
                            btermarketInfo.getMinAmount(),
                            null,
                            btermarketInfo.getDecimalPlaces(),
                            null);
            currencyPairs.put(currencyPair, currencyPairMetaData);
        }

        return new ExchangeMetaData(currencyPairs, null, null, null, null);
    }

    public static List<FundingRecord> adaptDepositsWithdrawals(GateioDepositsWithdrawals depositsWithdrawals) {
        List<FundingRecord> result = new ArrayList<>();
        depositsWithdrawals
                .getDeposits()
                .forEach(d -> {
                    FundingRecord r = new FundingRecord(
                            d.address,
                            d.getTimestamp().getTime(),
                            Currency.getInstance(d.currency),
                            d.amount,
                            d.id,
                            d.txid,
                            FundingRecord.Type.DEPOSIT,
                            status(d.status),
                            null,
                            null,
                            null);
                    result.add(r);
                });
        depositsWithdrawals
                .getWithdraws()
                .forEach(
                        w -> {
                            FundingRecord r =
                                    new FundingRecord(
                                            w.address,
                                            w.getTimestamp().getTime(),
                                            Currency.getInstance(w.currency),
                                            w.amount,
                                            w.id,
                                            w.txid,
                                            FundingRecord.Type.WITHDRAWAL,
                                            status(w.status),
                                            null,
                                            null,
                                            null);
                            result.add(r);
                        });

        return result;
    }

    private static FundingRecord.Status status(String gateioStatus) {
        switch (gateioStatus) {
            case "DONE":
                return Status.COMPLETE;
            default:
                return Status.PROCESSING; // @TODO which statusses are possible at gate.io?
        }
    }
}
