package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.currency.Currency;

public final class BinanceBalance {

  private final Currency currency;
  private final Double free;
  private final Double locked;

  public BinanceBalance(
      @JsonProperty("asset") String asset,
      @JsonProperty("free") Double free,
      @JsonProperty("locked") Double locked) {
    this.currency = Currency.getInstance(asset);
    this.locked = locked;
    this.free = free;
  }

  public Currency getCurrency() {
    return currency;
  }

  public Double getTotal() {
    return free + locked;
  }

  public Double getAvailable() {
    return free;
  }

  public Double getLocked() {
    return locked;
  }

  public String toString() {
    return "[" + currency + ", free=" + free + ", locked=" + locked + "]";
  }
}
