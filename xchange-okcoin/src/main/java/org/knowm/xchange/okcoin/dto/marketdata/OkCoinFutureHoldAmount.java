package org.knowm.xchange.okcoin.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OkCoinFutureHoldAmount {
  private final Double amount;
  private final String contractName;

  public OkCoinFutureHoldAmount(
      @JsonProperty("amount") Double amount, @JsonProperty("contract_name") String contractName) {
    this.amount = amount;
    this.contractName = contractName;
  }

  public Double getAmount() {
    return amount;
  }

  public String getContractName() {
    return contractName;
  }

  @Override
  public String toString() {
    return "OkCoinFutureHoldAmount{"
        + "amount="
        + amount
        + ", contractName='"
        + contractName
        + '\''
        + '}';
  }
}
