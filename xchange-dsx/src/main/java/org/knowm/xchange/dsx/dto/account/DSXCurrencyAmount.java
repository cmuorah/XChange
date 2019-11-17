package org.knowm.xchange.dsx.dto.account;

/** @author Mikhail Wall */
public class DSXCurrencyAmount {
  private Double total;
  private Double available;

  public DSXCurrencyAmount(Double total, Double available) {
    this.total = total;
    this.available = available;
  }

  // constructor for correct json parsing
  public DSXCurrencyAmount() {}

  public Double getTotal() {
    return total;
  }

  public Double getAvailable() {
    return available;
  }

  @Override
  public String toString() {
    return "DSXCurrencyAmount{" + "total=" + total + ", available=" + available + '}';
  }
}
