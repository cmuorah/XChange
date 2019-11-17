package org.knowm.xchange.independentreserve.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** @author Stuart Low */
public final class IndependentReserveTicker {
  private final Double last;
  private final Double high;
  private final Double low;
  private final Double vwap;
  private final Double volume;
  private final Double bid;
  private final Double ask;
  private Date timestamp;

  /**
   * Constructor
   *
   * @param last
   * @param high
   * @param low
   * @param vwap
   * @param volume
   * @param bid
   * @param ask
   */
  public IndependentReserveTicker(
      @JsonProperty("LastPrice") Double last,
      @JsonProperty("DayHighestPrice") Double high,
      @JsonProperty("DayLowestPrice") Double low,
      @JsonProperty("DayAvgPrice") Double vwap,
      @JsonProperty("DayVolumeXbt") Double volume,
      @JsonProperty("CurrentHighestBidPrice") Double bid,
      @JsonProperty("CurrentLowestOfferPrice") Double ask,
      @JsonProperty("CreatedTimestampUtc") String timestamp) {

    // @JsonFormat(pattern="") @JsonDeserialize(using =
    // TimestampDeserializer.class)
    this.last = last;
    this.high = high;
    this.low = low;
    this.vwap = vwap;
    this.volume = volume;
    this.bid = bid;
    this.ask = ask;

    try {
      SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSX");
      this.timestamp = myFormatter.parse(timestamp);
    } catch (ParseException e) {
      System.out.println(
          "Received parsing exception while attempting to process timestamp: " + e.getMessage());
    }
  }

  public Double getLast() {

    return last;
  }

  public Double getHigh() {

    return high;
  }

  public Double getLow() {

    return low;
  }

  public Double getVwap() {

    return vwap;
  }

  public Double getVolume() {

    return volume;
  }

  public Double getBid() {

    return bid;
  }

  public Double getAsk() {

    return ask;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {

    return "IndependentReserveTicker [last="
        + last
        + ", high="
        + high
        + ", low="
        + low
        + ", vwap="
        + vwap
        + ", volume="
        + volume
        + ", bid="
        + bid
        + ", ask="
        + ask
        + ", timestamp="
        + timestamp
        + "]";
  }
}
