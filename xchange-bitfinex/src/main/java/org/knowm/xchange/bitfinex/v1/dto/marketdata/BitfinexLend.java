package org.knowm.xchange.bitfinex.v1.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitfinexLend {

  private final Double rate;
  private final Double amountLent;
  private final long timestamp;

  /**
   * Constructor
   *
   * @param rate
   * @param amountLent
   * @param timestamp
   */
  public BitfinexLend(
      @JsonProperty("rate") Double rate,
      @JsonProperty("amount_lent") Double amountLent,
      @JsonProperty("timestamp") long timestamp) {

    this.rate = rate;
    this.amountLent = amountLent;
    this.timestamp = timestamp;
  }

  public Double getRate() {

    return rate;
  }

  public Double getAmountLent() {

    return amountLent;
  }

  public long getTimestamp() {

    return timestamp;
  }

  @Override
  public String toString() {

    return "BitfinexLend [rate="
        + rate
        + ", amountLent="
        + amountLent
        + ", timestamp="
        + timestamp
        + "]";
  }
}
