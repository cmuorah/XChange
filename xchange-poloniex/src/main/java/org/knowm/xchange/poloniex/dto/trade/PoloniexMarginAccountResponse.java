package org.knowm.xchange.poloniex.dto.trade;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PoloniexMarginAccountResponse {

  private Double totalValue;
  private Double pl;
  private Double lendingFees;
  private Double netValue;
  private Double totalBorrowedValue;
  private Double currentMargin;

  @JsonCreator
  public PoloniexMarginAccountResponse(
      @JsonProperty("totalValue") Double totalValue,
      @JsonProperty("pl") Double pl,
      @JsonProperty("lendingFees") Double lendingFees,
      @JsonProperty("netValue") Double netValue,
      @JsonProperty("totalBorrowedValue") Double totalBorrowedValue,
      @JsonProperty("currentMargin") Double currentMargin) {
    this.totalValue = totalValue;
    this.pl = pl;
    this.lendingFees = lendingFees;
    this.netValue = netValue;
    this.totalBorrowedValue = totalBorrowedValue;
    this.currentMargin = currentMargin;
  }

  public Double getTotalValue() {
    return totalValue;
  }

  public void setTotalValue(Double totalValue) {
    this.totalValue = totalValue;
  }

  public Double getPl() {
    return pl;
  }

  public void setPl(Double pl) {
    this.pl = pl;
  }

  public Double getLendingFees() {
    return lendingFees;
  }

  public void setLendingFees(Double lendingFees) {
    this.lendingFees = lendingFees;
  }

  public Double getNetValue() {
    return netValue;
  }

  public void setNetValue(Double netValue) {
    this.netValue = netValue;
  }

  public Double getTotalBorrowedValue() {
    return totalBorrowedValue;
  }

  public void setTotalBorrowedValue(Double totalBorrowedValue) {
    this.totalBorrowedValue = totalBorrowedValue;
  }

  public Double getCurrentMargin() {
    return currentMargin;
  }

  public void setCurrentMargin(Double currentMargin) {
    this.currentMargin = currentMargin;
  }

  @Override
  public String toString() {
    return "PoloniexMarginAccountResponse{"
        + "totalValue="
        + totalValue
        + ", pl="
        + pl
        + ", lendingFees="
        + lendingFees
        + ", netValue="
        + netValue
        + ", totalBorrowedValue="
        + totalBorrowedValue
        + ", currentMargin="
        + currentMargin
        + '}';
  }
}
