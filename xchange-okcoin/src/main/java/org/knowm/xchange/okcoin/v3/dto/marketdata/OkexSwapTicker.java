package org.knowm.xchange.okcoin.v3.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.Date;
import lombok.Data;

@Data
public class OkexSwapTicker {

  @JsonProperty("instrument_id")
  private String instrumentId;

  private Double last;

  @JsonProperty("high_24h")
  private Double high24h;

  @JsonProperty("low_24h")
  private Double low24h;

  @JsonProperty("volume_24h")
  private Double volume24h;

  @JsonProperty("best_ask")
  private Double bestAsk;

  @JsonProperty("best_bid")
  private Double bestBid;

  private String timestamp;

  public Date getTimestamp() {
    return Date.from(Instant.parse(timestamp));
  }
}
