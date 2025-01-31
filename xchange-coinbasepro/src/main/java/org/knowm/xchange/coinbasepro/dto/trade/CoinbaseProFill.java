package org.knowm.xchange.coinbasepro.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinbaseProFill {
  private final String tradeId;
  private final String productId;
  private final Double price;
  private final Double size;
  private final String orderId;
  private final String createdAt;
  private final String liquidity;
  private final Double fee;
  private final boolean settled;
  private final String side;

  public CoinbaseProFill(
      @JsonProperty("trade_id") String tradeId,
      @JsonProperty("product_id") String productId,
      @JsonProperty("price") Double price,
      @JsonProperty("size") Double size,
      @JsonProperty("order_id") String orderId,
      @JsonProperty("created_at") String createdAt,
      @JsonProperty("liquidity") String liquidity,
      @JsonProperty("fee") Double fee,
      @JsonProperty("settled") boolean settled,
      @JsonProperty("side") String side) {
    this.tradeId = tradeId;
    this.productId = productId;
    this.price = price;
    this.size = size;
    this.orderId = orderId;
    this.createdAt = createdAt;
    this.liquidity = liquidity;
    this.fee = fee;
    this.settled = settled;
    this.side = side;
  }

  public String getTradeId() {
    return tradeId;
  }

  public String getProductId() {
    return productId;
  }

  public Double getPrice() {
    return price;
  }

  public Double getSize() {
    return size;
  }

  public String getOrderId() {
    return orderId;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public String getLiquidity() {
    return liquidity;
  }

  public Double getFee() {
    return fee;
  }

  public boolean isSettled() {
    return settled;
  }

  public String getSide() {
    return side;
  }

  @Override
  public String toString() {
    return "CoinbaseExFill{"
        + "tradeId='"
        + tradeId
        + '\''
        + ", productId='"
        + productId
        + '\''
        + ", price="
        + price
        + ", size="
        + size
        + ", orderId='"
        + orderId
        + '\''
        + ", createdAt='"
        + createdAt
        + '\''
        + ", liquidity='"
        + liquidity
        + '\''
        + ", fee="
        + fee
        + ", settled="
        + settled
        + ", side='"
        + side
        + '\''
        + '}';
  }
}
