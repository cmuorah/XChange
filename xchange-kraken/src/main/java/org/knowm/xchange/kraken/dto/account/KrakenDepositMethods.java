package org.knowm.xchange.kraken.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KrakenDepositMethods {
  /*
   * method = name of deposit method limit = maximum net amount that can be deposited right now fee
   * = amount of fees that will be paid address-setup-fee = whether or not method has an address
   * setup fee (optional)
   */

  private final String method;
  private final String limit;
  private final Double fee;
  private final Double addressSetupFee;

  public KrakenDepositMethods(
      @JsonProperty("method") String method,
      @JsonProperty("limit") String limit,
      @JsonProperty("fee") Double fee,
      @JsonProperty("address-setup-fee") Double addressSetupFee) {
    super();
    this.method = method;
    this.limit = limit;
    this.fee = fee;
    this.addressSetupFee = addressSetupFee;
  }

  public String getMethod() {
    return method;
  }

  public Double getLimit() {
    if (limit.equals("false")) {
      return Double.valueOf(Double.MAX_VALUE);
    } else {
      return new Double(limit);
    }
  }

  public Double getFee() {
    return fee;
  }

  public Double getAddressSetupFee() {
    return addressSetupFee;
  }

  @Override
  public String toString() {
    return "KrakenDepositMethods [method="
        + method
        + ", limit="
        + limit
        + ", fee="
        + fee
        + ", addressSetupFee="
        + addressSetupFee
        + "]";
  }
}
