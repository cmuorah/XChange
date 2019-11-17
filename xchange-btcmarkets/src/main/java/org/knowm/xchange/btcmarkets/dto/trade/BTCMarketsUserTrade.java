package org.knowm.xchange.btcmarkets.dto.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Date;
import org.knowm.xchange.utils.jackson.MillisecTimestampDeserializer;

public class BTCMarketsUserTrade {

  private Long id;

  private Long orderId;

  private String description;

  private Double price;

  private Double volume;

  private Double fee;

  private BTCMarketsOrder.Side side;

  @JsonDeserialize(using = MillisecTimestampDeserializer.class)
  private Date creationTime;

  public Long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public Double getPrice() {
    return price;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getFee() {
    return fee;
  }

  public Date getCreationTime() {
    return creationTime;
  }

  public BTCMarketsOrder.Side getSide() {
    return side;
  }

  public Long getOrderId() {
    return orderId;
  }

  @Override
  public String toString() {
    return String.format(
        "BTCMarketsUserTrade{id=%d, side='%s', description='%s', price=%s, volume=%s, fee=%s, creationTime=%s, orderId=%s}",
        id, side, description, price, volume, fee, creationTime, orderId);
  }
}
