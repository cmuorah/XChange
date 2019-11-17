package org.knowm.xchange.liqui.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.stream.Collectors;

public class LiquiTrade {

  private final Double received;
  private final Double remains;
  private final long orderId;
  private final long initOrderId;
  private final Map<String, Double> funds;
  private final Object trades;

  public LiquiTrade(
      @JsonProperty("received") final String received,
      @JsonProperty("remains") final String remains,
      @JsonProperty("order_id") final long orderId,
      @JsonProperty("init_order_id") final long initOrderId,
      @JsonProperty("funds") final Map<String, String> funds,
      @JsonProperty("trades") final Object trades) {

    this.received = new Double(received);
    this.remains = new Double(remains);
    this.orderId = orderId;
    this.initOrderId = initOrderId;
    this.funds =
        funds.entrySet().stream()
            .collect(Collectors.toMap((Map.Entry::getKey), (e -> new Double(e.getValue()))));
    this.trades = trades;
  }

  public Double getReceived() {
    return received;
  }

  public Double getRemains() {
    return remains;
  }

  public long getOrderId() {
    return orderId;
  }

  public long getInitOrderId() {
    return initOrderId;
  }

  public Map<String, Double> getFunds() {
    return funds;
  }

  public Object getTrades() {
    return trades;
  }

  @Override
  public String toString() {
    return "LiquiTrade{"
        + "received='"
        + received
        + '\''
        + ", remains='"
        + remains
        + '\''
        + ", orderId="
        + orderId
        + ", initOrderId="
        + initOrderId
        + ", funds="
        + funds
        + ", trades="
        + trades
        + '}';
  }
}
