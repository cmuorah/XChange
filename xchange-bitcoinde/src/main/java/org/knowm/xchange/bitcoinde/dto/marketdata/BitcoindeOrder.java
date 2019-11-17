package org.knowm.xchange.bitcoinde.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitcoindeOrder {

  private final Double price;
  private final Double amount;

  public BitcoindeOrder(
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

  @Override
  public String toString() {
    return "BitcoindeOrder{" + "price=" + price + ", amount=" + amount + '}';
  }
}
