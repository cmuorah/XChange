package org.knowm.xchange.btcturk.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author mertguner */
public class BTCTurkAccountBalance {

  private final Double try_balance;
  private final Double btc_balance;
  private final Double eth_balance;
  private final Double xrp_balance;
  private final Double ltc_balance;
  private final Double usdt_balance;
  private final Double xlm_balance;
  private final Double try_reserved;
  private final Double btc_reserved;
  private final Double eth_reserved;
  private final Double xrp_reserved;
  private final Double ltc_reserved;
  private final Double usdt_reserved;
  private final Double xlm_reserved;
  private final Double try_available;
  private final Double btc_available;
  private final Double eth_available;
  private final Double xrp_available;
  private final Double ltc_available;
  private final Double usdt_available;
  private final Double xlm_available;
  private final Double btctry_taker_fee_percentage;
  private final Double btctry_maker_fee_percentage;
  private final Double ethtry_taker_fee_percentage;
  private final Double ethtry_maker_fee_percentage;
  private final Double ethbtc_taker_fee_percentage;
  private final Double ethbtc_maker_fee_percentage;
  private final Double xrptry_taker_fee_percentage;
  private final Double xrptry_maker_fee_percentage;
  private final Double ltctry_taker_fee_percentage;
  private final Double ltctry_maker_fee_percentage;
  private final Double usdttry_taker_fee_percentage;
  private final Double usdttry_maker_fee_percentage;
  private final Double xlmtry_taker_fee_percentage;
  private final Double xlmtry_maker_fee_percentage;

