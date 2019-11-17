package org.knowm.xchange.coindirect.dto.trade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoindirectOrder {
  public final String symbol;
  public final String uuid;
  public final Double amount;
  public final Double executedAmount;
  public final Double executedPrice;
  public final Double price;
  public final Status status;
  public final Side side;
  public final Date dateCreated;
  public final Type type;
  public final Double executedFees;

  public CoindirectOrder(
      @JsonProperty("symbol") String symbol,
      @JsonProperty("uuid") String uuid,
      @JsonProperty("amount") Double amount,
      @JsonProperty("executedAmount") Double executedAmount,
      @JsonProperty("executedPrice") Double executedPrice,
      @JsonProperty("price") Double price,
      @JsonProperty("status") Status status,
      @JsonProperty("side") Side side,
      @JsonProperty("dateCreated") Date dateCreated,
      @JsonProperty("type") Type type,
      @JsonProperty("executedFees") Double executedFees) {
    this.symbol = symbol;
    this.uuid = uuid;
    this.amount = amount;
    this.executedAmount = executedAmount;
    this.executedPrice = executedPrice;
    this.price = price;
    this.status = status;
    this.side = side;
    this.dateCreated = dateCreated;
    this.type = type;
    this.executedFees = executedFees;
  }

  public enum Side {
    BUY,
    SELL
  }

  public enum Type {
    LIMIT,
    MARKET
  }

  public enum Status {
    SUBMITTED,
    PLACED,
    PENDING_CANCEL,
    CANCELLED,
    PARTIAL_CANCEL,
    PARTIAL,
    COMPLETED,
    ERROR
  }

  @Override
  public String toString() {
    return "CoindirectOrder{"
        + "symbol='"
        + symbol
        + '\''
        + ", uuid='"
        + uuid
        + '\''
        + ", amount="
        + amount
        + ", executedAmount="
        + executedAmount
        + ", executedPrice="
        + executedPrice
        + ", price="
        + price
        + ", status="
        + status
        + ", side="
        + side
        + ", dateCreated="
        + dateCreated
        + ", type="
        + type
        + ", executedFees="
        + executedFees
        + '}';
  }
}
