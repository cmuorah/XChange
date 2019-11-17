package org.knowm.xchange.huobi.dto.marketdata;

public class HuobiPrice {

  private final Double price;
  private final Double volume;

  HuobiPrice(Double[] inputData) {
    this.price = inputData[0];
    this.volume = inputData[1];
  }

  public Double getPrice() {
    return price;
  }

  private Double getVolume() {
    return volume;
  }

  @Override
  public String toString() {
    return String.format("HuobiPrice [price=%s, volume=%s]", getPrice(), getVolume());
  }
}
