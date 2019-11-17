package org.knowm.xchange.cryptopia.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class CryptopiaTradePair {

  private final long id;
  private final String label;
  private final String currency;
  private final String symbol;
  private final String baseCurrency;
  private final String baseSymbol;
  private final String status;
  private final String statusMessage;
  private final Double tradeFee;
  private final Double minimumTrade;
  private final Double maximumTrade;
  private final Double minimumBaseTrade;
  private final Double maximumBaseTrade;
  private final Double minimumPrice;
  private final Double maximumPrice;

  public CryptopiaTradePair(
      @JsonProperty("Id") long id,
      @JsonProperty("Label") String label,
      @JsonProperty("Currency") String currency,
      @JsonProperty("Symbol") String symbol,
      @JsonProperty("BaseCurrency") String baseCurrency,
      @JsonProperty("BaseSymbol") String baseSymbol,
      @JsonProperty("Status") String status,
      @JsonProperty("StatusMessage") String statusMessage,
      @JsonProperty("TradeFee") Double tradeFee,
      @JsonProperty("MinimumTrade") Double minimumTrade,
      @JsonProperty("MaximumTrade") Double maximumTrade,
      @JsonProperty("MinimumBaseTrade") Double minimumBaseTrade,
      @JsonProperty("MaximumBaseTrade") Double maximumBaseTrade,
      @JsonProperty("MinimumPrice") Double minimumPrice,
      @JsonProperty("MaximumPrice") Double maximumPrice) {
    this.id = id;
    this.label = label;
    this.currency = currency;
    this.symbol = symbol;
    this.baseCurrency = baseCurrency;
    this.baseSymbol = baseSymbol;
    this.status = status;
    this.statusMessage = statusMessage;
    this.tradeFee = tradeFee;
    this.minimumTrade = minimumTrade;
    this.maximumTrade = maximumTrade;
    this.minimumBaseTrade = minimumBaseTrade;
    this.maximumBaseTrade = maximumBaseTrade;
    this.minimumPrice = minimumPrice;
    this.maximumPrice = maximumPrice;
  }

  public long getId() {
    return id;
  }

  public String getLabel() {
    return label;
  }

  public String getCurrency() {
    return currency;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getBaseCurrency() {
    return baseCurrency;
  }

  public String getBaseSymbol() {
    return baseSymbol;
  }

  public String getStatus() {
    return status;
  }

  public String getStatusMessage() {
    return statusMessage;
  }

  public Double getTradeFee() {
    return tradeFee;
  }

  public Double getMinimumTrade() {
    return minimumTrade;
  }

  public Double getMaximumTrade() {
    return maximumTrade;
  }

  public Double getMinimumBaseTrade() {
    return minimumBaseTrade;
  }

  public Double getMaximumBaseTrade() {
    return maximumBaseTrade;
  }

  public Double getMinimumPrice() {
    return minimumPrice;
  }

  public Double getMaximumPrice() {
    return maximumPrice;
  }

  @Override
  public String toString() {
    return "CryptopiaTradePair{"
        + "id="
        + id
        + ", label='"
        + label
        + '\''
        + ", currency='"
        + currency
        + '\''
        + ", symbol='"
        + symbol
        + '\''
        + ", baseCurrency='"
        + baseCurrency
        + '\''
        + ", baseSymbol='"
        + baseSymbol
        + '\''
        + ", status='"
        + status
        + '\''
        + ", statusMessage='"
        + statusMessage
        + '\''
        + ", tradeFee="
        + tradeFee
        + ", minimumTrade="
        + minimumTrade
        + ", maximumTrade="
        + maximumTrade
        + ", minimumBaseTrade="
        + minimumBaseTrade
        + ", maximumBaseTrade="
        + maximumBaseTrade
        + ", minimumPrice="
        + minimumPrice
        + ", maximumPrice="
        + maximumPrice
        + '}';
  }
}
