package org.knowm.xchange.poloniex.dto.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.annotation.Generated;

/** Created by Roland Schumacher on 12.09.2015. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"available", "onOrders", "btcValue"})
public class PoloniexBalance {
  @JsonProperty("available")
  private Double available;

  @JsonProperty("onOrders")
  private Double onOrders;

  @JsonProperty("btcValue")
  private Double btcValue;

  @JsonProperty("available")
  public Double getAvailable() {
    return available;
  }

  @JsonProperty("available")
  public void setAvailable(Double available) {
    this.available = available;
  }

  @JsonProperty("onOrders")
  public Double getOnOrders() {
    return onOrders;
  }

  @JsonProperty("onOrders")
  public void setOnOrders(Double onOrders) {
    this.onOrders = onOrders;
  }

  @JsonProperty("btcValue")
  public Double getBtcValue() {
    return btcValue;
  }

  @JsonProperty("btcValue")
  public void setBtcValue(Double btcValue) {
    this.btcValue = btcValue;
  }

  @Override
  public String toString() {
    return "PoloniexBalance["
        + "available="
        + available
        + ", onOrders="
        + onOrders
        + ", btcValue="
        + btcValue
        + ']';
  }
}
