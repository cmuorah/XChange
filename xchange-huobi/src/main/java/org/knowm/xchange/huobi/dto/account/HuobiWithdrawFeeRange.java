package org.knowm.xchange.huobi.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class HuobiWithdrawFeeRange {

  private final Double defaultAmount;
  private final Double minAmount;
  private final Double maxAmount;
  private final String dynamicSwitch;

  public HuobiWithdrawFeeRange(
      @JsonProperty("default-amount") Double defaultAmount,
      @JsonProperty("min-amount") Double minAmount,
      @JsonProperty("max-amount") Double maxAmount,
      @JsonProperty("dynamic-switch") String dynamicSwitch) {
    this.defaultAmount = defaultAmount;
    this.minAmount = minAmount;
    this.maxAmount = maxAmount;
    this.dynamicSwitch = dynamicSwitch;
  }

  public Double getDefaultAmount() {
    return defaultAmount;
  }

  public Double getMinAmount() {
    return minAmount;
  }

  public Double getMaxAmount() {
    return maxAmount;
  }

  @Override
  public String toString() {
    return "HuobiWithdrawFeeRange [defaultAmount="
        + getDefaultAmount()
        + ", minAmount="
        + getMinAmount()
        + ", maxAmount="
        + getMaxAmount()
        + "]";
  }
}
