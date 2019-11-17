package org.knowm.xchange.okcoin.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OkCoinPriceLimit {

  private final Double high;
  private final Double low;

  /**
   * Constructor
   *
   * @param high
   * @param low
   */
  public OkCoinPriceLimit(
      @JsonProperty("high") final Double high, @JsonProperty("low") final Double low) {

    this.high = high;
    this.low = low;
  }

  public Double getHigh() {

    return high;
  }

  public Double getLow() {

    return low;
  }

  @Override
  public String toString() {

    return "OkCoinPriceLimit [high=" + high + ", low=" + low + "]";
  }
}
