package org.knowm.xchange.coinbasepro.dto.marketdata;

public abstract class CoinbaseProProductBookEntry {

  private final Double price;
  private final Double volume;

  public CoinbaseProProductBookEntry(Double price, Double volume) {

    this.price = price;
    this.volume = volume;
  }

  public Double getPrice() {

    return price;
  }

  public Double getVolume() {

    return volume;
  }

  @Override
  public String toString() {
    return "CoinbaseProProductBookEntry [price=" + price + ", volume=" + volume + "]";
  }
}
