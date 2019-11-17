package org.knowm.xchange.dsx.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.MessageFormat;

/** @author Mikhail Wall */
public class DSXTradeHistoryResult {

  private final String pair;
  private final Type type;
  private final Double amount;
  private final Double rate;
  private final Long orderId;
  private final Long timestamp;
  private Double commission;
  private String commissionCurrency;

  public DSXTradeHistoryResult(
      @JsonProperty("pair") String pair,
      @JsonProperty("type") Type type,
      @JsonProperty("volume") Double amount,
      @JsonProperty("rate") Double rate,
      @JsonProperty("orderId") Long orderId,
      @JsonProperty("timestamp") Long timestamp,
      @JsonProperty("commission") Double commission,
      @JsonProperty("commissionCurrency") String commissionCurrency) {

    this.pair = pair;
    this.type = type;
    this.amount = amount;
    this.rate = rate;
    this.orderId = orderId;
    this.timestamp = timestamp;
    this.commission = commission;
    this.commissionCurrency = commissionCurrency;
  }

  public String getPair() {
    return pair;
  }

  public Type getType() {
    return type;
  }

  public Double getAmount() {
    return amount;
  }

  public Double getRate() {
    return rate;
  }

  public Long getOrderId() {
    return orderId;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public Double getCommission() {
    return commission;
  }

  public String getCommissionCurrency() {
    return commissionCurrency;
  }

  @Override
  public String toString() {

    return MessageFormat.format(
        "DSXOwnTransaction[pair=''{0}'', type={1}, amount={2}, rate={3}, orderId={4}, timestamp={5}, "
            + "commission={6}, commissionCurrency={7}]",
        pair, type, amount, rate, orderId, timestamp, commission, commissionCurrency);
  }

  public enum Type {
    buy,
    sell
  }
}
