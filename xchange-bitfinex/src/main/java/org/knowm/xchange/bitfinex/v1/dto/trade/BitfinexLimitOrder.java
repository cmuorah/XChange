package org.knowm.xchange.bitfinex.v1.dto.trade;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.trade.LimitOrder;

/**
 * Bitfinex new order entry returns details of order status. If a LimitOrder object of this type is
 * supplied to the trade service orderEntry method it will be populated with this information.
 */
public class BitfinexLimitOrder extends LimitOrder {
  private Double myOcoStopLimit;

  private BitfinexOrderStatusResponse response = null;

  public BitfinexLimitOrder(
      OrderType type,
      Double originalAmount,
      CurrencyPair currencyPair,
      String id,
      Long timestamp,
      Double limitPrice) {
    this(type, originalAmount, currencyPair, id, timestamp, limitPrice, null);
  }

  public BitfinexLimitOrder(
      OrderType type,
      Double originalAmount,
      CurrencyPair currencyPair,
      String id,
      Long timestamp,
      Double limitPrice,
      Double ocoStopLimit) {
    super(type, originalAmount, currencyPair, id, timestamp, limitPrice);
    myOcoStopLimit = ocoStopLimit;
  }

  public BitfinexOrderStatusResponse getResponse() {
    return response;
  }

  public void setResponse(BitfinexOrderStatusResponse value) {
    response = value;
  }

  public Double getOcoStopLimit() {
    return myOcoStopLimit;
  }

  public void setOcoStopLimit(Double ocoStopLimit) {
    myOcoStopLimit = ocoStopLimit;
  }

  public static class Builder extends LimitOrder.Builder {

    public Builder(OrderType orderType, CurrencyPair currencyPair) {
      super(orderType, currencyPair);
    }

    public BitfinexLimitOrder build() {
      final BitfinexLimitOrder order =
          new BitfinexLimitOrder(
              orderType, originalAmount, currencyPair, id, timestamp, limitPrice);
      order.setOrderFlags(flags);
      return order;
    }
  }
}
