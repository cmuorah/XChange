package org.knowm.xchange.btctrade.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BTCTradeOrder {

  private final String id;
  private final String datetime;
  private final String type;
  private final String coin;
  private final Double price;
  private final Double amountOriginal;
  private final Double amountOutstanding;

  private final String status;
  private final BTCTradeTrade[] trades;

  public BTCTradeOrder(
      @JsonProperty("id") String id,
      @JsonProperty("datetime") String datetime,
      @JsonProperty("type") String type,
      @JsonProperty("coin") String coin,
      @JsonProperty("price") Double price,
      @JsonProperty("amount_original") Double amountOriginal,
      @JsonProperty("amount_outstanding") Double amountOutstanding,
      @JsonProperty("status") String status,
      @JsonProperty("trades") BTCTradeTrade[] trades) {

    this.id = id;
    this.datetime = datetime;
    this.type = type;
    this.coin = coin;
    this.price = price;
    this.amountOriginal = amountOriginal;
    this.amountOutstanding = amountOutstanding;

    this.status = status;
    this.trades = trades;
  }

  public String getId() {

    return id;
  }

  public String getDatetime() {

    return datetime;
  }

  public String getType() {

    return type;
  }

  public String getCoin() {

    return coin;
  }

  public Double getPrice() {

    return price;
  }

  public Double getAmountOriginal() {

    return amountOriginal;
  }

  public Double getAmountOutstanding() {

    return amountOutstanding;
  }

  public String getStatus() {

    return status;
  }

  public BTCTradeTrade[] getTrades() {

    return trades;
  }
}
