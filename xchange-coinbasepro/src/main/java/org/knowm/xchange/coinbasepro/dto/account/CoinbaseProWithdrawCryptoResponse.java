package org.knowm.xchange.coinbasepro.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinbaseProWithdrawCryptoResponse {
  public final String id;
  public final Double amount;
  public final String currency;

  public CoinbaseProWithdrawCryptoResponse(
      @JsonProperty("id") String id,
      @JsonProperty("amount") Double amount,
      @JsonProperty("currency") String currency) {
    this.id = id;
    this.amount = amount;
    this.currency = currency;
  }
}
