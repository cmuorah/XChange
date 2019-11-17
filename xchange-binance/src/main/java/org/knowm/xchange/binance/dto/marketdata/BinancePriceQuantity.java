package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class BinancePriceQuantity {

  public final String symbol;
  public final Double bidPrice;
  public final Double bidQty;
  public final Double askPrice;
  public final Double askQty;

  public BinancePriceQuantity(
      @JsonProperty("symbol") String symbol,
      @JsonProperty("bidPrice") Double bidPrice,
      @JsonProperty("bidQty") Double bidQty,
      @JsonProperty("askPrice") Double askPrice,
      @JsonProperty("askQty") Double askQty) {
    this.symbol = symbol;
    this.bidPrice = bidPrice;
    this.bidQty = bidQty;
    this.askPrice = askPrice;
    this.askQty = askQty;
  }
}
