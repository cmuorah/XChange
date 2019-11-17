package org.knowm.xchange.btcturk.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/** Created by semihunaldi on 26/11/2017 */
public final class BTCTurkOHLC {
  private final Date time;
  private final Double open;
  private final Double high;
  private final Double low;
  private final Double close;
  private final Double volume;
  private final Double average;
  private final Double dailyChangeAmount;
  private final Double dailyChangePercentage;

  public BTCTurkOHLC(
      @JsonProperty("Time") Date time,
      @JsonProperty("Open") Double open,
      @JsonProperty("High") Double high,
      @JsonProperty("Low") Double low,
      @JsonProperty("Close") Double close,
      @JsonProperty("Volume") Double volume,
      @JsonProperty("Average") Double average,
      @JsonProperty("DailyChangeAmount") Double dailyChangeAmount,
      @JsonProperty("DailyChangePercentage") Double dailyChangePercentage) {
    this.time = time;
    this.open = open;
    this.high = high;
    this.low = low;
    this.close = close;
    this.volume = volume;
    this.average = average;
    this.dailyChangeAmount = dailyChangeAmount;
    this.dailyChangePercentage = dailyChangePercentage;
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

  public Double getAverage() {
    return average;
  }

  public Double getDailyChangeAmount() {
    return dailyChangeAmount;
  }

  public Double getDailyChangePercentage() {
    return dailyChangePercentage;
  }

  @Override
  public String toString() {
    return "BTCTurkOHLC {"
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
        + ", average="
        + average
        + ", dailyChangeAmount="
        + dailyChangeAmount
        + ", dailyChangePercentage="
        + dailyChangePercentage
        + '}';
  }
}
