package org.knowm.xchange.coinmarketcap.deprecated.v2.dto.marketdata;

import java.util.Date;

/** @author allenday */
public class CoinMarketCapHistoricalSpotPrice
    implements Comparable<CoinMarketCapHistoricalSpotPrice> {

  private final Date timestamp;
  private final Double spotRate;

  CoinMarketCapHistoricalSpotPrice(Date timestamp, final Double spotRate) {
    this.timestamp = timestamp;
    this.spotRate = spotRate;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public Double getSpotRate() {
    return spotRate;
  }

  @Override
  public String toString() {
    return "CoinbaseHistoricalPrice [timestamp=" + timestamp + ", spotRate=" + spotRate + "]";
  }

  @Override
  public int compareTo(CoinMarketCapHistoricalSpotPrice o) {

    return this.timestamp.compareTo(o.timestamp);
  }
}
