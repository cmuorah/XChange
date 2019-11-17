package org.knowm.xchange.itbit.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItBitTicker {

  private final String currencyPair;
  private final Double bid;
  private final Double ask;
  private final Double bidAmt;
  private final Double askAmt;
  private final Double lastPrice;
  private final double lastAmt;
  private final Double volume24h;
  private final Double highToday;
  private final Double lowToday;
  private final double openToday;
  private final double vwapToday;
  private final double vwap24h;
  private final String timestamp;

  public ItBitTicker(
      @JsonProperty("pair") String currencyPair,
      @JsonProperty("bid") Double bid,
      @JsonProperty("ask") Double ask,
      @JsonProperty("bidAmt") Double bidAmt,
      @JsonProperty("askAmt") Double askAmt,
      @JsonProperty("lastPrice") Double lastPrice,
      @JsonProperty("lastAmt") double lastAmt,
      @JsonProperty("volume24h") Double volume24h,
      @JsonProperty("highToday") Double highToday,
      @JsonProperty("lowToday") Double lowToday,
      @JsonProperty("openToday") double openToday,
      @JsonProperty("vwapToday") double vwapToday,
      @JsonProperty("vwap24h") double vwap24h,
      @JsonProperty("serverTimeUTC") String timestamp) {

    super();
    this.currencyPair = currencyPair;
    this.bid = bid;
    this.ask = ask;
    this.bidAmt = bidAmt;
    this.askAmt = askAmt;
    this.lastPrice = lastPrice;
    this.lastAmt = lastAmt;
    this.volume24h = volume24h;
    this.highToday = highToday;
    this.lowToday = lowToday;
    this.openToday = openToday;
    this.vwapToday = vwapToday;
    this.vwap24h = vwap24h;
    this.timestamp = timestamp;
  }

  public String getCurrencyPair() {

    return currencyPair;
  }

  public Double getBid() {

    return bid;
  }

  public Double getAsk() {

    return ask;
  }

  public Double getBidAmt() {

    return bidAmt;
  }

  public Double getAskAmt() {

    return askAmt;
  }

  public Double getLastPrice() {

    return lastPrice;
  }

  public double getLastAmt() {

    return lastAmt;
  }

  public Double getVolume24h() {

    return volume24h;
  }

  public Double getHighToday() {

    return highToday;
  }

  public Double getLowToday() {

    return lowToday;
  }

  public double getOpenToday() {

    return openToday;
  }

  public double getVwapToday() {

    return vwapToday;
  }

  public double getVwap24h() {

    return vwap24h;
  }

  public String getTimestamp() {

    return timestamp;
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    builder.append("ItBitTicker [currencyPair=");
    builder.append(currencyPair);
    builder.append(", bid=");
    builder.append(bid);
    builder.append(", ask=");
    builder.append(ask);
    builder.append(", volume24h=");
    builder.append(volume24h);
    builder.append(", highToday=");
    builder.append(highToday);
    builder.append(", lowToday=");
    builder.append(lowToday);
    builder.append("]");
    return builder.toString();
  }
}
