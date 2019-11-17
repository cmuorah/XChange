package org.knowm.xchange.poloniex.dto.trade;

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
@JsonPropertyOrder({"orderNumber", "type", "rate", "amount", "total", "date"})
public class PoloniexOpenOrder {

  @JsonProperty("orderNumber")
  private String orderNumber;

  @JsonProperty("type")
  private String type;

  @JsonProperty("rate")
  private Double rate;

  @JsonProperty("startingAmount")
  private Double startingAmount;

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("total")
  private Double total;

  @JsonProperty("date")
  private String date;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("orderNumber")
  public String getOrderNumber() {
    return orderNumber;
  }

  @JsonProperty("orderNumber")
  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("rate")
  public Double getRate() {
    return rate;
  }

  @JsonProperty("rate")
  public void setRate(Double rate) {
    this.rate = rate;
  }

  @JsonProperty("startingAmount")
  public Double getStartingAmount() {
    return startingAmount;
  }

  @JsonProperty("startingAmount")
  public void setStartingAmount(Double startingAmount) {
    this.startingAmount = startingAmount;
  }

  @JsonProperty("amount")
  public Double getAmount() {
    return amount;
  }

  @JsonProperty("amount")
  public void setAmount(Double amount) {
    this.amount = amount;
  }

  @JsonProperty("total")
  public Double getTotal() {
    return total;
  }

  @JsonProperty("total")
  public void setTotal(Double total) {
    this.total = total;
  }

  @JsonProperty("date")
  public String getDate() {
    return date;
  }

  @JsonProperty("date")
  public void setDate(String date) {
    this.date = date;
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
    return "PoloniexOpenOrder{"
        + "orderNumber='"
        + orderNumber
        + '\''
        + ", type='"
        + type
        + '\''
        + ", rate="
        + rate
        + ", startingAmount="
        + startingAmount
        + ", amount="
        + amount
        + ", total="
        + total
        + ", date='"
        + date
        + '\''
        + ", additionalProperties="
        + additionalProperties
        + '}';
  }
}
