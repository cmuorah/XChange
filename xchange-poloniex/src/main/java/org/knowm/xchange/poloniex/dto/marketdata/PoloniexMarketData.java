package org.knowm.xchange.poloniex.dto.marketdata;

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
  "last",
  "lowestAsk",
  "highestBid",
  "percentChange",
  "baseVolume",
  "quoteVolume"
})
public class PoloniexMarketData {

  @JsonProperty("high24hr")
  private Double high24hr;

  @JsonProperty("low24hr")
  private Double low24hr;

  @JsonProperty("last")
  private Double last;

  @JsonProperty("lowestAsk")
  private Double lowestAsk;

  @JsonProperty("highestBid")
  private Double highestBid;

  @JsonProperty("percentChange")
  private Double percentChange;

  @JsonProperty("baseVolume")
  private Double baseVolume;

  @JsonProperty("quoteVolume")
  private Double quoteVolume;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  public Double getHigh24hr() {
    return high24hr;
  }

  public void setHigh24hr(Double high24hr) {
    this.high24hr = high24hr;
  }

  public Double getLow24hr() {
    return low24hr;
  }

  public void setLow24hr(Double low24hr) {
    this.low24hr = low24hr;
  }

  @JsonProperty("last")
  public Double getLast() {

    return last;
  }

  @JsonProperty("last")
  public void setLast(Double last) {

    this.last = last;
  }

  @JsonProperty("lowestAsk")
  public Double getLowestAsk() {

    return lowestAsk;
  }

  @JsonProperty("lowestAsk")
  public void setLowestAsk(Double lowestAsk) {

    this.lowestAsk = lowestAsk;
  }

  @JsonProperty("highestBid")
  public Double getHighestBid() {

    return highestBid;
  }

  @JsonProperty("highestBid")
  public void setHighestBid(Double highestBid) {

    this.highestBid = highestBid;
  }

  @JsonProperty("percentChange")
  public Double getPercentChange() {

    return percentChange;
  }

  @JsonProperty("percentChange")
  public void setPercentChange(Double percentChange) {

    this.percentChange = percentChange;
  }

  @JsonProperty("baseVolume")
  public Double getBaseVolume() {

    return baseVolume;
  }

  @JsonProperty("baseVolume")
  public void setBaseVolume(Double baseVolume) {

    this.baseVolume = baseVolume;
  }

  @JsonProperty("quoteVolume")
  public Double getQuoteVolume() {

    return quoteVolume;
  }

  @JsonProperty("quoteVolume")
  public void setQuoteVolume(Double quoteVolume) {

    this.quoteVolume = quoteVolume;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {

    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {

    this.additionalProperties.put(name, value);
  }

  @Override
  public String toString() {

    return "PoloniexMarketData [last="
        + last
        + ", lowestAsk="
        + lowestAsk
        + ", highestBid="
        + highestBid
        + ", percentChange="
        + percentChange
        + ", baseVolume="
        + baseVolume
        + ", quoteVolume="
        + quoteVolume
        + ", additionalProperties="
        + additionalProperties
        + "]";
  }
}
