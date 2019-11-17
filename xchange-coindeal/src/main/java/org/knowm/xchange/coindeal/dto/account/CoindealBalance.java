package org.knowm.xchange.coindeal.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoindealBalance {

  @JsonProperty("currency")
  private final String currency;

  @JsonProperty("available")
  private final Double available;

  @JsonProperty("reserved")
  private final Double reserved;

  public CoindealBalance(
      @JsonProperty("currency") String currency,
      @JsonProperty("available") Double available,
      @JsonProperty("reserved") Double reserved) {
    this.currency = currency;
    this.available = available;
    this.reserved = reserved;
  }

  public String getCurrency() {
    return currency;
  }

  public Double getAvailable() {
    return available;
  }

  public Double getReserved() {
    return reserved;
  }

  @Override
  public String toString() {
    return "CoindealBalance{"
        + "currency='"
        + currency
        + '\''
        + ", available='"
        + available
        + '\''
        + ", reserved='"
        + reserved
        + '\''
        + '}';
  }
}
