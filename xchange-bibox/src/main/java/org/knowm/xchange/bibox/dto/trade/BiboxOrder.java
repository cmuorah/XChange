package org.knowm.xchange.bibox.dto.trade;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

/** @author odrotleff */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
  "id",
  "createdAt",
  "account_type",
  "coin_symbol",
  "currency_symbol",
  "order_side",
  "order_type",
  "price",
  "amount",
  "money",
  "deal_amount",
  "deal_percent",
  "status",
  "unexecuted"
})
public class BiboxOrder {

  @JsonProperty("id")
  private String id;

  @JsonProperty("createdAt")
  private long createdAt;

  @JsonProperty("account_type")
  private BiboxAccountType accountType;

  @JsonProperty("coin_symbol")
  private String coinSymbol;

  @JsonProperty("currency_symbol")
  private String currencySymbol;

  @JsonProperty("order_side")
  private BiboxOrderSide orderSide;

  @JsonProperty("order_type")
  private BiboxOrderType orderType;

  @JsonProperty("price")
  private Double price;

  @JsonProperty("amount")
  private Double amount;

  @JsonProperty("money")
  private Double money;

  @JsonProperty("deal_amount")
  private Double dealAmount;

  @JsonProperty("deal_percent")
  private String dealPercent;

  @JsonProperty("status")
  private BiboxOrderStatus status;

  @JsonProperty("unexecuted")
  private Double unexecuted;
  /** only for order history */
  @JsonProperty("fee")
  private Double fee;

  @JsonProperty("fee_symbol")
  private String feeSymbol;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /** @return The id */
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  /** @param id The id */
  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  /** @return The createdAt */
  @JsonProperty("createdAt")
  public long getCreatedAt() {
    return createdAt;
  }

  /** @param createdAt The createdAt */
  @JsonProperty("createdAt")
  public void setCreatedAt(long createdAt) {
    this.createdAt = createdAt;
  }

  /** @return The accountType */
  @JsonProperty("account_type")
  public BiboxAccountType getAccountType() {
    return accountType;
  }

  /** @param accountType The account_type */
  @JsonProperty("account_type")
  public void setAccountType(BiboxAccountType accountType) {
    this.accountType = accountType;
  }

  /** @return The coinSymbol */
  @JsonProperty("coin_symbol")
  public String getCoinSymbol() {
    return coinSymbol;
  }

  /** @param coinSymbol The coin_symbol */
  @JsonProperty("coin_symbol")
  public void setCoinSymbol(String coinSymbol) {
    this.coinSymbol = coinSymbol;
  }

  /** @return The currencySymbol */
  @JsonProperty("currency_symbol")
  public String getCurrencySymbol() {
    return currencySymbol;
  }

  /** @param currencySymbol The currency_symbol */
  @JsonProperty("currency_symbol")
  public void setCurrencySymbol(String currencySymbol) {
    this.currencySymbol = currencySymbol;
  }

  /** @return The orderSide */
  @JsonProperty("order_side")
  public BiboxOrderSide getOrderSide() {
    return orderSide;
  }

  /** @param orderSide The order_side */
  @JsonProperty("order_side")
  public void setOrderSide(BiboxOrderSide orderSide) {
    this.orderSide = orderSide;
  }

  /** @return The orderType */
  @JsonProperty("order_type")
  public BiboxOrderType getOrderType() {
    return orderType;
  }

  /** @param orderType The order_type */
  @JsonProperty("order_type")
  public void setOrderType(BiboxOrderType orderType) {
    this.orderType = orderType;
  }

  /** @return The price */
  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  /** @param price The price */
  @JsonProperty("price")
  public void setPrice(Double price) {
    this.price = price;
  }

  /** @return The amount */
  @JsonProperty("amount")
  public Double getAmount() {
    return amount;
  }

  /** @param amount The amount */
  @JsonProperty("amount")
  public void setAmount(Double amount) {
    this.amount = amount;
  }

  /** @return The money */
  @JsonProperty("money")
  public Double getMoney() {
    return money;
  }

  /** @param money The money */
  @JsonProperty("money")
  public void setMoney(Double money) {
    this.money = money;
  }

  /** @return The dealAmount */
  @JsonProperty("deal_amount")
  public Double getDealAmount() {
    return dealAmount;
  }

  /** @param dealAmount The deal_amount */
  @JsonProperty("deal_amount")
  public void setDealAmount(Double dealAmount) {
    this.dealAmount = dealAmount;
  }

  /** @return The dealPercent */
  @JsonProperty("deal_percent")
  public String getDealPercent() {
    return dealPercent;
  }

  /** @param dealPercent The deal_percent */
  @JsonProperty("deal_percent")
  public void setDealPercent(String dealPercent) {
    this.dealPercent = dealPercent;
  }

  /** @return The status */
  @JsonProperty("status")
  public BiboxOrderStatus getStatus() {
    return status;
  }

  /** @param status The status */
  @JsonProperty("status")
  public void setStatus(BiboxOrderStatus status) {
    this.status = status;
  }

  /** @return The unexecuted */
  @JsonProperty("unexecuted")
  public Double getUnexecuted() {
    return unexecuted;
  }

  /** @param unexecuted The unexecuted */
  @JsonProperty("unexecuted")
  public void setUnexecuted(Double unexecuted) {
    this.unexecuted = unexecuted;
  }

  public Double getFee() {
    return fee;
  }

  public void setFee(Double fee) {
    this.fee = fee;
  }

  public String getFeeSymbol() {
    return feeSymbol;
  }

  public void setFeeSymbol(String feeSymbol) {
    this.feeSymbol = feeSymbol;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }
}
