package org.knowm.xchange.btcmarkets.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.btcmarkets.dto.BTCMarketsBaseResponse;

public class BTCMarketsWithdrawCryptoResponse extends BTCMarketsBaseResponse {
  public final String status;
  public final String fundTransferId;
  public final String description;
  public final String currency;
  public final Double amount;
  public final Double fee;
  public final Long creationTime;

  public BTCMarketsWithdrawCryptoResponse(
      @JsonProperty("success") Boolean success,
      @JsonProperty("errorMessage") String errorMessage,
      @JsonProperty("errorCode") Integer errorCode,
      @JsonProperty("status") String status,
      @JsonProperty("fundTransferId") String fundTransferId,
      @JsonProperty("description") String description,
      @JsonProperty("currency") String currency,
      @JsonProperty("amount") Double amount,
      @JsonProperty("fee") Double fee,
      @JsonProperty("creationTime") Long creationTime) {
    super(success, errorMessage, errorCode);
    this.status = status;
    this.fundTransferId = fundTransferId;
    this.description = description;
    this.currency = currency;
    this.amount = amount;
    this.fee = fee;
    this.creationTime = creationTime;
  }
}
