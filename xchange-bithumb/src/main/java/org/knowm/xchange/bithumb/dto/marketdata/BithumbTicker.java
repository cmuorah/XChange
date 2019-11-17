package org.knowm.xchange.bithumb.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BithumbTicker {

  private final Double openingPrice;
  private final Double closingPrice;
  private final Double minPrice;
  private final Double maxPrice;
  private final Double averagePrice;
  private final Double unitsTraded;
  private final Double volume1day;
  private final Double volume7day;
  private final Double buyPrice;
  private final Double sellPrice;
  private final Double _24HFluctate;
  private final Double _24HFluctateRate;
  private long date;

  public BithumbTicker(
      @JsonProperty("opening_price") Double openingPrice,
      @JsonProperty("closing_price") Double closingPrice,
      @JsonProperty("min_price") Double minPrice,
      @JsonProperty("max_price") Double maxPrice,
      @JsonProperty("average_price") Double averagePrice,
      @JsonProperty("units_traded") Double unitsTraded,
      @JsonProperty("volume_1day") Double volume1day,
      @JsonProperty("volume_7day") Double volume7day,
      @JsonProperty("buy_price") Double buyPrice,
      @JsonProperty("sell_price") Double sellPrice,
      @JsonProperty("24H_fluctate") Double hFluctate,
      @JsonProperty("24H_fluctate_rate") Double hFluctateRate,
      @JsonProperty("date") long date) {
    this.openingPrice = openingPrice;
    this.closingPrice = closingPrice;
    this.minPrice = minPrice;
    this.maxPrice = maxPrice;
    this.averagePrice = averagePrice;
    this.unitsTraded = unitsTraded;
    this.volume1day = volume1day;
    this.volume7day = volume7day;
    this.buyPrice = buyPrice;
    this.sellPrice = sellPrice;
    _24HFluctate = hFluctate;
    _24HFluctateRate = hFluctateRate;
    this.date = date;
  }

  public Double getOpeningPrice() {
    return openingPrice;
  }

  public Double getClosingPrice() {
    return closingPrice;
  }

  public Double getMinPrice() {
    return minPrice;
  }

  public Double getMaxPrice() {
    return maxPrice;
  }

  public Double getAveragePrice() {
    return averagePrice;
  }

  public Double getUnitsTraded() {
    return unitsTraded;
  }

  public Double getVolume1day() {
    return volume1day;
  }

  public Double getVolume7day() {
    return volume7day;
  }

  public Double getBuyPrice() {
    return buyPrice;
  }

  public Double getSellPrice() {
    return sellPrice;
  }

  public Double get_24HFluctate() {
    return _24HFluctate;
  }

  public Double get_24HFluctateRate() {
    return _24HFluctateRate;
  }

  public long getDate() {
    return date;
  }

  public void setDate(long date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "BithumbTicker{"
        + "openingPrice="
        + openingPrice
        + ", closingPrice="
        + closingPrice
        + ", minPrice="
        + minPrice
        + ", maxPrice="
        + maxPrice
        + ", averagePrice="
        + averagePrice
        + ", unitsTraded="
        + unitsTraded
        + ", volume1day="
        + volume1day
        + ", volume7day="
        + volume7day
        + ", buyPrice="
        + buyPrice
        + ", sellPrice="
        + sellPrice
        + ", _24HFluctate="
        + _24HFluctate
        + ", _24HFluctateRate="
        + _24HFluctateRate
        + ", date="
        + date
        + '}';
  }
}
