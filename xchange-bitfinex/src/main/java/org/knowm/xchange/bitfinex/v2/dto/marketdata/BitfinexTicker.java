package org.knowm.xchange.bitfinex.v2.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class BitfinexTicker {

  private String symbol;
  private Double bid;
  private Double bidSize;
  private Double ask;
  private Double askSize;
  private Double dailyChange;
  private Double dailyChangePerc;
  private Double lastPrice;
  private Double volume;
  private Double high;
  private Double low;

  public BitfinexTicker() {}

  public BitfinexTicker(
      String symbol,
      Double bid,
      Double bidSize,
      Double ask,
      Double askSize,
      Double dailyChange,
      Double dailyChangePerc,
      Double lastPrice,
      Double volume,
      Double high,
      Double low) {

    this.symbol = symbol;
    this.bid = bid;
    this.bidSize = bidSize;
    this.ask = ask;
    this.askSize = askSize;
    this.dailyChange = dailyChange;
    this.dailyChangePerc = dailyChangePerc;
    this.lastPrice = lastPrice;
    this.volume = volume;
    this.high = high;
    this.low = low;
  }

  public String getSymbol() {
    return symbol;
  }

  public Double getBid() {
    return bid;
  }

  public Double getBidSize() {
    return bidSize;
  }

  public Double getAskSize() {
    return askSize;
  }

  public Double getDailyChange() {
    return dailyChange;
  }

  public Double getDailyChangePerc() {
    return dailyChangePerc;
  }

  public Double getLastPrice() {
    return lastPrice;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getHigh() {
    return high;
  }

  public Double getLow() {
    return low;
  }

  public Double getAsk() {
    return ask;
  }

  @Override
  public String toString() {
    return "BitfinexTicker{"
        + "symbol='"
        + symbol
        + '\''
        + ", bid="
        + bid
        + ", bidSize="
        + bidSize
        + ", askSize="
        + askSize
        + ", dailyChange="
        + dailyChange
        + ", dailyChangePerc="
        + dailyChangePerc
        + ", lastPrice="
        + lastPrice
        + ", volume="
        + volume
        + ", high="
        + high
        + ", low="
        + low
        + '}';
  }
}
