package org.knowm.xchange.bitcoinium;

import org.knowm.xchange.bitcoinium.dto.marketdata.BitcoiniumOrderbook;
import org.knowm.xchange.bitcoinium.dto.marketdata.BitcoiniumOrderbook.CondensedOrder;
import org.knowm.xchange.bitcoinium.dto.marketdata.BitcoiniumTicker;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.trade.LimitOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Various adapters for converting from Bitcoinium DTOs to XChange DTOs
 */
public final class BitcoiniumAdapters {

    /**
     * private Constructor
     */
    private BitcoiniumAdapters() {
    }

    /**
     * Adapts a BitcoiniumTicker to a Ticker Object
     *
     * @param bitcoiniumTicker
     * @return
     */
    public static Ticker adaptTicker(BitcoiniumTicker bitcoiniumTicker, CurrencyPair currencyPair) {

        Double last = bitcoiniumTicker.getLast();
        Double high = bitcoiniumTicker.getHigh();
        Double low = bitcoiniumTicker.getLow();
        Double ask = bitcoiniumTicker.getAsk();
        Double bid = bitcoiniumTicker.getBid();
        Double volume = bitcoiniumTicker.getVolume();

        return new Ticker.Builder()
                .currencyPair(currencyPair)
                .last(last)
                .high(high)
                .low(low)
                .volume(volume)
                .ask(ask)
                .bid(bid)
                .build();
    }

    /**
     * Adapts a BitcoiniumOrderbook to a OrderBook Object
     *
     * @param bitcoiniumOrderbook
     * @return the XChange OrderBook
     */
    public static OrderBook adaptOrderbook(
            BitcoiniumOrderbook bitcoiniumOrderbook, CurrencyPair currencyPair) {

        List<LimitOrder> asks = createOrders(currencyPair, Order.OrderType.ASK, bitcoiniumOrderbook.getAsks());
        List<LimitOrder> bids = createOrders(currencyPair, Order.OrderType.BID, bitcoiniumOrderbook.getBids());
        Long date = (bitcoiniumOrderbook.getBitcoiniumTicker().getTimestamp()); // Note, this is the timestamp of the piggy-backed Ticker.
        return new OrderBook(date, asks, bids);
    }

    public static List<LimitOrder> createOrders(
            CurrencyPair currencyPair, Order.OrderType orderType, CondensedOrder[] condensedOrders) {

        List<LimitOrder> limitOrders = new ArrayList<>();
        for (int i = 0; i < condensedOrders.length; i++) {

            LimitOrder limitOrder =
                    new LimitOrder(
                            orderType,
                            condensedOrders[i].getVolume(),
                            currencyPair,
                            "",
                            null,
                            condensedOrders[i].getPrice());
            limitOrders.add(limitOrder);
        }
        return limitOrders;
    }
}
