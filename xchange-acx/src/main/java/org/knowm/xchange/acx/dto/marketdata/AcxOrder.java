package org.knowm.xchange.acx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class AcxOrder {
  /** Unique order ID */
  public final String id;
  /** Buy/Sell */
  public final String side;

  public final String ordType;
  public final Double price;
  /** Average execution price */
  public final Double avgPrice;
  /**
   * wait, done or cancel. - ‘wait’ represents the order is active, it may be a new order or partial
   * complete order; - ‘done’ means the order has been fulfilled completely; - ‘cancel’ means the
   * order has been cancelled.
   */
  public final String state;
  /** Order created time */
  public final Date createdAt;
  /** Volume to buy/sell */
  public final Double volume;
  /** remaining_volume is always less or equal than volume */
  public final Double remainingVolume;
  /** volume = remaining_volume + executed_volume */
  public final Double executedVolume;

  public final int tradesCount;
  /** the market the order belongs to, like ‘btcaud’ */
  public final String market;

  public AcxOrder(
      @JsonProperty("id") String id,
      @JsonProperty("side") String side,
      @JsonProperty("ord_type") String ordType,
      @JsonProperty("price") Double price,
      @JsonProperty("avg_price") Double avgPrice,
      @JsonProperty("state") String state,
      @JsonProperty("market") String market,
      @JsonProperty("created_at") Date createdAt,
      @JsonProperty("volume") Double volume,
      @JsonProperty("remaining_volume") Double remainingVolume,
      @JsonProperty("executed_volume") Double executedVolume,
      @JsonProperty("trades_count") int tradesCount) {
    this.id = id;
    this.side = side;
    this.ordType = ordType;
    this.price = price;
    this.avgPrice = avgPrice;
    this.state = state;
    this.market = market;
    this.createdAt = createdAt;
    this.volume = volume;
    this.remainingVolume = remainingVolume;
    this.executedVolume = executedVolume;
    this.tradesCount = tradesCount;
  }
}
