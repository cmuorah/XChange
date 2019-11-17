package org.knowm.xchange.coingi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;

/** Orders grouped by value. */
public class CoingiOrderGroup {
  private int type;

  private Map<String, String> currencyPair;

  private Double price;

  private Double baseAmount;

  private Double counterAmount;

  public CoingiOrderGroup(
      @JsonProperty("type") int type,
      @JsonProperty("currencyPair") Map<String, String> currencyPair,
      @JsonProperty("price") Double price,
      @JsonProperty("baseAmount") Double baseAmount,
      @JsonProperty("counterAmount") Double counterAmount) {
    this.type = type;
    this.currencyPair = Objects.requireNonNull(currencyPair);
    this.price = Objects.requireNonNull(price);
    this.baseAmount = Objects.requireNonNull(baseAmount);
    this.counterAmount = Objects.requireNonNull(counterAmount);
  }

  public int getType() {
    return type;
  }

  public Map<String, String> getCurrencyPair() {
    return currencyPair;
  }

  public Double getPrice() {
    return price;
  }

  public Double getBaseAmount() {
    return baseAmount;
  }

  public Double getCounterAmount() {
    return counterAmount;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    CoingiOrderGroup that = (CoingiOrderGroup) o;
    return type == that.type
        && Objects.equals(currencyPair, that.currencyPair)
        && Objects.equals(price, that.price)
        && Objects.equals(baseAmount, that.baseAmount)
        && Objects.equals(counterAmount, that.counterAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, currencyPair, price, baseAmount, counterAmount);
  }
}
