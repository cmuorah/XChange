package org.knowm.xchange.cryptopia.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class CryptopiaTicker {

  private final long tradePairId;
  private final String label;
  private final Double ask;
  private final Double bid;
  private final Double low;
  private final Double high;
  private final Double volume;
  private final Double last;
  private final Double buyVolume;
  private final Double sellVolume;
  private final Double change;
  private final Double open;
  private final Double close;
  private final Double baseVolume;
  private final Double buyBaseVolume;
  private final Double sellBaseVolume;

  public CryptopiaTicker(
      @JsonProperty("TradePairId") long tradePairId,
      @JsonProperty("Label") String label,
      @JsonProperty("AskPrice") Double ask,
      @JsonProperty("BidPrice") Double bid,
      @JsonProperty("Low") Double low,
      @JsonProperty("High") Double high,
      @JsonProperty("Volume") Double volume,
      @JsonProperty("LastPrice") Double last,
      @JsonProperty("BuyVolume") Double buyVolume,
      @JsonProperty("SellVolume") Double sellVolume,
      @JsonProperty("Change") Double change,
      @JsonProperty("Open") Double open,
      @JsonProperty("Close") Double close,
      @JsonProperty("BaseVolume") Double baseVolume,
      @JsonProperty("BuyBaseVolume") Double buyBaseVolume,
      @JsonProperty("SellBaseVolume") Double sellBaseVolume) {
    this.tradePairId = tradePairId;
    this.label = label;
    this.ask = ask;
    this.bid = bid;
    this.low = low;
    this.high = high;
    this.volume = volume;
    this.last = last;
    this.buyVolume = buyVolume;
    this.sellVolume = sellVolume;
    this.change = change;
    this.open = open;
    this.close = close;
    this.baseVolume = baseVolume;
    this.buyBaseVolume = buyBaseVolume;
    this.sellBaseVolume = sellBaseVolume;
  }

  public long getTradePairId() {
    return tradePairId;
  }

  public String getLabel() {
    return label;
  }

  public Double getAsk() {
    return ask;
  }

  public Double getBid() {
    return bid;
  }

  public Double getLow() {
    return low;
  }

  public Double getHigh() {
    return high;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getLast() {
    return last;
  }

  public Double getBuyVolume() {
    return buyVolume;
  }

  public Double getSellVolume() {
    return sellVolume;
  }

  public Double getChange() {
    return change;
  }

  public Double getOpen() {
    return open;
  }

  public Double getClose() {
    return close;
  }

  public Double getBaseVolume() {
    return baseVolume;
  }

  public Double getBuyBaseVolume() {
    return buyBaseVolume;
  }

  public Double getSellBaseVolume() {
    return sellBaseVolume;
  }

  @Override
  public String toString() {
    return "CryptopiaTicker{"
        + "tradePairId="
        + tradePairId
        + ", label='"
        + label
        + '\''
        + ", ask="
        + ask
        + ", bid="
        + bid
        + ", low="
        + low
        + ", high="
        + high
        + ", volume="
        + volume
        + ", last="
        + last
        + ", buyVolume="
        + buyVolume
        + ", sellVolume="
        + sellVolume
        + ", change="
        + change
        + ", open="
        + open
        + ", close="
        + close
        + ", baseVolume="
        + baseVolume
        + ", buyBaseVolume="
        + buyBaseVolume
        + ", sellBaseVolume="
        + sellBaseVolume
        + '}';
  }
}
