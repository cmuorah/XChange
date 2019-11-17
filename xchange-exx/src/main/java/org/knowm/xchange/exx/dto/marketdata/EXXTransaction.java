package org.knowm.xchange.exx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class EXXTransaction {

  @JsonProperty("date")
  private long date;

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("price")
  private Double price;

  @JsonProperty("trade_type")
  private String tradeType;

  @JsonProperty("type")
  private String type;

  @JsonProperty("tid")
  private long tid;

  /** No args constructor for use in serialization */
  public EXXTransaction() {}

  /**
   * @param amount
   * @param tradeType
   * @param price
   * @param tid
   * @param type
   * @param date
   */
  public EXXTransaction(
      long date, Double amount, Double price, String tradeType, String type, long tid) {
    super();
    this.date = date;
    this.amount = amount;
    this.price = price;
    this.tradeType = tradeType;
    this.type = type;
    this.tid = tid;
  }

  @JsonProperty("date")
  public long getDate() {
    return date;
  }

  @JsonProperty("date")
  public void setDate(long date) {
    this.date = date;
  }

  @JsonProperty("amount")
  public Double getAmount() {
    return amount;
  }

  @JsonProperty("amount")
  public void setAmount(Double amount) {
    this.amount = amount;
  }

  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  @JsonProperty("price")
  public void setPrice(Double price) {
    this.price = price;
  }

  @JsonProperty("trade_type")
  public String getTradeType() {
    return tradeType;
  }

  @JsonProperty("trade_type")
  public void setTradeType(String tradeType) {
    this.tradeType = tradeType;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("tid")
  public long getTid() {
    return tid;
  }

  @JsonProperty("tid")
  public void setTid(long tid) {
    this.tid = tid;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("date", date)
        .append("amount", amount)
        .append("price", price)
        .append("tradeType", tradeType)
        .append("type", type)
        .append("tid", tid)
        .toString();
  }
}
