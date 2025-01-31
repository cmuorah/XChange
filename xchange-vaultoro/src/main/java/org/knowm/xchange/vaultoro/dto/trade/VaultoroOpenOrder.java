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
@JsonPropertyOrder({"Order_ID", "BTC_Amount", "Gold_Price", "Gold_Amount"})
public class VaultoroOpenOrder {

  @JsonProperty("Order_ID")
  private String OrderID;

  @JsonProperty("BTC_Amount")
  private Double BTCAmount;

  @JsonProperty("Gold_Price")
  private Double GoldPrice;

  @JsonProperty("Gold_Amount")
  private Double GoldAmount;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

  /** @return The BTCAmount */
  @JsonProperty("BTC_Amount")
  public Double getBTCAmount() {

    return BTCAmount;
  }

  /** @param BTCAmount The BTC_Amount */
  @JsonProperty("BTC_Amount")
  public void setBTCAmount(Double BTCAmount) {

    this.BTCAmount = BTCAmount;
  }

  /** @return The GoldPrice */
  @JsonProperty("Gold_Price")
  public Double getGoldPrice() {

    return GoldPrice;
  }

  /** @param GoldPrice The Gold_Price */
  @JsonProperty("Gold_Price")
  public void setGoldPrice(Double GoldPrice) {

    this.GoldPrice = GoldPrice;
  }

  /** @return The GoldAmount */
  @JsonProperty("Gold_Amount")
  public Double getGoldAmount() {

    return GoldAmount;
  }

  /** @param GoldAmount The Gold_Amount */
  @JsonProperty("Gold_Amount")
  public void setGoldAmount(Double GoldAmount) {

    this.GoldAmount = GoldAmount;
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
