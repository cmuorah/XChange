package org.knowm.xchange.bitfinex.v1.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitfinexFee {
  private final String pairs;
  private final Double makerFees;
  private final Double takerFees;

  public BitfinexFee(
      @JsonProperty("pairs") String pairs,
      @JsonProperty("maker_fees") Double makerFees,
      @JsonProperty("taker_fees") Double takerFees) {
    this.pairs = pairs;
    this.makerFees = makerFees;
    this.takerFees = takerFees;
  }

  public String getPairs() {
    return pairs;
  }

  public Double getMakerFees() {
    return makerFees;
  }

  public Double getTakerFees() {
    return takerFees;
  }
}
