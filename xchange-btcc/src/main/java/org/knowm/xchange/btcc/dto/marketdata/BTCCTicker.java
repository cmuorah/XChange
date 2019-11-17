package org.knowm.xchange.btcc.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BTCCTicker {

  @JsonProperty("BidPrice")
  private Double bidPrice;

  @JsonProperty("AskPrice")
  private Double askPrice;

  @JsonProperty("Open")
  private Double open;

  @JsonProperty("High")
  private Double high;

  @JsonProperty("Low")
  private Double low;

  @JsonProperty("Last")
  private Double last;

  @JsonProperty("LastQuantity")
  private Double lastQuantity;

  @JsonProperty("PrevCls")
  private Double prevClose;

  @JsonProperty("Volume")
  private Double volume;

  @JsonProperty("Volume24H")
  private Double volume24H;

  @JsonProperty("Timestamp")
  private long timestamp;

  @JsonProperty("ExecutionLimitDown")
  private Double executionLimitDown;

  @JsonProperty("ExecutionLimitUp")
  private Double executionLimitUp;

  public Double getBidPrice() {
    return bidPrice;
  }

  public void setBidPrice(Double bidPrice) {
    this.bidPrice = bidPrice;
  }

  public Double getAskPrice() {
    return askPrice;
  }

  public void setAskPrice(Double askPrice) {
    this.askPrice = askPrice;
  }

  public Double getOpen() {
    return open;
  }

  public void setOpen(Double open) {
    this.open = open;
  }

  public Double getHigh() {
    return high;
  }

  public void setHigh(Double high) {
    this.high = high;
  }

  public Double getLow() {
    return low;
  }

  public void setLow(Double low) {
    this.low = low;
  }

  public Double getLast() {
    return last;
  }

  public void setLast(Double last) {
    this.last = last;
  }

  public Double getLastQuantity() {
    return lastQuantity;
  }

  public void setLastQuantity(Double lastQuantity) {
    this.lastQuantity = lastQuantity;
  }

  public Double getPrevClose() {
    return prevClose;
  }

  public void setPrevClose(Double precClose) {
    this.prevClose = precClose;
  }

  public Double getVolume() {
    return volume;
  }

  public void setVolume(Double volume) {
    this.volume = volume;
  }

  public Double getVolume24H() {
    return volume24H;
  }

  public void setVolume24H(Double volume24H) {
    this.volume24H = volume24H;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public Double getExecutionLimitDown() {
    return executionLimitDown;
  }

  public void setExecutionLimitDown(Double executionLimitDown) {
    this.executionLimitDown = executionLimitDown;
  }

  public Double getExecutionLimitUp() {
    return executionLimitUp;
  }

  public void setExecutionLimitUp(Double executionLimitUp) {
    this.executionLimitUp = executionLimitUp;
  }

  @Override
  public String toString() {
    return "BTCCTicker{"
        + "bidPrice="
        + bidPrice
        + ", askPrice="
        + askPrice
        + ", open="
        + open
        + ", high="
        + high
        + ", low="
        + low
        + ", last="
        + last
        + ", lastQuantity="
        + lastQuantity
        + ", prevClose="
        + prevClose
        + ", volume="
        + volume
        + ", volume24H="
        + volume24H
        + ", timestamp="
        + timestamp
        + ", executionLimitDown="
        + executionLimitDown
        + ", executionLimitUp="
        + executionLimitUp
        + '}';
  }
}
