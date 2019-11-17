package org.knowm.xchange.coinone.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinoneOrderInfo {

  private final Double price;
  private final Long timestamp;
  private final Double qty;
  private final Double remainQty;
  private final String type;
  private final String currency;
  private final Double feeRate;
  private final Double fee;
  private final String orderId;

  /**
   * @param price
   * @param timestamp
   * @param qty
   * @param remainQty
   * @param type
   * @param currency
   * @param feeRate
   * @param fee
   * @param orderId
   */
  public CoinoneOrderInfo(
      @JsonProperty("price") String price,
      @JsonProperty("timestamp") String timestamp,
      @JsonProperty("qty") String qty,
      @JsonProperty("remainQty") String remainQty,
      @JsonProperty("type") String type,
      @JsonProperty("currency") String currency,
      @JsonProperty("feeRate") String feeRate,
      @JsonProperty("fee") String fee,
      @JsonProperty("orderId") String orderId) {

    this.price = new Double(price);
    this.timestamp = Long.valueOf(timestamp);
    this.qty = new Double(qty);
    this.remainQty = new Double(remainQty);
    this.type = type;
    this.currency = currency;
    this.feeRate = new Double(feeRate);
    this.fee = new Double(fee);
    this.orderId = orderId;
  }

  public Double getPrice() {
    return price;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public Double getQty() {
    return qty;
  }

  public Double getRemainQty() {
    return remainQty;
  }

  public String getType() {
    return type;
  }

  public String getCurrency() {
    return currency;
  }

  public Double getFeeRate() {
    return feeRate;
  }

  public Double getFee() {
    return fee;
  }

  public String getOrderId() {
    return orderId;
  }
}
