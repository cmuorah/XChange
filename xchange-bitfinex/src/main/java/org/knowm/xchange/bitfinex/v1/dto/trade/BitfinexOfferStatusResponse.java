package org.knowm.xchange.bitfinex.v1.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitfinexOfferStatusResponse {

  private final long id;
  private final String currency;
  private final Double rate;
  private final int period;
  private final String direction;
  private final String type;
  private final Double timestamp;
  private final boolean isLive;
  private final boolean isCancelled;
  private final Double originalAmount;
  private final Double remainingAmount;
  private final Double executedAmount;

  public BitfinexOfferStatusResponse(
      @JsonProperty("id") long id,
      @JsonProperty("currency") String currency,
      @JsonProperty("rate") Double rate,
      @JsonProperty("period") int period,
      @JsonProperty("direction") String direction,
      @JsonProperty("type") String type,
      @JsonProperty("timestamp") Double timestamp,
      @JsonProperty("is_live") boolean isLive,
      @JsonProperty("is_cancelled") boolean isCancelled,
      @JsonProperty("original_amount") Double originalAmount,
      @JsonProperty("remaining_amount") Double remainingAmount,
      @JsonProperty("executed_amount") Double executedAmount) {

    this.id = id;
    this.currency = currency;
    this.rate = rate;
    this.period = period;
    this.direction = direction;
    this.type = type;
    this.timestamp = timestamp;
    this.isLive = isLive;
    this.isCancelled = isCancelled;
    this.originalAmount = originalAmount;
    this.remainingAmount = remainingAmount;
    this.executedAmount = executedAmount;
  }

  public long getId() {

    return id;
  }

  public String getCurrency() {

    return currency;
  }

  public Double getRate() {

    return rate;
  }

  public int getPeriod() {

    return period;
  }

  public String getDirection() {

    return direction;
  }

  public String getType() {

    return type;
  }

  public Double getTimestamp() {

    return timestamp;
  }

  public boolean isLive() {

    return isLive;
  }

  public boolean isCancelled() {

    return isCancelled;
  }

  public Double getOriginalAmount() {

    return originalAmount;
  }

  public Double getRemainingAmount() {

    return remainingAmount;
  }

  public Double getExecutedAmount() {

    return executedAmount;
  }

  @Override
  public String toString() {

    return "BitfinexOfferStatusResponse [id="
        + id
        + ", currency="
        + currency
        + ", rate="
        + rate
        + ", period="
        + period
        + ", direction="
        + direction
        + ", type="
        + type
        + ", timestamp="
        + timestamp
        + ", isLive="
        + isLive
        + ", isCancelled="
        + isCancelled
        + ", originalAmount="
        + originalAmount
        + ", remainingAmount="
        + remainingAmount
        + ", executedAmount="
        + executedAmount
        + "]";
  }
}
