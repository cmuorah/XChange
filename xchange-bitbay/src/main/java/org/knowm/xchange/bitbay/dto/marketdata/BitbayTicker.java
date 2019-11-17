package org.knowm.xchange.bitbay.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author kpysniak */
public final class BitbayTicker {

  private final Double max;
  private final Double min;
  private final Double last;
  private final Double bid;
  private final Double ask;
  private final Double vwap;
  private final Double average;
  private final Double volume;

  /**
   * Constructor
   *
   * @param max
   * @param min
   * @param last
   * @param bid
   * @param ask
   * @param vwap
   * @param average
   * @param volume
   */
  public BitbayTicker(
      @JsonProperty("max") Double max,
      @JsonProperty("min") Double min,
      @JsonProperty("last") Double last,
      @JsonProperty("bid") Double bid,
      @JsonProperty("ask") Double ask,
      @JsonProperty("vwap") Double vwap,
      @JsonProperty("average") Double average,
      @JsonProperty("volume") Double volume) {

    this.max = max;
    this.min = min;
    this.last = last;
    this.bid = bid;
    this.ask = ask;
    this.vwap = vwap;
    this.average = average;
    this.volume = volume;
  }

  public Double getMax() {

    return max;
  }

  public Double getMin() {

    return min;
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

  public Double getVwap() {

    return vwap;
  }

  public Double getAverage() {

    return average;
  }

  public Double getVolume() {

    return volume;
  }

  @Override
  public String toString() {

    return "BitbayTicker{"
        + "max="
        + max
        + ", min="
        + min
        + ", last="
        + last
        + ", bid="
        + bid
        + ", ask="
        + ask
        + ", vwap="
        + vwap
        + ", average="
        + average
        + ", volume="
        + volume
        + '}';
  }
}
