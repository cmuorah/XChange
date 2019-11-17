package org.knowm.xchange.bitfinex.v1.dto.account;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"on_pair", "initial_margin", "margin_requirement", "tradable_balance"})
public class BitfinexMarginLimit {

  @JsonProperty("on_pair")
  private String onPair;

  @JsonProperty("initial_margin")
  private Double initialMargin;

  @JsonProperty("margin_requirement")
  private Double marginRequirement;

  @JsonProperty("tradable_balance")
  private Double tradableBalance;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("on_pair")
  public String getOnPair() {

    return onPair;
  }

  @JsonProperty("on_pair")
  public void setOnPair(String onPair) {

    this.onPair = onPair;
  }

  @JsonProperty("initial_margin")
  public Double getInitialMargin() {

    return initialMargin;
  }

  @JsonProperty("initial_margin")
  public void setInitialMargin(Double initialMargin) {

    this.initialMargin = initialMargin;
  }

  @JsonProperty("margin_requirement")
  public Double getMarginRequirement() {

    return marginRequirement;
  }

  @JsonProperty("margin_requirement")
  public void setMarginRequirement(Double marginRequirement) {

    this.marginRequirement = marginRequirement;
  }

  @JsonProperty("tradable_balance")
  public Double getTradableBalance() {

    return tradableBalance;
  }

  @JsonProperty("tradable_balance")
  public void setTradableBalance(Double tradableBalance) {

    this.tradableBalance = tradableBalance;
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
    return "BitfinexMarginLimit{"
        + "onPair='"
        + onPair
        + '\''
        + ", initialMargin="
        + initialMargin
        + ", marginRequirement="
        + marginRequirement
        + ", tradableBalance="
        + tradableBalance
        + '}';
  }
}
