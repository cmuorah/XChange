package org.knowm.xchange.bx.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BxOrder {

  private final String pairingId;
  private final String orderId;
  private final String orderType;
  private final Double amount;
  private final Double rate;
  private final String date;

  public BxOrder(
      @JsonProperty("pairing_id") String pairingId,
      @JsonProperty("order_id") String orderId,
      @JsonProperty("order_type") String orderType,
      @JsonProperty("amount") Double amount,
      @JsonProperty("rate") Double rate,
      @JsonProperty("date") String date) {
    this.pairingId = pairingId;
    this.orderId = orderId;
    this.orderType = orderType;
    this.amount = amount;
    this.rate = rate;
    this.date = date;
  }

  public String getPairingId() {
    return pairingId;
  }

  public String getOrderId() {
    return orderId;
  }

  public String getOrderType() {
    return orderType;
  }

  public Double getAmount() {
    return amount;
  }

  public Double getRate() {
    return rate;
  }

  public String getDate() {
    return date;
  }

  @Override
  public String toString() {
    return "BxOrder{"
        + "pairingId='"
        + pairingId
        + '\''
        + ", orderId='"
        + orderId
        + '\''
        + ", orderType='"
        + orderType
        + '\''
        + ", amount="
        + amount
        + ", rate="
        + rate
        + ", date="
        + date
        + '}';
  }
}
