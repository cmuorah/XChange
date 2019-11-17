package org.knowm.xchange.wex.v3.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Data object representing depth from Wex */
public class WexDepth {

  private final List<Double[]> asks;
  private final List<Double[]> bids;

  /**
   * Constructor
   *
   * @param asks
   * @param bids
   */
  public WexDepth(
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

    StringBuilder sb = new StringBuilder("WexDepth [asks=");
    for (Double[] a : asks) {
      sb.append("[").append(a[0].toString()).append(",").append(a[1].toString()).append("],");
    }
    sb.append(" bids=");
    for (Double[] b : bids) {
      sb.append("[").append(b[0].toString()).append(",").append(b[1].toString()).append("],");
    }
    sb.append("]");

    return sb.toString();
  }
}
