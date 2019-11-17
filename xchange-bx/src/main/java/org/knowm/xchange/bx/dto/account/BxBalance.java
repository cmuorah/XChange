package org.knowm.xchange.bx.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BxBalance {

  private final Double total;
  private final Double available;
  private final Double orders;
  private final Double withdrawals;
  private final Double deposits;
  private final Double options;

  public BxBalance(
      @JsonProperty("total") Double total,
      @JsonProperty("available") Double available,
      @JsonProperty("orders") Double orders,
      @JsonProperty("withdrawals") Double withdrawals,
      @JsonProperty("deposits") Double deposits,
      @JsonProperty("options") Double options) {
    this.total = total;
    this.available = available;
    this.orders = orders;
    this.withdrawals = withdrawals;
    this.deposits = deposits;
    this.options = options;
  }

  public Double getTotal() {
    return total;
  }

  public Double getAvailable() {
    return available;
  }

  public Double getOrders() {
    return orders;
  }

  public Double getWithdrawals() {
    return withdrawals;
  }

  public Double getDeposits() {
    return deposits;
  }

  public Double getOptions() {
    return options;
  }

  @Override
  public String toString() {
    return "BxBalance{"
        + "total="
        + total
        + ", available="
        + available
        + ", orders="
        + orders
        + ", withdrawals="
        + withdrawals
        + ", deposits="
        + deposits
        + ", options="
        + options
        + '}';
  }
}
