package org.knowm.xchange.coindirect.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoindirectTickerData {
  public final long time;
  public final Double open;
  public final Double high;
  public final Double low;
  public final Double close;
  public final Double volume;

  public CoindirectTickerData(
      @JsonProperty("time") long time,
      @JsonProperty("open") Double open,
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("close") Double close,
      @JsonProperty("volume") Double volume) {
    this.time = time;
    this.open = open;
    this.high = high;
    this.low = low;
    this.close = close;
    this.volume = volume;
  }

  @Override
  public String toString() {
    return "CoindirectTickerData{"
        + "time="
        + time
        + ", open="
        + open
        + ", high="
        + high
        + ", low="
        + low
        + ", close="
        + close
        + ", volume="
        + volume
        + '}';
  }
}
