package org.knowm.xchange.bitflyer.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "product_code",
  "timestamp",
  "tick_id",
  "best_bid",
  "best_ask",
  "best_bid_size",
  "best_ask_size",
  "total_bid_depth",
  "total_ask_depth",
  "ltp",
  "volume",
  "volume_by_product"
})
public class BitflyerTicker {
  @JsonProperty("product_code")
  private String productCode;

  @JsonProperty("timestamp")
  private String timestamp;

  @JsonProperty("tick_id")
  private Integer tickId;

  @JsonProperty("best_bid")
  private Double bestBid;

  @JsonProperty("best_ask")
  private Double bestAsk;

  @JsonProperty("best_bid_size")
  private Double bestBidSize;

  @JsonProperty("best_ask_size")
  private Double bestAskSize;

  @JsonProperty("total_bid_depth")
  private Double totalBidDepth;

  @JsonProperty("total_ask_depth")
  private Double totalAskDepth;

  @JsonProperty("ltp")
  private Double ltp;

  @JsonProperty("volume")
  private Double volume;

  @JsonProperty("volume_by_product")
  private Double volumeByProduct;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<>();

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getTickId() {
    return tickId;
  }

  public void setTickId(Integer tickId) {
    this.tickId = tickId;
  }

  public Double getBestBid() {
    return bestBid;
  }

  public void setBestBid(Double bestBid) {
    this.bestBid = bestBid;
  }

  public Double getBestAsk() {
    return bestAsk;
  }

  public void setBestAsk(Double bestAsk) {
    this.bestAsk = bestAsk;
  }

  public Double getBestBidSize() {
    return bestBidSize;
  }

  public void setBestBidSize(Double bestBidSize) {
    this.bestBidSize = bestBidSize;
  }

  public Double getBestAskSize() {
    return bestAskSize;
  }

  public void setBestAskSize(Double bestAskSize) {
    this.bestAskSize = bestAskSize;
  }

  public Double getTotalBidDepth() {
    return totalBidDepth;
  }

  public void setTotalBidDepth(Double totalBidDepth) {
    this.totalBidDepth = totalBidDepth;
  }

  public Double getTotalAskDepth() {
    return totalAskDepth;
  }

  public void setTotalAskDepth(Double totalAskDepth) {
    this.totalAskDepth = totalAskDepth;
  }

  public Double getLtp() {
    return ltp;
  }

  public void setLtp(Double ltp) {
    this.ltp = ltp;
  }

  public Double getVolume() {
    return volume;
  }

  public void setVolume(Double volume) {
    this.volume = volume;
  }

  public Double getVolumeByProduct() {
    return volumeByProduct;
  }

  public void setVolumeByProduct(Double volumeByProduct) {
    this.volumeByProduct = volumeByProduct;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }

  @Override
  public String toString() {
    return "BitflyerTicker{"
        + "productCode='"
        + productCode
        + '\''
        + ", timestamp='"
        + timestamp
        + '\''
        + ", tickId="
        + tickId
        + ", bestBid="
        + bestBid
        + ", bestAsk="
        + bestAsk
        + ", bestBidSize="
        + bestBidSize
        + ", bestAskSize="
        + bestAskSize
        + ", totalBidDepth="
        + totalBidDepth
        + ", totalAskDepth="
        + totalAskDepth
        + ", ltp="
        + ltp
        + ", volume="
        + volume
        + ", volumeByProduct="
        + volumeByProduct
        + ", additionalProperties="
        + additionalProperties
        + '}';
  }
}
