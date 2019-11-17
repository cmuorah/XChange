package org.knowm.xchange.paribu.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author semihunaldi */
public final class BTC_TL {

  private final Double last;
  private final Double lowestAsk;
  private final Double highestBid;
  private final Double percentChange;
  private final Double volume;
  private final Double high24hr;
  private final Double low24hr;

  public BTC_TL(
      @JsonProperty("last") Double last,
      @JsonProperty("lowestAsk") Double lowestAsk,
      @JsonProperty("highestBid") Double highestBid,
      @JsonProperty("percentChange") Double percentChange,
      @JsonProperty("volume") Double volume,
      @JsonProperty("high24hr") Double high24hr,
      @JsonProperty("low24hr") Double low24hr) {
    this.last = last;
    this.lowestAsk = lowestAsk;
    this.highestBid = highestBid;
    this.percentChange = percentChange;
    this.volume = volume;
    this.high24hr = high24hr;
    this.low24hr = low24hr;
  }

  public Double getLast() {
    return last;
  }

  public Double getLowestAsk() {
    return lowestAsk;
  }

  public Double getHighestBid() {
    return highestBid;
  }

  public Double getPercentChange() {
    return percentChange;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getHigh24hr() {
    return high24hr;
  }

  public Double getLow24hr() {
    return low24hr;
  }

  @Override
  public String toString() {
    return "ParibuTicker {"
        + "last="
        + last
        + ", lowestAsk="
        + lowestAsk
        + ", highestBid="
        + highestBid
        + ", percentChange="
        + percentChange
        + ", volume="
        + volume
        + ", high24hr="
        + high24hr
        + ", low24hr="
        + low24hr
        + '}';
  }
}
