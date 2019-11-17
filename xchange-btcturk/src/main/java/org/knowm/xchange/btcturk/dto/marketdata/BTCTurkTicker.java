package org.knowm.xchange.btcturk.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.btcturk.dto.BTCTurkPair;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;

/**
 * @author semihunaldi
 * @author mertguner
 */
public final class BTCTurkTicker {

  private BTCTurkPair pair;
  private final Double high;
  private final Double last;
  private final long timestamp;
  private final Double bid;
  private final Double volume;
  private final Double low;
  private final Double ask;
  private final Double open;
  private final Double average;
  private final Double daily;
  private final Double dailyPercent;
  private final Currency denominatorsymbol;
  private final Currency numeratorsymbol;

  public BTCTurkTicker(
      @JsonProperty("pair") BTCTurkPair pair,
      @JsonProperty("high") Double high,
      @JsonProperty("last") Double last,
      @JsonProperty("timestamp") long timestamp,
      @JsonProperty("bid") Double bid,
      @JsonProperty("volume") Double volume,
      @JsonProperty("low") Double low,
      @JsonProperty("ask") Double ask,
      @JsonProperty("open") Double open,
      @JsonProperty("average") Double average,
      @JsonProperty("daily") Double daily,
      @JsonProperty("dailyPercent") Double dailyPercent,
      @JsonProperty("denominatorsymbol") Currency denominatorsymbol,
      @JsonProperty("numeratorsymbol") Currency numeratorsymbol) {
    this.pair = pair;
    this.high = high;
    this.last = last;
    this.timestamp = timestamp;
    this.bid = bid;
    this.volume = volume;
    this.low = low;
    this.ask = ask;
    this.open = open;
    this.average = average;
    this.daily = daily;
    this.dailyPercent = dailyPercent;
    this.denominatorsymbol = denominatorsymbol;
    this.numeratorsymbol = numeratorsymbol;
  }

  public CurrencyPair getPair() {
    return pair.pair;
  }

  public Double getHigh() {
    return high;
  }

  public Double getLast() {
    return last;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public Double getBid() {
    return bid;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getLow() {
    return low;
  }

  public Double getAsk() {
    return ask;
  }

  public Double getOpen() {
    return open;
  }

  public Double getAverage() {
    return average;
  }

  public Double getDaily() {
    return daily;
  }

  public Double getDailyPercent() {
    return dailyPercent;
  }

  public Currency getDenominatorsymbol() {
    return denominatorsymbol;
  }

  public Currency getNumeratorsymbol() {
    return numeratorsymbol;
  }

  @Override
  public String toString() {
    return "BTCTurkTicker [high="
        + high
        + ", last="
        + last
        + ", timestamp="
        + timestamp
        + ", bid="
        + bid
        + ", volume="
        + volume
        + ", low="
        + low
        + ", ask="
        + ask
        + ", open="
        + open
        + ", average="
        + average
        + ", daily="
        + daily
        + ", dailyPercent="
        + dailyPercent
        + ", denominatorsymbol="
        + denominatorsymbol
        + ", numeratorsymbol="
        + numeratorsymbol
        + "]";
  }
}
