package org.knowm.xchange.poloniex.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author anw */
public class PoloniexLoan {

  private String id;

  private String currency;

  private Double rate;

  private Double amount;

  private int range;

  private boolean autoRenew;

  private String date;

  private Double fees;

  public PoloniexLoan(
      @JsonProperty("id") String id,
      @JsonProperty("currency") String currency,
      @JsonProperty("rate") Double rate,
      @JsonProperty("amount") Double amount,
      @JsonProperty("range") int range,
      @JsonProperty("autoRenew") boolean autoRenew,
      @JsonProperty("date") String date,
      @JsonProperty("fees") Double fees) {
    this.id = id;
    this.currency = currency;
    this.rate = rate;
    this.amount = amount;
    this.range = range;
    this.autoRenew = autoRenew;
    this.date = date;
    this.fees = fees;
  }

  public String getId() {
    return id;
  }

  public String getCurrency() {
    return currency;
  }

  public Double getRate() {
    return rate;
  }

  public Double getAmount() {
    return amount;
  }

  public int getRange() {
    return range;
  }

  public boolean isAutoRenew() {
    return autoRenew;
  }

  public String getDate() {
    return date;
  }

  public Double getFees() {
    return fees;
  }
}
