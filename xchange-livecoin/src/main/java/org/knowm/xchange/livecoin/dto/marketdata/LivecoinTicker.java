package org.knowm.xchange.livecoin.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.livecoin.dto.LivecoinBaseResponse;

public class LivecoinTicker extends LivecoinBaseResponse {
  private final String cur;
  private final String symbol;
  private final Double last;
  private final Double high;
  private final Double low;
  private final Double volume;
  private final Double vwap;
  private final Double maxBid;
  private final Double minAsk;
  private final Double bestBid;
  private final Double bestAsk;

  public LivecoinTicker(
      @JsonProperty("success") Boolean success,
      @JsonProperty("cur") String cur,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("last") Double last,
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("volume") Double volume,
      @JsonProperty("vwap") Double vwap,
      @JsonProperty("max_bid") Double maxBid,
      @JsonProperty("min_ask") Double minAsk,
      @JsonProperty("best_bid") Double bestBid,
      @JsonProperty("best_ask") Double bestAsk) {
    super(success);
    this.cur = cur;
    this.symbol = symbol;
    this.last = last;
    this.high = high;
    this.low = low;
    this.volume = volume;
    this.vwap = vwap;
    this.maxBid = maxBid;
    this.minAsk = minAsk;
    this.bestBid = bestBid;
    this.bestAsk = bestAsk;
  }

  public Double getLast() {
    return last;
  }

  public Double getHigh() {
    return high;
  }

  public Double getLow() {
    return low;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getVwap() {
    return vwap;
  }

  public Double getBestAsk() {
    return bestAsk;
  }

  public Double getMinAsk() {
    return minAsk;
  }

  public Double getMaxBid() {
    return maxBid;
  }

  public Double getBestBid() {
    return bestBid;
  }

  public String getCur() {
    return cur;
  }

  public String getSymbol() {
    return symbol;
  }

  @Override
  public String toString() {
    return "LivecoinTicker{"
        + "cur="
        + cur
        + ", symbol="
        + symbol
        + ", last="
        + last
        + ", high="
        + high
        + ", low="
        + low
        + ", volume="
        + volume
        + ", vwap="
        + vwap
        + ", maxBid="
        + maxBid
        + ", minAsk="
        + minAsk
        + ", bestBid="
        + bestBid
        + ", bestAsk="
        + bestAsk
        + '}';
  }
}
