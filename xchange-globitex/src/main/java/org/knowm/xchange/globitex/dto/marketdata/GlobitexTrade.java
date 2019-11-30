package org.knowm.xchange.globitex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.openhft.chronicle.wire.AbstractMarshallable;

import java.io.Serializable;

public class GlobitexTrade extends AbstractMarshallable implements Serializable {

  @JsonProperty("date")
  private final long timestamp;

  @JsonProperty("price")
  private final Double price;

  @JsonProperty("amount")
  private final Double amount;

  @JsonProperty("tid")
  private final long tid;

  @JsonProperty("side")
  @JsonIgnore
  private final String side;

  public GlobitexTrade(
      @JsonProperty("date") long timestamp,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("tid") long tid,
      @JsonProperty("side") String side) {
    this.timestamp = timestamp;
    this.price = price;
    this.amount = amount;
    this.tid = tid;
    this.side = side;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public Double getPrice() {
    return price;
  }

  public Double getAmount() {
    return amount;
  }

  public long getTid() {
    return tid;
  }

  public String getSide() {
    return side;
  }

  @Override
  public String toString() {
    return "GlobitexTrade{"
        + "date="
        + timestamp
        + ", price="
        + price
        + ", amount="
        + amount
        + ", tid='"
        + tid
        + '\''
        + ", side='"
        + side
        + '\''
        + '}';
  }
}
