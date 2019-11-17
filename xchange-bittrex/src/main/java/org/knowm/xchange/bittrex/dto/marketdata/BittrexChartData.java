package org.knowm.xchange.bittrex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.knowm.xchange.bittrex.BittrexUtils;

public class BittrexChartData {
  private final Date timeStamp;
  private final Double open;
  private final Double close;
  private final Double high;
  private final Double low;
  private final Double volume;
  private final Double baseVolume;

  public BittrexChartData(
      @JsonProperty("T") String timeStamp,
      @JsonProperty("O") Double open,
      @JsonProperty("C") Double close,
      @JsonProperty("H") Double high,
      @JsonProperty("L") Double low,
      @JsonProperty("V") Double volume,
      @JsonProperty("BV") Double baseVolume) {
    this.timeStamp = BittrexUtils.toDate(timeStamp);
    this.open = open;
    this.close = close;
    this.high = high;
    this.low = low;
    this.volume = volume;
    this.baseVolume = baseVolume;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  public Double getOpen() {
    return open;
  }

  public Double getClose() {
    return close;
  }

  public Double getHigh() {
    return high;
  }

  public Double getLow() {
    return low;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getBaseVolume() {
    return baseVolume;
  }

  @Override
  public String toString() {
    return "BittrexChartData [timeStamp="
        + timeStamp
        + ", open="
        + open
        + ", close="
        + close
        + ", high="
        + high
        + ", low="
        + low
        + ", volume="
        + volume
        + ", baseVolume="
        + baseVolume
        + "]";
  }
}
