package org.knowm.xchange.cexio.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Author: brox Since: 2/5/14 */
public class CexIOTicker {

  private final Double last;
  private final Double high;
  private final Double low;
  private final Double volume;
  private final Double bid;
  private final Double ask;
  private final long timestamp;
  private final String pair;

  /**
   * Constructor
   *
   * @param last
   * @param high
   * @param low
   * @param volume
   * @param bid
   * @param ask
   * @param pair the currency pair
   */
  public CexIOTicker(
      @JsonProperty("last") Double last,
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("volume") Double volume,
      @JsonProperty("bid") Double bid,
      @JsonProperty("ask") Double ask,
      @JsonProperty("timestamp") long timestamp,
      @JsonProperty("pair") String pair) {

    this.last = last;
    this.high = high;
    this.low = low;
    this.volume = volume;
    this.bid = bid;
    this.ask = ask;
    this.timestamp = timestamp;
    this.pair = pair;
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

  public String getPair() {

    return pair;
  }

  @Override
  public String toString() {

    return "CexIOTicker [last="
        + last
        + ", high="
        + high
        + ", low="
        + low
        + ", volume="
        + volume
        + ", bid="
        + bid
        + ", ask="
        + ask
        + ", timestamp="
        + timestamp
        + ", pair="
        + pair
        + "]";
  }
}
