package org.knowm.xchange.bitcoinde.dto.account;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"available_amount", "reserved_amount", "total_amount"})
public class BitcoindeBalance {

  @JsonProperty("available_amount")
  private Double availableAmount;

  @JsonProperty("reserved_amount")
  private Double reservedAmount;

  @JsonProperty("total_amount")
  private Double totalAmount;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /** No args constructor for use in serialization */
  public BitcoindeBalance() {}

  /**
   * @param availableAmount
   * @param reservedAmount
   * @param totalAmount
   */
  public BitcoindeBalance(Double availableAmount, Double reservedAmount, Double totalAmount) {
    super();
    this.availableAmount = availableAmount;
    this.reservedAmount = reservedAmount;
    this.totalAmount = totalAmount;
  }

  @JsonProperty("available_amount")
  public Double getAvailableAmount() {
    return availableAmount;
  }

  @JsonProperty("available_amount")
  public void setAvailableAmount(Double availableAmount) {
    this.availableAmount = availableAmount;
  }

  @JsonProperty("reserved_amount")
  public Double getReservedAmount() {
    return reservedAmount;
  }

  @JsonProperty("reserved_amount")
  public void setReservedAmount(Double reservedAmount) {
    this.reservedAmount = reservedAmount;
  }

  @JsonProperty("total_amount")
  public Double getTotalAmount() {
    return totalAmount;
  }

  @JsonProperty("total_amount")
  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
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
