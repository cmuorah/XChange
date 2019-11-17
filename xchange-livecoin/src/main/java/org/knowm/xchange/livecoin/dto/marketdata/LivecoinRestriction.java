package org.knowm.xchange.livecoin.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LivecoinRestriction {

  private String currencyPair;
  private Double minLimitQuantity;
  private Integer priceScale;

  public LivecoinRestriction(
      @JsonProperty("currencyPair") String currencyPair,
      @JsonProperty("minLimitQuantity") Double minLimitQuantity,
      @JsonProperty("priceScale") Integer priceScale) {
    super();
    this.currencyPair = currencyPair;
    this.minLimitQuantity = minLimitQuantity;
    this.priceScale = priceScale;
  }

  public String getCurrencyPair() {
    return currencyPair;
  }

  public Double getMinLimitQuantity() {
    return minLimitQuantity;
  }

  public Integer getPriceScale() {
    return priceScale;
  }
}
