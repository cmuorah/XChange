package org.knowm.xchange.hitbtc.v2.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HitbtcCandle {

  private String timestamp;

  private Double open;

  private Double close;

  private Double min;

  private Double max;

  private Double volume;

  private Double volumeQuote;

  @JsonCreator
  public HitbtcCandle(
      @JsonProperty("timestamp") String timestamp,
      @JsonProperty("open") Double open,
      @JsonProperty("close") Double close,
      @JsonProperty("min") Double min,
      @JsonProperty("max") Double max,
      @JsonProperty("volume") Double volume,
      @JsonProperty("volumeQuote") Double volumeQuote) {
    this.timestamp = timestamp;
    this.open = open;
    this.close = close;
    this.min = min;
    this.max = max;
    this.volume = volume;
    this.volumeQuote = volumeQuote;
  }

  @Override
  public String toString() {
    return "HitbtcCandle [timestamp="
        + timestamp
        + ", open="
        + open
        + ", max="
        + max
        + ", min="
        + min
        + ", close="
        + close
        + ", volumeQuote="
        + volumeQuote
        + ", volume="
        + volume
        + "]";
  }

  public String getTimestamp() {
    return timestamp;
  }

  public Double getOpen() {
    return open;
  }

  public Double getClose() {
    return close;
  }

  public Double getMin() {
    return min;
  }

  public Double getMax() {
    return max;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getVolumeQuote() {
    return volumeQuote;
  }
}
