package org.knowm.xchange.fcoin.dto.trade;

public class FCoinOrder {

  private String symbol;
  private FCoinSide side;
  private FCoinType type;
  private Double price;
  private Double amount;

  public FCoinOrder(String symbol, FCoinSide side, FCoinType type, Double price, Double amount) {
    this.symbol = symbol;
    this.side = side;
    this.type = type;
    this.price = price;
    this.amount = amount;
  }

  public String getSymbol() {
    return symbol;
  }

  public FCoinSide getSide() {
    return side;
  }

  public FCoinType getType() {
    return type;
  }

  public Double getPrice() {
    return price;
  }

  public Double getAmount() {
    return amount;
  }
}
