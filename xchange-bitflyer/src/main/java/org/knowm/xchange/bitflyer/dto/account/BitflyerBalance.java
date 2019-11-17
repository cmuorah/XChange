package org.knowm.xchange.bitflyer.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"currency_code", "amount", "available"})
public class BitflyerBalance {
  @JsonProperty("currency_code")
  private String currencyCode;

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("available")
  private Double available;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<>();

  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Double getAvailable() {
    return available;
  }

  public void setAvailable(Double available) {
    this.available = available;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }

  @Override
  public String toString() {
    return "BitflyerBalance{"
        + "currencyCode='"
        + currencyCode
        + '\''
        + ", amount="
        + amount
        + ", available="
        + available
        + ", additionalProperties="
        + additionalProperties
        + '}';
  }
}
