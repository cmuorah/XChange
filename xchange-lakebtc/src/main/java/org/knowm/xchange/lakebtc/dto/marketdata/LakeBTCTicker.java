package org.knowm.xchange.lakebtc.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author kpysniak */
public final class LakeBTCTicker {

  private final Double last;
  private final Double bid;
  private final Double ask;
  private final Double high;
  private final Double low;
  private final Double volume;

  public LakeBTCTicker(
      @JsonProperty("last") Double last,
      @JsonProperty("bid") Double bid,
      @JsonProperty("ask") Double ask,
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("volume") Double volume) {

    this.last = last;
    this.bid = bid;
    this.ask = ask;
    this.high = high;
    this.low = low;
    this.volume = volume;
  }

  public Double getLast() {

    return last;
  }

  public Double getBid() {

    return bid;
  }

  public Double getAsk() {

    return ask;
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

  @Override
  public String toString() {

    return "LakeBTCTicker [last="
        + last
        + ", bid="
        + bid
        + ", ask="
        + ask
        + ", high="
        + high
        + ", low="
        + low
        + ", volume="
        + volume
        + "]";
  }
}
