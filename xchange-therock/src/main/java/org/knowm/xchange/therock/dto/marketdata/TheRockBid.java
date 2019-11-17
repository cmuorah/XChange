package org.knowm.xchange.therock.dto.marketdata;

public class TheRockBid {
  private Double price, amount;

  public Double getPrice() {
    return price;
  }

  public Double getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return String.format("TheRockBid{price=%s, amount=%s}", price, amount);
  }
}
