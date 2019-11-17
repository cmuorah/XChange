package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.knowm.xchange.binance.BinanceAdapters;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;

public final class BinanceTicker24h {

  private final Double priceChange;
  private final Double priceChangePercent;
  private final Double weightedAvgPrice;
  private final Double prevClosePrice;
  private final Double lastPrice;
  private final Double lastQty;
  private final Double bidPrice;
  private final Double bidQty;
  private final Double askPrice;
  private final Double askQty;
  private final Double openPrice;
  private final Double highPrice;
  private final Double lowPrice;
  private final Double volume;
  private final Double quoteVolume;
  private final long openTime;
  private final long closeTime;
  private final long firstId;
  private final long lastId;
  private final long count;
  private final String symbol;

  // The curency pair that is unfortunately not returned in the response
  private CurrencyPair pair;

  // The cached ticker
  private Ticker ticker;

  public BinanceTicker24h(
      @JsonProperty("priceChange") Double priceChange,
      @JsonProperty("priceChangePercent") Double priceChangePercent,
      @JsonProperty("weightedAvgPrice") Double weightedAvgPrice,
      @JsonProperty("prevClosePrice") Double prevClosePrice,
      @JsonProperty("lastPrice") Double lastPrice,
      @JsonProperty("lastQty") Double lastQty,
      @JsonProperty("bidPrice") Double bidPrice,
      @JsonProperty("bidQty") Double bidQty,
      @JsonProperty("askPrice") Double askPrice,
      @JsonProperty("askQty") Double askQty,
      @JsonProperty("openPrice") Double openPrice,
      @JsonProperty("highPrice") Double highPrice,
      @JsonProperty("lowPrice") Double lowPrice,
      @JsonProperty("volume") Double volume,
      @JsonProperty("quoteVolume") Double quoteVolume,
      @JsonProperty("openTime") long openTime,
      @JsonProperty("closeTime") long closeTime,
      @JsonProperty("firstId") long firstId,
      @JsonProperty("lastId") long lastId,
      @JsonProperty("count") long count,
      @JsonProperty("symbol") String symbol) {
    this.priceChange = priceChange;
    this.priceChangePercent = priceChangePercent;
    this.weightedAvgPrice = weightedAvgPrice;
    this.prevClosePrice = prevClosePrice;
    this.lastPrice = lastPrice;
    this.lastQty = lastQty;
    this.bidPrice = bidPrice;
    this.bidQty = bidQty;
    this.askPrice = askPrice;
    this.askQty = askQty;
    this.openPrice = openPrice;
    this.highPrice = highPrice;
    this.lowPrice = lowPrice;
    this.volume = volume;
    this.quoteVolume = quoteVolume;
    this.openTime = openTime;
    this.closeTime = closeTime;
    this.firstId = firstId;
    this.lastId = lastId;
    this.count = count;
    this.symbol = symbol;
  }

  public String getSymbol() {
    return symbol;
  }

  public CurrencyPair getCurrencyPair() {
    return pair;
  }

  public void setCurrencyPair(CurrencyPair pair) {
    this.pair = pair;
  }

  public Double getPriceChange() {
    return priceChange;
  }

  public Double getPriceChangePercent() {
    return priceChangePercent;
  }

  public Double getWeightedAvgPrice() {
    return weightedAvgPrice;
  }

  public Double getPrevClosePrice() {
    return prevClosePrice;
  }

  public Double getLastPrice() {
    return lastPrice;
  }

  public Double getLastQty() {
    return lastQty;
  }

  public Double getBidPrice() {
    return bidPrice;
  }

  public Double getBidQty() {
    return bidQty;
  }

  public Double getAskPrice() {
    return askPrice;
  }

  public Double getAskQty() {
    return askQty;
  }

  public Double getOpenPrice() {
    return openPrice;
  }

  public Double getHighPrice() {
    return highPrice;
  }

  public Double getLowPrice() {
    return lowPrice;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getQuoteVolume() {
    return quoteVolume;
  }

  public long getFirstTradeId() {
    return firstId;
  }

  public long getLastTradeId() {
    return lastId;
  }

  public long getTradeCount() {
    return count;
  }

  public Date getOpenTime() {
    return new Date(openTime);
  }

  public Date getCloseTime() {
    return new Date(closeTime);
  }

  public synchronized Ticker toTicker() {
    CurrencyPair currencyPair = pair;
    if (currencyPair == null) {
      currencyPair = BinanceAdapters.adaptSymbol(symbol);
    }
    if (ticker == null) {
      ticker =
          new Ticker.Builder()
              .currencyPair(currencyPair)
              .open(openPrice)
              .ask(askPrice)
              .bid(bidPrice)
              .last(lastPrice)
              .high(highPrice)
              .low(lowPrice)
              .volume(volume)
              .vwap(weightedAvgPrice)
              .askSize(askQty)
              .bidSize(bidQty)
              .quoteVolume(quoteVolume)
              .build();
    }
    return ticker;
  }
}
