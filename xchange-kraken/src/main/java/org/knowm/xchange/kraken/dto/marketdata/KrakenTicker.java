package org.knowm.xchange.kraken.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

/** Data object representing depth from Kraken */
public class KrakenTicker {

  private final KrakenPublicOrder ask; // ask array(<price>, <lot volume>),
  private final KrakenPublicOrder bid; // bid array(<price>, <lot volume>),
  private final KrakenPublicOrder close; // last trade closed array(<price>, <lot volume>),
  private final Double[] volume; // volume array(<today>, <last 24 hours>),
  private final Double[]
      volumeAvg; // volume weighted average price array(<today>, <last 24 hours>),
  private final Double[] trades; // number of trades array(<today>, <last 24 hours>),
  private final Double[] low; // low array(<today>, <last 24 hours>),
  private final Double[] high; // high array(<today>, <last 24 hours>),
  private final Double open; // today's opening price

  /**
   * Constructor
   *
   * @param ask
   * @param bid
   * @param close
   * @param volume
   * @param volumeAvg
   * @param trades
   * @param low
   * @param high
   * @param open
   * @author Raphael Voellmy
   */
  public KrakenTicker(
      @JsonProperty("a") KrakenPublicOrder ask,
      @JsonProperty("b") KrakenPublicOrder bid,
      @JsonProperty("c") KrakenPublicOrder close,
      @JsonProperty("v") Double[] volume,
      @JsonProperty("p") Double[] volumeAvg,
      @JsonProperty("t") Double[] trades,
      @JsonProperty("l") Double[] low,
      @JsonProperty("h") Double[] high,
      @JsonProperty("o") Double open) {

    this.ask = ask;
    this.bid = bid;
    this.close = close;
    this.volume = volume;
    this.volumeAvg = volumeAvg;
    this.trades = trades;
    this.low = low;
    this.high = high;
    this.open = open;
  }

  public KrakenPublicOrder getAsk() {

    return ask;
  }

  public KrakenPublicOrder getBid() {

    return bid;
  }

  public KrakenPublicOrder getClose() {

    return close;
  }

  public Double getTodaysVolume() {

    return volume[0];
  }

  public Double get24HourVolume() {

    return volume[1];
  }

  public Double getTodaysVolumeAvg() {

    return volumeAvg[0];
  }

  public Double get24HourVolumeAvg() {

    return volumeAvg[1];
  }

  public Double getTodaysNumTrades() {

    return trades[0];
  }

  public Double get24HourNumTrades() {

    return trades[1];
  }

  public Double getTodaysLow() {

    return low[0];
  }

  public Double get24HourLow() {

    return low[1];
  }

  public Double getTodaysHigh() {

    return high[0];
  }

  public Double get24HourHigh() {

    return high[1];
  }

  public Double getOpen() {

    return open;
  }

  @Override
  public String toString() {

    return "KrakenTicker [ask="
        + ask
        + ", bid="
        + bid
        + ", close="
        + close
        + ", volume="
        + Arrays.toString(volume)
        + ", volumeAvg="
        + Arrays.toString(volumeAvg)
        + ", trades="
        + Arrays.toString(trades)
        + ", low="
        + Arrays.toString(low)
        + ", high="
        + Arrays.toString(high)
        + ", open="
        + open
        + "]";
  }
}
