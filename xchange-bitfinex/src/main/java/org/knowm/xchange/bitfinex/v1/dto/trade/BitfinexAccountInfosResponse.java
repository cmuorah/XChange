package org.knowm.xchange.bitfinex.v1.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitfinexAccountInfosResponse {

  private final Double makerFees;
  private final Double takerFees;
  private final BitfinexFee[] fees;

  public BitfinexAccountInfosResponse(
      @JsonProperty("maker_fees") Double makerFees,
      @JsonProperty("taker_fees") Double takerFees,
      @JsonProperty("fees") BitfinexFee[] fees) {
    this.makerFees = makerFees;
    this.takerFees = takerFees;
    this.fees = fees;
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    builder.append("BitfinexAccountInfosResponse [makerFees=");
    builder.append(makerFees);
    builder.append(", takerFees=");
    builder.append(takerFees);
    builder.append("]");
    return builder.toString();
  }

  public Double getMakerFees() {
    return makerFees;
  }

  public Double getTakerFees() {
    return takerFees;
  }

  public BitfinexFee[] getFees() {
    return fees;
  }
}
