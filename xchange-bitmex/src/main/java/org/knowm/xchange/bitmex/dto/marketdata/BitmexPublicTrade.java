package org.knowm.xchange.bitmex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.knowm.xchange.bitmex.dto.trade.BitmexSide;
import org.knowm.xchange.bitmex.dto.trade.BitmexTickDirection;

public class BitmexPublicTrade {

  private final Double price;
  private final Double size;
  private final Date timestamp;
  private final BitmexSide side;
  private final BitmexTickDirection tickDirection;
  private final String symbol;
  private final String trdMatchID;
  private final Double grossValue;
  private final Double homeNotional;
  private final Double foreignNotional;

  public BitmexPublicTrade(
      @JsonProperty("price") Double price,
      @JsonProperty("size") Double size,
      @JsonProperty("timestamp") Date timestamp,
      @JsonProperty("side") BitmexSide side,
      @JsonProperty("tickDirection") BitmexTickDirection tickDirection,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("trdMatchID") String trdMatchID,
      @JsonProperty("grossValue") Double grossValue,
      @JsonProperty("homeNotional") Double homeNotional,
      @JsonProperty("foreignNotional") Double foreignNotional) {

    this.price = price;
    this.size = size;
    this.timestamp = timestamp;
    this.side = side;
    this.tickDirection = tickDirection;
    this.symbol = symbol;
    this.trdMatchID = trdMatchID;
    this.homeNotional = homeNotional;
    this.foreignNotional = foreignNotional;
    this.grossValue = grossValue;
  }

  public Double getPrice() {

    return price;
  }

  public Double getSize() {

    return size;
  }

  public Date getTime() {

    return timestamp;
  }

  public BitmexSide getSide() {

    return side;
  }

  public BitmexTickDirection getTickDirection() {

    return tickDirection;
  }

  public String getSymbol() {

    return symbol;
  }

  public String getTrdMatchID() {

    return trdMatchID;
  }

  @Override
  public String toString() {

    return "BitmexPublicTrade [symbol="
        + symbol
        + " price="
        + price
        + ", size="
        + size
        + ", time="
        + timestamp
        + ", side="
        + side
        + ", tickDirection="
        + tickDirection
        + "]";
  }
}
