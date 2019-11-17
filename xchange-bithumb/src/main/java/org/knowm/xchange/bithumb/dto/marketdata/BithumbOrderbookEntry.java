package org.knowm.xchange.bithumb.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BithumbOrderbookEntry {

  private final Double quantity;
  private final Double price;

  public BithumbOrderbookEntry(
      @JsonProperty("quantity") Double quantity, @JsonProperty("price") Double price) {
    this.quantity = quantity;
    this.price = price;
  }

  public Double getQuantity() {
    return quantity;
  }

  public Double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "BithumbOrderbookEntry{" + "quantity=" + quantity + ", price=" + price + '}';
  }
}
