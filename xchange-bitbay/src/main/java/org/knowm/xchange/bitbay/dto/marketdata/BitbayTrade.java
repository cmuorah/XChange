package org.knowm.xchange.bitbay.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author kpysniak */
public class BitbayTrade {

  private final long date;
  private final Double price;
  private final Double amount;
  private final String tid;

  /**
   * Constructor
   *
   * @param date
   * @param price
   * @param amount
   * @param tid
   */
  public BitbayTrade(
      @JsonProperty("date") long date,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("tid") String tid) {

    this.date = date;
    this.price = price;
    this.amount = amount;
    this.tid = tid;
  }

  public long getDate() {

    return date;
  }

  public Double getPrice() {

    return price;
  }

  public Double getAmount() {

    return amount;
  }

  public String getTid() {

    return tid;
  }

  @Override
  public String toString() {

    return "BitbayTrade{"
        + "date="
        + date
        + ", price="
        + price
        + ", amount="
        + amount
        + ", tid='"
        + tid
        + '\''
        + '}';
  }
}
