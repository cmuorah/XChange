package org.knowm.xchange.bitso.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author Matija Mazi */
public final class BitsoBalance {

  private final Double mxnBalance;

  private final Double btcBalance;

  private final Double mxnReserved;

  private final Double btcReserved;

  private final Double mxnAvailable;

  private final Double btcAvailable;

  private final Double fee;

  private final String error;

  public BitsoBalance(
      @JsonProperty("mxn_balance") Double mxnBalance,
      @JsonProperty("btc_balance") Double btcBalance,
      @JsonProperty("mxn_reserved") Double mxnReserved,
      @JsonProperty("btc_reserved") Double btcReserved,
      @JsonProperty("mxn_available") Double mxnAvailable,
      @JsonProperty("btc_available") Double btcAvailable,
      @JsonProperty("fee") Double fee,
      @JsonProperty("error") String error) {

    this.mxnBalance = mxnBalance;
    this.btcBalance = btcBalance;
    this.mxnReserved = mxnReserved;
    this.btcReserved = btcReserved;
    this.mxnAvailable = mxnAvailable;
    this.btcAvailable = btcAvailable;
    this.fee = fee;
    this.error = error;
  }

  public Double getMxnBalance() {

    return mxnBalance;
  }

  public Double getBtcBalance() {

    return btcBalance;
  }

  public Double getMxnReserved() {

    return mxnReserved;
  }

  public Double getBtcReserved() {

    return btcReserved;
  }

  public Double getMxnAvailable() {

    return mxnAvailable;
  }

  public Double getBtcAvailable() {

    return btcAvailable;
  }

  public Double getFee() {

    return fee;
  }

  public String getError() {

    return error;
  }

  @Override
  public String toString() {

    return String.format(
        "Balance{mxnBalance=%s, btcBalance=%s, mxnReserved=%s, btcReserved=%s, mxnAvailable=%s, btcAvailable=%s, fee=%s}",
        mxnBalance, btcBalance, mxnReserved, btcReserved, mxnAvailable, btcAvailable, fee);
  }
}
