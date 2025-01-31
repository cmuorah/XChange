package org.knowm.xchange.paymium.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;

public class PaymiumOrder {

  @JsonProperty("account_operations")
  private List<PaymiumAccountOperations> accountOperations;

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("bitcoin_address")
  private String bitcoinAddress;

  @JsonProperty("btc_fee")
  private Double btcFee;

  @JsonProperty("comment")
  private String comment;

  @JsonProperty("created_at")
  private Date createdAt;

  @JsonProperty("currency")
  private String currency;

  @JsonProperty("currency_amount")
  private Double currencyAmount;

  @JsonProperty("currency_fee")
  private Double currencyFee;

  @JsonProperty("direction")
  private String direction;

  @JsonProperty("price")
  private Double price;

  @JsonProperty("state")
  private String state;

  @JsonProperty("traded_btc")
  private Double tradedBtc;

  @JsonProperty("traded_currency")
  private Double tradedCurrency;

  @JsonProperty("tx_id")
  private String txid;

  @JsonProperty("type")
  private String type;

  @JsonProperty("updated_at")
  private Date updatedAt;

  @JsonProperty("uuid")
  private String uuid;

  @Override
  public String toString() {
    return "PaymiumOrder [accountOperations="
        + accountOperations
        + ", bitcoinAddress= "
        + bitcoinAddress
        + ", btcFee="
        + btcFee
        + ", comment= "
        + comment
        + ", createdAt="
        + createdAt
        + ", currency= "
        + currency
        + ", currencyAmount="
        + currencyAmount
        + ", currencyFee= "
        + currencyFee
        + ", direction="
        + direction
        + ", price= "
        + price
        + ", state="
        + state
        + ", tradedBtc= "
        + tradedBtc
        + ", tradedCurrency="
        + tradedCurrency
        + ", txid= "
        + txid
        + ", type="
        + type
        + ", updatedAt= "
        + updatedAt
        + ", uuid="
        + uuid
        + "]";
  }

  public List<PaymiumAccountOperations> getAccountOperations() {
    return accountOperations;
  }

  public void setAccountOperations(List<PaymiumAccountOperations> accountOperations) {
    this.accountOperations = accountOperations;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public String getBitcoinAddress() {
    return bitcoinAddress;
  }

  public void setBitcoinAddress(String bitcoinAddress) {
    this.bitcoinAddress = bitcoinAddress;
  }

  public Double getBtcFee() {
    return btcFee;
  }

  public void setBtcFee(Double btcFee) {
    this.btcFee = btcFee;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Double getCurrencyAmount() {
    return currencyAmount;
  }

  public void setCurrencyAmount(Double currencyAmount) {
    this.currencyAmount = currencyAmount;
  }

  public Double getCurrencyFee() {
    return currencyFee;
  }

  public void setCurrencyFee(Double currencyFee) {
    this.currencyFee = currencyFee;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Double getTradedBtc() {
    return tradedBtc;
  }

  public void setTradedBtc(Double tradedBtc) {
    this.tradedBtc = tradedBtc;
  }

  public Double getTradedCurrency() {
    return tradedCurrency;
  }

  public void setTradedCurrency(Double tradedCurrency) {
    this.tradedCurrency = tradedCurrency;
  }

  public String getTxid() {
    return txid;
  }

  public void setTxid(String txid) {
    this.txid = txid;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }
}
