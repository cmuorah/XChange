package org.knowm.xchange.dragonex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

  public final Double price;
  public final Double volume;

  public Order(@JsonProperty("price") Double price, @JsonProperty("volume") Double volume) {
    this.price = price;
    this.volume = volume;
  }

  @Override
  public String toString() {
    return "Order ["
        + (price != null ? "price=" + price + ", " : "")
        + (volume != null ? "volume=" + volume : "")
        + "]";
  }
}
