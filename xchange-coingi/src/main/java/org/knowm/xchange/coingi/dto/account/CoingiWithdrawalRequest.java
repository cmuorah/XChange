package org.knowm.xchange.coingi.dto.account;

import org.knowm.xchange.coingi.dto.CoingiAuthenticatedRequest;

public class CoingiWithdrawalRequest extends CoingiAuthenticatedRequest {
  private String currency;
  private Double amount;
  private String address;

  public String getCurrency() {
    return currency;
  }

  public CoingiWithdrawalRequest setCurrency(String currency) {
    this.currency = currency;
    return this;
  }

  public Double getAmount() {
    return amount;
  }

  public CoingiWithdrawalRequest setAmount(Double amount) {
    this.amount = amount;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public CoingiWithdrawalRequest setAddress(String address) {
    this.address = address;
    return this;
  }
}
