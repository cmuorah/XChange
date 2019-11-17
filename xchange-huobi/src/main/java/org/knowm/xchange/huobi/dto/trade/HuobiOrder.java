package org.knowm.xchange.huobi.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class HuobiOrder {

  private final long accountID;
  private final Double amount;
  private final Date canceledAt;
  private final Date createdAt;
  private final Double fieldAmount;
  private final Double fieldCashAmount;
  private final Double fieldFees;
  private final Date finishedAt;
  private final long id;
  private final Double price;
  private final String source;
  private final String state;
  private final String symbol;
  private final String type;

  public HuobiOrder(
      @JsonProperty("account-id") long accountID,
      @JsonProperty("amount") Double amount,
      @JsonProperty("canceled-at") Date canceledAt,
      @JsonProperty("created-at") Date createdAt,
      @JsonProperty("field-amount") Double fieldAmount,
      @JsonProperty("field-cash-amount") Double fieldCashAmount,
      @JsonProperty("field-fees") Double fieldFees,
      @JsonProperty("finished-at") Date finishedAt,
      @JsonProperty("id") long id,
      @JsonProperty("price") Double price,
      @JsonProperty("source") String source,
      @JsonProperty("state") String state,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("type") String type) {
    this.accountID = accountID;
    this.amount = amount;
    this.canceledAt = canceledAt;
    this.createdAt = createdAt;
    this.fieldAmount = fieldAmount;
    this.fieldCashAmount = fieldCashAmount;
    this.fieldFees = fieldFees;
    this.finishedAt = finishedAt;
    this.id = id;
    this.price = price;
    this.source = source;
    this.state = state;
    this.symbol = symbol;
    this.type = type;
  }

  public long getAccountID() {
    return accountID;
  }

  public Double getAmount() {
    return amount;
  }

  public Date getCanceledAt() {
    return canceledAt;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Double getFieldAmount() {
    return fieldAmount;
  }

  public Double getFieldCashAmount() {
    return fieldCashAmount;
  }

  public Double getFieldFees() {
    return fieldFees;
  }

  public Date getFinishedAt() {
    return finishedAt;
  }

  public long getId() {
    return id;
  }

  public Double getPrice() {
    return price;
  }

  public String getSource() {
    return source;
  }

  public String getState() {
    return state;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getType() {
    return type;
  }

  public boolean isLimit() {
    return getType().equals("buy-limit") || getType().equals("sell-limit");
  }

  public boolean isMarket() {
    return getType().equals("buy-market") || getType().equals("sell-market");
  }
}
