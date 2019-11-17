package org.knowm.xchange.dvchain.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DVChainNewLimitOrder {
  private String side;
  private Double qty;
  private String asset;
  private Double limitPrice;
  private String orderType;

  public DVChainNewLimitOrder(
      @JsonProperty("side") String side,
      @JsonProperty("limitPrice") Double limitPrice,
      @JsonProperty("qty") Double qty,
      @JsonProperty("asset") String asset) {
    this.asset = asset;
    this.limitPrice = limitPrice;
    this.qty = qty;
    this.side = side;
    this.orderType = "limit";
  }

  public Double getQty() {
    return qty;
  }

  public String getAsset() {
    return asset;
  }

  public String getSide() {
    return side;
  }

  public Double getLimitPrice() {
    return limitPrice;
  }

  public String getOrderType() {
    return orderType;
  }
}
