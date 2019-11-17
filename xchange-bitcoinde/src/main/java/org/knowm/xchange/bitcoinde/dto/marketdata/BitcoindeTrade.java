package org.knowm.xchange.bitcoinde.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author matthewdowney */
public class BitcoindeTrade {

  private final long date;
  private final Double price;
  private final Double amount;
  private final int tid;

  /**
   * Constructor
   *
   * @param tid
   * @param price
   * @param amount
   * @param date
   */
  public BitcoindeTrade(
      @JsonProperty("tid") int tid,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("date") long date) {

    this.tid = tid;
    this.price = price;
    this.amount = amount;
    this.date = date;
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

  @Override
  public String toString() {

    return "BitcoindeTrade{"
        + "date="
        + date
        + ", price="
        + price
        + ", amount='"
        + amount
        + "', tid="
        + tid
        + '}';
  }
}
