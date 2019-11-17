package org.knowm.xchange.poloniex.dto.marketdata;

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
@JsonPropertyOrder({"tradeID", "date", "type", "rate", "amount", "total"})
public class PoloniexPublicTrade {

  @JsonProperty("tradeID")
  private String tradeID;

  @JsonProperty("date")
  private String date;

  @JsonProperty("type")
  private String type;

  @JsonProperty("rate")
  private Double rate;

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("total")
  private Double total;

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

    return "PoloniexPublicTrade [tradeID="
        + tradeID
        + ", date="
        + date
        + ", type="
        + type
        + ", amount="
        + amount
        + ", rate="
        + rate
        + ", total="
        + total
        + ""
        + ", additionalProperties="
        + additionalProperties
        + "]";
  }
}
