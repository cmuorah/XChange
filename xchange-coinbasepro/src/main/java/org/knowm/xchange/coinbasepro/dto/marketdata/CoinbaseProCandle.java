package org.knowm.xchange.coinbasepro.dto.marketdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Date;

@JsonDeserialize(using = CoinbaseProCandleDeserializer.class)
public class CoinbaseProCandle {

  private final Date time;
  private final Double open, high, low, close, volume;

  public CoinbaseProCandle(
      Date time, Double open, Double high, Double low, Double close, Double volume) {
    this.time = time;
    this.open = open;
    this.high = high;
    this.low = low;
    this.close = close;
    this.volume = volume;
  }

  public Date getTime() {
    return time;
  }

  public Double getOpen() {
    return open;
  }

  public Double getHigh() {
    return high;
  }

  public Double getLow() {
    return low;
  }

  public Double getClose() {
    return close;
  }

  public Double getVolume() {
    return volume;
  }

  @Override
  public String toString() {
    return "CoinbaseProCandle [time="
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
        + "]";
  }
}
