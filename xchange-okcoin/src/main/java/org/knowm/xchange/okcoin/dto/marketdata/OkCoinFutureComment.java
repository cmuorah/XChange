package org.knowm.xchange.okcoin.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OkCoinFutureComment {
  // 指数
  private final Double futureIndex;
  // 美元-人民币汇率
  private final Double rate;
  // 交割预估价  注意：交割预估价只有交割前三小时返回
  private final Double forecastPrice;
  // 合约最高限价
  private final Double high;
  // 合约最低限价
  private final Double low;

  public OkCoinFutureComment(
      @JsonProperty("future_index") final Double futureIndex,
      @JsonProperty("rate") final Double rate,
      @JsonProperty("forecast_price") final Double forecastPrice,
      @JsonProperty("high") final Double high,
      @JsonProperty("low") final Double low) {
    this.futureIndex = futureIndex;
    this.rate = rate;
    this.forecastPrice = forecastPrice;
    this.high = high;
    this.low = low;
  }

  public Double getRate() {
    return rate;
  }

  public Double getForecastPrice() {
    return forecastPrice;
  }

  public Double getFutureIndex() {
    return futureIndex;
  }

  public Double getHigh() {
    return high;
  }

  public Double getLow() {
    return low;
  }
}
