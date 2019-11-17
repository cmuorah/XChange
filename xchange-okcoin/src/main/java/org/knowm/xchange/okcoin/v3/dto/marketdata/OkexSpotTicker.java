package org.knowm.xchange.okcoin.v3.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.Date;
import lombok.Data;

@Data
public class OkexSpotTicker {

  @JsonProperty("best_ask")
  private Double bestAsk;

  @JsonProperty("best_bid")
  private Double bestBid;

  @JsonProperty("instrument_id")
  private String instrumentId;

  @JsonProperty("product_id")
  private String productId;

  private Double last;
  private Double ask;
  private Double bid;

  @JsonProperty("open_24h")
  private Double open24h;

  @JsonProperty("high_24h")
  private Double high24h;

  @JsonProperty("low_24h")
  private Double low24h;

  @JsonProperty("base_volume_24h")
  private Double baseVolume24h;

  private String timestamp;

  @JsonProperty("quote_volume_24h")
  private Double quoteVolume24h;

  public Date getTimestamp() {
    return Date.from(Instant.parse(timestamp));
  }
}
