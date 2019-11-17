package org.knowm.xchange.bitcoincharts.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author Matija Mazi */
public final class BitcoinChartsTicker {

  private final Double ask;
  private final Double avg;
  private final Double bid;
  private final Double close;
  private final String currency;
  private final Double currencyVolume;
  private final Double high;
  private final long latestTrade;
  private final Double low;
  private final String symbol;
  private final Double volume;

  /**
   * Constructor
   *
   * @param ask
   * @param avg
   * @param bid
   * @param close
   * @param currency
   * @param currencyVolume
   * @param high
   * @param latestTrade
   * @param low
   * @param symbol
   * @param volume
   */
  public BitcoinChartsTicker(
      @JsonProperty("ask") Double ask,
      @JsonProperty("avg") Double avg,
      @JsonProperty("bid") Double bid,
      @JsonProperty("close") Double close,
      @JsonProperty("currency") String currency,
      @JsonProperty("currency_volume") Double currencyVolume,
      @JsonProperty("high") Double high,
      @JsonProperty("latest_trade") long latestTrade,
      @JsonProperty("low") Double low,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("volume") Double volume) {

    this.ask = ask;
    this.avg = avg;
    this.bid = bid;
    this.close = close;
    this.currency = currency.toUpperCase();
    this.currencyVolume = currencyVolume;
    this.high = high;
    this.latestTrade = latestTrade;
    this.low = low;
    this.symbol = symbol.toUpperCase();
    this.volume = volume;
  }

  public Double getAsk() {

    return ask;
  }

  public Double getAvg() {

    return avg;
  }

  public Double getBid() {

    return bid;
  }

  public Double getClose() {

    return close;
  }

  public String getCurrency() {

    return currency;
  }

  public Double getCurrencyVolume() {

    return currencyVolume;
  }

  public Double getHigh() {

    return high;
  }

  public long getLatestTrade() {

    return latestTrade;
  }

  public Double getLow() {

    return low;
  }

  public String getSymbol() {

    return symbol;
  }

  public Double getVolume() {

    return volume;
  }

  @Override
  public String toString() {

    return "BitcoinChartsTickers [ask="
        + ask
        + ", avg="
        + avg
        + ", bid="
        + bid
        + ", close="
        + close
        + ", currency="
        + currency
        + ", currencyVolume="
        + currencyVolume
        + ", high="
        + high
        + ", latestTrade="
        + latestTrade
        + ", low="
        + low
        + ", symbol="
        + symbol
        + ", volume="
        + volume
        + "]";
  }
}
