package org.knowm.xchange.coinone.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author interwater */
public class CoinoneTradeData {

  private final Double price;
  private final Double qty;
  private final String timestamp;

  /**
   * @param price
   * @param qty
   * @param timestamp
   */
  public CoinoneTradeData(
      @JsonProperty("price") String price,
      @JsonProperty("qty") String qty,
      @JsonProperty("timestamp") String timestamp) {
    this.price = new Double(price);
    this.qty = new Double(qty);
    this.timestamp = timestamp;
  }

  public Double getPrice() {
    return price;
  }

  public Double getQty() {
    return qty;
  }

  public String getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {

    return "CoinoneOrderBook{" + "price=" + price + ", qty=" + qty + "}";
  }
}
