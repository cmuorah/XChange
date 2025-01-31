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
@JsonPropertyOrder({"TimeStamp", "Quantity", "Price", "Total", "OrderType"})
public class BleutradeTrade {

  @JsonProperty("TimeStamp")
  private String TimeStamp;

  @JsonProperty("Quantity")
  private Double Quantity;

  @JsonProperty("Price")
  private Double Price;

  @JsonProperty("Total")
  private Double Total;

  @JsonProperty("OrderType")
  private String OrderType;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /** @return The TimeStamp */
  @JsonProperty("TimeStamp")
  public String getTimeStamp() {

    return TimeStamp;
  }

  /** @param TimeStamp The TimeStamp */
  @JsonProperty("TimeStamp")
  public void setTimeStamp(String TimeStamp) {

    this.TimeStamp = TimeStamp;
  }

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

  /** @return The Price */
  @JsonProperty("Price")
  public Double getPrice() {

    return Price;
  }

  /** @param Price The Price */
  @JsonProperty("Price")
  public void setPrice(Double Price) {

    this.Price = Price;
  }

  /** @return The Total */
  @JsonProperty("Total")
  public Double getTotal() {

    return Total;
  }

  /** @param Total The Total */
  @JsonProperty("Total")
  public void setTotal(Double Total) {

    this.Total = Total;
  }

  /** @return The OrderType */
  @JsonProperty("OrderType")
  public String getOrderType() {

    return OrderType;
  }

  /** @param OrderType The OrderType */
  @JsonProperty("OrderType")
  public void setOrderType(String OrderType) {

    this.OrderType = OrderType;
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

    return "BleutradeTrade [TimeStamp="
        + TimeStamp
        + ", Quantity="
        + Quantity
        + ", Price="
        + Price
        + ", Total="
        + Total
        + ", OrderType="
        + OrderType
        + ", additionalProperties="
        + additionalProperties
        + "]";
  }
}
