package org.knowm.xchange.lgo.dto.order;

import java.time.Instant;
import java.util.StringJoiner;

public class LgoPlaceLimitOrder extends LgoPlaceOrder {

  private final String side;
  private final String productId;
  private final Double quantity;
  private final Double price;

  public LgoPlaceLimitOrder(
      long reference,
      String side,
      String productId,
      Double quantity,
      Double price,
      Instant timestamp) {
    super(reference, timestamp);
    this.side = side;
    this.productId = productId;
    this.quantity = quantity;
    this.price = price;
  }

  public String toPayload() {
    return new StringJoiner(",")
        .add("L")
        .add(side)
        .add(productId)
        .add(quantity.toString())
        .add(price == null ? "" : price.toString())
        .add("gtc")
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

  public Double getPrice() {
    return price;
  }
}
