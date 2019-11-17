package org.knowm.xchange.binance.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public final class BinanceOrder {

  public final String symbol;
  public final long orderId;
  public final String clientOrderId;
  public final Double price;
  public final Double origQty;
  public final Double executedQty;
  public final Double cummulativeQuoteQty;
  public final OrderStatus status;
  public final TimeInForce timeInForce;
  public final OrderType type;
  public final OrderSide side;
  public final Double stopPrice;
  public final Double icebergQty;
  public final long time;

  public BinanceOrder(
      @JsonProperty("symbol") String symbol,
      @JsonProperty("orderId") long orderId,
      @JsonProperty("clientOrderId") String clientOrderId,
      @JsonProperty("price") Double price,
      @JsonProperty("origQty") Double origQty,
      @JsonProperty("executedQty") Double executedQty,
      @JsonProperty("cummulativeQuoteQty") Double cummulativeQuoteQty,
      @JsonProperty("status") OrderStatus status,
      @JsonProperty("timeInForce") TimeInForce timeInForce,
      @JsonProperty("type") OrderType type,
      @JsonProperty("side") OrderSide side,
      @JsonProperty("stopPrice") Double stopPrice,
      @JsonProperty("icebergQty") Double icebergQty,
      @JsonProperty("time") long time) {
    this.symbol = symbol;
    this.orderId = orderId;
    this.clientOrderId = clientOrderId;
    this.price = price;
    this.origQty = origQty;
    this.executedQty = executedQty;
    this.cummulativeQuoteQty = cummulativeQuoteQty;
    this.status = status;
    this.timeInForce = timeInForce;
    this.type = type;
    this.side = side;
    this.stopPrice = stopPrice;
    this.icebergQty = icebergQty;
    this.time = time;
  }

  public Date getTime() {
    return new Date(time);
  }
}
