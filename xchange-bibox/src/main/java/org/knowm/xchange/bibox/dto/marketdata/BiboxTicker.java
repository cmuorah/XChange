package org.knowm.xchange.bibox.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
  "buy",
  "high",
  "last",
  "low",
  "sell",
  "timestamp",
  "vol",
  "last_cny",
  "last_usd",
  "percent"
})
public class BiboxTicker {

  @JsonProperty("buy")
  private Double buy;

  @JsonProperty("high")
  private Double high;

  @JsonProperty("last")
  private Double last;

  @JsonProperty("low")
  private Double low;

  @JsonProperty("sell")
  private Double sell;

  @JsonProperty("timestamp")
  private long timestamp;

  @JsonProperty("vol")
  private Double vol;

  @JsonProperty("last_cny")
  private Double lastCny;

  @JsonProperty("last_usd")
  private Double lastUsd;
  // yes, I'm lazy
  @JsonProperty("percent")
  private String percent;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /** @return The buy */
  @JsonProperty("buy")
  public Double getBuy() {
    return buy;
  }

  /** @param buy The buy */
  @JsonProperty("buy")
  public void setBuy(Double buy) {
    this.buy = buy;
  }

  /** @return The high */
  @JsonProperty("high")
  public Double getHigh() {
    return high;
  }

  /** @param high The high */
  @JsonProperty("high")
  public void setHigh(Double high) {
    this.high = high;
  }

  /** @return The last */
  @JsonProperty("last")
  public Double getLast() {
    return last;
  }

  /** @param last The last */
  @JsonProperty("last")
  public void setLast(Double last) {
    this.last = last;
  }

  /** @return The low */
  @JsonProperty("low")
  public Double getLow() {
    return low;
  }

  /** @param low The low */
  @JsonProperty("low")
  public void setLow(Double low) {
    this.low = low;
  }

  /** @return The sell */
  @JsonProperty("sell")
  public Double getSell() {
    return sell;
  }

  /** @param sell The sell */
  @JsonProperty("sell")
  public void setSell(Double sell) {
    this.sell = sell;
  }

  /** @return The timestamp */
  @JsonProperty("timestamp")
  public long getTimestamp() {
    return timestamp;
  }

  /** @param timestamp The timestamp */
  @JsonProperty("timestamp")
  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  /** @return The vol */
  @JsonProperty("vol")
  public Double getVol() {
    return vol;
  }

  /** @param vol The vol */
  @JsonProperty("vol")
  public void setVol(Double vol) {
    this.vol = vol;
  }

  /** @return The lastCny */
  @JsonProperty("last_cny")
  public Double getLastCny() {
    return lastCny;
  }

  /** @param lastCny The last_cny */
  @JsonProperty("last_cny")
  public void setLastCny(Double lastCny) {
    this.lastCny = lastCny;
  }

  /** @return The lastUsd */
  @JsonProperty("last_usd")
  public Double getLastUsd() {
    return lastUsd;
  }

  /** @param lastUsd The last_usd */
  @JsonProperty("last_usd")
  public void setLastUsd(Double lastUsd) {
    this.lastUsd = lastUsd;
  }

  /** @return The percent */
  @JsonProperty("percent")
  public String getPercent() {
    return percent;
  }

  /** @param percent The percent */
  @JsonProperty("percent")
  public void setPercent(String percent) {
    this.percent = percent;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }
}
