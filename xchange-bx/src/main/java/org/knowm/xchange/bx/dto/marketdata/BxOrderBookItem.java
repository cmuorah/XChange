package org.knowm.xchange.bx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BxOrderBookItem {

  private final Double total;
  private final Double volume;
  private final Double highBid;

  public BxOrderBookItem(
      @JsonProperty("total") Double total,
      @JsonProperty("volume") Double volume,
      @JsonProperty("highbid") Double highBid) {
    this.total = total;
    this.volume = volume;
    this.highBid = highBid;
  }

  public Double getHighBid() {
    return highBid;
  }

  @Override
  public String toString() {
    return "BxOrderBookItem{"
        + "total="
        + total
        + ", volume="
        + volume
        + ", highbid="
        + highBid
        + '}';
  }
}
