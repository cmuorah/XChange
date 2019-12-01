package org.knowm.xchange.coinsuper.dto.trade;

import java.util.Date;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;

public class CoinsuperGenericOrder extends Order {

  public CoinsuperGenericOrder(
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
