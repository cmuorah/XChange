package org.knowm.xchange.hitbtc.v2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class HitbtcOrder {

  public final String id;
  public final String clientOrderId;
  public final String symbol;
  public final String side;
  public final String status;
  public final String type;
  public final String timeInForce;
  public final Double quantity;
  public final Double price;
  public final Double cumQuantity;

  private final Date createdAt;
  private final Date updatedAt;

  public HitbtcOrder(
      @JsonProperty("id") String id,
      @JsonProperty("clientOrderId") String clientOrderId,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("side") String side,
      @JsonProperty("status") String status,
      @JsonProperty("type") String type,
      @JsonProperty("timeInForce") String timeInForce,
      @JsonProperty("quantity") Double quantity,
      @JsonProperty("price") Double price,
      @JsonProperty("cumQuantity") Double cumQuantity,
      @JsonProperty("createdAt") Date createdAt,
      @JsonProperty("updatedAt") Date updatedAt) {
    super();
    this.id = id;
    this.clientOrderId = clientOrderId;
    this.symbol = symbol;
    this.side = side;
    this.status = status;
    this.type = type;
    this.timeInForce = timeInForce;
    this.quantity = quantity;
    this.price = price;
    this.cumQuantity = cumQuantity;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Date getCreatedAt() {
    return new Date(createdAt.getTime());
  }

  public Date getUpdatedAt() {
    return new Date(updatedAt.getTime());
  }

  @Override
  public String toString() {
    return "HitbtcNewOrderResponse [id="
        + id
        + ", clientOrderId="
        + clientOrderId
        + ", symbol="
        + symbol
        + ", side="
        + side
        + ", status="
        + status
        + ", type="
        + type
        + ", timeInForce="
        + timeInForce
        + ", quantity="
        + quantity
        + ", price="
        + price
        + ", cumQuantity="
        + cumQuantity
        + ", createdAt="
        + createdAt
        + ", updatedAt="
        + updatedAt
        + "]";
  }
}
