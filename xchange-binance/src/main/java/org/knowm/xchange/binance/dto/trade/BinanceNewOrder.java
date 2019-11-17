package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class BinanceNewOrder {

  public final String symbol;
  public final long orderId;
  public final String clientOrderId;
  public final long transactTime;
  public final Double price;
  public final Double origQty;
  public final Double executedQty;
  public final OrderStatus status;
  public final TimeInForce timeInForce;
  public final OrderType type;
  public final OrderSide side;

  public BinanceNewOrder(
      @JsonProperty("symbol") String symbol,
      @JsonProperty("orderId") long orderId,
      @JsonProperty("clientOrderId") String clientOrderId,
      @JsonProperty("transactTime") long transactTime,
      @JsonProperty("price") Double price,
      @JsonProperty("origQty") Double origQty,
      @JsonProperty("executedQty") Double executedQty,
      @JsonProperty("status") OrderStatus status,
      @JsonProperty("timeInForce") TimeInForce timeInForce,
      @JsonProperty("type") OrderType type,
      @JsonProperty("side") OrderSide side) {
    super();
    this.symbol = symbol;
    this.orderId = orderId;
    this.clientOrderId = clientOrderId;
    this.transactTime = transactTime;
    this.price = price;
    this.origQty = origQty;
    this.executedQty = executedQty;
    this.status = status;
    this.timeInForce = timeInForce;
    this.type = type;
    this.side = side;
  }
}
