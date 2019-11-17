package org.knowm.xchange.lgo.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class LgoLimit {

  private final Double min;
  private final Double max;

  public LgoLimit(@JsonProperty("min") Double min, @JsonProperty("max") Double max) {
    this.min = min;
    this.max = max;
  }

  public Double getMin() {
    return min;
  }

  public Double getMax() {
    return max;
  }
}
