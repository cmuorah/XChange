package org.knowm.xchange.cryptofacilities.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;
import java.util.Date;
import org.knowm.xchange.cryptofacilities.Util;
import org.knowm.xchange.cryptofacilities.dto.CryptoFacilitiesResult;

/** @author Jean-Christophe Laruelle */
public class CryptoFacilitiesOpenOrder extends CryptoFacilitiesResult {

  private final Date receivedTime;
  private final String status;
  private final String order_id;
  private final String orderType;
  private final String symbol;
  private final String side;
  private final Double unfilledSize;
  private final Double filledSize;
  private final Double limitPrice;
  private final Double stopPrice;

  public CryptoFacilitiesOpenOrder(
      @JsonProperty("result") String result,
      @JsonProperty("error") String error,
      @JsonProperty("receivedTime") String strReceivedTime,
      @JsonProperty("status") String status,
      @JsonProperty("order_id") String order_id,
      @JsonProperty("orderType") String orderType,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("side") String side,
      @JsonProperty("unfilledSize") Double unfilledSize,
      @JsonProperty("filledSize") Double filledSize,
      @JsonProperty("limitPrice") Double limitPrice,
      @JsonProperty("stopPrice") Double stopPrice)
      throws ParseException {

    super(result, error);

    this.receivedTime = Util.parseDate(strReceivedTime);
    this.status = status;
    this.order_id = order_id;
    this.orderType = orderType;
    this.symbol = symbol;
    this.side = side;
    this.unfilledSize = unfilledSize;
    this.filledSize = filledSize;
    this.limitPrice = limitPrice;
    this.stopPrice = stopPrice;
  }

  public Date getTimestamp() {
    return receivedTime;
  }

  public String getStatus() {
    return status;
  }

  public String getId() {
    return order_id;
  }

  public String getType() {
    return orderType;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getDirection() {
    return side;
  }

  public Double getUnfilled() {
    return unfilledSize;
  }

  public Double getFilled() {
    return filledSize;
  }

  public Double getQuantity() {
    return filledSize + (unfilledSize);
  }

  public Double getLimitPrice() {
    return limitPrice;
  }

  public Double getStopPrice() {
    return stopPrice;
  }

  @Override
  public String toString() {
    return "CryptoFacilitiesOpenOrder [order_id="
        + order_id
        + ", status="
        + status
        + ", orderType="
        + orderType
        + ", symbol="
        + symbol
        + ", dir="
        + side
        + ", unfilled="
        + unfilledSize
        + ", filled="
        + filledSize
        + ", qty="
        + getQuantity()
        + ", limitPrice="
        + limitPrice
        + ", stopPrice="
        + stopPrice
        + ", receivedTime="
        + receivedTime
        + "]";
  }
}
