package org.knowm.xchange.okcoin.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OkcoinFuturesFundsFixed {

  private final Double balance;
  private final OkcoinFuturesFunds[] contracts;
  private final Double rights;

  public OkcoinFuturesFundsFixed(
      @JsonProperty("balance") Double balance,
      @JsonProperty("contracts") OkcoinFuturesFunds[] contracts,
      @JsonProperty("rights") Double rights) {

    this.balance = balance;
    this.contracts = contracts;
    this.rights = rights;
  }

  public Double getBalance() {
    return balance;
  }

  public OkcoinFuturesFunds[] getContracts() {
    return contracts;
  }

  public Double getRights() {
    return rights;
  }
}
