package org.knowm.xchange.bittrex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BittrexLevel {

  private final Double rate;
  private final Double quantity;

  /**
   * Constructor
   *
   * @param rate
   * @param quantity
   */
  public BittrexLevel(
      @JsonProperty("Rate") Double rate, @JsonProperty("Quantity") Double quantity) {

    this.rate = rate;
    this.quantity = quantity;
  }

  public Double getPrice() {

    return rate;
  }

  public Double getAmount() {

    return quantity;
  }

  @Override
  public String toString() {

    return "BittrexLevel [rate=" + rate + ", quantity=" + quantity + "]";
  }
}
