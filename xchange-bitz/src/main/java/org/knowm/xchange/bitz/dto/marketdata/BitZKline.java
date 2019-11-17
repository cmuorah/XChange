package org.knowm.xchange.bitz.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

// History Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitZKline {

  private final String contractUnit;
  private final String moneyType;
  private final String marketName;
  private final String symbol;
  private final String url;

  private final List<Double[]> data;

  public BitZKline(
      @JsonProperty("contractUnit") String contractUnit,
      @JsonProperty("moneyType") String moneyType,
      @JsonProperty("marketName") String marketName,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("url") String url,
      @JsonProperty("data") List<Double[]> data) {

    this.contractUnit = contractUnit;
    this.moneyType = moneyType;
    this.marketName = marketName;
    this.symbol = symbol;
    this.url = url;

    this.data = data;
  }
}
