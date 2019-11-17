package org.knowm.xchange.cobinhood.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CobinhoodOrderBook {
  private final List<List<Double>> asks;
  private final List<List<Double>> bids;

  public CobinhoodOrderBook(
      @JsonProperty("asks") List<List<Double>> asks,
      @JsonProperty("bids") List<List<Double>> bids) {
    this.asks = asks;
    this.bids = bids;
  }

  public List<List<Double>> getAsks() {
    return asks;
  }

  public List<List<Double>> getBids() {
    return bids;
  }

  @Override
  public String toString() {
    return "CobinhoodOrderBook{" + "asks=" + asks + ", bids=" + bids + '}';
  }

  public static class Container {
    private final CobinhoodOrderBook orderBook;

    public Container(@JsonProperty("orderbook") CobinhoodOrderBook orderBook) {
      this.orderBook = orderBook;
    }

    public CobinhoodOrderBook getOrderBook() {
      return orderBook;
    }
  }
}
