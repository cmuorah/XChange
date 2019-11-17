package org.knowm.xchange.mercadobitcoin.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author Felipe Micaroni Lalli */
public final class OperationEntry {

  private final Double volume;
  private final Double price;
  private final Double rate;
  private final Long created;

  public OperationEntry(
      @JsonProperty("volume") Double volume,
      @JsonProperty("price") Double price,
      @JsonProperty("rate") Double rate,
      @JsonProperty("created") Long created) {

    this.volume = volume;
    this.price = price;
    this.rate = rate;
    this.created = created;
  }

  public Double getVolume() {

    return volume;
  }

  public Double getPrice() {

    return price;
  }

  public Double getRate() {

    return rate;
  }

  public Long getCreated() {

    return created;
  }

  @Override
  public String toString() {

    return "OperationEntry ["
        + "volume="
        + volume
        + ", price="
        + price
        + ", rate="
        + rate
        + ", created="
        + created
        + ']';
  }
}
