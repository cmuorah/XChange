package org.knowm.xchange.coinbene.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.knowm.xchange.coinbene.dto.CoinbeneResponse;

public class CoinbeneTicker {
  private final String symbol;
  private final Double dayHigh;
  private final Double dayLow;
  private final Double last;
  private final Double ask;
  private final Double bid;
  private final Double dayVolume;
  private final Double dayAmount;

  public CoinbeneTicker(
      @JsonProperty("symbol") String symbol,
      @JsonProperty("24hrHigh") Double dayHigh,
      @JsonProperty("24hrLow") Double dayLow,
      @JsonProperty("last") Double last,
      @JsonProperty("ask") Double ask,
      @JsonProperty("bid") Double bid,
      @JsonProperty("24hrVol") Double dayVolume,
      @JsonProperty("24hrAmt") Double dayAmount) {
    this.symbol = symbol;
    this.dayHigh = dayHigh;
    this.dayLow = dayLow;
    this.last = last;
    this.ask = ask;
    this.bid = bid;
    this.dayVolume = dayVolume;
    this.dayAmount = dayAmount;
  }

  public String getSymbol() {
    return symbol;
  }

  public Double getDayHigh() {
    return dayHigh;
  }

  public Double getDayLow() {
    return dayLow;
  }

  public Double getLast() {
    return last;
  }

  public Double getAsk() {
    return ask;
  }

  public Double getBid() {
    return bid;
  }

  public Double getDayVolume() {
    return dayVolume;
  }

  public Double getDayAmount() {
    return dayAmount;
  }

  @Override
  public String toString() {
    return "CoinbeneTicker{"
        + "symbol='"
        + symbol
        + '\''
        + ", dayHigh="
        + dayHigh
        + ", dayLow="
        + dayLow
        + ", last="
        + last
        + ", ask="
        + ask
        + ", bid="
        + bid
        + ", dayVolume="
        + dayVolume
        + ", dayAmount="
        + dayAmount
        + '}';
  }

  public static class Container extends CoinbeneResponse {
    private final List<CoinbeneTicker> tickers;
    private final long timestamp;

    public Container(
        @JsonProperty("ticker") List<CoinbeneTicker> tickers,
        @JsonProperty("timestamp") long timestamp) {
      this.tickers = tickers;
      this.timestamp = timestamp;
    }

    public CoinbeneTicker getTicker() {
      return tickers.get(0);
    }

    public List<CoinbeneTicker> getTickers() {
      return tickers;
    }

    public long getTimestamp() {
      return timestamp;
    }
  }
}
