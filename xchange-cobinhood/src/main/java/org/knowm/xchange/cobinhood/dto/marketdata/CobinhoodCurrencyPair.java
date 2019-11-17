package org.knowm.xchange.cobinhood.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CobinhoodCurrencyPair {

  private final String baseCurrencyId;
  private final boolean marginEnabled;
  private final Double makerFee;
  private final Double quoteIncrement;
  private final Double baseMaxSize;
  private final Double takerFee;
  private final String quoteCurrencyId;
  private final String id;
  private final Double baseMinSize;

  public CobinhoodCurrencyPair(
      @JsonProperty("base_currency_id") String baseCurrencyId,
      @JsonProperty("margin_enabled") boolean marginEnabled,
      @JsonProperty("maker_fee") Double makerFee,
      @JsonProperty("quote_increment") Double quoteIncrement,
      @JsonProperty("base_max_size") Double baseMaxSize,
      @JsonProperty("taker_fee") Double takerFee,
      @JsonProperty("quote_currency_id") String quoteCurrencyId,
      @JsonProperty("id") String id,
      @JsonProperty("base_min_size") Double baseMinSize) {
    this.baseCurrencyId = baseCurrencyId;
    this.marginEnabled = marginEnabled;
    this.makerFee = makerFee;
    this.quoteIncrement = quoteIncrement;
    this.baseMaxSize = baseMaxSize;
    this.takerFee = takerFee;
    this.quoteCurrencyId = quoteCurrencyId;
    this.id = id;
    this.baseMinSize = baseMinSize;
  }

  public String getBaseCurrencyId() {
    return baseCurrencyId;
  }

  public boolean isMarginEnabled() {
    return marginEnabled;
  }

  public Double getMakerFee() {
    return makerFee;
  }

  public Double getQuoteIncrement() {
    return quoteIncrement;
  }

  public Double getBaseMaxSize() {
    return baseMaxSize;
  }

  public Double getTakerFee() {
    return takerFee;
  }

  public String getQuoteCurrencyId() {
    return quoteCurrencyId;
  }

  public String getId() {
    return id;
  }

  public Double getBaseMinSize() {
    return baseMinSize;
  }

  @Override
  public String toString() {
    return "CobinhoodCurrencyPair{"
        + "baseCurrencyId='"
        + baseCurrencyId
        + '\''
        + ", marginEnabled="
        + marginEnabled
        + ", makerFee="
        + makerFee
        + ", quoteIncrement="
        + quoteIncrement
        + ", baseMaxSize="
        + baseMaxSize
        + ", takerFee="
        + takerFee
        + ", quoteCurrencyId='"
        + quoteCurrencyId
        + '\''
        + ", id='"
        + id
        + '\''
        + ", baseMinSize="
        + baseMinSize
        + '}';
  }
}
