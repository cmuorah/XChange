package org.knowm.xchange.gemini.v1.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeminiTradeResponse {

  private final Double price;
  private final Double amount;
  private final Double timestamp;
  private final String exchange;
  private final String type;
  private final String tradeId;
  private final String orderId;
  private final Double feeAmount;
  private final String feeCurrency;

  /**
   * Constructor
   *
   * @param price
   * @param amount
   * @param timestamp
   * @param exchange
   * @param type
   * @param tradeId
   * @param orderId
   * @param feeAmount
   * @param feeCurrency
   */
  public GeminiTradeResponse(
      @JsonProperty("price") final Double price,
      @JsonProperty("amount") final Double amount,
      @JsonProperty("timestamp") final Double timestamp,
      @JsonProperty("exchange") final String exchange,
      @JsonProperty("type") final String type,
      @JsonProperty("tid") final String tradeId,
      @JsonProperty("order_id") final String orderId,
      @JsonProperty("fee_amount") final Double feeAmount,
      @JsonProperty("fee_currency") String feeCurrency) {

    this.price = price;
    this.amount = amount;
    this.timestamp = timestamp;
    this.exchange = exchange;
    this.type = type;
    this.tradeId = tradeId;
    this.orderId = orderId;
    this.feeAmount = feeAmount;
    this.feeCurrency = feeCurrency;
  }

  public Double getPrice() {

    return price;
  }

  public Double getAmount() {

    return amount;
  }

  public Double getTimestamp() {

    return timestamp;
  }

  public String getType() {

    return type;
  }

  public String getOrderId() {

    return orderId;
  }

  public String getTradeId() {

    return tradeId;
  }

  public Double getFeeAmount() {

    return feeAmount;
  }

  public String getFeeCurrency() {

    return feeCurrency;
  }

  @Override
  public String toString() {

    final StringBuilder builder = new StringBuilder();
    builder.append("GeminiTradeResponse [price=");
    builder.append(price);
    builder.append(", amount=");
    builder.append(amount);
    builder.append(", timestamp=");
    builder.append(timestamp);
    builder.append(", exchange=");
    builder.append(exchange);
    builder.append(", type=");
    builder.append(type);
    builder.append("]");
    builder.append(", tradeId=");
    builder.append(tradeId);
    builder.append("]");
    builder.append(", orderId=");
    builder.append(orderId);
    builder.append(", fee=");
    builder.append(feeAmount);
    builder.append(" ");
    builder.append(feeCurrency);
    builder.append("]");
    return builder.toString();
  }
}
