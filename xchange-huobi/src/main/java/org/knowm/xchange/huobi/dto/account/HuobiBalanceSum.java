package org.knowm.xchange.huobi.dto.account;

public class HuobiBalanceSum {

  private Double available;
  private Double frozen;

  public Double getAvailable() {
    return available;
  }

  public Double getFrozen() {
    return frozen;
  }

  public Double getTotal() {
    return available + (frozen);
  }

  public void setAvailable(Double available) {
    this.available = available;
  }

  public void setFrozen(Double frozen) {
    this.frozen = frozen;
  }
}
