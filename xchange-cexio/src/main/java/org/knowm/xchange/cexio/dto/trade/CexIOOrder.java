package org.knowm.xchange.cexio.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Author: brox Since: 2/5/14 */
public class CexIOOrder {

  private final long id;
  private final long time;
  private final Type type;
  private final Double price;
  private final Double amount;
  private final Double pending;
  private final String errorMessage;
  private final String symbol1;
  private final String symbol2;

  /**
   * Constructor
   *
   * @param id
   * @param time
   * @param type
   * @param price
   * @param amount
   * @param pending
   * @param symbol1
   * @param symbol2
   */
  public CexIOOrder(
      @JsonProperty("id") long id,
      @JsonProperty("time") long time,
      @JsonProperty("type") Type type,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("pending") Double pending,
      @JsonProperty("symbol1") String symbol1,
      @JsonProperty("symbol2") String symbol2,
      @JsonProperty("error") String errorMessage) {

    this.id = id;
    this.time = time;
    this.type = type;
    this.price = price;
    this.amount = amount;
    this.pending = pending;
    this.symbol1 = symbol1;
    this.symbol2 = symbol2;
    this.errorMessage = errorMessage;
  }

  public long getId() {

    return id;
  }

  public long getTime() {

    return time;
  }

  public Type getType() {

    return type;
  }

  public Double getPrice() {

    return price;
  }

  public Double getAmount() {

    return amount;
  }

  public Double getPending() {

    return pending;
  }

  public String getErrorMessage() {

    return errorMessage;
  }

  public String getSymbol1() {

    return symbol1;
  }

  public String getSymbol2() {

    return symbol2;
  }

  @Override
  public String toString() {

    return errorMessage != null
        ? errorMessage
        : String.format(
            "Order{id=%s, time=%s, type=%s, price=%s, amount=%s, pending=%s, symbol1=%s, symbol2=%s}",
            id, time, type, price, amount, pending, symbol1, symbol2);
  }

  public enum Type {
    buy,
    sell
  }
}
