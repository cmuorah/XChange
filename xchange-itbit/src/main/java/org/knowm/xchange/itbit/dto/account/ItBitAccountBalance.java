package org.knowm.xchange.itbit.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItBitAccountBalance {

  private final Double availableBalance;
  private final Double totalBalance;
  private final String currency;

  public ItBitAccountBalance(
      @JsonProperty("availableBalance") Double availableBalance,
      @JsonProperty("totalBalance") Double totalBalance,
      @JsonProperty("currency") String currency) {

    this.availableBalance = availableBalance;
    this.totalBalance = totalBalance;
    this.currency = currency;
  }

  public Double getAvailableBalance() {

    return availableBalance;
  }

  public Double getTotalBalance() {

    return totalBalance;
  }

  public String getCurrency() {

    return currency;
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    builder.append("ItBitAccountBalance [availableBalance=");
    builder.append(availableBalance);
    builder.append(", totalBalance=");
    builder.append(totalBalance);
    builder.append(", currency=");
    builder.append(currency);
    builder.append("]");
    return builder.toString();
  }
}
