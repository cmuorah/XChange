package org.knowm.xchange.poloniex.dto.trade;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.trade.LimitOrder;

/**
 * Poloniex order response contains details of any trades that have just executed in the order entry
 * return value. If a LimitOrder of this type is supplied to the trade service orderEntry method it
 * will be populated with this information.
 */
public class PoloniexLimitOrder extends LimitOrder {

  private PoloniexTradeResponse response = null;

  public PoloniexLimitOrder(
      OrderType type,
      Double originalAmount,
      CurrencyPair currencyPair,
      String id,
      Long timestamp,
      Double limitPrice) {
    super(type, originalAmount, currencyPair, id, timestamp, limitPrice);
  }

  public PoloniexTradeResponse getResponse() {
    return response;
  }

  public void setResponse(PoloniexTradeResponse value) {
    response = value;
  }

  public static class Builder extends LimitOrder.Builder {

    public Builder(OrderType orderType, CurrencyPair currencyPair) {
      super(orderType, currencyPair);
    }

    public PoloniexLimitOrder build() {
      final PoloniexLimitOrder order =
          new PoloniexLimitOrder(
              orderType, originalAmount, currencyPair, id, timestamp, limitPrice);
      order.setOrderFlags(flags);
      return order;
    }
  }
}
