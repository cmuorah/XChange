package org.knowm.xchange.livecoin.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LivecoinTrade {

  private final Long time;
  private final Long id;
  private final Double price;
  private final Double quantity;
  private final String type;

  public LivecoinTrade(
      @JsonProperty("time") Long time,
      @JsonProperty("id") Long id,
      @JsonProperty("price") Double price,
      @JsonProperty("quantity") Double quantity,
      @JsonProperty("type") String type) {
    super();

    this.time = time;
    this.id = id;
    this.price = price;
    this.quantity = quantity;
    this.type = type;
  }

  public Long getTime() {
    return time;
  }

  public Long getId() {
    return id;
  }

  public Double getPrice() {
    return price;
  }

  public Double getQuantity() {
    return quantity;
  }

  public String getType() {
    return type;
  }

  @Override
  public String toString() {
    return "LivecoinTrade [time="
        + time
        + ", id="
        + id
        + ", price="
        + price
        + ", quantity="
        + quantity
        + ", type="
        + type
        + "]";
  }
}
