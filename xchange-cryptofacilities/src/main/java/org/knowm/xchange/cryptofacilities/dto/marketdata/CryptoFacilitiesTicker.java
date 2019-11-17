package org.knowm.xchange.cryptofacilities.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;
import java.util.Date;
import org.knowm.xchange.cryptofacilities.Util;
import org.knowm.xchange.cryptofacilities.dto.CryptoFacilitiesResult;

/** @author Jean-Christophe Laruelle */
public class CryptoFacilitiesTicker extends CryptoFacilitiesResult {

  private final Double bid;
  private final Double ask;
  private final Double last;
  private final Double askSize;
  private final String symbol;
  private final Date lastTime;
  private final Double low24H;
  private final Double bidSize;
  private final boolean suspended;
  private final Double open24H;
  private final Double high24H;
  private final Double markPrice;
  private final Double lastSize;
  private final Double vol24H;
  private final String tag;
  private final String pair;
  private final Double fundingRate;
  private final Double fundingRatePrediction;

  public CryptoFacilitiesTicker(
      @JsonProperty("result") String result,
      @JsonProperty("error") String error,
      @JsonProperty("bid") Double bid,
      @JsonProperty("ask") Double ask,
      @JsonProperty("last") Double last,
      @JsonProperty("askSize") Double askSize,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("lastTime") String strLastTime,
      @JsonProperty("low24h") Double low24H,
      @JsonProperty("bidSize") Double bidSize,
      @JsonProperty("suspended") boolean suspended,
      @JsonProperty("open24h") Double open24H,
      @JsonProperty("high24h") Double high24H,
      @JsonProperty("markPrice") Double markPrice,
      @JsonProperty("lastSize") Double lastSize,
      @JsonProperty("vol24h") Double vol24H,
      @JsonProperty("tag") String tag,
      @JsonProperty("pair") String pair,
      @JsonProperty("fundingRate") Double fundingRate,
      @JsonProperty("fundingRatePrediction") Double fundingRatePrediction)
      throws ParseException {

    super(result, error);

    this.bid = bid;
    this.ask = ask;
    this.last = last;
    this.askSize = askSize;
    this.symbol = symbol;
    this.lastTime = Util.parseDate(strLastTime);
    this.low24H = low24H;
    this.bidSize = bidSize;
    this.suspended = suspended;
    this.open24H = open24H;
    this.high24H = high24H;
    this.markPrice = markPrice;
    this.lastSize = lastSize;
    this.vol24H = vol24H;
    this.tag = tag;
    this.pair = pair;
    this.fundingRate = fundingRate;
    this.fundingRatePrediction = fundingRatePrediction;
  }

  public Double getBid() {
    return bid;
  }

  public Double getAsk() {
    return ask;
  }

  public Double getLast() {
    return last;
  }

  public Double getAskSize() {
    return askSize;
  }

  public String getSymbol() {
    return symbol;
  }

  public Date getLastTime() {
    return lastTime;
  }

  public Double getLow24H() {
    return low24H;
  }

  public Double getBidSize() {
    return bidSize;
  }

  public boolean getSuspended() {
    return suspended;
  }

  public Double getOpen24H() {
    return open24H;
  }

  public Double getHigh24H() {
    return high24H;
  }

  public Double getMarkPrice() {
    return markPrice;
  }

  public Double getLastSize() {
    return lastSize;
  }

  public Double getVol24H() {
    return vol24H;
  }

  public String getTag() {
    return tag;
  }

  public String getPair() {
    return pair;
  }

  public Double getFundingRate() {
    return fundingRate;
  }

  public Double getFundingRatePrediction() {
    return fundingRatePrediction;
  }

  @Override
  public String toString() {

    return "CryptoFacilitiesTicker ["
        + "symbol="
        + symbol
        + ", bid="
        + bid
        + ", bidSize="
        + bidSize
        + ", ask="
        + ask
        + ", askSize="
        + askSize
        + ", last="
        + last
        + ", lastSize="
        + lastSize
        + ", lastTime="
        + lastTime
        + ", open24H="
        + open24H
        + ", low24H="
        + low24H
        + ", high24H="
        + high24H
        + ", vol24H="
        + vol24H
        + ", markPrice="
        + markPrice
        + ", suspended="
        + suspended
        + ", tag="
        + tag
        + ", pair="
        + pair
        + ", fundingRate="
        + fundingRate
        + ", fundingRatePrediction="
        + fundingRatePrediction
        + "]";
  }
}
