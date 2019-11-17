package org.knowm.xchange.coinegg.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.coinegg.dto.marketdata.CoinEggTrade.Type;

public class CoinEggTradeView extends CoinEggTradeList {

  private final String status;

  public CoinEggTradeView(
      @JsonProperty("id") int id,
      @JsonProperty("datetime") String datetime,
      @JsonProperty("type") Type type,
      @JsonProperty("price") Double price,
      @JsonProperty("amount_original") Double amountOriginal,
      @JsonProperty("amount_outstanding") Double amountOutstanding,
      @JsonProperty("status") String status) {

    super(id, datetime, type, price, amountOriginal, amountOutstanding);
    this.status = status;
  }

  public boolean isOpen() {
    return status.toUpperCase().equals("OPEN");
  }
}
