package org.knowm.xchange.hitbtc.v2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HitbtcOrderLimit {

  private final Double price;
  private final Double size;

  public HitbtcOrderLimit(@JsonProperty("price") Double price, @JsonProperty("size") Double size) {
    this.price = price;
    this.size = size;
  }

  public Double getPrice() {
    return price;
  }

  public Double getSize() {
    return size;
  }

  @Override
  public String toString() {
    return "HitbtcOrderLimit{" + "price=" + price + ", size=" + size + '}';
  }
}
