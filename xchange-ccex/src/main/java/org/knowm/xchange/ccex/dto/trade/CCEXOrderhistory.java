package org.knowm.xchange.ccex.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CCEXOrderhistory {

  private String OrderUuid;
  private String Exchange;
  private String TimeStamp;
  private String OrderType;
  private Double Limit;
  private Double Quantity;
  private Double QuantityRemaining;
  private Double Commission;
  private Double Price;
  private Double PricePerUnit;
  private boolean IsConditional;
  private String Condition;
  private String ConditionTarget;
  private boolean ImmediateOrCancel;

  public CCEXOrderhistory(
      @JsonProperty("OrderUuid") String orderUuid,
      @JsonProperty("Exchange") String exchange,
      @JsonProperty("TimeStamp") String timeStamp,
      @JsonProperty("OrderType") String orderType,
      @JsonProperty("Limit") Double limit,
      @JsonProperty("Quantity") Double quantity,
      @JsonProperty("QuantityRemaining") Double quantityRemaining,
      @JsonProperty("Commission") Double commission,
      @JsonProperty("Price") Double price,
      @JsonProperty("PricePerUnit") Double pricePerUnit,
      @JsonProperty("IsConditional") boolean isConditional,
      @JsonProperty("Condition") String condition,
      @JsonProperty("ConditionTarget") String conditionTarget,
      @JsonProperty("ImmediateOrCancel") boolean immediateOrCancel) {
    super();
    OrderUuid = orderUuid;
    Exchange = exchange;
    TimeStamp = timeStamp;
    OrderType = orderType;
    Limit = limit;
    Quantity = quantity;
    QuantityRemaining = quantityRemaining;
    Commission = commission;
    Price = price;
    PricePerUnit = pricePerUnit;
    IsConditional = isConditional;
    Condition = condition;
    ConditionTarget = conditionTarget;
    ImmediateOrCancel = immediateOrCancel;
  }

  public String getOrderUuid() {
    return OrderUuid;
  }

  public void setOrderUuid(String orderUuid) {
    OrderUuid = orderUuid;
  }

  public String getExchange() {
    return Exchange;
  }

  public void setExchange(String exchange) {
    Exchange = exchange;
  }

  public String getTimeStamp() {
    return TimeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    TimeStamp = timeStamp;
  }

  public String getOrderType() {
    return OrderType;
  }

  public void setOrderType(String orderType) {
    OrderType = orderType;
  }

  public Double getLimit() {
    return Limit;
  }

  public void setLimit(Double limit) {
    Limit = limit;
  }

  public Double getQuantity() {
    return Quantity;
  }

  public void setQuantity(Double quantity) {
    Quantity = quantity;
  }

  public Double getQuantityRemaining() {
    return QuantityRemaining;
  }

  public void setQuantityRemaining(Double quantityRemaining) {
    QuantityRemaining = quantityRemaining;
  }

  public Double getCommission() {
    return Commission;
  }

  public void setCommission(Double commission) {
    Commission = commission;
  }

  public Double getPrice() {
    return Price;
  }

  public void setPrice(Double price) {
    Price = price;
  }

  public Double getPricePerUnit() {
    return PricePerUnit;
  }

  public void setPricePerUnit(Double pricePerUnit) {
    PricePerUnit = pricePerUnit;
  }

  public boolean isIsConditional() {
    return IsConditional;
  }

  public void setIsConditional(boolean isConditional) {
    IsConditional = isConditional;
  }

  public String getCondition() {
    return Condition;
  }

  public void setCondition(String condition) {
    Condition = condition;
  }

  public String getConditionTarget() {
    return ConditionTarget;
  }

  public void setConditionTarget(String conditionTarget) {
    ConditionTarget = conditionTarget;
  }

  public boolean isImmediateOrCancel() {
    return ImmediateOrCancel;
  }

  public void setImmediateOrCancel(boolean immediateOrCancel) {
    ImmediateOrCancel = immediateOrCancel;
  }

  @Override
  public String toString() {
    return "CCEXOrderhistory [OrderUuid="
        + OrderUuid
        + ", Exchange="
        + Exchange
        + ", TimeStamp="
        + TimeStamp
        + ", OrderType="
        + OrderType
        + ", Limit="
        + Limit
        + ", Quantity="
        + Quantity
        + ", QuantityRemaining="
        + QuantityRemaining
        + ", Commission="
        + Commission
        + ", Price="
        + Price
        + ", PricePerUnit="
        + PricePerUnit
        + ", IsConditional="
        + IsConditional
        + ", Condition="
        + Condition
        + ", ConditionTarget="
        + ConditionTarget
        + ", ImmediateOrCancel="
        + ImmediateOrCancel
        + "]";
  }
}
