package org.knowm.xchange.bitflyer.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"collateral", "open_position_pnl", "require_collateral", "keep_rate"})
public class BitflyerMarginStatus {
  @JsonProperty("collateral")
  private Double collateral;

  @JsonProperty("open_position_pnl")
  private Double openPositionPnl;

  @JsonProperty("require_collateral")
  private Double requireCollateral;

  @JsonProperty("keep_rate")
  private Double keepRate;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<>();

  public Double getCollateral() {
    return collateral;
  }

  public void setCollateral(Double collateral) {
    this.collateral = collateral;
  }

  public Double getOpenPositionPnl() {
    return openPositionPnl;
  }

  public void setOpenPositionPnl(Double openPositionPnl) {
    this.openPositionPnl = openPositionPnl;
  }

  public Double getRequireCollateral() {
    return requireCollateral;
  }

  public void setRequireCollateral(Double requireCollateral) {
    this.requireCollateral = requireCollateral;
  }

  public Double getKeepRate() {
    return keepRate;
  }

  public void setKeepRate(Double keepRate) {
    this.keepRate = keepRate;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }

  @Override
  public String toString() {
    return "BitflyerMarginStatus{"
        + "collateral="
        + collateral
        + ", openPositionPnl="
        + openPositionPnl
        + ", requireCollateral="
        + requireCollateral
        + ", keepRate="
        + keepRate
        + ", additionalProperties="
        + additionalProperties
        + '}';
  }
}
