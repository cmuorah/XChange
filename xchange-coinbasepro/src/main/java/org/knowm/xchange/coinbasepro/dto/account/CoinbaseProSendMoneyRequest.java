package org.knowm.xchange.coinbasepro.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinbaseProSendMoneyRequest {

  @JsonProperty("type")
  private final String type = "send";

  @JsonProperty("to")
  private final String to;

  @JsonProperty("amount")
  private final Double amount;

  @JsonProperty("currency")
  private final String currency;

  public CoinbaseProSendMoneyRequest(String to, Double amount, String currency) {
    this.to = to;
    this.amount = amount;
    this.currency = currency;
  }

  public String getType() {
    return type;
  }

  public String getTo() {
    return to;
  }

  public Double getAmount() {
    return amount;
  }

  public String getCurrency() {
    return currency;
  }

  @Override
  public String toString() {
    return "CoinbaseExSendMoneyRequest{"
        + "type='"
        + type
        + '\''
        + ", to='"
        + to
        + '\''
        + ", amount="
        + amount
        + ", currency='"
        + currency
        + '\''
        + '}';
  }
}
