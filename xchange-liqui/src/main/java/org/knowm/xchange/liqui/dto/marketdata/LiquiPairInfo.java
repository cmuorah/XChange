package org.knowm.xchange.liqui.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LiquiPairInfo {

  private final int decimalPlaces;
  private final Double minPrice;
  private final Double maxPrice;
  private final Double minAmount;
  private final Double maxAmount;
  private final Double minTotal;
  private final boolean hidden;
  private final Double fee;

  public LiquiPairInfo(
      @JsonProperty("decimal_places") int decimalPlaces,
      @JsonProperty("min_price") Double minPrice,
      @JsonProperty("max_price") Double maxPrice,
      @JsonProperty("min_amount") Double minAmount,
      @JsonProperty("max_amount") Double maxAmount,
      @JsonProperty("min_total") Double minTotal,
      @JsonProperty("hidden") boolean hidden,
      @JsonProperty("fee") Double fee) {
    this.decimalPlaces = decimalPlaces;
    this.minPrice = minPrice;
    this.maxPrice = maxPrice;
    this.minAmount = minAmount;
    this.maxAmount = maxAmount;
    this.minTotal = minTotal;
    this.hidden = hidden;
    this.fee = fee;
  }

  public int getDecimalPlaces() {
    return this.decimalPlaces;
  }

  public Double getMinPrice() {
    return this.minPrice;
  }

  public Double getMaxPrice() {
    return this.maxPrice;
  }

  public Double getMinAmount() {
    return this.minAmount;
  }

  public Double getMaxAmount() {
    return this.maxAmount;
  }

  public Double getMinTotal() {
    return this.minTotal;
  }

  public boolean isHidden() {
    return this.hidden;
  }

  public Double getFee() {
    return this.fee;
  }

  @Override
  public String toString() {
    return "LiquiPairInfo{"
        + "decimalPlaces="
        + this.decimalPlaces
        + ", minPrice="
        + this.minPrice
        + ", maxPrice="
        + this.maxPrice
        + ", minAmount="
        + this.minAmount
        + ", maxAmount="
        + this.maxAmount
        + ", minTotal="
        + this.minTotal
        + ", hidden="
        + this.hidden
        + ", fee="
        + this.fee
        + '}';
  }
}
