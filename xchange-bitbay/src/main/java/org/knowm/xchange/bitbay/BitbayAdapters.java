package org.knowm.xchange.bitbay;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.knowm.xchange.bitbay.dto.acount.BitbayAccountInfoResponse;
import org.knowm.xchange.bitbay.dto.acount.BitbayBalance;
import org.knowm.xchange.bitbay.dto.marketdata.BitbayOrderBook;
import org.knowm.xchange.bitbay.dto.marketdata.BitbayTicker;
import org.knowm.xchange.bitbay.dto.marketdata.BitbayTrade;
import org.knowm.xchange.bitbay.dto.trade.BitbayOrder;
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
import org.knowm.xchange.dto.trade.OpenOrders;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.dto.trade.UserTrades;

/** @author kpysniak */
public class BitbayAdapters {

  /** Singleton */
  private BitbayAdapters() {}

  /**
   * Adapts a BitbayTicker to a Ticker Object
   *
   * @param bitbayTicker The exchange specific ticker
   * @param currencyPair (e.g. BTC/USD)
   * @return The ticker
   */
  public static Ticker adaptTicker(BitbayTicker bitbayTicker, CurrencyPair currencyPair) {

    Double ask = bitbayTicker.getAsk();
    Double bid = bitbayTicker.getBid();
    Double high = bitbayTicker.getMax();
    Double low = bitbayTicker.getMin();
    Double volume = bitbayTicker.getVolume();
    Double last = bitbayTicker.getLast();

    return new Ticker.Builder()
        .currencyPair(currencyPair)
        .last(last)
        .bid(bid)
        .ask(ask)
        .high(high)
        .low(low)
        .volume(volume)
        .build();
  }

  private static List<LimitOrder> transformArrayToLimitOrders(
      Double[][] orders, OrderType orderType, CurrencyPair currencyPair) {

    List<LimitOrder> limitOrders = new ArrayList<>();

    if (orders != null) {
      for (Double[] order : orders) {
        limitOrders.add(
            new LimitOrder(orderType, order[1], currencyPair, null, System.currentTimeMillis(), order[0]));
      }
    }

    return limitOrders;
  }

  public static OrderBook adaptOrderBook(
      BitbayOrderBook bitbayOrderBook, CurrencyPair currencyPair) {

    return new OrderBook(
        null,
        transformArrayToLimitOrders(bitbayOrderBook.getAsks(), OrderType.ASK, currencyPair),
        transformArrayToLimitOrders(bitbayOrderBook.getBids(), OrderType.BID, currencyPair));
  }

  public static Trades adaptTrades(BitbayTrade[] bitbayTrades, CurrencyPair currencyPair) {

    List<Trade> tradeList = new ArrayList<>();

    for (BitbayTrade bitbayTrade : bitbayTrades) {

      Trade trade =
          new Trade(
              null,
              bitbayTrade.getAmount(),
              currencyPair,
              bitbayTrade.getPrice(),
              bitbayTrade.getDate() * 1000L,
              bitbayTrade.getTid());

      tradeList.add(trade);
    }

    return new Trades(tradeList, Trades.TradeSortType.SortByTimestamp);
  }

  public static AccountInfo adaptAccountInfo(
      String userName, BitbayAccountInfoResponse bitbayAccountInfo) {
    List<Balance> balances = new ArrayList<>(bitbayAccountInfo.getBitbayBalances().size());

    for (Map.Entry<String, BitbayBalance> entry :
        bitbayAccountInfo.getBitbayBalances().entrySet()) {
      Currency currency = Currency.getInstance(entry.getKey());
      BitbayBalance balance = entry.getValue();

      balances.add(
          new Balance(
              currency,
              balance.getAvailable() + (balance.getLocked()),
              balance.getAvailable(),
              balance.getLocked()));
    }

    return new AccountInfo(userName, Wallet.Builder.from(balances).build());
  }

  public static OpenOrders adaptOpenOrders(List<BitbayOrder> orders) {
    List<LimitOrder> result = new ArrayList<>();

    for (BitbayOrder order : orders) {
      if ("active".equals(order.getStatus())) {
        result.add(createOrder(order));
      }
    }

    return new OpenOrders(result);
  }

  public static UserTrades adaptTradeHistory(List<BitbayOrder> orders) {
    List<UserTrade> result = new ArrayList<>();

    for (BitbayOrder order : orders) {
      if ("inactive".equals(order.getStatus())) {
        result.add(createUserTrade(order));
      }
    }

    return new UserTrades(result, Trades.TradeSortType.SortByTimestamp);
  }

  private static LimitOrder createOrder(BitbayOrder bitbayOrder) {
    CurrencyPair currencyPair =
        new CurrencyPair(bitbayOrder.getCurrency(), bitbayOrder.getPaymentCurrency());
    OrderType type = "ask".equals(bitbayOrder.getType()) ? OrderType.ASK : OrderType.BID;

    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date;
    try {
      date = formatter.parse(bitbayOrder.getDate());
    } catch (ParseException e) {
      throw new IllegalArgumentException(e);
    }

    return new LimitOrder(
        type,
        bitbayOrder.getAmount(),
        currencyPair,
        String.valueOf(bitbayOrder.getId()),
        date.getTime(),
        bitbayOrder.getStartPrice() / (bitbayOrder.getStartAmount()));
  }

  private static UserTrade createUserTrade(BitbayOrder bitbayOrder) {
    CurrencyPair currencyPair =
        new CurrencyPair(bitbayOrder.getCurrency(), bitbayOrder.getPaymentCurrency());
    OrderType type = "ask".equals(bitbayOrder.getType()) ? OrderType.ASK : OrderType.BID;

    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date;
    try {
      date = formatter.parse(bitbayOrder.getDate());
    } catch (ParseException e) {
      throw new IllegalArgumentException(e);
    }

    return new UserTrade(
        type,
        bitbayOrder.getAmount(),
        currencyPair,
        bitbayOrder.getCurrentPrice() / (bitbayOrder.getStartAmount()),
        date.getTime(),
        String.valueOf(bitbayOrder.getId()),
        String.valueOf(bitbayOrder.getId()),
        null,
        null);
  }

  public static List<UserTrade> adaptTransactions(List<Map> response) {
    List<UserTrade> trades = new ArrayList<>();

    for (Map map : response) {
      try {
        OrderType orderType;
        String type = map.get("type").toString();

        if (type.equals("BID")) orderType = OrderType.BID;
        else if (type.equals("ASK")) orderType = OrderType.ASK;
        else continue;

        String market = map.get("market").toString();

        String[] parts = market.split("-");
        CurrencyPair pair =
            new CurrencyPair(Currency.getInstance(parts[0]), Currency.getInstance(parts[1]));
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = map.get("date").toString();
        Date timestamp = formatter.parse(date);
        Double amount = new Double(map.get("amount").toString());
        Double price = new Double(map.get("rate").toString());

        // there's no id - create a synthetic one
        String id = (type + "_" + date + "_" + market).replaceAll("\\s+", "");

        trades.add(new UserTrade(orderType, amount, pair, price, timestamp.getTime(), id, null, null, null));
      } catch (ParseException e) {
        throw new IllegalStateException("Cannot parse " + map);
      }
    }

    return trades;
  }
}
