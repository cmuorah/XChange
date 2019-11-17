package org.knowm.xchange.bitcoinium.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Data object representing Ticker from Bitcoinium Web Service */
public final class BitcoiniumTicker {

  private final Double last;
  private final long timestamp;
  private final Double volume;
  private final Double high;
  private final Double low;
  private final Double bid;
  private final Double ask;
  private final Double trades;

  /**
   * Constructor
   *
   * @param last
   * @param timestamp
   * @param volume
   * @param high
   * @param low
   * @param bid
   * @param ask
   */
  public BitcoiniumTicker(
      @JsonProperty("l") Double last,
      @JsonProperty("t") long timestamp,
      @JsonProperty("v") Double volume,
      @JsonProperty("h") Double high,
      @JsonProperty("lo") Double low,
      @JsonProperty("b") Double bid,
      @JsonProperty("a") Double ask,
      @JsonProperty("tr") Double trades) {

    this.last = last;
    this.timestamp = timestamp;
    this.volume = volume;
    this.high = high;
    this.low = low;
    this.bid = bid;
    this.ask = ask;
    this.trades = trades;
  }

  public Double getLast() {

    return this.last;
  }

  public long getTimestamp() {

    return this.timestamp;
  }

  public Double getVolume() {

    return this.volume;
  }

  public Double getHigh() {

    return this.high;
  }

  public Double getLow() {

    return this.low;
  }

  public Double getBid() {

    return this.bid;
  }

  public Double getAsk() {

    return this.ask;
  }

  public Double getTrades() {

    return trades;
  }

  @Override
  public String toString() {

    return "BitcoiniumTicker [last="
        + last
        + ", timestamp="
        + timestamp
        + ", volume="
        + volume
        + ", high="
        + high
        + ", low="
        + low
        + ", bid="
        + bid
        + ", ask="
        + ask
        + ", trades="
        + trades
        + "]";
  }
}
