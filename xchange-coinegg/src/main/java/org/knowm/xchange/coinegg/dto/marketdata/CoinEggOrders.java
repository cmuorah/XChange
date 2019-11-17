package org.knowm.xchange.coinegg.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinEggOrders {

  private final CoinEggOrder[] asks;
  private final CoinEggOrder[] bids;

  public CoinEggOrders(
      @JsonProperty("asks") CoinEggOrder[] asks, @JsonProperty("bids") CoinEggOrder[] bids) {
    this.asks = asks;
    this.bids = bids;
  }

  public CoinEggOrder[] getAsks() {
    return asks;
  }

  public CoinEggOrder[] getBids() {
    return bids;
  }

  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  public static class CoinEggOrder {

    @JsonProperty() private Double price;
    @JsonProperty() private Double quantity;

    public final Double getPrice() {
      return price;
    }

    public final Double getQuantity() {
      return quantity;
    }
  }
}
