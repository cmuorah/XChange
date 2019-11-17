package org.knowm.xchange.coinsuper.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinsuperBalance {

  private final String asset;

  private final Double balance;

  private final Double frozen;

  private final int state;

  public CoinsuperBalance(
      @JsonProperty("asset") String asset,
      @JsonProperty("balance") Double balance,
      @JsonProperty("frozen") Double frozen,
      @JsonProperty("state") int state) {
    super();
    this.asset = asset;
    this.balance = balance;
    this.frozen = frozen;
    this.state = state;
  }

  public String getAsset() {
    return asset;
  }

  public Double getBalance() {
    return balance;
  }

  public Double getFrozen() {
    return frozen;
  }

  public int getState() {
    return state;
  }
}
