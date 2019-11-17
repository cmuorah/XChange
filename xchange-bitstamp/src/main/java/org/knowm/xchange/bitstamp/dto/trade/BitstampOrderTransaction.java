package org.knowm.xchange.bitstamp.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.knowm.xchange.bitstamp.BitstampUtils;

public class BitstampOrderTransaction {

  private final Date datetime;
  private final long tid;
  private final BitstampUserTransaction.TransactionType type;
  private final Double usd;
  private final Double btc;
  private final Double ltc;
  private final Double eth;
  private final Double eur;
  private final Double xrp;
  private final Double bch;
  private final Double price;
  private final Double fee;

  /**
   * Constructor
   *
   * @param datetime date and time of transaction
   * @param tid transaction id
   * @param type transaction type
   * @param usd settled amoun
   * @param btc traded amount
   * @param price transaction rate
   * @param fee transaction fee
   */
  public BitstampOrderTransaction(
      @JsonProperty("datetime") String datetime,
      @JsonProperty("tid") long tid,
      @JsonProperty("type") BitstampUserTransaction.TransactionType type,
      @JsonProperty("usd") Double usd,
      @JsonProperty("btc") Double btc,
      @JsonProperty("ltc") Double ltc,
      @JsonProperty("eth") Double eth,
      @JsonProperty("eur") Double eur,
      @JsonProperty("xrp") Double xrp,
      @JsonProperty("bch") Double bch,
      @JsonProperty("price") Double price,
      @JsonProperty("fee") Double fee) {

    this.datetime = BitstampUtils.parseDate(datetime);
    ;
    this.tid = tid;
    this.type = type;
    this.usd = usd;
    this.btc = btc;
    this.price = price;
    this.fee = fee;
    this.ltc = ltc;
    this.eth = eth;
    this.eur = eur;
    this.xrp = xrp;
    this.bch = bch;
  }

  public Date getDatetime() {

    return datetime;
  }

  public long getTid() {

    return tid;
  }

  public BitstampUserTransaction.TransactionType getType() {

    return type;
  }

  public Double getUsd() {

    return usd;
  }

  public Double getBtc() {

    return btc;
  }

  public Double getPrice() {

    return price;
  }

  public Double getFee() {

    return fee;
  }

  public Double getLtc() {
    return ltc;
  }

  public Double getEth() {
    return eth;
  }

  public Double getEur() {
    return eur;
  }

  public Double getXrp() {
    return xrp;
  }

  public Double getBch() {
    return bch;
  }
}
