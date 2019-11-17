package org.knowm.xchange.btcturk.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.knowm.xchange.btcturk.dto.BTCTurkOperations;
import org.knowm.xchange.currency.Currency;

/** @author mertguner */
public class BTCTurkUserTransactions {

  private final String id;

  private final Date date;

  private final BTCTurkOperations operation;
  private final Currency currency;
  private final Double funds;
  private final Double amount;
  private final Double fee;
  private final Double tax;
  private final Double price;

  public BTCTurkUserTransactions(
      @JsonProperty("id") String id,
      @JsonProperty("date") Date date,
      @JsonProperty("operation") BTCTurkOperations operation,
      @JsonProperty("currency") Currency currency,
      @JsonProperty("funds") Double funds,
      @JsonProperty("amount") Double amount,
      @JsonProperty("fee") Double fee,
      @JsonProperty("tax") Double tax,
      @JsonProperty("price") Double price) {
    this.id = id;
    this.date = date;
    this.operation = operation;
    this.currency = currency;
    this.funds = funds;
    this.amount = amount;
    this.fee = fee;
    this.tax = tax;
    this.price = price;
  }

  public String getId() {
    return id;
  }

  public Date getDate() {
    return date;
  }

  public BTCTurkOperations getOperation() {
    return operation;
  }

  public Currency getCurrency() {
    return currency;
  }

  public Double getFunds() {
    return funds;
  }

  public Double getAmount() {
    return amount;
  }

  public Double getFee() {
    return fee;
  }

  public Double getTax() {
    return tax;
  }

  public Double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "BTCTurkUserTransactions [id="
        + id
        + ", date="
        + date
        + ", operation="
        + operation
        + ", currency="
        + currency
        + ", funds="
        + funds
        + ", amount="
        + amount
        + ", fee="
        + fee
        + ", tax="
        + tax
        + ", price="
        + price
        + "]";
  }
}
