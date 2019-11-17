package org.knowm.xchange.coinbene.dto.trading;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.coinbene.dto.CoinbeneResponse;

public class CoinbeneLimitOrder {
  private final String orderId;
  private final CoinbeneOrderStatus orderStatus;
  private final String symbol;
  private final String type;
  private final Double price;
  private final Double orderQuantity;
  private final Double filledQuantity;
  private final Double filledAmount;
  private final Double averagePrice;
  private final Double fees;
  private final Long createTime;
  private final Long lastModified;

  public CoinbeneLimitOrder(
      @JsonProperty("orderid") String orderId,
      @JsonProperty("orderstatus") CoinbeneOrderStatus orderStatus,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("type") String type,
      @JsonProperty("price") Double price,
      @JsonProperty("orderquantity") Double orderQuantity,
      @JsonProperty("filledquantity") Double filledQuantity,
      @JsonProperty("filledamount") Double filledAmount,
      @JsonProperty("averageprice") Double averagePrice,
      @JsonProperty("fees") Double fees,
      @JsonProperty("createtime") Long createTime,
      @JsonProperty("lastmodified") Long lastModified) {
    this.orderId = orderId;
    this.orderStatus = orderStatus;
    this.symbol = symbol;
    this.type = type;
    this.price = price;
    this.orderQuantity = orderQuantity;
    this.filledQuantity = filledQuantity;
    this.filledAmount = filledAmount;
    this.averagePrice = averagePrice;
    this.fees = fees;
    this.createTime = createTime;
    this.lastModified = lastModified;
  }

  public String getOrderId() {
    return orderId;
  }

  public CoinbeneOrderStatus getOrderStatus() {
    return orderStatus;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getType() {
    return type;
  }

  public Double getPrice() {
    return price;
  }

  public Double getOrderQuantity() {
    return orderQuantity;
  }

  public Double getFilledQuantity() {
    return filledQuantity;
  }

  public Double getFilledAmount() {
    return filledAmount;
  }

  public Double getAveragePrice() {
    return averagePrice;
  }

  public Double getFees() {
    return fees;
  }

  public Long getCreateTime() {
    return createTime;
  }

  public Long getLastModified() {
    return lastModified;
  }

  public static class Container extends CoinbeneResponse {
    private final CoinbeneLimitOrder order;

    public Container(@JsonProperty("order") CoinbeneLimitOrder order) {
      this.order = order;
    }

    public CoinbeneLimitOrder getOrder() {
      return order;
    }
  }
}
