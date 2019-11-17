package org.knowm.xchange.liqui.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LiquiTicker {

  private final Double high;
  private final Double low;
  private final Double avg;
  private final Double vol;
  private final Double volCur;
  private final Double last;
  private final Double buy;
  private final Double sell;
  private final long updated;

  public LiquiTicker(
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("avg") Double avg,
      @JsonProperty("vol") Double vol,
      @JsonProperty("vol_cur") Double volCur,
      @JsonProperty("last") Double last,
      @JsonProperty("buy") Double buy,
      @JsonProperty("sell") Double sell,
      @JsonProperty("updated") long updated) {
    this.high = high;
    this.low = low;
    this.avg = avg;
    this.vol = vol;
    this.volCur = volCur;
    this.last = last;
    this.buy = buy;
    this.sell = sell;
    this.updated = updated;
  }

  public Double getHigh() {
    return this.high;
  }

  public Double getLow() {
    return this.low;
  }

  public Double getAvg() {
    return this.avg;
  }

  public Double getVol() {
    return this.vol;
  }

  public Double getVolCur() {
    return this.volCur;
  }

  public Double getLast() {
    return this.last;
  }

  public Double getBuy() {
    return this.buy;
  }

  public Double getSell() {
    return this.sell;
  }

  public long getUpdated() {
    return this.updated;
  }

  @Override
  public String toString() {
    return "LiquiTicker{"
        + "high="
        + this.high
        + ", low="
        + this.low
        + ", avg="
        + this.avg
        + ", vol="
        + this.vol
        + ", volCur="
        + this.volCur
        + ", last="
        + this.last
        + ", buy="
        + this.buy
        + ", sell="
        + this.sell
        + ", updated="
        + this.updated
        + '}';
  }
}
