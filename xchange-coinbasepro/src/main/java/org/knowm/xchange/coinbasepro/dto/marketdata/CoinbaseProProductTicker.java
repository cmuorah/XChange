package org.knowm.xchange.coinbasepro.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinbaseProProductTicker {

  private final String tradeId;
  private final Double price;
  private final Double size;
  private final Double bid;
  private final Double ask;
  private final Double volume;
  private final String time;

  public CoinbaseProProductTicker(
      @JsonProperty("trade_id") String tradeId,
      @JsonProperty("price") Double price,
      @JsonProperty("size") Double size,
      @JsonProperty("bid") Double bid,
      @JsonProperty("ask") Double ask,
      @JsonProperty("volume") Double volume,
      @JsonProperty("time") String time) {

    this.tradeId = tradeId;
    this.price = price;
    this.size = size;
    this.bid = bid;
    this.ask = ask;
    this.volume = volume;
    this.time = time;
  }

  public String getTradeId() {
    return tradeId;
  }

  public Double getPrice() {
    return price;
  }

  public Double getSize() {
    return size;
  }

  public Double getBid() {
    return bid;
  }

  public Double getAsk() {
    return ask;
  }

  public Double getVolume() {
    return volume;
  }

  public String getTime() {
    return time;
  }

  @Override
  public String toString() {
    return "CoinbaseProProductTicker [tradeId="
        + tradeId
        + ", price="
        + price
        + ", size="
        + size
        + ", bid="
        + bid
        + ", ask="
        + ask
        + ", volume="
        + volume
        + ", time="
        + time
        + "]";
  }
}
