package org.knowm.xchange.btcmarkets.dto.trade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Date;
import java.util.List;
import org.knowm.xchange.utils.jackson.MillisecTimestampDeserializer;

@JsonPropertyOrder({
  "currency",
  "instrument",
  "price",
  "volume",
  "orderSide",
  "ordertype",
  "clientRequestId"
})
// @JsonInclude(JsonInclude.Include.NON_NULL)
public class BTCMarketsOrder {

  private Double volume;

  private Double price;

  private String currency;

  private String instrument;

  private Side orderSide;

  private Type ordertype;

  private String clientRequestId;

  private Long id;

  @JsonDeserialize(using = MillisecTimestampDeserializer.class)
  private Date creationTime;

  private String status;

  private String errorMessage;

  private Double openVolume;

  private List<BTCMarketsUserTrade> trades;

  protected BTCMarketsOrder() {}

  public BTCMarketsOrder(
      Double volume,
      Double price,
      String currency,
      String instrument,
      Side orderSide,
      Type ordertype,
      String clientRequestId) {
    this.volume = volume;
    this.price = price;
    this.currency = currency;
    this.instrument = instrument;
    this.orderSide = orderSide;
    this.ordertype = ordertype;
    this.clientRequestId = clientRequestId;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getPrice() {
    return price;
  }

  public String getCurrency() {
    return currency;
  }

  public String getInstrument() {
    return instrument;
  }

  public Side getOrderSide() {
    return orderSide;
  }

  public Type getOrdertype() {
    return ordertype;
  }

  public String getClientRequestId() {
    return clientRequestId;
  }

  @JsonIgnore(true)
  public Long getId() {
    return id;
  }

  @JsonProperty
  @JsonIgnore(false)
  protected void setId(Long id) {
    this.id = id;
  }

  @JsonIgnore(true)
  public Date getCreationTime() {
    return creationTime;
  }

  @JsonProperty
  @JsonIgnore(false)
  protected void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  @JsonIgnore(true)
  public String getStatus() {
    return status;
  }

  @JsonProperty
  @JsonIgnore(false)
  protected void setStatus(String status) {
    this.status = status;
  }

  @JsonIgnore(true)
  public String getErrorMessage() {
    return errorMessage;
  }

  @JsonProperty
  @JsonIgnore(false)
  protected void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @JsonIgnore(true)
  public Double getOpenVolume() {
    return openVolume;
  }

  @JsonProperty
  @JsonIgnore(false)
  protected void setOpenVolume(Double openVolume) {
    this.openVolume = openVolume;
  }

  @JsonIgnore(true)
  public List<BTCMarketsUserTrade> getTrades() {
    return trades;
  }

  @JsonProperty
  @JsonIgnore(false)
  protected void setTrades(List<BTCMarketsUserTrade> trades) {
    this.trades = trades;
  }

  @Override
  public String toString() {
    return String.format(
        "BTCMarketsOrder{volume=%s, price=%s, currency='%s', instrument='%s', orderSide=%s, ordertype=%s, clientRequestId='%s', id=%d, creationTime=%s, status='%s', errorMessage='%s', openVolume=%s, trades=%s}",
        volume,
        price,
        currency,
        instrument,
        orderSide,
        ordertype,
        clientRequestId,
        id,
        creationTime,
        status,
        errorMessage,
        openVolume,
        trades);
  }

  public enum Side {
    Bid,
    Ask
  }

  public enum Type {
    Limit,
    Market
  }
}
