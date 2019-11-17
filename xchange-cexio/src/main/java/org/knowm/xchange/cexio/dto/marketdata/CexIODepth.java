package org.knowm.xchange.cexio.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Author: brox Since: 2/5/14 */
public class CexIODepth {

  private final String error;
  private final Long timestamp;
  private final List<List<Double>> bids;
  private final List<List<Double>> asks;

  public CexIODepth(@JsonProperty("timestamp") String error) {
    this.error = error;
    this.bids = null;
    this.asks = null;
    this.timestamp = null;
  }

  public CexIODepth(
      @JsonProperty("timestamp") Long timestamp,
      @JsonProperty("bids") List<List<Double>> bids,
      @JsonProperty("asks") List<List<Double>> asks) {
    this.bids = bids;
    this.asks = asks;
    this.timestamp = timestamp;
    this.error = null;
  }

  public String getError() {
    return error;
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

    return "CexIOOrderBook [timestamp=" + timestamp + ", bids=" + bids + ", asks=" + asks + "]";
  }
}
