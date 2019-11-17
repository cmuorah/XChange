package org.knowm.xchange.luno.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Date;

public class LunoTrades {

  private final Trade[] trades;

  public LunoTrades(@JsonProperty(value = "trades", required = true) Trade[] trades) {
    this.trades = trades != null ? trades : new Trade[0];
  }

  @Override
  public String toString() {
    return "LunoTrades [trades(" + trades.length + ")=" + Arrays.toString(trades) + "]";
  }

  public Trade[] getTrades() {
    Trade[] copy = new Trade[trades.length];
    System.arraycopy(trades, 0, copy, 0, trades.length);
    return copy;
  }

  public static class Trade {
    public final long timestamp;
    public final Double price;
    public final Double volume;
    public final boolean buy;

    public Trade(
        @JsonProperty(value = "timestamp", required = true) long timestamp,
        @JsonProperty(value = "price", required = true) Double price,
        @JsonProperty(value = "volume", required = true) Double volume,
        @JsonProperty(value = "is_buy", required = true) boolean buy) {
      this.timestamp = timestamp;
      this.price = price;
      this.volume = volume;
      this.buy = buy;
    }

    public Date getTimestamp() {
      return new Date(timestamp);
    }

    @Override
    public String toString() {
      return "Trade [timestamp="
          + getTimestamp()
          + ", price="
          + price
          + ", volume="
          + volume
          + ", buy="
          + buy
          + "]";
    }
  }
}
