package org.knowm.xchange.kuna.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.kuna.dto.*;
import org.knowm.xchange.kuna.dto.enums.KunaOrderType;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dat Bui
 */
public class KunaMarketDataService extends KunaMarketDataServiceRaw implements MarketDataService {


    public KunaMarketDataService(Exchange exchange) {
        super(exchange);
    }

    @Override
    public Ticker getTicker(CurrencyPair currencyPair, Object... args) throws IOException {
        KunaTimeTicker timeTicker = getKunaTicker(currencyPair);
        return mapKunaTicker2Ticker(timeTicker, currencyPair);
    }

    @Override
    public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) throws IOException {
        KunaAskBid kunaAskBid = getKunaOrderBook(currencyPair);
        List<LimitOrder> asks =
                Arrays.stream(kunaAskBid.getAsks())
                        .map(kunaOrder -> mapKunaOrder2LimitOrder(kunaOrder, currencyPair))
                        .collect(Collectors.toList());
        List<LimitOrder> bids =
                Arrays.stream(kunaAskBid.getBids())
                        .map(kunaOrder -> mapKunaOrder2LimitOrder(kunaOrder, currencyPair))
                        .collect(Collectors.toList());
        return new OrderBook(System.currentTimeMillis(), asks, bids);
    }

    @Override
    public Trades getTrades(CurrencyPair currencyPair, Object... args) throws IOException {
        KunaTrade[] kunaTrades = getKunaTradesHistory(currencyPair);
        return mapKunaTrades2Trades(kunaTrades, currencyPair);
    }

    protected Ticker mapKunaTicker2Ticker(KunaTimeTicker kunaTimeTicker, CurrencyPair currencyPair) {
        KunaTicker kunaTicker = kunaTimeTicker.getTicker();
        Date timestamp = new Date(kunaTimeTicker.getTimestamp());
        Ticker.Builder builder =
                new Ticker.Builder()
                        .currencyPair(currencyPair)
                        .timestamp(timestamp.getTime())
                        .ask(kunaTicker.getBuy())
                        .bid(kunaTicker.getSell())
                        .high(kunaTicker.getHigh())
                        .low(kunaTicker.getLow())
                        .last(kunaTicker.getLast())
                        .volume(kunaTicker.getVol());
        return builder.build();
    }

    protected LimitOrder mapKunaOrder2LimitOrder(KunaOrder kunaOrder, CurrencyPair currencyPair) {
        Order.OrderType orderType =
                kunaOrder.getOrderType() == KunaOrderType.LIMIT ? Order.OrderType.ASK : Order.OrderType.BID;
        LimitOrder.Builder builder = new LimitOrder.Builder(orderType, currencyPair);
        builder
                .id(String.valueOf(kunaOrder.getId()))
                .currencyPair(currencyPair)
                .timestamp(kunaOrder.getCreatedAt().getTime())
                .orderStatus(Order.OrderStatus.NEW)
                .orderType(orderType)
                .averagePrice(kunaOrder.getAveragePrice())
                .limitPrice(kunaOrder.getPrice())
                .originalAmount(kunaOrder.getVolume())
                .remainingAmount(kunaOrder.getRemainingVolume())
                .cumulativeAmount(kunaOrder.getExecutedVolume());
        return builder.build();
    }

    protected Trades mapKunaTrades2Trades(KunaTrade[] kunaTrades, CurrencyPair currencyPair) {
        List<Trade> trades =
                Arrays.stream(kunaTrades)
                        .map(kunaTrade -> mapKunaTrade2Trade(kunaTrade, currencyPair))
                        .collect(Collectors.toList());
        return new Trades(trades);
    }

    protected Trade mapKunaTrade2Trade(KunaTrade kunaTrade, CurrencyPair currencyPair) {
        Trade.Builder builder =
                new Trade.Builder()
                        .currencyPair(currencyPair)
                        .id(String.valueOf(kunaTrade.getId()))
                        .price(kunaTrade.getPrice())
                        .timestamp(kunaTrade.getCreatedAt().getTime())
                        .originalAmount(kunaTrade.getVolume());
        return builder.build();
    }
}
