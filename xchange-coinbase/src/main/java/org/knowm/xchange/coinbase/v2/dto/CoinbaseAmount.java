package org.knowm.xchange.coinbase.v2.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.utils.Assert;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinbaseAmount {

  private final String currency;
  private final Double amount;
  private final String toString;

  @JsonCreator
  public CoinbaseAmount(
      @JsonProperty("currency") String currency, @JsonProperty("amount") Double amount) {
    Assert.notNull(currency, "Null currency");
    Assert.notNull(amount, "Null amount");
    this.currency = currency;
    this.amount = amount;

    toString = String.format("%.8f %s", amount, currency);
  }

  public String getCurrency() {
    return currency;
  }

  public Double getAmount() {
    return amount;
  }

  @Override
  public int hashCode() {
    return toString().hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    CoinbaseAmount other = (CoinbaseAmount) obj;
    return amount.compareTo(other.amount) == 0 && currency.equals(other.currency);
  }

  @Override
  public String toString() {
    return toString;
  }
}
