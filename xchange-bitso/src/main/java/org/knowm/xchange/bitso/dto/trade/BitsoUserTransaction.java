package org.knowm.xchange.bitso.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.knowm.xchange.bitso.util.BitsoTransactionTypeDeserializer;

/** @author Piotr Ładyżyński */
public final class BitsoUserTransaction {

  private final String datetime;
  private final long id;
  private final String order_id;
  private final TransactionType type;
  /** MXN amount, negative -> BID, positive -> ASK */
  private final Double mxn;

  private final Double btc;
  /** price, has the reciprocal sign compared to 'mxn' value */
  private final Double rate;

  private final Double fee;

  /**
   * Constructor
   *
   * @param datetime
   * @param id
   * @param order_id
   * @param type
   * @param mxn
   * @param btc
   * @param rate
   * @param fee
   */
  public BitsoUserTransaction(
      @JsonProperty("datetime") String datetime,
      @JsonProperty("id") long id,
      @JsonProperty("order_id") String order_id,
      @JsonProperty("type") @JsonDeserialize(using = BitsoTransactionTypeDeserializer.class)
          TransactionType type,
      @JsonProperty("mxn") Double mxn,
      @JsonProperty("btc") Double btc,
      @JsonProperty("rate") Double rate,
      @JsonProperty("fee") Double fee) {

    this.datetime = datetime;
    this.id = id;
    this.order_id = order_id;
    this.type = type;
    this.mxn = mxn;
    this.btc = btc;
    this.rate = rate;
    this.fee = fee;
  }

  public String getDatetime() {

    return datetime;
  }

  public long getId() {

    return id;
  }

  public String getOrderId() {

    return order_id;
  }

  public TransactionType getType() {

    return type;
  }

  public boolean isDeposit() {

    return type == TransactionType.deposit;
  }

  public boolean isWithdrawal() {

    return type == TransactionType.withdrawal;
  }

  public boolean isMarketTrade() {

    return type == TransactionType.trade;
  }

  public Double getMxn() {

    return mxn;
  }

  public Double getBtc() {

    return btc;
  }

  public Double getPrice() {

    return rate;
  }

  public Double getFee() {

    return fee;
  }

  @Override
  public String toString() {

    return String.format(
        "UserTransaction{datetime=%s, id=%d, type=%s, mxn=%s, btc=%s, fee=%s}",
        datetime, id, type, mxn, btc, fee);
  }

  public enum TransactionType {
    deposit,
    withdrawal,
    trade,
    type3_reserved,
    type4_reserved,
    type5_reseverd,
    type6_reseved,
    type7_reserved
    // reseved so parsing won 't break in case Bitso adds new types
  }
}
