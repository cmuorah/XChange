package org.knowm.xchange.lgo.dto.order;

import java.time.Instant;
import java.util.StringJoiner;

public class LgoPlaceMarketOrder extends LgoPlaceOrder {

  private final String side;
  private final String productId;
  private final Double quantity;

  public LgoPlaceMarketOrder(
      long reference, String side, String productId, Double quantity, Instant timestamp) {
    super(reference, timestamp);
    this.side = side;
    this.productId = productId;
    this.quantity = quantity;
  }

  public String toPayload() {
    return new StringJoiner(",")
        .add("M")
        .add(side)
        .add(productId)
        .add(quantity.toString())
        .add("")
        .add("")
        .add(String.valueOf(getTimestamp().toEpochMilli()))
        .toString();
  }

  public String getSide() {
    return side;
  }

  public String getProductId() {
    return productId;
  }

  public Double getQuantity() {
    return quantity;
  }
}
