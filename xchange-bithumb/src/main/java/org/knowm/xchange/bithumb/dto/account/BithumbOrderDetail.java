package org.knowm.xchange.bithumb.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BithumbOrderDetail {

  private final long transactionDate;
  private final String type;
  private final String orderCurrency;
  private final String paymentCurrency;
  private final Double unitsTraded;
  private final Double price;
  private final Double fee;
  private final Double total;

  public BithumbOrderDetail(
      @JsonProperty("transaction_date") long transactionDate,
      @JsonProperty("type") String type,
      @JsonProperty("order_currency") String orderCurrency,
      @JsonProperty("payment_currency") String paymentCurrency,
      @JsonProperty("units_traded") Double unitsTraded,
      @JsonProperty("price") Double price,
      @JsonProperty("fee") Double fee,
      @JsonProperty("total") Double total) {
    this.transactionDate = transactionDate;
    this.type = type;
    this.orderCurrency = orderCurrency;
    this.paymentCurrency = paymentCurrency;
    this.unitsTraded = unitsTraded;
    this.price = price;
    this.fee = fee;
    this.total = total;
  }

  public long getTransactionDate() {
    return transactionDate;
  }

  public String getType() {
    return type;
  }

  public String getOrderCurrency() {
    return orderCurrency;
  }

  public String getPaymentCurrency() {
    return paymentCurrency;
  }

  public Double getUnitsTraded() {
    return unitsTraded;
  }

  public Double getPrice() {
    return price;
  }

  public Double getFee() {
    return fee;
  }

  public Double getTotal() {
    return total;
  }

  @Override
  public String toString() {
    return "BithumbOrderDetail{"
        + "transactionDate="
        + transactionDate
        + ", type='"
        + type
        + '\''
        + ", orderCurrency='"
        + orderCurrency
        + '\''
        + ", paymentCurrency='"
        + paymentCurrency
        + '\''
        + ", unitsTraded="
        + unitsTraded
        + ", price="
        + price
        + ", fee="
        + fee
        + ", total="
        + total
        + '}';
  }
}
