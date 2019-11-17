package org.knowm.xchange.kraken.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class KrakenTradeVolume {

  private final String currency;
  private final Double volume;
  private final Map<String, KrakenVolumeFee> feesTaker;
  private final Map<String, KrakenVolumeFee> feesMaker;

  public KrakenTradeVolume(
      @JsonProperty("currency") String currency,
      @JsonProperty("volume") Double volume,
      @JsonProperty("fees") Map<String, KrakenVolumeFee> feesTaker,
      @JsonProperty("fees_maker") Map<String, KrakenVolumeFee> feesMaker) {

    this.currency = currency;
    this.volume = volume;
    this.feesTaker = feesTaker;
    this.feesMaker = feesMaker;
  }

  public String getCurrency() {

    return currency;
  }

  public Double getVolume() {

    return volume;
  }

  public Map<String, KrakenVolumeFee> getFees() {

    return feesTaker;
  }

  public Map<String, KrakenVolumeFee> getFeesMaker() {

    return feesMaker;
  }

  @Override
  public String toString() {

    return "KrakenTradeVolume [currency="
        + currency
        + ", volume="
        + volume
        + ", feesTaker="
        + feesTaker
        + ", feesMaker="
        + feesMaker
        + "]";
  }
}
