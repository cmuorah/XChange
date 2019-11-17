package org.knowm.xchange.koineks.dto.marketdata;

import org.knowm.xchange.currency.Currency;

/** Created by semihunaldi on 05/12/2017 */
public abstract class BaseKoineksTicker {

  private final Currency shortCode;

  private final String name;

  private final Currency currency;

  private final Double current;

  private final String changeAmount;

  private final Double changePercentage;

  private final Double high;

  private final Double low;

  private final Double volume;

  private final Double ask;

  private final Double bid;

  private final String timestamp;

  public BaseKoineksTicker(
      Currency shortCode,
      String name,
      Currency currency,
      Double current,
      String changeAmount,
      Double changePercentage,
      Double high,
      Double low,
      Double volume,
      Double ask,
      Double bid,
      String timestamp) {
    this.shortCode = shortCode;
    this.name = name;
    this.currency = currency;
    this.current = current;
    this.changeAmount = changeAmount;
    this.changePercentage = changePercentage;
    this.high = high;
    this.low = low;
    this.volume = volume;
    this.ask = ask;
    this.bid = bid;
    this.timestamp = timestamp;
  }

  public Currency getShortCode() {
    return shortCode;
  }

  public String getName() {
    return name;
  }

  public Currency getCurrency() {
    return currency;
  }

  public Double getCurrent() {
    return current;
  }

  public String getChangeAmount() {
    return changeAmount;
  }

  public Double getChangePercentage() {
    return changePercentage;
  }

  public Double getHigh() {
    return high;
  }

  public Double getLow() {
    return low;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getAsk() {
    return ask;
  }

  public Double getBid() {
    return bid;
  }

  public String getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName()
        + " {"
        + "shortCode="
        + shortCode
        + ", name='"
        + name
        + '\''
        + ", currency="
        + currency
        + ", current="
        + current
        + ", changeAmount='"
        + changeAmount
        + '\''
        + ", changePercentage="
        + changePercentage
        + ", high="
        + high
        + ", low="
        + low
        + ", volume="
        + volume
        + ", ask="
        + ask
        + ", bid="
        + bid
        + ", timestamp="
        + timestamp
        + '}'
        + "\n\n";
  }
}
