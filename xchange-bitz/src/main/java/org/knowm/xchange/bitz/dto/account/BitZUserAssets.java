package org.knowm.xchange.bitz.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitZUserAssets {
  private final Double cny;
  private final Double usd;
  private final Double btcTotal;
  private final BitZUserAssetsInfo[] info;

  public BitZUserAssets(
      @JsonProperty("cny") Double cny,
      @JsonProperty("usd") Double usd,
      @JsonProperty("btc_total") Double btcTotal,
      @JsonProperty("info") BitZUserAssetsInfo[] info) {
    this.cny = cny;
    this.usd = usd;
    this.btcTotal = btcTotal;
    this.info = info;
  }

  public Double getCny() {
    return cny;
  }

  public Double getUsd() {
    return usd;
  }

  public Double getBtcTotal() {
    return btcTotal;
  }

  public BitZUserAssetsInfo[] getInfo() {
    return info;
  }
}
