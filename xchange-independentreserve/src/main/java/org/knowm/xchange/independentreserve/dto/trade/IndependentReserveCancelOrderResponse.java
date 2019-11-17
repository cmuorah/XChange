package org.knowm.xchange.independentreserve.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/** Author: Kamil Zbikowski Date: 4/15/15 */
public class IndependentReserveCancelOrderResponse {
  private final Date createdTimestampUtc;
  private final String orderGuid;
  private final Double price;
  private final String primaryCurrencyCode;
  private final Double reservedAmount;
  private final String secondaryCurrencyCode;
  private final String status;
  private final String type;
  private final Double volumeFilled;
  private final Double volumeOrdered;

  public IndependentReserveCancelOrderResponse(
      @JsonProperty("CreatedTimestampUtc") Date createdTimestampUtc,
      @JsonProperty("OrderGuid") String orderGuid,
      @JsonProperty("Price") Double price,
      @JsonProperty("PrimaryCurrencyCode") String primaryCurrencyCode,
      @JsonProperty("ReservedAmount") Double reservedAmount,
      @JsonProperty("SecondaryCurrencyCode") String secondaryCurrencyCode,
      @JsonProperty("Status") String status,
      @JsonProperty("Type") String type,
      @JsonProperty("VolumeFilled") Double volumeFilled,
      @JsonProperty("VolumeOrdered") Double volumeOrdered) {

    this.createdTimestampUtc = createdTimestampUtc;
    this.orderGuid = orderGuid;
    this.price = price;
    this.primaryCurrencyCode = primaryCurrencyCode;
    this.reservedAmount = reservedAmount;
    this.secondaryCurrencyCode = secondaryCurrencyCode;
    this.status = status;
    this.type = type;
    this.volumeFilled = volumeFilled;
    this.volumeOrdered = volumeOrdered;
  }

  public Date getCreatedTimestampUtc() {
    return createdTimestampUtc;
  }

  public String getOrderGuid() {
    return orderGuid;
  }

  public Double getPrice() {
    return price;
  }

  public String getPrimaryCurrencyCode() {
    return primaryCurrencyCode;
  }

  public Double getReservedAmount() {
    return reservedAmount;
  }

  public String getSecondaryCurrencyCode() {
    return secondaryCurrencyCode;
  }

  public String getStatus() {
    return status;
  }

  public String getType() {
    return type;
  }

  public Double getVolumeFilled() {
    return volumeFilled;
  }

  public Double getVolumeOrdered() {
    return volumeOrdered;
  }
}
