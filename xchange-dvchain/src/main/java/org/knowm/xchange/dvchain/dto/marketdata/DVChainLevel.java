package org.knowm.xchange.dvchain.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DVChainLevel {
  private final Double sellPrice;
  private final Double buyPrice;
  private final Double maxQuantity;

  public DVChainLevel(
      @JsonProperty("sellPrice") Double sellPrice,
      @JsonProperty("buyPrice") Double buyPrice,
      @JsonProperty("maxQuantity") Double maxQuantity) {
    this.buyPrice = buyPrice;
    this.sellPrice = sellPrice;
    this.maxQuantity = maxQuantity;
  }

  public Double getBuyPrice() {
    return buyPrice;
  }

  public Double getMaxQuantity() {
    return maxQuantity;
  }

  public Double getSellPrice() {
    return sellPrice;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Level {sellPrice=");
    builder.append(sellPrice);
    builder.append(", buyPrice=");
    builder.append(buyPrice);
    builder.append(", maxQuantity=");
    builder.append(maxQuantity);
    builder.append("}");
    return builder.toString();
  }
}
