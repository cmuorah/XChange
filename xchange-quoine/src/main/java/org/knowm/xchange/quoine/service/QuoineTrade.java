package org.knowm.xchange.quoine.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoineTrade {
  public final String id;
  public final String currencyPairCode;
  public final String status;
  public final String side;
  public final Double marginUsed;
  public final Double openQuantity;
  public final Double closeQuantity;
  public final Double quantity;
  public final Double leverageLevel;
  public final String productCode;
  public final String productId;
  public final Double openPrice;
  public final Double closePrice;
  public final String traderId;
  public final Double openPnl;
  public final Double closePnl;
  public final Double pnl;
  public final Double stopLoss;
  public final Double takeProfit;
  public final String fundingCurrency;
  public final Long createdAt;
  public final Long updatedAt;
  public final Double totalInterest;

  public QuoineTrade(
      @JsonProperty("id") String id,
      @JsonProperty("currency_pair_code") String currencyPairCode,
      @JsonProperty("status") String status,
      @JsonProperty("side") String side,
      @JsonProperty("margin_used") Double marginUsed,
      @JsonProperty("open_quantity") Double openQuantity,
      @JsonProperty("close_quantity") Double closeQuantity,
      @JsonProperty("quantity") Double quantity,
      @JsonProperty("leverage_level") Double leverageLevel,
      @JsonProperty("product_code") String productCode,
      @JsonProperty("product_id") String productId,
      @JsonProperty("open_price") Double openPrice,
      @JsonProperty("close_price") Double closePrice,
      @JsonProperty("trader_id") String traderId,
      @JsonProperty("open_pnl") Double openPnl,
      @JsonProperty("close_pnl") Double closePnl,
      @JsonProperty("pnl") Double pnl,
      @JsonProperty("stop_loss") Double stopLoss,
      @JsonProperty("take_profit") Double takeProfit,
      @JsonProperty("funding_currency") String fundingCurrency,
      @JsonProperty("created_at") Long createdAt,
      @JsonProperty("updated_at") Long updatedAt,
      @JsonProperty("total_interest") Double totalInterest) {
    this.id = id;
    this.currencyPairCode = currencyPairCode;
    this.status = status;
    this.side = side;
    this.marginUsed = marginUsed;
    this.openQuantity = openQuantity;
    this.closeQuantity = closeQuantity;
    this.quantity = quantity;
    this.leverageLevel = leverageLevel;
    this.productCode = productCode;
    this.productId = productId;
    this.openPrice = openPrice;
    this.closePrice = closePrice;
    this.traderId = traderId;
    this.openPnl = openPnl;
    this.closePnl = closePnl;
    this.pnl = pnl;
    this.stopLoss = stopLoss;
    this.takeProfit = takeProfit;
    this.fundingCurrency = fundingCurrency;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.totalInterest = totalInterest;
  }

  @Override
  public String toString() {
    return "QuoineTrade{"
        + "id='"
        + id
        + '\''
        + ", currencyPairCode='"
        + currencyPairCode
        + '\''
        + ", status='"
        + status
        + '\''
        + ", side='"
        + side
        + '\''
        + ", marginUsed="
        + marginUsed
        + ", openQuantity="
        + openQuantity
        + ", closeQuantity="
        + closeQuantity
        + ", quantity="
        + quantity
        + ", leverageLevel="
        + leverageLevel
        + ", productCode='"
        + productCode
        + '\''
        + ", productId='"
        + productId
        + '\''
        + ", openPrice="
        + openPrice
        + ", closePrice="
        + closePrice
        + ", traderId='"
        + traderId
        + '\''
        + ", openPnl="
        + openPnl
        + ", closePnl="
        + closePnl
        + ", pnl="
        + pnl
        + ", stopLoss="
        + stopLoss
        + ", takeProfit="
        + takeProfit
        + ", fundingCurrency='"
        + fundingCurrency
        + '\''
        + ", createdAt="
        + createdAt
        + ", updatedAt="
        + updatedAt
        + ", totalInterest="
        + totalInterest
        + '}';
  }
}
