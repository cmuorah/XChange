package org.knowm.xchange.bitso.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author Piotr Ładyżyński */
public class BitsoTransaction {

  private final long date;
  private final int tid;
  private final Double price;
  private final Double amount;
  private final String side;

  /**
   * Constructor
   *
   * @param date Unix timestamp date and time
   * @param tid Transaction id
   * @param price BTC price
   * @param amount BTC amount
   * @param side "buy"/"sell" for the type of order the trade has completed
   */
  public BitsoTransaction(
      @JsonProperty("date") long date,
      @JsonProperty("tid") int tid,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("side") String side) {

    this.date = date;
    this.tid = tid;
    this.price = price;
    this.amount = amount;
    this.side = side;
  }

  public int getTid() {

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

  public String getSide() {

    return side;
  }

  public Double calculateFeeBtc() {

    return roundUp(amount * (new Double(.5))) * (new Double(100.));
  }

  private Double roundUp(Double x) {

    long n = x.longValue();
    return new Double(x.equals(new Double(n)) ? n : n + 1);
  }

  public Double calculateFeeMxn() {

    return calculateFeeBtc() * (price);
  }

  @Override
  public String toString() {

    return "Transaction [date="
        + date
        + ", tid="
        + tid
        + ", price="
        + price
        + ", amount="
        + amount
        + ", side="
        + side
        + "]";
  }
}
