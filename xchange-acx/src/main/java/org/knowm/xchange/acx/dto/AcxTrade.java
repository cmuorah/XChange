package org.knowm.xchange.acx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class AcxTrade {
  /** Unique ID */
  public final String id;
  /** trade price */
  public final Double price;
  /** trade volume */
  public final Double volume;

  public final Double funds;
  /** the market trade belongs to, like ‘btcaud’ */
  public final String market;
  /** trade time */
  public final Date createdAt;

  public final String trend;
  public final String side;

  public AcxTrade(
      @JsonProperty("id") String id,
      @JsonProperty("price") Double price,
      @JsonProperty("volume") Double volume,
      @JsonProperty("funds") Double funds,
      @JsonProperty("market") String market,
      @JsonProperty("created_at") Date createdAt,
      @JsonProperty("trend") String trend,
      @JsonProperty("side") String side) {
    this.id = id;
    this.price = price;
    this.volume = volume;
    this.funds = funds;
    this.market = market;
    this.createdAt = createdAt;
    this.trend = trend;
    this.side = side;
  }
}
