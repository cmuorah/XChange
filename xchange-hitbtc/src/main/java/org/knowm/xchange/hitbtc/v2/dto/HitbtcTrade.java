package org.knowm.xchange.hitbtc.v2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class HitbtcTrade {

  private final String id;
  private final Double price;
  private final Double quantity;
  private final HitbtcSide side;
  private final Date timestamp;

  public HitbtcTrade(
      @JsonProperty("id") String id,
      @JsonProperty("price") Double price,
      @JsonProperty("quantity") Double quantity,
      @JsonProperty("side") HitbtcSide side,
      @JsonProperty("timestamp") Date timestamp) {
    this.id = id;
    this.price = price;
    this.quantity = quantity;
    this.side = side;
    this.timestamp = timestamp;
  }

  public String getId() {
    return id;
  }

  public Double getPrice() {
    return price;
  }

  public Double getQuantity() {
    return quantity;
  }

  public HitbtcSide getSide() {
    return side;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return "HitbtcTrade{"
        + "id='"
        + id
        + '\''
        + ", price="
        + price
        + ", quantity="
        + quantity
        + ", side="
        + side
        + ", timestamp="
        + timestamp
        + '}';
  }

  public enum HitbtcTradesSortField {
    SORT_BY_TRADE_ID("trade_id"),
    SORT_BY_TIMESTAMP("ts");

    private final String hitbtcTradesSortField;

    HitbtcTradesSortField(String hitbtcTradesSortField) {

      this.hitbtcTradesSortField = hitbtcTradesSortField;
    }

    @Override
    public String toString() {

      return hitbtcTradesSortField;
    }
  }
}
