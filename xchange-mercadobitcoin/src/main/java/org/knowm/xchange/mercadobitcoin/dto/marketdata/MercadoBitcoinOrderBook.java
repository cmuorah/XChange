package org.knowm.xchange.mercadobitcoin.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * @author Matija Mazi
 * @author Felipe Micaroni Lalli
 */
public class MercadoBitcoinOrderBook {

  private final List<List<Double>> bids;
  private final List<List<Double>> asks;

  /**
   * Constructor
   *
   * @param bids
   * @param asks
   */
  public MercadoBitcoinOrderBook(
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

    return "MercadoBitcoinOrderBook [bids=" + bids + ", asks=" + asks + "]";
  }
}
