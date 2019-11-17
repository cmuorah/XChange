package org.knowm.xchange.upbit.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author interwater */
public class UpbitTrade {

  private final String market;
  private final String tradeDateUtc;
  private final String tradeTimeUtc;
  private final Double timestamp;
  private final Double tradePrice;
  private final Double tradeVolume;
  private final Double prevClosingPrice;
  private final Double changePrice;
  private final String askBid;

  /**
   * @param market
   * @param tradeDateUtc
   * @param tradeTimeUtc
   * @param timestamp
   * @param tradePrice
   * @param tradeVolume
   * @param prevClosingPrice
   * @param changePrice
   * @param askBid
   */
  public UpbitTrade(
      @JsonProperty("market") String market,
      @JsonProperty("trade_date_utc") String tradeDateUtc,
      @JsonProperty("trade_time_utc") String tradeTimeUtc,
      @JsonProperty("timestamp") Double timestamp,
      @JsonProperty("trade_price") Double tradePrice,
      @JsonProperty("trade_volume") Double tradeVolume,
      @JsonProperty("prev_closing_price") Double prevClosingPrice,
      @JsonProperty("change_price") Double changePrice,
      @JsonProperty("ask_bid") String askBid) {
    this.market = market;
    this.tradeDateUtc = tradeDateUtc;
    this.tradeTimeUtc = tradeTimeUtc;
    this.timestamp = timestamp;
    this.tradePrice = tradePrice;
    this.tradeVolume = tradeVolume;
    this.prevClosingPrice = prevClosingPrice;
    this.changePrice = changePrice;
    this.askBid = askBid;
  }

  public String getMarket() {
    return market;
  }

  public String getTradeDateUtc() {
    return tradeDateUtc;
  }

  public String getTradeTimeUtc() {
    return tradeTimeUtc;
  }

  public Double getTimestamp() {
    return timestamp;
  }

  public Double getTradePrice() {
    return tradePrice;
  }

  public Double getTradeVolume() {
    return tradeVolume;
  }

  public Double getPrevClosingPrice() {
    return prevClosingPrice;
  }

  public Double getChangePrice() {
    return changePrice;
  }

  public String getAskBid() {
    return askBid;
  }
}
