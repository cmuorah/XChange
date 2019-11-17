package org.knowm.xchange.coindirect.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoindirectPriceLevel {
  public final Double size;
  public final Double price;

  public CoindirectPriceLevel(
      @JsonProperty("size") Double size, @JsonProperty("price") Double price) {
    this.size = size;
    this.price = price;
  }

  @Override
  public String toString() {
    return "CoindirectPriceLevel{" + "size=" + size + ", price=" + price + '}';
  }
}
