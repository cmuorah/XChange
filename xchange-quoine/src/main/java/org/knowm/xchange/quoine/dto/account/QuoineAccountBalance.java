package org.knowm.xchange.quoine.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class QuoineAccountBalance {

  private final String currency;
  private final Double balance;

  public QuoineAccountBalance(
      @JsonProperty("currency") String currency, @JsonProperty("balance") Double balance) {
    this.currency = currency;
    this.balance = balance;
  }

  public String getCurrency() {
    return currency;
  }

  public Double getBalance() {
    return balance;
  }

  @Override
  public String toString() {
    return "QuoineAccountBalance [currency=" + currency + ", balance=" + balance + "]";
  }
}
