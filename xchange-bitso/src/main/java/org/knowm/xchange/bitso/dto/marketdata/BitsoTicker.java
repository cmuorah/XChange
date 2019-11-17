package org.knowm.xchange.bitso.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Date;
import si.mazi.rescu.ExceptionalReturnContentException;
import si.mazi.rescu.serialization.jackson.serializers.TimestampDeserializer;

/** @author Piotr Ładyżyński */
public class BitsoTicker {

  private final Double last;
  private final Double high;
  private final Double low;
  private final Double vwap;
  private final Double volume;
  private final Double bid;
  private final Double ask;
  private final Date timestamp;

  public BitsoTicker(
      @JsonProperty("last") Double last,
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("vwap") Double vwap,
      @JsonProperty("volume") Double volume,
      @JsonProperty("bid") Double bid,
      @JsonProperty("ask") Double ask,
      @JsonProperty("timestamp") @JsonDeserialize(using = TimestampDeserializer.class)
          Date timestamp) {

    if (last == null) {
      throw new ExceptionalReturnContentException("No last in response.");
    }
    this.last = last;
    this.high = high;
    this.low = low;
    this.vwap = vwap;
    this.volume = volume;
    this.bid = bid;
    this.ask = ask;
    this.timestamp = timestamp;
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

  public Double getVwap() {

    return vwap;
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

  public Date getTimestamp() {

    return timestamp;
  }

  @Override
  public String toString() {

    return "BitsoTicker [last="
        + last
        + ", high="
        + high
        + ", low="
        + low
        + ", vwap="
        + vwap
        + ", volume="
        + volume
        + ", bid="
        + bid
        + ", ask="
        + ask
        + ", timestamp="
        + timestamp
        + "]";
  }
}
