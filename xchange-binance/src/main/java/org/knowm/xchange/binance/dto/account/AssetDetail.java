package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssetDetail {

  private final String minWithdrawAmount;
  private final boolean depositStatus;
  private final Double withdrawFee;
  private final boolean withdrawStatus;

  public AssetDetail(
      @JsonProperty("minWithdrawAmount") String minWithdrawAmount,
      @JsonProperty("depositStatus") boolean depositStatus,
      @JsonProperty("withdrawFee") Double withdrawFee,
      @JsonProperty("withdrawStatus") boolean withdrawStatus) {
    this.minWithdrawAmount = minWithdrawAmount;
    this.depositStatus = depositStatus;
    this.withdrawFee = withdrawFee;
    this.withdrawStatus = withdrawStatus;
  }

  public String getMinWithdrawAmount() {
    return minWithdrawAmount;
  }

  public boolean isDepositStatus() {
    return depositStatus;
  }

  public Double getWithdrawFee() {
    return withdrawFee;
  }

  public boolean isWithdrawStatus() {
    return withdrawStatus;
  }

  @Override
  public String toString() {
    return "AssetDetail{"
        + "minWithdrawAmount = '"
        + minWithdrawAmount
        + '\''
        + ",depositStatus = '"
        + depositStatus
        + '\''
        + ",withdrawFee = '"
        + withdrawFee
        + '\''
        + ",withdrawStatus = '"
        + withdrawStatus
        + '\''
        + "}";
  }
}
