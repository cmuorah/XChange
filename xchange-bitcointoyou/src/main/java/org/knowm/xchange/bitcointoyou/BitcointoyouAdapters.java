package org.knowm.xchange.bitcointoyou;

import static org.knowm.xchange.utils.DateUtils.fromUnixTime;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.knowm.xchange.bitcointoyou.dto.account.BitcointoyouBalance;
import org.knowm.xchange.bitcointoyou.dto.marketdata.BitcointoyouLevel;
import org.knowm.xchange.bitcointoyou.dto.marketdata.BitcointoyouMarketData;
import org.knowm.xchange.bitcointoyou.dto.marketdata.BitcointoyouOrderBook;
import org.knowm.xchange.bitcointoyou.dto.marketdata.BitcointoyouPublicTrade;
import org.knowm.xchange.bitcointoyou.dto.marketdata.BitcointoyouTicker;
import org.knowm.xchange.bitcointoyou.dto.trade.BitcointoyouOrderInfo;
import org.knowm.xchange.bitcointoyou.dto.trade.BitcointoyouOrderResponse;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.marketdata.Trades.TradeSortType;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.OpenOrders;
import org.knowm.xchange.utils.DateUtils;

/**
 * Bitcointoyou adapter class.
 *
 * @author Jonathas Carrijo
 * @author Danilo Guimaraes
 */
public final class BitcointoyouAdapters {

  private BitcointoyouAdapters() {
    // Static use only
  }

  public static Ticker adaptBitcointoyouTicker(
      BitcointoyouTicker bitcointoyouTicker, CurrencyPair currencyPair) {

    return adaptBitcointoyouTicker(bitcointoyouTicker.getBitcointoyouMarketData(), currencyPair);
  }

  static Ticker adaptBitcointoyouTicker(
      BitcointoyouMarketData bitcointoyouMarketData, CurrencyPair currencyPair) {

    Double last = bitcointoyouMarketData.getLast();
    Double bid = bitcointoyouMarketData.getBuy();
    Double ask = bitcointoyouMarketData.getSell();
    Double high = bitcointoyouMarketData.getHigh();
    Double low = bitcointoyouMarketData.getLow();
    Double volume = bitcointoyouMarketData.getVolume();

    return new Ticker.Builder()
        .currencyPair(currencyPair)
        .last(last)
        .bid(bid)
        .ask(ask)
        .high(high)
        .low(low)
        .volume(volume)
        .timestamp(fromUnixTime(bitcointoyouMarketData.getDate()).getTime())
        .build();
  }

  public static OrderBook adaptBitcointoyouOrderBook(
      BitcointoyouOrderBook depth, CurrencyPair currencyPair) {

    List<LimitOrder> asks =
        adaptBitcointoyouPublicOrders(depth.getAsks(), OrderType.ASK, currencyPair);
    List<LimitOrder> bids =
        adaptBitcointoyouPublicOrders(depth.getBids(), OrderType.BID, currencyPair);

    return new OrderBook(System.currentTimeMillis(), asks, bids);
  }

  static List<LimitOrder> adaptBitcointoyouPublicOrders(
      List<List<Double>> list, OrderType orderType, CurrencyPair currencyPair) {

    List<BitcointoyouLevel> levels = new ArrayList<>();

    for (List<Double> rawLevel : list) {
      levels.add(adaptRawBitcointoyouLevel(rawLevel));
    }

    List<LimitOrder> orders = new ArrayList<>();

    for (BitcointoyouLevel level : levels) {
      LimitOrder limitOrder =
          new LimitOrder.Builder(orderType, currencyPair)
              .originalAmount(level.getAmount())
              .limitPrice(level.getLimit())
              .build();
      orders.add(limitOrder);
    }
    return orders;
  }

  static BitcointoyouLevel adaptRawBitcointoyouLevel(List<Double> rawLevel) {

    return new BitcointoyouLevel(rawLevel.get(0), rawLevel.get(1));
  }

  public static Trades adaptBitcointoyouPublicTrades(
      BitcointoyouPublicTrade[] bitcointoyouPublicTrades, CurrencyPair currencyPair) {

    List<Trade> trades = new ArrayList<>();

    for (BitcointoyouPublicTrade bitcointoyouTrade : bitcointoyouPublicTrades) {
      trades.add(adaptBitcointoyouPublicTrade(bitcointoyouTrade, currencyPair));
    }

    return new Trades(trades, TradeSortType.SortByTimestamp);
  }

