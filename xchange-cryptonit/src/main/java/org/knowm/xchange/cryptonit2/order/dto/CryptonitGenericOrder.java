package org.knowm.xchange.cryptonit2.order.dto;

import java.util.Date;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;

public class CryptonitGenericOrder extends Order {

  public CryptonitGenericOrder(
      OrderType type,
      Double originalAmount,
      CurrencyPair currencyPair,
      String id,
      Date timestamp,
      Double averagePrice,
      Double cumulativeAmount,
      Double fee,
      OrderStatus status) {

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
  }
}
