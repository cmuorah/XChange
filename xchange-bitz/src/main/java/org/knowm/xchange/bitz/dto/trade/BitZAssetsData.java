package org.knowm.xchange.bitz.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitZAssetsData {
  private final Double bzLock;
  private final Double bzOver;

  public BitZAssetsData(
      @JsonProperty("bz_lock") Double bzLock, @JsonProperty("bz_over") Double bzOver) {
    this.bzLock = bzLock;
    this.bzOver = bzOver;
  }

  public Double getBzLock() {
    return bzLock;
  }

  public Double getBzOver() {
    return bzOver;
  }
}
