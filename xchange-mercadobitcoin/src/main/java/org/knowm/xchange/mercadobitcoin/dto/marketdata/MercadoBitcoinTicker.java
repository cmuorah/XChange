package org.knowm.xchange.mercadobitcoin.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author Felipe Micaroni Lalli */
public class MercadoBitcoinTicker {

  private final MercadoBitcoinTicker.Ticker ticker;

  public MercadoBitcoinTicker(@JsonProperty("ticker") MercadoBitcoinTicker.Ticker ticker) {

    this.ticker = ticker;
  }

  public Ticker getTicker() {

    return ticker;
  }

  @Override
  public String toString() {

    return "MercadoBitcoinTicker [ticker=" + ticker + "]";
  }

  public static class Ticker {

    private final Double last;
    private final Double high;
    private final Double low;
    private final Double vol;
    private final Double buy;
    private final Double sell;
    private final long date;

    public Ticker(
        @JsonProperty("last") Double last,
        @JsonProperty("high") Double high,
        @JsonProperty("low") Double low,
        @JsonProperty("vol") Double vol,
        @JsonProperty("buy") Double buy,
        @JsonProperty("sell") Double sell,
        @JsonProperty("date") long date) {

      this.last = last;
      this.high = high;
      this.low = low;
      this.vol = vol;
      this.buy = buy;
      this.sell = sell;
      this.date = date;
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

    public Double getVol() {

      return vol;
    }

    public Double getBuy() {

      return buy;
    }

    public Double getSell() {

      return sell;
    }

    public long getDate() {

      return date;
    }

    @Override
    public String toString() {

      return "Ticker ["
          + "last="
          + last
          + ", high="
          + high
          + ", low="
          + low
          + ", vol="
          + vol
          + ", buy="
          + buy
          + ", sell="
          + sell
          + ", date="
          + date
          + ']';
    }
  }
}
