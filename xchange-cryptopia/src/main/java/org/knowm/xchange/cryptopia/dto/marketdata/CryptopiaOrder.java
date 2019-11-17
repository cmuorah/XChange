package org.knowm.xchange.cryptopia.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class CryptopiaOrder {

  private final long tradePairId;
  private final String label;
  private final Double price;
  private final Double volume;
  private final Double total;

  public CryptopiaOrder(
      @JsonProperty("TradePairId") long tradePairId,
      @JsonProperty("Label") String label,
      @JsonProperty("Price") Double price,
      @JsonProperty("Volume") Double volume,
      @JsonProperty("Total") Double total) {
    this.tradePairId = tradePairId;
    this.label = label;
    this.price = price;
    this.volume = volume;
    this.total = total;
  }

  public long getTradePairId() {
    return tradePairId;
  }

  public String getLabel() {
    return label;
  }

  public Double getPrice() {
    return price;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getTotal() {
    return total;
  }

  @Override
  public String toString() {
    return "Order{"
        + "tradePairId="
        + tradePairId
        + ", label='"
        + label
        + '\''
        + ", price="
        + price
        + ", volume="
        + volume
        + ", total="
        + total
        + '}';
  }
}
