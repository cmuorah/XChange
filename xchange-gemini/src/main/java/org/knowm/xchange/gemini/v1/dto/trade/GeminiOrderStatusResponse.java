package org.knowm.xchange.gemini.v1.dto.trade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeminiOrderStatusResponse {

  private final long id;
  private final String exchange;
  private final String symbol;
  private final Double price;
  private final Double avgExecutionPrice;
  private final String side;
  private final String type;
  private final String timestamp;
  private final long timestampms;
  private final boolean isLive;
  private final boolean isCancelled;
  private final boolean wasForced;
  private final Double originalAmount;
  private final Double remainingAmount;
  private final Double executedAmount;

  /**
   * Constructor
   *
   * @param id
   * @param symbol
   * @param price
   * @param avgExecutionPrice
   * @param side
   * @param type
   * @param timestamp
   * @param isLive
   * @param isCancelled
   * @param wasForced
   * @param originalAmount
   * @param remainingAmount
   * @param executedAmount
   */
  public GeminiOrderStatusResponse(
      @JsonProperty("order_id") long id,
      @JsonProperty("exchange") String exchange,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("price") Double price,
      @JsonProperty("avg_execution_price") Double avgExecutionPrice,
      @JsonProperty("side") String side,
      @JsonProperty("type") String type,
      @JsonProperty("timestamp") String timestamp,
      @JsonProperty("timestampms") long timestampms,
      @JsonProperty("is_live") boolean isLive,
      @JsonProperty("is_cancelled") boolean isCancelled,
      @JsonProperty("was_forced") boolean wasForced,
      @JsonProperty("original_amount") Double originalAmount,
      @JsonProperty("remaining_amount") Double remainingAmount,
      @JsonProperty("executed_amount") Double executedAmount) {

    this.id = id;
    this.exchange = exchange;
    this.symbol = symbol;
    this.price = price;
    this.avgExecutionPrice = avgExecutionPrice;
    this.side = side;
    this.type = type;
    this.timestamp = timestamp;
    this.timestampms = timestampms;
    this.isLive = isLive;
    this.isCancelled = isCancelled;
    this.wasForced = wasForced;
    this.originalAmount = originalAmount;
    this.remainingAmount = remainingAmount;
    this.executedAmount = executedAmount;
  }

  public Double getExecutedAmount() {

    return executedAmount;
  }

  public Double getRemainingAmount() {

    return remainingAmount;
  }

  public Double getOriginalAmount() {

    return originalAmount;
  }

  public boolean getWasForced() {

    return wasForced;
  }

  public String getType() {

    return type;
  }

  public String getSymbol() {

    return symbol;
  }

  public boolean isCancelled() {

    return isCancelled;
  }

  public Double getPrice() {

    return price;
  }

  public String getSide() {

    return side;
  }

  public String getTimestamp() {

    return timestamp;
  }

  public long getId() {

    return id;
  }

  public boolean isLive() {

    return isLive;
  }

  public Double getAvgExecutionPrice() {

    return avgExecutionPrice;
  }

  public Long getTimestampms() {
    return timestampms;
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    builder.append("GeminiOrderStatusResponse [id=");
    builder.append(id);
    builder.append(", symbol=");
    builder.append(symbol);
    builder.append(", price=");
    builder.append(price);
    builder.append(", avgExecutionPrice=");
    builder.append(avgExecutionPrice);
    builder.append(", side=");
    builder.append(side);
    builder.append(", type=");
    builder.append(type);
    builder.append(", timestamp=");
    builder.append(timestamp);
    builder.append(", isLive=");
    builder.append(isLive);
    builder.append(", isCancelled=");
    builder.append(isCancelled);
    builder.append(", wasForced=");
    builder.append(wasForced);
    builder.append(", originalAmount=");
    builder.append(originalAmount);
    builder.append(", remainingAmount=");
    builder.append(remainingAmount);
    builder.append(", executedAmount=");
    builder.append(executedAmount);
    builder.append("]");
    return builder.toString();
  }
}
