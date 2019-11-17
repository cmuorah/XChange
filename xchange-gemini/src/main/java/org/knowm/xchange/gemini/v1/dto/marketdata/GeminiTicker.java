package org.knowm.xchange.gemini.v1.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import org.knowm.xchange.currency.CurrencyPair;

public class GeminiTicker {

  private final Double bid;
  private final Double ask;
  private final Double last;
  private final Volume volume;

  /**
   * @param bid
   * @param ask
   * @param last
   * @param volume
   */
  public GeminiTicker(
      @JsonProperty("bid") Double bid,
      @JsonProperty("ask") Double ask,
      @JsonProperty("last") Double last,
      @JsonProperty("volume") Map<String, Object> volume) {

    this.bid = bid;
    this.ask = ask;
    this.last = last;
    this.volume = new Volume(volume);
  }

  public Double getBid() {

    return bid;
  }

  public Double getAsk() {

    return ask;
  }

  public Double getLast() {

    return last;
  }

  public Volume getVolume() {

    return volume;
  }

  @Override
  public String toString() {

    return "GeminiTicker [bid="
        + bid
        + ", ask="
        + ask
        + ", last="
        + last
        + ", volume="
        + volume
        + "]";
  }

  public static class Volume {
    private final Map<String, Object> valueMap;

    public Volume(Map<String, Object> valueMap) {
      this.valueMap = valueMap;
    }

    public long getTimestampMS() {
      return (long) valueMap.get("timestamp");
    }

    public Double getBaseVolume(CurrencyPair currencyPair) {
      return new Double((String) valueMap.get(currencyPair.base.toString()));
    }

    public Double getCounterVolume(CurrencyPair currencyPair) {
      return new Double((String) valueMap.get(currencyPair.counter.toString()));
    }
  }
}
