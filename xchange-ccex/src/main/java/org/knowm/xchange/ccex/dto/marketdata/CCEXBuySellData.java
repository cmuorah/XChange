package org.knowm.xchange.ccex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CCEXBuySellData {

  private final Double quantity;
  private final Double rate;

  /**
   * @param rate
   * @param quantity
   */
  public CCEXBuySellData(
      @JsonProperty("Quantity") Double quantity, @JsonProperty("Rate") Double rate) {
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
