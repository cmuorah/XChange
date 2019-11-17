package org.knowm.xchange.luno.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LunoFundingAddress {

  public final String asset;
  public final String address;
  public final Double totalReceived;
  public final Double totalUnconfirmed;

  public LunoFundingAddress(
      @JsonProperty(value = "asset", required = true) String asset,
      @JsonProperty(value = "address", required = true) String address,
      @JsonProperty(value = "total_received", required = true) Double totalReceived,
      @JsonProperty(value = "total_unconfirmed", required = true) Double totalUnconfirmed) {
    this.asset = asset;
    this.address = address;
    this.totalReceived = totalReceived;
    this.totalUnconfirmed = totalUnconfirmed;
  }

  @Override
  public String toString() {
    return "LunoFundingAddress [asset="
        + asset
        + ", address="
        + address
        + ", totalReceived="
        + totalReceived
        + ", totalUnconfirmed="
        + totalUnconfirmed
        + "]";
  }
}
