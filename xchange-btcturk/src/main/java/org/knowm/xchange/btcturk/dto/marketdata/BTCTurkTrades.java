package org.knowm.xchange.btcturk.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 * @author semihunaldi
 * @author mertguner updated 14.01.2019 because tid value was bigger than int
 */
public final class BTCTurkTrades {

  private final Date date;
  private final Double tid;
  private final Double price;
  private final Double amount;

  /**
   * Constructor
   *
   * @param date Unix timestamp date and time
   * @param tid Transaction id
   * @param price BTC price
   * @param amount BTC amount
   */
  public BTCTurkTrades(
      @JsonProperty("date") Date date,
      @JsonProperty("tid") Double tid,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount) {
    this.date = date;
    this.tid = tid;
    this.price = price;
    this.amount = amount;
  }

  public Date getDate() {
    return date;
  }

  public Double getTid() {
    return tid;
  }

  public Double getPrice() {
    return price;
  }

  public Double getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return "BTCTurkTrade [date="
        + date
        + ", tid="
        + tid
        + ", price="
        + price
        + ", amount="
        + amount
        + "]";
  }
}
