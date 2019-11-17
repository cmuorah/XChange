package org.knowm.xchange.kraken.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class KrakenTrade {

  private final String orderTxId;
  private final String assetPair;
  private final double unixTimestamp;
  private final KrakenType type;
  private final KrakenOrderType orderType;
  private final Double price;
  private final Double cost;
  private final Double fee;
  private final Double volume;
  private final Double margin;
  private final String miscellaneous;
  private final String closing;
  private final String positionStatus;
  private final Double averageClosePrice;
  private final Double closeCost;
  private final Double closeFee;
  private final Double closeVolume;
  private final Double closeMargin;
  private final Double netDifference;
  private final List<String> tradeIds;

  /**
   * Constructor
   *
   * @param orderTxId
   * @param assetPair
   * @param unixTimestamp
   * @param type
   * @param orderType
   * @param price
   * @param cost
   * @param fee
   * @param volume
   * @param margin
   * @param miscellaneous
   * @param closing
   * @param positionStatus
   * @param averageClosePrice
   * @param closeCost
   * @param closeFee
   * @param closeVolume
   * @param closeMargin
   * @param netDifference
   * @param tradeIds
   */
  public KrakenTrade(
      @JsonProperty("ordertxid") String orderTxId,
      @JsonProperty("pair") String assetPair,
      @JsonProperty("time") double unixTimestamp,
      @JsonProperty("type") KrakenType type,
      @JsonProperty("ordertype") KrakenOrderType orderType,
      @JsonProperty("price") Double price,
      @JsonProperty("cost") Double cost,
      @JsonProperty("fee") Double fee,
      @JsonProperty("vol") Double volume,
      @JsonProperty("margin") Double margin,
      @JsonProperty("misc") String miscellaneous,
      @JsonProperty("closing") String closing,
      @JsonProperty("posstatus") String positionStatus,
      @JsonProperty("cprice") Double averageClosePrice,
      @JsonProperty("ccost") Double closeCost,
      @JsonProperty("cfee") Double closeFee,
      @JsonProperty("cvol") Double closeVolume,
      @JsonProperty("cmargin") Double closeMargin,
      @JsonProperty("net") Double netDifference,
      @JsonProperty("trades") List<String> tradeIds) {

    this.orderTxId = orderTxId;
    this.assetPair = assetPair;
    this.unixTimestamp = unixTimestamp;
    this.type = type;
    this.orderType = orderType;
    this.price = price;
    this.cost = cost;
    this.fee = fee;
    this.volume = volume;
    this.margin = margin;
    this.miscellaneous = miscellaneous;
    this.closing = closing;
    this.positionStatus = positionStatus;
    this.averageClosePrice = averageClosePrice;
    this.closeCost = closeCost;
    this.closeFee = closeFee;
    this.closeVolume = closeVolume;
    this.closeMargin = closeMargin;
    this.netDifference = netDifference;
    this.tradeIds = tradeIds;
  }

  public String getOrderTxId() {

    return orderTxId;
  }

  public String getAssetPair() {

    return assetPair;
  }

  public double getUnixTimestamp() {

    return unixTimestamp;
  }

  public KrakenType getType() {

    return type;
  }

  public KrakenOrderType getOrderType() {

    return orderType;
  }

  public Double getPrice() {

    return price;
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

  public Double getMargin() {

    return margin;
  }

  public String getMiscellaneous() {

    return miscellaneous;
  }

  public String getClosing() {

    return closing;
  }

  public String getPositionStatus() {

    return positionStatus;
  }

  public Double getAverageClosePrice() {

    return averageClosePrice;
  }

  public Double getCloseCost() {

    return closeCost;
  }

  public Double getCloseFee() {

    return closeFee;
  }

  public Double getCloseVolume() {

    return closeVolume;
  }

  public Double getCloseMargin() {

    return closeMargin;
  }

  public Double getNetDifference() {

    return netDifference;
  }

  public List<String> getTradeIds() {

    return tradeIds;
  }

  @Override
  public String toString() {

    return "KrakenTrade [orderTxId="
        + orderTxId
        + ", assetPair="
        + assetPair
        + ", unixTimestamp="
        + unixTimestamp
        + ", type="
        + type
        + ", orderType="
        + orderType
        + ", price="
        + price
        + ", cost="
        + cost
        + ", fee="
        + fee
        + ", volume="
        + volume
        + ", margin="
        + margin
        + ", miscellaneous="
        + miscellaneous
        + ", closing="
        + closing
        + ", positionStatus="
        + positionStatus
        + ", averageClosePrice="
        + averageClosePrice
        + ", closeCost="
        + closeCost
        + ", closeFee="
        + closeFee
        + ", closeVolume="
        + closeVolume
        + ", closeMargin="
        + closeMargin
        + ", netDifference="
        + netDifference
        + ", tradeIds="
        + tradeIds
        + "]";
  }
}
