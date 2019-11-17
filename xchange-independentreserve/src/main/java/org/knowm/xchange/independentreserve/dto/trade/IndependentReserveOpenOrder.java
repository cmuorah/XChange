package org.knowm.xchange.independentreserve.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/** Author: Kamil Zbikowski Date: 4/15/15 */
public class IndependentReserveOpenOrder {
  private final Double avgPrice;
  private final Date createdTimestamp;
  private final Double feePercent;
  private final String orderGuid;
  private final String orderType;
  private final Double outstanding;
  private final Double price;
  private final String primaryCurrencyCode;
  private final String secondaryCurrencyCode;
  private final String status;
  private final Double value;
  private final Double volume;

  public IndependentReserveOpenOrder(
      @JsonProperty("AvgPrice") Double avgPrice,
      @JsonProperty("CreatedTimestampUtc") String createdTimestampUtc,
      @JsonProperty("FeePercent") Double feePercent,
      @JsonProperty("OrderGuid") String orderGuid,
      @JsonProperty("OrderType") String orderType,
      @JsonProperty("Outstanding") Double outstanding,
      @JsonProperty("Price") Double price,
      @JsonProperty("PrimaryCurrencyCode") String primaryCurrencyCode,
      @JsonProperty("SecondaryCurrencyCode") String secondaryCurrencyCode,
      @JsonProperty("Status") String status,
      @JsonProperty("Value") Double value,
      @JsonProperty("Volume") Double volume)
      throws com.fasterxml.jackson.databind.exc.InvalidFormatException {
    this.avgPrice = avgPrice;
    this.createdTimestamp =
        org.knowm.xchange.utils.DateUtils.fromISO8601DateString(createdTimestampUtc);
    this.feePercent = feePercent;
    this.orderGuid = orderGuid;
    this.orderType = orderType;
    this.outstanding = outstanding;
    this.price = price;
    this.primaryCurrencyCode = primaryCurrencyCode;
    this.secondaryCurrencyCode = secondaryCurrencyCode;
    this.status = status;
    this.value = value;
    this.volume = volume;
  }

  public Double getAvgPrice() {
    return avgPrice;
  }

  public Date getCreatedTimestamp() {
    return createdTimestamp;
  }

  public Double getFeePercent() {
    return feePercent;
  }

  public String getOrderGuid() {
    return orderGuid;
  }

  public String getOrderType() {
    return orderType;
  }

  public Double getOutstanding() {
    return outstanding;
  }

  public Double getPrice() {
    return price;
  }

  public String getPrimaryCurrencyCode() {
    return primaryCurrencyCode;
  }

  public String getSecondaryCurrencyCode() {
    return secondaryCurrencyCode;
  }

  public String getStatus() {
    return status;
  }

  public Double getValue() {
    return value;
  }

  public Double getVolume() {
    return volume;
  }

  @Override
  public String toString() {
    return "IndependentReserveOpenOrder{"
        + "avgPrice="
        + avgPrice
        + ", createdTimestamp="
        + createdTimestamp
        + ", feePercent="
        + feePercent
        + ", orderGuid='"
        + orderGuid
        + '\''
        + ", orderType='"
        + orderType
        + '\''
        + ", outstanding="
        + outstanding
        + ", price="
        + price
        + ", primaryCurrencyCode='"
        + primaryCurrencyCode
        + '\''
        + ", secondaryCurrencyCode='"
        + secondaryCurrencyCode
        + '\''
        + ", status='"
        + status
        + '\''
        + ", value="
        + value
        + ", volume="
        + volume
        + '}';
  }
}
