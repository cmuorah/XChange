package org.knowm.xchange.coinbasepro.dto.marketdata;

public class CoinbaseProProductBookEntryLevel3 extends CoinbaseProProductBookEntry {

  private final String orderId;

  public CoinbaseProProductBookEntryLevel3(Double price, Double volume, String orderId) {
    super(price, volume);
    this.orderId = orderId;
  }

  public String getOrderId() {
    return orderId;
  }
}
