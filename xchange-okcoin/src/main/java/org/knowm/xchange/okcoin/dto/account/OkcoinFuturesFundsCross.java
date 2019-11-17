package org.knowm.xchange.okcoin.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OkcoinFuturesFundsCross {

  private final Double accountRights;
  private final Double keepDeposits;
  private final Double profitReal;
  private final Double profitUnreal;
  private final int riskRate;

  public OkcoinFuturesFundsCross(
      @JsonProperty("account_rights") Double accountRights,
      @JsonProperty("keep_deposit") Double keepDeposits,
      @JsonProperty("profit_real") Double profitReal,
      @JsonProperty("profit_unreal") Double profitUnreal,
      @JsonProperty("risk_rate") int riskRate) {

    this.accountRights = accountRights;
    this.keepDeposits = keepDeposits;
    this.profitReal = profitReal;
    this.profitUnreal = profitUnreal;
    this.riskRate = riskRate;
  }

  public Double getAccountRights() {

    return accountRights;
  }

  public Double getKeepDeposits() {

    return keepDeposits;
  }

  public Double getProfitReal() {

    return profitReal;
  }

  public Double getProfitUnreal() {

    return profitUnreal;
  }

  public int getRiskRate() {

    return riskRate;
  }
}
