package org.knowm.xchange.upbit.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author interwater */
public class UpbitOrderBook {

  private final String market;
  private final Double timestamp;
  private final Double totalAskSize;
  private final Double totalBidSize;
  private final UpbitOrderBookData[] orderbookUnits;

  /**
   * @param market
   * @param timestamp
   * @param totalAskSize
   * @param totalBidSize
   * @param orderbookUnits
   */
  public UpbitOrderBook(
      @JsonProperty("market") String market,
      @JsonProperty("timestamp") Double timestamp,
      @JsonProperty("total_ask_size") Double totalAskSize,
      @JsonProperty("total_bid_size") Double totalBidSize,
      @JsonProperty("orderbook_units") UpbitOrderBookData[] orderbookUnits) {
    this.market = market;
    this.timestamp = timestamp;
    this.totalAskSize = totalAskSize;
    this.totalBidSize = totalBidSize;
    this.orderbookUnits = orderbookUnits;
  }

  public String getMarket() {
    return market;
  }

  public Double getTimestamp() {
    return timestamp;
  }

  public Double getTotalAskSize() {
    return totalAskSize;
  }

  public Double getTotalBidSize() {
    return totalBidSize;
  }

  public UpbitOrderBookData[] getOrderbookUnits() {
    return orderbookUnits;
  }
}
