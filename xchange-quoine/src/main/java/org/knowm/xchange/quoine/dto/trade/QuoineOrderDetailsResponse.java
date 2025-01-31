package org.knowm.xchange.quoine.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

/** @author timmolter */
public final class QuoineOrderDetailsResponse {

  private final String id;
  private final String orderType;
  private final Double quantity;
  private final String currencyPairCode;
  private final String side;
  private final Integer leverageLevel;
  private final String productCode;
  private final Double filledQuantity;
  private final Double price;
  private final Double createdAt;
  private final Double updatedAt;
  private final String status;
  private final Double orderFee;
  private final Object settings;
  private final Execution[] executions;

  /**
   * Constructor
   *
   * @param id
   * @param orderType
   * @param quantity
   * @param currencyPairCode
   * @param side
   * @param leverageLevel
   * @param productCode
   * @param filledQuantity
   * @param price
   * @param createdAt
   * @param updatedAt
   * @param status
   * @param orderFee
   * @param settings
   * @param executions
   */
  public QuoineOrderDetailsResponse(
      @JsonProperty("id") String id,
      @JsonProperty("order_type") String orderType,
      @JsonProperty("quantity") Double quantity,
      @JsonProperty("currency_pair_code") String currencyPairCode,
      @JsonProperty("side") String side,
      @JsonProperty("leverage_level") Integer leverageLevel,
      @JsonProperty("product_code") String productCode,
      @JsonProperty("filled_quantity") Double filledQuantity,
      @JsonProperty("price") Double price,
      @JsonProperty("created_at") Double createdAt,
      @JsonProperty("updated_at") Double updatedAt,
      @JsonProperty("status") String status,
      @JsonProperty("order_fee") Double orderFee,
      @JsonProperty("settings") Object settings,
      @JsonProperty("executions") Execution[] executions) {
    this.id = id;
    this.orderType = orderType;
    this.quantity = quantity;
    this.currencyPairCode = currencyPairCode;
    this.side = side;
    this.leverageLevel = leverageLevel;
    this.productCode = productCode;
    this.filledQuantity = filledQuantity;
    this.price = price;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
    this.orderFee = orderFee;
    this.settings = settings;
    this.executions = executions;
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

  public Integer getLeverageLevel() {
    return leverageLevel;
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

  public Double getOrderFee() {
    return orderFee;
  }

  public Object getSettings() {
    return settings;
  }

  public Execution[] getExecutions() {
    return executions;
  }

  @Override
  public String toString() {
    return "OrderDetailsResponse [id="
        + id
        + ", orderType="
        + orderType
        + ", quantity="
        + quantity
        + ", currencyPairCode="
        + currencyPairCode
        + ", side="
        + side
        + ", leverageLevel="
        + leverageLevel
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
        + ", orderFee="
        + orderFee
        + ", settings="
        + settings
        + ", executions="
        + Arrays.toString(executions)
        + "]";
  }
}
