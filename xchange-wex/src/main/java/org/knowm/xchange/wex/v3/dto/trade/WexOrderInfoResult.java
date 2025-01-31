package org.knowm.xchange.wex.v3.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.MessageFormat;

/** @author Dyorgio Nascimento */
public class WexOrderInfoResult {

  private final String pair;
  private final Type type;
  private final Double startAmount;
  private final Double amount;
  private final Double rate;
  private final Long timestampCreated;
  /** 0 - active, 1 – executed order, 2 - canceled, 3 – canceled, but was partially executed. */
  private final int status;

  /**
   * Constructor
   *
   * @param status
   * @param timestampCreated
   * @param rate
   * @param startAmount
   * @param amount
   * @param type
   * @param pair
   */
  public WexOrderInfoResult(
      @JsonProperty("status") int status,
      @JsonProperty("timestamp_created") Long timestampCreated,
      @JsonProperty("rate") Double rate,
      @JsonProperty("start_amount") Double startAmount,
      @JsonProperty("amount") Double amount,
      @JsonProperty("type") Type type,
      @JsonProperty("pair") String pair) {

    this.status = status;
    this.timestampCreated = timestampCreated;
    this.rate = rate;
    this.startAmount = startAmount;
    this.amount = amount;
    this.type = type;
    this.pair = pair;
  }

  public String getPair() {

    return pair;
  }

  public Type getType() {

    return type;
  }

  public Double getStartAmount() {

    return startAmount;
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

  public int getStatus() {

    return status;
  }

  @Override
  public String toString() {

    return MessageFormat.format(
        "WexOrderInfoResult[pair=''{0}'', type={1}, startAmount={2}, amount={3}, rate={4}, timestampCreated={5}, status={6}]",
        pair, type, startAmount, amount, rate, timestampCreated, status);
  }

  public enum Type {
    buy,
    sell
  }
}
