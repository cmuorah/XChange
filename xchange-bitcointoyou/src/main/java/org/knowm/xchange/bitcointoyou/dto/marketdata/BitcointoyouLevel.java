package org.knowm.xchange.bitcointoyou.dto.marketdata;

/**
 * @author Jonathas Carrijo
 * @author Danilo Guimaraes
 */
public class BitcointoyouLevel {

  private final Double amount;
  private final Double limit;

  public BitcointoyouLevel(Double price, Double quantity) {

    super();
    this.amount = quantity;
    this.limit = price;
  }

  public Double getAmount() {

    return amount;
  }

  public Double getLimit() {

    return limit;
  }

  @Override
  public String toString() {

    return "BitcointoyouLevel [amount=" + amount + ", limit=" + limit + "]";
  }
}
