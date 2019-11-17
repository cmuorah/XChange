package org.knowm.xchange.okcoin.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.Map;

public class OkCoinFunds {

  private final Map<String, Double> free;
  private final Map<String, Double> freezed;
  private final Map<String, Double> borrow;

  public OkCoinFunds(
      @JsonProperty("free") final Map<String, Double> free,
      @JsonProperty("freezed") final Map<String, Double> freezed,
      @JsonProperty(value = "borrow", required = false) final Map<String, Double> borrow) {

    this.free = free;
    this.freezed = freezed;
    this.borrow = borrow == null ? Collections.<String, Double>emptyMap() : borrow;
  }

  public Map<String, Double> getFree() {

    return free;
  }

  public Map<String, Double> getFreezed() {

    return freezed;
  }

  public Map<String, Double> getBorrow() {

    return borrow;
  }
}
