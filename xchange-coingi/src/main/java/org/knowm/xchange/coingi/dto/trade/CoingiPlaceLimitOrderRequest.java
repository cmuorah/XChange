package org.knowm.xchange.coingi.dto.trade;

import org.knowm.xchange.coingi.dto.CoingiAuthenticatedRequest;

public class CoingiPlaceLimitOrderRequest extends CoingiAuthenticatedRequest {
  private String currencyPair;
  private int type;
  private Double price;
  private Double volume;

  public String getCurrencyPair() {
    return currencyPair;
  }

  public CoingiPlaceLimitOrderRequest setCurrencyPair(String pair) {
    this.currencyPair = pair;
    return this;
  }

  public int getType() {
    return type;
  }

  public CoingiPlaceLimitOrderRequest setOrderType(int type) {
    this.type = type;
    return this;
  }

  public Double getPrice() {
    return price;
  }

  public CoingiPlaceLimitOrderRequest setPrice(Double price) {
    this.price = price;
    return this;
  }

  public Double getVolume() {
    return volume;
  }

  public CoingiPlaceLimitOrderRequest setVolume(Double volume) {
    this.volume = volume;
    return this;
  }
}
