package org.knowm.xchange.btctrade.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BTCTradeDepth {

  private final Double[][] asks;
  private final Double[][] bids;

  public BTCTradeDepth(
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
}
