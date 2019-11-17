package org.knowm.xchange.bittrex.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BittrexBalance {

  private Double available;
  private Double balance;
  private String cryptoAddress;
  private String currency;
  private Double pending;
  private boolean requested;
  private String uuid;

  public BittrexBalance(
      @JsonProperty("Available") Double available,
      @JsonProperty("Balance") Double balance,
      @JsonProperty("CryptoAddress") String cryptoAddress,
      @JsonProperty("Currency") String currency,
      @JsonProperty("Pending") Double pending,
      @JsonProperty("Requested") boolean requested,
      @JsonProperty("Uuid") String uuid) {

    super();
    this.available = available;
    this.balance = balance;
    this.cryptoAddress = cryptoAddress;
    this.currency = currency;
    this.pending = pending;
    this.requested = requested;
    this.uuid = uuid;
  }

  public Double getAvailable() {

    return available;
  }

  public void setAvailable(Double available) {

    this.available = available;
  }

  public Double getBalance() {

    return balance;
  }

  public void setBalance(Double balance) {

    this.balance = balance;
  }

  public String getCryptoAddress() {

    return cryptoAddress;
  }

  public void setCryptoAddress(String cryptoAddress) {

    this.cryptoAddress = cryptoAddress;
  }

  public String getCurrency() {

    return currency;
  }

  public void setCurrency(String currency) {

    this.currency = currency;
  }

  public Double getPending() {

    return pending;
  }

  public void setPending(Double pending) {

    this.pending = pending;
  }

  public boolean isRequested() {

    return requested;
  }

  public void setRequested(boolean requested) {

    this.requested = requested;
  }

  public String getUuid() {

    return uuid;
  }

  public void setUuid(String uuid) {

    this.uuid = uuid;
  }

  @Override
  public String toString() {

    return "Bittrexbalance [available="
        + available
        + ", balance="
        + balance
        + ", cryptoAddress="
        + cryptoAddress
        + ", currency="
        + currency
        + ", pending="
        + pending
        + ", requested="
        + requested
        + ", uuid="
        + uuid
        + "]";
  }
}
