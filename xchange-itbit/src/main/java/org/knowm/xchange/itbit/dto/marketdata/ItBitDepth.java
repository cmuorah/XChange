package org.knowm.xchange.itbit.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ItBitDepth {

  private final List<Double[]> asks;
  private final List<Double[]> bids;

  /**
   * Constructor
   *
   * @param asks
   * @param bids
   */
  public ItBitDepth(
      @JsonProperty("asks") List<Double[]> asks, @JsonProperty("bids") List<Double[]> bids) {

    this.asks = asks;
    this.bids = bids;
  }

  public List<Double[]> getAsks() {

    return asks;
  }

  public List<Double[]> getBids() {

    return bids;
  }

  @Override
  public String toString() {

    return "ItBitDepth [asks=" + asks.toString() + ", bids=" + bids.toString() + "]";
  }
}
