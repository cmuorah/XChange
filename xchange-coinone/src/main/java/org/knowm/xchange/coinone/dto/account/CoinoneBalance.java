package org.knowm.xchange.coinone.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinoneBalance {

  private final Double avail;
  private final Double balance;

  public CoinoneBalance(
      @JsonProperty("avail") String avail, @JsonProperty("balance") String balance) {
    this.avail = new Double(avail);
    this.balance = new Double(balance);
  }

  public Double getAvail() {
    return avail;
  }

  public Double getBalance() {
    return balance;
  }
}
