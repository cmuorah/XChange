package org.knowm.xchange.coinex.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinexBalanceInfo {

  private final Double available;
  private final Double frozen;

  public CoinexBalanceInfo(
      @JsonProperty("available") Double available, @JsonProperty("frozen") Double frozen) {
    this.available = available;
    this.frozen = frozen;
  }

  public Double getAvailable() {
    return available;
  }

  public Double getFrozen() {
    return frozen;
  }

  @Override
  public String toString() {
    return "CoinexBalanceInfo{" + "available=" + available + ", frozen=" + frozen + '}';
  }
}
