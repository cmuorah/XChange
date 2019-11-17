package org.knowm.xchange.globitex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class GlobitexSymbol implements Serializable {

  @JsonProperty("symbol")
  private final String symbol;

  @JsonProperty("priceIncrement")
  private final Double priceIncrement;

  @JsonProperty("sizeIncrement")
  private final Double sizeIncrement;

  @JsonProperty("sizeMin")
  private final Double sizeMin;

  @JsonProperty("currency")
  private final String currency;

  @JsonProperty("commodity")
  private final String commodity;

  public GlobitexSymbol(
      @JsonProperty("symbol") String symbol,
      @JsonProperty("priceIncrement") Double priceIncrement,
      @JsonProperty("sizeIncrement") Double sizeIncrement,
      @JsonProperty("sizeMin") Double sizeMin,
      @JsonProperty("currency") String currency,
      @JsonProperty("commodity") String commodity) {
    this.symbol = symbol;
    this.priceIncrement = priceIncrement;
    this.sizeIncrement = sizeIncrement;
    this.sizeMin = sizeMin;
    this.currency = currency;
    this.commodity = commodity;
  }

  public String getSymbol() {
    return symbol;
  }

  public Double getPriceIncrement() {
    return priceIncrement;
  }

  public Double getSizeIncrement() {
    return sizeIncrement;
  }

  public Double getSizeMin() {
    return sizeMin;
  }

  public String getCurrency() {
    return currency;
  }

  public String getCommodity() {
    return commodity;
  }

  @Override
  public String toString() {
    return "GlobitexSymbol{"
        + "symbol='"
        + symbol
        + '\''
        + ", priceIncrement="
        + priceIncrement
        + ", sizeIncrement="
        + sizeIncrement
        + ", sizeMin="
        + sizeMin
        + ", currency='"
        + currency
        + '\''
        + ", commodity='"
        + commodity
        + '\''
        + '}';
  }
}
