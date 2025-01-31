package org.knowm.xchange.coinegg.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.dto.Order.OrderType;

public class CoinEggTrade {

  private final Double price;
  private final Double amount;
  private final Type type;
  private final long timestamp;
  private final int tid;

  public CoinEggTrade(
      @JsonProperty("date") long timestamp,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("tid") int tid,
      @JsonProperty("type") Type type) {

    this.timestamp = timestamp;
    this.price = price;
    this.amount = amount;
    this.tid = tid;
    this.type = type;
  }

  public Double getPrice() {
    return price;
  }

  public Double getAmount() {
    return amount;
  }

  public Type getType() {
    return type;
  }

  public OrderType getOrderType() {
    return type == Type.BUY ? OrderType.BID : OrderType.ASK;
  }

  public int getTransactionID() {
    return tid;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public enum Type {
    BUY,
    SELL;

    @JsonCreator
    public static Type forValue(String value) {
      return Type.valueOf(value.toUpperCase());
    }
  }
}
