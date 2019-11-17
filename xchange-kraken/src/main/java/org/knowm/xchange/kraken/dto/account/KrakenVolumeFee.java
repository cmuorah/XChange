package org.knowm.xchange.kraken.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KrakenVolumeFee {

  private final Double fee;
  private final Double minFee;
  private final Double maxFee;
  private final Double nextFee;
  private final Double nextVolume;
  private final Double tierVolume;

  /**
   * Constructor
   *
   * @param fee
   * @param minFee
   * @param maxFee
   * @param nextFee
   * @param nextVolume
   * @param tierVolume
   */
  public KrakenVolumeFee(
      @JsonProperty("fee") Double fee,
      @JsonProperty("minfee") Double minFee,
      @JsonProperty("maxfee") Double maxFee,
      @JsonProperty("nextfee") Double nextFee,
      @JsonProperty("nextvolume") Double nextVolume,
      @JsonProperty("tiervolume") Double tierVolume) {

    this.fee = fee;
    this.minFee = minFee;
    this.maxFee = maxFee;
    this.nextFee = nextFee;
    this.nextVolume = nextVolume;
    this.tierVolume = tierVolume;
  }

  public Double getFee() {

    return fee;
  }

  public Double getMinFee() {

    return minFee;
  }

  public Double getMaxFee() {

    return maxFee;
  }

  public Double getNextFee() {

    return nextFee;
  }

  public Double getNextVolume() {

    return nextVolume;
  }

  public Double getTierVolume() {

    return tierVolume;
  }

  @Override
  public String toString() {

    return "KrakenVolumeFee [fee="
        + fee
        + ", minFee="
        + minFee
        + ", maxFee="
        + maxFee
        + ", nextFee="
        + nextFee
        + ", nextVolume="
        + nextVolume
        + ", tierVolume="
        + tierVolume
        + "]";
  }
}
