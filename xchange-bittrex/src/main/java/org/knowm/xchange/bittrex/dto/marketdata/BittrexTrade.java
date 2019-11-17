package org.knowm.xchange.bittrex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BittrexTrade {

  private String fillType;
  private String id;
  private String orderType;
  private Double price;
  private Double quantity;
  private String timeStamp;
  private Double total;

  public BittrexTrade(
      @JsonProperty("FillType") String fillType,
      @JsonProperty("Id") String id,
      @JsonProperty("OrderType") String orderType,
      @JsonProperty("Price") Double price,
      @JsonProperty("Quantity") Double quantity,
      @JsonProperty("TimeStamp") String timeStamp,
      @JsonProperty("Total") Double total) {

    super();
    this.fillType = fillType;
    this.id = id;
    this.orderType = orderType;
    this.price = price;
    this.quantity = quantity;
    this.timeStamp = timeStamp;
    this.total = total;
  }

  public String getFillType() {

    return this.fillType;
  }

  public void setFillType(String fillType) {

    this.fillType = fillType;
  }

  public String getId() {

    return this.id;
  }

  public void setId(String id) {

    this.id = id;
  }

  public String getOrderType() {

    return this.orderType;
  }

  public void setOrderType(String orderType) {

    this.orderType = orderType;
  }

  public Double getPrice() {

    return this.price;
  }

  public void setPrice(Double price) {

    this.price = price;
  }

  public Double getQuantity() {

    return this.quantity;
  }

  public void setQuantity(Double quantity) {

    this.quantity = quantity;
  }

  public String getTimeStamp() {

    return this.timeStamp;
  }

  public void setTimeStamp(String timeStamp) {

    this.timeStamp = timeStamp;
  }

  public Double getTotal() {

    return this.total;
  }

  public void setTotal(Double total) {

    this.total = total;
  }

  @Override
  public String toString() {

    return "BittrexTrade [fillType="
        + fillType
        + ", id="
        + id
        + ", orderType="
        + orderType
        + ", price="
        + price
        + ", quantity="
        + quantity
        + ", timeStamp="
        + timeStamp
        + ", total="
        + total
        + "]";
  }
}
