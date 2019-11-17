package org.knowm.xchange.yobit.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YoBitTicker {
  private final Double high;
  private final Double low;
  private final Double avg;
  private final Double vol;
  private final Double volCur;
  private final Double last;
  private final Double buy;
  private final Double sell;
  private final long updated;

  public YoBitTicker(
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

  public Double getBuy() {
    return buy;
  }

  public Double getHigh() {
    return high;
  }

  public Double getLow() {
    return low;
  }

  public Double getAvg() {
    return avg;
  }

  public Double getVol() {
    return vol;
  }

  public Double getVolCur() {
    return volCur;
  }

  public Double getLast() {
    return last;
  }

  public Double getSell() {
    return sell;
  }

  public long getUpdated() {
    return updated;
  }

  @Override
  public String toString() {
    return "YoBitTickker [buy="
        + buy
        + ", high="
        + high
        + ", low="
        + low
        + ", avg="
        + avg
        + ", vol="
        + vol
        + ", volCur="
        + volCur
        + ", last="
        + last
        + ", sell="
        + sell
        + ", updated="
        + updated
        + "]";
  }
}
