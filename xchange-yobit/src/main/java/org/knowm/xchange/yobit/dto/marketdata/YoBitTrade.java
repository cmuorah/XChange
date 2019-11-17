package org.knowm.xchange.yobit.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YoBitTrade {
  private final String type;
  private final Double price;
  private final Double amount;
  private final Long tid;
  private final Long timestamp;

  public YoBitTrade(
      @JsonProperty("type") String type,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("tid") Long tid,
      @JsonProperty("timestamp") Long timestamp) {
    super();
    this.type = type;
    this.price = price;
    this.amount = amount;
    this.tid = tid;
    this.timestamp = timestamp;
  }

  public String getType() {
    return type;
  }

  public Double getPrice() {
    return price;
  }

  public Double getAmount() {
    return amount;
  }

  public Long getTid() {
    return tid;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return "YoBitTrade [type="
        + type
        + ", price="
        + price
        + ", amount="
        + amount
        + ", tid="
        + tid
        + ", timestamp="
        + timestamp
        + "]";
  }
}
