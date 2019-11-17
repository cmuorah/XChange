package org.knowm.xchange.bittrex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BittrexMarketSummary {

  private Double ask;
  private Double baseVolume;
  private Double bid;
  private String created;
  private String displayMarketName;
  private Double high;
  private Double last;
  private Double low;
  private String marketName;
  private int openBuyOrders;
  private int openSellOrders;
  private Double prevDay;
  private String timeStamp;
  private Double volume;

  public BittrexMarketSummary(
      @JsonProperty("Ask") Double ask,
      @JsonProperty("BaseVolume") Double baseVolume,
      @JsonProperty("Bid") Double bid,
      @JsonProperty("Created") String created,
      @JsonProperty("DisplayMarketName") String displayMarketName,
      @JsonProperty("High") Double high,
      @JsonProperty("Last") Double last,
      @JsonProperty("Low") Double low,
      @JsonProperty("MarketName") String marketName,
      @JsonProperty("OpenBuyOrders") int openBuyOrders,
      @JsonProperty("OpenSellOrders") int openSellOrders,
      @JsonProperty("PrevDay") Double prevDay,
      @JsonProperty("TimeStamp") String timeStamp,
      @JsonProperty("Volume") Double volume) {

    this.ask = ask;
    this.baseVolume = baseVolume;
    this.bid = bid;
    this.created = created;
    this.displayMarketName = displayMarketName;
    this.high = high;
    this.last = last;
    this.low = low;
    this.marketName = marketName;
    this.openBuyOrders = openBuyOrders;
    this.openSellOrders = openSellOrders;
    this.prevDay = prevDay;
    this.timeStamp = timeStamp;
    this.volume = volume;
  }

  public Double getAsk() {

    return this.ask;
  }

  public void setAsk(Double ask) {

    this.ask = ask;
  }

  public Double getBaseVolume() {

    return this.baseVolume;
  }

  public void setBaseVolume(Double baseVolume) {

    this.baseVolume = baseVolume;
  }

  public Double getBid() {

    return this.bid;
  }

  public void setBid(Double bid) {

    this.bid = bid;
  }

  public String getCreated() {

    return this.created;
  }

  public void setCreated(String created) {

    this.created = created;
  }

  public String getDisplayMarketName() {

    return this.displayMarketName;
  }

  public void setDisplayMarketName(String displayMarketName) {

    this.displayMarketName = displayMarketName;
  }

  public Double getHigh() {

    return this.high;
  }

  public void setHigh(Double high) {

    this.high = high;
  }

  public Double getLast() {

    return this.last;
  }

  public void setLast(Double last) {

    this.last = last;
  }

  public Double getLow() {

    return this.low;
  }

  public void setLow(Double low) {

    this.low = low;
  }

  public String getMarketName() {

    return this.marketName;
  }

  public void setMarketName(String marketName) {

    this.marketName = marketName;
  }

  public int getOpenBuyOrders() {

    return this.openBuyOrders;
  }

  public void setOpenBuyOrders(int openBuyOrders) {

    this.openBuyOrders = openBuyOrders;
  }

  public int getOpenSellOrders() {

    return this.openSellOrders;
  }

  public void setOpenSellOrders(int openSellOrders) {

    this.openSellOrders = openSellOrders;
  }

  public Double getPrevDay() {

    return this.prevDay;
  }

  public void setPrevDay(Double prevDay) {

    this.prevDay = prevDay;
  }

  public String getTimeStamp() {

    return this.timeStamp;
  }

  public void setTimeStamp(String timeStamp) {

    this.timeStamp = timeStamp;
  }

  public Double getVolume() {

    return this.volume;
  }

  public void setVolume(Double volume) {

    this.volume = volume;
  }

  @Override
  public String toString() {

    return "BittrexMarketSummary [ask="
        + ask
        + ", baseVolume="
        + baseVolume
        + ", bid="
        + bid
        + ", created="
        + created
        + ", displayMarketName="
        + displayMarketName
        + ", high="
        + high
        + ", last="
        + last
        + ", low="
        + low
        + ", marketName="
        + marketName
        + ", openBuyOrders="
        + openBuyOrders
        + ", openSellOrders="
        + openSellOrders
        + ", prevDay="
        + prevDay
        + ", timeStamp="
        + timeStamp
        + ", volume="
        + volume
        + "]";
  }
}
