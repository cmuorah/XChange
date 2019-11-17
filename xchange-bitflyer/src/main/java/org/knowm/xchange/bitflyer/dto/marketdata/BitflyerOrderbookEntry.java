package org.knowm.xchange.bitflyer.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitflyerOrderbookEntry {

  private final Double price;
  private final Double size;

  public BitflyerOrderbookEntry(
      @JsonProperty("price") Double price, @JsonProperty("size") Double size) {

    this.price = price;
    this.size = size;
  }

  public Double getPrice() {
    return price;
  }

  public Double getSize() {
    return size;
  }
}
