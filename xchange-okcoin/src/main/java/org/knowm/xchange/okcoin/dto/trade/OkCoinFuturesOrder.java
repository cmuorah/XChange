package org.knowm.xchange.okcoin.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class OkCoinFuturesOrder {

  private final Double amount;
  private final String contractName;
  private final Date createdDate;
  private final Double dealAmount;
  private final Double fee;
  private final String orderId;
  private final Double price;
  private final Double avgPrice;
  private final int status;
  private final String symbol;
  private final String type;
  private final Double unitAmount;
  private final int leverRate;

  public OkCoinFuturesOrder(
      @JsonProperty("amount") Double amount,
      @JsonProperty("contract_name") String contractName,
      @JsonProperty("create_date") Date createdDate,
      @JsonProperty("deal_amount") Double dealAmount,
      @JsonProperty("fee") Double fee,
      @JsonProperty("order_id") String orderId,
      @JsonProperty("price") Double price,
      @JsonProperty("price_avg") Double avgPrice,
      @JsonProperty("status") int status,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("type") String type,
      @JsonProperty("unit_amount") Double unitAmount,
      @JsonProperty("lever_rate") int leverRate) {

    this.amount = amount;
    this.contractName = contractName;
    this.createdDate = createdDate;
    this.dealAmount = dealAmount;
    this.fee = fee;
    this.orderId = orderId;
    this.price = price;
    this.avgPrice = avgPrice;
    this.status = status;
    this.symbol = symbol;
    this.type = type;
    this.unitAmount = unitAmount;
    this.leverRate = leverRate;
  }

  public Double getAmount() {

    return amount;
  }

  public String getContractName() {

    return contractName;
  }

  public Date getCreatedDate() {

    return createdDate;
  }

  public Double getDealAmount() {

    return dealAmount;
  }

  public Double getFee() {

    return fee;
  }

  public String getOrderId() {

    return orderId;
  }

  public Double getPrice() {

    return price;
  }

  public Double getAvgPrice() {

    return avgPrice;
  }

  public int getStatus() {

    return status;
  }

  public String getSymbol() {

    return symbol;
  }

  public String getType() {

    return type;
  }

  public Double getUnitAmount() {

    return unitAmount;
  }

  public int getLeverRate() {

    return leverRate;
  }

  @Override
  public String toString() {
    return "OkCoinFuturesOrder{"
        + "amount="
        + amount
        + ", contractName='"
        + contractName
        + '\''
        + ", createdDate="
        + createdDate
        + ", dealAmount="
        + dealAmount
        + ", fee="
        + fee
        + ", orderId='"
        + orderId
        + '\''
        + ", price="
        + price
        + ", avgPrice="
        + avgPrice
        + ", status="
        + status
        + ", symbol='"
        + symbol
        + '\''
        + ", type='"
        + type
        + '\''
        + ", unitAmount="
        + unitAmount
        + ", leverRate="
        + leverRate
        + '}';
  }
}
