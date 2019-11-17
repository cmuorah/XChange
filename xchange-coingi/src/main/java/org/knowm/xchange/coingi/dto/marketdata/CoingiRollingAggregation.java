package org.knowm.xchange.coingi.dto.marketdata;

import java.util.Objects;

/** A currency pair rolling aggregation. */
public class CoingiRollingAggregation {

  private CoingiAggregationCurrencyPair currencyPair;

  private Double last;

  private Double lowestAsk;

  private Double highestBid;

  private Double baseVolume;

  private Double counterVolume;

  private Double high;

  private Double low;

  public CoingiRollingAggregation(
      CoingiAggregationCurrencyPair currencyPair,
      Double last,
      Double lowestAsk,
      Double highestBid,
      Double baseVolume,
      Double counterVolume,
      Double high,
      Double low) {
    this.currencyPair = Objects.requireNonNull(currencyPair);
    this.last = Objects.requireNonNull(last);
    this.lowestAsk = Objects.requireNonNull(lowestAsk);
    this.highestBid = Objects.requireNonNull(highestBid);
    this.baseVolume = Objects.requireNonNull(baseVolume);
    this.counterVolume = Objects.requireNonNull(counterVolume);
    this.high = Objects.requireNonNull(high);
    this.low = Objects.requireNonNull(low);
  }

  CoingiRollingAggregation() {}

  public CoingiAggregationCurrencyPair getCurrencyPair() {
    return currencyPair;
  }

  public Double getLast() {
    return last;
  }

  public Double getLowestAsk() {
    return lowestAsk;
  }

  public Double getHighestBid() {
    return highestBid;
  }

  public Double getBaseVolume() {
    return baseVolume;
  }

  public Double getCounterVolume() {
    return counterVolume;
  }

  public Double getHigh() {
    return high;
  }

  public Double getLow() {
    return low;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CoingiRollingAggregation that = (CoingiRollingAggregation) o;
    return Objects.equals(currencyPair, that.currencyPair)
        && Objects.equals(last, that.last)
        && Objects.equals(lowestAsk, that.lowestAsk)
        && Objects.equals(highestBid, that.highestBid)
        && Objects.equals(baseVolume, that.baseVolume)
        && Objects.equals(counterVolume, that.counterVolume)
        && Objects.equals(high, that.high)
        && Objects.equals(low, that.low);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        currencyPair, last, lowestAsk, highestBid, baseVolume, counterVolume, high, low);
  }
}
