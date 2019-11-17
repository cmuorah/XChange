package org.knowm.xchange.bitbay.dto.acount;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author Z. Dolezal */
public class BitbayBalance {
  private final Double available;
  private final Double locked;

  /**
   * available : amount of available money/cryptocurrency locked : amount of locked
   * money/cryptocurrency
   */
  public BitbayBalance(
      @JsonProperty("available") Double available, @JsonProperty("locked") Double locked) {
    this.available = available;
    this.locked = locked;
  }

  public Double getAvailable() {
    return available;
  }

  public Double getLocked() {
    return locked;
  }
}
