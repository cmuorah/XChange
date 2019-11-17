package org.knowm.xchange.mercadobitcoin.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author Felipe Micaroni Lalli */
public class MercadoBitcoinAccountInfo {

  private final Funds funds;
  private final Long serverTime;
  private final Long openOrders;

  public MercadoBitcoinAccountInfo(
      @JsonProperty("funds") MercadoBitcoinAccountInfo.Funds funds,
      @JsonProperty("server_time") Long serverTime,
      @JsonProperty("open_orders") Long openOrders) {

    this.funds = funds;
    this.serverTime = serverTime;
    this.openOrders = openOrders;
  }

  @Override
  public String toString() {

    return "MercadoBitcoinAccountInfo ["
        + "funds="
        + funds
        + ", serverTime="
        + serverTime
        + ", openOrders="
        + openOrders
        + ']';
  }

  public Long getOpenOrders() {

    return openOrders;
  }

  public Long getServerTime() {

    return serverTime;
  }

  public Funds getFunds() {

    return funds;
  }

  public static class Funds {

    private final Double ltc;
    private final Double brl;
    private final Double btc;

    public Funds(
        @JsonProperty("ltc") Double ltc,
        @JsonProperty("brl") Double brl,
        @JsonProperty("btc") Double btc) {

      this.ltc = ltc;
      this.brl = brl;
      this.btc = btc;
    }

    public Double getLtc() {

      return ltc;
    }

    public Double getBrl() {

      return brl;
    }

    public Double getBtc() {

      return btc;
    }

    @Override
    public String toString() {

      return "Funds [" + "ltc=" + ltc + ", brl=" + brl + ", btc=" + btc + ']';
    }
  }
}
