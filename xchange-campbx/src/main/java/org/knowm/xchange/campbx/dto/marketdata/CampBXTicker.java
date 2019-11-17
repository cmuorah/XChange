package org.knowm.xchange.campbx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.campbx.dto.CampBXResponse;

/** @author Matija Mazi */
public final class CampBXTicker extends CampBXResponse {

  @JsonProperty("Last Trade")
  private Double last;

  @JsonProperty("Best Bid")
  private Double bid;

  @JsonProperty("Best Ask")
  private Double ask;

  public Double getLast() {

    return last;
  }

  public void setLast(Double last) {

    this.last = last;
  }

  public Double getBid() {

    return bid;
  }

  public void setBid(Double bid) {

    this.bid = bid;
  }

  public Double getAsk() {

    return ask;
  }

  public void setAsk(Double ask) {

    this.ask = ask;
  }

  @Override
  public String toString() {

    return "CampBXTicker [last="
        + last
        + ", bid="
        + bid
        + ", ask="
        + ask
        + ", getSuccess()="
        + getSuccess()
        + ", getInfo()="
        + getInfo()
        + ", getError()="
        + getError()
        + "]";
  }
}
