package org.knowm.xchange.bibox.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BiboxTradeCommandBody {

  private String pair;

  @JsonProperty("account_type")
  private int accountType;

  @JsonProperty("order_type")
  private int orderType;

  @JsonProperty("order_side")
  private int orderSide;

  @JsonProperty("pay_bix")
  private boolean payBix;

  private Double price;

  private Double amount;

  /** what? */
  private Double money;

  public BiboxTradeCommandBody(
      String pair,
      int accountType,
      int orderType,
      int orderSide,
      boolean payBix,
      Double price,
      Double amount,
      Double money) {
    super();
    this.pair = pair;
    this.accountType = accountType;
    this.orderType = orderType;
    this.orderSide = orderSide;
    this.payBix = payBix;
    this.price = price;
    this.amount = amount;
    this.money = money;
  }

  public String getPair() {
    return pair;
  }

  public int getAccountType() {
    return accountType;
  }

  public int getOrderType() {
    return orderType;
  }

  public int getOrderSide() {
    return orderSide;
  }

  public boolean isPayBix() {
    return payBix;
  }

  public Double getPrice() {
    return price;
  }

  public Double getAmount() {
    return amount;
  }

  public Double getMoney() {
    return money;
  }
}
