package org.knowm.xchange.upbit;

import java.time.ZonedDateTime;
import java.util.*;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.upbit.dto.account.UpbitBalances;
import org.knowm.xchange.upbit.dto.marketdata.*;
import org.knowm.xchange.upbit.dto.trade.UpbitOrderResponse;
import org.knowm.xchange.utils.DateUtils;

public final class UpbitAdapters {

  private UpbitAdapters() {}

  public static OrderBook adaptOrderBook(UpbitOrderBooks upbitOrderBooks) {
    UpbitOrderBook upbitOrderBook = upbitOrderBooks.getUpbitOrderBooks()[0];
    String market = upbitOrderBook.getMarket();
    CurrencyPair currencyPair =
        new CurrencyPair(
            Currency.getInstance(market.split("-")[0]), Currency.getInstance(market.split("-")[1]));
    Map<OrderType, List<LimitOrder>> orderbookMap =
        adaptMarketOrderToLimitOrder(upbitOrderBook.getOrderbookUnits(), currencyPair);
    return new OrderBook(
        upbitOrderBook.getTimestamp().longValue(),
        orderbookMap.get(OrderType.ASK),
        orderbookMap.get(OrderType.BID));
  }

  private static Map<OrderType, List<LimitOrder>> adaptMarketOrderToLimitOrder(
      UpbitOrderBookData[] upbitOrders, CurrencyPair currencyPair) {

    List<LimitOrder> asks = new ArrayList<>(upbitOrders.length);
    List<LimitOrder> bids = new ArrayList<>(upbitOrders.length);
    Arrays.stream(upbitOrders)
        .forEach(
            upbitOrder -> {
              OrderType orderType = OrderType.ASK;
              Double price = upbitOrder.getAskPrice();
              Double amount = upbitOrder.getAskSize();
              LimitOrder limitOrder =
                  new LimitOrder(orderType, amount, currencyPair, null, null, price);
              asks.add(limitOrder);
              orderType = OrderType.BID;
              price = upbitOrder.getBidPrice();
              amount = upbitOrder.getBidSize();
              limitOrder = new LimitOrder(orderType, amount, currencyPair, null, null, price);
              bids.add(limitOrder);
            });
    Map<OrderType, List<LimitOrder>> map = new HashMap<>();
    map.put(OrderType.ASK, asks);
    map.put(OrderType.BID, bids);
    return map;
  }

  public static Ticker adaptTicker(UpbitTickers tickers) {
    UpbitTicker ticker = tickers.getTickers()[0];
    String market = ticker.getMarket();

    CurrencyPair currencyPair =
        new CurrencyPair(
            Currency.getInstance(market.split("-")[0]), Currency.getInstance(market.split("-")[1]));
    final Long date = ticker.getTimestamp().longValue() * 1000;
    return new Ticker.Builder()
        .currencyPair(currencyPair)
        .high(ticker.getHigh_price())
        .low(ticker.getLow_price())
        .last(ticker.getTrade_price())
        .volume(ticker.getTrade_volume())
        .open(ticker.getOpening_price())
        .timestamp(date)
        .build();
  }

  public static Trades adaptTrades(UpbitTrades trades, CurrencyPair currencyPair) {

    List<Trade> tradeList = new ArrayList<>(trades.getUpbitTrades().length);
    for (UpbitTrade trade : trades.getUpbitTrades()) {
      tradeList.add(adaptTrade(trade, currencyPair));
    }
    return new Trades(tradeList, 0, Trades.TradeSortType.SortByTimestamp);
  }

  private static Trade adaptTrade(UpbitTrade trade, CurrencyPair currencyPair) {
    OrderType orderType = OrderType.BID;
    if (OrderType.ASK.toString().equals(trade.getAskBid())) orderType = OrderType.ASK;

    return new Trade(
        orderType,
        trade.getTradeVolume(),
        currencyPair,
        trade.getTradePrice(),
        trade.getTimestamp().longValue(),
        "");
  }

  public static Wallet adaptWallet(UpbitBalances wallets) {
    List<Balance> balances = new ArrayList<>();
    Arrays.stream(wallets.getBalances())
        .forEach(
            balance ->
                balances.add(
                    new Balance(
                        Currency.getInstance(balance.getCurrency()),
                        balance.getBalance() + (balance.getLocked()),
                        balance.getBalance())));
    return Wallet.Builder.from(balances).build();
  }

  public static Order adaptOrderInfo(UpbitOrderResponse upbitOrderResponse) {
    Order.OrderStatus status = Order.OrderStatus.NEW;
    if (upbitOrderResponse.getState().equalsIgnoreCase("cancel")) {
      status = Order.OrderStatus.CANCELED;
    } else if (upbitOrderResponse.getRemainingVolume().compareTo(0d) > 0) {
      status = Order.OrderStatus.PARTIALLY_FILLED;
    } else if (upbitOrderResponse.getState().equalsIgnoreCase("done")) {
      status = Order.OrderStatus.FILLED;
    }
    OrderType type = upbitOrderResponse.getSide().equals("ask") ? OrderType.ASK : OrderType.BID;
    Double originalAmount = upbitOrderResponse.getVolume();
    String[] markets = upbitOrderResponse.getMarket().split("-");
    CurrencyPair currencyPair =
        new CurrencyPair(new Currency(markets[1]), new Currency(markets[0]));
    String orderId = upbitOrderResponse.getUuid();
    Double cumulativeAmount = upbitOrderResponse.getExecutedVolume();
    Double price = upbitOrderResponse.getAvgPrice();
    ZonedDateTime dateTime = ZonedDateTime.parse(upbitOrderResponse.getCreatedAt());
    return new LimitOrder(
        type,
        originalAmount,
        currencyPair,
        orderId,
        dateTime.toEpochSecond() * 1000L,
        price,
        price,
        cumulativeAmount,
        upbitOrderResponse.getPaidFee(),
        status);
  }
}
