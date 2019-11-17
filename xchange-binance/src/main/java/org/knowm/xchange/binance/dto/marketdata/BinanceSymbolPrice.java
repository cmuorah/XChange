package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class BinanceSymbolPrice {

  public final String symbol;
  public final Double price;

  public BinanceSymbolPrice(
      @JsonProperty("symbol") String symbol, @JsonProperty("price") Double price) {
    this.symbol = symbol;
    this.price = price;
  }
}
