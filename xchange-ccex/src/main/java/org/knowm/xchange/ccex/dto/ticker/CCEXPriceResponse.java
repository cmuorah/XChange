package org.knowm.xchange.ccex.dto.ticker;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CCEXPriceResponse {

  private Double high;
  private Double low;
  private Double avg;
  private Double lastbuy;
  private Double lastsell;
  private Double buy;
  private Double sell;
  private Double lastprice;
  private Double buysupport;
  private int updated;

  public CCEXPriceResponse(
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("avg") Double avg,
      @JsonProperty("lastbuy") Double lastbuy,
      @JsonProperty("lastsell") Double lastsell,
      @JsonProperty("buy") Double buy,
      @JsonProperty("sell") Double sell,
      @JsonProperty("lastprice") Double lastprice,
      @JsonProperty("buysupport") Double buysupport,
      @JsonProperty("updated") int updated) {
    super();
    this.high = high;
    this.low = low;
    this.avg = avg;
    this.lastbuy = lastbuy;
    this.lastsell = lastsell;
    this.buy = buy;
    this.sell = sell;
    this.lastprice = lastprice;
    this.buysupport = buysupport;
    this.updated = updated;
  }

  public Double getHigh() {
    return high;
  }

  public void setHigh(Double high) {
    this.high = high;
  }

  public Double getLow() {
    return low;
  }

  public void setLow(Double low) {
    this.low = low;
  }

  public Double getAvg() {
    return avg;
  }

  public void setAvg(Double avg) {
    this.avg = avg;
  }

  public Double getLastbuy() {
    return lastbuy;
  }

  public void setLastbuy(Double lastbuy) {
    this.lastbuy = lastbuy;
  }

  public Double getLastsell() {
    return lastsell;
  }

  public void setLastsell(Double lastsell) {
    this.lastsell = lastsell;
  }

  public Double getBuy() {
    return buy;
  }

  public void setBuy(Double buy) {
    this.buy = buy;
  }

  public Double getSell() {
    return sell;
  }

  public void setSell(Double sell) {
    this.sell = sell;
  }

  public Double getLastprice() {
    return lastprice;
  }

  public void setLastprice(Double lastprice) {
    this.lastprice = lastprice;
  }

  public Double getBuysupport() {
    return buysupport;
  }

  public void setBuysupport(Double buysupport) {
    this.buysupport = buysupport;
  }

  public int getUpdated() {
    return updated;
  }

  public void setUpdated(int updated) {
    this.updated = updated;
  }

  @Override
  public String toString() {
    return "CCEXPriceResponse [high="
        + high
        + ", low="
        + low
        + ", avg="
        + avg
        + ", lastbuy="
        + lastbuy
        + ", lastsell="
        + lastsell
        + ", buy="
        + buy
        + ", sell="
        + sell
        + ", lastprice="
        + lastprice
        + ", buysupport="
        + buysupport
        + ", updated="
        + updated
        + "]";
  }
}
