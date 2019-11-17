package org.knowm.xchange.btctrade.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.btctrade.dto.BTCTradeResult;

public class BTCTradeBalance extends BTCTradeResult {

  private final Long uid;
  private final Integer nameauth;
  private final String moflag;
  private final Double btcBalance;
  private final Double btcReserved;
  private final Double ltcBalance;
  private final Double ltcReserved;
  private final Double dogeBalance;
  private final Double dogeReserved;
  private final Double ybcBalance;
  private final Double ybcReserved;
  private final Double cnyBalance;
  private final Double cnyReserved;

  public BTCTradeBalance(
      @JsonProperty("result") Boolean result,
      @JsonProperty("message") String message,
      @JsonProperty("uid") Long uid,
      @JsonProperty("nameauth") Integer nameauth,
      @JsonProperty("moflag") String moflag,
      @JsonProperty("btc_balance") Double btcBalance,
      @JsonProperty("btc_reserved") Double btcReserved,
      @JsonProperty("ltc_balance") Double ltcBalance,
      @JsonProperty("ltc_reserved") Double ltcReserved,
      @JsonProperty("doge_balance") Double dogeBalance,
      @JsonProperty("doge_reserved") Double dogeReserved,
      @JsonProperty("ybc_balance") Double ybcBalance,
      @JsonProperty("ybc_reserved") Double ybcReserved,
      @JsonProperty("cny_balance") Double cnyBalance,
      @JsonProperty("cny_reserved") Double cnyReserved) {

    super(result, message);
    this.uid = uid;
    this.nameauth = nameauth;
    this.moflag = moflag;
    this.btcBalance = btcBalance;
    this.btcReserved = btcReserved;
    this.ltcBalance = ltcBalance;
    this.ltcReserved = ltcReserved;
    this.dogeBalance = dogeBalance;
    this.dogeReserved = dogeReserved;
    this.ybcBalance = ybcBalance;
    this.ybcReserved = ybcReserved;
    this.cnyBalance = cnyBalance;
    this.cnyReserved = cnyReserved;
  }

  public Long getUid() {

    return uid;
  }

  public Integer getNameauth() {

    return nameauth;
  }

  public String getMoflag() {

    return moflag;
  }

  public Double getBtcBalance() {

    return btcBalance;
  }

  public Double getBtcReserved() {

    return btcReserved;
  }

  public Double getLtcBalance() {

    return ltcBalance;
  }

  public Double getLtcReserved() {

    return ltcReserved;
  }

  public Double getDogeBalance() {

    return dogeBalance;
  }

  public Double getDogeReserved() {

    return dogeReserved;
  }

  public Double getYbcBalance() {

    return ybcBalance;
  }

  public Double getYbcReserved() {

    return ybcReserved;
  }

  public Double getCnyBalance() {

    return cnyBalance;
  }

  public Double getCnyReserved() {

    return cnyReserved;
  }
}
