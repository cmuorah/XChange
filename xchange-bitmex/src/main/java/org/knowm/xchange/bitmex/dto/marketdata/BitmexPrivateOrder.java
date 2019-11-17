package org.knowm.xchange.bitmex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.knowm.xchange.bitmex.AbstractHttpResponseAware;
import org.knowm.xchange.bitmex.dto.trade.BitmexSide;

/** see field description at http://www.onixs.biz/fix-dictionary/5.0.SP2/fields_by_name.html */
public class BitmexPrivateOrder extends AbstractHttpResponseAware {

  private final Double price;
  private final Double size;
  private final String symbol;
  private final String id;
  private final String clOrdID;
  private final BitmexSide side;
  private final Date timestamp;
  private final OrderStatus orderStatus;
  private final String currency;
  private final String settleCurrency;

  private final String clOrdLinkID;

  private final Double simpleOrderQty;
  private final Double displayQty;
  private final Double stopPx;
  private final Double pegOffsetValue;
  private final String pegPriceType;
  private final String orderType;
  private final String timeInForce;
  private final String execInst;
  private final String contingencyType;
  private final String exDestination;
  private final String triggered;
  private final boolean workingIndicator;
  private final String ordRejReason;

  private final Double simpleLeavesQty;
  private final Double leavesQty;
  private final Double simpleCumQty;
  private final Double cumQty;
  private final Double avgPx;

  private final String multiLegReportingType;
  private final String text;

  // "2018-06-03T05:22:49.018Z"
  private final Date transactTime;

  private final String error;

  public BitmexPrivateOrder(
      @JsonProperty("price") Double price,
      @JsonProperty("orderID") String id,
      @JsonProperty("orderQty") Double size,
      @JsonProperty("side") BitmexSide side,
      @JsonProperty("symbol") String symbol,
      @JsonProperty("clOrdID") String clOrdID,
      @JsonProperty("timestamp") Date timestamp,
      @JsonProperty("ordStatus") OrderStatus orderStatus,
      @JsonProperty("currency") String currency,
      @JsonProperty("settlCurrency") String settleCurrency,
      @JsonProperty("clOrdLinkID") String clOrdLinkID,
      @JsonProperty("simpleOrderQty") Double simpleOrderQty,
      @JsonProperty("displayQty") Double displayQty,
      @JsonProperty("stopPx") Double stopPx,
      @JsonProperty("pegOffsetValue") Double pegOffsetValue,
      @JsonProperty("pegPriceType") String pegPriceType,
      @JsonProperty("orderType") String orderType,
      @JsonProperty("timeInForce") String timeInForce,
      @JsonProperty("execInst") String execInst,
      @JsonProperty("contingencyType") String contingencyType,
      @JsonProperty("exDestination") String exDestination,
      @JsonProperty("triggered") String triggered,
      @JsonProperty("workingIndicator") boolean workingIndicator,
      @JsonProperty("ordRejReason") String ordRejReason,
      @JsonProperty("simpleLeavesQty") Double simpleLeavesQty,
      @JsonProperty("leavesQty") Double leavesQty,
      @JsonProperty("simpleCumQty") Double simpleCumQty,
      @JsonProperty("cumQty") Double cumQty,
      @JsonProperty("avgPx") Double avgPx,
      @JsonProperty("multiLegReportingType") String multiLegReportingType,
      @JsonProperty("text") String text,
      @JsonProperty("transactTime") Date transactTime,
      @JsonProperty("error") String error) {

    this.symbol = symbol;
    this.id = id;
    this.side = side;
    this.size = size;
    this.price = price;
    this.clOrdID = clOrdID;
    this.timestamp = timestamp;
    this.orderStatus = orderStatus;
    this.currency = currency;
    this.settleCurrency = settleCurrency;

    this.clOrdLinkID = clOrdLinkID;
    this.simpleOrderQty = simpleOrderQty;
    this.displayQty = displayQty;
    this.stopPx = stopPx;
    this.pegOffsetValue = pegOffsetValue;
    this.pegPriceType = pegPriceType;
    this.orderType = orderType;
    this.timeInForce = timeInForce;
    this.execInst = execInst;
    this.contingencyType = contingencyType;
    this.exDestination = exDestination;
    this.triggered = triggered;
    this.workingIndicator = workingIndicator;
    this.ordRejReason = ordRejReason;
    this.simpleLeavesQty = simpleLeavesQty;
    this.leavesQty = leavesQty;
    this.simpleCumQty = simpleCumQty;
    this.cumQty = cumQty;
    this.avgPx = avgPx;
    this.multiLegReportingType = multiLegReportingType;
    this.text = text;
    this.transactTime = transactTime;
    this.error = error;
  }

