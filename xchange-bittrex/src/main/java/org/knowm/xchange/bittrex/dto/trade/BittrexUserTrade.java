package org.knowm.xchange.bittrex.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BittrexUserTrade {

  private final String orderUuid;
  private final String exchange;
  private final String timeStamp;
  private final String orderType;
  private final Double limit;
  private final Double quantity;
  private final Double quantityRemaining;
  private final Double commission;
  private final Double price;
  private final Double pricePerUnit;
  private final Boolean isConditional;
  private final String condition;
  private final Object conditionTarget;
  private final Boolean immediateOrCancel;
  private final String closed;

  public BittrexUserTrade(
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
      @JsonProperty("IsConditional") Boolean isConditional,
      @JsonProperty("Condition") String condition,
      @JsonProperty("ConditionTarget") Object conditionTarget,
      @JsonProperty("ImmediateOrCancel") Boolean immediateOrCancel,
      @JsonProperty("Closed") String closed) {
    this.orderUuid = orderUuid;
    this.exchange = exchange;
    this.timeStamp = timeStamp;
    this.orderType = orderType;
    this.limit = limit;
    this.quantity = quantity;
    this.quantityRemaining = quantityRemaining;
    this.commission = commission;
    this.price = price;
    this.pricePerUnit = pricePerUnit;
    this.isConditional = isConditional;
    this.condition = condition;
    this.conditionTarget = conditionTarget;
    this.immediateOrCancel = immediateOrCancel;
    this.closed = closed;
  }

  public String getOrderUuid() {
    return orderUuid;
  }

  public String getExchange() {
    return exchange;
  }

  public String getTimeStamp() {
    return timeStamp;
  }

  public String getOrderType() {
    return orderType;
  }

  public Double getLimit() {
    return limit;
  }

  public Double getQuantity() {
    return quantity;
  }

  public Double getQuantityRemaining() {
    return quantityRemaining;
  }

  public Double getCommission() {
    return commission;
  }

  public Double getPrice() {
    return price;
  }

  public Double getPricePerUnit() {
    return pricePerUnit;
  }

  public Boolean getConditional() {
    return isConditional;
  }

  public String getCondition() {
    return condition;
  }

  public Object getConditionTarget() {
    return conditionTarget;
  }

  public Boolean getImmediateOrCancel() {
    return immediateOrCancel;
  }

  public String getClosed() {
    return closed;
  }

  @Override
  public String toString() {

    return "BittrexUserTrade [orderUuid="
        + getOrderUuid()
        + ", exchange="
        + getExchange()
        + ", timeStamp="
        + getTimeStamp()
        + ", orderType="
        + getOrderType()
        + ", limit="
        + getLimit()
        + ", quantity="
        + getQuantity()
        + ", quantityRemaining="
        + getQuantityRemaining()
        + ", commission="
        + getCommission()
        + ", price="
        + getPrice()
        + ", pricePerUnit="
        + getPricePerUnit()
        + ", isConditional="
        + getConditional()
        + ", condition="
        + getCondition()
        + ", conditionTarget="
        + getConditionTarget()
        + ", immediateOrCancel="
        + getImmediateOrCancel()
        + "]";
  }
}
