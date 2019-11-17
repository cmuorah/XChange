package org.knowm.xchange.coinmate.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinmateTransferHistoryEntry {
  private final long id;
  private final Double fee;
  private final String transferType;
  private final long timestamp;
  private final String transferStatus;
  private final Double amount;
  private final String amountCurrency;
  private final String walletType;

  public CoinmateTransferHistoryEntry(
      @JsonProperty("id") long id,
      @JsonProperty("fee") Double fee,
      @JsonProperty("transferType") String transferType,
      @JsonProperty("timestamp") long timestamp,
      @JsonProperty("transferStatus") String transferStatus,
      @JsonProperty("amount") Double amount,
      @JsonProperty("amountCurrency") String amountCurrency,
      @JsonProperty("walletType") String walletType) {

    this.fee = fee;
    this.transferType = transferType;
    this.timestamp = timestamp;
    this.id = id;
    this.transferStatus = transferStatus;
    this.amount = amount;
    this.amountCurrency = amountCurrency;
    this.walletType = walletType;
  }
}
