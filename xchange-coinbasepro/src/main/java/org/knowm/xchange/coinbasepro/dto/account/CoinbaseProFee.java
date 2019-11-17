package org.knowm.xchange.coinbasepro.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinbaseProFee {
  private final Double makerRate;
  private final Double takerRate;

  public CoinbaseProFee(
      @JsonProperty("maker_fee_rate") Double makerRate,
      @JsonProperty("taker_fee_rate") Double takerRate) {
    this.makerRate = makerRate;
    this.takerRate = takerRate;
  }

  public Double getMakerRate() {
    return makerRate;
  }

  public Double getTakerRate() {
    return takerRate;
  }
}
