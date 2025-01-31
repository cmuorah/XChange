package org.knowm.xchange.bitflyer.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "currency_code", "change", "amount", "reason_code", "date"})
public class BitflyerMarginTransaction {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("currency_code")
  private String currencyCode;

  @JsonProperty("change")
  private Double change;

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("reason_code")
  private String reasonCode;

  @JsonProperty("date")
  private String date;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<>();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public Double getChange() {
    return change;
  }

  public void setChange(Double change) {
    this.change = change;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public String getReasonCode() {
    return reasonCode;
  }

  public void setReasonCode(String reasonCode) {
    this.reasonCode = reasonCode;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }

  @Override
  public String toString() {
    return "BitflyerMarginTransaction{"
        + "id="
        + id
        + ", currencyCode='"
        + currencyCode
        + '\''
        + ", change="
        + change
        + ", amount="
        + amount
        + ", reasonCode='"
        + reasonCode
        + '\''
        + ", date='"
        + date
        + '\''
        + ", additionalProperties="
        + additionalProperties
        + '}';
  }
}
