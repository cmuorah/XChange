package org.knowm.xchange.itbit.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItBitOrder {

  private final String id;
  private final String walletId;
  private final String side;
  private final String instrument;
  private final String currency;
  private final String type;
  private final String status;
  private final String createdTime;
  private final Double amountFilled;
  private final Double price;
  private final Double amount;
  private final Double volumeWeightedAveragePrice;

  public ItBitOrder(
      @JsonProperty("id") String id,
      @JsonProperty("walletId") String walletId,
      @JsonProperty("side") String side,
      @JsonProperty("instrument") String instrument,
      @JsonProperty("currency") String currency,
      @JsonProperty("type") String type,
      @JsonProperty("amount") Double amount,
      @JsonProperty("price") Double price,
      @JsonProperty("amountFilled") Double amountFilled,
      @JsonProperty("volumeWeightedAveragePrice") Double volumeWeightedAveragePrice,
      @JsonProperty("createdTime") String createdTime,
      @JsonProperty("status") String status) {

    this.id = id;
    this.walletId = walletId;
    this.side = side;
    this.instrument = instrument;
    this.currency = currency;
    this.type = type;
    this.amount = amount;
    this.price = price;
    this.amountFilled = amountFilled;
    this.createdTime = createdTime;
    this.status = status;
    this.volumeWeightedAveragePrice = volumeWeightedAveragePrice;
  }

  public String getId() {

    return id;
  }

  public String getWalletId() {

    return walletId;
  }

  public String getSide() {

    return side;
  }

  public String getInstrument() {

    return instrument;
  }

  public String getCurrency() {

    return currency;
  }

  public String getType() {

    return type;
  }

  public String getStatus() {

    return status;
  }

  public String getCreatedTime() {

    return createdTime;
  }

  public Double getAmountFilled() {

    return amountFilled;
  }

  public Double getPrice() {

    return price;
  }

  public Double getAmount() {

    return amount;
  }

  public Double getVolumeWeightedAveragePrice() {

    return volumeWeightedAveragePrice;
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    builder.append("ItBitAccountOrder [id=");
    builder.append(id);
    builder.append(", walletId=");
    builder.append(walletId);
    builder.append(", side=");
    builder.append(side);
    builder.append(", instrument=");
    builder.append(instrument);
    builder.append(", currency=");
    builder.append(currency);
    builder.append(", type=");
    builder.append(type);
    builder.append(", status=");
    builder.append(status);
    builder.append(", createdTime=");
    builder.append(createdTime);
    builder.append(", amountFilled=");
    builder.append(amountFilled);
    builder.append(", price=");
    builder.append(price);
    builder.append(", amount=");
    builder.append(amount);
    builder.append(", volumeWeightedAveragePrice=");
    builder.append(volumeWeightedAveragePrice);
    builder.append("]");
    return builder.toString();
  }
}
