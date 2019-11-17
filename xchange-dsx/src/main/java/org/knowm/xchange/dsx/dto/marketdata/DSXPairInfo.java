package org.knowm.xchange.dsx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author Mikhail Wall */
public final class DSXPairInfo {

  private final int decimalsPrice;
  private final Double minPrice;
  private final Double maxPrice;
  private final Double minAmount;
  private final int hidden;
  private final Double fee;
  private final int decimalVolume;
  public final String quotedCurrency;
  public final String baseCurrency;

  public DSXPairInfo(
      @JsonProperty("decimal_places") int decimalsPrice,
      @JsonProperty("min_price") Double minPrice,
      @JsonProperty("max_price") Double maxPrice,
      @JsonProperty("min_amount") Double minAmount,
      @JsonProperty("hidden") int hidden,
      @JsonProperty("fee") Double fee,
      @JsonProperty("amount_decimal_places") int decimalVolume,
      @JsonProperty("quoted_currency") String quotedCurrency,
      @JsonProperty("base_currency") String baseCurrency) {

    this.decimalsPrice = decimalsPrice;
    this.minPrice = minPrice;
    this.maxPrice = maxPrice;
    this.minAmount = minAmount;
    this.hidden = hidden;
    this.fee = fee;
    this.decimalVolume = decimalVolume;
    this.quotedCurrency = quotedCurrency;
    this.baseCurrency = baseCurrency;
  }

  public int getDecimalsPrice() {

    return decimalsPrice;
  }

  public Double getMinPrice() {

    return minPrice;
  }

  public Double getMaxPrice() {

    return maxPrice;
  }

  public int getHidden() {

    return hidden;
  }

  public Double getMinAmount() {

    return minAmount;
  }

  public Double getFee() {

    return fee;
  }

  public int getDecimalVolume() {

    return decimalVolume;
  }

  @Override
  public String toString() {

    return "DSXPairInfo{"
        + "decimalsPrice="
        + decimalsPrice
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
        + ", decimalVolume="
        + decimalVolume
        + '}';
  }
}
