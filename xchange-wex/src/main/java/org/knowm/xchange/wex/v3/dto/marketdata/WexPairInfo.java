package org.knowm.xchange.wex.v3.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Author: brox */
public class WexPairInfo {

  private final int decimals;
  private final Double minPrice;
  private final Double maxPrice;
  private final Double minAmount;
  private final int hidden;
  private final Double fee;

  public WexPairInfo(
      @JsonProperty("decimal_places") int decimals,
      @JsonProperty("min_price") Double minPrice,
      @JsonProperty("max_price") Double maxPrice,
      @JsonProperty("min_amount") Double minAmount,
      @JsonProperty("hidden") int hidden,
      @JsonProperty("fee") Double fee) {

    this.decimals = decimals;
    this.minPrice = minPrice;
    this.maxPrice = maxPrice;
    this.minAmount = minAmount;
    this.hidden = hidden;
    this.fee = fee;
  }

  public int getDecimals() {

    return decimals;
  }

  public Double getMinPrice() {

    return minPrice;
  }

  public Double getMaxPrice() {

    return maxPrice;
  }

  public Double getMinAmount() {

    return minAmount;
  }

  public int getHidden() {

    return hidden;
  }

  public Double getFee() {

    return fee;
  }

  @Override
  public String toString() {

    return "WexPairInfo [decimals="
        + decimals
        + ", minPrice="
        + minPrice
        + ", maxPrice="
        + maxPrice
        + ", minAmount="
        + minAmount
        + ", hidden="
        + hidden
        + ", fee="
        + fee
        + "]";
  }
}
