package org.knowm.xchange.kraken.dto.marketdata;

public class KrakenOHLC {

  private final long time;
  private final Double open;
  private final Double high;
  private final Double low;
  private final Double close;
  private final Double vwap;
  private final Double volume;
  private final long count;

  public KrakenOHLC(
      long time,
      Double open,
      Double high,
      Double low,
      Double close,
      Double vwap,
      Double volume,
      long count) {
    this.time = time;
    this.open = open;
    this.high = high;
    this.low = low;
    this.close = close;
    this.vwap = vwap;
    this.volume = volume;
    this.count = count;
  }

  public long getTime() {
    return time;
  }

  public Double getOpen() {
    return open;
  }

  public Double getHigh() {
    return high;
  }

  public Double getLow() {
    return low;
  }

  public Double getClose() {
    return close;
  }

  public Double getVwap() {
    return vwap;
  }

  public Double getVolume() {
    return volume;
  }

  public long getCount() {
    return count;
  }

  @Override
  public String toString() {

    return "KrakenOHLC [time="
        + time
        + ", open="
        + open
        + ", high="
        + high
        + ", low="
        + low
        + ", close="
        + close
        + ", vwap="
        + vwap
        + ", volume="
        + volume
        + ", count="
        + count
        + "]";
  }
}
