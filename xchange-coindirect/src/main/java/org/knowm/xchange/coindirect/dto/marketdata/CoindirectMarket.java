package org.knowm.xchange.coindirect.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoindirectMarket {
  public final long id;
  public final Double maximumPrice;
  public final Double minimumPrice;
  public final Double maximumQuantity;
  public final Double minimumQuantity;
  public final String status;
  public final Double stepSize;
  public final Double tickSize;
  public final String symbol;
  public final CoindirectMarketSummary summary;

  public CoindirectMarket(
      @JsonProperty("id") long id,
      @JsonProperty("maximumPrice") Double maximumPrice,
      @JsonProperty("minimumPrice") Double minimumPrice,
      @JsonProperty("maximumQuantity") Double maximumQuantity,
      @JsonProperty("minimumQuantity") Double minimumQuantity,
      @JsonProperty("status") String status,
      @JsonProperty("stepSize") Double stepSize,
      @JsonProperty("tickSize") Double tickSize,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("summary") CoindirectMarketSummary summary) {
    this.id = id;
    this.maximumPrice = maximumPrice;
    this.minimumPrice = minimumPrice;
    this.maximumQuantity = maximumQuantity;
    this.minimumQuantity = minimumQuantity;
    this.status = status;
    this.stepSize = stepSize;
    this.tickSize = tickSize;
    this.symbol = symbol;
    this.summary = summary;
  }

  @Override
  public String toString() {
    return "CoindirectMarket{"
        + "id="
        + id
        + ", maximumPrice="
        + maximumPrice
        + ", minimumPrice="
        + minimumPrice
        + ", maximumQuantity="
        + maximumQuantity
        + ", minimumQuantity="
        + minimumQuantity
        + ", status='"
        + status
        + '\''
        + ", stepSize="
        + stepSize
        + ", tickSize="
        + tickSize
        + ", symbol='"
        + symbol
        + '\''
        + ", summary="
        + summary
        + '}';
  }
}
