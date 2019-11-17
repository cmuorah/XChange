package org.knowm.xchange.coingi.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoingiBalance {
  private CoingiCurrency currency;

  private Double available;

  private Double inOrders;

  private Double deposited;

  private Double withdrawing;

  private Double blocked;

  public CoingiBalance(
      @JsonProperty("currency") CoingiCurrency currency,
      @JsonProperty("available") Double available,
      @JsonProperty("inOrders") Double inOrders,
      @JsonProperty("deposited") Double deposited,
      @JsonProperty("withdrawing") Double withdrawing,
      @JsonProperty("blocked") Double blocked) {

    this.currency = currency;
    this.available = available;
    this.inOrders = inOrders;
    this.deposited = deposited;
    this.withdrawing = withdrawing;
    this.blocked = blocked;
  }

  public CoingiCurrency getCurrency() {
    return currency;
  }

  public Double getAvailable() {
    return available;
  }

  public Double getInOrders() {
    return inOrders;
  }

  public Double getDeposited() {
    return deposited;
  }

  public Double getWithdrawing() {
    return withdrawing;
  }

  public Double getBlocked() {
    return blocked;
  }
}
