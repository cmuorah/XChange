package org.knowm.xchange.koinim.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author ahmet.oz */
public final class KoinimTicker {

  private final Double sell;
  private final Double high;
  private final Double buy;
  private final Double change_rate;
  private final Double bid;
  private final Double wavg;
  private final Double last_order;
  private final Double volume;
  private final Double low;
  private final Double ask;
  private final Double avg;

  public KoinimTicker(
      @JsonProperty("sell") Double sell,
      @JsonProperty("high") Double high,
      @JsonProperty("buy") Double buy,
      @JsonProperty("change_rate") Double change_rate,
      @JsonProperty("bid") Double bid,
      @JsonProperty("wavg") Double wavg,
      @JsonProperty("last_order") Double last_order,
      @JsonProperty("volume") Double volume,
      @JsonProperty("low") Double low,
      @JsonProperty("ask") Double ask,
      @JsonProperty("avg") Double avg) {
    this.sell = sell;
    this.high = high;
    this.buy = buy;
    this.change_rate = change_rate;
    this.bid = bid;
    this.wavg = wavg;
    this.last_order = last_order;
    this.volume = volume;
    this.low = low;
    this.ask = ask;
    this.avg = avg;
  }

  public Double getAvg() {
    return avg;
  }

  public Double getAsk() {
    return ask;
  }

  public Double getLow() {
    return low;
  }

  public Double getSell() {
    return sell;
  }

  public Double getHigh() {
    return high;
  }

  public Double getBuy() {
    return buy;
  }

  public Double getChangeRate() {
    return change_rate;
  }

  public Double getBid() {
    return bid;
  }

  public Double getWavg() {
    return wavg;
  }

  public Double getLastOrder() {
    return last_order;
  }

  @Override
  public String toString() {
    return "KoinimTicker {"
        + "sell="
        + sell
        + ", high="
        + high
        + ", buy="
        + buy
        + ", change_rate="
        + change_rate
        + ", bid="
        + bid
        + ", wavg="
        + wavg
        + ", last_order="
        + last_order
        + ", volume="
        + volume
        + ", low="
        + low
        + ", ask="
        + ask
        + ", avg="
        + avg
        + '}';
  }

  public Double getVolume() {
    return volume;
  }
}
