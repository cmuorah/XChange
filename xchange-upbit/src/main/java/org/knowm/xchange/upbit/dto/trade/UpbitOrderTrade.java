package org.knowm.xchange.upbit.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpbitOrderTrade {

  private final String marketId;

  private final String uuid;

  private final Double volume;

  private final Double price;

  private final Double funds;

  private final String side;

  public UpbitOrderTrade(
      @JsonProperty("market") String marketId,
      @JsonProperty("uuid") String uuid,
      @JsonProperty("volume") Double volume,
      @JsonProperty("price") Double price,
      @JsonProperty("funds") Double funds,
      @JsonProperty("side") String side) {
    this.marketId = marketId;
    this.side = side;
    this.volume = volume;
    this.price = price;
    this.funds = funds;
    this.uuid = uuid;
  }

  public String getMarketId() {
    return marketId;
  }

  public String getUuid() {
    return uuid;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getPrice() {
    return price;
  }

  public Double getFunds() {
    return funds;
  }

  public String getSide() {
    return side;
  }
}
