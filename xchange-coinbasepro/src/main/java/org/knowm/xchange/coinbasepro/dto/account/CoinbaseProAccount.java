package org.knowm.xchange.coinbasepro.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinbaseProAccount {
  private final String id;
  private final String currency;
  private final String profile_id;
  private final Double balance;
  private final Double hold;
  private final Double available;

  public CoinbaseProAccount(
      @JsonProperty("id") String id,
      @JsonProperty("currency") String currency,
      @JsonProperty("profile_id") String profile_id,
      @JsonProperty("balance") Double balance,
      @JsonProperty("hold") Double hold,
      @JsonProperty("available") Double available) {
    this.id = id;
    this.currency = currency;
    this.profile_id = profile_id;
    this.balance = balance;
    this.hold = hold;
    this.available = available;
  }

  public String getId() {
    return id;
  }

  public String getCurrency() {
    return currency;
  }

  public String getProfile_id() {
    return profile_id;
  }

  public Double getBalance() {
    return balance;
  }

  public Double getHold() {
    return hold;
  }

  public Double getAvailable() {
    return available;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CoinbaseExAccount [id=");
    builder.append(id);
    builder.append(", currency=");
    builder.append(currency);
    builder.append(", profile_id=");
    builder.append(profile_id);
    builder.append(", balance=");
    builder.append(balance);
    builder.append(", hold=");
    builder.append(hold);
    builder.append(", available=");
    builder.append(available);
    builder.append("]");
    return builder.toString();
  }
}
