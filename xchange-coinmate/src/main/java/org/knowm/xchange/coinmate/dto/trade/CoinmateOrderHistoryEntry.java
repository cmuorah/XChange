package org.knowm.xchange.coinmate.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinmateOrderHistoryEntry {

  private final long id;
  private final long timestamp;
  private final String type;
  private final Double price;
  private final Double remainingAmount;
  private final Double originalAmount;
  private final String status;

  public CoinmateOrderHistoryEntry(
      @JsonProperty("id") long id,
      @JsonProperty("timestamp") long timestamp,
      @JsonProperty("type") String type,
      @JsonProperty("price") Double price,
      @JsonProperty("remainingAmount") Double remainingAmount,
      @JsonProperty("originalAmount") Double originalAmount,
      @JsonProperty("status") String status) {

    this.id = id;
    this.timestamp = timestamp;
    this.type = type;
    this.price = price;
    this.remainingAmount = remainingAmount;
    this.originalAmount = originalAmount;
    this.status = status;
  }

  public long getId() {
    return id;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public String getType() {
    return type;
  }

  public Double getPrice() {
    return price;
  }

  public Double getRemainingAmount() {
    return remainingAmount;
  }

  public Double getOriginalAmount() {
    return originalAmount;
  }

  public String getStatus() {
    return status;
  }
}
