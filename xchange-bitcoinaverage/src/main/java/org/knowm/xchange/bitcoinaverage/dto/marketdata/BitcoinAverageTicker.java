package org.knowm.xchange.bitcoinaverage.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/** Data object representing Ticker from BitcoinAverage */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class BitcoinAverageTicker {

  private final Double last;
  private final Double ask;
  private final Double bid;
  private final Double volume_percent;
  private final Double volume;
  private final String timestamp;

  /**
   * Constructor
   *
   * @param bid
   * @param ask
   * @param volume
   * @param last
   * @param timestamp
   */
  public BitcoinAverageTicker(
      @JsonProperty("ask") Double ask,
      @JsonProperty("bid") Double bid,
      @JsonProperty("volume_btc") Double volume,
      @JsonProperty("last") Double last,
      @JsonProperty("volume_percent") Double volume_percent,
      @JsonProperty("timestamp") String timestamp) {

    this.ask = ask;
    this.bid = bid;
    this.volume = volume;
    this.last = last;
    this.volume_percent = volume_percent;
    this.timestamp = timestamp;
  }

  public Double getLast() {

    return last;
  }

  public Double getAsk() {

    return ask;
  }

  public Double getBid() {

    return bid;
  }

  public Double getVolume() {

    return volume;
  }

  public Double getVolumePercent() {

    return volume_percent;
  }

  public Date getTimestamp() {

    try {
      // Parse the timestamp into a Date object
      return new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.getDefault())
          .parse(timestamp);
    } catch (IllegalArgumentException | ParseException e) {
      // Return current Date
      return new Date();
    }
  }

  @Override
  public String toString() {

    return "BitcoinAverageTicker [last="
        + last
        + ", ask="
        + ask
        + ", bid="
        + bid
        + ", volume="
        + volume
        + ", volume_percent="
        + volume_percent
        + ", timestamp="
        + timestamp
        + "]";
  }
}
