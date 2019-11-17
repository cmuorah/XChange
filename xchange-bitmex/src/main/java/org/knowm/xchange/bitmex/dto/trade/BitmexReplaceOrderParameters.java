package org.knowm.xchange.bitmex.dto.trade;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.knowm.xchange.bitmex.Bitmex;

/** See {@link Bitmex#replaceOrder} */
@SuppressWarnings({"unused", "WeakerAccess"})
public class BitmexReplaceOrderParameters {

  @Nullable private final String orderId;
  @Nullable private final String origClOrdId;
  @Nullable private final String clOrdId;
  @Nullable private final Double simpleOrderQuantity;
  @Nullable private final Double orderQuantity;
  @Nullable private final Double simpleLeavesQuantity;
  @Nullable private final Double leavesQuantity;
  @Nullable private final Double price;
  @Nullable private final Double stopPrice;
  @Nullable private final Double pegOffsetValue;
  @Nullable private final String text;

  public BitmexReplaceOrderParameters(
      @Nullable String orderId,
      @Nullable String origClOrdId,
      @Nullable String clOrdId,
      @Nullable Double simpleOrderQuantity,
      @Nullable Double orderQuantity,
      @Nullable Double simpleLeavesQuantity,
      @Nullable Double leavesQuantity,
      @Nullable Double price,
      @Nullable Double stopPrice,
      @Nullable Double pegOffsetValue,
      @Nullable String text) {
    this.orderId = orderId;
    this.origClOrdId = origClOrdId;
    this.clOrdId = clOrdId;
    this.simpleOrderQuantity = simpleOrderQuantity;
    this.orderQuantity = orderQuantity;
    this.simpleLeavesQuantity = simpleLeavesQuantity;
    this.leavesQuantity = leavesQuantity;
    this.price = price;
    this.stopPrice = stopPrice;
    this.pegOffsetValue = pegOffsetValue;
    this.text = text;
  }

  @Nullable
  public String getOrderId() {
    return orderId;
  }

  @Nullable
  public String getOrigClOrdId() {
    return origClOrdId;
  }

  @Nullable
  public String getClOrdId() {
    return clOrdId;
  }

  @Nullable
  public Double getSimpleOrderQuantity() {
    return simpleOrderQuantity;
  }

  @Nullable
  public Double getOrderQuantity() {
    return orderQuantity;
  }

  @Nullable
  public Double getSimpleLeavesQuantity() {
    return simpleLeavesQuantity;
  }

  @Nullable
  public Double getLeavesQuantity() {
    return leavesQuantity;
  }

  @Nullable
  public Double getPrice() {
    return price;
  }

  @Nullable
  public Double getStopPrice() {
    return stopPrice;
  }

  @Nullable
  public Double getPegOffsetValue() {
    return pegOffsetValue;
  }

  @Nullable
  public String getText() {
    return text;
  }

  /** See {@link Bitmex#replaceOrder} */
  public static class Builder {

    @Nullable private String orderId;
    @Nullable private String origClOrdId;
    @Nullable private String clOrdId;
    @Nullable private Double simpleOrderQuantity;
    @Nullable private Double orderQuantity;
    @Nullable private Double simpleLeavesQuantity;
    @Nullable private Double leavesQuantity;
    @Nullable private Double price;
    @Nullable private Double stopPrice;
    @Nullable private Double pegOffsetValue;
    @Nullable private String text;

    @Nonnull
    public BitmexReplaceOrderParameters build() {
      return new BitmexReplaceOrderParameters(
          orderId,
          origClOrdId,
          clOrdId,
          simpleOrderQuantity,
          orderQuantity,
          simpleLeavesQuantity,
          leavesQuantity,
          price,
          stopPrice,
          pegOffsetValue,
          text);
    }

    @Nonnull
    public Builder setOrderId(@Nullable String orderId) {
      this.orderId = orderId;
      return this;
    }

    @Nonnull
    public Builder setOrigClOrdId(@Nullable String origClOrdId) {
      this.origClOrdId = origClOrdId;
      return this;
    }

    @Nonnull
    public Builder setClOrdId(@Nullable String clOrdId) {
      this.clOrdId = clOrdId;
      return this;
    }

    @Nonnull
    public Builder setSimpleOrderQuantity(@Nullable Double simpleOrderQuantity) {
      this.simpleOrderQuantity = simpleOrderQuantity;
      return this;
    }

    @Nonnull
    public Builder setOrderQuantity(@Nullable Double orderQuantity) {
      this.orderQuantity = orderQuantity;
      return this;
    }

    @Nonnull
    public Builder setSimpleLeavesQuantity(@Nullable Double simpleLeavesQuantity) {
      this.simpleLeavesQuantity = simpleLeavesQuantity;
      return this;
    }

    @Nonnull
    public Builder setLeavesQuantity(@Nullable Double leavesQuantity) {
      this.leavesQuantity = leavesQuantity;
      return this;
    }

    @Nonnull
    public Builder setPrice(@Nullable Double price) {
      this.price = price;
      return this;
    }

    @Nonnull
    public Builder setStopPrice(@Nullable Double stopPrice) {
      this.stopPrice = stopPrice;
      return this;
    }

    @Nonnull
    public Builder setPegOffsetValue(@Nullable Double pegOffsetValue) {
      this.pegOffsetValue = pegOffsetValue;
      return this;
    }

    @Nonnull
    public Builder setText(@Nullable String text) {
      this.text = text;
      return this;
    }
  }

  @Override
  public String toString() {
    return "BitmexReplaceOrderParameters{"
        + "orderId="
        + orderId
        + ", origClOrdId='"
        + origClOrdId
        + "', clOrdId='"
        + clOrdId
        + "', simpleOrderQuantity="
        + simpleOrderQuantity
        + ", orderQuantity="
        + orderQuantity
        + ", simpleLeavesQuantity="
        + simpleLeavesQuantity
        + ", leavesQuantity="
        + leavesQuantity
        + ", price="
        + price
        + ", stopPrice="
        + stopPrice
        + ", pegOffsetValue="
        + pegOffsetValue
        + ", text='"
        + text
        + "'}";
  }
}
