package org.knowm.xchange.kraken.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.kraken.dto.trade.KrakenOrderType;
import org.knowm.xchange.kraken.dto.trade.KrakenType;

public class KrakenPublicTrade {

  private final Double price;
  private final Double volume;
  private final double time;
  private final KrakenType type;
  private final KrakenOrderType orderType;
  private final String miscellaneous;

  public KrakenPublicTrade(
      @JsonProperty("price") Double price,
      @JsonProperty("volume") Double volume,
      @JsonProperty("time") double time,
      @JsonProperty("type") KrakenType type,
      @JsonProperty("orderType") KrakenOrderType orderType,
      @JsonProperty("miscellaneous") String miscellaneous) {

    this.price = price;
    this.volume = volume;
    this.time = time;
    this.type = type;
    this.orderType = orderType;
    this.miscellaneous = miscellaneous;
  }

  public Double getPrice() {

    return price;
  }

  public Double getVolume() {

    return volume;
  }

  public double getTime() {

    return time;
  }

  public KrakenType getType() {

    return type;
  }

  public KrakenOrderType getOrderType() {

    return orderType;
  }

  public String getMiscellaneous() {

    return miscellaneous;
  }

  @Override
  public String toString() {

    return "KrakenPublicTrade [price="
        + price
        + ", volume="
        + volume
        + ", time="
        + time
        + ", type="
        + type
        + ", orderType="
        + orderType
        + ", miscellaneous="
        + miscellaneous
        + "]";
  }
}
