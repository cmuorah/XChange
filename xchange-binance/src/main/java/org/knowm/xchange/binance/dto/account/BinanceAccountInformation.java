package org.knowm.xchange.binance.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public final class BinanceAccountInformation {

  public final Double makerCommission;
  public final Double takerCommission;
  public final Double buyerCommission;
  public final Double sellerCommission;
  public final boolean canTrade;
  public final boolean canWithdraw;
  public final boolean canDeposit;
  public final long updateTime;
  public List<BinanceBalance> balances;

  public BinanceAccountInformation(
      @JsonProperty("makerCommission") Double makerCommission,
      @JsonProperty("takerCommission") Double takerCommission,
      @JsonProperty("buyerCommission") Double buyerCommission,
      @JsonProperty("sellerCommission") Double sellerCommission,
      @JsonProperty("canTrade") boolean canTrade,
      @JsonProperty("canWithdraw") boolean canWithdraw,
      @JsonProperty("canDeposit") boolean canDeposit,
      @JsonProperty("updateTime") long updateTime,
      @JsonProperty("balances") List<BinanceBalance> balances) {
    this.makerCommission = makerCommission;
    this.takerCommission = takerCommission;
    this.buyerCommission = buyerCommission;
    this.sellerCommission = sellerCommission;
    this.canTrade = canTrade;
    this.canWithdraw = canWithdraw;
    this.canDeposit = canDeposit;
    this.updateTime = updateTime;
    this.balances = balances;
  }
}
