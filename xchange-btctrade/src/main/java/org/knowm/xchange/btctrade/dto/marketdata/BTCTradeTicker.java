package org.knowm.xchange.btctrade.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BTCTradeTicker {

  private final Double high;
  private final Double low;
  private final Double buy;
  private final Double sell;
  private final Double last;
  private final Double vol;

  public BTCTradeTicker(
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("buy") Double buy,
      @JsonProperty("sell") Double sell,
      @JsonProperty("last") Double last,
      @JsonProperty("vol") Double vol) {

    this.high = high;
    this.low = low;
    this.buy = buy;
    this.sell = sell;
    this.last = last;
    this.vol = vol;
  }

  public Double getHigh() {

    return high;
  }

  public Double getLow() {

    return low;
  }

  public Double getBuy() {

    return buy;
  }

  public Double getSell() {

    return sell;
  }

  public Double getLast() {

    return last;
  }

  public Double getVol() {

    return vol;
  }
}
