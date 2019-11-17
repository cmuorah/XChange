package org.knowm.xchange.bitmex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
  "timestamp",
  "symbol",
  "open",
  "high",
  "low",
  "close",
  "trades",
  "volume",
  "vwap",
  "lastSize",
  "turnover",
  "homeNotional",
  "foreignNotional"
})
public class BitmexKline {
  @JsonProperty("timestamp")
  private final String timestamp;

  @JsonProperty("symbol")
  private final String symbol;

  @JsonProperty("open")
  private final Double open;

  @JsonProperty("high")
  private final Double high;

  @JsonProperty("low")
  private final Double low;

  @JsonProperty("close")
  private final Double close;

  @JsonProperty("trades")
  private final Double trades;

  @JsonProperty("volume")
  private final Double volume;

  @JsonProperty("vwap")
  private final Double vwap;

  @JsonProperty("lastSize")
  private final Long lastSize;

  @JsonProperty("turnover")
  private final Long turnover;

  @JsonProperty("homeNotional")
  private final Double homeNotional;

  @JsonProperty("foreignNotional")
  private final Double foreignNotional;

  public BitmexKline(
      @JsonProperty("timestamp") String timestamp,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("open") Double open,
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("close") Double close,
      @JsonProperty("trades") Double trades,
      @JsonProperty("volume") Double volume,
      @JsonProperty("vwap") Double vwap,
      @JsonProperty("lastSize") Long lastSize,
      @JsonProperty("turnover") Long turnover,
      @JsonProperty("homeNotional") Double homeNotional,
      @JsonProperty("foreignNotional") Double foreignNotional) {
    this.timestamp = timestamp;
    this.symbol = symbol;
    this.open = open;
    this.high = high;
    this.low = low;
    this.close = close;
    this.trades = trades;
    this.volume = volume;
    this.vwap = vwap;
    this.lastSize = lastSize;
    this.turnover = turnover;
    this.homeNotional = homeNotional;
    this.foreignNotional = foreignNotional;
  }

  @JsonProperty("timestamp")
  public String getTimestamp() {
    return timestamp;
  }

  @JsonProperty("symbol")
  public String getSymbol() {
    return symbol;
  }

  @JsonProperty("open")
  public Double getOpen() {
    return open;
  }

  @JsonProperty("high")
  public Double getHigh() {
    return high;
  }

  @JsonProperty("low")
  public Double getLow() {
    return low;
  }

  @JsonProperty("close")
  public Double getClose() {
    return close;
  }

  @JsonProperty("trades")
  public Double getTrades() {
    return trades;
  }

  @JsonProperty("volume")
  public Double getVolume() {
    return volume;
  }

  @JsonProperty("vwap")
  public Double getVwap() {
    return vwap;
  }

  @JsonProperty("lastSize")
  public Long getLastSize() {
    return lastSize;
  }

  @JsonProperty("turnover")
  public Long getTurnover() {
    return turnover;
  }

  @JsonProperty("homeNotional")
  public Double getHomeNotional() {
    return homeNotional;
  }

  @JsonProperty("foreignNotional")
  public Double getForeignNotional() {
    return foreignNotional;
  }

  @Override
  public String toString() {
    return "BitmexKline [timestamp="
        + timestamp
        + ", symbol="
        + symbol
        + ", open="
        + open
        + ", high="
        + high
        + ", low="
        + low
        + ", close="
        + close
        + ", trades="
        + trades
        + ", volume="
        + volume
        + ", vwap="
        + vwap
        + ", lastSize="
        + lastSize
        + ", turnover="
        + turnover
        + ", homeNotional="
        + homeNotional
        + ", foreignNotional="
        + foreignNotional
        + "]";
  }
}
