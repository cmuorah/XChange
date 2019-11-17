package org.knowm.xchange.coinbasepro.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinbaseProProductStats {
  private final Double open;
  private final Double high;
  private final Double low;
  private final Double volume;

  public CoinbaseProProductStats(
      @JsonProperty("open") Double open,
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("volume") Double volume) {
    this.open = open;
    this.high = high;
    this.low = low;
    this.volume = volume;
  }

  public Double getOpen() {
    return open;
  }

  public Double getHigh() {
    return high;
  }

  public Double getLow() {
    return low;
  }

  public Double getVolume() {
    return volume;
  }
}
