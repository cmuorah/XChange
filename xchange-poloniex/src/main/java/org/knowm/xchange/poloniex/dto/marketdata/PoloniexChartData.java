package org.knowm.xchange.poloniex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Date;
import org.knowm.xchange.poloniex.PoloniexUtils;

public class PoloniexChartData {
  private Date date;
  private Double high;
  private Double low;
  private Double open;
  private Double close;
  private Double volume;
  private Double quoteVolume;
  private Double weightedAverage;

  @JsonCreator
  public PoloniexChartData(
      @JsonProperty(value = "date", required = true)
          @JsonDeserialize(using = PoloniexUtils.UnixTimestampDeserializer.class)
          Date date,
      @JsonProperty(value = "high", required = true) Double high,
      @JsonProperty(value = "low", required = true) Double low,
      @JsonProperty(value = "open", required = true) Double open,
      @JsonProperty(value = "close", required = true) Double close,
      @JsonProperty(value = "volume", required = true) Double volume,
      @JsonProperty(value = "quoteVolume", required = true) Double quoteVolume,
      @JsonProperty(value = "weightedAverage", required = true) Double weightedAverage) {
    this.date = date;
    this.high = high;
    this.low = low;
    this.open = open;
    this.close = close;
    this.volume = volume;
    this.quoteVolume = quoteVolume;
    this.weightedAverage = weightedAverage;
  }

  public Date getDate() {
    return date;
  }

  public Double getHigh() {
    return high;
  }

  public Double getLow() {
    return low;
  }

  public Double getOpen() {
    return open;
  }

  public Double getClose() {
    return close;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getQuoteVolume() {
    return quoteVolume;
  }

  public Double getWeightedAverage() {
    return weightedAverage;
  }

  @Override
  public String toString() {
    return "PoloniexChartData ["
        + "date="
        + date
        + ", high="
        + high
        + ", low="
        + low
        + ", open="
        + open
        + ", close="
        + close
        + ", volume="
        + volume
        + ", quoteVolume="
        + quoteVolume
        + ", weightedAverage="
        + weightedAverage
        + ']';
  }
}
