package org.knowm.xchange.bitfinex.v1.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitfinexTicker {

  private final Double mid;
  private final Double bid;
  private final Double ask;
  private final Double high;
  private final Double low;
  private final Double last;
  private final Double volume;
  private final double timestamp;

  /**
   * @param mid
   * @param bid
   * @param ask
   * @param low
   * @param high
   * @param last
   * @param timestamp
   * @param volume
   */
  public BitfinexTicker(
      @JsonProperty("mid") Double mid,
      @JsonProperty("bid") Double bid,
      @JsonProperty("ask") Double ask,
      @JsonProperty("low") Double low,
      @JsonProperty("high") Double high,
      @JsonProperty("last_price") Double last,
      @JsonProperty("timestamp") double timestamp,
      @JsonProperty("volume") Double volume) {

    this.mid = mid;
    this.bid = bid;
    this.ask = ask;
    this.last = last;
    this.volume = volume;
    this.high = high;
    this.low = low;
    this.timestamp = timestamp;
  }

  public Double getMid() {

    return mid;
  }

  public Double getBid() {

    return bid;
  }

  public Double getAsk() {

    return ask;
  }

  public Double getLow() {

    return low;
  }

  public Double getHigh() {

    return high;
  }

  public Double getLast_price() {

    return last;
  }

  public Double getVolume() {

    return volume;
  }

  public double getTimestamp() {

    return timestamp;
  }

  @Override
  public String toString() {

    return "BitfinexTicker [mid="
        + mid
        + ", bid="
        + bid
        + ", ask="
        + ask
        + ", low="
        + low
        + ", high="
        + high
        + ", last="
        + last
        + ", timestamp="
        + timestamp
        + "]";
  }
}
