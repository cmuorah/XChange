package org.knowm.xchange.ccex.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CCEXBalance {

  private String Currency;
  private Double Balance;
  private Double Available;
  private Double Pending;
  private String CryptoAddress;

  public CCEXBalance(
      @JsonProperty("Currency") String currency,
      @JsonProperty("Balance") Double balance,
      @JsonProperty("Available") Double available,
      @JsonProperty("Pending") Double pending,
      @JsonProperty("CryptoAddress") String cryptoAddress) {
    super();
    Currency = currency;
    Balance = balance;
    Available = available;
    Pending = pending;
    CryptoAddress = cryptoAddress;
  }

  public String getCurrency() {
    return Currency;
  }

  public void setCurrency(String currency) {
    Currency = currency;
  }

  public Double getBalance() {
    return Balance;
  }

  public void setBalance(Double balance) {
    Balance = balance;
  }

  public Double getAvailable() {
    return Available;
  }

  public void setAvailable(Double available) {
    Available = available;
  }

  public Double getPending() {
    return Pending;
  }

  public void setPending(Double pending) {
    Pending = pending;
  }

  public String getCryptoAddress() {
    return CryptoAddress;
  }

  public void setCryptoAddress(String cryptoAddress) {
    CryptoAddress = cryptoAddress;
  }

  @Override
  public String toString() {
    return "CCEXBalance [Currency="
        + Currency
        + ", Balance="
        + Balance
        + ", Available="
        + Available
        + ", Pending="
        + Pending
        + ", CryptoAddress="
        + CryptoAddress
        + "]";
  }
}
