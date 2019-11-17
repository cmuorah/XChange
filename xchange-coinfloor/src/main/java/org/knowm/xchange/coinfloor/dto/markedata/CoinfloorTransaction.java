package org.knowm.xchange.coinfloor.dto.markedata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinfloorTransaction {
  private final long date;
  private final long tid;
  private final Double price;
  private final Double amount;

  /**
   * @param date Seconds since epoch
   * @param tid Transaction id
   * @param price price
   * @param amount amount
   */
  public CoinfloorTransaction(
      @JsonProperty("date") long date,
      @JsonProperty("tid") long tid,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount) {

    this.date = date;
    this.tid = tid;
    this.price = price;
    this.amount = amount;
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

  /**
   * Trade timestamp as seconds since the epoch.
   *
   * @return trade timestamp
   */
  public long getDate() {
    return date;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("BitstampTransaction [date=");
    builder.append(date);
    builder.append(", tid=");
    builder.append(tid);
    builder.append(", price=");
    builder.append(price);
    builder.append(", amount=");
    builder.append(amount);
    builder.append("]");
    return builder.toString();
  }
}
