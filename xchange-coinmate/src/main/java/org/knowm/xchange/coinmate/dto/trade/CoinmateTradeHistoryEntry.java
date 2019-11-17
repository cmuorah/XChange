package org.knowm.xchange.coinmate.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinmateTradeHistoryEntry {

  private final long transactionId;
  private final long createdTimestamp;
  private final String currencyPair;
  private final String type;
  private final String orderType;
  private final long orderId;
  private final Double amount;
  private final Double price;
  private final Double fee;
  private final String feeType;

  public CoinmateTradeHistoryEntry(
      @JsonProperty("transactionId") long transactionId,
      @JsonProperty("createdTimestamp") long createdTimestamp,
      @JsonProperty("currencyPair") String currencyPair,
      @JsonProperty("orderType") String orderType,
      @JsonProperty("type") String type,
      @JsonProperty("orderId") long orderId,
      @JsonProperty("amount") Double amount,
      @JsonProperty("price") Double price,
      @JsonProperty("fee") Double fee,
      @JsonProperty("feeType") String feeType) {

    this.transactionId = transactionId;
    this.createdTimestamp = createdTimestamp;
    this.currencyPair = currencyPair;
    this.type = type;
    this.orderType = orderType;
    this.orderId = orderId;
    this.amount = amount;
    this.price = price;
    this.fee = fee;
    this.feeType = feeType;
  }

  public long getTransactionId() {
    return transactionId;
  }

  public long getCreatedTimestamp() {
    return createdTimestamp;
  }

  public String getCurrencyPair() {
    return currencyPair;
  }

  public String getType() {
    return type;
  }

  public String getOrderType() {
    return orderType;
  }

  public long getOrderId() {
    return orderId;
  }

  public Double getAmount() {
    return amount;
  }

  public Double getPrice() {
    return price;
  }

  public Double getFee() {
    return fee;
  }

  public String getFeeType() {
    return feeType;
  }
}
