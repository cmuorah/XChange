package org.knowm.xchange.bitfinex.v1.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitfinexBalanceHistoryResponse {

  @JsonProperty("currency")
  private String currency;

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("balance")
  private Double balance;

  @JsonProperty("description")
  private String description;

  @JsonProperty("timestamp")
  private Double timestamp;

  public BitfinexBalanceHistoryResponse(
      @JsonProperty("currency") String currency,
      @JsonProperty("amount") Double amount,
      @JsonProperty("balance") Double balance,
      @JsonProperty("description") String description,
      @JsonProperty("timestamp") Double timestamp) {

    this.currency = currency;
    this.balance = balance;
    this.amount = amount;
    this.description = description;
    this.timestamp = timestamp;
  }

  public String getCurrency() {
    return currency;
  }

  public Double getAmount() {
    return amount;
  }

  public Double getBalance() {
    return balance;
  }

  public String getDescription() {
    return description;
  }

  public Double getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {

    final StringBuilder builder = new StringBuilder();
    builder.append("BitfinexPastTransactionsResponse [currency=");
    builder.append(currency);
    builder.append(", amount=");
    builder.append(amount);
    builder.append(", balance=");
    builder.append(balance);
    builder.append(", description=");
    builder.append(description);
    builder.append(", timestamp=");
    builder.append(timestamp);
    builder.append("]");
    return builder.toString();
  }
}
