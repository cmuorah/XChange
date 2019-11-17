package org.knowm.xchange.luno.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Date;

public class LunoUserTrades {

  private final UserTrade[] trades;

  public LunoUserTrades(@JsonProperty(value = "trades", required = true) UserTrade[] trades) {
    this.trades = trades != null ? trades : new UserTrade[0];
  }

  public UserTrade[] getTrades() {
    UserTrade[] copy = new UserTrade[trades.length];
    System.arraycopy(trades, 0, copy, 0, trades.length);
    return copy;
  }

  @Override
  public String toString() {
    return "LunoUserTrades [trades(" + trades.length + ")=" + Arrays.toString(trades) + "]";
  }

  public static class UserTrade {
    public final String pair;
    public final String orderId;
    public final OrderType type;
    public final long timestamp;
    public final Double price;
    public final Double volume;
    public final Double base;
    public final Double counter;
    public final Double feeBase;
    public final Double feeCounter;
    public final boolean buy;

    public UserTrade(
        @JsonProperty(value = "pair", required = false) String pair,
        @JsonProperty(value = "order_id", required = true) String orderId,
        @JsonProperty(value = "type", required = false) OrderType type,
        @JsonProperty(value = "timestamp", required = true) long timestamp,
        @JsonProperty(value = "price", required = true) Double price,
        @JsonProperty(value = "volume", required = true) Double volume,
        @JsonProperty(value = "base", required = true) Double base,
        @JsonProperty(value = "counter", required = true) Double counter,
        @JsonProperty(value = "fee_base", required = true) Double feeBase,
        @JsonProperty(value = "fee_counter", required = true) Double feeCounter,
        @JsonProperty(value = "is_buy", required = true) boolean buy) {
      this.pair = pair;
      this.orderId = orderId;
      this.type = type;
      this.timestamp = timestamp;
      this.price = price;
      this.volume = volume;
      this.base = base;
      this.counter = counter;
      this.feeBase = feeBase;
      this.feeCounter = feeCounter;
      this.buy = buy;
    }

    public Date getTimestamp() {
      return new Date(timestamp);
    }

    @Override
    public String toString() {
      return "UserTrade [base="
          + base
          + ", counter="
          + counter
          + ", feeBase="
          + feeBase
          + ", feeCounter="
          + feeCounter
          + ", buy="
          + buy
          + ", orderId="
          + orderId
          + ", pair="
          + pair
          + ", price="
          + price
          + ", timestamp="
          + getTimestamp()
          + ", type="
          + type
          + ", volume="
          + volume
          + "]";
    }
  }
}
