package org.knowm.xchange.dsx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** @author Mikhail Wall */
public final class DSXOrderbook {

  private final List<Double[]> asks;
  private final List<Double[]> bids;
  private final Double marketBuyPrice;
  private final Double marketSellPrice;

  public DSXOrderbook(
      @JsonProperty("asks") List<Double[]> asks,
      @JsonProperty("bids") List<Double[]> bids,
      @JsonProperty("market_buy_price") Double marketBuyPrice,
      @JsonProperty("market_sell_price") Double marketSellPrice) {

    this.asks = asks;
    this.bids = bids;
    this.marketBuyPrice = marketBuyPrice;
    this.marketSellPrice = marketSellPrice;
  }

  public List<Double[]> getAsks() {

    return asks;
  }

  public List<Double[]> getBids() {

    return bids;
  }

  public Double getMarketBuyPrice() {

    return marketBuyPrice;
  }

  public Double getMarketSellPrice() {

    return marketSellPrice;
  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder("DSXOrderbook [asks=");
    for (Double[] a : asks) {
      sb.append("[").append(a[0].toString()).append(",").append(a[1].toString()).append("],");
    }
    sb.append(" bids=");
    for (Double[] b : bids) {
      sb.append("[").append(b[0].toString()).append(",").append(b[1].toString()).append("],");
    }
    sb.append(", marketBuyPrice=");
    sb.append(marketBuyPrice);
    sb.append(", marketSellPrice=");
    sb.append(marketSellPrice);
    sb.append("]");
    return sb.toString();
  }
}
