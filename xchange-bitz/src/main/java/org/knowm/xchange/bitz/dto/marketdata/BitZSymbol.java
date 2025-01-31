package org.knowm.xchange.bitz.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitZSymbol {

  private final String symbol;
  private final String coin;
  private final String currencyCoin;
  private final Integer numberPrecision;
  private final Integer pricePrecision;
  private final Double minTrade;
  private final Double maxTrade;
  private final String orderBy;

  public BitZSymbol(
      @JsonProperty("symbol") String symbol,
      @JsonProperty("coin") String coin,
      @JsonProperty("currencyCoin") String currencyCoin,
      @JsonProperty("numberPrecision") Integer numberPrecision,
      @JsonProperty("pricePrecision") Integer pricePrecision,
      @JsonProperty("minTrade") Double minTrade,
      @JsonProperty("maxTrade") Double maxTrade,
      @JsonProperty("orderBy") String orderBy) {
    this.symbol = symbol;
    this.coin = coin;
    this.currencyCoin = currencyCoin;
    this.numberPrecision = numberPrecision;
    this.pricePrecision = pricePrecision;
    this.minTrade = minTrade;
    this.maxTrade = maxTrade;
    this.orderBy = orderBy;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getCoin() {
    return coin;
  }

  public String getCurrencyCoin() {
    return currencyCoin;
  }

  public Integer getNumberPrecision() {
    return numberPrecision;
  }

  public Integer getPricePrecision() {
    return pricePrecision;
  }

  public Double getMinTrade() {
    return minTrade;
  }

  public Double getMaxTrade() {
    return maxTrade;
  }

  public String getOrderBy() {
    return orderBy;
  }

  @Override
  public String toString() {
    return "BitZSymbol{"
        + "symbol='"
        + symbol
        + '\''
        + ", coin='"
        + coin
        + '\''
        + ", currencyCoin='"
        + currencyCoin
        + '\''
        + ", numberPrecision="
        + numberPrecision
        + ", pricePrecision="
        + pricePrecision
        + ", minTrade="
        + minTrade
        + ", maxTrade="
        + maxTrade
        + ", orderBy='"
        + orderBy
        + '\''
        + '}';
  }
}
