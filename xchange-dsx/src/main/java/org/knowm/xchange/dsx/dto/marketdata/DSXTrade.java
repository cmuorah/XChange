package org.knowm.xchange.dsx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author Mikhail Wall */
public final class DSXTrade {

  private final Double amount;
  private final Double price;
  private final long date;
  private final long tid;
  private final String tradeType;

  public DSXTrade(
      @JsonProperty("amount") Double amount,
      @JsonProperty("price") Double price,
      @JsonProperty("timestamp") long date,
      @JsonProperty("tid") long tid,
      @JsonProperty("type") String tradeType) {

    this.amount = amount;
    this.price = price;
    this.date = date;
    this.tid = tid;
    this.tradeType = tradeType;
  }

  public Double getAmount() {

    return amount;
  }

  public Double getPrice() {

    return price;
  }

  public long getDate() {

    return date;
  }

  public long getTid() {

    return tid;
  }

  public String getTradeType() {

    return tradeType;
  }

  @Override
  public String toString() {

    return "DSXTrade{"
        + "amount="
        + amount
        + ", price="
        + price
        + ", timestamp="
        + date
        + ", tid="
        + tid
        + ", tradeType='"
        + tradeType
        + '\''
        + '}';
  }
}
