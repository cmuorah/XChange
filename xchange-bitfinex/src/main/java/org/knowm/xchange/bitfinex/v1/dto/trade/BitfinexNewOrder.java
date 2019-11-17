package org.knowm.xchange.bitfinex.v1.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitfinexNewOrder {

  @JsonProperty("symbol")
  protected String symbol;

  @JsonProperty("exchange")
  protected String exchange;

  @JsonProperty("side")
  protected String side;

  @JsonProperty("type")
  protected String type;

  @JsonProperty("amount")
  protected Double amount;

  @JsonProperty("price")
  protected Double price;

  public BitfinexNewOrder(
      String symbol, String exchange, String side, String type, Double amount, Double price) {

    this.symbol = symbol;
    this.exchange = exchange;
    this.side = side;
    this.type = type;
    this.amount = amount;
    this.price = price;
  }

  public String getSymbol() {

    return symbol;
  }

  public void setSymbol(String symbol) {

    this.symbol = symbol;
  }

  public String getExchange() {

    return exchange;
  }

  public void setExchange(String exchange) {

    this.exchange = exchange;
  }

  public String getSide() {

    return side;
  }

  public void setSide(String side) {

    this.side = side;
  }

  public String getType() {

    return type;
  }

  public void setType(String type) {

    this.type = type;
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
}
