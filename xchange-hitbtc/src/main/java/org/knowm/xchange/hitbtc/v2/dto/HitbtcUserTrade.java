package org.knowm.xchange.hitbtc.v2.dto;

import java.util.Date;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.trade.UserTrade;

public class HitbtcUserTrade extends UserTrade {

  public final String clientOrderId;

  public HitbtcUserTrade(
      Order.OrderType type,
      Double originalAmount,
      CurrencyPair currencyPair,
      Double price,
      Date timestamp,
      String id,
      String orderId,
      Double feeAmount,
      Currency feeCurrency,
      String clientOrderId) {
    super(
        type, originalAmount, currencyPair, price, timestamp, id, orderId, feeAmount, feeCurrency);
    this.clientOrderId = clientOrderId;
  }

  public String getClientOrderId() {
    return clientOrderId;
  }
}
