package org.knowm.xchange.livecoin.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author walec51 */
public class LivecoinBalance {

  private final String type;
  private final String currency;
  private final Double value;

  public LivecoinBalance(
      @JsonProperty("type") String type,
      @JsonProperty("currency") String currency,
      @JsonProperty("value") Double value) {
    this.type = type;
    this.currency = currency;
    this.value = value;
  }

  public String getType() {
    return type;
  }

  public String getCurrency() {
    return currency;
  }

  public Double getValue() {
    return value;
  }
}
