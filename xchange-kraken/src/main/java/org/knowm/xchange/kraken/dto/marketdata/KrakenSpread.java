package org.knowm.xchange.kraken.dto.marketdata;

public class KrakenSpread {

  private final long time;
  private final Double bid;
  private final Double ask;

  public KrakenSpread(long time, Double bid, Double ask) {

    this.time = time;
    this.bid = bid;
    this.ask = ask;
  }

  public long getTime() {

    return time;
  }

  public Double getBid() {

    return bid;
  }

  public Double getAsk() {

    return ask;
  }

  @Override
  public String toString() {

    return "KrakenSpread [time=" + time + ", bid=" + bid + ", ask=" + ask + "]";
  }
}
