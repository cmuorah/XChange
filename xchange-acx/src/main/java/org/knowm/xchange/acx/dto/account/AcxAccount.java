package org.knowm.xchange.acx.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AcxAccount {
  public final String currency;
  /** Account balance, exclude locked funds */
  public final Double balance;
  /** locked funds */
  public final Double locked;

  public AcxAccount(
      @JsonProperty("currency") String currency,
      @JsonProperty("balance") Double balance,
      @JsonProperty("locked") Double locked) {
    this.currency = currency;
    this.balance = balance;
    this.locked = locked;
  }
}
