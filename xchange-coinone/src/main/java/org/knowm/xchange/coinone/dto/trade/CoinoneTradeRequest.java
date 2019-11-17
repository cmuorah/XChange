package org.knowm.xchange.coinone.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.currency.Currency;

public class CoinoneTradeRequest {

  @JsonProperty("access_token")
  protected String accessTocken;

  @JsonProperty("nonce")
  protected Long nonce;

  @JsonProperty("price")
  protected Double price;

  @JsonProperty("qty")
  protected Double qty;

  @JsonProperty("currency")
  protected String currency;

  /**
   * Constructor
   *
   * @param nonce
   */
  public CoinoneTradeRequest(
      String accessTocken, Long nonce, Double price, Double qty, Currency currency) {

    this.accessTocken = accessTocken;
    this.nonce = nonce;
    this.price = price;
    this.qty = qty;
    this.currency = currency.getSymbol().toLowerCase();
  }

  public String getAccessTocken() {
    return accessTocken;
  }

  public void setAccessTocken(String accessTocken) {
    this.accessTocken = accessTocken;
  }

  public Long getNonce() {
    return nonce;
  }

  public void setNonce(Long nonce) {
    this.nonce = nonce;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getQty() {
    return qty;
  }

  public void setQty(Double qty) {
    this.qty = qty;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}
