package org.knowm.xchange.poloniex.dto.trade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "amount",
  "total",
  "basePrice",
  "liquidationPrice",
  "pl",
  "lendingFees",
  "type"
})
public class PoloniexMarginPostionResponse {
  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("total")
  private Double total;

  @JsonProperty("basePrice")
  private Double basePrice;

  @JsonProperty("liquidationPrice")
  private Double liquidationPrice;

  @JsonProperty("pl")
  private Double pl;

  @JsonProperty("lendingFees")
  private Double lendingFees;

  @JsonProperty("type")
  private String type;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  public Double getAmount() {
    return amount;
  }

  public Double getTotal() {
    return total;
  }

  public Double getBasePrice() {
    return basePrice;
  }

  public Double getLiquidationPrice() {
    return liquidationPrice;
  }

  public Double getPl() {
    return pl;
  }

  public Double getLendingFees() {
    return lendingFees;
  }

  public String getType() {
    return type;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  @Override
  public String toString() {
    return "PoloniexMarginPostionResponse{"
        + "amount="
        + amount
        + ", total="
        + total
        + ", basePrice="
        + basePrice
        + ", liquidationPrice="
        + liquidationPrice
        + ", pl="
        + pl
        + ", lendingFees="
        + lendingFees
        + ", type='"
        + type
        + '\''
        + '}';
  }
}
