package org.knowm.xchange.bity.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class BityTicker {

  @JsonProperty("is_enabled")
  private Boolean isEnabled;

  @JsonProperty("pair")
  private String pair;

  @JsonProperty("rate")
  private Double rate;

  @JsonProperty("rate_we_buy")
  private Double rateWeBuy;

  @JsonProperty("rate_we_buy_timestamp")
  private Date rateWeBuyTimestamp;

  @JsonProperty("rate_we_sell")
  private Double rateWeSell;

  @JsonProperty("rate_we_sell_timestamp")
  private Date rateWeSellTimestamp;

  @JsonProperty("resource_uri")
  private String resourceUri;

  @JsonProperty("source")
  private String source;

  @JsonProperty("target")
  private String target;

  @JsonProperty("timestamp")
  private Date timestamp;

  @JsonProperty("is_enabled")
  public Boolean getIsEnabled() {
    return isEnabled;
  }

  @JsonProperty("is_enabled")
  public void setIsEnabled(Boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  @JsonProperty("pair")
  public String getPair() {
    return pair;
  }

  @JsonProperty("pair")
  public void setPair(String pair) {
    this.pair = pair;
  }

  @JsonProperty("rate")
  public Double getRate() {
    return rate;
  }

  @JsonProperty("rate")
  public void setRate(Double rate) {
    this.rate = rate;
  }

  @JsonProperty("rate_we_buy")
  public Double getRateWeBuy() {
    return rateWeBuy;
  }

  @JsonProperty("rate_we_buy")
  public void setRateWeBuy(Double rateWeBuy) {
    this.rateWeBuy = rateWeBuy;
  }

  @JsonProperty("rate_we_buy_timestamp")
  public Date getRateWeBuyTimestamp() {
    return rateWeBuyTimestamp;
  }

  @JsonProperty("rate_we_buy_timestamp")
  public void setRateWeBuyTimestamp(Date rateWeBuyTimestamp) {
    this.rateWeBuyTimestamp = rateWeBuyTimestamp;
  }

  @JsonProperty("rate_we_sell")
  public Double getRateWeSell() {
    return rateWeSell;
  }

  @JsonProperty("rate_we_sell")
  public void setRateWeSell(Double rateWeSell) {
    this.rateWeSell = rateWeSell;
  }

  @JsonProperty("rate_we_sell_timestamp")
  public Date getRateWeSellTimestamp() {
    return rateWeSellTimestamp;
  }

  @JsonProperty("rate_we_sell_timestamp")
  public void setRateWeSellTimestamp(Date rateWeSellTimestamp) {
    this.rateWeSellTimestamp = rateWeSellTimestamp;
  }

  @JsonProperty("resource_uri")
  public String getResourceUri() {
    return resourceUri;
  }

  @JsonProperty("resource_uri")
  public void setResourceUri(String resourceUri) {
    this.resourceUri = resourceUri;
  }

  @JsonProperty("source")
  public String getSource() {
    return source;
  }

  @JsonProperty("source")
  public void setSource(String source) {
    this.source = source;
  }

  @JsonProperty("target")
  public String getTarget() {
    return target;
  }

  @JsonProperty("target")
  public void setTarget(String target) {
    this.target = target;
  }

  @JsonProperty("timestamp")
  public Date getTimestamp() {
    return timestamp;
  }

  @JsonProperty("timestamp")
  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }
}
