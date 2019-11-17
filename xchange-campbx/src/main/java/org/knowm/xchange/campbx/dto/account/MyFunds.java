package org.knowm.xchange.campbx.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.campbx.dto.CampBXResponse;

public final class MyFunds extends CampBXResponse {

  @JsonProperty("Total USD")
  private Double totalUSD;

  @JsonProperty("Total BTC")
  private Double totalBTC;

  @JsonProperty("Liquid USD")
  private Double liquidUSD;

  @JsonProperty("Liquid BTC")
  private Double liquidBTC;

  @JsonProperty("Margin Account USD")
  private Double marginAccountUSD;

  @JsonProperty("Margin Account BTC")
  private Double marginAccountBTC;

  public Double getTotalUSD() {

    return totalUSD;
  }

  public void setTotalUSD(Double totalUSD) {

    this.totalUSD = totalUSD;
  }

  public Double getTotalBTC() {

    return totalBTC;
  }

  public void setTotalBTC(Double totalBTC) {

    this.totalBTC = totalBTC;
  }

  public Double getLiquidUSD() {

    return liquidUSD;
  }

  public void setLiquidUSD(Double liquidUSD) {

    this.liquidUSD = liquidUSD;
  }

  public Double getLiquidBTC() {

    return liquidBTC;
  }

  public void setLiquidBTC(Double liquidBTC) {

    this.liquidBTC = liquidBTC;
  }

  public Double getMarginAccountUSD() {

    return marginAccountUSD;
  }

  public void setMarginAccountUSD(Double marginAccountUSD) {

    this.marginAccountUSD = marginAccountUSD;
  }

  public Double getMarginAccountBTC() {

    return marginAccountBTC;
  }

  public void setMarginAccountBTC(Double marginAccountBTC) {

    this.marginAccountBTC = marginAccountBTC;
  }

  @Override
  public String toString() {

    return "MyFunds [totalUSD="
        + totalUSD
        + ", totalBTC="
        + totalBTC
        + ", liquidUSD="
        + liquidUSD
        + ", liquidBTC="
        + liquidBTC
        + ", marginAccountUSD="
        + marginAccountUSD
        + ", marginAccountBTC="
        + marginAccountBTC
        + ", getSuccess()="
        + getSuccess()
        + ", getInfo()="
        + getInfo()
        + ", getError()="
        + getError()
        + "]";
  }
}
