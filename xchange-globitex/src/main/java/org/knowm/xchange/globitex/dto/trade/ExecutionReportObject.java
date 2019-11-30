package org.knowm.xchange.globitex.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.openhft.chronicle.wire.AbstractMarshallable;

import java.io.Serializable;

public class ExecutionReportObject extends AbstractMarshallable implements Serializable {

  @JsonProperty("orderId")
  private final String orderId;

  @JsonProperty("clientOrderId")
  private final String clientOrderId;

  @JsonProperty("orderStatus")
  private final String orderStatus;

  @JsonProperty("symbol")
  private final String symbol;

  @JsonProperty("side")
  private final String side;

  @JsonProperty("price")
  private final Double price;

  @JsonProperty("quantity")
  private final Double quantity;

  @JsonProperty("type")
  private final String type;

  @JsonProperty("timeInForce")
  private final String timeInForce;

  @JsonProperty("lastQuantity")
  private final Double lastQuantity;

  @JsonProperty("lastPrice")
  private final Double lastPrice;

  @JsonProperty("leavesQuantity")
  private final Double leavesQuantity;

  @JsonProperty("cumQuantity")
  private final Double cumQuantity;

  @JsonProperty("averagePrice")
  private final Double averagePrice;

  @JsonProperty("created")
  private final long created;

  @JsonProperty("execReportType")
  private final String execReportType;

  @JsonProperty("lastTimestamp")
  private final long lastTimestamp;

  @JsonProperty("account")
  private final String account;

  @JsonProperty("orderSource")
  private final String orderSource;

  public ExecutionReportObject(
      @JsonProperty("orderId") String orderId,
      @JsonProperty("clientOrderId") String clientOrderId,
      @JsonProperty("orderStatus") String orderStatus,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("side") String side,
      @JsonProperty("price") Double price,
      @JsonProperty("quantity") Double quantity,
      @JsonProperty("type") String type,
      @JsonProperty("timeInForce") String timeInForce,
      @JsonProperty("lastQuantity") Double lastQuantity,
      @JsonProperty("lastPrice") Double lastPrice,
      @JsonProperty("leavesQuantity") Double leavesQuantity,
      @JsonProperty("cumQuantity") Double cumQuantity,
      @JsonProperty("averagePrice") Double averagePrice,
      @JsonProperty("created") long created,
      @JsonProperty("execReportType") String execReportType,
      @JsonProperty("lastTimestamp") long lastTimestamp,
      @JsonProperty("account") String account,
      @JsonProperty("orderSource") String orderSource) {
    super();
    this.orderId = orderId;
    this.clientOrderId = clientOrderId;
    this.orderStatus = orderStatus;
    this.symbol = symbol;
    this.side = side;
    this.price = price;
    this.quantity = quantity;
    this.type = type;
    this.timeInForce = timeInForce;
    this.lastQuantity = lastQuantity;
    this.lastPrice = lastPrice;
    this.leavesQuantity = leavesQuantity;
    this.cumQuantity = cumQuantity;
    this.averagePrice = averagePrice;
    this.created = created;
    this.execReportType = execReportType;
    this.lastTimestamp = lastTimestamp;
    this.account = account;
    this.orderSource = orderSource;
  }

  public String getOrderId() {
    return orderId;
  }

  public String getClientOrderId() {
    return clientOrderId;
  }

  public String getOrderStatus() {
    return orderStatus;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getSide() {
    return side;
  }

  public Double getPrice() {
    return price;
  }

  public Double getQuantity() {
    return quantity;
  }

  public String getType() {
    return type;
  }

  public String getTimeInForce() {
    return timeInForce;
  }

  public Double getLastQuantity() {
    return lastQuantity;
  }

  public Double getLastPrice() {
    return lastPrice;
  }

  public Double getLeavesQuantity() {
    return leavesQuantity;
  }

  public Double getCumQuantity() {
    return cumQuantity;
  }

  public Double getAveragePrice() {
    return averagePrice;
  }

  public long getCreated() {
    return created;
  }

  public String getExecReportType() {
    return execReportType;
  }

  public long getLastTimestamp() {
    return lastTimestamp;
  }

  public String getAccount() {
    return account;
  }

  public String getOrderSource() {
    return orderSource;
  }

  @Override
  public String toString() {
    return "ExecutionReportObject{"
        + "orderId='"
        + orderId
        + '\''
        + ", clientOrderId='"
        + clientOrderId
        + '\''
        + ", orderStatus='"
        + orderStatus
        + '\''
        + ", symbol='"
        + symbol
        + '\''
        + ", side='"
        + side
        + '\''
        + ", price='"
        + price
        + '\''
        + ", quantity='"
        + quantity
        + '\''
        + ", type='"
        + type
        + '\''
        + ", timeInForce='"
        + timeInForce
        + '\''
        + ", lastQuantity='"
        + lastQuantity
        + '\''
        + ", lastPrice='"
        + lastPrice
        + '\''
        + ", leavesQuantity='"
        + leavesQuantity
        + '\''
        + ", cumQuantity='"
        + cumQuantity
        + '\''
        + ", averagePrice='"
        + averagePrice
        + '\''
        + ", created="
        + created
        + ", execReportType='"
        + execReportType
        + '\''
        + ", timestamp="
        + lastTimestamp
        + ", account='"
        + account
        + '\''
        + ", orderSource='"
        + orderSource
        + '\''
        + '}';
  }
}
