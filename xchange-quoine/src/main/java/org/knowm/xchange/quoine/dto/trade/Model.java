package org.knowm.xchange.quoine.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

/** @author timmolter */
public final class Model {

  private final String id;
  private final String orderType;
  private final Double quantity;
  private final String currencyPairCode;
  private final String side;
  private final String productCode;
  private final Double filledQuantity;
  private final Double price;
  private final Double createdAt;
  private final Double updatedAt;
  private final String status;
  private final String bitcoinAccountId;
  private final Integer leverageLevel;
  private final String fundingCurrency;

  /**
   * Constructor
   *
   * @param id
   * @param orderType
   * @param quantity
   * @param currencyPairCode
   * @param side
   * @param productCode
   * @param filledQuantity
   * @param price
   * @param createdAt
   * @param updatedAt
   * @param status
   * @param bitcoinAccountId
   * @param leverageLevel
   */
  public Model(
      @JsonProperty("id") String id,
      @JsonProperty("order_type") String orderType,
      @JsonProperty("quantity") Double quantity,
      @JsonProperty("currency_pair_code") String currencyPairCode,
      @JsonProperty("side") String side,
      @JsonProperty("product_code") String productCode,
      @JsonProperty("filled_quantity") Double filledQuantity,
      @JsonProperty("price") Double price,
      @JsonProperty("created_at") Double createdAt,
      @JsonProperty("updated_at") Double updatedAt,
      @JsonProperty("status") String status,
      @JsonProperty("bitcoin_account_id") String bitcoinAccountId,
      @JsonProperty("leverage_level") Integer leverageLevel,
      @JsonProperty("funding_currency") String fundingCurrency) {
    this.id = id;
    this.orderType = orderType;
    this.quantity = quantity;
    this.currencyPairCode = currencyPairCode;
    this.side = side;
    this.productCode = productCode;
    this.filledQuantity = filledQuantity;
    this.price = price;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
    this.bitcoinAccountId = bitcoinAccountId;
    this.leverageLevel = leverageLevel;
    this.fundingCurrency = fundingCurrency;
  }

  public String getId() {
    return id;
  }

  public String getOrderType() {
    return orderType;
  }

  public Double getQuantity() {
    return quantity;
  }

  public String getCurrencyPairCode() {
    return currencyPairCode;
  }

  public String getSide() {
    return side;
  }

  public String getProductCode() {
    return productCode;
  }

  public Double getFilledQuantity() {
    return filledQuantity;
  }

  public Double getPrice() {
    return price;
  }

  public Double getCreatedAt() {
    return createdAt;
  }

  public Double getUpdatedAt() {
    return updatedAt;
  }

  public String getStatus() {
    return status;
  }

  public String getBitcoinAccountId() {
    return bitcoinAccountId;
  }

  public Integer getLeverageLevel() {
    return leverageLevel;
  }

  public String getFundingCurrency() {
    return fundingCurrency;
  }

  @Override
  public String toString() {
    return "Model [id="
        + id
        + ", orderType="
        + orderType
        + ", quantity="
        + quantity
        + ", currencyPairCode="
        + currencyPairCode
        + ", side="
        + side
        + ", productCode="
        + productCode
        + ", filledQuantity="
        + filledQuantity
        + ", price="
        + price
        + ", createdAt="
        + createdAt
        + ", updatedAt="
        + updatedAt
        + ", status="
        + status
        + ", bitcoinAccountId="
        + bitcoinAccountId
        + ", leverageLevel="
        + leverageLevel
        + ",fundingCurrency="
        + fundingCurrency
        + "]";
  }
}
