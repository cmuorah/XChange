package org.knowm.xchange.globitex.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.openhft.chronicle.wire.AbstractMarshallable;

import java.io.Serializable;

public class GlobitexBalance extends AbstractMarshallable implements Serializable {

  @JsonProperty("currency")
  private final String currency;

  @JsonProperty("available")
  private final Double available;

  @JsonProperty("reserved")
  private final Double reserved;

  public GlobitexBalance(
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
    return "GlobitexBalance{"
        + "currency='"
        + currency
        + '\''
        + ", available="
        + available
        + ", reserved="
        + reserved
        + '}';
  }
}
