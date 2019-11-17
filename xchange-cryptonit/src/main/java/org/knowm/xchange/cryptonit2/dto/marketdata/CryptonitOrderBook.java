package org.knowm.xchange.cryptonit2.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;

/** @author Matija Mazi */
public class CryptonitOrderBook {

  private final Date timestamp;
  private final List<List<Double>> bids;
  private final List<List<Double>> asks;

  /**
   * Constructor
   *
   * @param timestamp
   * @param bids
   * @param asks
   */
  public CryptonitOrderBook(
      @JsonProperty("timestamp") Long timestamp,
      @JsonProperty("bids") List<List<Double>> bids,
      @JsonProperty("asks") List<List<Double>> asks) {

    this.bids = bids;
    this.asks = asks;
    this.timestamp = new Date(timestamp * 1000);
  }

  /** @return Timestamp in Unix milliseconds */
  public Date getTimestamp() {

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

    return "CryptonitOrderBook [timestamp=" + timestamp + ", bids=" + bids + ", asks=" + asks + "]";
  }
}
