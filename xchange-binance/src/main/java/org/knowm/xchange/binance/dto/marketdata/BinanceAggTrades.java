package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public final class BinanceAggTrades {

  public final long aggregateTradeId;
  public final Double price;
  public final Double quantity;
  public final long firstTradeId;
  public final long lastTradeId;
  public final long timestamp;
  public final boolean buyerMaker;
  public final boolean bestPriceMatch;

  public BinanceAggTrades(
      @JsonProperty("a") long aggregateTradeId,
      @JsonProperty("p") Double price,
      @JsonProperty("q") Double quantity,
      @JsonProperty("f") long firstTradeId,
      @JsonProperty("l") long lastTradeId,
      @JsonProperty("T") long timestamp,
      @JsonProperty("m") boolean buyerMaker,
      @JsonProperty("M") boolean bestPriceMatch) {
    this.aggregateTradeId = aggregateTradeId;
    this.price = price;
    this.quantity = quantity;
    this.firstTradeId = firstTradeId;
    this.lastTradeId = lastTradeId;
    this.timestamp = timestamp;
    this.buyerMaker = buyerMaker;
    this.bestPriceMatch = bestPriceMatch;
  }

  public Date getTimestamp() {
    return new Date(timestamp);
  }
}
