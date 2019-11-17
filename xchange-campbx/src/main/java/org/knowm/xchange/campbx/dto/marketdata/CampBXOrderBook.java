package org.knowm.xchange.campbx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.knowm.xchange.campbx.dto.CampBXResponse;

/** @author Matija Mazi */
public final class CampBXOrderBook extends CampBXResponse {

  @JsonProperty("Bids")
  private List<List<Double>> bids;

  @JsonProperty("Asks")
  private List<List<Double>> asks;

  public List<List<Double>> getBids() {

    return bids;
  }

  public void setBids(List<List<Double>> bids) {

    this.bids = bids;
  }

  public List<List<Double>> getAsks() {

    return asks;
  }

  public void setAsks(List<List<Double>> asks) {

    this.asks = asks;
  }

  @Override
  public String toString() {

    return "CampBXOrderBook [bids="
        + bids
        + ", asks="
        + asks
        + ", getSuccess()="
        + getSuccess()
        + ", getInfo()="
        + getInfo()
        + ", getError()="
        + getError()
        + "]";
  }
}
