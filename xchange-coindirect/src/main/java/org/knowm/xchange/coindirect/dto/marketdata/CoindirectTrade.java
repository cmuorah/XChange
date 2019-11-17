package org.knowm.xchange.coindirect.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoindirectTrade {
  public final long time;
  public final Double price;
  public final Double volume;

  public CoindirectTrade(
      @JsonProperty("time") long time,
      @JsonProperty("price") Double price,
      @JsonProperty("volume") Double volume) {
    this.time = time;
    this.price = price;
    this.volume = volume;
  }

  @Override
  public String toString() {
    return "CoindirectTrade{" + "time=" + time + ", price=" + price + ", volume=" + volume + '}';
  }
}
