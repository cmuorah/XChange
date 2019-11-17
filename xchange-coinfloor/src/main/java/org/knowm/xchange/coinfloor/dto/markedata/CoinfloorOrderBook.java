package org.knowm.xchange.coinfloor.dto.markedata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CoinfloorOrderBook {
  private final List<List<Double>> bids;
  private final List<List<Double>> asks;

  public CoinfloorOrderBook(
      @JsonProperty("bids") List<List<Double>> bids,
      @JsonProperty("asks") List<List<Double>> asks) {
    this.bids = bids;
    this.asks = asks;
  }

  /** (price, amount) */
  public List<List<Double>> getBids() {
    return bids;
  }

  /** (price, amount) */
  public List<List<Double>> getAsks() {
    return asks;
  }

  @Override
  public String toString() {
    return "CoinfloorOrderBook [bids=" + bids + ", asks=" + asks + "]";
  }
}
