package org.knowm.xchange.gateio.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GateioOpenOrder {

  private String timestamp;

  private String total;

  private Double amount;

  private String id;

  private Double rate;

  private String status;

  private String orderNumber;

  private String type;

  private String currencyPair;

  /** Constructor */
  private GateioOpenOrder(
      @JsonProperty("timestamp") String timestamp,
      @JsonProperty("total") String total,
      @JsonProperty("amount") Double amount,
      @JsonProperty("id") String id,
      @JsonProperty("rate") Double rate,
      @JsonProperty("status") String status,
      @JsonProperty("orderNumber") String orderNumber,
      @JsonProperty("type") String type,
      @JsonProperty("currencyPair") String currencyPair) {
    this.timestamp = timestamp;
    this.total = total;
    this.amount = amount;
    this.id = id;
    this.rate = rate;
    this.status = status;
    this.orderNumber = orderNumber;
    this.type = type;
    this.currencyPair = currencyPair;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public String getTotal() {
    return total;
  }

  public Double getAmount() {
    return amount;
  }

  public String getId() {
    return id;
  }

  public Double getRate() {
    return rate;
  }

  public String getStatus() {
    return status;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public String getType() {
    return type;
  }

  public String getCurrencyPair() {
    return currencyPair;
  }

  @Override
  public String toString() {
    return "GateioOpenOrder{"
        + "timestamp='"
        + timestamp
        + '\''
        + ", total='"
        + total
        + '\''
        + ", amount='"
        + amount
        + '\''
        + ", id='"
        + id
        + '\''
        + ", rate='"
        + rate
        + '\''
        + ", status='"
        + status
        + '\''
        + ", orderNumber='"
        + orderNumber
        + '\''
        + ", type='"
        + type
        + '\''
        + ", currencyPair='"
        + currencyPair
        + '\''
        + '}';
  }
}
