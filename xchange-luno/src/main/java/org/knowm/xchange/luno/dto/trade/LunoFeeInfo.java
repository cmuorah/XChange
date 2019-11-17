package org.knowm.xchange.luno.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LunoFeeInfo {

  public final Double makerFee;
  public final Double takerFee;
  public final Double thirtyDayVolume;

  public LunoFeeInfo(
      @JsonProperty(value = "maker_fee", required = true) Double makerFee,
      @JsonProperty(value = "taker_fee", required = true) Double takerFee,
      @JsonProperty(value = "thirty_day_volume", required = true) Double thirtyDayVolume) {
    this.makerFee = makerFee;
    this.takerFee = takerFee;
    this.thirtyDayVolume = thirtyDayVolume;
  }

  @Override
  public String toString() {
    return "LunoFeeInfo [makerFee="
        + makerFee
        + ", takerFee="
        + takerFee
        + ", thirtyDayVolume="
        + thirtyDayVolume
        + "]";
  }
}
