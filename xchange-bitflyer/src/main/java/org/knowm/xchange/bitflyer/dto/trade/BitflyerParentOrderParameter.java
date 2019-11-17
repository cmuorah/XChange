package org.knowm.xchange.bitflyer.dto.trade;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BitflyerParentOrderParameter {
  private static final int CURRENCY_SCALE = 2;
  private static final int SIZE_SCALE = 8;

  private String productCode;
  private BitflyerParentOrderConditionType conditionType;
  private BitflyerSide side;
  private Double price;
  private Double triggerPrice;
  private Double size;
  private Double offset;

  public BitflyerParentOrderParameter(
      String productCode,
      BitflyerParentOrderConditionType conditionType,
      BitflyerSide side,
      Double price,
      Double triggerPrice,
      Double size,
      Double offset) {
    this.productCode = productCode;
    this.conditionType = conditionType;
    this.side = side;
    this.price = price;
    this.triggerPrice = triggerPrice;
    this.size = size;
    this.offset = offset;
  }

  @JsonProperty("product_code")
  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  @JsonProperty("condition_type")
  public BitflyerParentOrderConditionType getConditionType() {
    return conditionType;
  }

  public void setConditionType(BitflyerParentOrderConditionType conditionType) {
    this.conditionType = conditionType;
  }

  @JsonProperty("side")
  public BitflyerSide getSide() {
    return side;
  }

  public void setSide(BitflyerSide side) {
    this.side = side;
  }

  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @JsonProperty("trigger_price")
  public Double getTriggerPrice() {
    return triggerPrice;
  }

  public void setTriggerPrice(Double triggerPrice) {
    this.triggerPrice = triggerPrice;
  }

  @JsonProperty("size")
  public Double getSize() {
    return size;
  }

  public void setSize(Double size) {
    this.size = size;
  }

  @JsonProperty("offset")
  public Double getOffset() {
    return offset;
  }

  public void setOffset(Double offset) {
    this.offset = offset;
  }

  @Override
  public String toString() {
    return "BitflyerParentOrderParameter{"
        + "productCode='"
        + productCode
        + '\''
        + ", conditionType="
        + conditionType
        + ", side="
        + side
        + ", price="
        + price
        + ", triggerPrice="
        + triggerPrice
        + ", size="
        + size
        + ", offset="
        + offset
        + '}';
  }
}
