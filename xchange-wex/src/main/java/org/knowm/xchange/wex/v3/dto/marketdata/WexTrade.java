package org.knowm.xchange.wex.v3.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Author: okhomenko Data object representing single Trade from Wex API v.3 */
public class WexTrade {

  private final Double amount;
  private final long date;
  private final Double price;
  private final long tid;
  private String tradeType;

  /**
   * Constructor
   *
   * @param tradeType
   * @param price
   * @param amount
   * @param tid
   * @param date
   */
  public WexTrade(
      @JsonProperty("type") String tradeType,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("tid") long tid,
      @JsonProperty("timestamp") long date) {

    this.tradeType = tradeType;
    this.price = price;
    this.amount = amount;
    this.tid = tid;
    this.date = date;
  }

  public Double getAmount() {

    return amount;
  }

  public long getDate() {

    return date;
  }

  public Double getPrice() {

    return price;
  }

  public long getTid() {

    return tid;
  }

  public String getTradeType() {

    return tradeType;
  }

  @Override
  public String toString() {

    return "WexTrade [amount="
        + amount
        + ", timestamp="
        + date
        + ", price="
        + price
        + ", tid="
        + tid
        + ", type="
        + tradeType
        + "]";
  }
}
