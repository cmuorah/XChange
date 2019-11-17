package org.knowm.xchange.bibox.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.annotation.Generated;

/** @author odrotleff */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
  "id",
  "coin_symbol",
  "currency_symbol",
  "last",
  "high",
  "low",
  "change",
  "percent",
  "vol24H",
  "amount",
  "last_cny",
  "high_cny",
  "low_cny",
  "last_usd",
  "high_usd",
  "low_usd"
})
public class BiboxMarket {

  @JsonProperty("id")
  private long id;

  @JsonProperty("coin_symbol")
  private String coinSymbol;

  @JsonProperty("currency_symbol")
  private String currencySymbol;

  @JsonProperty("last")
  private Double last;

  @JsonProperty("high")
  private Double high;

  @JsonProperty("low")
  private Double low;

  @JsonProperty("change")
  private Double change;

  @JsonProperty("percent")
  private String percent;

  @JsonProperty("vol24H")
  private Double vol24H;

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("last_cny")
  private Double lastCny;

  @JsonProperty("high_cny")
  private Double highCny;

  @JsonProperty("low_cny")
  private Double lowCny;

  @JsonProperty("last_usd")
  private Double lastUsd;

  @JsonProperty("high_usd")
  private Double highUsd;

  @JsonProperty("low_usd")
  private Double lowUsd;

  /** @return The id */
  @JsonProperty("id")
  public long getId() {
    return id;
  }

  /** @param id The id */
  @JsonProperty("id")
  public void setId(long id) {
    this.id = id;
  }

  /** @return The coinSymbol */
  @JsonProperty("coin_symbol")
  public String getCoinSymbol() {
    return coinSymbol;
  }

  /** @param coinSymbol The coin_symbol */
  @JsonProperty("coin_symbol")
  public void setCoinSymbol(String coinSymbol) {
    this.coinSymbol = coinSymbol;
  }

  /** @return The currencySymbol */
  @JsonProperty("currency_symbol")
  public String getCurrencySymbol() {
    return currencySymbol;
  }

  /** @param currencySymbol The currency_symbol */
  @JsonProperty("currency_symbol")
  public void setCurrencySymbol(String currencySymbol) {
    this.currencySymbol = currencySymbol;
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

  /** @return The change */
  @JsonProperty("change")
  public Double getChange() {
    return change;
  }

  /** @param change The change */
  @JsonProperty("change")
  public void setChange(Double change) {
    this.change = change;
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

  /** @return The vol24H */
  @JsonProperty("vol24H")
  public Double getVol24H() {
    return vol24H;
  }

  /** @param vol24H The vol24H */
  @JsonProperty("vol24H")
  public void setVol24H(Double vol24H) {
    this.vol24H = vol24H;
  }

  /** @return The amount */
  @JsonProperty("amount")
  public Double getAmount() {
    return amount;
  }

  /** @param amount The amount */
  @JsonProperty("amount")
  public void setAmount(Double amount) {
    this.amount = amount;
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

  /** @return The highCny */
  @JsonProperty("high_cny")
  public Double getHighCny() {
    return highCny;
  }

  /** @param highCny The high_cny */
  @JsonProperty("high_cny")
  public void setHighCny(Double highCny) {
    this.highCny = highCny;
  }

  /** @return The lowCny */
  @JsonProperty("low_cny")
  public Double getLowCny() {
    return lowCny;
  }

  /** @param lowCny The low_cny */
  @JsonProperty("low_cny")
  public void setLowCny(Double lowCny) {
    this.lowCny = lowCny;
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

  /** @return The highUsd */
  @JsonProperty("high_usd")
  public Double getHighUsd() {
    return highUsd;
  }

  /** @param highUsd The high_usd */
  @JsonProperty("high_usd")
  public void setHighUsd(Double highUsd) {
    this.highUsd = highUsd;
  }

  /** @return The lowUsd */
  @JsonProperty("low_usd")
  public Double getLowUsd() {
    return lowUsd;
  }

  /** @param lowUsd The low_usd */
  @JsonProperty("low_usd")
  public void setLowUsd(Double lowUsd) {
    this.lowUsd = lowUsd;
  }
}
