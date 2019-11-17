package org.knowm.xchange.dsx.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author Mikhail Wall */
public class DSXCommission {

  private Double tradingVolume;
  private Double takerCommission;
  private Double makerCommission;

  public DSXCommission(
      @JsonProperty("tradingVolume") Double tradingVolume,
      @JsonProperty("takerCommission") Double takerCommission,
      @JsonProperty("makerCommission") Double makerCommission) {
    this.tradingVolume = tradingVolume;
    this.takerCommission = takerCommission;
    this.makerCommission = makerCommission;
  }

  public Double getTradingVolume() {
    return tradingVolume;
  }

  public Double getTakerCommission() {
    return takerCommission;
  }

  public Double getMakerCommission() {
    return makerCommission;
  }
}
