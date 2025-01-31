package org.knowm.xchange.exmo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.utils.DateUtils;

public class ExmoAdapters {
  public static UserTrade adaptTrade(Map<String, String> tradeDatum, CurrencyPair currencyPair) {
    Order.OrderType type = adaptOrderType(tradeDatum);
    Double amount = new Double(tradeDatum.get("quantity"));
    Double price = new Double(tradeDatum.get("price"));
    Long date = Long.parseLong(tradeDatum.get("date")) * 1000L;
    String tradeId = tradeDatum.get("trade_id");
    String orderId = tradeDatum.get("order_id");

    return new UserTrade(type, amount, currencyPair, price, date, tradeId, orderId, null, null);
  }

  public static Order.OrderType adaptOrderType(Map<String, String> order) {
    return order.get("type").equals("sell") ? Order.OrderType.ASK : Order.OrderType.BID;
  }

  public static Balance adaptBalance(
      Map<String, String> balances, Map<String, String> reserved, String ccy) {
    Currency currency = Currency.getInstance(ccy);
    Double available = new Double(balances.get(ccy));
    Double frozen = new Double(reserved.get(ccy));

    return new Balance(currency, available + (frozen), available, frozen);
  }

  public static List<LimitOrder> adaptOrders(
      CurrencyPair currencyPair, Map<String, Object> orderBookData, Order.OrderType type) {
    List<LimitOrder> orders = new ArrayList<>();
    for (List<String> orderData :
        (List<List<String>>) orderBookData.get(type.equals(Order.OrderType.ASK) ? "ask" : "bid")) {
      Double price = new Double(orderData.get(0));
      Double quantity = new Double(orderData.get(1));
      orders.add(new LimitOrder(type, quantity, currencyPair, null, null, price));
    }
    return orders;
  }

  public static Ticker adaptTicker(CurrencyPair currencyPair, Map<String, String> data) {
    return new Ticker.Builder()
        .currencyPair(currencyPair)
        .ask(new Double(data.get("sell_price")))
        .bid(new Double(data.get("buy_price")))
        .high(new Double(data.get("high")))
        .last(new Double(data.get("last_trade")))
        .low(new Double(data.get("low")))
        .volume(new Double(data.get("vol")))
        .timestamp(Long.parseLong(data.get("updated")))
        .build();
  }

  public static String format(CurrencyPair currencyPair) {
    return currencyPair.base.getCurrencyCode() + "_" + currencyPair.counter.getCurrencyCode();
  }
}
