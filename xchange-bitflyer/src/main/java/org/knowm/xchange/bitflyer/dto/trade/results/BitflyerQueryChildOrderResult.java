package org.knowm.xchange.bitflyer.dto.trade.results;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BitflyerQueryChildOrderResult {
  private Long id;

  @JsonProperty("child_order_id")
  private String childOrderId;

  @JsonProperty("product_code")
  private String productCode;

  private String side;

  @JsonProperty("child_order_type")
  private String childOrderType;

  private Double price;

  @JsonProperty("average_price")
  private Double averagePrice;

  private Double size;

  @JsonProperty("child_order_state")
  private String childOrderState;

  @JsonProperty("expire_date")
  private String expireDate;

  @JsonProperty("child_order_date")
  private String childOrderDate;

  @JsonProperty("child_order_acceptance_id")
  private String childOrderAcceptanceId;

  @JsonProperty("outstanding_size")
  private Double outstandingSize;

  @JsonProperty("cancel_size")
  private Double cancelSize;

  @JsonProperty("executed_size")
  private Double executedSize;

  @JsonProperty("total_commission")
  private Double totalCommission;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getChildOrderId() {
    return childOrderId;
  }

  public void setChildOrderId(String childOrderId) {
    this.childOrderId = childOrderId;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public String getSide() {
    return side;
  }

  public void setSide(String side) {
    this.side = side;
  }

  public String getChildOrderType() {
    return childOrderType;
  }

  public void setChildOrderType(String childOrderType) {
    this.childOrderType = childOrderType;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getAveragePrice() {
    return averagePrice;
  }

  public void setAveragePrice(Double averagePrice) {
    this.averagePrice = averagePrice;
  }

  public Double getSize() {
    return size;
  }

  public void setSize(Double size) {
    this.size = size;
  }

  public String getChildOrderState() {
    return childOrderState;
  }

  public void setChildOrderState(String childOrderState) {
    this.childOrderState = childOrderState;
  }

  public String getExpireDate() {
    return expireDate;
  }

  public void setExpireDate(String expireDate) {
    this.expireDate = expireDate;
  }

  public String getChildOrderDate() {
    return childOrderDate;
  }

  public void setChildOrderDate(String childOrderDate) {
    this.childOrderDate = childOrderDate;
  }

  public String getChildOrderAcceptanceId() {
    return childOrderAcceptanceId;
  }

  public void setChildOrderAcceptanceId(String childOrderAcceptanceId) {
    this.childOrderAcceptanceId = childOrderAcceptanceId;
  }

  public Double getOutstandingSize() {
    return outstandingSize;
  }

  public void setOutstandingSize(Double outstandingSize) {
    this.outstandingSize = outstandingSize;
  }

  public Double getCancelSize() {
    return cancelSize;
  }

  public void setCancelSize(Double cancelSize) {
    this.cancelSize = cancelSize;
  }

  public Double getExecutedSize() {
    return executedSize;
  }

  public void setExecutedSize(Double executedSize) {
    this.executedSize = executedSize;
  }

  public Double getTotalCommission() {
    return totalCommission;
  }

  public void setTotalCommission(Double totalCommission) {
    this.totalCommission = totalCommission;
  }

  @Override
  public String toString() {
    return "BitflyerQueryChildOrderResult{"
        + "id="
        + id
        + ", childOrderId='"
        + childOrderId
        + '\''
        + ", productCode='"
        + productCode
        + '\''
        + ", side='"
        + side
        + '\''
        + ", childOrderType='"
        + childOrderType
        + '\''
        + ", price="
        + price
        + ", averagePrice="
        + averagePrice
        + ", size="
        + size
        + ", childOrderState='"
        + childOrderState
        + '\''
        + ", expireDate='"
        + expireDate
        + '\''
        + ", childOrderDate='"
        + childOrderDate
        + '\''
        + ", childOrderAcceptanceId='"
        + childOrderAcceptanceId
        + '\''
        + ", outstandingSize="
        + outstandingSize
        + ", cancelSize="
        + cancelSize
        + ", executedSize="
        + executedSize
        + ", totalCommission="
        + totalCommission
        + '}';
  }
}
