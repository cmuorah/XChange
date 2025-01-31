package org.knowm.xchange.coindirect.dto.trade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoindirectOrderRequest {
  @JsonProperty("symbol")
  public String symbol;

  @JsonProperty("amount")
  public Double amount;

  @JsonProperty("price")
  public Double price;

  @JsonProperty("type")
  public CoindirectOrder.Type type;

  @JsonProperty("side")
  public CoindirectOrder.Side side;

  public CoindirectOrderRequest(
      String symbol,
      Double amount,
      Double price,
      CoindirectOrder.Type type,
      CoindirectOrder.Side side) {
    this.symbol = symbol;
    this.amount = amount;
    this.price = price;
    this.type = type;
    this.side = side;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public CoindirectOrder.Type getType() {
    return type;
  }

  public void setType(CoindirectOrder.Type type) {
    this.type = type;
  }

  public CoindirectOrder.Side getSide() {
    return side;
  }

  public void setSide(CoindirectOrder.Side side) {
    this.side = side;
  }

  @Override
  public String toString() {
    return "CoindirectOrderRequest{"
        + "symbol='"
        + symbol
        + '\''
        + ", amount="
        + amount
        + ", price="
        + price
        + ", type="
        + type
        + ", side="
        + side
        + '}';
  }
}
