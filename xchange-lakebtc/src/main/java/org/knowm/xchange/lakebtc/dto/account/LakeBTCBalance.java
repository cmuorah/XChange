package org.knowm.xchange.lakebtc.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

/** User: cristian.lucaci Date: 10/3/2014 Time: 4:54 PM */
public class LakeBTCBalance {
  private final Double USD;
  private final Double CNY;
  private final Double BTC;

  public LakeBTCBalance(
      @JsonProperty("USD") Double USD,
      @JsonProperty("CNY") Double CNY,
      @JsonProperty("BTC") Double BTC) {
    this.USD = USD;
    this.CNY = CNY;
    this.BTC = BTC;
  }

  public Double getUSD() {
    return USD;
  }

  public Double getCNY() {
    return CNY;
  }

  public Double getBTC() {
    return BTC;
  }
}
