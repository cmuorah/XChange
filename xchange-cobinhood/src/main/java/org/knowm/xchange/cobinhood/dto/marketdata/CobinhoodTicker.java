package org.knowm.xchange.cobinhood.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CobinhoodTicker {
  private final String tradingPairId;
  private final long timestamp;
  private final Double dayHigh;
  private final Double dayLow;
  private final Double dayOpen;
  private final Double dayVolume;
  private final Double lastTradePrice;
  private final Double highestBid;
  private final Double lowestAsk;

  public CobinhoodTicker(
      @JsonProperty("trading_pair_id") String tradingPairId,
      @JsonProperty("timestamp") long timestamp,
      @JsonProperty("24h_high") Double dayHigh,
      @JsonProperty("24h_low") Double dayLow,
      @JsonProperty("24h_open") Double dayOpen,
      @JsonProperty("24h_volume") Double dayVolume,
      @JsonProperty("last_trade_price") Double lastTradePrice,
      @JsonProperty("highest_bid") Double highestBid,
      @JsonProperty("lowest_ask") Double lowestAsk) {
    this.tradingPairId = tradingPairId;
    this.timestamp = timestamp;
    this.dayHigh = dayHigh;
    this.dayLow = dayLow;
    this.dayOpen = dayOpen;
    this.dayVolume = dayVolume;
    this.lastTradePrice = lastTradePrice;
    this.highestBid = highestBid;
    this.lowestAsk = lowestAsk;
  }

  public String getTradingPairId() {
    return tradingPairId;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public Double getDayHigh() {
    return dayHigh;
  }

  public Double getDayLow() {
    return dayLow;
  }

  public Double getDayOpen() {
    return dayOpen;
  }

  public Double getDayVolume() {
    return dayVolume;
  }

  public Double getLastTradePrice() {
    return lastTradePrice;
  }

  public Double getHighestBid() {
    return highestBid;
  }

  public Double getLowestAsk() {
    return lowestAsk;
  }

  @Override
  public String toString() {
    return "CobinhoodTicker{"
        + "tradingPairId='"
        + tradingPairId
        + '\''
        + ", timestamp="
        + timestamp
        + ", dayHigh="
        + dayHigh
        + ", dayLow="
        + dayLow
        + ", dayOpen="
        + dayOpen
        + ", dayVolume="
        + dayVolume
        + ", lastTradePrice="
        + lastTradePrice
        + ", highestBid="
        + highestBid
        + ", lowestAsk="
        + lowestAsk
        + '}';
  }

  public static class Container {
    private final CobinhoodTicker ticker;

    public Container(@JsonProperty("ticker") CobinhoodTicker ticker) {
      this.ticker = ticker;
    }

    public CobinhoodTicker getTicker() {
      return ticker;
    }
  }
}
