package org.knowm.xchange.liqui.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.liqui.dto.LiquiTradeType;

public class LiquiOrderInfo {

  private final CurrencyPair pair;
  private final LiquiTradeType type;
  private final Double amount;
  private final Double rate;
  private final long timestampCreated;
  private final Double startAmount;
  private final String status;

  public LiquiOrderInfo(
      @JsonProperty("start_amount") final String startAmount,
      @JsonProperty("status") final String status,
      @JsonProperty("pair") final String pair,
      @JsonProperty("type") final LiquiTradeType type,
      @JsonProperty("amount") final String amount,
      @JsonProperty("rate") final String rate,
      @JsonProperty("timestamp_created") final long timestampCreated) {
    this.status = status;
    final String[] split = pair.split("_");
    this.pair = new CurrencyPair(split[0], split[1]);
    this.type = type;
    this.startAmount = startAmount != null ? new Double(startAmount) : null;
    this.amount = new Double(amount);
    this.rate = new Double(rate);
    this.timestampCreated = timestampCreated;
  }

  public Double getStartAmount() {
    return startAmount;
  }

  public String getStatus() {
    return status;
  }

  public CurrencyPair getPair() {
    return pair;
  }

  public LiquiTradeType getType() {
    return type;
  }

  public Double getAmount() {
    return amount;
  }

  public Double getRate() {
    return rate;
  }

  public long getTimestampCreated() {
    return timestampCreated;
  }

  @Override
  public String toString() {
    return "LiquiOrderInfo{"
        + "pair="
        + pair
        + ", type="
        + type
        + ", amount="
        + amount
        + ", rate="
        + rate
        + ", timestampCreated="
        + timestampCreated
        + ", startAmount='"
        + startAmount
        + '\''
        + ", status='"
        + status
        + '\''
        + '}';
  }
}
