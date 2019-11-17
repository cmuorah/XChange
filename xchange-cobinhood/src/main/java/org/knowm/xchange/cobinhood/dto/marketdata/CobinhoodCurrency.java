package org.knowm.xchange.cobinhood.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CobinhoodCurrency {
  private final String symbol;
  private final String name;
  private final Double minUnit;
  private final Double depositFee;
  private final Double withdrawalFee;

  public CobinhoodCurrency(
      @JsonProperty("currency") String symbol,
      @JsonProperty("name") String name,
      @JsonProperty("min_unit") Double minUnit,
      @JsonProperty("deposit_fee") Double depositFee,
      @JsonProperty("withdrawal_fee") Double withdrawalFee) {
    this.symbol = symbol;
    this.name = name;
    this.minUnit = minUnit;
    this.depositFee = depositFee;
    this.withdrawalFee = withdrawalFee;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getName() {
    return name;
  }

  public Double getMinUnit() {
    return minUnit;
  }

  public Double getDepositFee() {
    return depositFee;
  }

  public Double getWithdrawalFee() {
    return withdrawalFee;
  }
}
