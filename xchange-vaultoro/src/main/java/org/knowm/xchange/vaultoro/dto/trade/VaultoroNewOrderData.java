package org.knowm.xchange.vaultoro.dto.trade;

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
@JsonPropertyOrder({"action", "Order_ID", "type", "time", "price", "btc", "gld"})
public class VaultoroNewOrderData {

  @JsonProperty("action")
  private String action;

  @JsonProperty("Order_ID")
  private String OrderID;

  @JsonProperty("type")
  private String type;

  @JsonProperty("time")
  private String time;

  @JsonProperty("price")
  private Double price;

  @JsonProperty("btc")
  private Double btc;

  @JsonProperty("gld")
  private Double gld;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /** @return The action */
  @JsonProperty("action")
  public String getAction() {

    return action;
  }

  /** @param action The action */
  @JsonProperty("action")
  public void setAction(String action) {

    this.action = action;
  }

  /** @return The OrderID */
  @JsonProperty("Order_ID")
  public String getOrderID() {

    return OrderID;
  }

  /** @param OrderID The Order_ID */
  @JsonProperty("Order_ID")
  public void setOrderID(String OrderID) {

    this.OrderID = OrderID;
  }

  /** @return The type */
  @JsonProperty("type")
  public String getType() {

    return type;
  }

  /** @param type The type */
  @JsonProperty("type")
  public void setType(String type) {

    this.type = type;
  }

  /** @return The time */
  @JsonProperty("time")
  public String getTime() {

    return time;
  }

  /** @param time The time */
  @JsonProperty("time")
  public void setTime(String time) {

    this.time = time;
  }

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

  /** @return The btc */
  @JsonProperty("btc")
  public Double getBtc() {

    return btc;
  }

  /** @param btc The btc */
  @JsonProperty("btc")
  public void setBtc(Double btc) {

    this.btc = btc;
  }

  /** @return The gld */
  @JsonProperty("gld")
  public Double getGld() {

    return gld;
  }

  /** @param gld The gld */
  @JsonProperty("gld")
  public void setGld(Double gld) {

    this.gld = gld;
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
