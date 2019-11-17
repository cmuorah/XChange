package org.knowm.xchange.dragonex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ticker {

  public final Double closePrice;
  public final Double currentVolume;
  public final Double maxPrice;
  public final Double minPrice;
  public final Double openPrice;
  public final Double priceBase;
  public final Double priceChange;
  public final Double priceChangeRate;
  public final long timestamp;
  public final Double totalAmount;
  public final Double totalVolume;
  public final Double usdtAmount;
  public final long symbolId;

  public Ticker(
      @JsonProperty("close_price") Double closePrice,
      @JsonProperty("current_volume") Double currentVolume,
      @JsonProperty("max_price") Double maxPrice,
      @JsonProperty("min_price") Double minPrice,
      @JsonProperty("open_price") Double openPrice,
      @JsonProperty("price_base") Double priceBase,
      @JsonProperty("price_change") Double priceChange,
      @JsonProperty("price_change_rate") Double priceChangeRate,
      @JsonProperty("timestamp") long timestamp,
      @JsonProperty("total_amount") Double totalAmount,
      @JsonProperty("total_volume") Double totalVolume,
      @JsonProperty("usdt_amount") Double usdtAmount,
      @JsonProperty("symbol_id") long symbolId) {
    this.closePrice = closePrice;
    this.currentVolume = currentVolume;
    this.maxPrice = maxPrice;
    this.minPrice = minPrice;
    this.openPrice = openPrice;
    this.priceBase = priceBase;
    this.priceChange = priceChange;
    this.priceChangeRate = priceChangeRate;
    this.timestamp = timestamp;
    this.totalAmount = totalAmount;
    this.totalVolume = totalVolume;
    this.usdtAmount = usdtAmount;
    this.symbolId = symbolId;
  }

  @Override
  public String toString() {
    return "Ticker ["
        + (closePrice != null ? "closePrice=" + closePrice + ", " : "")
        + (currentVolume != null ? "currentVolume=" + currentVolume + ", " : "")
        + (maxPrice != null ? "maxPrice=" + maxPrice + ", " : "")
        + (minPrice != null ? "minPrice=" + minPrice + ", " : "")
        + (openPrice != null ? "openPrice=" + openPrice + ", " : "")
        + (priceBase != null ? "priceBase=" + priceBase + ", " : "")
        + (priceChange != null ? "priceChange=" + priceChange + ", " : "")
        + (priceChangeRate != null ? "priceChangeRate=" + priceChangeRate + ", " : "")
        + "timestamp="
        + timestamp
        + ", "
        + (totalAmount != null ? "totalAmount=" + totalAmount + ", " : "")
        + (totalVolume != null ? "totalVolume=" + totalVolume + ", " : "")
        + (usdtAmount != null ? "usdtAmount=" + usdtAmount + ", " : "")
        + "symbolId="
        + symbolId
        + "]";
  }
}
