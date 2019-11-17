package org.knowm.xchange.liqui.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.List;

public class LiquiPublicAsk {

  private final Double price;
  private final Double volume;

  @JsonCreator
  public LiquiPublicAsk(final List<String> ask) {
    price = new Double(ask.get(0));
    volume = new Double(ask.get(1));
  }

  public Double getPrice() {
    return price;
  }

  public Double getVolume() {
    return volume;
  }

  @Override
  public String toString() {
    return "LiquiPublicAsk{" + "price=" + price + ", volume=" + volume + '}';
  }
}
