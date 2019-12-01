package org.knowm.xchange.paymium;

import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.paymium.dto.account.PaymiumBalance;
import org.knowm.xchange.paymium.dto.marketdata.PaymiumMarketDepth;
import org.knowm.xchange.paymium.dto.marketdata.PaymiumMarketOrder;
import org.knowm.xchange.paymium.dto.marketdata.PaymiumTicker;
import org.knowm.xchange.paymium.dto.marketdata.PaymiumTrade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaymiumAdapters {

    /**
     * Singleton
     */
    private PaymiumAdapters() {
    }

    /**
     * Adapts a PaymiumTicker to a Ticker Object
     *
     * @param paymiumTicker The exchange specific ticker
     * @param currencyPair  (e.g. BTC/USD)
     * @return The ticker
     */
    public static Ticker adaptTicker(PaymiumTicker paymiumTicker, CurrencyPair currencyPair) {

        Double bid = paymiumTicker.getBid();
        Double ask = paymiumTicker.getAsk();
        Double high = paymiumTicker.getHigh();
        Double low = paymiumTicker.getLow();
        Double last = paymiumTicker.getPrice();
        Double volume = paymiumTicker.getVolume();
        Long timestamp = paymiumTicker.getAt() * 1000L;

        return new Ticker.Builder()
                .currencyPair(currencyPair)
                .bid(bid)
                .ask(ask)
                .high(high)
                .low(low)
                .last(last)
                .volume(volume)
                .timestamp(timestamp)
                .build();
    }

    /**
     * @param marketDepth
     * @param currencyPair
     * @return new order book
     */
    public static OrderBook adaptMarketDepth(
            PaymiumMarketDepth marketDepth, CurrencyPair currencyPair) {

        List<LimitOrder> asks =
                adaptMarketOrderToLimitOrder(marketDepth.getAsks(), OrderType.ASK, currencyPair);
        List<LimitOrder> bids =
                adaptMarketOrderToLimitOrder(marketDepth.getBids(), OrderType.BID, currencyPair);
        Collections.reverse(bids);

        return new OrderBook(null, asks, bids);
    }

    /**
     * @param paymiumMarketOrders
     * @param orderType
     * @param currencyPair
     */
    private static List<LimitOrder> adaptMarketOrderToLimitOrder(
            List<PaymiumMarketOrder> paymiumMarketOrders,
            OrderType orderType,
            CurrencyPair currencyPair) {

        List<LimitOrder> orders = new ArrayList<>(paymiumMarketOrders.size());

        for (PaymiumMarketOrder PaymiumMarketOrder : paymiumMarketOrders) {
            LimitOrder limitOrder =
                    new LimitOrder(
                            orderType,
                            PaymiumMarketOrder.getAmount(),
                            currencyPair,
                            null,
                            PaymiumMarketOrder.getTimestamp(),
                            PaymiumMarketOrder.getPrice());
            orders.add(limitOrder);
        }

        return orders;
    }

    public static Trades adaptTrade(PaymiumTrade[] paymiumTrades, CurrencyPair currencyPair) {

        List<Trade> trades = new ArrayList<>();

        for (PaymiumTrade paymiumTrade : paymiumTrades) {
            Trade trade =
                    new Trade(
                            null,
                            paymiumTrade.getTraded_btc(),
                            currencyPair,
                            paymiumTrade.getPrice(),
                            paymiumTrade.getCreated_at_int(),
                            paymiumTrade.getUuid().toString());

            trades.add(trade);
        }

        return new Trades(trades, Trades.TradeSortType.SortByTimestamp);
    }

    public static Wallet adaptWallet(PaymiumBalance paymiumBalances) {

        List<Balance> wallets = new ArrayList<>();

        wallets.add(
                new Balance(
                        Currency.BTC,
                        paymiumBalances.getBalanceBtc(),
                        paymiumBalances.getBalanceBtc() - (paymiumBalances.getLockedBtc()),
                        paymiumBalances.getLockedBtc()));

        wallets.add(
                new Balance(
                        Currency.EUR,
                        paymiumBalances.getBalanceEur(),
                        paymiumBalances.getBalanceEur() - (paymiumBalances.getLockedEur()),
                        paymiumBalances.getLockedEur()));

        return Wallet.Builder.from(wallets).build();
    }
}
