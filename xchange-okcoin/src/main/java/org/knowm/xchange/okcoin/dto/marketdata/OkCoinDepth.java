package org.knowm.xchange.okcoin.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Date;

public class OkCoinDepth {

  private final Double[][] asks;
  private final Double[][] bids;
  private final Date timestamp;

  public OkCoinDepth(
      @JsonProperty("asks") final Double[][] asks,
      @JsonProperty("bids") final Double[][] bids,
      @JsonProperty(required = false, value = "timestamp") Date timestamp) {

    this.asks = asks;
    this.bids = bids;
    this.timestamp = timestamp;
  }

  public Double[][] getAsks() {

    return asks;
  }

  public Double[][] getBids() {

    return bids;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {

    return "OkCoinDepth [asks=" + Arrays.toString(asks) + ", bids=" + Arrays.toString(bids) + "]";
  }
}
