package org.knowm.xchange.coingi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/** Depth range. */
public class CoingiDepthRange {
  private Double price;

  private Double amount;

  public CoingiDepthRange(
      @JsonProperty("price") Double price, @JsonProperty("amount") Double amount) {
    this.price = Objects.requireNonNull(price);
    this.amount = Objects.requireNonNull(amount);
  }

  public Double getPrice() {
    return price;
  }

  public Double getAmount() {
    return amount;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    CoingiDepthRange that = (CoingiDepthRange) o;
    return Objects.equals(price, that.price) && Objects.equals(amount, that.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(price, amount);
  }
}
