package org.knowm.xchange.bitfinex.v1.dto.account;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
  "margin_balance",
  "tradable_balance",
  "unrealized_pl",
  "unrealized_swap",
  "net_value",
  "required_margin",
  "leverage",
  "margin_requirement",
  "margin_limits",
  "message"
})
public class BitfinexMarginInfosResponse {

  @JsonProperty("margin_balance")
  private Double marginBalance;

  @JsonProperty("tradable_balance")
  private Double tradableBalance;

  @JsonProperty("unrealized_pl")
  private Double unrealizedPl;

  @JsonProperty("unrealized_swap")
  private Double unrealizedSwap;

  @JsonProperty("net_value")
  private Double netValue;

  @JsonProperty("required_margin")
  private Double requiredMargin;

  @JsonProperty("leverage")
  private Double leverage;

  @JsonProperty("margin_requirement")
  private Double marginRequirement;

  @JsonProperty("margin_limits")
  private List<BitfinexMarginLimit> marginLimits = new ArrayList<BitfinexMarginLimit>();

  @JsonProperty("message")
  private String message;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("margin_balance")
  public Double getMarginBalance() {

    return marginBalance;
  }

  @JsonProperty("margin_balance")
  public void setMarginBalance(Double marginBalance) {

    this.marginBalance = marginBalance;
  }

  @JsonProperty("tradable_balance")
  public Double getTradableBalance() {

    return tradableBalance;
  }

  @JsonProperty("tradable_balance")
  public void setTradableBalance(Double tradableBalance) {

    this.tradableBalance = tradableBalance;
  }

  @JsonProperty("unrealized_pl")
  public Double getUnrealizedPl() {

    return unrealizedPl;
  }

  @JsonProperty("unrealized_pl")
  public void setUnrealizedPl(Double unrealizedPl) {

    this.unrealizedPl = unrealizedPl;
  }

  @JsonProperty("unrealized_swap")
  public Double getUnrealizedSwap() {

    return unrealizedSwap;
  }

  @JsonProperty("unrealized_swap")
  public void setUnrealizedSwap(Double unrealizedSwap) {

    this.unrealizedSwap = unrealizedSwap;
  }

  @JsonProperty("net_value")
  public Double getNetValue() {

    return netValue;
  }

  @JsonProperty("net_value")
  public void setNetValue(Double netValue) {

    this.netValue = netValue;
  }

  @JsonProperty("required_margin")
  public Double getRequiredMargin() {

    return requiredMargin;
  }

  @JsonProperty("required_margin")
  public void setRequiredMargin(Double requiredMargin) {

    this.requiredMargin = requiredMargin;
  }

  @JsonProperty("leverage")
  public Double getLeverage() {

    return leverage;
  }

  @JsonProperty("leverage")
  public void setLeverage(Double leverage) {

    this.leverage = leverage;
  }

  @JsonProperty("margin_requirement")
  public Double getMarginRequirement() {

    return marginRequirement;
  }

  @JsonProperty("margin_requirement")
  public void setMarginRequirement(Double marginRequirement) {

    this.marginRequirement = marginRequirement;
  }

  @JsonProperty("margin_limits")
  public List<BitfinexMarginLimit> getMarginLimits() {

    return marginLimits;
  }

  @JsonProperty("margin_limits")
  public void setMarginLimits(List<BitfinexMarginLimit> marginLimits) {

    this.marginLimits = marginLimits;
  }

  @JsonProperty("message")
  public String getMessage() {

    return message;
  }

  @JsonProperty("message")
  public void setMessage(String message) {

    this.message = message;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {

    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {

    this.additionalProperties.put(name, value);
  }

  @Override
  public String toString() {
    return "BitfinexMarginInfosResponse{"
        + "marginBalance="
        + marginBalance
        + ", tradableBalance="
        + tradableBalance
        + ", unrealizedPl="
        + unrealizedPl
        + ", unrealizedSwap="
        + unrealizedSwap
        + ", netValue="
        + netValue
        + ", requiredMargin="
        + requiredMargin
        + ", leverage="
        + leverage
        + ", marginRequirement="
        + marginRequirement
        + ", marginLimits="
        + marginLimits
        + ", message='"
        + message
        + '\''
        + '}';
  }
}
