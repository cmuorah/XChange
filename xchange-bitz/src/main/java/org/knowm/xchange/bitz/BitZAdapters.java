package org.knowm.xchange.bitz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.knowm.xchange.bitz.dto.marketdata.BitZOrders;
import org.knowm.xchange.bitz.dto.marketdata.BitZPublicOrder;
import org.knowm.xchange.bitz.dto.marketdata.BitZPublicTrade;
import org.knowm.xchange.bitz.dto.marketdata.BitZTicker;
import org.knowm.xchange.bitz.dto.marketdata.BitZTrades;
import org.knowm.xchange.bitz.dto.marketdata.result.BitZTickerAllResult;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.utils.DateUtils;

public class BitZAdapters {

  public static Ticker adaptTicker(BitZTicker bitzTicker, CurrencyPair currencyPair) {

    Double last = bitzTicker.getLast();
    Double bid = bitzTicker.getSell();
    Double ask = bitzTicker.getBuy();
    Double high = bitzTicker.getHigh();
    Double low = bitzTicker.getLow();
    Double volume = bitzTicker.getVolume();
    Date timestamp = DateUtils.fromMillisUtc(bitzTicker.getTimestamp());

    return new Ticker.Builder()
        .currencyPair(currencyPair)
        .last(last)
        .bid(bid)
        .ask(ask)
        .high(high)
        .low(low)
        .volume(volume)
        .timestamp(timestamp.getTime())
        .build();
  }

  public static Trade adaptTrade(BitZPublicTrade trade, CurrencyPair pair) {
    return new Trade.Builder()
        .currencyPair(pair)
        .id(String.valueOf(trade.hashCode()))
        .price(trade.getPrice())
        .originalAmount(trade.getVolume())
        .build();
  }

  public static Trades adaptTrades(BitZTrades bitZTrades, CurrencyPair pair) {
    return new Trades(
        Stream.of(bitZTrades.getTrades())
            .map(bt -> adaptTrade(bt, pair))
            .collect(Collectors.toList()));
  }

  public static OrderBook adaptOrders(BitZOrders bitZOrders, CurrencyPair currencyPair) {

    Date timestamp = DateUtils.fromMillisUtc(bitZOrders.getTimestamp());
    List<LimitOrder> asks = new ArrayList<>();
    List<LimitOrder> bids = new ArrayList<>();

    for (BitZPublicOrder order : bitZOrders.getAsks()) {
      asks.add(
          new LimitOrder.Builder(OrderType.ASK, currencyPair)
              .averagePrice(order.getPrice())
              .originalAmount(order.getVolume())
              .build());
    }

    for (BitZPublicOrder order : bitZOrders.getBids()) {
      bids.add(
          new LimitOrder.Builder(OrderType.BID, currencyPair)
              .averagePrice(order.getPrice())
              .originalAmount(order.getVolume())
              .build());
    }

    return new OrderBook(timestamp.getTime(), asks, bids);
  }

  public static List<Ticker> adaptTickers(BitZTickerAllResult bitZTickerAllResult) {

    List<Ticker> tickers = new ArrayList<>();

    for (Entry<String, BitZTicker> ticker :
        bitZTickerAllResult.getData().getAllTickers().entrySet()) {
      CurrencyPair pair = BitZUtils.toCurrencyPair(ticker.getKey());

      if (pair != null) {
        tickers.add(adaptTicker(ticker.getValue(), pair));
      }
    }

    return tickers;
  }
}
