package org.knowm.xchange.cexio.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.Objects;

public class CexIOTransaction {

  private final String id;
  private final String d;
  private final String c;
  private final Double a;
  private final Double ds;
  private final Double cs;
  private final String user;
  private final String symbol;
  private final String symbol1;
  private final String symbol2;
  private final Double amount;
  private final Long buy;
  private final Long order;
  private final Long sell;
  private final Double price;
  private final String type;
  private final Date time;
  private final Double balance;
  private final Double feeAmount;
  private final String pair;
  private final String pos;

  public CexIOTransaction(
      @JsonProperty("id") String id,
      @JsonProperty("d") String d,
      @JsonProperty("c") String c,
      @JsonProperty("a") Double a,
      @JsonProperty("ds") Double ds,
      @JsonProperty("cs") Double cs,
      @JsonProperty("user") String user,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("symbol1") String symbol1,
      @JsonProperty("symbol2") String symbol2,
      @JsonProperty("amount") Double amount,
      @JsonProperty("order") Long order,
      @JsonProperty("buy") Long buy,
      @JsonProperty("sell") Long sell,
      @JsonProperty("price") Double price,
      @JsonProperty("type") String type,
      @JsonProperty("time") Date time,
      @JsonProperty("balance") Double balance,
      @JsonProperty("fee_amount") Double feeAmount,
      @JsonProperty("pair") String pair,
      @JsonProperty("pos") String pos) {
    this.id = id;
    this.d = d;
    this.c = c;
    this.a = a;
    this.ds = ds;
    this.cs = cs;
    this.user = user;
    this.symbol = symbol;
    this.symbol1 = symbol1;
    this.symbol2 = symbol2;
    this.amount = amount;
    this.buy = buy;
    this.order = order;
    this.sell = sell;
    this.price = price;
    this.type = type;
    this.time = time;
    this.balance = balance;
    this.feeAmount = feeAmount;
    this.pair = pair;
    this.pos = pos;
  }

  public String getId() {
    return id;
  }

  public String getD() {
    return d;
  }

  public String getC() {
    return c;
  }

  public Double getA() {
    return a;
  }

  public Double getDs() {
    return ds;
  }

  public Double getCs() {
    return cs;
  }

  public String getUser() {
    return user;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getSymbol1() {
    return symbol1;
  }

  public String getSymbol2() {
    return symbol2;
  }

  public Double getAmount() {
    return amount;
  }

  public Long getBuy() {
    return buy;
  }

  public Long getOrder() {
    return order;
  }

  public Long getSell() {
    return sell;
  }

  public Double getPrice() {
    return price;
  }

  public String getType() {
    return type;
  }

  public Date getTime() {
    return time;
  }

  public Double getBalance() {
    return balance;
  }

  public Double getFeeAmount() {
    return feeAmount;
  }

  public String getPair() {
    return pair;
  }

  public String getPos() {
    return pos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CexIOTransaction that = (CexIOTransaction) o;
    return Objects.equals(id, that.id)
        && Objects.equals(d, that.d)
        && Objects.equals(c, that.c)
        && Objects.equals(a, that.a)
        && Objects.equals(ds, that.ds)
        && Objects.equals(cs, that.cs)
        && Objects.equals(user, that.user)
        && Objects.equals(symbol, that.symbol)
        && Objects.equals(symbol1, that.symbol1)
        && Objects.equals(symbol2, that.symbol2)
        && Objects.equals(amount, that.amount)
        && Objects.equals(buy, that.buy)
        && Objects.equals(order, that.order)
        && Objects.equals(sell, that.sell)
        && Objects.equals(price, that.price)
        && Objects.equals(type, that.type)
        && Objects.equals(time, that.time)
        && Objects.equals(balance, that.balance)
        && Objects.equals(feeAmount, that.feeAmount)
        && Objects.equals(pair, that.pair)
        && Objects.equals(pos, that.pos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id, d, c, a, ds, cs, user, symbol, symbol1, symbol2, amount, buy, order, sell, price, type,
        time, balance, feeAmount, pair, pos);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CexIOTransaction{");
    sb.append("id='").append(id).append('\'');
    sb.append(", d='").append(d).append('\'');
    sb.append(", c='").append(c).append('\'');
    sb.append(", a=").append(a);
    sb.append(", ds=").append(ds);
    sb.append(", cs=").append(cs);
    sb.append(", user='").append(user).append('\'');
    sb.append(", symbol='").append(symbol).append('\'');
    sb.append(", symbol1='").append(symbol1).append('\'');
    sb.append(", symbol2='").append(symbol2).append('\'');
    sb.append(", amount=").append(amount);
    sb.append(", buy=").append(buy);
    sb.append(", order=").append(order);
    sb.append(", sell=").append(sell);
    sb.append(", price=").append(price);
    sb.append(", type='").append(type).append('\'');
    sb.append(", time=").append(time);
    sb.append(", balance=").append(balance);
    sb.append(", feeAmount=").append(feeAmount);
    sb.append(", pair='").append(pair).append('\'');
    sb.append(", pos='").append(pos).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
