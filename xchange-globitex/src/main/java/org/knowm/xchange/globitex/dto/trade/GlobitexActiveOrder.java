package org.knowm.xchange.globitex.dto.trade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.openhft.chronicle.wire.AbstractMarshallable;

import java.io.Serializable;

public class GlobitexActiveOrder extends AbstractMarshallable implements Serializable {

  @JsonProperty("orderId")
  private final String orderId;

  @JsonProperty("orderStatus")
  private final String orderStatus;

  @JsonProperty("lastTimestamp")
  private final long lastTimestamp;

  @JsonProperty("orderPrice")
  private final Double orderPrice;

  @JsonProperty("orderQuantity")
  private final Double orderQuantity;

  @JsonProperty("avgPrice")
  private final Double avgPrice;

  @JsonProperty("type")
  private final String type;

  @JsonProperty("timeInForce")
  private final String timeInForce;

  @JsonProperty("clientOrderId")
  private final String clientOrderId;

  @JsonProperty("symbol")
  private final String symbol;

  @JsonProperty("side")
  private final String side;

  @JsonProperty("account")
  private final String account;

  @JsonProperty("orderSource")
  private final String orderSource;

  @JsonProperty("leavesQuantity")
  private final Double leavesQuantity;

  @JsonProperty("cumQuantity")
  private final Double cumQuantity;

  @JsonProperty("execQuantity")
  private final Double execQuantity;

  @JsonProperty("stopPrice")
  @JsonIgnore
  private final Double stopPrice;

  @JsonProperty("expireTime")
  @JsonIgnore
  private final long expireTime;

  public GlobitexActiveOrder(
      @JsonProperty("orderId") String orderId,
      @JsonProperty("orderStatus") String orderStatus,
      @JsonProperty("lastTimestamp") long lastTimestamp,
      @JsonProperty("orderPrice") Double orderPrice,
      @JsonProperty("orderQuantity") Double orderQuantity,
      @JsonProperty("avgPrice") Double avgPrice,
      @JsonProperty("type") String type,
      @JsonProperty("timeInForce") String timeInForce,
      @JsonProperty("clientOrderId") String clientOrderId,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("side") String side,
      @JsonProperty("account") String account,
      @JsonProperty("orderSource") String orderSource,
      @JsonProperty("leavesQuantity") Double leavesQuantity,
      @JsonProperty("cumQuantity") Double cumQuantity,
      @JsonProperty("execQuantity") Double execQuantity,
      @JsonProperty("stopPrice") Double stopPrice,
      @JsonProperty("expireTime") long expireTime) {
    super();
    this.orderId = orderId;
    this.orderStatus = orderStatus;
    this.lastTimestamp = lastTimestamp;
    this.orderPrice = orderPrice;
    this.orderQuantity = orderQuantity;
    this.avgPrice = avgPrice;
    this.type = type;
    this.timeInForce = timeInForce;
    this.clientOrderId = clientOrderId;
    this.symbol = symbol;
    this.side = side;
    this.account = account;
    this.orderSource = orderSource;
    this.leavesQuantity = leavesQuantity;
    this.cumQuantity = cumQuantity;
    this.execQuantity = execQuantity;
    this.stopPrice = stopPrice;
    this.expireTime = expireTime;
  }

  public String getOrderId() {
    return orderId;
  }

  public String getOrderStatus() {
    return orderStatus;
  }

  public long getLastTimestamp() {
    return lastTimestamp;
  }

  public Double getOrderPrice() {
    return orderPrice;
  }

  public Double getOrderQuantity() {
    return orderQuantity;
  }

  public Double getAvgPrice() {
    return avgPrice;
  }

  public String getType() {
    return type;
  }

  public String getTimeInForce() {
    return timeInForce;
  }

  public String getClientOrderId() {
    return clientOrderId;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getSide() {
    return side;
  }

  public String getAccount() {
    return account;
  }

  public String getOrderSource() {
    return orderSource;
  }

  public Double getLeavesQuantity() {
    return leavesQuantity;
  }

  public Double getCumQuantity() {
    return cumQuantity;
  }

  public Double getExecQuantity() {
    return execQuantity;
  }

  public Double getStopPrice() {
    return stopPrice;
  }

  public long getExpireTime() {
    return expireTime;
  }

  @Override
  public String toString() {
    return "GlobitexActiveOrder{"
        + "orderId='"
        + orderId
        + '\''
        + ", orderStatus='"
        + orderStatus
        + '\''
        + ", lastTimestamp="
        + lastTimestamp
        + ", orderPrice="
        + orderPrice
        + ", orderQuantity="
        + orderQuantity
        + ", avgPrice="
        + avgPrice
        + ", type='"
        + type
        + '\''
        + ", timeInForce='"
        + timeInForce
        + '\''
        + ", clientOrderId='"
        + clientOrderId
        + '\''
        + ", symbol='"
        + symbol
        + '\''
        + ", side='"
        + side
        + '\''
        + ", account='"
        + account
        + '\''
        + ", orderSource='"
        + orderSource
        + '\''
        + ", leavesQuantity="
        + leavesQuantity
        + ", cumQuantity="
        + cumQuantity
        + ", execQuantity="
        + execQuantity
        + ", stopPrice="
        + stopPrice
        + ", expireTime="
        + expireTime
        + '}';
  }
}
