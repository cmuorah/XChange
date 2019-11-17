package org.knowm.xchange.cobinhood.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CobinhoodCoinBalance {
  private final String currency;
  private final Double totalAmount;
  private final Double onOrderAmount;

  public CobinhoodCoinBalance(
      @JsonProperty("currency") String currency,
      @JsonProperty("total") Double totalAmount,
      @JsonProperty("on_order") Double onOrderAmount) {
    this.currency = currency;
    this.totalAmount = totalAmount;
    this.onOrderAmount = onOrderAmount;
  }

  public String getCurrency() {
    return currency;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public Double getOnOrderAmount() {
    return onOrderAmount;
  }

  @Override
  public String toString() {
    return "CobinhoodCoinBalance{"
        + "currency='"
        + currency
        + '\''
        + ", totalAmount="
        + totalAmount
        + ", onOrderAmount="
        + onOrderAmount
        + '}';
  }
}
