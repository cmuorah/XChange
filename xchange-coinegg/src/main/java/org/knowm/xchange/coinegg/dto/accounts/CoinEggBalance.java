package org.knowm.xchange.coinegg.dto.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinEggBalance {

  private final int id;
  private final int xasLock;
  private final int ethLock;
  private final int btcLock;

  private final Double xasBalance;
  private final Double ethBalance;
  private final Double btcBalance;

  public CoinEggBalance(
      @JsonProperty("uid") int id,
      @JsonProperty("xas_balance") Double xasBalance,
      @JsonProperty("xas_lock") int xasLock,
      @JsonProperty("eth_balance") Double ethBalance,
      @JsonProperty("eth_lock") int ethLock,
      @JsonProperty("btc_balance") Double btcBalance,
      @JsonProperty("btc_lock") int btcLock) {

    this.id = id;
    this.xasLock = xasLock;
    this.ethLock = ethLock;
    this.btcLock = btcLock;
    this.xasBalance = xasBalance;
    this.ethBalance = ethBalance;
    this.btcBalance = btcBalance;
  }

  public int getID() {
    return id;
  }

  public boolean isXASLocked() {
    return xasLock == 1;
  }

  public boolean isETHLocked() {
    return ethLock == 1;
  }

  public boolean isBTCLocked() {
    return btcLock == 1;
  }

  public Double getXASBalance() {
    return xasBalance;
  }

  public Double getETHBalance() {
    return ethBalance;
  }

  public Double getBTCBalance() {
    return btcBalance;
  }
}
