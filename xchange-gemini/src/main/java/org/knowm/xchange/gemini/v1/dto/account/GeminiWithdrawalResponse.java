package org.knowm.xchange.gemini.v1.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeminiWithdrawalResponse {

  public final String destination;
  public final Double amount;
  public final String txHash;

  public GeminiWithdrawalResponse(
      @JsonProperty("destination") String destination,
      @JsonProperty("amount") Double amount,
      @JsonProperty("txHash") String txHash) {
    this.destination = destination;
    this.amount = amount;
    this.txHash = txHash;
  }
}