  public BTCTurkAccountBalance(
      @JsonProperty("try_balance") Double try_balance,
      @JsonProperty("btc_balance") Double btc_balance,
      @JsonProperty("eth_balance") Double eth_balance,
      @JsonProperty("xrp_balance") Double xrp_balance,
      @JsonProperty("ltc_balance") Double ltc_balance,
      @JsonProperty("usdt_balance") Double usdt_balance,
      @JsonProperty("xlm_balance") Double xlm_balance,
      @JsonProperty("try_reserved") Double try_reserved,
      @JsonProperty("btc_reserved") Double btc_reserved,
      @JsonProperty("eth_reserved") Double eth_reserved,
      @JsonProperty("xrp_reserved") Double xrp_reserved,
      @JsonProperty("ltc_reserved") Double ltc_reserved,
      @JsonProperty("usdt_reserved") Double usdt_reserved,
      @JsonProperty("xlm_reserved") Double xlm_reserved,
      @JsonProperty("try_available") Double try_available,
      @JsonProperty("btc_available") Double btc_available,
      @JsonProperty("eth_available") Double eth_available,
      @JsonProperty("xrp_available") Double xrp_available,
      @JsonProperty("ltc_available") Double ltc_available,
      @JsonProperty("usdt_available") Double usdt_available,
      @JsonProperty("xlm_available") Double xlm_available,
      @JsonProperty("btctry_taker_fee_percentage") Double btctry_taker_fee_percentage,
      @JsonProperty("btctry_maker_fee_percentage") Double btctry_maker_fee_percentage,
      @JsonProperty("ethtry_taker_fee_percentage") Double ethtry_taker_fee_percentage,
      @JsonProperty("ethtry_maker_fee_percentage") Double ethtry_maker_fee_percentage,
      @JsonProperty("ethbtc_taker_fee_percentage") Double ethbtc_taker_fee_percentage,
      @JsonProperty("ethbtc_maker_fee_percentage") Double ethbtc_maker_fee_percentage,
      @JsonProperty("xrptry_taker_fee_percentage") Double xrptry_taker_fee_percentage,
      @JsonProperty("xrptry_maker_fee_percentage") Double xrptry_maker_fee_percentage,
      @JsonProperty("ltctry_taker_fee_percentage") Double ltctry_taker_fee_percentage,
      @JsonProperty("ltctry_maker_fee_percentage") Double ltctry_maker_fee_percentage,
      @JsonProperty("usdttry_taker_fee_percentage") Double usdttry_taker_fee_percentage,
      @JsonProperty("usdttry_maker_fee_percentage") Double usdttry_maker_fee_percentage,
      @JsonProperty("xlmtry_taker_fee_percentage") Double xlmtry_taker_fee_percentage,
      @JsonProperty("xlmtry_maker_fee_percentage") Double xlmtry_maker_fee_percentage) {
    this.try_balance = try_balance;
    this.btc_balance = btc_balance;
    this.eth_balance = eth_balance;
    this.xrp_balance = xrp_balance;
    this.ltc_balance = ltc_balance;
    this.usdt_balance = usdt_balance;
    this.xlm_balance = xlm_balance;
    this.try_reserved = try_reserved;
    this.btc_reserved = btc_reserved;
    this.eth_reserved = eth_reserved;
    this.xrp_reserved = xrp_reserved;
    this.ltc_reserved = ltc_reserved;
    this.usdt_reserved = usdt_reserved;
    this.xlm_reserved = xlm_reserved;
    this.try_available = try_available;
    this.btc_available = btc_available;
    this.eth_available = eth_available;
    this.xrp_available = xrp_available;
    this.ltc_available = ltc_available;
    this.usdt_available = usdt_available;
    this.xlm_available = xlm_available;
    this.btctry_taker_fee_percentage = btctry_taker_fee_percentage;
    this.btctry_maker_fee_percentage = btctry_maker_fee_percentage;
    this.ethtry_taker_fee_percentage = ethtry_taker_fee_percentage;
    this.ethtry_maker_fee_percentage = ethtry_maker_fee_percentage;
    this.ethbtc_taker_fee_percentage = ethbtc_taker_fee_percentage;
    this.ethbtc_maker_fee_percentage = ethbtc_maker_fee_percentage;

    this.xrptry_taker_fee_percentage = xrptry_taker_fee_percentage;
    this.xrptry_maker_fee_percentage = xrptry_maker_fee_percentage;
    this.ltctry_taker_fee_percentage = ltctry_taker_fee_percentage;
    this.ltctry_maker_fee_percentage = ltctry_maker_fee_percentage;
    this.usdttry_taker_fee_percentage = usdttry_taker_fee_percentage;
    this.usdttry_maker_fee_percentage = usdttry_maker_fee_percentage;
    this.xlmtry_taker_fee_percentage = xlmtry_taker_fee_percentage;
    this.xlmtry_maker_fee_percentage = xlmtry_maker_fee_percentage;
  }

  public Double getTry_balance() {
    return try_balance;
  }

  public Double getBtc_balance() {
    return btc_balance;
  }

  public Double getEth_balance() {
    return eth_balance;
  }

  public Double getTry_reserved() {
    return try_reserved;
  }

  public Double getBtc_reserved() {
    return btc_reserved;
  }

  public Double getEth_reserved() {
    return eth_reserved;
  }

  public Double getTry_available() {
    return try_available;
  }

  public Double getBtc_available() {
    return btc_available;
  }

  public Double getEth_available() {
    return eth_available;
  }

  public Double getBtctry_taker_fee_percentage() {
    return btctry_taker_fee_percentage;
  }

  public Double getBtctry_maker_fee_percentage() {
    return btctry_maker_fee_percentage;
  }

  public Double getEthtry_taker_fee_percentage() {
    return ethtry_taker_fee_percentage;
  }

  public Double getEthtry_maker_fee_percentage() {
    return ethtry_maker_fee_percentage;
  }

  public Double getEthbtc_taker_fee_percentage() {
    return ethbtc_taker_fee_percentage;
  }

  public Double getEthbtc_maker_fee_percentage() {
    return ethbtc_maker_fee_percentage;
  }

  public Double getXrp_balance() {
    return xrp_balance;
  }

  public Double getLtc_balance() {
    return ltc_balance;
  }

  public Double getUsdt_balance() {
    return usdt_balance;
  }

