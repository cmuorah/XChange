package org.knowm.xchange.bl3p.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class Bl3pTicker {

  @JsonProperty("ask")
  private Double ask;

  @JsonProperty("bid")
  private Double bid;

  @JsonProperty("high")
  private Double high;

  @JsonProperty("last")
  private Double last;

  @JsonProperty("low")
  private Double low;

  private Date timestamp;

  @JsonProperty("volume")
  private Bl3pTickerVolume volume;

  public Bl3pTicker(@JsonProperty("timestamp") long timestamp) {
    this.timestamp = new Date(timestamp * 1000l);
  }

  public Double getAsk() {
    return ask;
  }

  public Double getBid() {
    return bid;
  }

  public Double getHigh() {
    return high;
  }

  public Double getLast() {
    return last;
  }

  public Double getLow() {
    return low;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public Bl3pTickerVolume getVolume() {
    return volume;
  }

  public static class Bl3pTickerVolume {
    @JsonProperty("24h")
    private Double day;

    @JsonProperty("30d")
    private Double month;

    public Double getDay() {
      return day;
    }

    public Double getMonth() {
      return month;
    }
  }
}
