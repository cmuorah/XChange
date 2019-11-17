package org.knowm.xchange.upbit.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpbitBalance {
  private final String currency;
  private final Double balance;
  private final Double locked;
  private final Double avgKrwBuyPrice;
  private final boolean modified;

  public UpbitBalance(
      @JsonProperty("currency") String currency,
      @JsonProperty("balance") Double balance,
      @JsonProperty("locked") Double locked,
      @JsonProperty("avg_krw_buy_price") Double avgKrwBuyPrice,
      @JsonProperty("modified") boolean modified) {
    this.currency = currency;
    this.balance = balance;
    this.locked = locked;
    this.avgKrwBuyPrice = avgKrwBuyPrice;
    this.modified = modified;
  }

  public String getCurrency() {
    return currency;
  }

  public Double getBalance() {
    return balance;
  }

  public Double getLocked() {
    return locked;
  }

  public Double getAvgKrwBuyPrice() {
    return avgKrwBuyPrice;
  }

  public boolean isModified() {
    return modified;
  }
}
