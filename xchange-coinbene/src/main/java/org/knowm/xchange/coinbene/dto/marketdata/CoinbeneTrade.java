package org.knowm.xchange.coinbene.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.dto.Order;

public class CoinbeneTrade {
  private final Double price;
  private final Double quantity;
  private final Long timestamp;
  private final Take take;
  private final String tradeId;

  public CoinbeneTrade(
      @JsonProperty("price") Double price,
      @JsonProperty("quantity") Double quantity,
      @JsonProperty("time") Long timestamp,
      @JsonProperty("take") Take take,
      @JsonProperty("tradeId") String tradeId) {
    this.price = price;
    this.quantity = quantity;
    this.timestamp = timestamp;
    this.take = take;
    this.tradeId = tradeId;
  }

  public Double getPrice() {
    return price;
  }

  public Double getQuantity() {
    return quantity;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public Take getTake() {
    return take;
  }

  public String getTradeId() {
    return tradeId;
  }

  public enum Take {
    buy(Order.OrderType.ASK),
    sell(Order.OrderType.BID);

    private final Order.OrderType orderType;

    Take(Order.OrderType orderType) {
      this.orderType = orderType;
    }

    public Order.OrderType getOrderType() {
      return orderType;
    }
  }
}
