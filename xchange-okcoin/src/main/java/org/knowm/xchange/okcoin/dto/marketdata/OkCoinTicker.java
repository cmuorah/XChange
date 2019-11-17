package org.knowm.xchange.okcoin.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OkCoinTicker {

  private final Double high;
  private final Double low;
  private final Double buy;
  private final Double sell;
  private final Double last;
  private final Double vol;
  private final Long contractId;
  private final Double unitAmount;

  public OkCoinTicker(
      @JsonProperty("high") final Double high,
      @JsonProperty("low") final Double low,
      @JsonProperty("buy") final Double buy,
      @JsonProperty("sell") final Double sell,
      @JsonProperty("last") final Double last,
      @JsonProperty("vol") final Double vol,
      @JsonProperty("contract_id") final Long contractId,
      @JsonProperty("unit_amount") final Double unitAmount) {

    this.high = high;
    this.low = low;
    this.buy = buy;
    this.sell = sell;
    this.last = last;
    this.vol = vol;
    this.contractId = contractId;
    this.unitAmount = unitAmount;
  }

  /** @return the high */
  public Double getHigh() {

    return high;
  }

  /** @return the low */
  public Double getLow() {

    return low;
  }

  /** @return the buy */
  public Double getBuy() {

    return buy;
  }

  /** @return the sell */
  public Double getSell() {

    return sell;
  }

  /** @return the last */
  public Double getLast() {

    return last;
  }

  /** @return the vol */
  public Double getVol() {

    return vol;
  }

  public Long getContractId() {
    return contractId;
  }

  public Double getUnitAmount() {
    return unitAmount;
  }

  @Override
  public String toString() {
    return "OkCoinTicker{"
        + "high="
        + high
        + ", low="
        + low
        + ", buy="
        + buy
        + ", sell="
        + sell
        + ", last="
        + last
        + ", vol="
        + vol
        + ", contractId="
        + contractId
        + ", unitAmount="
        + unitAmount
        + '}';
  }
}
