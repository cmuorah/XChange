package org.knowm.xchange.coinbene.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinbeneCoinBalance {
  private final String asset;
  private final Double available;
  private final Double reserved;
  private final Double total;

  public CoinbeneCoinBalance(
      @JsonProperty("asset") String asset,
      @JsonProperty("available") Double available,
      @JsonProperty("reserved") Double reserved,
      @JsonProperty("total") Double total) {
    this.asset = asset;
    this.available = available;
    this.reserved = reserved;
    this.total = total;
  }

  public String getAsset() {
    return asset;
  }

  public Double getAvailable() {
    return available;
  }

  public Double getReserved() {
    return reserved;
  }

  public Double getTotal() {
    return total;
  }
}