  public Double getXlm_balance() {
    return xlm_balance;
  }

  public Double getXrp_reserved() {
    return xrp_reserved;
  }

  public Double getLtc_reserved() {
    return ltc_reserved;
  }

  public Double getUsdt_reserved() {
    return usdt_reserved;
  }

  public Double getXlm_reserved() {
    return xlm_reserved;
  }

  public Double getXrp_available() {
    return xrp_available;
  }

  public Double getLtc_available() {
    return ltc_available;
  }

  public Double getUsdt_available() {
    return usdt_available;
  }

  public Double getXlm_available() {
    return xlm_available;
  }

  public Double getXrptry_taker_fee_percentage() {
    return xrptry_taker_fee_percentage;
  }

  public Double getXrptry_maker_fee_percentage() {
    return xrptry_maker_fee_percentage;
  }

  public Double getLtctry_taker_fee_percentage() {
    return ltctry_taker_fee_percentage;
  }

  public Double getLtctry_maker_fee_percentage() {
    return ltctry_maker_fee_percentage;
  }

  public Double getUsdttry_taker_fee_percentage() {
    return usdttry_taker_fee_percentage;
  }

  public Double getUsdttry_maker_fee_percentage() {
    return usdttry_maker_fee_percentage;
  }

  public Double getXlmtry_taker_fee_percentage() {
    return xlmtry_taker_fee_percentage;
  }

  public Double getXlmtry_maker_fee_percentage() {
    return xlmtry_maker_fee_percentage;
  }

  @Override
  public String toString() {
    return "BTCTurkAccountBalance [try_balance="
        + try_balance
        + ", btc_balance="
        + btc_balance
        + ", eth_balance="
        + eth_balance
        + ", xrp_balance="
        + xrp_balance
        + ", ltc_balance="
        + ltc_balance
        + ", usdt_balance="
        + usdt_balance
        + ", xlm_balance="
        + xlm_balance
        + ", try_reserved="
        + try_reserved
        + ", btc_reserved="
        + btc_reserved
        + ", eth_reserved="
        + eth_reserved
        + ", xrp_reserved="
        + xrp_reserved
        + ", ltc_reserved="
        + ltc_reserved
        + ", usdt_reserved="
        + usdt_reserved
        + ", xlm_reserved="
        + xlm_reserved
        + ", try_available="
        + try_available
        + ", btc_available="
        + btc_available
        + ", eth_available="
        + eth_available
        + ", xrp_available="
        + xrp_available
        + ", ltc_available="
        + ltc_available
        + ", usdt_available="
        + usdt_available
        + ", xlm_available="
        + xlm_available
        + ", btctry_taker_fee_percentage="
        + btctry_taker_fee_percentage
        + ", btctry_maker_fee_percentage="
        + btctry_maker_fee_percentage
        + ", ethtry_taker_fee_percentage="
        + ethtry_taker_fee_percentage
        + ", ethtry_maker_fee_percentage="
        + ethtry_maker_fee_percentage
        + ", ethbtc_taker_fee_percentage="
        + ethbtc_taker_fee_percentage
        + ", ethbtc_maker_fee_percentage="
        + ethbtc_maker_fee_percentage
        + ", xrptry_taker_fee_percentage="
        + xrptry_taker_fee_percentage
        + ", xrptry_maker_fee_percentage="
        + xrptry_maker_fee_percentage
        + ", ltctry_taker_fee_percentage="
        + ltctry_taker_fee_percentage
        + ", ltctry_maker_fee_percentage="
        + ltctry_maker_fee_percentage
        + ", usdttry_taker_fee_percentage="
        + usdttry_taker_fee_percentage
        + ", usdttry_maker_fee_percentage="
        + usdttry_maker_fee_percentage
        + ", xlmtry_taker_fee_percentage="
        + xlmtry_taker_fee_percentage
        + ", xlmtry_maker_fee_percentage="
        + xlmtry_maker_fee_percentage
        + "]";
  }
}
