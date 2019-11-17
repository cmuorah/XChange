package org.knowm.xchange.exx.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class EXXBalance {

  @JsonProperty("total")
  private Double total;

  @JsonProperty("freeze")
  private Double freeze;

  @JsonProperty("balance")
  private Double balance;

  @JsonProperty("fundsType")
  private String fundsType;

  @JsonProperty("propTag")
  private String propTag;

  @JsonProperty("credit_quota")
  private Double creditQuota;

  @JsonProperty("credit_borrowed")
  private Double creditBorrowed;

  @JsonProperty("credit_interest")
  private Double creditInterest;

  /** No args constructor for use in serialization */
  public EXXBalance() {}

  /**
   * @param creditBorrowed
   * @param total
   * @param balance
   * @param creditQuota
   * @param freeze
   * @param creditInterest
   * @param propTag
   * @param fundsType
   */
  public EXXBalance(
      Double total,
      Double freeze,
      Double balance,
      String fundsType,
      String propTag,
      Double creditQuota,
      Double creditBorrowed,
      Double creditInterest) {
    super();
    this.total = total;
    this.freeze = freeze;
    this.balance = balance;
    this.fundsType = fundsType;
    this.propTag = propTag;
    this.creditQuota = creditQuota;
    this.creditBorrowed = creditBorrowed;
    this.creditInterest = creditInterest;
  }

  @JsonProperty("total")
  public Double getTotal() {
    return total;
  }

  @JsonProperty("total")
  public void setTotal(Double total) {
    this.total = total;
  }

  @JsonProperty("freeze")
  public Double getFreeze() {
    return freeze;
  }

  @JsonProperty("freeze")
  public void setFreeze(Double freeze) {
    this.freeze = freeze;
  }

  @JsonProperty("balance")
  public Double getBalance() {
    return balance;
  }

  @JsonProperty("balance")
  public void setBalance(Double balance) {
    this.balance = balance;
  }

  @JsonProperty("fundsType")
  public String getFundsType() {
    return fundsType;
  }

  @JsonProperty("fundsType")
  public void setFundsType(String fundsType) {
    this.fundsType = fundsType;
  }

  @JsonProperty("propTag")
  public String gEXXBalanceropTag() {
    return propTag;
  }

  @JsonProperty("propTag")
  public void sEXXBalanceropTag(String propTag) {
    this.propTag = propTag;
  }

  @JsonProperty("credit_quota")
  public Double getCreditQuota() {
    return creditQuota;
  }

  @JsonProperty("credit_quota")
  public void setCreditQuota(Double creditQuota) {
    this.creditQuota = creditQuota;
  }

  @JsonProperty("credit_borrowed")
  public Double getCreditBorrowed() {
    return creditBorrowed;
  }

  @JsonProperty("credit_borrowed")
  public void setCreditBorrowed(Double creditBorrowed) {
    this.creditBorrowed = creditBorrowed;
  }

  @JsonProperty("credit_interest")
  public Double getCreditInterest() {
    return creditInterest;
  }

  @JsonProperty("credit_interest")
  public void setCreditInterest(Double creditInterest) {
    this.creditInterest = creditInterest;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("total", total)
        .append("freeze", freeze)
        .append("balance", balance)
        .append("fundsType", fundsType)
        .append("propTag", propTag)
        .append("creditQuota", creditQuota)
        .append("creditBorrowed", creditBorrowed)
        .append("creditInterest", creditInterest)
        .toString();
  }
}
