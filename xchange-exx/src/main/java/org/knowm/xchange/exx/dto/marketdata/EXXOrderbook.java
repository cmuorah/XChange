package org.knowm.xchange.exx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class EXXOrderbook {
  @JsonProperty("asks")
  private List<Double[]> asks = null;

  @JsonProperty("bids")
  private List<Double[]> bids = null;

  @JsonProperty("timestamp")
  private long timestamp;

  /** No args constructor for use in serialization */
  public EXXOrderbook() {}

  /**
   * @param timestamp
   * @param asks
   * @param bids
   */
  public EXXOrderbook(List<Double[]> asks, List<Double[]> bids, long timestamp) {
    super();
    this.asks = asks;
    this.bids = bids;
    this.timestamp = timestamp;
  }

  @JsonProperty("asks")
  public List<Double[]> getAsks() {
    return asks;
  }

  @JsonProperty("asks")
  public void setAsks(List<Double[]> asks) {
    this.asks = asks;
  }

  @JsonProperty("bids")
  public List<Double[]> getBids() {
    return bids;
  }

  @JsonProperty("bids")
  public void setBids(List<Double[]> bids) {
    this.bids = bids;
  }

  @JsonProperty("timestamp")
  public long getTimestamp() {
    return timestamp;
  }

  @JsonProperty("timestamp")
  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("asks", asks)
        .append("bids", bids)
        .append("timestamp", timestamp)
        .toString();
  }
}
