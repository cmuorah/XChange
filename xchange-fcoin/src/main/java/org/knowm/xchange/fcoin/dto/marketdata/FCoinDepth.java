package org.knowm.xchange.fcoin.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Date;

public class FCoinDepth {
  private final Double[][] asks;
  private final Double[][] bids;
  private final Date ts;
  private final Long seq;

  public FCoinDepth(
      @JsonProperty("asks") Double[] asks,
      @JsonProperty("bids") Double[] bids,
      @JsonProperty(required = false, value = "ts") Long ts,
      @JsonProperty(required = false, value = "seq") Long seq) {

    this.asks = new Double[asks.length / 2][];
    for (int i = 0; i < asks.length / 2; i++) {
      this.asks[i] = new Double[2];
      this.asks[i][0] = asks[i * 2];
      this.asks[i][1] = asks[i * 2 + 1];
    }
    this.bids = new Double[bids.length / 2][];
    for (int i = 0; i < asks.length / 2; i++) {
      this.bids[i] = new Double[2];
      this.bids[i][0] = bids[i * 2];
      this.bids[i][1] = bids[i * 2 + 1];
    }
    this.ts = new Date(ts);
    this.seq = seq;
  }

  public Double[][] getAsks() {
    return this.asks;
  }

  public Double[][] getBids() {
    return this.bids;
  }

  public Date getTs() {
    return ts;
  }

  public Long getSeq() {
    return seq;
  }

  public String toString() {
    return "FcoinDepth [asks="
        + Arrays.toString(this.asks)
        + ", bids="
        + Arrays.toString(this.bids)
        + "]";
  }
}
