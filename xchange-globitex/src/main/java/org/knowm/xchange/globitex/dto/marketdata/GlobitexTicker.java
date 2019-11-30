package org.knowm.xchange.globitex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import net.openhft.chronicle.wire.AbstractMarshallable;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "symbol",
  "ask",
  "bid",
  "last",
  "low",
  "high",
  "open",
  "volume",
  "volumeQuote",
  "timestamp"
})
public class GlobitexTicker extends AbstractMarshallable implements Serializable {

  @JsonProperty("symbol")
  private final String symbol;

  @JsonProperty("ask")
  private final Double ask;

  @JsonProperty("bid")
  private final Double bid;

  @JsonProperty("last")
  private final Double last;

  @JsonProperty("low")
  private final Double low;

  @JsonProperty("high")
  private final Double high;

  @JsonProperty("open")
  private final Double open;

  @JsonProperty("volume")
  private final Double volume;

  @JsonProperty("volumeQuote")
  private final Double volumeQuote;

  @JsonProperty("timestamp")
  private final long timestamp;

  /**
   * @param timestamp
   * @param open
   * @param last
   * @param symbol
   * @param volume
   * @param high
   * @param low
   * @param ask
   * @param bid
   * @param volumeQuote
   */
  public GlobitexTicker(
      @JsonProperty("symbol") String symbol,
      @JsonProperty("ask") Double ask,
      @JsonProperty("bid") Double bid,
      @JsonProperty("last") Double last,
      @JsonProperty("low") Double low,
      @JsonProperty("high") Double high,
      @JsonProperty("open") Double open,
      @JsonProperty("volume") Double volume,
      @JsonProperty("volumeQuote") Double volumeQuote,
      @JsonProperty("timestamp") long timestamp) {
    super();
    this.symbol = symbol;
    this.ask = ask;
    this.bid = bid;
    this.last = last;
    this.low = low;
    this.high = high;
    this.open = open;
    this.volume = volume;
    this.volumeQuote = volumeQuote;
    this.timestamp = timestamp;
  }

  public String getSymbol() {
    return symbol;
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

  public Double getVolume() {
    return volume;
  }

  public Double getVolumeQuote() {
    return volumeQuote;
  }

  public long getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return "GlobitexTicker{"
        + "symbol='"
        + symbol
        + '\''
        + ", ask='"
        + ask
        + '\''
        + ", bid='"
        + bid
        + '\''
        + ", last='"
        + last
        + '\''
        + ", low='"
        + low
        + '\''
        + ", high='"
        + high
        + '\''
        + ", open='"
        + open
        + '\''
        + ", volume='"
        + volume
        + '\''
        + ", volumeQuote='"
        + volumeQuote
        + '\''
        + ", timestamp="
        + timestamp
        + '}';
  }
}
