package org.knowm.xchange.kraken.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Set;
import org.knowm.xchange.kraken.dto.trade.KrakenOrderFlags.KrakenOrderFlagsDeserializer;

public class KrakenOpenPosition {

  private final String orderTxId;
  private final String assetPair;
  private final long tradeUnixTimestamp;
  private final KrakenType type;
  private final KrakenOrderType orderType;
  private final Double cost;
  private final Double fee;
  private final Double volume;
  private final Double volumeClosed;
  private final Double margin;
  private final Double value;
  private final Double netDifference;
  private final String miscellaneous;
  private final Set<KrakenOrderFlags> orderFlags;
  private final Double volumeInQuoteCurrency;

  /**
   * Constructor
   *
   * @param orderTxId
   * @param assetPair
   * @param tradeUnixTimestamp
   * @param type
   * @param orderType
   * @param cost
   * @param fee
   * @param volume
   * @param volumeClosed
   * @param margin
   * @param value
   * @param netDifference
   * @param miscellaneous
   * @param orderFlags
   * @param volumeInQuoteCurrency
   */
  public KrakenOpenPosition(
      @JsonProperty("ordertxid") String orderTxId,
      @JsonProperty("pair") String assetPair,
      @JsonProperty("time") long tradeUnixTimestamp,
      @JsonProperty("type") KrakenType type,
      @JsonProperty("ordertype") KrakenOrderType orderType,
      @JsonProperty("cost") Double cost,
      @JsonProperty("fee") Double fee,
      @JsonProperty("vol") Double volume,
      @JsonProperty("vol_closed") Double volumeClosed,
      @JsonProperty("margin") Double margin,
      @JsonProperty("volue") Double value,
      @JsonProperty("net") Double netDifference,
      @JsonProperty("misc") String miscellaneous,
      @JsonProperty("oflags") @JsonDeserialize(using = KrakenOrderFlagsDeserializer.class)
          Set<KrakenOrderFlags> orderFlags,
      @JsonProperty("viqc") Double volumeInQuoteCurrency) {

    this.orderTxId = orderTxId;
    this.assetPair = assetPair;
    this.tradeUnixTimestamp = tradeUnixTimestamp;
    this.type = type;
    this.orderType = orderType;
    this.cost = cost;
    this.fee = fee;
    this.volume = volume;
    this.volumeClosed = volumeClosed;
    this.margin = margin;
    this.value = value;
    this.netDifference = netDifference;
    this.miscellaneous = miscellaneous;
    this.orderFlags = orderFlags;
    this.volumeInQuoteCurrency = volumeInQuoteCurrency;
  }

  public String getOrderTxId() {

    return orderTxId;
  }

  public String getAssetPair() {

    return assetPair;
  }

  public long getTradeUnixTimestamp() {

    return tradeUnixTimestamp;
  }

  public KrakenType getType() {

    return type;
  }

  public KrakenOrderType getOrderType() {

    return orderType;
  }

  public Double getCost() {

    return cost;
  }

  public Double getFee() {

    return fee;
  }

  public Double getVolume() {

    return volume;
  }

  public Double getVolumeClosed() {

    return volumeClosed;
  }

  public Double getMargin() {

    return margin;
  }

  public Double getValue() {

    return value;
  }

  public Double getNetDifference() {

    return netDifference;
  }

  public String getMiscellaneous() {

    return miscellaneous;
  }

  public Set<KrakenOrderFlags> getOrderFlags() {

    return orderFlags;
  }

  public Double getVolumeInQuoteCurrency() {

    return volumeInQuoteCurrency;
  }

  @Override
  public String toString() {

    return "KrakenOpenPosition [orderTxId="
        + orderTxId
        + ", assetPair="
        + assetPair
        + ", tradeUnixTimestamp="
        + tradeUnixTimestamp
        + ", type="
        + type
        + ", orderType="
        + orderType
        + ", cost="
        + cost
        + ", fee="
        + fee
        + ", volume="
        + volume
        + ", volumeClosed="
        + volumeClosed
        + ", margin="
        + margin
        + ", value="
        + value
        + ", netDifference="
        + netDifference
        + ", miscellaneous="
        + miscellaneous
        + ", orderFlags="
        + orderFlags
        + ", volumeInQuoteCurrency="
        + volumeInQuoteCurrency
        + "]";
  }
}
