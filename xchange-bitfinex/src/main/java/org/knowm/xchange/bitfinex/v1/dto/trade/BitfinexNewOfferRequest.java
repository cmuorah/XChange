package org.knowm.xchange.bitfinex.v1.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitfinexNewOfferRequest {

  @JsonProperty("request")
  protected String request;

  @JsonProperty("nonce")
  protected String nonce;

  @JsonProperty("currency")
  protected String currency;

  @JsonProperty("amount")
  protected Double amount;

  @JsonProperty("rate")
  protected Double rate;

  @JsonProperty("period")
  protected int period;

  @JsonProperty("direction")
  protected String direction;

  public BitfinexNewOfferRequest(
      String nonce, String currency, Double amount, Double rate, int period, String direction) {

    this.request = "/v1/offer/new";
    this.nonce = nonce;
    this.currency = currency;
    this.amount = amount;
    this.rate = rate;
    this.period = period;
    this.direction = direction;
  }

  public String getRequest() {

    return request;
  }

  public void setRequest(String request) {

    this.request = request;
  }

  public String getNonce() {

    return nonce;
  }

  public void setNonce(String nonce) {

    this.nonce = nonce;
  }

  public String getCurrency() {

    return currency;
  }

  public String getAmount() {

    return amount.toString();
  }

  public String getRate() {

    return rate.toString();
  }

  public int getPeriod() {

    return period;
  }

  public String getDirection() {

    return direction;
  }
}
