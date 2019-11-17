package org.knowm.xchange.bithumb.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BithumbAccount {

  private final long created;
  private final String accountId;
  private final Double tradeFee;
  private final Double balance;

  public BithumbAccount(
      @JsonProperty("created") long created,
      @JsonProperty("account_id") String accountId,
      @JsonProperty("trade_fee") Double tradeFee,
      @JsonProperty("balance") Double balance) {
    this.created = created;
    this.accountId = accountId;
    this.tradeFee = tradeFee;
    this.balance = balance;
  }

  public long getCreated() {
    return created;
  }

  public String getAccountId() {
    return accountId;
  }

  public Double getTradeFee() {
    return tradeFee;
  }

  public Double getBalance() {
    return balance;
  }

  @Override
  public String toString() {
    return "BithumbAccount{"
        + "created="
        + created
        + ", accountId='"
        + accountId
        + '\''
        + ", tradeFee="
        + tradeFee
        + ", balance="
        + balance
        + '}';
  }
}
