package org.knowm.xchange.dragonex.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderPlacement {

  @JsonProperty("symbol_id")
  public final long symbolId;

  @JsonProperty("price")
  public final String price;

  @JsonProperty("volume")
  public final String volume;

  public OrderPlacement(long symbolId, Double price, Double volume) {
    this.symbolId = symbolId;
    this.price = price.toString();
    this.volume = volume.toString();
  }

  @Override
  public String toString() {
    return "OrderPlacement [symbolId="
        + symbolId
        + ", "
        + (price != null ? "price=" + price + ", " : "")
        + (volume != null ? "volume=" + volume : "")
        + "]";
  }
}
