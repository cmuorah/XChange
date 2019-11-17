package org.knowm.xchange.coindeal.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoindealOrderBookEntry {

  @JsonProperty("price")
  private final Double price;

  @JsonProperty("amount")
  private final Double amount;

  public CoindealOrderBookEntry(
      @JsonProperty("price") Double price, @JsonProperty("amount") Double amount) {
    this.price = price;
    this.amount = amount;
  }

  public Double getPrice() {
    return price;
  }

  public Double getAmount() {
    return amount;
  }
}
