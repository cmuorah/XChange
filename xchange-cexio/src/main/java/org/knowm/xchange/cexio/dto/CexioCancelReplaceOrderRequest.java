package org.knowm.xchange.cexio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CexioCancelReplaceOrderRequest extends CexIORequest {

  @JsonProperty("order_id")
  public final String orderId;

  @JsonProperty("type")
  public final String type;

  @JsonProperty("amount")
  public final Double amount;

  @JsonProperty("price")
  public final Double price;

  public CexioCancelReplaceOrderRequest(String orderId, String type, Double amount, Double price) {
    this.orderId = orderId;
    this.type = type;
    this.amount = amount;
    this.price = price;
  }
}
