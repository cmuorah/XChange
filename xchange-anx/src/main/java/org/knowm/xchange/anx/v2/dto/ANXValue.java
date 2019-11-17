package org.knowm.xchange.anx.v2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Data object representing a Value from ANX */
public final class ANXValue {

  private final Double value;
  private final String currency;

  /**
   * Constructor
   *
   * @param value
   * @param currency
   */
  public ANXValue(@JsonProperty("value") Double value, @JsonProperty("currency") String currency) {

    this.value = value;
    this.currency = currency;
  }

  public Double getValue() {

    return value;
  }

  public String getCurrency() {

    return currency;
  }

  @Override
  public String toString() {

    return "ANXValue [value=" + value + ", currency=" + currency + "]";
  }
}
