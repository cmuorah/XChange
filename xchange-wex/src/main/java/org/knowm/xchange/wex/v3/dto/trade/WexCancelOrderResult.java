package org.knowm.xchange.wex.v3.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.MessageFormat;
import java.util.Map;

/** @author Matija Mazi */
public class WexCancelOrderResult {

  private final long orderId;
  private final Map<String, Double> funds;

  /**
   * Constructor
   *
   * @param orderId
   * @param funds
   */
  public WexCancelOrderResult(
      @JsonProperty("order_id") long orderId, @JsonProperty("funds") Map<String, Double> funds) {

    this.orderId = orderId;
    this.funds = funds;
  }

  public long getOrderId() {

    return orderId;
  }

  public Map<String, Double> getFunds() {

    return funds;
  }

  @Override
  public String toString() {

    return MessageFormat.format("WexCancelOrderResult[orderId={0}, funds={1}]", orderId, funds);
  }
}
