package org.knowm.xchange.lakebtc.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

/** @author kpysniak */
public class LakeBTCOrderBook {

  private final Double[][] asks;
  private final Double[][] bids;

  /**
   * Constructor
   *
   * @param asks
   * @param bids
   */
  public LakeBTCOrderBook(
      @JsonProperty("asks") Double[][] asks, @JsonProperty("bids") Double[][] bids) {

    this.asks = asks;
    this.bids = bids;
  }

  public Double[][] getAsks() {

    return asks;
  }

  public Double[][] getBids() {

    return bids;
  }

  @Override
  public String toString() {

    StringBuilder asksBuilder = new StringBuilder();
    StringBuilder bidsBuilder = new StringBuilder();

    for (Double[] ask : getAsks()) {
      asksBuilder.append(Arrays.toString(ask) + ";");
    }

    for (Double[] bid : getBids()) {
      bidsBuilder.append(Arrays.toString(bid) + ";");
    }

    return "LakeBTCOrderBook{" + "asks=" + asksBuilder + ", bids=" + bidsBuilder + '}';
  }
}
