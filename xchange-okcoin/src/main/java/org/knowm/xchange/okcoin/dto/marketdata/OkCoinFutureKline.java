package org.knowm.xchange.okcoin.dto.marketdata;

import java.util.Date;

public class OkCoinFutureKline {
  protected Date closeTime;
  protected Double close;
  protected Double high;
  protected Double low;
  protected Double open;
  protected Double volume;
  protected Double quoteAssetVolume;

  public OkCoinFutureKline() {}

  public OkCoinFutureKline(Object[] kline) {
    if (kline[0] instanceof Long) {
      this.closeTime = new Date((Long) kline[0]);
    } else {
      this.closeTime = new Date(Long.valueOf((String) kline[0]));
    }
    this.open = new Double(String.valueOf(kline[1]));
    this.high = new Double(String.valueOf(kline[2]));
    this.low = new Double(String.valueOf(kline[3]));
    this.close = new Double(String.valueOf(kline[4]));
    this.volume = new Double(String.valueOf(kline[5]));
    this.quoteAssetVolume = new Double(String.valueOf(kline[6]));
  }

  public Date getCloseTime() {
    return closeTime;
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

  public Double getOpen() {
    return open;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getQuoteAssetVolume() {
    return quoteAssetVolume;
  }
}
