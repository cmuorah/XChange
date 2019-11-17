package org.knowm.xchange.independentreserve.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class IndependentReserveOrderDetailsResponse {
  private final Double avgPrice;
  private final Date createdTimestamp;
  private final String orderGuid;
  private final String orderType;
  private final Double price;
  private final String primaryCurrencyCode;
  private final String secondaryCurrencyCode;
  private final String status;
  private final Double volumeOrdered;
  private final Double volumeFilled;
  private final Double reservedAmount;

  public IndependentReserveOrderDetailsResponse(
      @JsonProperty("OrderGuid") String orderGuid,
      @JsonProperty("CreatedTimestampUtc") String createdTimestampUtc,
      @JsonProperty("Type") String orderType,
      @JsonProperty("VolumeOrdered") Double volumeOrdered,
      @JsonProperty("VolumeFilled") Double volumeFilled,
      @JsonProperty("Price") Double price,
      @JsonProperty("AvgPrice") Double avgPrice,
      @JsonProperty("ReservedAmount") Double reservedAmount,
      @JsonProperty("Status") String status,
      @JsonProperty("PrimaryCurrencyCode") String primaryCurrencyCode,
      @JsonProperty("SecondaryCurrencyCode") String secondaryCurrencyCode)
      throws com.fasterxml.jackson.databind.exc.InvalidFormatException {

    this.orderGuid = orderGuid;
    this.createdTimestamp =
        org.knowm.xchange.utils.DateUtils.fromISO8601DateString(createdTimestampUtc);
    this.orderType = orderType;
    this.volumeOrdered = volumeOrdered;
    this.volumeFilled = volumeFilled;
    this.price = price;
    this.avgPrice = avgPrice;
    this.reservedAmount = reservedAmount;
    this.status = status;
    this.primaryCurrencyCode = primaryCurrencyCode;
    this.secondaryCurrencyCode = secondaryCurrencyCode;
  }

  public Double getAvgPrice() {
    return avgPrice;
  }

  public Date getCreatedTimestamp() {
    return createdTimestamp;
  }

  public String getOrderGuid() {
    return orderGuid;
  }

  public String getOrderType() {
    return orderType;
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

  public Double getVolumeOrdered() {
    return volumeOrdered;
  }

  public Double getVolumeFilled() {
    return volumeFilled;
  }

  public Double getReservedAmount() {
    return reservedAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    IndependentReserveOrderDetailsResponse that = (IndependentReserveOrderDetailsResponse) o;

    return new EqualsBuilder()
        .append(avgPrice, that.avgPrice)
        .append(createdTimestamp, that.createdTimestamp)
        .append(orderGuid, that.orderGuid)
        .append(orderType, that.orderType)
        .append(price, that.price)
        .append(primaryCurrencyCode, that.primaryCurrencyCode)
        .append(secondaryCurrencyCode, that.secondaryCurrencyCode)
        .append(status, that.status)
        .append(volumeOrdered, that.volumeOrdered)
        .append(volumeFilled, that.volumeFilled)
        .append(reservedAmount, that.reservedAmount)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(avgPrice)
        .append(createdTimestamp)
        .append(orderGuid)
        .append(orderType)
        .append(price)
        .append(primaryCurrencyCode)
        .append(secondaryCurrencyCode)
        .append(status)
        .append(volumeOrdered)
        .append(volumeFilled)
        .append(reservedAmount)
        .toHashCode();
  }

  @Override
  public String toString() {
    return "IndependentReserveOrderDetails{"
        + "avgPrice="
        + avgPrice
        + ", createdTimestamp="
        + createdTimestamp
        + ", orderGuid='"
        + orderGuid
        + '\''
        + ", orderType='"
        + orderType
        + '\''
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
        + ", volumeOrdered="
        + volumeOrdered
        + ", volumeFilled="
        + volumeFilled
        + ", reservedAmount="
        + reservedAmount
        + '}';
  }
}
