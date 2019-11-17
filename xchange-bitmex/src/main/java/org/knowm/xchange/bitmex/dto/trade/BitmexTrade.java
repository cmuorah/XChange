package org.knowm.xchange.bitmex.dto.trade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "timestamp",
  "symbol",
  "side",
  "size",
  "price",
  "tickDirection",
  "trdMatchID",
  "grossValue",
  "homeNotional",
  "foreignNotional"
})
public final class BitmexTrade {

  @JsonProperty("timestamp")
  public Date timestamp;

  @JsonProperty("symbol")
  public String symbol;

  @JsonProperty("side")
  public BitmexSide side;

  @JsonProperty("size")
  public Double size;

  @JsonProperty("price")
  public Double price;

  @JsonProperty("tickDirection")
  public BitmexTickDirection tickDirection;

  @JsonProperty("trdMatchID")
  public String trdMatchID;

  @JsonProperty("grossValue")
  public Double grossValue;

  @JsonProperty("homeNotional")
  public Double homeNotional;

  @JsonProperty("foreignNotional")
  public Double foreignNotional;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<>();

  public String getSymbol() {

    return symbol;
  }

  public BitmexSide getSide() {

    return side;
  }

  public Double getSize() {

    return size;
  }

  public Double getPrice() {

    return price;
  }

  public BitmexTickDirection getTickDirection() {

    return tickDirection;
  }

  public String getTrdMatchID() {

    return trdMatchID;
  }

  public Double getGrossValue() {

    return grossValue;
  }

  public Double getHomeNotional() {

    return homeNotional;
  }

  public Double getForeignNotional() {

    return foreignNotional;
  }

  public Map<String, Object> getAdditionalProperties() {

    return additionalProperties;
  }

  @Override
  public String toString() {

    return "BitmexTrade{"
        + "symbol='"
        + symbol
        + '\''
        + ", side='"
        + side
        + '\''
        + ", size="
        + size
        + ", price="
        + price
        + ", tickDirection='"
        + tickDirection
        + '\''
        + ", trdMatchID='"
        + trdMatchID
        + '\''
        + ", grossValue="
        + grossValue
        + ", homeNotional="
        + homeNotional
        + ", foreignNotional="
        + foreignNotional
        + '}';
  }
}
