package org.knowm.xchange.coingi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoingiTicker {
  private Double open;
  private Double close;
  private Double high;
  private Double low;
  private Double vwap;
  private Double volume;
  private Long timestamp;

  public CoingiTicker(
      @JsonProperty("open") Double open,
      @JsonProperty("close") Double close,
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("vwap") Double vwap,
      @JsonProperty("volume") Double volume,
      @JsonProperty("timestamp") Long timestamp) {
    this.open = open;
    this.close = close;
    this.high = high;
    this.low = low;
    this.vwap = vwap;
    this.volume = volume;
    this.timestamp = timestamp;
  }

  public Double getOpen() {
    return open;
  }

  public Double getClose() {
    return close;
  }

  public Double getHigh() {
    return high;
  }

  public Double getLow() {
    return low;
  }

  public Double getVwap() {
    return vwap;
  }

  public Double getVolume() {
    return volume;
  }

  public Long getTimestamp() {
    return timestamp;
  }
}
