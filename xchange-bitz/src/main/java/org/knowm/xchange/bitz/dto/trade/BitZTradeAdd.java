package org.knowm.xchange.bitz.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Implement Once Implemented By The Exchange
public class BitZTradeAdd {
  private final long id;
  private final long uId;
  private final Double price;
  private final Double number;
  private final Double numberOver;
  private final String flag;
  private final String status;
  private final String coinFrom;
  private final String coinTo;
  private final Double numberDeal;

  public BitZTradeAdd(
      @JsonProperty("id") long id,
      @JsonProperty("uId") long uId,
      @JsonProperty("price") Double price,
      @JsonProperty("number") Double number,
      @JsonProperty("numberOver") Double numberOver,
      @JsonProperty("flag") String flag,
      @JsonProperty("status") String status,
      @JsonProperty("coinFrom") String coinFrom,
      @JsonProperty("coinTo") String coinTo,
      @JsonProperty("numberDeal") Double numberDeal) {
    this.id = id;
    this.uId = uId;
    this.price = price;
    this.number = number;
    this.numberOver = numberOver;
    this.flag = flag;
    this.status = status;
    this.coinFrom = coinFrom;
    this.coinTo = coinTo;
    this.numberDeal = numberDeal;
  }

  public long getId() {
    return id;
  }

  public long getuId() {
    return uId;
  }

  public Double getPrice() {
    return price;
  }

  public Double getNumber() {
    return number;
  }

  public String getFlag() {
    return flag;
  }

  public String getStatus() {
    return status;
  }

  public String getCoinFrom() {
    return coinFrom;
  }

  public String getCoinTo() {
    return coinTo;
  }

  public Double getNumberDeal() {
    return numberDeal;
  }

  public Double getNumberOver() {
    return numberOver;
  }

  @Override
  public String toString() {
    return "BitZTradeAdd{"
        + "id="
        + id
        + ", uId="
        + uId
        + ", price="
        + price
        + ", number="
        + number
        + ", numberOver="
        + numberOver
        + ", flag='"
        + flag
        + '\''
        + ", status='"
        + status
        + '\''
        + ", coinFrom='"
        + coinFrom
        + '\''
        + ", coinTo='"
        + coinTo
        + '\''
        + ", numberDeal="
        + numberDeal
        + '}';
  }
}
