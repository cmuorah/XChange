package org.knowm.xchange.okcoin.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OkcoinFuturesFunds {

  private final Double available;
  private final Double balance;
  private final Double bond;
  private final Long contractId;
  private final String contratctType;
  private final Double freeze;
  private final Integer profit;
  private final Integer unprofit;

  public OkcoinFuturesFunds(
      @JsonProperty("available") Double available,
      @JsonProperty("balance") Double balance,
      @JsonProperty("bond") Double bond,
      @JsonProperty("contract_id") Long contractId,
      @JsonProperty("contratct_type") String contratctType,
      @JsonProperty("freeze") Double freeze,
      @JsonProperty("profit") Integer profit,
      @JsonProperty("unprofit") Integer unprofit) {
    this.available = available;
    this.balance = balance;
    this.bond = bond;
    this.contractId = contractId;
    this.contratctType = contratctType;
    this.freeze = freeze;
    this.profit = profit;
    this.unprofit = unprofit;
  }

  public Double getAvailable() {
    return available;
  }

  public Double getBalance() {
    return balance;
  }

  public Double getBond() {
    return bond;
  }

  public Long getContractId() {
    return contractId;
  }

  public String getContratctType() {
    return contratctType;
  }

  public Double getFreeze() {
    return freeze;
  }

  public Integer getProfit() {
    return profit;
  }

  public Integer getUnprofit() {
    return unprofit;
  }
}
