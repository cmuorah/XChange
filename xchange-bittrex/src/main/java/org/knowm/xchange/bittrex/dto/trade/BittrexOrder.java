package org.knowm.xchange.bittrex.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class BittrexOrder extends BittrexOrderBase {

  private final String accountId;
  private final Double reserved;
  private final Double reserveRemaining;
  private final Double commissionReserved;
  private final Double commissionReserveRemaining;
  private final Boolean isOpen;
  private final String sentinel;

  public BittrexOrder(
      @JsonProperty("AccountId") String accountId,
      @JsonProperty("OrderUuid") String orderUuid,
      @JsonProperty("Exchange") String exchange,
      @JsonProperty("Type") String type,
      @JsonProperty("Quantity") Double quantity,
      @JsonProperty("QuantityRemaining") Double quantityRemaining,
      @JsonProperty("Limit") Double limit,
      @JsonProperty("Reserved") Double reserved,
      @JsonProperty("ReserveRemaining") Double reserveRemaining,
      @JsonProperty("CommissionReserved") Double commissionReserved,
      @JsonProperty("CommissionReserveRemaining") Double commissionReserveRemaining,
      @JsonProperty("CommissionPaid") Double commissionPaid,
      @JsonProperty("Price") Double price,
      @JsonProperty("PricePerUnit") Double pricePerUnit,
      @JsonProperty("Opened") Date opened,
      @JsonProperty("Closed") Date closed,
      @JsonProperty("IsOpen") Boolean isOpen,
      @JsonProperty("Sentinel") String sentinel,
      @JsonProperty("CancelInitiated") Boolean cancelInitiated,
      @JsonProperty("ImmediateOrCancel") Boolean immediateOrCancel,
      @JsonProperty("IsConditional") Boolean isConditional,
      @JsonProperty("Condition") String condition,
      @JsonProperty("ConditionTarget") String conditionTarget) {
    super(
        orderUuid,
        exchange,
        type,
        quantity,
        quantityRemaining,
        limit,
        commissionPaid,
        price,
        pricePerUnit,
        opened,
        closed,
        cancelInitiated,
        immediateOrCancel,
        isConditional,
        condition,
        conditionTarget);
    this.accountId = accountId;
    this.reserved = reserved;
    this.reserveRemaining = reserveRemaining;
    this.commissionReserved = commissionReserved;
    this.commissionReserveRemaining = commissionReserveRemaining;
    this.isOpen = isOpen;
    this.sentinel = sentinel;
  }

  public String getAccountId() {
    return accountId;
  }

  public Double getReserved() {
    return reserved;
  }

  public Double getReserveRemaining() {
    return reserveRemaining;
  }

  public Double getCommissionReserved() {
    return commissionReserved;
  }

  public Double getCommissionReserveRemaining() {
    return commissionReserveRemaining;
  }

  public Boolean getOpen() {
    return isOpen;
  }

  public String getSentinel() {
    return sentinel;
  }

  @Override
  protected String additionalToString() {
    return "accountId="
        + accountId
        + ", reserved="
        + reserved
        + ", reserveRemaining="
        + reserveRemaining
        + ", commissionReserved="
        + commissionReserved
        + ", commissionReserveRemaining="
        + commissionReserveRemaining
        + ", isOpen="
        + isOpen
        + ", sentinel="
        + sentinel;
  }
}
