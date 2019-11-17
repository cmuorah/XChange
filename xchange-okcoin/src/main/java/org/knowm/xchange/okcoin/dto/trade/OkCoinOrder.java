package org.knowm.xchange.okcoin.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class OkCoinOrder {

  private final long orderId;

  private final int status;

  private final String symbol;

  private final String type;

  private final Double amount;

  private final Double dealAmount;

  private final Date createDate;

  private final Double price;

  private final Double averagePrice;

  public OkCoinOrder(
      @JsonProperty("order_id") final long orderId,
      @JsonProperty("status") final int status,
      @JsonProperty("symbol") final String symbol,
      @JsonProperty("type") final String type,
      @JsonProperty("price") final Double price,
      @JsonProperty("avg_price") final Double averagePrice,
      @JsonProperty("amount") final Double amount,
      @JsonProperty("deal_amount") final Double dealAmount,
      @JsonProperty("create_date") final Date createDate) {

    this.orderId = orderId;
    this.status = status;
    this.symbol = symbol;
    this.type = type;
    this.amount = amount;
    this.dealAmount = dealAmount;
    this.price = price;
    this.averagePrice = averagePrice;
    this.createDate = createDate;
  }

  public long getOrderId() {

    return orderId;
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

  public Double getAmount() {

    return amount;
  }

  public Double getDealAmount() {

    return dealAmount;
  }

  public Date getCreateDate() {

    return createDate;
  }

  public Double getPrice() {

    return price;
  }

  public Double getAveragePrice() {

    return averagePrice;
  }
}
