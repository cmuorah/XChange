package org.knowm.xchange.independentreserve.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Author: Kamil Zbikowski Date: 4/10/15 */
public class OrderBookOrder {
  private final String guid;
  private final Double price;
  private final Double volume;

  public OrderBookOrder(
      @JsonProperty("Guid") String guid,
      @JsonProperty("Price") Double price,
      @JsonProperty("Volume") Double volume) {
    this.guid = guid;
    this.price = price;
    this.volume = volume;
  }

  public String getGuid() {
    return guid;
  }

  public Double getPrice() {
    return price;
  }

  public Double getVolume() {
    return volume;
  }

  @Override
  public String toString() {
    return "OrderBookOrder{"
        + "guid='"
        + guid
        + '\''
        + ", price="
        + price
        + ", volume="
        + volume
        + '}';
  }
}
