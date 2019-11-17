package org.knowm.xchange.hitbtc.v2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HitbtcSymbol {

  private final String id;
  private final String baseCurrency;
  private final String quoteCurrency;
  private final Double quantityIncrement;
  private final Double tickSize;
  private final Double takeLiquidityRate;
  private final Double provideLiquidityRate;
  private final String feeCurrency;

  public HitbtcSymbol(
      @JsonProperty("id") String id,
      @JsonProperty("baseCurrency") String baseCurrency,
      @JsonProperty("quoteCurrency") String quoteCurrency,
      @JsonProperty("quantityIncrement") Double quantityIncrement,
      @JsonProperty("tickSize") Double tickSize,
      @JsonProperty("takeLiquidityRate") Double takeLiquidityRate,
      @JsonProperty("provideLiquidityRate") Double provideLiquidityRate,
      @JsonProperty("feeCurrency") String feeCurrency) {

    this.id = id;
    this.baseCurrency = baseCurrency;
    this.quoteCurrency = quoteCurrency;
    this.quantityIncrement = quantityIncrement;
    this.tickSize = tickSize;
    this.takeLiquidityRate = takeLiquidityRate;
    this.provideLiquidityRate = provideLiquidityRate;
    this.feeCurrency = feeCurrency;
  }

  public String getId() {
    return id;
  }

  public String getBaseCurrency() {
    return baseCurrency;
  }

  public String getQuoteCurrency() {
    return quoteCurrency;
  }

  public Double getQuantityIncrement() {
    return quantityIncrement;
  }

  public Double getTickSize() {
    return tickSize;
  }

  public Double getTakeLiquidityRate() {
    return takeLiquidityRate;
  }

  public Double getProvideLiquidityRate() {
    return provideLiquidityRate;
  }

  public String getFeeCurrency() {
    return feeCurrency;
  }

  @Override
  public String toString() {
    return "HitbtcSymbol{"
        + "id='"
        + id
        + '\''
        + ", baseCurrency='"
        + baseCurrency
        + '\''
        + ", quoteCurrency='"
        + quoteCurrency
        + '\''
        + ", quantityIncrement="
        + quantityIncrement
        + ", tickSize="
        + tickSize
        + ", takeLiquidityRate="
        + takeLiquidityRate
        + ", provideLiquidityRate="
        + provideLiquidityRate
        + ", feeCurrency='"
        + feeCurrency
        + '\''
        + '}';
  }
}
