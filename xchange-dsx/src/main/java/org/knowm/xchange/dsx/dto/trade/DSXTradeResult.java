package org.knowm.xchange.dsx.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.MessageFormat;
import java.util.Map;
import org.knowm.xchange.dsx.dto.account.DSXCurrencyAmount;

/** @author Mikhail Wall */
public class DSXTradeResult {

  private final long orderId;
  private final Double received;
  private final Double remains;
  private final Map<String, DSXCurrencyAmount> funds;

  public DSXTradeResult(
      @JsonProperty("orderId") long orderId,
      @JsonProperty("received") Double received,
      @JsonProperty("remains") Double remains,
      @JsonProperty("funds") Map<String, DSXCurrencyAmount> funds) {

    this.orderId = orderId;
    this.received = received;
    this.remains = remains;
    this.funds = funds;
  }

  public long getOrderId() {

    return orderId;
  }

  public Double getReceived() {

    return received;
  }

  public Double getRemains() {

    return remains;
  }

  public Map<String, DSXCurrencyAmount> getFunds() {

    return funds;
  }

  @Override
  public String toString() {

    return MessageFormat.format(
        "DSXTrade[orderId={0}, received={1}, remains={2}, funds={3}]",
        orderId, received, remains, funds);
  }
}
