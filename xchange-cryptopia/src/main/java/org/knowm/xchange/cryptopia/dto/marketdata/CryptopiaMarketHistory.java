package org.knowm.xchange.cryptopia.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class CryptopiaMarketHistory {

  private final long tradePairId;
  private final String label;
  private final String type;
  private final Double price;
  private final Double amount;
  private final Double total;
  private final long timestamp;

  public CryptopiaMarketHistory(
      @JsonProperty("TradePairId") long tradePairId,
      @JsonProperty("Label") String label,
      @JsonProperty("Type") String type,
      @JsonProperty("Price") Double price,
      @JsonProperty("Amount") Double amount,
      @JsonProperty("Total") Double total,
      @JsonProperty("Timestamp") long timestamp) {
    this.tradePairId = tradePairId;
    this.label = label;
    this.type = type;
    this.price = price;
    this.amount = amount;
    this.total = total;
    this.timestamp = timestamp;
  }

  public long getTradePairId() {
    return tradePairId;
  }

  public String getLabel() {
    return label;
  }

  public String getType() {
    return type;
  }

  public Double getPrice() {
    return price;
  }

  public Double getAmount() {
    return amount;
  }

  public Double getTotal() {
    return total;
  }

  public long getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return "CryptopiaMarketHistory{"
        + "tradePairId="
        + tradePairId
        + ", label='"
        + label
        + '\''
        + ", type='"
        + type
        + '\''
        + ", price="
        + price
        + ", amount="
        + amount
        + ", total="
        + total
        + ", timestamp="
        + timestamp
        + '}';
  }
}
