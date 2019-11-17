package org.knowm.xchange.bitfinex.v1.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.dto.Order.OrderType;

public class BitfinexActivePositionsResponse {

  private final long id;
  private final String symbol;
  private final String status;
  private final Double base;
  private final Double amount;
  private final Double timestamp;
  private final Double swap;
  private final Double pnl;
  private final OrderType orderType;

  public BitfinexActivePositionsResponse(
      @JsonProperty("id") long id,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("status") String status,
      @JsonProperty("base") Double base,
      @JsonProperty("amount") Double amount,
      @JsonProperty("timestamp") Double timestamp,
      @JsonProperty("swap") Double swap,
      @JsonProperty("pl") Double pnl) {

    this.id = id;
    this.symbol = symbol;
    this.status = status;
    this.base = base;
    this.amount = amount;
    this.timestamp = timestamp;
    this.swap = swap;
    this.pnl = pnl;
    this.orderType = Math.signum(amount) < 0 ? OrderType.ASK : OrderType.BID;
  }

  public long getId() {
    return id;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getStatus() {

    return status;
  }

  public Double getBase() {

    return base;
  }

  public Double getAmount() {

    return amount;
  }

  public Double getTimestamp() {

    return timestamp;
  }

  public Double getSwap() {

    return swap;
  }

  public Double getPnl() {

    return pnl;
  }

  public OrderType getOrderType() {

    return orderType;
  }

  @Override
  public String toString() {

    return "BitfinexActivePositionsResponse [id="
        + id
        + ", symbol="
        + symbol
        + ", status="
        + status
        + ", base="
        + base
        + ", amount="
        + amount
        + ", timestamp="
        + timestamp
        + ", swap="
        + swap
        + ", pnl="
        + pnl
        + ", orderType="
        + orderType
        + "]";
  }
}
