package org.knowm.xchange.upbit.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author interwater */
public class UpbitOrderBookData {

  private final Double askPrice;
  private final Double bidPrice;
  private final Double askSize;
  private final Double bidSize;

  /**
   * @param askPrice
   * @param bidPrice
   * @param askSize
   * @param bidSize
   */
  public UpbitOrderBookData(
      @JsonProperty("ask_price") Double askPrice,
      @JsonProperty("bid_price") Double bidPrice,
      @JsonProperty("ask_size") Double askSize,
      @JsonProperty("bid_size") Double bidSize) {
    this.askPrice = askPrice;
    this.bidPrice = bidPrice;
    this.askSize = askSize;
    this.bidSize = bidSize;
  }

  public Double getAskPrice() {
    return askPrice;
  }

  public Double getBidPrice() {
    return bidPrice;
  }

  public Double getAskSize() {
    return askSize;
  }

  public Double getBidSize() {
    return bidSize;
  }

  @Override
  public String toString() {

    return "UpbitOrderBook{"
        + "ask_price="
        + askPrice
        + ", ask_size="
        + askSize
        + ", bid_price="
        + bidPrice
        + ", bid_size="
        + bidSize
        + "}";
  }
}
