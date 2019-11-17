package org.knowm.xchange.acx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AcxTicker {
  /** Current sell price */
  public final Double buy;
  /** Current sell price */
  public final Double sell;

  public final Double open;
  /** Lowest price in last 24 hours */
  public final Double low;
  /** Highest price in last 24 hours */
  public final Double high;
  /** Last price */
  public final Double last;
  /** Trade volume in last 24 hours */
  public final Double vol;

  public AcxTicker(
      @JsonProperty("buy") Double buy,
      @JsonProperty("sell") Double sell,
      @JsonProperty("open") Double open,
      @JsonProperty("low") Double low,
      @JsonProperty("high") Double high,
      @JsonProperty("last") Double last,
      @JsonProperty("vol") Double vol) {
    this.buy = buy;
    this.sell = sell;
    this.open = open;
    this.low = low;
    this.high = high;
    this.last = last;
    this.vol = vol;
  }
}
