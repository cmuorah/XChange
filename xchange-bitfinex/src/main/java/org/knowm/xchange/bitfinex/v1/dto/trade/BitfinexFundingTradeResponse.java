package org.knowm.xchange.bitfinex.v1.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitfinexFundingTradeResponse {

  private final Double rate;
  private final Double period;
  private final Double amount;
  private final Double timestamp;
  private final String type;
  private final String tradeId;
  private final String offerId;

  /**
   * Constructor
   *
   * @param rate
   * @param amount
   * @param timestamp
   * @param period
   * @param type
   * @param tradeId
   * @param offerId
   */
  public BitfinexFundingTradeResponse(
      @JsonProperty("rate") final Double rate,
      @JsonProperty("period") final Double period,
      @JsonProperty("amount") final Double amount,
      @JsonProperty("timestamp") final Double timestamp,
      @JsonProperty("type") final String type,
      @JsonProperty("tid") final String tradeId,
      @JsonProperty("offer_id") final String offerId) {

    this.rate = rate;
    this.amount = amount;
    this.period = period;
    this.timestamp = timestamp;
    this.type = type;
    this.tradeId = tradeId;
    this.offerId = offerId;
  }

  public Double getRate() {
    return rate;
  }

  public Double getPeriod() {
    return period;
  }

  public Double getAmount() {
    return amount;
  }

  public Double getTimestamp() {
    return timestamp;
  }

  public String getType() {
    return type;
  }

  public String getTradeId() {
    return tradeId;
  }

  public String getOfferId() {
    return offerId;
  }

  @Override
  public String toString() {
    return "BitfinexFundingTradeResponse [rate="
        + rate
        + ", period="
        + period
        + ", amount="
        + amount
        + ", timestamp="
        + timestamp
        + ", type="
        + type
        + ", tradeId="
        + tradeId
        + ", offerId="
        + offerId
        + "]";
  }
}
