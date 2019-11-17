package org.knowm.xchange.cryptofacilities.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** @author Panchen */
public class CryptoFacilitiesBidsAsks {

  private final List<List<Double>> bids;
  private final List<List<Double>> asks;

  public CryptoFacilitiesBidsAsks(
      @JsonProperty("asks") List<List<Double>> asks,
      @JsonProperty("bids") List<List<Double>> bids) {

    this.bids = bids;
    this.asks = asks;
  }

  public List<List<Double>> getBids() {
    return bids;
  }

  public List<List<Double>> getAsks() {
    return asks;
  }

  @Override
  public String toString() {

    return "[bids=" + bids + ", asks=" + asks + "]";
  }
}
