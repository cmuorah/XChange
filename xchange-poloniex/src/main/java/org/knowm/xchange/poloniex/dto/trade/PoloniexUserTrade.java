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
@JsonPropertyOrder({"tradeId", "date", "rate", "amount", "total", "fee", "orderNumber", "type"})
public class PoloniexUserTrade {

  @JsonProperty("tradeID")
  private String tradeID;

  @JsonProperty("date")
  private String date;

  @JsonProperty("rate")
  private Double rate;

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("total")
  private Double total;

  @JsonProperty("fee")
  private Double fee;

  @JsonProperty("orderNumber")
  private String orderNumber;

  @JsonProperty("type")
  private String type;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("tradeID")
  public String getTradeID() {

    return tradeID;
  }

  @JsonProperty("tradeID")
  public void setTradeID(String tradeID) {

    this.tradeID = tradeID;
  }

  @JsonProperty("date")
  public String getDate() {

    return date;
  }

  @JsonProperty("date")
  public void setDate(String date) {

    this.date = date;
  }

  @JsonProperty("rate")
  public Double getRate() {

    return rate;
  }

  @JsonProperty("rate")
  public void setRate(Double rate) {

    this.rate = rate;
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

  @JsonProperty("fee")
  public Double getFee() {

    return fee;
  }

  @JsonProperty("fee")
  public void setFee(Double fee) {

    this.fee = fee;
  }

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

    return "PoloniexUserTrade [tradeID= "
        + tradeID
        + ", date="
        + date
        + ", rate="
        + rate
        + ", amount="
        + amount
        + ", total="
        + total
        + ", fee="
        + fee
        + ", orderNumber="
        + orderNumber
        + ", type="
        + type
        + ", additionalProperties="
        + additionalProperties
        + "]";
  }
}
