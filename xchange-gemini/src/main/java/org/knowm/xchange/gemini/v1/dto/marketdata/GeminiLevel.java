package org.knowm.xchange.gemini.v1.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeminiLevel {

  private final Double price;
  private final Double amount;
  private final Double timestamp;

  /**
   * Constructor
   *
   * @param price
   * @param amount
   * @param timestamp
   */
  public GeminiLevel(
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("timestamp") Double timestamp) {

    this.price = price;
    this.amount = amount;
    this.timestamp = timestamp;
  }

  public Double getPrice() {

    return price;
  }

  public Double getAmount() {

    return amount;
  }

  public Double getTimestamp() {

    return timestamp;
  }

  @Override
  public String toString() {

    return "GeminiLevel [price=" + price + ", amount=" + amount + ", timestamp=" + timestamp + "]";
  }
}
