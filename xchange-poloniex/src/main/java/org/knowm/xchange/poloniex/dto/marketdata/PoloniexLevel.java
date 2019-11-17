package org.knowm.xchange.poloniex.dto.marketdata;

/** @author Zach Holmes */
public class PoloniexLevel {

  private Double amount;
  private Double limit;

  public PoloniexLevel(Double amount, Double limit) {

    super();
    this.amount = amount;
    this.limit = limit;
  }

  public Double getAmount() {

    return amount;
  }

  public Double getLimit() {

    return limit;
  }

  @Override
  public String toString() {

    return "PoloniexLevel [amount=" + amount + ", limit=" + limit + "]";
  }
}
