package org.knowm.xchange.wex.v3.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.MessageFormat;
import java.util.Map;

/** @author Matija Mazi */
public class WexPlaceOrderResult {

  private final long orderId; // 0 if order completely filled, initial order_id otherwise
  private final Double received;
  private final Double remains;
  private final Map<String, Double> funds;

  /**
   * Constructor
   *
   * @param orderId
   * @param received
   * @param remains
   * @param funds
   */
  public WexPlaceOrderResult(
      @JsonProperty("order_id") long orderId,
      @JsonProperty("received") Double received,
      @JsonProperty("remains") Double remains,
      @JsonProperty("funds") Map<String, Double> funds) {

    this.orderId = orderId;
    this.received = received;
    this.remains = remains;
    this.funds = funds;
  }

  public long getOrderId() {

    return orderId;
  }

  public Map<String, Double> getFunds() {

    return funds;
  }

  public Double getReceived() {

    return received;
  }

  public Double getRemains() {

    return remains;
  }

  @Override
  public String toString() {

    return MessageFormat.format(
        "WexPlaceOrderResult[orderId={0}, received={1}, remains={2}, funds={3}]",
        orderId, received, remains, funds);
  }
}
