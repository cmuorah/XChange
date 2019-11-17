package org.knowm.xchange.yobit.dto.marketdata;

public class YoBitAsksBidsData {
  private final Double quantity;
  private final Double rate;

  /**
   * @param rate
   * @param quantity
   */
  public YoBitAsksBidsData(Double quantity, Double rate) {
    this.quantity = quantity;
    this.rate = rate;
  }

  /** @return The quantity */
  public Double getQuantity() {
    return quantity;
  }

  /** @return The rate */
  public Double getRate() {
    return rate;
  }
}
