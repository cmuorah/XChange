package org.knowm.xchange.bitfinex.v1.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitfinexLendLevel {

  private final Double rate;
  private final Double amount;
  private final int period;
  private final float timestamp;
  private final String frr;

  /**
   * Constructor
   *
   * @param rate
   * @param amount
   * @param period
   * @param timestamp
   * @param frr
   */
  public BitfinexLendLevel(
      @JsonProperty("rate") Double rate,
      @JsonProperty("amount") Double amount,
      @JsonProperty("period") int period,
      @JsonProperty("timestamp") float timestamp,
      @JsonProperty("frr") String frr) {

    this.rate = rate;
    this.amount = amount;
    this.period = period;
    this.timestamp = timestamp;
    this.frr = frr;
  }

  public Double getRate() {

    return rate;
  }

  public Double getAmount() {

    return amount;
  }

  public int getPeriod() {

    return period;
  }

  public float getTimestamp() {

    return timestamp;
  }

  public String getFrr() {

    return frr;
  }

  @Override
  public String toString() {

    return "BitfinexLendLevel [rate="
        + rate
        + ", amount="
        + amount
        + ", period="
        + period
        + ", timestamp="
        + timestamp
        + ", frr="
        + frr
        + "]";
  }
}