  private static Trade adaptBitcointoyouPublicTrade(
      BitcointoyouPublicTrade bitcointoyouTrade, CurrencyPair currencyPair) {

    OrderType type =
        bitcointoyouTrade.getType().equalsIgnoreCase("buy") ? OrderType.BID : OrderType.ASK;
    Date timestamp = fromRfc3339DateStringQuietly(bitcointoyouTrade.getDate().toString());

    return new Trade(
        type,
        bitcointoyouTrade.getAmount(),
        currencyPair,
        bitcointoyouTrade.getPrice(),
        timestamp.getTime(),
        bitcointoyouTrade.getTid().toString());
  }

  public static List<Balance> adaptBitcointoyouBalances(BitcointoyouBalance bitcointoyouBalances) {

    List<Balance> balances = new ArrayList<>();

    if (bitcointoyouBalances != null
        && bitcointoyouBalances.getoReturn() != null
        && bitcointoyouBalances.getoReturn().size() > 0) {
      Map<String, Double> balancesMap = bitcointoyouBalances.getoReturn().get(0);
      for (Map.Entry<String, Double> balance : balancesMap.entrySet()) {

        Currency currency = Currency.getInstance(balance.getKey());
        balances.add(new Balance(currency, balance.getValue()));
      }
    }

    return balances;
  }

  public static OpenOrders adaptBitcointoyouOpenOrders(
      BitcointoyouOrderResponse bitcointoyouOpenOrders) {

    List<LimitOrder> openOrders = new ArrayList<>();

    if (bitcointoyouOpenOrders != null && bitcointoyouOpenOrders.getOrderList() != null) {
      Collection<BitcointoyouOrderInfo> ordersInfo = bitcointoyouOpenOrders.getOrderList();

      if (ordersInfo != null && !ordersInfo.isEmpty()) {
        for (BitcointoyouOrderInfo orderInfo : ordersInfo) {
          if (orderInfo.getAsset() != null && orderInfo.getCurrency() != null) {
            CurrencyPair currencyPair =
                new CurrencyPair(orderInfo.getAsset(), orderInfo.getCurrency());

            openOrders.add(adaptBitcointoyouOpenOrder(bitcointoyouOpenOrders, currencyPair));
          }
        }
      }
    }

    return new OpenOrders(openOrders);
  }

  private static LimitOrder adaptBitcointoyouOpenOrder(
      BitcointoyouOrderResponse openOrder, CurrencyPair currencyPair) {

    if (openOrder != null
        && openOrder.getOrderList() != null
        && openOrder.getOrderList().isEmpty()) {
      BitcointoyouOrderInfo orderInfo = openOrder.getOrderList().get(0);
      Date orderDate = fromRfc3339DateStringQuietly(orderInfo.getDateCreated());
      return adaptBitcointoyouSingleOpenOrder(orderInfo, currencyPair, orderDate);
    } else {
      return null;
    }
  }

  private static LimitOrder adaptBitcointoyouSingleOpenOrder(
      BitcointoyouOrderInfo orderInfo, CurrencyPair currencyPair, Date orderDate) {
    OrderType type = orderInfo.getAction().equals("buy") ? OrderType.BID : OrderType.ASK;
    return new LimitOrder.Builder(type, currencyPair)
        .limitPrice(orderInfo.getPrice())
        .originalAmount(orderInfo.getAmount())
        .id(orderInfo.getId())
        .timestamp(orderDate.getTime())
        .build();
  }

  public static Collection<Order> adaptBitcointoyouOrderToOrdersCollection(
      BitcointoyouOrderResponse bitcointoyouOrderResponse) {
    Collection<Order> orders = new ArrayList<>();
    if (bitcointoyouOrderResponse != null
        && bitcointoyouOrderResponse.getOrderList() != null
        && !bitcointoyouOrderResponse.getOrderList().isEmpty()) {
      for (BitcointoyouOrderInfo orderInfo : bitcointoyouOrderResponse.getOrderList()) {
        Date orderDate = fromRfc3339DateStringQuietly(orderInfo.getDateCreated());

        Order order = adaptBitcointoyouSingleOpenOrder(orderInfo, null, orderDate);
        if (order != null) {
          orders.add(order);
        }
      }
    }

    return orders;
  }

  private static Date fromRfc3339DateStringQuietly(String orderDate) {

    try {
      return DateUtils.fromRfc3339DateString(orderDate);
    } catch (InvalidFormatException e) {
      return null;
    }
  }
}
