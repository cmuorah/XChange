package org.knowm.xchange.paymium.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymiumMarketOrder {

  private final String currency;
  private final long timestamp;
  private final Double price;
  private final Double amount;

  public PaymiumMarketOrder(
      @JsonProperty("currency") String currency,
      @JsonProperty("timestamp") long timestamp,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount) {

    this.currency = currency;
    this.timestamp = timestamp;
    this.price = price;
    this.amount = amount;
  }

  public String getCurrency() {

    return currency;
  }

  public long getTimestamp() {

    return timestamp;
  }

  public Double getPrice() {

    return price;
  }

  public Double getAmount() {

    return amount;
  }

  @Override
  public String toString() {

    return "PaymiumMarketOrder{"
        + "currency='"
        + currency
        + '\''
        + ", timestamp="
        + timestamp
        + ", price="
        + price
        + ", amount="
        + amount
        + '}';
  }
}
