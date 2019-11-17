package org.knowm.xchange.luno.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Date;

public class LunoOrders {

  private final Order[] orders;

  public LunoOrders(@JsonProperty(value = "orders", required = true) Order[] orders) {
    this.orders = orders != null ? orders : new Order[0];
  }

  public Order[] getOrders() {
    Order[] copy = new Order[orders.length];
    System.arraycopy(orders, 0, copy, 0, orders.length);
    return copy;
  }

  @Override
  public String toString() {
    return "LunoOrders [orders(" + orders.length + ")=" + Arrays.toString(orders) + "]";
  }

  public static class Order {
    public final String orderId;
    public final long creationTimestamp;
    public final long expirationTimestamp;
    public final long completedTimestamp;
    public final OrderType type;
    public final State state;
    public final Double limitPrice;
    public final Double limitVolume;
    public final Double base;
    public final Double counter;
    public final Double feeBase;
    public final Double feeCounter;
    public final String pair;

    public Order(
        @JsonProperty(value = "order_id", required = true) String orderId,
        @JsonProperty(value = "creation_timestamp", required = true) long creationTimestamp,
        @JsonProperty(value = "expiration_timestamp", required = true) long expirationTimestamp,
        @JsonProperty(value = "completed_timestamp", required = true) long completedTimestamp,
        @JsonProperty(value = "type", required = false) OrderType type,
        @JsonProperty(value = "state", required = false) State state,
        @JsonProperty(value = "limit_price", required = true) Double limitPrice,
        @JsonProperty(value = "limit_volume", required = true) Double limitVolume,
        @JsonProperty(value = "base", required = true) Double base,
        @JsonProperty(value = "counter", required = true) Double counter,
        @JsonProperty(value = "fee_base", required = true) Double feeBase,
        @JsonProperty(value = "fee_counter", required = true) Double feeCounter,
        @JsonProperty(value = "pair", required = false) String pair) {
      this.orderId = orderId;
      this.creationTimestamp = creationTimestamp;
      this.expirationTimestamp = expirationTimestamp;
      this.completedTimestamp = completedTimestamp;
      this.type = type;
      this.state = state;
      this.limitPrice = limitPrice;
      this.limitVolume = limitVolume;
      this.base = base;
      this.counter = counter;
      this.feeBase = feeBase;
      this.feeCounter = feeCounter;
      this.pair = pair;
    }

    public Date getCreationTimestamp() {
      return new Date(creationTimestamp);
    }

    public Date getExpirationTimestamp() {
      return expirationTimestamp == 0 ? null : new Date(expirationTimestamp);
    }

    public Date getCompletedTimestamp() {
      return completedTimestamp == 0 ? null : new Date(completedTimestamp);
    }

    @Override
    public String toString() {
      return "Order [orderId="
          + orderId
          + ", type="
          + type
          + ", state="
          + state
          + ", limitPrice="
          + limitPrice
          + ", limitVolume="
          + limitVolume
          + ", base="
          + base
          + ", counter="
          + counter
          + ", feeBase="
          + feeBase
          + ", feeCounter="
          + feeCounter
          + ", pair="
          + pair
          + ", getCreationTimestamp()="
          + getCreationTimestamp()
          + ", getExpirationTimestamp()="
          + getExpirationTimestamp()
          + ", getCompletedTimestamp()="
          + getCompletedTimestamp()
          + "]";
    }
  }
}
