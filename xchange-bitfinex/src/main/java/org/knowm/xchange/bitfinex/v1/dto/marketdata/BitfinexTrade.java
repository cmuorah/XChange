package org.knowm.xchange.bitfinex.v1.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitfinexTrade {

  private final Double price;
  private final Double amount;
  private final long timestamp;
  private final String exchange;
  private final long tradeId;
  private final String type;

  /**
   * Constructor
   *
   * @param price
   * @param amount
   * @param timestamp
   * @param exchange
   * @param tradeId
   */
  public BitfinexTrade(
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("timestamp") long timestamp,
      @JsonProperty("exchange") String exchange,
      @JsonProperty("tid") long tradeId,
      @JsonProperty("type") String type) {

    this.price = price;
    this.amount = amount;
    this.timestamp = timestamp;
    this.exchange = exchange;
    this.tradeId = tradeId;
    this.type = type;
  }

  public Double getPrice() {

    return price;
  }

  public Double getAmount() {

    return amount;
  }

  public long getTimestamp() {

    return timestamp;
  }

  public String getExchange() {

    return exchange;
  }

  public long getTradeId() {

    return tradeId;
  }

  public String getType() {

    return type;
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    builder.append("BitfinexTrade [price=");
    builder.append(price);
    builder.append(", amount=");
    builder.append(amount);
    builder.append(", timestamp=");
    builder.append(timestamp);
    builder.append(", exchange=");
    builder.append(exchange);
    builder.append(", tradeId=");
    builder.append(tradeId);
    builder.append(", type=");
    builder.append(type);
    builder.append("]");
    return builder.toString();
  }
}
