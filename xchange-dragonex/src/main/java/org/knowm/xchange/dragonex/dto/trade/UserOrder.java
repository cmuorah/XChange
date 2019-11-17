package org.knowm.xchange.dragonex.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.knowm.xchange.dragonex.DragonexUtils;

public class UserOrder {

  public final long orderId;
  /** order type: 1-Buy, 2-Sell */
  public final int orderType;

  public final long symbolId;
  public final Double price;
  /** order status: 1-pending trade, 2-successful trade, 3-canceled, 4-failed */
  public final int status;
  /** timestamp is provided in nano seconds */
  private final String timestamp;
  /** volume of successful trade */
  public final Double tradeVolume;
  /** volume of order */
  public final Double volume;

  public UserOrder(
      @JsonProperty("order_id") long orderId,
      @JsonProperty("order_type") int orderType,
      @JsonProperty("price") Double price,
      @JsonProperty("status") int status,
      @JsonProperty("symbol_id") long symbolId,
      @JsonProperty("timestamp") String timestamp,
      @JsonProperty("trade_volume") Double tradeVolume,
      @JsonProperty("volume") Double volume) {
    this.orderId = orderId;
    this.orderType = orderType;
    this.price = price;
    this.status = status;
    this.symbolId = symbolId;
    this.timestamp = timestamp;
    this.tradeVolume = tradeVolume;
    this.volume = volume;
  }

  @Override
  public String toString() {
    return "UserOrder [orderId="
        + orderId
        + ", "
        + (price != null ? "price=" + price + ", " : "")
        + "status="
        + status
        + ", timestamp="
        + timestamp
        + ", "
        + (tradeVolume != null ? "tradeVolume=" + tradeVolume + ", " : "")
        + (volume != null ? "volume=" + volume : "")
        + "]";
  }

  public Date getTimestamp() {
    return DragonexUtils.nanos2Date(timestamp);
  }
}
