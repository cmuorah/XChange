package org.knowm.xchange.lakebtc;

import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.dto.trade.UserTrades;
import org.knowm.xchange.lakebtc.dto.account.LakeBTCAccount;
import org.knowm.xchange.lakebtc.dto.account.LakeBTCBalance;
import org.knowm.xchange.lakebtc.dto.account.LakeBTCProfile;
import org.knowm.xchange.lakebtc.dto.marketdata.LakeBTCOrderBook;
import org.knowm.xchange.lakebtc.dto.marketdata.LakeBTCTicker;
import org.knowm.xchange.lakebtc.dto.trade.LakeBTCTradeResponse;
import org.knowm.xchange.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kpysniak
 */
public class LakeBTCAdapters {

    /**
     * Singleton
     */
    private LakeBTCAdapters() {
    }

    public static Ticker adaptTicker(LakeBTCTicker lakeBTCTicker, CurrencyPair currencyPair) {

        Double ask = lakeBTCTicker.getAsk();
        Double bid = lakeBTCTicker.getBid();
        Double high = lakeBTCTicker.getHigh();
        Double low = lakeBTCTicker.getLow();
        Double last = lakeBTCTicker.getLast();
        Double volume = lakeBTCTicker.getVolume();

        return new Ticker.Builder()
                .currencyPair(currencyPair)
                .bid(bid)
                .ask(ask)
                .high(high)
                .low(low)
                .last(last)
                .volume(volume)
                .build();
    }

    private static List<LimitOrder> transformArrayToLimitOrders(
            Double[][] orders, OrderType orderType, CurrencyPair currencyPair) {
        List<LimitOrder> limitOrders = new ArrayList<>();
        for (Double[] order : orders) {
            limitOrders.add(new LimitOrder(orderType, order[1], currencyPair, null, null, order[0]));
        }

        return limitOrders;
    }

    public static OrderBook adaptOrderBook(
            LakeBTCOrderBook lakeBTCOrderBook, CurrencyPair currencyPair) {
        return new OrderBook(
                null,
                transformArrayToLimitOrders(lakeBTCOrderBook.getAsks(), OrderType.ASK, currencyPair),
                transformArrayToLimitOrders(lakeBTCOrderBook.getBids(), OrderType.BID, currencyPair));
    }

    /**
     * Adapts a Transaction[] to a Trades Object
     *
     * @param transactions The LakeBtc transactions
     * @param currencyPair (e.g. BTC/USD)
     * @return The XChange Trades
     */
    public static Trades adaptTrades(LakeBTCTradeResponse[] transactions, CurrencyPair currencyPair) {

        List<Trade> trades = new ArrayList<>();
        long lastTradeId = 0;
        for (LakeBTCTradeResponse trade : transactions) {
            final OrderType orderType = trade.getType().startsWith("buy") ? OrderType.BID : OrderType.ASK;
            trades.add(
                    new Trade(
                            orderType,
                            trade.getAmount(),
                            currencyPair,
                            trade.getTotal(),
                            trade.getAt() * 1000L,
                            trade.getId()));
        }

        return new Trades(trades, lastTradeId, Trades.TradeSortType.SortByTimestamp);
    }

    /**
     * Adapts a Transaction to a Trade Object
     *
     * @param tx           The LakeBtc transaction
     * @param currencyPair (e.g. BTC/USD)
     * @param timeScale    polled order books provide a timestamp in seconds, stream in ms
     * @return The XChange Trade
     */
    public static Trade adaptTrade(
            LakeBTCTradeResponse tx, CurrencyPair currencyPair, int timeScale) {

        final String tradeId = String.valueOf(tx.getId());
        Date date = DateUtils.fromMillisUtc(tx.getAt() * timeScale); // polled order
        // books provide
        // a timestamp
        // in seconds,
        // stream in ms
        return new Trade(null, tx.getAmount(), currencyPair, tx.getTotal(), date.getTime(), tradeId);
    }


    public static UserTrades adaptTradeHistory(LakeBTCTradeResponse[] transactions) {

        List<UserTrade> trades = new ArrayList<>();
        long lastTradeId = 0;
        for (LakeBTCTradeResponse trade : transactions) {
            final OrderType orderType = trade.getType().startsWith("buy") ? OrderType.BID : OrderType.ASK;
            Double originalAmount = trade.getAmount();
            Double price = Math.abs(trade.getTotal());
            Date timestamp = DateUtils.fromMillisUtc(trade.getAt() * 1000L);

            final String tradeId = trade.getId();
            final CurrencyPair currencyPair = CurrencyPair.BTC_CNY;
            UserTrade userTrade =
                    new UserTrade(
                            orderType,
                            originalAmount,
                            currencyPair,
                            price,
                            timestamp.getTime(),
                            tradeId,
                            null,
                            null,
                            Currency.getInstance(currencyPair.counter.getCurrencyCode()));
            trades.add(userTrade);
        }

        return new UserTrades(trades, lastTradeId, Trades.TradeSortType.SortByTimestamp);
    }


    public static AccountInfo adaptAccountInfo(LakeBTCAccount lakeBTCAccount) {

        // Adapt to XChange DTOs
        LakeBTCProfile profile = lakeBTCAccount.getProfile();
        LakeBTCBalance balance = lakeBTCAccount.getBalance();
        Balance usdBalance = new Balance(Currency.USD, balance.getUSD());
        Balance cnyWBalance = new Balance(Currency.CNY, balance.getCNY());
        Balance btcBalance = new Balance(Currency.BTC, balance.getBTC());

        return new AccountInfo(
                profile.getId(),
                Wallet.Builder.from(
                        Stream.of(usdBalance, btcBalance, cnyWBalance).collect(Collectors.toList()))
                        .build());
    }

    /**
     * Adapts a currency pair to the keys returned by the tickers map.
     *
     * @param currencyPair The currency pair to convert to LakeBTCs ticker keys
     * @return A string suitable for looking up ticker information.
     */
    public static String adaptCurrencyPair(CurrencyPair currencyPair) {
        return currencyPair.base.getCurrencyCode().toLowerCase()
                + currencyPair.counter.getCurrencyCode().toLowerCase();
    }
}
