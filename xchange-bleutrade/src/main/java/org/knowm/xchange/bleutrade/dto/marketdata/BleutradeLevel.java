package org.knowm.xchange.bleutrade.dto.marketdata;

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
@JsonPropertyOrder({"Quantity", "Rate"})
public class BleutradeLevel {

  @JsonProperty("Quantity")
  private Double Quantity;

  @JsonProperty("Rate")
  private Double Rate;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /** @return The Quantity */
  @JsonProperty("Quantity")
  public Double getQuantity() {

    return Quantity;
  }

  /** @param Quantity The Quantity */
  @JsonProperty("Quantity")
  public void setQuantity(Double Quantity) {

    this.Quantity = Quantity;
  }

  /** @return The Rate */
  @JsonProperty("Rate")
  public Double getRate() {

    return Rate;
  }

  /** @param Rate The Rate */
  @JsonProperty("Rate")
  public void setRate(Double Rate) {

    this.Rate = Rate;
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

    return "BleutradeLevel [Quantity="
        + Quantity
        + ", Rate="
        + Rate
        + ", additionalProperties="
        + additionalProperties
        + "]";
  }
}
