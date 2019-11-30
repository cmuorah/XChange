package org.knowm.xchange.globitex.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.openhft.chronicle.wire.AbstractMarshallable;

import java.io.Serializable;

public class GlobitexUserTrade extends AbstractMarshallable implements Serializable {

  @JsonProperty("tradeId")
  private final long tradeId;

  @JsonProperty("symbol")
  private final String symbol;

  @JsonProperty("side")
  private final String side;

  @JsonProperty("originalOrderId")
  private final String originalOrderId;

  @JsonProperty("clientOrderId")
  private final String clientOrderId;

  @JsonProperty("execQuantity")
  private final Double quantity;

  @JsonProperty("execPrice")
  private final Double price;

  @JsonProperty("timestamp")
  private final long timestamp;

  @JsonProperty("fee")
  private final Double fee;

  @JsonProperty("isLiqProvided")
  private final boolean isLiqProvided;

  @JsonProperty("feeCurrency")
  private final String feeCurrency;

  @JsonProperty("account")
  private final String account;

  public GlobitexUserTrade(
      @JsonProperty("tradeId") long tradeId,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("side") String side,
      @JsonProperty("originalOrderId") String originalOrderId,
      @JsonProperty("clientOrderId") String clientOrderId,
      @JsonProperty("execQuantity") Double quantity,
      @JsonProperty("execPrice") Double price,
      @JsonProperty("timestamp") long timestamp,
      @JsonProperty("fee") Double fee,
      @JsonProperty("isLiqProvided") boolean isLiqProvided,
      @JsonProperty("feeCurrency") String feeCurrency,
      @JsonProperty("amount") String account) {
    this.tradeId = tradeId;
    this.symbol = symbol;
    this.side = side;
    this.originalOrderId = originalOrderId;
    this.clientOrderId = clientOrderId;
    this.quantity = quantity;
    this.price = price;
    this.timestamp = timestamp;
    this.fee = fee;
    this.isLiqProvided = isLiqProvided;
    this.feeCurrency = feeCurrency;
    this.account = account;
  }

  public long getTradeId() {
    return tradeId;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getSide() {
    return side;
  }

  public String getOriginalOrderId() {
    return originalOrderId;
  }

  public String getClientOrderId() {
    return clientOrderId;
  }

  public Double getQuantity() {
    return quantity;
  }

  public Double getPrice() {
    return price;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public Double getFee() {
    return fee;
  }

  public boolean isLiqProvided() {
    return isLiqProvided;
  }

  public String getFeeCurrency() {
    return feeCurrency;
  }

  public String getAccount() {
    return account;
  }

  @Override
  public String toString() {
    return "GlobitexUserTrade{"
        + "tradeId='"
        + tradeId
        + '\''
        + ", symbol='"
        + symbol
        + '\''
        + ", side='"
        + side
        + '\''
        + ", originalOrderId='"
        + originalOrderId
        + '\''
        + ", clientOrderId='"
        + clientOrderId
        + '\''
        + ", quantity="
        + quantity
        + ", price="
        + price
        + ", timestamp="
        + timestamp
        + ", fee="
        + fee
        + ", isLiqProvided="
        + isLiqProvided
        + ", feeCurrency='"
        + feeCurrency
        + '\''
        + ", account='"
        + account
        + '\''
        + '}';
  }
}
