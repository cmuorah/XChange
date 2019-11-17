package org.knowm.xchange.livecoin.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LivecoinUserOrder {
  private final Long id;
  private final String currencyPair;
  private final Long goodUntilTime;
  private final String type;
  private final String orderStatus;
  private final Long issueTime;
  private final Double price;
  private final Double quantity;
  private final Double remainingQuantity;
  private final Double commission;
  private final Double commissionRate;
  private final Long lastModificationTime;

  public LivecoinUserOrder(
      @JsonProperty("id") Long id,
      @JsonProperty("currencyPair") String currencyPair,
      @JsonProperty("goodUntilTime") Long goodUntilTime,
      @JsonProperty("type") String type,
      @JsonProperty("orderStatus") String orderStatus,
      @JsonProperty("issueTime") Long issueTime,
      @JsonProperty("price") Double price,
      @JsonProperty("quantity") Double quantity,
      @JsonProperty("remainingQuantity") Double remainingQuantity,
      @JsonProperty("commission") Double commission,
      @JsonProperty("commissionRate") Double commissionRate,
      @JsonProperty("lastModificationTime") Long lastModificationTime) {
    this.id = id;
    this.currencyPair = currencyPair;
    this.goodUntilTime = goodUntilTime;
    this.type = type;
    this.orderStatus = orderStatus;
    this.issueTime = issueTime;
    this.price = price;
    this.quantity = quantity;
    this.remainingQuantity = remainingQuantity;
    this.commission = commission;
    this.commissionRate = commissionRate;
    this.lastModificationTime = lastModificationTime;
  }

  public Long getId() {
    return id;
  }

  public String getCurrencyPair() {
    return currencyPair;
  }

  public Long getGoodUntilTime() {
    return goodUntilTime;
  }

  public String getType() {
    return type;
  }

  public String getOrderStatus() {
    return orderStatus;
  }

  public Long getIssueTime() {
    return issueTime;
  }

  public Double getPrice() {
    return price;
  }

  public Double getQuantity() {
    return quantity;
  }

  public Double getRemainingQuantity() {
    return remainingQuantity;
  }

  public Double getCommission() {
    return commission;
  }

  public Double getCommissionRate() {
    return commissionRate;
  }

  public Long getLastModificationTime() {
    return lastModificationTime;
  }
}
