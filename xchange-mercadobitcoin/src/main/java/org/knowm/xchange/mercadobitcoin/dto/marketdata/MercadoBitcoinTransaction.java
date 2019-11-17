package org.knowm.xchange.mercadobitcoin.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Matija Mazi
 * @author Felipe Micaroni Lalli
 */
public class MercadoBitcoinTransaction {

  private final long date;
  private final long tid;
  private final Double price;
  private final Double amount;
  private final String type;

  /**
   * Constructor
   *
   * @param date Unix timestamp date and time
   * @param tid Transaction id
   * @param price BTC price in BRL
   * @param amount BTC amount
   * @param type buy or sell
   */
  public MercadoBitcoinTransaction(
      @JsonProperty("date") long date,
      @JsonProperty("tid") long tid,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("type") String type) {

    this.date = date;
    this.tid = tid;
    this.price = price;
    this.amount = amount;
    this.type = type;
  }

  @Override
  public String toString() {

    return "MercadoBitcoinTransaction ["
        + "date="
        + date
        + ", tid="
        + tid
        + ", price="
        + price
        + ", amount="
        + amount
        + ", type='"
        + type
        + '\''
        + ']';
  }

  public long getTid() {

    return tid;
  }

  public Double getPrice() {

    return price;
  }

  public Double getAmount() {

    return amount;
  }

  public long getDate() {

    return date;
  }

  public Double calculateFeeBtc() {

    return roundUp(amount * (.5)) / (100.0);
  }

  private Double roundUp(Double x) {

    long n = x.longValue();
    return (double) (x.equals((double) n) ? n : n + 1);
  }

  public Double calculateFeeUsd() {

    return calculateFeeBtc() * (price);
  }

  public String getType() {

    return type;
  }
}
