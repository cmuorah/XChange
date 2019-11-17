package org.knowm.xchange.zaif.dto.marketdata;

import org.knowm.xchange.zaif.dto.ZaifException;

public class ZaifFullBookTier {
  private final Double price;
  private final Double volume;

  public ZaifFullBookTier(Object[] tier) {

    if (tier != null && tier.length == 2) {
      this.price = new Double(tier[0].toString());
      this.volume = new Double(tier[1].toString());
    } else throw new ZaifException("Invalid Tier");
  }

  public Double getPrice() {
    return this.price;
  }

  public Double getVolume() {
    return this.volume;
  }

  @Override
  public String toString() {
    return "ZaifFullBookTier [price=" + price + ", volume=" + volume + "]";
  }
}
