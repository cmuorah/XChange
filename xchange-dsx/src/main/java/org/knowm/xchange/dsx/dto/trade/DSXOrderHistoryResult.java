package org.knowm.xchange.dsx.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.MessageFormat;

/** @author Mikhail Wall */
public class DSXOrderHistoryResult {

  private final String pair;
  private final Type type;
  private final Double amount;
  private final Double rate;
  private final Long timestampCreated;
  private final Status status;
  private final OrderType orderType;

  public DSXOrderHistoryResult(
      @JsonProperty("pair") String pair,
      @JsonProperty("type") Type type,
      @JsonProperty("amount") Double amount,
      @JsonProperty("rate") Double rate,
      @JsonProperty("timestampCreated") Long timestampCreated,
      @JsonProperty("status") Status status,
      @JsonProperty("orderType") OrderType orderType) {

    this.pair = pair;
    this.type = type;
    this.amount = amount;
    this.rate = rate;
    this.timestampCreated = timestampCreated;
    this.status = status;
    this.orderType = orderType;
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

  public Long getTimestampCreated() {
    return timestampCreated;
  }

  public Status getStatus() {
    return status;
  }

  public OrderType getOrderType() {
    return orderType;
  }

  @Override
  public String toString() {

    return MessageFormat.format(
        "DSXOrderHistory[pair=''{0}'', type={1}, amount={2}, rate={3}, timestampCreated={4}, status={5}, orderType={6}]",
        pair, type, amount, rate, timestampCreated, status, orderType);
  }

  public enum Type {
    buy,
    sell
  }

  public enum Status {
    Active,
    Filled,
    Killed,
    Killing,
    Executing,
    Refused,
    Rejected
  }

  public enum OrderType {
    limit,
    market
  }
}
