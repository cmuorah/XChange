package org.knowm.xchange.ccex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CCEXTrade {

  private final String id;
  private final String timestamp;
  private final Double quantity;
  private final Double price;
  private final Double total;
  private final String fillType;
  private final String orderType;

  public CCEXTrade(
      @JsonProperty("Id") String id,
      @JsonProperty("TimeStamp") String timestamp,
      @JsonProperty("Quantity") Double quantity,
      @JsonProperty("Price") Double price,
      @JsonProperty("Total") Double total,
      @JsonProperty("FillType") String fillType,
      @JsonProperty("OrderType") String orderType) {
    super();
    this.id = id;
    this.timestamp = timestamp;
    this.quantity = quantity;
    this.price = price;
    this.total = total;
    this.fillType = fillType;
    this.orderType = orderType;
  }

  public String getId() {
    return id;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public Double getQuantity() {
    return quantity;
  }

  public Double getPrice() {
    return price;
  }

  public Double getTotal() {
    return total;
  }

  public String getFillType() {
    return fillType;
  }

  public String getOrderType() {
    return orderType;
  }
}
