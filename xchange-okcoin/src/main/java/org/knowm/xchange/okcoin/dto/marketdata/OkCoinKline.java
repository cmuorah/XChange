package org.knowm.xchange.okcoin.dto.marketdata;

import java.util.Date;

public class OkCoinKline {
  protected Date date;
  protected Double open;
  protected Double height;
  protected Double low;
  protected Double close;
  protected Double amount;

  public OkCoinKline(Object[] kline) {
    this.date = new Date((long) kline[0]);
    this.open = new Double(String.valueOf(kline[1]));
    this.height = new Double(String.valueOf(kline[2]));
    this.low = new Double(String.valueOf(kline[3]));
    this.close = new Double(String.valueOf(kline[4]));
    this.amount = new Double(String.valueOf(kline[5]));
  }

  public OkCoinKline() {}

  public Date getDate() {
    return date;
  }

  public Double getOpen() {
    return open;
  }

  public Double getHeight() {
    return height;
  }

  public Double getLow() {
    return low;
  }

  public Double getClose() {
    return close;
  }

  public Double getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return "OkCoinKline{"
        + "date="
        + date
        + ", open="
        + open
        + ", height="
        + height
        + ", low="
        + low
        + ", close="
        + close
        + ", amount="
        + amount
        + '}';
  }
}
