package org.knowm.xchange.hitbtc.v2.dto;

import java.util.Date;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.trade.MarketOrder;

public class HitbtcMarketOrder extends MarketOrder {
  public final String clientOrderId;

  public HitbtcMarketOrder(
      OrderType type,
      Double originalAmount,
      CurrencyPair currencyPair,
      String id,
      Date timestamp,
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
        averagePrice,
        cumulativeAmount,
        fee,
        status);
    this.clientOrderId = clientOrderId;
  }

  public HitbtcMarketOrder(
      OrderType type,
      Double originalAmount,
      CurrencyPair currencyPair,
      String id,
      Date timestamp,
      String clientOrderId) {
    super(type, originalAmount, currencyPair, id, timestamp.getTime());
    this.clientOrderId = clientOrderId;
  }

  public HitbtcMarketOrder(
      OrderType type,
      Double originalAmount,
      CurrencyPair currencyPair,
      Date timestamp,
      String clientOrderId) {
    super(type, originalAmount, currencyPair, timestamp.getTime());
    this.clientOrderId = clientOrderId;
  }

  public HitbtcMarketOrder(
      OrderType type, Double originalAmount, CurrencyPair currencyPair, String clientOrderId) {
    super(type, originalAmount, currencyPair);
    this.clientOrderId = clientOrderId;
  }

  public String getClientOrderId() {
    return clientOrderId;
  }
}
