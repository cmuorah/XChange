package org.knowm.xchange.cexio.dto;

import org.knowm.xchange.cexio.dto.trade.CexIOOrder;

public class CexioPlaceOrderRequest extends CexIORequest {
  public final CexIOOrder.Type type;
  public final Double price;
  public final Double amount;
  public final String order_type;

  public CexioPlaceOrderRequest(
      CexIOOrder.Type type, Double price, Double amount, String orderType) {
    this.type = type;
    this.price = price;
    this.amount = amount;
    this.order_type = orderType;
  }
}
