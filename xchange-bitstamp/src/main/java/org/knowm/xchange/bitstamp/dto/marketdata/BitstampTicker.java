package org.knowm.xchange.bitstamp.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author Matija Mazi */
public final class BitstampTicker {

  private final Double open;
  private final Double last;
  private final Double high;
  private final Double low;
  private final Double vwap;
  private final Double volume;
  private final Double bid;
  private final Double ask;
  private final long timestamp;

  /**
   * Constructor
   *
   * @param open
   * @param last
   * @param high
   * @param low
   * @param vwap
   * @param volume
   * @param bid
   * @param ask
   */
  public BitstampTicker(
      @JsonProperty("open") Double open,
      @JsonProperty("last") Double last,
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("vwap") Double vwap,
      @JsonProperty("volume") Double volume,
      @JsonProperty("bid") Double bid,
      @JsonProperty("ask") Double ask,
      @JsonProperty("timestamp") long timestamp) {

    this.open = open;
    this.last = last;
    this.high = high;
    this.low = low;
    this.vwap = vwap;
    this.volume = volume;
    this.bid = bid;
    this.ask = ask;
    this.timestamp = timestamp;
  }

  public Double getOpen() {
    return open;
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

  public long getTimestamp() {

    return timestamp;
  }

  @Override
  public String toString() {

    return "BitstampTicker [open="
        + open
        + ", last="
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
        + ", timestamp="
        + timestamp
        + "]";
  }
}
