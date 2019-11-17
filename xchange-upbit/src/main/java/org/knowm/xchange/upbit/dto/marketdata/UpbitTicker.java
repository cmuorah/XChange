package org.knowm.xchange.upbit.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpbitTicker {
  private final String market;
  private final String trade_date;
  private final String trade_time;
  private final String trade_date_kst;
  private final String trade_time_kst;
  private final String trade_timestamp;
  private final Double opening_price;
  private final Double high_price;
  private final Double low_price;
  private final Double trade_price;
  private final Double prev_closing_price;
  private final String change;
  private final Double change_price;
  private final Double change_rate;
  private final Double signed_change_price;
  private final Double signed_change_rate;
  private final Double trade_volume;
  private final Double acc_trade_price;
  private final Double acc_trade_price_24h;
  private final Double acc_trade_volume;
  private final Double acc_trade_volume_24h;
  private final Double highest_52_week_price;
  private final String highest_52_week_date;
  private final Double lowest_52_week_price;
  private final String lowest_52_week_date;
  private final Double timestamp;

  /**
   * @param market
   * @param trade_date
   * @param trade_time
   * @param trade_date_kst
   * @param trade_time_kst
   * @param trade_timestamp
   * @param opening_price
   * @param high_price
   * @param low_price
   * @param trade_price
   * @param prev_closing_price
   * @param change
   * @param change_price
   * @param change_rate
   * @param signed_change_price
   * @param signed_change_rate
   * @param trade_volume
   * @param acc_trade_price
   * @param acc_trade_price_24h
   * @param acc_trade_volume
   * @param acc_trade_volume_24h
   * @param highest_52_week_price
   * @param highest_52_week_date
   * @param lowest_52_week_price
   * @param lowest_52_week_date
   * @param timestamp
   */
  public UpbitTicker(
      @JsonProperty("market") String market,
      @JsonProperty("trade_date") String trade_date,
      @JsonProperty("trade_time") String trade_time,
      @JsonProperty("trade_date_kst") String trade_date_kst,
      @JsonProperty("trade_time_kst") String trade_time_kst,
      @JsonProperty("trade_timestamp") String trade_timestamp,
      @JsonProperty("opening_price") Double opening_price,
      @JsonProperty("high_price") Double high_price,
      @JsonProperty("low_price") Double low_price,
      @JsonProperty("trade_price") Double trade_price,
      @JsonProperty("prev_closing_price") Double prev_closing_price,
      @JsonProperty("change") String change,
      @JsonProperty("change_price") Double change_price,
      @JsonProperty("change_rate") Double change_rate,
      @JsonProperty("signed_change_price") Double signed_change_price,
      @JsonProperty("signed_change_rate") Double signed_change_rate,
      @JsonProperty("trade_volume") Double trade_volume,
      @JsonProperty("acc_trade_price") Double acc_trade_price,
      @JsonProperty("acc_trade_price_24h") Double acc_trade_price_24h,
      @JsonProperty("acc_trade_volume") Double acc_trade_volume,
      @JsonProperty("acc_trade_volume_24h") Double acc_trade_volume_24h,
      @JsonProperty("highest_52_week_price") Double highest_52_week_price,
      @JsonProperty("highest_52_week_date") String highest_52_week_date,
      @JsonProperty("lowest_52_week_price") Double lowest_52_week_price,
      @JsonProperty("lowest_52_week_date") String lowest_52_week_date,
      @JsonProperty("timestamp") Double timestamp) {
    this.market = market;
    this.trade_date = trade_date;
    this.trade_time = trade_time;
    this.trade_date_kst = trade_date_kst;
    this.trade_time_kst = trade_time_kst;
    this.trade_timestamp = trade_timestamp;
    this.opening_price = opening_price;
    this.high_price = high_price;
    this.low_price = low_price;
    this.trade_price = trade_price;
    this.prev_closing_price = prev_closing_price;
    this.change = change;
    this.change_price = change_price;
    this.change_rate = change_rate;
    this.signed_change_price = signed_change_price;
    this.signed_change_rate = signed_change_rate;
    this.trade_volume = trade_volume;
    this.acc_trade_price = acc_trade_price;
    this.acc_trade_price_24h = acc_trade_price_24h;
    this.acc_trade_volume = acc_trade_volume;
    this.acc_trade_volume_24h = acc_trade_volume_24h;
    this.highest_52_week_price = highest_52_week_price;
    this.highest_52_week_date = highest_52_week_date;
    this.lowest_52_week_price = lowest_52_week_price;
    this.lowest_52_week_date = lowest_52_week_date;
    this.timestamp = timestamp;
  }

  public String getMarket() {
    return market;
  }

  public String getTrade_date() {
    return trade_date;
  }

  public String getTrade_time() {
    return trade_time;
  }

  public String getTrade_date_kst() {
    return trade_date_kst;
  }

  public String getTrade_time_kst() {
    return trade_time_kst;
  }

  public String getTrade_timestamp() {
    return trade_timestamp;
  }

  public Double getOpening_price() {
    return opening_price;
  }

  public Double getHigh_price() {
    return high_price;
  }

  public Double getLow_price() {
    return low_price;
  }

  public Double getTrade_price() {
    return trade_price;
  }

  public Double getPrev_closing_price() {
    return prev_closing_price;
  }

  public String getChange() {
    return change;
  }

  public Double getChange_price() {
    return change_price;
  }

  public Double getChange_rate() {
    return change_rate;
  }

  public Double getSigned_change_price() {
    return signed_change_price;
  }

  public Double getSigned_change_rate() {
    return signed_change_rate;
  }

  public Double getTrade_volume() {
    return trade_volume;
  }

  public Double getAcc_trade_price() {
    return acc_trade_price;
  }

  public Double getAcc_trade_price_24h() {
    return acc_trade_price_24h;
  }

  public Double getAcc_trade_volume() {
    return acc_trade_volume;
  }

  public Double getAcc_trade_volume_24h() {
    return acc_trade_volume_24h;
  }

  public Double getHighest_52_week_price() {
    return highest_52_week_price;
  }

  public String getHighest_52_week_date() {
    return highest_52_week_date;
  }

  public Double getLowest_52_week_price() {
    return lowest_52_week_price;
  }

  public String getLowest_52_week_date() {
    return lowest_52_week_date;
  }

  public Double getTimestamp() {
    return timestamp;
  }
}
