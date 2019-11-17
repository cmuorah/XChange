package org.knowm.xchange.bittrex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BittrexTicker {

  private Double bid;
  private Double ask;
  private Double last;

  public BittrexTicker(
      @JsonProperty("Bid") Double bid,
      @JsonProperty("Ask") Double ask,
      @JsonProperty("Last") Double last) {

    this.bid = bid;
    this.ask = ask;
    this.last = last;
  }

  public Double getBid() {
    return bid;
  }

  public Double getAsk() {
    return ask;
  }

  public Double getLast() {
    return last;
  }

  @Override
  public String toString() {

    return "BittrexTicker [bid=" + bid + ", ask= " + ask + ", last=" + last + "]";
  }
}
