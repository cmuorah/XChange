package org.knowm.xchange.bitz.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitZTicker {

  private final Double last;
  private final Double high;
  private final Double low;
  private final Double volume;
  private final Double buy;
  private final Double sell;
  private final long timestamp;

  public BitZTicker(
      @JsonProperty("last") Double last,
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("vol") Double volume,
      @JsonProperty("buy") Double buy,
      @JsonProperty("sell") Double sell,
      @JsonProperty("date") long timestamp) {

    this.last = last;
    this.high = high;
    this.low = low;
    this.volume = volume;
    this.buy = buy;
    this.sell = sell;
    this.timestamp = timestamp;
  }

  public Double getLast() {
    return last;
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

  public Double getBuy() {
    return buy;
  }

  public Double getSell() {
    return sell;
  }

  public long getTimestamp() {
    return timestamp;
  }

  // TODO: Generate toString Override
  @Override
  public String toString() {
    return String.format(
        "BitZTicker[last=%s, high=%s, low=%s, buy=%s, sell=%s, volume=%s, timestamp=%d]",
        getLast().toString(),
        getHigh().toString(),
        getLow().toString(),
        getBuy().toString(),
        getSell().toString(),
        getVolume().toString(),
        getTimestamp());
  }
}
