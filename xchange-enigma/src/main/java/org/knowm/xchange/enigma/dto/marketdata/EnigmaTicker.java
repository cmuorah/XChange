package org.knowm.xchange.enigma.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnigmaTicker {
  @JsonProperty("product_id")
  private int productId;

  @JsonProperty("product_name")
  private String productName;

  @JsonProperty("last")
  private Double last;

  @JsonProperty("open")
  private Double open;

  @JsonProperty("bid")
  private Double bid;

  @JsonProperty("ask")
  private Double ask;

  @JsonProperty("bid_qty")
  private Double bidQty;

  @JsonProperty("ask_qty")
  private Double askQty;
}
