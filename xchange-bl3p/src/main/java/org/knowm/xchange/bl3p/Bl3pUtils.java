package org.knowm.xchange.bl3p;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;

public class Bl3pUtils {
  private static final Double SATOSHI = 1e8;
  private static final Double EUROSHI = 1e5;

  private Bl3pUtils() {}

  public static Double fromSatoshi(Double bd) {
    return bd / SATOSHI;
  }

  public static long toSatoshi(Double bd) {
    return Math.round(bd * (SATOSHI));
  }

  public static Double fromEuroshi(Double bd) {
    return bd / (EUROSHI);
  }

  public static long toEuroshi(Double bd) {
    return Math.round(bd * (EUROSHI));
  }

  public static String toPairString(CurrencyPair currencyPair) {
    return currencyPair.base.getCurrencyCode() + currencyPair.counter.getCurrencyCode();
  }

  public static Order.OrderType fromBl3pOrderType(String bl3pType) {
    return bl3pType.equals("bid") ? Order.OrderType.BID : Order.OrderType.ASK;
  }

  public static String toBl3pOrderType(Order.OrderType orderType) {
    switch (orderType) {
      case BID:
        return "bid";
      case ASK:
        return "ask";
      case EXIT_ASK:
        return "exit_ask";
      case EXIT_BID:
        return "exit_bid";
      default:
        return null;
    }
  }
}
