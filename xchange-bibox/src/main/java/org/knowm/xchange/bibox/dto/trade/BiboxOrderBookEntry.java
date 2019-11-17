package org.knowm.xchange.bibox.dto.trade;

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
@JsonPropertyOrder({"price", "volume"})
public class BiboxOrderBookEntry {

  @JsonProperty("price")
  private Double price;

  @JsonProperty("volume")
  private Double volume;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /** @return The price */
  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  /** @param price The price */
  @JsonProperty("price")
  public void setPrice(Double price) {
    this.price = price;
  }

  /** @return The volume */
  @JsonProperty("volume")
  public Double getVolume() {
    return volume;
  }

  /** @param volume The volume */
  @JsonProperty("volume")
  public void setVolume(Double volume) {
    this.volume = volume;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }
}
