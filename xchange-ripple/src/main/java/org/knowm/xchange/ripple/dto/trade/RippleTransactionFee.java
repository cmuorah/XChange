package org.knowm.xchange.ripple.dto.trade;

public class RippleTransactionFee {
  private Double fee;
  private boolean success;

  public Double getFee() {
    return fee;
  }

  public void setFee(final Double fee) {
    this.fee = fee;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(final boolean success) {
    this.success = success;
  }
}
