package org.knowm.xchange.coinmate.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinmateReplaceResponseData {
  private final boolean replacedOrderCancellationFinished;
  private final String replacedOrderCancellationResult;
  private final Double replacedOrderRemainingAmount;
  private final long createdOrderId;

  public CoinmateReplaceResponseData(
      @JsonProperty("replacedOrderCancellationFinished") boolean replacedOrderCancellationFinished,
      @JsonProperty("replacedOrderCancellationResult") String replacedOrderCancellationResult,
      @JsonProperty("replacedOrderRemainingAmount") Double replacedOrderRemainingAmount,
      @JsonProperty("createdOrderId") long createdOrderId) {
    this.replacedOrderCancellationFinished = replacedOrderCancellationFinished;
    this.replacedOrderCancellationResult = replacedOrderCancellationResult;
    this.replacedOrderRemainingAmount = replacedOrderRemainingAmount;
    this.createdOrderId = createdOrderId;
  }

  public boolean isReplacedOrderCancellationFinished() {
    return replacedOrderCancellationFinished;
  }

  public String getReplacedOrderCancellationResult() {
    return replacedOrderCancellationResult;
  }

  public Double getReplacedOrderRemainingAmount() {
    return replacedOrderRemainingAmount;
  }

  public long getCreatedOrderId() {
    return createdOrderId;
  }
}
