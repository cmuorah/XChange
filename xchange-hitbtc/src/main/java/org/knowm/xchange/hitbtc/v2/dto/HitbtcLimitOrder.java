package org.knowm.xchange.hitbtc.v2.dto;

import java.util.Date;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.trade.LimitOrder;

public class HitbtcLimitOrder extends LimitOrder {
  public final String clientOrderId;

  public HitbtcLimitOrder(
      OrderType type,
      Double originalAmount,
      CurrencyPair currencyPair,
      String id,
      Date timestamp,
      Double limitPrice,
      String clientOrderId) {
    super(type, originalAmount, currencyPair, id, timestamp.getTime(), limitPrice);
    this.clientOrderId = clientOrderId;
  }

  public HitbtcLimitOrder(
      OrderType type,
      Double originalAmount,
      Double cumulativeAmount,
      CurrencyPair currencyPair,
      String id,
      Date timestamp,
      Double limitPrice,
      String clientOrderId) {
    super(type, originalAmount, cumulativeAmount, currencyPair, id, timestamp.getTime(), limitPrice);
    this.clientOrderId = clientOrderId;
  }

  public HitbtcLimitOrder(
      OrderType type,
      Double originalAmount,
      CurrencyPair currencyPair,
      String id,
      Date timestamp,
      Double limitPrice,
      Double averagePrice,
      Double cumulativeAmount,
      Double fee,
      OrderStatus status,
      String clientOrderId) {
    super(
        type,
        originalAmount,
        currencyPair,
        id,
        timestamp.getTime(),
        limitPrice,
        averagePrice,
        cumulativeAmount,
        fee,
        status);
    this.clientOrderId = clientOrderId;
  }

  public String getClientOrderId() {
    return clientOrderId;
  }
}
