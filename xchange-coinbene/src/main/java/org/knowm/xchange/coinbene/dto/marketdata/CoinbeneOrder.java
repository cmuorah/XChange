package org.knowm.xchange.coinbene.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinbeneOrder {
  private final Double price;
  private final Double quantity;

  public CoinbeneOrder(
      @JsonProperty("price") Double price, @JsonProperty("quantity") Double quantity) {
    this.price = price;
    this.quantity = quantity;
  }

  public Double getPrice() {
    return price;
  }

  public Double getQuantity() {
    return quantity;
  }

  @Override
  public String toString() {
    return "CoinbeneOrder{" + "price=" + price + ", quantity=" + quantity + '}';
  }
}
