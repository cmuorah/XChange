package org.knowm.xchange.coinbasepro.dto.marketdata;

public class CoinbaseProProductBookEntryLevel1or2 extends CoinbaseProProductBookEntry {

  private final int numOrdersOnLevel;

  public CoinbaseProProductBookEntryLevel1or2(Double price, Double volume, int numOrdersOnLevel) {
    super(price, volume);
    this.numOrdersOnLevel = numOrdersOnLevel;
  }

  public int getNumOrdersOnLevel() {
    return numOrdersOnLevel;
  }
}
