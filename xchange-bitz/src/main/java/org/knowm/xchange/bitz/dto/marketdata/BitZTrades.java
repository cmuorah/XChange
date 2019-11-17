package org.knowm.xchange.bitz.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitZTrades {

  private final Double min;
  private final Double max;
  private final Double sum;

  private final BitZPublicTrade[] trades;

  public BitZTrades(
      @JsonProperty("min") Double min,
      @JsonProperty("max") Double max,
      @JsonProperty("sum") Double sum,
      @JsonProperty("d") BitZPublicTrade[] trades) {

    this.min = min;
    this.max = max;
    this.sum = sum;
    this.trades = trades;
  }

  public Double getMin() {
    return min;
  }

  public Double getMax() {
    return max;
  }

  public Double getSum() {
    return sum;
  }

  public BitZPublicTrade[] getTrades() {
    return trades;
  }
}
