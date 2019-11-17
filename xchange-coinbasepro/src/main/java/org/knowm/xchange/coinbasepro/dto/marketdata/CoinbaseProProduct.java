package org.knowm.xchange.coinbasepro.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinbaseProProduct {

  private final String id;
  private final String baseCurrency;
  private final String targetCurrency;
  private final Double baseMinSize;
  private final Double baseMaxSize;
  private final Double minMarketFunds;
  private final Double maxMarketFunds;
  private final Double baseIncrement;
  private final Double quoteIncrement;
  private final boolean limitOnly;
  private final String status;

  public CoinbaseProProduct(
      @JsonProperty("id") String id,
      @JsonProperty("base_currency") String baseCurrency,
      @JsonProperty("quote_currency") String targetCurrency,
      @JsonProperty("base_min_size") Double baseMinSize,
      @JsonProperty("base_max_size") Double baseMaxSize,
      @JsonProperty("min_market_funds") Double minMarketFunds,
      @JsonProperty("max_market_funds") Double maxMarketFunds,
      @JsonProperty("base_increment") Double baseIncrement,
      @JsonProperty("quote_increment") Double quoteIncrement,
      @JsonProperty("limit_only") boolean limitOnly,
      @JsonProperty("status") String status) {

    this.id = id;
    this.baseCurrency = baseCurrency;
    this.targetCurrency = targetCurrency;
    this.baseMinSize = baseMinSize;
    this.baseMaxSize = baseMaxSize;
    this.minMarketFunds = minMarketFunds;
    this.maxMarketFunds = maxMarketFunds;
    this.baseIncrement = baseIncrement;
    this.quoteIncrement = quoteIncrement;
    this.limitOnly = limitOnly;
    this.status = status;
  }

  public String getId() {

    return id;
  }

  public String getBaseCurrency() {

    return baseCurrency;
  }

  public String getTargetCurrency() {

    return targetCurrency;
  }

  public Double getBaseMinSize() {

    return baseMinSize;
  }

  public Double getBaseMaxSize() {

    return baseMaxSize;
  }

  public Double getBaseIncrement() {
    return baseIncrement;
  }

  public Double getQuoteIncrement() {

    return quoteIncrement;
  }

  public Double getMinMarketFunds() {
    return minMarketFunds;
  }

  public Double getMaxMarketFunds() {
    return maxMarketFunds;
  }

  public boolean isLimitOnly() {
    return limitOnly;
  }

  public String getStatus() {
    return status;
  }
}
