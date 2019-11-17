package org.knowm.xchange.poloniex.dto.marketdata;

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
@JsonPropertyOrder({"asks", "bids", "isFrozen"})
public class PoloniexDepth {

  @JsonProperty("asks")
  private List<List<Double>> asks = new ArrayList<List<Double>>();

  @JsonProperty("bids")
  private List<List<Double>> bids = new ArrayList<List<Double>>();

  @JsonProperty("isFrozen")
  private String isFrozen;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("asks")
  public List<List<Double>> getAsks() {

    return asks;
  }

  @JsonProperty("asks")
  public void setAsks(List<List<Double>> asks) {

    this.asks = asks;
  }

  @JsonProperty("bids")
  public List<List<Double>> getBids() {

    return bids;
  }

  @JsonProperty("bids")
  public void setBids(List<List<Double>> bids) {

    this.bids = bids;
  }

  @JsonProperty("isFrozen")
  public String getIsFrozen() {

    return isFrozen;
  }

  @JsonProperty("isFrozen")
  public void setIsFrozen(String isFrozen) {

    this.isFrozen = isFrozen;
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

    return "PoloniexDepth [asks="
        + asks
        + ", bids="
        + bids
        + ", isFrozen="
        + isFrozen
        + ", additionalProperties="
        + additionalProperties
        + "]";
  }
}
