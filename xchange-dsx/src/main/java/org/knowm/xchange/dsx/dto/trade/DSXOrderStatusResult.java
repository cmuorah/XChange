package org.knowm.xchange.dsx.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

/** @author Mikhail Wall */
public class DSXOrderStatusResult {

  private final String pair;
  private final String type;
  private final Double remainingVolume;
  private final Double volume;
  private final Double rate;
  private final Long timestampCreated;
  private final Integer status;
  private final String orderType;
  private final ClientDeal[] deals;

  public DSXOrderStatusResult(
      @JsonProperty("pair") String pair,
      @JsonProperty("type") String type,
      @JsonProperty("remainingVolume") Double remainingVolume,
      @JsonProperty("volume") Double volume,
      @JsonProperty("rate") Double rate,
      @JsonProperty("timestampCreated") Long timestampCreated,
      @JsonProperty("status") Integer status,
      @JsonProperty("orderType") String orderType,
      @JsonProperty("clientDeals") ClientDeal[] deals) {
    this.pair = pair;
    this.type = type;
    this.remainingVolume = remainingVolume;
    this.volume = volume;
    this.rate = rate;
    this.timestampCreated = timestampCreated;
    this.status = status;
    this.orderType = orderType;
    this.deals = deals;
  }

  public String getPair() {
    return pair;
  }

  public String getType() {
    return type;
  }

  public Double getRemainingVolume() {
    return remainingVolume;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getRate() {
    return rate;
  }

  public Long getTimestampCreated() {
    return timestampCreated;
  }

  public Integer getStatus() {
    return status;
  }

  public String getOrderType() {
    return orderType;
  }

  public ClientDeal[] getDeals() {
    return deals;
  }

  @Override
  public String toString() {
    return "DSXOrderStatusResult{"
        + "pair='"
        + pair
        + '\''
        + ", type='"
        + type
        + '\''
        + ", remainingVolume="
        + remainingVolume
        + ", volume="
        + volume
        + ", rate="
        + rate
        + ", timestampCreated="
        + timestampCreated
        + ", status="
        + status
        + ", orderType='"
        + orderType
        + '\''
        + ", deals="
        + Arrays.toString(deals)
        + '}';
  }
}
