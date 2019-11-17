package org.knowm.xchange.btcmarkets.dto.account;

/** @author Matija Mazi */
public class BTCMarketsBalance {

  private Double pendingFunds;

  private Double balance;

  private String currency;

  public Double getAvailable() {
    return pendingFunds != null && balance != null ? balance - (pendingFunds) : null;
  }

  public Double getPendingFunds() {
    return pendingFunds;
  }

  public Double getBalance() {
    return balance;
  }

  public String getCurrency() {
    return currency;
  }

  @Override
  public String toString() {
    return String.format(
        "BTCMarketsBalance{pendingFunds=%s, balance=%s, currency='%s'}",
        pendingFunds, balance, currency);
  }
}
