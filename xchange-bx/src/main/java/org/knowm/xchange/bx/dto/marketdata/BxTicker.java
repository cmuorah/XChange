package org.knowm.xchange.bx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BxTicker {

  private final String pairingId;
  private final String primaryCurrency;
  private final String secondaryCurrency;
  private final Double change;
  private final Double lastPrice;
  private final Double volume24hours;
  private final BxOrderBook orderBook;

  public BxTicker(
      @JsonProperty("pairing_id") String pairingId,
      @JsonProperty("primary_currency") String primaryCurrency,
      @JsonProperty("secondary_currency") String secondaryCurrency,
      @JsonProperty("change") Double change,
      @JsonProperty("last_price") Double lastPrice,
      @JsonProperty("volume_24hours") Double volume24hours,
      @JsonProperty("orderbook") BxOrderBook orderBook) {
    this.pairingId = pairingId;
    this.primaryCurrency = primaryCurrency;
    this.secondaryCurrency = secondaryCurrency;
    this.change = change;
    this.lastPrice = lastPrice;
    this.volume24hours = volume24hours;
    this.orderBook = orderBook;
  }

  public String getPairingId() {
    return pairingId;
  }

  public String getPrimaryCurrency() {
    return primaryCurrency;
  }

  public String getSecondaryCurrency() {
    return secondaryCurrency;
  }

  public Double getChange() {
    return change;
  }

  public Double getLastPrice() {
    return lastPrice;
  }

  public Double getVolume24hours() {
    return volume24hours;
  }

  public BxOrderBook getOrderBook() {
    return orderBook;
  }

  @Override
  public String toString() {
    return "BxTicker{"
        + "pairingId='"
        + pairingId
        + '\''
        + ", primaryCurrency='"
        + primaryCurrency
        + '\''
        + ", secondaryCurrency='"
        + secondaryCurrency
        + '\''
        + ", change="
        + change
        + ", lastPrice="
        + lastPrice
        + ", volume24hours="
        + volume24hours
        + ", orderBook="
        + orderBook
        + '}';
  }
}
