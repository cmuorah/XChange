package org.knowm.xchange.exx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

// -------------------------
public class EXXTicker extends EXXTickerResponse {

  @JsonProperty("vol")
  private Double vol;

  @JsonProperty("last")
  private Double last;

  @JsonProperty("sell")
  private Double sell;

  @JsonProperty("buy")
  private Double buy;

  @JsonProperty("weekRiseRate")
  private Double weekRiseRate;

  @JsonProperty("riseRate")
  private Double riseRate;

  @JsonProperty("high")
  private Double high;

  @JsonProperty("low")
  private Double low;

  @JsonProperty("monthRiseRate")
  private Double monthRiseRate;

  /** No args constructor for use in serialization */
  public EXXTicker() {}

  /**
   * @param vol
   * @param last
   * @param buy
   * @param sell
   * @param weekRiseRate
   * @param riseRate
   * @param high
   * @param low
   * @param monthRiseRate
   */
  public EXXTicker(
      Double vol,
      Double last,
      Double sell,
      Double buy,
      Double weekRiseRate,
      Double riseRate,
      Double high,
      Double low,
      Double monthRiseRate) {
    super();
    this.vol = vol;
    this.last = last;
    this.sell = sell;
    this.buy = buy;
    this.weekRiseRate = weekRiseRate;
    this.riseRate = riseRate;
    this.high = high;
    this.low = low;
    this.monthRiseRate = monthRiseRate;
  }

  @JsonProperty("vol")
  public Double getVol() {
    return vol;
  }

  @JsonProperty("vol")
  public void setVol(Double vol) {
    this.vol = vol;
  }

  @JsonProperty("last")
  public Double getLast() {
    return last;
  }

  @JsonProperty("last")
  public void setLast(Double last) {
    this.last = last;
  }

  @JsonProperty("sell")
  public Double getSell() {
    return sell;
  }

  @JsonProperty("sell")
  public void setSell(Double sell) {
    this.sell = sell;
  }

  @JsonProperty("buy")
  public Double getBuy() {
    return buy;
  }

  @JsonProperty("buy")
  public void setBuy(Double buy) {
    this.buy = buy;
  }

  @JsonProperty("weekRiseRate")
  public Double getWeekRiseRate() {
    return weekRiseRate;
  }

  @JsonProperty("weekRiseRate")
  public void setWeekRiseRate(Double weekRiseRate) {
    this.weekRiseRate = weekRiseRate;
  }

  @JsonProperty("riseRate")
  public Double getRiseRate() {
    return riseRate;
  }

  @JsonProperty("riseRate")
  public void setRiseRate(Double riseRate) {
    this.riseRate = riseRate;
  }

  @JsonProperty("high")
  public Double getHigh() {
    return high;
  }

  @JsonProperty("high")
  public void setHigh(Double high) {
    this.high = high;
  }

  @JsonProperty("low")
  public Double getLow() {
    return low;
  }

  @JsonProperty("low")
  public void setLow(Double low) {
    this.low = low;
  }

  @JsonProperty("monthRiseRate")
  public Double getMonthRiseRate() {
    return monthRiseRate;
  }

  @JsonProperty("monthRiseRate")
  public void setMonthRiseRate(Double monthRiseRate) {
    this.monthRiseRate = monthRiseRate;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("vol", vol)
        .append("last", last)
        .append("sell", sell)
        .append("buy", buy)
        .append("weekRiseRate", weekRiseRate)
        .append("riseRate", riseRate)
        .append("high", high)
        .append("low", low)
        .append("monthRiseRate", monthRiseRate)
        .toString();
  }
}
