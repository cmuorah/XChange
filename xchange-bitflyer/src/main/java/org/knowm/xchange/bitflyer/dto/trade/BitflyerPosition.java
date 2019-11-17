package org.knowm.xchange.bitflyer.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitflyerPosition {
  @JsonProperty("product_code")
  public String productCode;

  @JsonProperty("side")
  public String side;

  @JsonProperty("price")
  public Double price;

  @JsonProperty("size")
  public Double size;

  @JsonProperty("commission")
  public Double commission;

  @JsonProperty("swap_point_accumulate")
  public Double swapPointAccumulate;

  @JsonProperty("require_collateral")
  public Double requireCollateral;

  @JsonProperty("open_date")
  public String openDate;

  @JsonProperty("leverage")
  public Double leverage;

  @JsonProperty("pnl")
  public Double pnl;

  public String getProductCode() {
    return productCode;
  }

  public String getSide() {
    return side;
  }

  public Double getPrice() {
    return price;
  }

  public Double getSize() {
    return size;
  }

  public Double getCommission() {
    return commission;
  }

  public Double getSwapPointAccumulate() {
    return swapPointAccumulate;
  }

  public Double getRequireCollateral() {
    return requireCollateral;
  }

  public String getOpenDate() {
    return openDate;
  }

  public Double getLeverage() {
    return leverage;
  }

  public Double getPnl() {
    return pnl;
  }

  @Override
  public String toString() {
    return "BitflyerPosition{"
        + "productCode='"
        + productCode
        + '\''
        + ", side='"
        + side
        + '\''
        + ", price="
        + price
        + ", size="
        + size
        + ", commission="
        + commission
        + ", swapPointAccumulate="
        + swapPointAccumulate
        + ", requireCollateral="
        + requireCollateral
        + ", openDate='"
        + openDate
        + '\''
        + ", leverage="
        + leverage
        + ", pnl="
        + pnl
        + '}';
  }
}
