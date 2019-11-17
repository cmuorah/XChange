package org.knowm.xchange.gateio.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.gateio.dto.GateioBaseResponse;

public class GateioTicker extends GateioBaseResponse {
  private Double highestBid;

  private boolean result;

  private Double low24hr;

  private Double last;

  private Double high24hr;

  private Double percentChange;

  private Double lowestAsk;

  private Double quoteVolume;

  private Double baseVolume;

  public GateioTicker(
      @JsonProperty("result") boolean result,
      @JsonProperty("message") String message,
      @JsonProperty("highestBid") Double highestBid,
      @JsonProperty("low24hr") Double low24hr,
      @JsonProperty("last") Double last,
      @JsonProperty("high24hr") Double high24hr,
      @JsonProperty("percentChange") Double percentChange,
      @JsonProperty("lowestAsk") Double lowestAsk,
      @JsonProperty("quoteVolume") Double quoteVolume,
      @JsonProperty("baseVolume") Double baseVolume) {
    super(result, message);
    this.highestBid = highestBid;
    this.result = result;
    this.low24hr = low24hr;
    this.last = last;
    this.high24hr = high24hr;
    this.percentChange = percentChange;
    this.lowestAsk = lowestAsk;
    this.quoteVolume = quoteVolume;
    this.baseVolume = baseVolume;
  }

  public Double getHighestBid() {
    return highestBid;
  }

  @Override
  public boolean isResult() {
    return result;
  }

  public Double getLow24hr() {
    return low24hr;
  }

  public Double getLast() {
    return last;
  }

  public Double getHigh24hr() {
    return high24hr;
  }

  public Double getPercentChange() {
    return percentChange;
  }

  public Double getLowestAsk() {
    return lowestAsk;
  }

  public Double getQuoteVolume() {
    return quoteVolume;
  }

  public Double getBaseVolume() {
    return baseVolume;
  }

  @Override
  public String toString() {
    return "GateioTicker{"
        + "highestBid='"
        + highestBid
        + '\''
        + ", result='"
        + result
        + '\''
        + ", low24hr='"
        + low24hr
        + '\''
        + ", last='"
        + last
        + '\''
        + ", high24hr='"
        + high24hr
        + '\''
        + ", percentChange='"
        + percentChange
        + '\''
        + ", lowestAsk='"
        + lowestAsk
        + '\''
        + ", quoteVolume='"
        + quoteVolume
        + '\''
        + ", baseVolume='"
        + baseVolume
        + '\''
        + '}';
  }
}
