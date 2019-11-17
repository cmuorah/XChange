package org.knowm.xchange.huobi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public final class HuobiTicker {

  private final long id;
  private final Double amount;
  private final long count;
  private final Double open;
  private final Double close;
  private final Double low;
  private final Double high;
  private final Double vol;
  private final HuobiPrice bid;
  private final HuobiPrice ask;
  private Date ts;

  public HuobiTicker(
      @JsonProperty("id") long id,
      @JsonProperty("amount") Double amount,
      @JsonProperty("count") long count,
      @JsonProperty("open") Double open,
      @JsonProperty("close") Double close,
      @JsonProperty("low") Double low,
      @JsonProperty("high") Double high,
      @JsonProperty("vol") Double vol,
      @JsonProperty("bid") Double[] bid,
      @JsonProperty("ask") Double[] ask) {
    this.id = id;
    this.amount = amount;
    this.count = count;
    this.open = open;
    this.close = close;
    this.low = low;
    this.high = high;
    this.vol = vol;
    this.bid = new HuobiPrice(bid);
    this.ask = new HuobiPrice(ask);
  }

  public long getId() {
    return id;
  }

  public Double getAmount() {
    return amount;
  }

  public long getCount() {
    return count;
  }

  public Double getOpen() {
    return open;
  }

  public Double getClose() {
    return close;
  }

  public Double getLow() {
    return low;
  }

  public Double getHigh() {
    return high;
  }

  public Double getVol() {
    return vol;
  }

  public HuobiPrice getBid() {
    return bid;
  }

  public HuobiPrice getAsk() {
    return ask;
  }

  public Date getTs() {
    return ts;
  }

  public void setTs(Date ts) {
    this.ts = ts;
  }

  @Override
  public String toString() {
    return "HuobiTicker [id="
        + getId()
        + ", amount="
        + getAmount()
        + ", count="
        + getCount()
        + ", open="
        + getOpen()
        + ", close="
        + getClose()
        + ", low="
        + getLow()
        + ", high="
        + getHigh()
        + ", vol="
        + getVol()
        + ", bid="
        + getBid().toString()
        + ", ask="
        + getAsk().toString()
        + "]";
  }
}
