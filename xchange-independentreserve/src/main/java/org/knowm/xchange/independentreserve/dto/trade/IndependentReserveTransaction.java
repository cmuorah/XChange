package org.knowm.xchange.independentreserve.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class IndependentReserveTransaction {

  private final Double balance;
  private final String bitcoinTransactionId;
  private final String bitcoinTransactionOutputIndex;
  private final String ethereumTransactionId;
  private final String comment;
  private final Date createdTimestamp;
  private final Double credit;
  private final String currencyCode;
  private final Double debit;
  private final Date settleTimestamp;
  private final String status;
  private final Type type;

  public IndependentReserveTransaction(
      @JsonProperty("Balance") Double balance,
      @JsonProperty("BitcoinTransactionId") String bitcoinTransactionId,
      @JsonProperty("BitcoinTransactionOutputIndex") String bitcoinTransactionOutputIndex,
      @JsonProperty("EthereumTransactionId") String ethereumTransactionId,
      @JsonProperty("Comment") String comment,
      @JsonProperty("CreatedTimestampUtc") String createdTimestampUtc,
      @JsonProperty("Credit") Double credit,
      @JsonProperty("CurrencyCode") String currencyCode,
      @JsonProperty("Debit") Double debit,
      @JsonProperty("SettleTimestampUtc") String settleTimestampUtc,
      @JsonProperty("Status") String status,
      @JsonProperty("Type") Type type)
      throws com.fasterxml.jackson.databind.exc.InvalidFormatException {
    super();
    this.balance = balance;
    this.bitcoinTransactionId = bitcoinTransactionId;
    this.bitcoinTransactionOutputIndex = bitcoinTransactionOutputIndex;
    this.ethereumTransactionId = ethereumTransactionId;
    this.comment = comment;
    this.createdTimestamp =
        createdTimestampUtc == null
            ? null
            : org.knowm.xchange.utils.DateUtils.fromISO8601DateString(createdTimestampUtc);
    this.credit = credit;
    this.currencyCode = currencyCode;
    this.debit = debit;
    this.settleTimestamp =
        settleTimestampUtc == null
            ? null
            : org.knowm.xchange.utils.DateUtils.fromISO8601DateString(settleTimestampUtc);
    this.status = status;
    this.type = type;
  }

  public Double getBalance() {
    return balance;
  }

  public String getBitcoinTransactionId() {
    return bitcoinTransactionId;
  }

  public String getBitcoinTransactionOutputIndex() {
    return bitcoinTransactionOutputIndex;
  }

  public String getComment() {
    return comment;
  }

  public Date getCreatedTimestamp() {
    return createdTimestamp;
  }

  public Double getCredit() {
    return credit;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }

  public Double getDebit() {
    return debit;
  }

  public Date getSettleTimestamp() {
    return settleTimestamp;
  }

  public String getStatus() {
    return status;
  }

  public Type getType() {
    return type;
  }

  public String getEthereumTransactionId() {
    return ethereumTransactionId;
  }

  @Override
  public String toString() {
    return "IndependentReserveTransaction [balance="
        + balance
        + ", bitcoinTransactionId="
        + bitcoinTransactionId
        + ", bitcoinTransactionOutputIndex="
        + bitcoinTransactionOutputIndex
        + ", comment="
        + comment
        + ", createdTimestamp="
        + createdTimestamp
        + ", credit="
        + credit
        + ", currencyCode="
        + currencyCode
        + ", debit="
        + debit
        + ", settleTimestamp="
        + settleTimestamp
        + ", status="
        + status
        + ", type="
        + type
        + "]";
  }

  public enum Type {
    Deposit,
    Withdrawal,
    Brokerage,
    Trade,
    BitcoinNetworkFee,
    Commission,
    DepositFee,
    Error,
    GST,
    Transfer,
    Unclaimed,
    WithdrawalFee
  }
}
