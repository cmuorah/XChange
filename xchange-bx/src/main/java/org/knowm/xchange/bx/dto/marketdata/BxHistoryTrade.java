package org.knowm.xchange.bx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BxHistoryTrade {

  private final Double avg;
  private final Double high;
  private final Double low;
  private final Double volume;
  private final Double open;
  private final Double close;

  public BxHistoryTrade(
      @JsonProperty("avg") Double avg,
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("volume") Double volume,
      @JsonProperty("open") Double open,
      @JsonProperty("close") Double close) {
    this.avg = avg;
    this.high = high;
    this.low = low;
    this.volume = volume;
    this.open = open;
    this.close = close;
  }

  public Double getAvg() {
    return avg;
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

  public Double getOpen() {
    return open;
  }

  @Override
  public String toString() {
    return "BxHistoryTrade{"
        + "avg="
        + avg
        + ", high="
        + high
        + ", low="
        + low
        + ", volume="
        + volume
        + ", open="
        + open
        + ", close="
        + close
        + '}';
  }
}
