package org.knowm.xchange.itbit.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItBitTrade {

  private final Double amount;
  private final String timestamp;
  private final Double price;
  private final long matchNumber;

  public ItBitTrade(
      @JsonProperty("amount") Double amount,
      @JsonProperty("timestamp") String timestamp,
      @JsonProperty("price") Double price,
      @JsonProperty("matchNumber") long matchNumber) {

    this.amount = amount;
    this.timestamp = timestamp;
    this.price = price;
    this.matchNumber = matchNumber;
  }

  public Double getAmount() {

    return amount;
  }

  public String getTimestamp() {

    return timestamp;
  }

  public Double getPrice() {

    return price;
  }

  public long getMatchNumber() {

    return matchNumber;
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    builder.append("ItBitTrade [amount=");
    builder.append(amount);
    builder.append(", timestamp=");
    builder.append(timestamp);
    builder.append(", price=");
    builder.append(price);
    builder.append(", matchNumber=");
    builder.append(matchNumber);
    builder.append("]");
    return builder.toString();
  }
}
