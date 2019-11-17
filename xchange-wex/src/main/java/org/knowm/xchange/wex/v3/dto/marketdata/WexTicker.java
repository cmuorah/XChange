package org.knowm.xchange.wex.v3.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Data object representing Ticker from Wex */
public final class WexTicker {

  private final Double last;
  private final Double high;
  private final Double low;
  private final Double avg;
  private final Double buy;
  private final Double sell;
  private final Double vol;
  private final Double volCur;
  private final long updated;

  /**
   * Constructor
   *
   * @param high
   * @param low
   * @param vol
   * @param last
   * @param avg
   * @param buy
   * @param updated
   * @param volCur
   * @param sell
   */
  public WexTicker(
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("vol") Double vol,
      @JsonProperty("last") Double last,
      @JsonProperty("avg") Double avg,
      @JsonProperty("buy") Double buy,
      @JsonProperty("updated") long updated,
      @JsonProperty("vol_cur") Double volCur,
      @JsonProperty("sell") Double sell) {

    this.high = high;
    this.low = low;
    this.last = last;
    this.avg = avg;
    this.buy = buy;
    this.sell = sell;
    this.updated = updated;
    this.vol = vol;
    this.volCur = volCur;
  }

  public Double getAvg() {

    return avg;
  }

  public Double getBuy() {

    return buy;
  }

  public Double getHigh() {

    return high;
  }

  public Double getLast() {

    return last;
  }

  public Double getLow() {

    return low;
  }

  public Double getSell() {

    return sell;
  }

  public long getUpdated() {

    return updated;
  }

  public Double getVol() {

    return vol;
  }

  public Double getVolCur() {

    return volCur;
  }

  @Override
  public String toString() {

    return "BTCETickerObject [last="
        + last
        + ", high="
        + high
        + ", low="
        + low
        + ", avg="
        + avg
        + ", buy="
        + buy
        + ", sell="
        + sell
        + ", updated="
        + updated
        + ", vol="
        + vol
        + ", volCur="
        + volCur
        + "]";
  }
}
