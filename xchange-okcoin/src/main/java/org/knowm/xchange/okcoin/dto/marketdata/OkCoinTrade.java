package org.knowm.xchange.okcoin.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class OkCoinTrade {

  private final Date date;
  private final Double price;
  private final Double amount;
  private final long tid;
  private final String type;

  /**
   * Constructor
   *
   * @param date
   * @param price
   * @param amount
   * @param tid
   * @param type
   */
  public OkCoinTrade(
      @JsonProperty("date") final long date,
      @JsonProperty("price") final Double price,
      @JsonProperty("amount") final Double amount,
      @JsonProperty("tid") final long tid,
      @JsonProperty("type") final String type) {

    this.date = new Date(date * 1000);
    this.price = price;
    this.amount = amount;
    this.tid = tid;
    this.type = type;
  }

  public Date getDate() {

    return date;
  }

  public Double getPrice() {

    return price;
  }

  public Double getAmount() {

    return amount;
  }

  public long getTid() {

    return tid;
  }

  public String getType() {

    return type;
  }

  @Override
  public String toString() {

    return "OkCoinTrade [date="
        + date
        + ", price="
        + price
        + ", amount="
        + amount
        + ", tid="
        + tid
        + ", type="
        + type
        + "]";
  }
}