  public Double getPrice() {

    return price;
  }

  public Double getVolume() {

    return size;
  }

  public BitmexSide getSide() {

    return side;
  }

  public String getId() {

    return id;
  }

  public String getSymbol() {

    return symbol;
  }

  public Date getTimestamp() {

    return timestamp;
  }

  public OrderStatus getOrderStatus() {

    return orderStatus;
  }

  public String getCurrency() {
    return currency;
  }

  public String getSettleCurrency() {
    return settleCurrency;
  }

  public String getClOrdID() {
    return clOrdID;
  }

  public String getClOrdLinkID() {
    return clOrdLinkID;
  }

  public Double getSimpleOrderQty() {
    return simpleOrderQty;
  }

  public Double getDisplayQty() {
    return displayQty;
  }

  public Double getStopPx() {
    return stopPx;
  }

  public Double getPegOffsetValue() {
    return pegOffsetValue;
  }

  public String getPegPriceType() {
    return pegPriceType;
  }

  public String getOrderType() {
    return orderType;
  }

  public String getTimeInForce() {
    return timeInForce;
  }

  public String getExecInst() {
    return execInst;
  }

  public String getContingencyType() {
    return contingencyType;
  }

  public String getExDestination() {
    return exDestination;
  }

  public String getTriggered() {
    return triggered;
  }

  public boolean isWorkingIndicator() {
    return workingIndicator;
  }

  public String getOrdRejReason() {
    return ordRejReason;
  }

  public Double getSimpleLeavesQty() {
    return simpleLeavesQty;
  }

  public Double getLeavesQty() {
    return leavesQty;
  }

  public Double getSimpleCumQty() {
    return simpleCumQty;
  }

  public Double getCumQty() {
    return cumQty;
  }

  public Double getAvgPx() {
    return avgPx;
  }

  public String getMultiLegReportingType() {
    return multiLegReportingType;
  }

  public String getText() {
    return text;
  }

  public Date getTransactTime() {
    return transactTime;
  }

  public String getError() {
    return error;
  }

  @Override
  public String toString() {
    return "BitmexPrivateOrder{"
        + "price="
        + price
        + ", size="
        + size
        + ", symbol='"
        + symbol
        + '\''
        + ", id='"
        + id
        + '\''
        + ", side="
        + side
        + ", timestamp="
        + timestamp
        + ", orderStatus="
        + orderStatus
        + ", currency='"
        + currency
        + '\''
        + ", settleCurrency='"
        + settleCurrency
        + '\''
        + ", clOrdID='"
        + clOrdID
        + '\''
        + ", clOrdLinkID='"
        + clOrdLinkID
        + '\''
        + ", simpleOrderQty="
        + simpleOrderQty
        + ", displayQty="
        + displayQty
        + ", stopPx="
        + stopPx
        + ", pegOffsetValue='"
        + pegOffsetValue
        + '\''
        + ", pegPriceType='"
        + pegPriceType
        + '\''
        + ", orderType='"
        + orderType
        + '\''
        + ", timeInForce='"
        + timeInForce
        + '\''
        + ", execInst='"
        + execInst
        + '\''
        + ", contingencyType='"
        + contingencyType
        + '\''
        + ", exDestination='"
        + exDestination
        + '\''
        + ", triggered='"
        + triggered
        + '\''
        + ", workingIndicator="
        + workingIndicator
        + ", ordRejReason='"
        + ordRejReason
        + '\''
        + ", simpleLeavesQty="
        + simpleLeavesQty
        + ", leavesQty="
        + leavesQty
        + ", simpleCumQty="
        + simpleCumQty
        + ", cumQty="
        + cumQty
        + ", avgPx="
        + avgPx
        + ", multiLegReportingType='"
        + multiLegReportingType
        + '\''
        + ", text='"
        + text
        + '\''
        + ", transactTime='"
        + transactTime
        + '\''
        + ", error='"
        + error
        + '\''
        + '}';
  }

  public enum OrderStatus {
    New,
    PartiallyFilled,
    Filled,
    Canceled,
    Rejected,
    Replaced
  }
}
