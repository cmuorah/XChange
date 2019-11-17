package org.knowm.xchange.upbit.dto.trade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpbitOrderResponse {

  private final String uuid;
  private final String side;
  private final String orderType;
  private final Double price;
  private final Double avgPrice;
  private final String state;
  private final String market;
  private final String createdAt;
  private final Double volume;
  private final Double remainingVolume;
  private final Double reservedFee;
  private final Double remainingFee;
  private final Double paidFee;
  private final Double locked;
  private final Double executedVolume;
  private final Double tradeCount;
  private final UpbitOrderTrade[] trades;

  public UpbitOrderResponse(
      @JsonProperty("uuid") String uuid,
      @JsonProperty("side") String side,
      @JsonProperty("ord_type") String orderType,
      @JsonProperty("price") Double price,
      @JsonProperty("avg_price") Double avgPrice,
      @JsonProperty("state") String state,
      @JsonProperty("market") String market,
      @JsonProperty("created_at") String createdAt,
      @JsonProperty("volume") Double volume,
      @JsonProperty("remaining_volume") Double remainingVolume,
      @JsonProperty("reserved_fee") Double reservedFee,
      @JsonProperty("remaining_fee") Double remainingFee,
      @JsonProperty("paid_fee") Double paidFee,
      @JsonProperty("locked") Double locked,
      @JsonProperty("executed_volume") Double executedVolume,
      @JsonProperty("trade_count") Double tradeCount,
      @JsonProperty("trades") UpbitOrderTrade[] trades) {
    this.uuid = uuid;
    this.side = side;
    this.orderType = orderType;
    this.price = price;
    this.avgPrice = avgPrice;
    this.state = state;
    this.market = market;
    this.createdAt = createdAt;
    this.volume = volume;
    this.remainingVolume = remainingVolume;
    this.reservedFee = reservedFee;
    this.remainingFee = remainingFee;
    this.paidFee = paidFee;
    this.locked = locked;
    this.executedVolume = executedVolume;
    this.tradeCount = tradeCount;
    this.trades = trades;
  }

  public String getUuid() {
    return uuid;
  }

  public String getSide() {
    return side;
  }

  public String getOrderType() {
    return orderType;
  }

  public Double getPrice() {
    return price;
  }

  public Double getAvgPrice() {
    return avgPrice;
  }

  public String getState() {
    return state;
  }

  public String getMarket() {
    return market;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getRemainingVolume() {
    return remainingVolume;
  }

  public Double getReservedFee() {
    return reservedFee;
  }

  public Double getRemainingFee() {
    return remainingFee;
  }

  public Double getPaidFee() {
    return paidFee;
  }

  public Double getLocked() {
    return locked;
  }

  public Double getExecutedVolume() {
    return executedVolume;
  }

  public Double getTradeCount() {
    return tradeCount;
  }

  public UpbitOrderTrade[] getTrades() {
    return trades;
  }
}
