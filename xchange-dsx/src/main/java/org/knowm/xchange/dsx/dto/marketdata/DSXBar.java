package org.knowm.xchange.dsx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author Mikhail Wall */
public final class DSXBar {

  private final Double high;
  private final Double open;
  private final Double low;
  private final Double close;
  private final Double amount;
  private final long timestamp;

  public DSXBar(
      @JsonProperty("high") Double high,
      @JsonProperty("open") Double open,
      @JsonProperty("low") Double low,
      @JsonProperty("close") Double close,
      @JsonProperty("amount") Double amount,
      @JsonProperty("timestamp") long timestamp) {

    this.high = high;
    this.open = open;
    this.low = low;
    this.close = close;
    this.amount = amount;
    this.timestamp = timestamp;
  }

  public Double getHigh() {

    return high;
  }

  public Double getOpen() {

    return open;
  }

  public Double getLow() {

    return low;
  }

  public Double getClose() {

    return close;
  }

  public Double getAmount() {

    return amount;
  }

  public long getTimestamp() {

    return timestamp;
  }

  @Override
  public String toString() {

    return "DSXBar{"
        + "high="
        + high
        + ", open="
        + open
        + ", low="
        + low
        + ", close="
        + close
        + ", amount="
        + amount
        + ", timestamp="
        + timestamp
        + '}';
  }
}
