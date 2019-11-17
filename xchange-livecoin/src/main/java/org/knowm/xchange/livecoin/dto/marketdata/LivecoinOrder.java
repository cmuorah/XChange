package org.knowm.xchange.livecoin.dto.marketdata;

public class LivecoinOrder {
  private final Double rate;
  private final Double quantity;

  public LivecoinOrder(Double rate, Double quantity) {
    this.rate = rate;
    this.quantity = quantity;
  }

  public Double getRate() {
    return rate;
  }

  public Double getQuantity() {
    return quantity;
  }
}
