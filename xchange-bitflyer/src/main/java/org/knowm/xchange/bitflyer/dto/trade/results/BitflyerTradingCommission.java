package org.knowm.xchange.bitflyer.dto.trade.results;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BitflyerTradingCommission {
  @JsonProperty("commission_rate")
  private Double commissionRate;

  public Double getCommissionRate() {
    return commissionRate;
  }

  public void setCommissionRate(Double commissionRate) {
    this.commissionRate = commissionRate;
  }

  @Override
  public String toString() {
    return "BitflyerTradingCommission{" + "commissionRate=" + commissionRate + '}';
  }
}
