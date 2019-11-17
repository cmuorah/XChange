package org.knowm.xchange.coinfloor.dto.markedata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinfloorTicker {
  private final Double last;
  private final Double high;
  private final Double low;
  private final Double vwap;
  private final Double volume;
  private final Double bid;
  private final Double ask;

  public CoinfloorTicker(
      @JsonProperty("last") Double last,
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("vwap") Double vwap,
      @JsonProperty("volume") Double volume,
      @JsonProperty("bid") Double bid,
      @JsonProperty("ask") Double ask) {

    this.last = last;
    this.high = high;
    this.low = low;
    this.vwap = vwap;
    this.volume = volume;
    this.bid = bid;
    this.ask = ask;
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

  public Double getVwap() {
    return vwap;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getBid() {
    return bid;
  }

  public Double getAsk() {
    return ask;
  }

  @Override
  public String toString() {
    return "CoinfloorTicker [last="
        + last
        + ", high="
        + high
        + ", low="
        + low
        + ", vwap="
        + vwap
        + ", volume="
        + volume
        + ", bid="
        + bid
        + ", ask="
        + ask
        + "]";
  }
}
