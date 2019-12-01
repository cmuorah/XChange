package org.knowm.xchange.bankera;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.knowm.xchange.bankera.dto.BankeraException;
import org.knowm.xchange.bankera.dto.account.BankeraUserInfo;
import org.knowm.xchange.bankera.dto.account.BankeraWallet;
import org.knowm.xchange.bankera.dto.marketdata.BankeraOrderBook;
import org.knowm.xchange.bankera.dto.marketdata.BankeraTickerResponse;
import org.knowm.xchange.bankera.dto.marketdata.BankeraTrade;
import org.knowm.xchange.bankera.dto.marketdata.BankeraTradesResponse;
import org.knowm.xchange.bankera.dto.trade.BankeraOpenOrders;
import org.knowm.xchange.bankera.dto.trade.BankeraOrder;
import org.knowm.xchange.bankera.dto.trade.BankeraUserTrades;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
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
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exceptions.ExchangeSecurityException;

public final class BankeraAdapters {

  private static final String ORDER_SIDE_BUY = "buy";

  private BankeraAdapters() {}

  public static AccountInfo adaptAccountInfo(BankeraUserInfo userInfo) {
    return new AccountInfo(
        String.valueOf(userInfo.getUser().getId()), adaptWallet(userInfo.getUser().getWallets()));
  }

  public static Wallet adaptWallet(List<BankeraWallet> wallets) {
    List<Balance> balances =
        wallets.stream()
            .map(
                w ->
                    new Balance.Builder()
                        .total(new Double(w.getTotal()))
                        .available(new Double(w.getBalance()))
                        .frozen(new Double(w.getReserved()))
                        .currency(new Currency(w.getCurrency()))
                        .build())
            .collect(Collectors.toList());
    return Wallet.Builder.from(balances).build();
  }

  public static ExchangeException adaptError(BankeraException exception) {
    return exception.getHttpStatusCode() == 403
        ? new ExchangeSecurityException()
        : new ExchangeException(exception.getError(), exception);
  }

  /**
   * Adapts Bankera BankeraTickerResponse to a Ticker
   *
   * @param ticker Specific ticker
   * @param currencyPair BankeraCurrency pair (e.g. ETH/BTC)
   * @return Ticker
   */
  public static Ticker adaptTicker(BankeraTickerResponse ticker, CurrencyPair currencyPair) {

    Double high = new Double(ticker.getTicker().getHigh());
    Double low = new Double(ticker.getTicker().getLow());
    Double bid = new Double(ticker.getTicker().getBid());
    Double ask = new Double(ticker.getTicker().getAsk());
    Double last = new Double(ticker.getTicker().getLast());
    Double volume = new Double(ticker.getTicker().getVolume());
    Date timestamp = new Date(ticker.getTicker().getTimestamp());

    return new Ticker.Builder()
        .currencyPair(currencyPair)
        .high(high)
        .low(low)
        .bid(bid)
        .ask(ask)
        .last(last)
        .volume(volume)
        .timestamp(timestamp.getTime())
        .build();
  }

  public static OrderBook adaptOrderBook(BankeraOrderBook orderbook, CurrencyPair currencyPair) {

    List<LimitOrder> bids = createOrders(currencyPair, OrderType.BID, orderbook.getBids());
    List<LimitOrder> asks = createOrders(currencyPair, OrderType.ASK, orderbook.getAsks());

    return new OrderBook(null, asks, bids);
  }

  public static Trades adaptTrades(
      BankeraTradesResponse tradesResponse, CurrencyPair currencyPair) {

    List<BankeraTrade> bankeraTrades = tradesResponse.getTrades();
    List<Trade> tradesList = new ArrayList<>();

    bankeraTrades.forEach(
        bankeraTrade -> {
          Double amount = new Double(bankeraTrade.getAmount());
          Double price = new Double(bankeraTrade.getPrice());
          Long date = Long.parseLong(bankeraTrade.getTime());
          OrderType type =
              bankeraTrade.getSide().equalsIgnoreCase(ORDER_SIDE_BUY)
                  ? OrderType.BID
                  : OrderType.ASK;
          tradesList.add(new Trade(type, amount, currencyPair, price, date, null));
        });
    return new Trades(tradesList, 0L, Trades.TradeSortType.SortByTimestamp);
  }

