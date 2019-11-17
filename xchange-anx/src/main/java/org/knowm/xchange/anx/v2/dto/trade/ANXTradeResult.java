package org.knowm.xchange.anx.v2.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/** Data object representing trades from ANX */
public final class ANXTradeResult {

  private final String tradeId;
  private final String orderId;
  private final Date timestamp;
  private final Double tradedCurrencyFillAmount;
  private final Double settlementCurrencyFillAmount;
  private final String currencyPair;
  private final String side;

  public ANXTradeResult(
      @JsonProperty("tradeId") String tradeId,
      @JsonProperty("orderId") String orderId,
      @JsonProperty("timestamp") Date timestamp,
      @JsonProperty("tradedCurrencyFillAmount") Double tradedCurrencyFillAmount,
      @JsonProperty("settlementCurrencyFillAmount") Double settlementCurrencyFillAmount,
      @JsonProperty("ccyPair") String currencyPair,
      @JsonProperty("side") String side) {

    this.tradeId = tradeId;
    this.orderId = orderId;
    this.timestamp = timestamp;
    this.tradedCurrencyFillAmount = tradedCurrencyFillAmount;
    this.settlementCurrencyFillAmount = settlementCurrencyFillAmount;
    this.currencyPair = currencyPair;
    this.side = side;
  }

  public String getTradeId() {

    return tradeId;
  }

  public String getOrderId() {

    return orderId;
  }

  public Date getTimestamp() {

    return timestamp;
  }

  public Double getTradedCurrencyFillAmount() {

    return tradedCurrencyFillAmount;
  }

  public Double getSettlementCurrencyFillAmount() {

    return settlementCurrencyFillAmount;
  }

  public String getCurrencyPair() {

    return currencyPair;
  }

  public String getSide() {

    return side;
  }

  @Override
  public String toString() {

    return "ANXOrderResultTrade{"
        + "tradeId='"
        + tradeId
        + '\''
        + ", orderId='"
        + orderId
        + '\''
        + ", timestamp="
        + timestamp
        + ", tradedCurrencyFillAmount="
        + tradedCurrencyFillAmount
        + ", settlementCurrencyFillAmount="
        + settlementCurrencyFillAmount
        + ", currencyPair='"
        + currencyPair
        + '\''
        + ", side='"
        + side
        + '\''
        + '}';
  }
}
