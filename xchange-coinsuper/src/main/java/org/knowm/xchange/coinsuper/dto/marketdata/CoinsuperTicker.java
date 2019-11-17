package org.knowm.xchange.coinsuper.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"price", "timestamp", "tradeType", "volume"})
public class CoinsuperTicker {

  @JsonProperty("price")
  private Double price;

  @JsonProperty("timestamp")
  private long timestamp;

  @JsonProperty("tradeType")
  private String tradeType;

  @JsonProperty("volume")
  private Double volume;

  /** No args constructor for use in serialization */
  public CoinsuperTicker() {}

  /**
   * @param timestamp
   * @param tradeType
   * @param price
   * @param volume
   */
  public CoinsuperTicker(Double price, long timestamp, String tradeType, Double volume) {
    super();
    this.price = price;
    this.timestamp = timestamp;
    this.tradeType = tradeType;
    this.volume = volume;
  }

  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  @JsonProperty("price")
  public void setPrice(Double price) {
    this.price = price;
  }

  @JsonProperty("timestamp")
  public long getTimestamp() {
    return timestamp;
  }

  @JsonProperty("timestamp")
  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  @JsonProperty("tradeType")
  public String getTradeType() {
    return tradeType;
  }

  @JsonProperty("tradeType")
  public void setTradeType(String tradeType) {
    this.tradeType = tradeType;
  }

  public CoinsuperTicker withTradeType(String tradeType) {
    this.tradeType = tradeType;
    return this;
  }

  @JsonProperty("volume")
  public Double getVolume() {
    return volume;
  }

  @JsonProperty("volume")
  public void setVolume(Double volume) {
    this.volume = volume;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("price", price)
        .append("timestamp", timestamp)
        .append("tradeType", tradeType)
        .append("volume", volume)
        .toString();
  }
}
