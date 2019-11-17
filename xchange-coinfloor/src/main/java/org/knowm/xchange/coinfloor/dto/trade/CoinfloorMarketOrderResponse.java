package org.knowm.xchange.coinfloor.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinfloorMarketOrderResponse {
  private final Double remaining;

  public CoinfloorMarketOrderResponse(@JsonProperty("remaining") Double remaining) {
    this.remaining = remaining;
  }

  public Double getRemaining() {
    return remaining;
  }

  @Override
  public String toString() {
    return String.format("MarketOrderResponse{remaining=%s}", remaining);
  }
}
