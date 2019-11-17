package org.knowm.xchange.hitbtc.v2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class HitbtcTicker {

  private final Double ask;
  private final Double bid;
  private final Double last;
  private final Double low;
  private final Double high;
  private final Double open;
  private final String symbol;
  private final Date timestamp;
  private final Double volume;
  private final Double volumeQuote;

  public HitbtcTicker(
      @JsonProperty("ask") Double ask,
      @JsonProperty("bid") Double bid,
      @JsonProperty("last") Double last,
      @JsonProperty("low") Double low,
      @JsonProperty("high") Double high,
      @JsonProperty("open") Double open,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("timestamp") Date timestamp,
      @JsonProperty("volume") Double volume,
      @JsonProperty("volumeQuote") Double volumeQuote) {

    this.ask = ask;
    this.bid = bid;
    this.last = last;
    this.low = low;
    this.high = high;
    this.open = open;
    this.volume = volume;
    this.volumeQuote = volumeQuote;
    this.timestamp = timestamp;
    this.symbol = symbol;
  }

  public Double getAsk() {
    return ask;
  }

  public Double getBid() {
    return bid;
  }

  public Double getLast() {
    return last;
  }

  public Double getLow() {
    return low;
  }

  public Double getHigh() {
    return high;
  }

  public Double getOpen() {
    return open;
  }

  public String getSymbol() {
    return symbol;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getVolumeQuote() {
    return volumeQuote;
  }

  @Override
  public String toString() {
    return "HitbtcTicker{"
        + "ask="
        + ask
        + ", bid="
        + bid
        + ", last="
        + last
        + ", low="
        + low
        + ", high="
        + high
        + ", open="
        + open
        + ", symbol='"
        + symbol
        + '\''
        + ", timestamp="
        + timestamp
        + ", volume="
        + volume
        + ", volumeQuote="
        + volumeQuote
        + '}';
  }
}
