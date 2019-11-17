package org.knowm.xchange.exx.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class EXXOrder {

  @JsonProperty("fees")
  private Double fees;

  @JsonProperty("total_amount")
  private Double totalAmount;

  @JsonProperty("trade_amount")
  private Double tradeAmount;

  @JsonProperty("price")
  private Double price;

  @JsonProperty("currency")
  private String currency;

  @JsonProperty("id")
  private String id;

  @JsonProperty("trade_money")
  private Double tradeMoney;

  @JsonProperty("type")
  private String type;

  @JsonProperty("trade_date")
  private Long tradeDate;

  @JsonProperty("status")
  private int status;

  /** No args constructor for use in serialization */
  public EXXOrder() {}

  /**
   * @param id
   * @param tradeDate
   * @param tradeMoney
   * @param price
   * @param status
   * @param totalAmount
   * @param fees
   * @param tradeAmount
   * @param type
   * @param currency
   */
  public EXXOrder(
      Double fees,
      Double totalAmount,
      Double tradeAmount,
      Double price,
      String currency,
      String id,
      Double tradeMoney,
      String type,
      Long tradeDate,
      int status) {
    super();
    this.fees = fees;
    this.totalAmount = totalAmount;
    this.tradeAmount = tradeAmount;
    this.price = price;
    this.currency = currency;
    this.id = id;
    this.tradeMoney = tradeMoney;
    this.type = type;
    this.tradeDate = tradeDate;
    this.status = status;
  }

  @JsonProperty("fees")
  public Double getFees() {
    return fees;
  }

  @JsonProperty("fees")
  public void setFees(Double fees) {
    this.fees = fees;
  }

  @JsonProperty("total_amount")
  public Double getTotalAmount() {
    return totalAmount;
  }

  @JsonProperty("total_amount")
  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  @JsonProperty("trade_amount")
  public Double getTradeAmount() {
    return tradeAmount;
  }

  @JsonProperty("trade_amount")
  public void setTradeAmount(Double tradeAmount) {
    this.tradeAmount = tradeAmount;
  }

  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  @JsonProperty("price")
  public void setPrice(Double price) {
    this.price = price;
  }

  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }

  @JsonProperty("currency")
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("trade_money")
  public Double getTradeMoney() {
    return tradeMoney;
  }

  @JsonProperty("trade_money")
  public void setTradeMoney(Double tradeMoney) {
    this.tradeMoney = tradeMoney;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("trade_date")
  public Long getTradeDate() {
    return tradeDate;
  }

  @JsonProperty("trade_date")
  public void setTradeDate(Long tradeDate) {
    this.tradeDate = tradeDate;
  }

  @JsonProperty("status")
  public int getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("fees", fees)
        .append("totalAmount", totalAmount)
        .append("tradeAmount", tradeAmount)
        .append("price", price)
        .append("currency", currency)
        .append("id", id)
        .append("tradeMoney", tradeMoney)
        .append("type", type)
        .append("tradeDate", tradeDate)
        .append("status", status)
        .toString();
  }
}
