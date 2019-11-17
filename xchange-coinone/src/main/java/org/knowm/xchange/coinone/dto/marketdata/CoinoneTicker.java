package org.knowm.xchange.coinone.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author interwater */
public class CoinoneTicker {

  private final String result;
  private final String errorCode;
  private final Double volume;
  private final Double last;
  private final Double yesterday_last;
  private final String timestamp;
  private final Double yesterday_low;
  private final Double high;
  private final String currency;
  private final Double low;
  private final Double yesterday_first;
  private final Double yesterday_volume;
  private final Double yesterday_high;
  private final Double first;

  public CoinoneTicker(
      @JsonProperty("result") String result,
      @JsonProperty("errorCode") String errorCode,
      @JsonProperty("volume") String volume,
      @JsonProperty("last") String last,
      @JsonProperty("yesterday_last") String yesterday_last,
      @JsonProperty("timestamp") String timestamp,
      @JsonProperty("yesterday_low") String yesterday_low,
      @JsonProperty("high") String high,
      @JsonProperty("currency") String currency,
      @JsonProperty("low") String low,
      @JsonProperty("yesterday_first") String yesterday_first,
      @JsonProperty("yesterday_volume") String yesterday_volume,
      @JsonProperty("yesterday_high") String yesterday_high,
      @JsonProperty("first") String first) {
    this.result = result;
    this.errorCode = errorCode;
    this.volume = new Double(volume);
    this.last = new Double(last);
    this.yesterday_last = new Double(yesterday_last);
    this.timestamp = timestamp;
    this.yesterday_low = new Double(yesterday_low);
    this.high = new Double(high);
    this.currency = currency;
    this.low = new Double(low);
    this.yesterday_first = new Double(yesterday_first);
    this.yesterday_volume = new Double(yesterday_volume);
    this.yesterday_high = new Double(yesterday_high);
    this.first = new Double(first);
  }

  public String getResult() {
    return result;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getLast() {
    return last;
  }

  public Double getYesterday_last() {
    return yesterday_last;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public Double getYesterday_low() {
    return yesterday_low;
  }

  public Double getHigh() {
    return high;
  }

  public String getCurrency() {
    return currency;
  }

  public Double getLow() {
    return low;
  }

  public Double getYesterday_first() {
    return yesterday_first;
  }

  public Double getYesterday_volume() {
    return yesterday_volume;
  }

  public Double getYesterday_high() {
    return yesterday_high;
  }

  public Double getFirst() {
    return first;
  }
}
