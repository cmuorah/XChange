package org.knowm.xchange.bitz.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Extend POJO To Remove Annotation
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitZPublicTrade {

  private final Double price;
  private final Double volume;

  public BitZPublicTrade(@JsonProperty("p") Double price, @JsonProperty("n") Double volume) {
    this.price = price;
    this.volume = volume;
  }

  public Double getPrice() {
    return price;
  }

  public Double getVolume() {
    return volume;
  }
}
