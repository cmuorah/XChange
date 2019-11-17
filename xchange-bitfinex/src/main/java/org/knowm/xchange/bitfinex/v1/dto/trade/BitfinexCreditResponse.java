package org.knowm.xchange.bitfinex.v1.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitfinexCreditResponse {

  private final long id;
  private final String currency;
  private final String status;
  private final Double rate;
  private final int period;
  private final Double amount;
  private final Double timestamp;

  public BitfinexCreditResponse(
      @JsonProperty("id") long id,
      @JsonProperty("currency") String currency,
      @JsonProperty("status") String status,
      @JsonProperty("rate") Double rate,
      @JsonProperty("period") int period,
      @JsonProperty("amount") Double amount,
      @JsonProperty("timestamp") Double timestamp) {

    this.id = id;
    this.currency = currency;
    this.status = status;
    this.rate = rate;
    this.period = period;
    this.amount = amount;
    this.timestamp = timestamp;
  }

  public long getId() {

    return id;
  }

  public String getCurrency() {

    return currency;
  }

  public String getStatus() {

    return status;
  }

  public Double getRate() {

    return rate;
  }

  public int getPeriod() {

    return period;
  }

  public Double getAmount() {

    return amount;
  }

  public Double getTimestamp() {

    return timestamp;
  }

  @Override
  public String toString() {

    return "BitfinexCreditResponse [id="
        + id
        + ", currency="
        + currency
        + ", status="
        + status
        + ", rate="
        + rate
        + ", period="
        + period
        + ", amount="
        + amount
        + ", timestamp="
        + timestamp
        + "]";
  }
}
