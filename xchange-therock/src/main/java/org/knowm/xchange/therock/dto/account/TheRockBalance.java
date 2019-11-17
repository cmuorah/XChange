package org.knowm.xchange.therock.dto.account;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TheRockBalance {

  private String currency;

  private Double balance;

  private Double tradingBalance;

  public String getCurrency() {
    return currency;
  }

  public Double getBalance() {
    return balance;
  }

  public Double getTradingBalance() {
    return tradingBalance;
  }

  @Override
  public String toString() {
    return String.format(
        "TheRockBalance{currency='%s', balance=%s, trandingBalance=%s}",
        currency, balance, tradingBalance);
  }
}
