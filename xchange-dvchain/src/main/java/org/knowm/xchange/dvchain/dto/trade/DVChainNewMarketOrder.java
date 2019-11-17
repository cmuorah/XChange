package org.knowm.xchange.dvchain.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DVChainNewMarketOrder {
  private String side;
  private Double qty;
  private String asset;
  private Double price;
  private String orderType;

  public DVChainNewMarketOrder(
      @JsonProperty("side") String side,
      @JsonProperty("price") Double price,
      @JsonProperty("qty") Double qty,
      @JsonProperty("asset") String asset) {
    this.asset = asset;
    this.price = price;
    this.qty = qty;
    this.side = side;
    orderType = "market";
  }

  public Double getPrice() {
    return price;
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

  public String getOrderType() {
    return orderType;
  }
}
