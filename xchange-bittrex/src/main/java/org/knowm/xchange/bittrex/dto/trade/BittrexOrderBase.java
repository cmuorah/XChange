package org.knowm.xchange.bittrex.dto.trade;

import java.util.Date;

public abstract class BittrexOrderBase {

  private final String orderUuid;
  private final String exchange;
  private final String orderType;
  private final Double quantity;
  private final Double quantityRemaining;
  private final Double limit;
  private final Double commissionPaid;
  private final Double price;
  private final Double pricePerUnit;
  private final Date opened;
  private final Date closed;
  private final Boolean cancelInitiated;
  private final Boolean immediateOrCancel;
  private final Boolean isConditional;
  private final String condition;
  private final Object conditionTarget;

  protected BittrexOrderBase(
      String orderUuid,
      String exchange,
      String orderType,
      Double quantity,
      Double quantityRemaining,
      Double limit,
      Double commissionPaid,
      Double price,
      Double pricePerUnit,
      Date opened,
      Date closed,
      Boolean cancelInitiated,
      Boolean immediateOrCancel,
      Boolean isConditional,
      String condition,
      Object conditionTarget) {
    this.orderUuid = orderUuid;
    this.exchange = exchange;
    this.orderType = orderType;
    this.quantity = quantity;
    this.quantityRemaining = quantityRemaining;
    this.limit = limit;
    this.commissionPaid = commissionPaid;
    this.price = price;
    this.pricePerUnit = pricePerUnit;
    this.opened = opened;
    this.closed = closed;
    this.cancelInitiated = cancelInitiated;
    this.immediateOrCancel = immediateOrCancel;
    this.isConditional = isConditional;
    this.condition = condition;
    this.conditionTarget = conditionTarget;
  }

  public String getOrderUuid() {
    return orderUuid;
  }

  public String getExchange() {
    return exchange;
  }

  public String getOrderType() {
    return orderType;
  }

  public Double getQuantity() {
    return quantity;
  }

  public Double getQuantityRemaining() {
    return quantityRemaining;
  }

  public Double getLimit() {
    return limit;
  }

  public Double getCommissionPaid() {
    return commissionPaid;
  }

  public Double getPrice() {
    return price;
  }

  public Double getPricePerUnit() {
    return pricePerUnit;
  }

  public Date getOpened() {
    return opened;
  }

  public Date getClosed() {
    return closed;
  }

  public Boolean getCancelInitiated() {
    return cancelInitiated;
  }

  public Boolean getImmediateOrCancel() {
    return immediateOrCancel;
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

  @Override
  public final String toString() {
    return "BittrexOrder [orderUuid="
        + getOrderUuid()
        + ", exchange="
        + getExchange()
        + ", orderType="
        + getOrderType()
        + ", quantity="
        + getQuantity()
        + ", quantityRemaining="
        + getQuantityRemaining()
        + ", limit="
        + getLimit()
        + ", commissionPaid="
        + getCommissionPaid()
        + ", price="
        + getPrice()
        + ", pricePerUnit="
        + getPricePerUnit()
        + ", opened="
        + getOpened()
        + ", closed="
        + getClosed()
        + ", cancelInitiated="
        + getCancelInitiated()
        + ", immediateOrCancel="
        + getImmediateOrCancel()
        + ", isConditional="
        + getConditional()
        + ", condition="
        + getCondition()
        + ", conditionTarget="
        + getConditionTarget()
        + ", "
        + additionalToString()
        + "]";
  }

  protected abstract String additionalToString();
}
