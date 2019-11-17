package org.knowm.xchange.coinegg.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinEggTicker {

  private final Double high;
  private final Double low;
  private final Double buy;
  private final Double sell;
  private final Double last;
  private final Double volume;

  public CoinEggTicker(
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("buy") Double buy,
      @JsonProperty("sell") Double sell,
      @JsonProperty("last") Double last,
      @JsonProperty("vol") Double volume) {

    this.high = high;
    this.low = low;
    this.buy = buy;
    this.sell = sell;
    this.last = last;
    this.volume = volume;
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

  @Override
  public String toString() {
    return "";
  }
}
