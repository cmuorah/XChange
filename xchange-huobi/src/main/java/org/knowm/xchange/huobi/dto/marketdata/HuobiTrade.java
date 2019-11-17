package org.knowm.xchange.huobi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class HuobiTrade {
  private final String id;
  private final Double price;
  private final Double amount;
  private final String direction;
  private final Date ts;

  public HuobiTrade(
      @JsonProperty("id") String id,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("direction") String direction,
      @JsonProperty("ts") Date ts) {
    this.id = id;
    this.price = price;
    this.amount = amount;
    this.direction = direction;
    this.ts = ts;
  }

  public String getId() {
    return id;
  }

  public Double getPrice() {
    return price;
  }

  public Double getAmount() {
    return amount;
  }

  public String getDirection() {
    return direction;
  }

  public Date getTs() {
    return ts;
  }

  @Override
  public String toString() {

    return "HuobiTrade [timestamp="
        + ts
        + ", price="
        + price
        + ", amount="
        + amount
        + ", type="
        + direction
        + "]";
  }
}
