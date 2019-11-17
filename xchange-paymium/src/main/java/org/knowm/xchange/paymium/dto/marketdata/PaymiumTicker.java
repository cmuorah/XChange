package org.knowm.xchange.paymium.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class PaymiumTicker {

  private final Double high;
  private final Double low;
  private final Double volume;
  private final Double bid;
  private final Double ask;
  private final Double midpoint;
  private final long at;
  private final Double price;
  private final Double vwap;
  private final Double variation;
  private final String currency;

  /**
   * Constructor
   *
   * @param high
   * @param low
   * @param volume
   * @param bid
   * @param ask
   * @param midpoint
   * @param at
   * @param price
   * @param vwap
   * @param variation
   * @param currency
   */
  public PaymiumTicker(
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("volume") Double volume,
      @JsonProperty("bid") Double bid,
      @JsonProperty("ask") Double ask,
      @JsonProperty("midpoint") Double midpoint,
      @JsonProperty("at") long at,
      @JsonProperty("price") Double price,
      @JsonProperty("vwap") Double vwap,
      @JsonProperty("variation") Double variation,
      @JsonProperty("currency") String currency) {

    this.high = high;
    this.low = low;
    this.volume = volume;
    this.bid = bid;
    this.ask = ask;
    this.midpoint = midpoint;
    this.at = at;
    this.price = price;
    this.vwap = vwap;
    this.variation = variation;
    this.currency = currency;
  }

  public Double getHigh() {

    return high;
  }

  public Double getLow() {

    return low;
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

  public Double getMidpoint() {

    return midpoint;
  }

  public long getAt() {

    return at;
  }

  public Double getPrice() {

    return price;
  }

  public Double getVwap() {

    return vwap;
  }

  public Double getVariation() {

    return variation;
  }

  public String getCurrency() {

    return currency;
  }

  @Override
  public String toString() {

    return "PaymiumTicker{"
        + "high="
        + high
        + ", low="
        + low
        + ", volume="
        + volume
        + ", bid="
        + bid
        + ", ask="
        + ask
        + ", midpoint="
        + midpoint
        + ", at="
        + at
        + ", price="
        + price
        + ", vwap="
        + vwap
        + ", variation="
        + variation
        + ", currency='"
        + currency
        + '\''
        + '}';
  }
}
