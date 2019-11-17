package org.knowm.xchange.quoine.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** @author timmolter */
public final class QuoineOrderBook {

  private final List<Double[]> buyPriceLevels;

  private final List<Double[]> sellPriceLevels;

  /**
   * Constructor
   *
   * @param buyPriceLevels
   * @param sellPriceLevels
   */
  public QuoineOrderBook(
      @JsonProperty("buy_price_levels") List<Double[]> buyPriceLevels,
      @JsonProperty("sell_price_levels") List<Double[]> sellPriceLevels) {

    this.buyPriceLevels = buyPriceLevels;
    this.sellPriceLevels = sellPriceLevels;
  }

  public List<Double[]> getBuyPriceLevels() {
    return buyPriceLevels;
  }

  public List<Double[]> getSellPriceLevels() {
    return sellPriceLevels;
  }

  @Override
  public String toString() {
    return "QuoineOrderBook [buyPriceLevels="
        + buyPriceLevels
        + ", sellPriceLevels="
        + sellPriceLevels
        + "]";
  }
}
