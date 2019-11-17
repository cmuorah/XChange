package org.knowm.xchange.bitfinex.v2.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.knowm.xchange.dto.Order.OrderType;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class BitfinexPublicTrade {

  private long tradeId;
  private long timestamp;
  private Double amount;
  private Double price;

  public BitfinexPublicTrade() {}

  public BitfinexPublicTrade(long tradeId, long timestamp, Double amount, Double price) {

    this.tradeId = tradeId;
    this.timestamp = timestamp;
    this.amount = amount;
    this.price = price;
  }

  public long getTradeId() {

    return tradeId;
  }

  public long getTimestamp() {

    return timestamp;
  }

  public Double getAmount() {

    return amount;
  }

  public OrderType getType() {

    return Math.signum(getAmount()) == -1 ? OrderType.ASK : OrderType.BID;
  }

  public Double getPrice() {

    return price;
  }

  @Override
  public String toString() {
    return "BitfinexPublicTrade [tradeId="
        + tradeId
        + ", timestamp="
        + timestamp
        + ", amount="
        + amount
        + ", price="
        + price
        + "]";
  }
}
