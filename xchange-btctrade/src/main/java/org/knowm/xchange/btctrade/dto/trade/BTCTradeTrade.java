package org.knowm.xchange.btctrade.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BTCTradeTrade {

  private final String tradeId;
  private final Double amount;
  private final Double price;
  private final String datetime;
  private final Double fee;

  public BTCTradeTrade(
      @JsonProperty("trade_id") String tradeId,
      @JsonProperty("amount") Double amount,
      @JsonProperty("price") Double price,
      @JsonProperty("datetime") String datetime,
      @JsonProperty("fee") Double fee) {

    this.tradeId = tradeId;
    this.amount = amount;
    this.price = price;
    this.datetime = datetime;
    this.fee = fee;
  }

  public String getTradeId() {

    return tradeId;
  }

  public Double getAmount() {

    return amount;
  }

  public Double getPrice() {

    return price;
  }

  public String getDatetime() {

    return datetime;
  }

  public Double getFee() {

    return fee;
  }
}
