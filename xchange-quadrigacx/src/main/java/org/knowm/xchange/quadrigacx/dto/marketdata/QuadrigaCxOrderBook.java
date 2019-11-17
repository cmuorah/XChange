package org.knowm.xchange.quadrigacx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import si.mazi.rescu.ExceptionalReturnContentException;

public class QuadrigaCxOrderBook {

  private final Long timestamp;
  private final List<List<Double>> bids;
  private final List<List<Double>> asks;

  /**
   * Constructor
   *
   * @param timestamp
   * @param bids
   * @param asks
   */
  public QuadrigaCxOrderBook(
      @JsonProperty("timestamp") Long timestamp,
      @JsonProperty("bids") List<List<Double>> bids,
      @JsonProperty("asks") List<List<Double>> asks) {

    if (asks == null) {
      throw new ExceptionalReturnContentException("No asks in response.");
    }
    this.bids = bids;
    this.asks = asks;
    this.timestamp = timestamp;
  }

  /** @return Timestamp in Unix milliseconds */
  public Long getTimestamp() {

    return timestamp;
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

    return "QuadrigaCxOrderBook [timestamp="
        + timestamp
        + ", bids="
        + bids
        + ", asks="
        + asks
        + "]";
  }
}
