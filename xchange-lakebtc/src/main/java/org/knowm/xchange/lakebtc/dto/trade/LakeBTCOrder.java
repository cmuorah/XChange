package org.knowm.xchange.lakebtc.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Created by cristian.lucaci on 12/19/2014. */
public class LakeBTCOrder {

  private final Double trades;

  private final Double totalTradedBtc;

  private final Double totalTradedCurrency;

  private final String currency;

  private final Double ppc;

  public LakeBTCOrder(
      @JsonProperty("trades") Double trades,
      @JsonProperty("total_traded_btc") Double totalTradedBtc,
      @JsonProperty("total_traded_currency") Double totalTradedCurrency,
      @JsonProperty("currency") String currency,
      @JsonProperty("ppc") Double ppc) {
    this.trades = trades;
    this.totalTradedBtc = totalTradedBtc;
    this.totalTradedCurrency = totalTradedCurrency;
    this.currency = currency;
    this.ppc = ppc;
  }

  public Double getTrades() {
    return trades;
  }

  public Double getTotalTradedBtc() {
    return totalTradedBtc;
  }

  public Double getTotalTradedCurrency() {
    return totalTradedCurrency;
  }

  public String getCurrency() {
    return currency;
  }

  public Double getPpc() {
    return ppc;
  }
}
