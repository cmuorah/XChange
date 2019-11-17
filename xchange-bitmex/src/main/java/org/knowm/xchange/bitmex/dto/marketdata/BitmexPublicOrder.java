package org.knowm.xchange.bitmex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.bitmex.dto.trade.BitmexSide;

public class BitmexPublicOrder {

  private final Double price;
  private final Double size;
  private final String symbol;
  private final Double id;
  private final BitmexSide side;

  public BitmexPublicOrder(
      @JsonProperty("price") Double price,
      @JsonProperty("id") Double id,
      @JsonProperty("size") Double size,
      @JsonProperty("side") BitmexSide side,
      @JsonProperty("symbol") String symbol) {

    this.symbol = symbol;
    this.id = id;
    this.side = side;
    this.size = size;
    this.price = price;
  }

  public Double getPrice() {

    return price;
  }

  public Double getVolume() {

    return size;
  }

  public BitmexSide getSide() {

    return side;
  }

  public Double getId() {

    return id;
  }

  public String getSymbol() {

    return symbol;
  }

  @Override
  public String toString() {

    return "BitmexOrder [price="
        + price
        + ", volume="
        + size
        + ", symbol="
        + symbol
        + ", side="
        + side
        + "]";
  }
}
