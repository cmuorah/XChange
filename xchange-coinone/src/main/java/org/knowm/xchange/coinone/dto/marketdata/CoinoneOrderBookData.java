package org.knowm.xchange.coinone.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author interwater */
public class CoinoneOrderBookData {

  private final Double price;
  private final Double qty;

  /**
   * @param price
   * @param qty
   */
  public CoinoneOrderBookData(
      @JsonProperty("price") String price, @JsonProperty("qty") String qty) {
    this.price = new Double(price);
    this.qty = new Double(qty);
  }

  public Double getPrice() {
    return price;
  }

  public Double getQty() {
    return qty;
  }

  @Override
  public String toString() {

    return "CoinoneOrderBook{" + "price=" + price + ", qty=" + qty + "}";
  }
}
