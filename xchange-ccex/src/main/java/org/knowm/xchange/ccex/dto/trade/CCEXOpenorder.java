package org.knowm.xchange.ccex.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CCEXOpenorder {

  private String OrderUuid;
  private String Exchange;
  private String OrderType;
  private Double Quantity;
  private Double QuantityRemaining;
  private Double Limit;
  private Double CommissionPaid;
  private Double Price;
  private Double PricePerUnit;
  private String Opened;
  private String Closed;
  private boolean CancelInitiated;
  private boolean ImmediateOrCancel;
  private boolean IsConditional;
  private String Condition;
  private String ConditionTarget;

  public CCEXOpenorder(
      @JsonProperty("OrderUuid") String orderUuid,
      @JsonProperty("Exchange") String exchange,
      @JsonProperty("OrderType") String orderType,
      @JsonProperty("Quantity") Double quantity,
      @JsonProperty("QuantityRemaining") Double quantityRemaining,
      @JsonProperty("Limit") Double limit,
      @JsonProperty("CommissionPaid") Double commissionPaid,
      @JsonProperty("Price") Double price,
      @JsonProperty("PricePerUnit") Double pricePerUnit,
      @JsonProperty("Opened") String opened,
      @JsonProperty("Closed") String closed,
      @JsonProperty("CancelInitiated") boolean cancelInitiated,
      @JsonProperty("ImmediateOrCancel") boolean immediateOrCancel,
      @JsonProperty("IsConditional") boolean isConditional,
      @JsonProperty("Condition") String condition,
      @JsonProperty("ConditionTarget") String conditionTarget) {
    super();
    OrderUuid = orderUuid;
    Exchange = exchange;
    OrderType = orderType;
    Quantity = quantity;
    QuantityRemaining = quantityRemaining;
    Limit = limit;
    CommissionPaid = commissionPaid;
    Price = price;
    PricePerUnit = pricePerUnit;
    Opened = opened;
    Closed = closed;
    CancelInitiated = cancelInitiated;
    ImmediateOrCancel = immediateOrCancel;
    IsConditional = isConditional;
    Condition = condition;
    ConditionTarget = conditionTarget;
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

  public String getOrderType() {
    return OrderType;
  }

  public void setOrderType(String orderType) {
    OrderType = orderType;
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

  public Double getLimit() {
    return Limit;
  }

  public void setLimit(Double limit) {
    Limit = limit;
  }

  public Double getCommissionPaid() {
    return CommissionPaid;
  }

  public void setCommissionPaid(Double commissionPaid) {
    CommissionPaid = commissionPaid;
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

  public String getOpened() {
    return Opened;
  }

  public void setOpened(String opened) {
    Opened = opened;
  }

  public String getClosed() {
    return Closed;
  }

  public void setClosed(String closed) {
    Closed = closed;
  }

  public boolean isCancelInitiated() {
    return CancelInitiated;
  }

  public void setCancelInitiated(boolean cancelInitiated) {
    CancelInitiated = cancelInitiated;
  }

  public boolean isImmediateOrCancel() {
    return ImmediateOrCancel;
  }

  public void setImmediateOrCancel(boolean immediateOrCancel) {
    ImmediateOrCancel = immediateOrCancel;
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

  @Override
  public String toString() {
    return "CCEXOpenorder [OrderUuid="
        + OrderUuid
        + ", Exchange="
        + Exchange
        + ", OrderType="
        + OrderType
        + ", Quantity="
        + Quantity
        + ", QuantityRemaining="
        + QuantityRemaining
        + ", Limit="
        + Limit
        + ", CommissionPaid="
        + CommissionPaid
        + ", Price="
        + Price
        + ", PricePerUnit="
        + PricePerUnit
        + ", Opened="
        + Opened
        + ", Closed="
        + Closed
        + ", CancelInitiated="
        + CancelInitiated
        + ", ImmediateOrCancel="
        + ImmediateOrCancel
        + ", IsConditional="
        + IsConditional
        + ", Condition="
        + Condition
        + ", ConditionTarget="
        + ConditionTarget
        + "]";
  }
}
