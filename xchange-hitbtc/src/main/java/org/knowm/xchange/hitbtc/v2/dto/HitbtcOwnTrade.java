package org.knowm.xchange.hitbtc.v2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class HitbtcOwnTrade {

  public final String symbol;
  private final Long id;
  private final String clientOrderId;
  private final Long orderId;
  private final HitbtcSide side;
  private final Double quantity;
  private final Double fee;
  private final Double price;
  private final Date timestamp;

  public HitbtcOwnTrade(
      @JsonProperty("id") Long id,
      @JsonProperty("clientOrderId") String clientOrderId,
      @JsonProperty("orderId") Long orderId,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("side") HitbtcSide side,
      @JsonProperty("quantity") Double quantity,
      @JsonProperty("fee") Double fee,
      @JsonProperty("price") Double price,
      @JsonProperty("timestamp") Date timestamp) {
    this.id = id;
    this.clientOrderId = clientOrderId;
    this.orderId = orderId;
    this.symbol = symbol;
    this.side = side;
    this.quantity = quantity;
    this.fee = fee;
    this.price = price;
    this.timestamp = timestamp;
  }

  public Long getId() {
    return id;
  }

  public String getClientOrderId() {
    return clientOrderId;
  }

  public Long getOrderId() {
    return orderId;
  }

  public HitbtcSide getSide() {
    return side;
  }

  public Double getQuantity() {
    return quantity;
  }

  public Double getFee() {
    return fee;
  }

  public Double getPrice() {
    return price;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return "HitbtcOwnTrade{"
        + "id="
        + id
        + ", clientOrderId='"
        + clientOrderId
        + '\''
        + ", orderId="
        + orderId
        + ", side="
        + side
        + ", quantity="
        + quantity
        + ", fee="
        + fee
        + ", price="
        + price
        + ", timestamp="
        + timestamp
        + '}';
  }
}
