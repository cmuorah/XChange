package org.knowm.xchange.btctrade.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BTCTradeTrade {

  private final long date;
  private final Double price;
  private final Double amount;
  private final long tid;
  private final String type;

  public BTCTradeTrade(
      @JsonProperty("date") long date,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("tid") long tid,
      @JsonProperty("type") String type) {

    this.date = date;
    this.price = price;
    this.amount = amount;
    this.tid = tid;
    this.type = type;
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

  public long getTid() {

    return tid;
  }

  public String getType() {

    return type;
  }
}
