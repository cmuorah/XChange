package org.knowm.xchange.liqui.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.liqui.dto.LiquiTradeType;

public class LiquiPublicTrade {

  private final LiquiTradeType type;
  private final Double price;
  private final Double amount;
  private final long tradeId;
  private final long timestamp;

  public LiquiPublicTrade(
      @JsonProperty("type") final LiquiTradeType type,
      @JsonProperty("price") final String price,
      @JsonProperty("amount") final String amount,
      @JsonProperty("tid") final long tradeId,
      @JsonProperty("timestamp") final long timestamp) {
    this.type = type;
    this.price = new Double(price);
    this.amount = new Double(amount);
    this.tradeId = tradeId;
    this.timestamp = timestamp;
  }

  public LiquiTradeType getType() {
    return type;
  }

  public Double getPrice() {
    return price;
  }

  public Double getAmount() {
    return amount;
  }

  public long getTradeId() {
    return tradeId;
  }

  public long getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return "LiquiPublicTrade{"
        + "type="
        + type
        + ", price="
        + price
        + ", amount="
        + amount
        + ", tradeId="
        + tradeId
        + ", timestamp="
        + timestamp
        + '}';
  }
}