  private static List<LimitOrder> createOrders(
      CurrencyPair currencyPair,
      OrderType orderType,
      List<BankeraOrderBook.OrderBookOrder> ordersList) {

    List<LimitOrder> limitOrders = new ArrayList<>();
    if (ordersList == null) return limitOrders;

    ordersList.forEach(
        order ->
            limitOrders.add(
                new LimitOrder(
                    orderType,
                    new Double(order.getAmount()),
                    currencyPair,
                    String.valueOf(order.getId()),
                    null,
                    new Double(order.getPrice()))));

    return limitOrders;
  }

  public static List<LimitOrder> adaptOpenOrders(BankeraOpenOrders openOrders) {

    List<LimitOrder> orderList = new ArrayList<>();

    openOrders
        .getOpenOrders()
        .forEach(
            bankeraOrder -> {
              String[] currencies = bankeraOrder.getMarket().split("-");
              CurrencyPair pair = new CurrencyPair(currencies[0], currencies[1]);
              orderList.add(
                  new LimitOrder(
                      bankeraOrder.getSide().equalsIgnoreCase("buy")
                          ? OrderType.BID
                          : OrderType.ASK,
                      new Double(bankeraOrder.getAmount()),
                      new Double(bankeraOrder.getRemainingAmount()),
                      pair,
                      String.valueOf(bankeraOrder.getId()),
                      Long.parseLong(bankeraOrder.getCreatedAt()),
                      new Double(bankeraOrder.getPrice())));
            });

    return orderList;
  }

  public static List<UserTrade> adaptUserTrades(BankeraUserTrades userTrades) {
    List<UserTrade> tradeList = new ArrayList<>();

    userTrades
        .getTrades()
        .forEach(
            trade -> {
              String[] currencies = trade.getMarket().split("-");
              CurrencyPair pair = new CurrencyPair(currencies[0], currencies[1]);
              Currency feeCurrency = new Currency(currencies[1]);
              tradeList.add(
                  new UserTrade(
                      trade.getSide().equalsIgnoreCase("buy") ? OrderType.BID : OrderType.ASK,
                      new Double(trade.getAmount()),
                      pair,
                      new Double(trade.getPrice()),
                      Long.parseLong(trade.getCompletedAt()),
                      String.valueOf(trade.getId()),
                      String.valueOf(trade.getOrderId()),
                      new Double(trade.getFeeAmount()),
                      feeCurrency));
            });

    return tradeList;
  }

  public static Order adaptOrder(BankeraOrder bankeraOrder) {
    String[] currencies = bankeraOrder.getMarket().split("-");
    CurrencyPair pair = new CurrencyPair(currencies[0], currencies[1]);
    return new LimitOrder(
        bankeraOrder.getSide().equalsIgnoreCase("buy") ? OrderType.BID : OrderType.ASK,
        new Double(bankeraOrder.getAmount()),
        pair,
        String.valueOf(bankeraOrder.getId()),
        Long.parseLong(bankeraOrder.getCreatedAt()),
        Double.parseDouble(bankeraOrder.getPrice()),
        Double.parseDouble(bankeraOrder.getPrice()),
        Double.parseDouble(bankeraOrder.getExecutedAmount()),
        bankeraOrder.getTotalFee(),
        adaptOrderStatus(bankeraOrder.getStatus()));
  }

  private static Order.OrderStatus adaptOrderStatus(String status) {
    switch (status.toLowerCase()) {
      case "open":
        return Order.OrderStatus.NEW;
      case "completed":
        return Order.OrderStatus.FILLED;
      case "cancelled":
        return Order.OrderStatus.CANCELED;
      case "rejected":
        return Order.OrderStatus.REJECTED;
      case "pending cancel":
        return Order.OrderStatus.PENDING_CANCEL;
      default:
        return Order.OrderStatus.UNKNOWN;
    }
  }
}
