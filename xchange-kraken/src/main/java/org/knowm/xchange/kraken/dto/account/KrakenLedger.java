package org.knowm.xchange.kraken.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KrakenLedger {

  private final String refId;
  private final double unixTime;
  private final LedgerType ledgerType;
  private final String assetClass;
  private final String asset;
  private final Double transactionAmount;
  private final Double fee;
  private final Double balance;

  /**
   * Constructor
   *
   * @param refId
   * @param unixTime
   * @param ledgerType
   * @param assetClass
   * @param asset
   * @param transactionAmount
   * @param fee
   * @param balance
   */
  public KrakenLedger(
      @JsonProperty("refid") String refId,
      @JsonProperty("time") double unixTime,
      @JsonProperty("type") LedgerType ledgerType,
      @JsonProperty("aclass") String assetClass,
      @JsonProperty("asset") String asset,
      @JsonProperty("amount") Double transactionAmount,
      @JsonProperty("fee") Double fee,
      @JsonProperty("balance") Double balance) {

    this.refId = refId;
    this.unixTime = unixTime;
    this.ledgerType = ledgerType;
    this.assetClass = assetClass;
    this.asset = asset;
    this.transactionAmount = transactionAmount;
    this.fee = fee;
    this.balance = balance;
  }

  public String getRefId() {

    return refId;
  }

  public double getUnixTime() {

    return unixTime;
  }

  public LedgerType getLedgerType() {

    return ledgerType;
  }

  public String getAssetClass() {

    return assetClass;
  }

  public String getAsset() {

    return asset;
  }

  public Double getTransactionAmount() {

    return transactionAmount;
  }

  public Double getFee() {

    return fee;
  }

  public Double getBalance() {

    return balance;
  }

  @Override
  public String toString() {

    return "KrakenLedgerInfo [refId="
        + refId
        + ", unixTime="
        + unixTime
        + ", ledgerType="
        + ledgerType
        + ", assetClass="
        + assetClass
        + ", asset="
        + asset
        + ", transactionAmount="
        + transactionAmount
        + ", fee="
        + fee
        + ", balance="
        + balance
        + "]";
  }
}
