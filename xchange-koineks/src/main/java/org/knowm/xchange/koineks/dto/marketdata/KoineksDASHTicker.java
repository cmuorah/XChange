package org.knowm.xchange.koineks.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.currency.Currency;

/** Created by semihunaldi on 05/12/2017 */
public class KoineksDASHTicker extends BaseKoineksTicker {
  public KoineksDASHTicker(
      @JsonProperty("short_code") Currency shortCode,
      @JsonProperty("name") String name,
      @JsonProperty("currency") Currency currency,
      @JsonProperty("current") Double current,
      @JsonProperty("change_amount") String changeAmount,
      @JsonProperty("change_percentage") Double changePercentage,
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("volume") Double volume,
      @JsonProperty("ask") Double ask,
      @JsonProperty("bid") Double bid,
      @JsonProperty("timestamp") String timestamp) {
    super(
        shortCode,
        name,
        currency,
        current,
        changeAmount,
        changePercentage,
        high,
        low,
        volume,
        ask,
        bid,
        timestamp);
  }
}
