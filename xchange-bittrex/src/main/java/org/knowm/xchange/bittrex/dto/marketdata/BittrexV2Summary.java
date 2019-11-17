package org.knowm.xchange.bittrex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class BittrexV2Summary {
  private Integer openSellOrders;
  private LocalDateTime timeStamp;
  private Double last;
  private Double low;
  private LocalDateTime created;
  private Double prevDay;
  private Integer openBuyOrders;
  private Double volume;
  private Double baseVolume;
  private Double bid;
  private Double ask;
  private String marketName;
  private Double high;

  public BittrexV2Summary(
      @JsonProperty("OpenSellOrders") Integer openSellOrders,
      @JsonProperty("TimeStamp") String timeStamp,
      @JsonProperty("Last") Double last,
      @JsonProperty("Low") Double low,
      @JsonProperty("Created") String created,
      @JsonProperty("PrevDay") Double prevDay,
      @JsonProperty("OpenBuyOrders") Integer openBuyOrders,
      @JsonProperty("Volume") Double volume,
      @JsonProperty("BaseVolume") Double baseVolume,
      @JsonProperty("Bid") Double bid,
      @JsonProperty("Ask") Double ask,
      @JsonProperty("MarketName") String marketName,
      @JsonProperty("High") Double high) {
    this.openSellOrders = openSellOrders;
    this.timeStamp = LocalDateTime.parse(timeStamp);
    this.last = last;
    this.low = low;
    this.created = LocalDateTime.parse(created);
    this.prevDay = prevDay;
    this.openBuyOrders = openBuyOrders;
    this.volume = volume;
    this.baseVolume = baseVolume;
    this.bid = bid;
    this.ask = ask;
    this.marketName = marketName;
    this.high = high;
  }

  public Integer getOpenSellOrders() {
    return openSellOrders;
  }

  public void setOpenSellOrders(Integer openSellOrders) {
    this.openSellOrders = openSellOrders;
  }

  public LocalDateTime getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(LocalDateTime timeStamp) {
    this.timeStamp = timeStamp;
  }

  public Double getLast() {
    return last;
  }

  public void setLast(Double last) {
    this.last = last;
  }

  public Double getLow() {
    return low;
  }

  public void setLow(Double low) {
    this.low = low;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public Double getPrevDay() {
    return prevDay;
  }

  public void setPrevDay(Double prevDay) {
    this.prevDay = prevDay;
  }

  public Integer getOpenBuyOrders() {
    return openBuyOrders;
  }

  public void setOpenBuyOrders(Integer openBuyOrders) {
    this.openBuyOrders = openBuyOrders;
  }

  public Double getVolume() {
    return volume;
  }

  public void setVolume(Double volume) {
    this.volume = volume;
  }

  public Double getBaseVolume() {
    return baseVolume;
  }

  public void setBaseVolume(Double baseVolume) {
    this.baseVolume = baseVolume;
  }

  public Double getBid() {
    return bid;
  }

  public void setBid(Double bid) {
    this.bid = bid;
  }

  public Double getAsk() {
    return ask;
  }

  public void setAsk(Double ask) {
    this.ask = ask;
  }

  public String getMarketName() {
    return marketName;
  }

  public void setMarketName(String marketName) {
    this.marketName = marketName;
  }

  public Double getHigh() {
    return high;
  }

  public void setHigh(Double high) {
    this.high = high;
  }

  @Override
  public String toString() {
    return "BittrexV2Summary{"
        + "openSellOrders="
        + openSellOrders
        + ", timeStamp="
        + timeStamp
        + ", last="
        + last
        + ", low="
        + low
        + ", created="
        + created
        + ", prevDay="
        + prevDay
        + ", openBuyOrders="
        + openBuyOrders
        + ", volume="
        + volume
        + ", baseVolume="
        + baseVolume
        + ", bid="
        + bid
        + ", ask="
        + ask
        + ", marketName='"
        + marketName
        + '\''
        + ", high="
        + high
        + '}';
  }
}
