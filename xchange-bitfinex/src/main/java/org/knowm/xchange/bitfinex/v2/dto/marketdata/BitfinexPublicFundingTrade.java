package org.knowm.xchange.bitfinex.v2.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class BitfinexPublicFundingTrade {

  private long tradeId;
  private long timestamp;
  private Double amount;
  private Double rate;
  private int period;

  public BitfinexPublicFundingTrade() {}

  public BitfinexPublicFundingTrade(
      long tradeId, long timestamp, Double amount, Double rate, int period) {

    this.tradeId = tradeId;
    this.timestamp = timestamp;
    this.amount = amount;
    this.rate = rate;
    this.period = period;
  }

  public long getTradeId() {

    return tradeId;
  }

  public long getTimestamp() {

    return timestamp;
  }

  public Double getAmount() {

    return amount;
  }

  public Double getRate() {

    return rate;
  }

  public int getPeriod() {

    return period;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("BitfinexPublicFundingTrade [tradeId=");
    builder.append(tradeId);
    builder.append(", timestamp=");
    builder.append(timestamp);
    builder.append(", amount=");
    builder.append(amount);
    builder.append(", rate=");
    builder.append(rate);
    builder.append(", period=");
    builder.append(period);
    builder.append("]");
    return builder.toString();
  }
}
