package org.knowm.xchange.binance.dto.marketdata;

import java.text.SimpleDateFormat;
import org.knowm.xchange.currency.CurrencyPair;

public final class BinanceKline {

  private final CurrencyPair pair;
  private final KlineInterval interval;
  private final long openTime;
  private final Double open;
  private final Double high;
  private final Double low;
  private final Double close;
  private final Double volume;
  private final long closeTime;
  private final Double quoteAssetVolume;
  private final long numberOfTrades;
  private final Double takerBuyBaseAssetVolume;
  private final Double takerBuyQuoteAssetVolume;

  public BinanceKline(CurrencyPair pair, KlineInterval interval, Object[] obj) {
    this.pair = pair;
    this.interval = interval;
    this.openTime = Long.parseLong(obj[0].toString());
    this.open = new Double(obj[1].toString());
    this.high = new Double(obj[2].toString());
    this.low = new Double(obj[3].toString());
    this.close = new Double(obj[4].toString());
    this.volume = new Double(obj[5].toString());
    this.closeTime = Long.parseLong(obj[6].toString());
    this.quoteAssetVolume = new Double(obj[7].toString());
    this.numberOfTrades = Long.parseLong(obj[8].toString());
    this.takerBuyBaseAssetVolume = new Double(obj[9].toString());
    this.takerBuyQuoteAssetVolume = new Double(obj[10].toString());
  }

  public CurrencyPair getCurrencyPair() {
    return pair;
  }

  public KlineInterval getInterval() {
    return interval;
  }

  public long getOpenTime() {
    return openTime;
  }

  public Double getOpenPrice() {
    return open;
  }

  public Double getHighPrice() {
    return high;
  }

  public Double getLowPrice() {
    return low;
  }

  public Double getAveragePrice() {
    return (low + high) / 2d;
  }

  public Double getClosePrice() {
    return close;
  }

  public Double getVolume() {
    return volume;
  }

  public long getCloseTime() {
    return closeTime;
  }

  public Double getQuoteAssetVolume() {
    return quoteAssetVolume;
  }

  public long getNumberOfTrades() {
    return numberOfTrades;
  }

  public Double getTakerBuyBaseAssetVolume() {
    return takerBuyBaseAssetVolume;
  }

  public Double getTakerBuyQuoteAssetVolume() {
    return takerBuyQuoteAssetVolume;
  }

  public String toString() {
    String tstamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(openTime);
    return String.format(
        "[%s] %s %s O:%.6f A:%.6f C:%.6f", pair, tstamp, interval, open, getAveragePrice(), close);
  }
}
