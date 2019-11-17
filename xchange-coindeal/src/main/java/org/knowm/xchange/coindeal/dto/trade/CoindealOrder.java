package org.knowm.xchange.coindeal.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoindealOrder {

  @JsonProperty("id")
  private final String id;

  @JsonProperty("clientOrderId")
  private final String clientOrderId;

  @JsonProperty("symbol")
  private final String symbol;

  @JsonProperty("side")
  private final String side;

  @JsonProperty("status")
  private final String status;

  @JsonProperty("quantity")
  private final Double quantity;

  @JsonProperty("price")
  private final Double price;

  @JsonProperty("cumQuantity")
  private final Double cumQuantity;

  @JsonProperty("createdAt")
  private final String createdAt;

  @JsonProperty("updatedAt")
  private final String updatedAt;

  @JsonProperty("stopPrice")
  private final Double stopPrice;

  @JsonProperty("expireTime")
  private final String expireTime;

  public CoindealOrder(
      @JsonProperty("id") String id,
      @JsonProperty("clientOrderId") String clientOrderId,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("side") String side,
      @JsonProperty("status") String status,
      @JsonProperty("quantity") Double quantity,
      @JsonProperty("price") Double price,
      @JsonProperty("cumQuantity") Double cumQuantity,
      @JsonProperty("createdAt") String createdAt,
      @JsonProperty("updatedAt") String updatedAt,
      @JsonProperty("stopPrice") Double stopPrice,
      @JsonProperty("expireTime") String expireTime) {
    this.id = id;
    this.clientOrderId = clientOrderId;
    this.symbol = symbol;
    this.side = side;
    this.status = status;
    this.quantity = quantity;
    this.price = price;
    this.cumQuantity = cumQuantity;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.stopPrice = stopPrice;
    this.expireTime = expireTime;
  }

  public String getId() {
    return id;
  }

  public String getClientOrderId() {
    return clientOrderId;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getSide() {
    return side;
  }

  public String getStatus() {
    return status;
  }

  public Double getQuantity() {
    return quantity;
  }

  public Double getPrice() {
    return price;
  }

  public Double getCumQuantity() {
    return cumQuantity;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public Double getStopPrice() {
    return stopPrice;
  }

  public String getExpireTime() {
    return expireTime;
  }

  @Override
  public String toString() {
    return "CoindealOrder{"
        + "id='"
        + id
        + '\''
        + ", clientOrderId='"
        + clientOrderId
        + '\''
        + ", symbol='"
        + symbol
        + '\''
        + ", side='"
        + side
        + '\''
        + ", status='"
        + status
        + '\''
        + ", quantity="
        + quantity
        + ", price="
        + price
        + ", cumQuantity="
        + cumQuantity
        + ", createdAt='"
        + createdAt
        + '\''
        + ", updatedAt='"
        + updatedAt
        + '\''
        + ", stopPrice="
        + stopPrice
        + ", expireTime='"
        + expireTime
        + '\''
        + '}';
  }
}
