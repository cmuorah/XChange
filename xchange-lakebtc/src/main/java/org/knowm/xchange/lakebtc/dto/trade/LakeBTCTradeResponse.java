package org.knowm.xchange.lakebtc.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Created by cristian.lucaci on 12/19/2014. */
public class LakeBTCTradeResponse {

  private final String type;
  private final String currency;
  private final Double amount;
  private final Double total;
  private final long at;
  private final String id;

  public LakeBTCTradeResponse(
      @JsonProperty("type") String type,
      @JsonProperty("currency") String currency,
      @JsonProperty("amount") Double amount,
      @JsonProperty("total") Double total,
      @JsonProperty("at") long at) {
    this.type = type;
    this.currency = currency;
    this.amount = amount;
    this.total = total;
    this.at = at;
    this.id = total.toString() + "_" + at;
  }

  public String getType() {
    return type;
  }

  public String getCurrency() {
    return currency;
  }

  public Double getAmount() {
    return amount;
  }

  public Double getTotal() {
    return total;
  }

  public long getAt() {
    return at;
  }

  public String getId() {
    return id;
  }
}
