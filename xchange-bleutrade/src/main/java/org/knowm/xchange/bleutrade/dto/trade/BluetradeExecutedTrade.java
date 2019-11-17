package org.knowm.xchange.bleutrade.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BluetradeExecutedTrade {
  public final String orderId;
  public final String exchange;
  public final String type;
  public final Double quantity;
  public final String quantityRemaining;
  public final Double price;
  public final String status;
  public final String created;
  public final Double quantityBaseTraded;
  public final String comments;

  public BluetradeExecutedTrade(
      @JsonProperty("OrderId") String orderId,
      @JsonProperty("Exchange") String exchange,
      @JsonProperty("Type") String type,
      @JsonProperty("Quantity") Double quantity,
      @JsonProperty("QuantityRemaining") String quantityRemaining,
      @JsonProperty("Price") Double price,
      @JsonProperty("Status") String status,
      @JsonProperty("Created") String created,
      @JsonProperty("QuantityBaseTraded") Double quantityBaseTraded,
      @JsonProperty("Comments") String comments) {
    this.orderId = orderId;
    this.exchange = exchange;
    this.type = type;
    this.quantity = quantity;
    this.quantityRemaining = quantityRemaining;
    this.price = price;
    this.status = status;
    this.created = created;
    this.quantityBaseTraded = quantityBaseTraded;
    this.comments = comments;
  }
}
