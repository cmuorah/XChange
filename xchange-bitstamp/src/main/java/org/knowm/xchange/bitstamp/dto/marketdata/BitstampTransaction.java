package org.knowm.xchange.bitstamp.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author Matija Mazi */
public class BitstampTransaction {

  private final long date;
  private final long tid;
  private final Double price;
  private final Double amount;
  private final int type;

  /**
   * Constructor
   *
   * @param date Unix timestamp date and time
   * @param tid Transaction id
   * @param price BTC price
   * @param amount BTC amount
   */
  public BitstampTransaction(
      @JsonProperty("date") long date,
      @JsonProperty("tid") long tid,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("type") int type) {

    this.date = date;
    this.tid = tid;
    this.price = price;
    this.amount = amount;
    this.type = type;
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

  public int getType() {

    return type;
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
    builder.append(", type=");
    builder.append(type);
    builder.append("]");
    return builder.toString();
  }
}
