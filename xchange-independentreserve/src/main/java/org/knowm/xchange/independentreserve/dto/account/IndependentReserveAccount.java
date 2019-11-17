package org.knowm.xchange.independentreserve.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Author: Kamil Zbikowski Date: 4/10/15 */
public class IndependentReserveAccount {
  private final String accountGuid;
  private final String accountStatus;
  private final Double availableBalance;
  private final String currencyCode;
  private final Double totalBalance;

  public IndependentReserveAccount(
      @JsonProperty("AccountGuid") String accountGuid,
      @JsonProperty("AccountStatus") String accountStatus,
      @JsonProperty("AvailableBalance") Double availableBalance,
      @JsonProperty("CurrencyCode") String currencyCode,
      @JsonProperty("TotalBalance") Double totalBalance) {
    this.accountGuid = accountGuid;
    this.accountStatus = accountStatus;
    this.availableBalance = availableBalance;
    this.currencyCode = currencyCode;
    this.totalBalance = totalBalance;
  }

  public String getAccountGuid() {
    return accountGuid;
  }

  public String getAccountStatus() {
    return accountStatus;
  }

  public Double getAvailableBalance() {
    return availableBalance;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }

  public Double getTotalBalance() {
    return totalBalance;
  }

  @Override
  public String toString() {
    return "IndependentReserveAccount [accountGuid="
        + accountGuid
        + ", accountStatus="
        + accountStatus
        + ", availableBalance="
        + availableBalance
        + ", currencyCode="
        + currencyCode
        + ", totalBalance="
        + totalBalance
        + "]";
  }
}
