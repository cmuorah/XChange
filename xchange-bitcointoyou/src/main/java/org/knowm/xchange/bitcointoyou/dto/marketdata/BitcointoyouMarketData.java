package org.knowm.xchange.bitcointoyou.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

/**
 * @author Danilo Guimaraes
 * @author Jonathas Carrijo
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({"high", "low", "vol", "last", "buy", "buyQty", "sell", "sellQty", "date"})
public class BitcointoyouMarketData {

  private final Double high;
  private final Double low;
  private final Double volume;
  private final Double last;
  private final Double buy;
  private final Double buyQuantity;
  private final Double sell;
  private final Double sellQuantity;
  private final Long date;
  @JsonIgnore private final Map<String, Object> additionalProperties = new HashMap<>();

  public BitcointoyouMarketData(
      @JsonProperty("high") Double high,
      @JsonProperty("low") Double low,
      @JsonProperty("vol") Double volume,
      @JsonProperty("last") Double last,
      @JsonProperty("buy") Double buy,
      @JsonProperty("buyQty") Double buyQuantity,
      @JsonProperty("sell") Double sell,
      @JsonProperty("sellQty") Double sellQuantity,
      @JsonProperty("date") Long date) {
    this.high = high;
    this.low = low;
    this.volume = volume;
    this.last = last;
    this.buy = buy;
    this.buyQuantity = buyQuantity;
    this.sell = sell;
    this.sellQuantity = sellQuantity;
    this.date = date;
  }

  public Double getHigh() {

    return high;
  }

  public Double getLow() {

    return low;
  }

  public Double getVolume() {

    return volume;
  }

  public Double getLast() {

    return last;
  }

  public Double getBuy() {

    return buy;
  }

  public Double getBuyQuantity() {

    return buyQuantity;
  }

  public Double getSell() {

    return sell;
  }

  public Double getSellQuantity() {

    return sellQuantity;
  }

  public Long getDate() {

    return date;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {

    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {

    this.additionalProperties.put(name, value);
  }

  @Override
  public String toString() {
    return String.format(
        "BitcointoyouMarketData [high=%f, low=%f, volume=%f, last=%f, buy=%f, buyQuantity=%f, sell=%f, "
            + "sellQuantity=%f, additionalProperties=%s]",
        high, low, volume, last, buy, buyQuantity, sell, sellQuantity, date);
  }
}
