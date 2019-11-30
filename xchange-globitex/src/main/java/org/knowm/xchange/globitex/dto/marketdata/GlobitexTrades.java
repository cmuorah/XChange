package org.knowm.xchange.globitex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.openhft.chronicle.wire.AbstractMarshallable;

import java.io.Serializable;
import java.util.List;

public class GlobitexTrades extends AbstractMarshallable implements Serializable {

  @JsonProperty("trades")
  private final List<GlobitexTrade> recentTrades;

  public GlobitexTrades(@JsonProperty("trades") List<GlobitexTrade> recentTrades) {
    this.recentTrades = recentTrades;
  }

  public List<GlobitexTrade> getRecentTrades() {
    return recentTrades;
  }

  @Override
  public String toString() {
    return "GlobitexTrades{" + "recentTrades=" + recentTrades + '}';
  }
}
