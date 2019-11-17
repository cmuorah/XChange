package org.knowm.xchange.okcoin.v3.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.Date;
import lombok.Data;

@Data
public class OkexFutureTicker {
  @JsonProperty("instrument_id")
  private String instrumentId;

  private Double last;

  @JsonProperty("best_bid")
  private Double bestBid;

  @JsonProperty("best_ask")
  private Double bestAsk;

  @JsonProperty("high_24h")
  private Double high24h;

  @JsonProperty("low_24h")
  private Double low24h;

  @JsonProperty("volume_24h")
  private Double volume24h;

  private String timestamp;

  @JsonProperty("open_24h")
  private Double open24h;

  @JsonProperty("open_interest")
  private Double openInterest;

  public Date getTimestamp() {
    return Date.from(Instant.parse(timestamp));
  }
}
