package org.knowm.xchange.luno.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class LunoTicker {

  public final long timestamp;
  public final Double bid;
  public final Double ask;
  public final Double lastTrade;
  public final Double rolling24HourVolume;
  public final String pair;

  public LunoTicker(
      @JsonProperty(value = "timestamp", required = true) long timestamp,
      @JsonProperty("bid") Double bid,
      @JsonProperty("ask") Double ask,
      @JsonProperty("last_trade") Double lastTrade,
      @JsonProperty("rolling_24_hour_volume") Double rolling24HourVolume,
      @JsonProperty("pair") String pair) {
    super();
    this.timestamp = timestamp;
    this.bid = bid;
    this.ask = ask;
    this.lastTrade = lastTrade;
    this.rolling24HourVolume = rolling24HourVolume;
    this.pair = pair;
  }

  public Date getTimestamp() {
    return new Date(timestamp);
  }

  @Override
  public String toString() {
    return "LunoTicker [timestamp="
        + getTimestamp()
        + ", bid="
        + bid
        + ", ask="
        + ask
        + ", lastTrade="
        + lastTrade
        + ", rolling24HourVolume="
        + rolling24HourVolume
        + ", pair="
        + pair
        + "]";
  }
}
