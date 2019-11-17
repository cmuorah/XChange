package org.knowm.xchange.quoine.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public final class QuoineTradingAccountInfo {
  private final String id;
  private final int leverageLevel;
  private final int currentLeverageLevel;
  private final Double equity;
  private final Double margin;
  private final Double freeMargin;
  private final long traderId;
  private final String status;
  private final String productCode;
  private final String currencyPairCode;
  private final Double pnl;
  private final Double position;
  private final Double balance;
  private final Date updatedAt;
  private final String pusher_channel;
  private final Double marginPercent;
  private final String fundingCurrency;

  public QuoineTradingAccountInfo(
      @JsonProperty("id") String id,
      @JsonProperty("leverage_level") int leverageLevel,
      @JsonProperty("current_leverage_level") int currentLeverageLevel,
      @JsonProperty("equity") Double equity,
      @JsonProperty("margin") Double margin,
      @JsonProperty("free_margin") Double freeMargin,
      @JsonProperty("trader_id") long traderId,
      @JsonProperty("status") String status,
      @JsonProperty("product_code") String productCode,
      @JsonProperty("currency_pair_code") String currencyPairCode,
      @JsonProperty("pnl") Double pnl,
      @JsonProperty("position") Double position,
      @JsonProperty("balance") Double balance,
      @JsonProperty("updated_at") Date updatedAt,
      @JsonProperty("pusher_channel") String pusher_channel,
      @JsonProperty("margin_percent") Double marginPercent,
      @JsonProperty("funding_currency") String fundingCurrency) {
    super();
    this.id = id;
    this.leverageLevel = leverageLevel;
    this.currentLeverageLevel = currentLeverageLevel;
    this.equity = equity;
    this.margin = margin;
    this.freeMargin = freeMargin;
    this.traderId = traderId;
    this.status = status;
    this.productCode = productCode;
    this.currencyPairCode = currencyPairCode;
    this.pnl = pnl;
    this.position = position;
    this.balance = balance;
    this.updatedAt = updatedAt;
    this.pusher_channel = pusher_channel;
    this.marginPercent = marginPercent;
    this.fundingCurrency = fundingCurrency;
  }

  public String getId() {
    return id;
  }

  public int getLeverageLevel() {
    return leverageLevel;
  }

  public int getCurrentLeverageLevel() {
    return currentLeverageLevel;
  }

  public Double getEquity() {
    return equity;
  }

  public Double getMargin() {
    return margin;
  }

  public Double getFreeMargin() {
    return freeMargin;
  }

  public long getTraderId() {
    return traderId;
  }

  public String getStatus() {
    return status;
  }

  public String getProductCode() {
    return productCode;
  }

  public String getCurrencyPairCode() {
    return currencyPairCode;
  }

  public Double getPnl() {
    return pnl;
  }

  public Double getPosition() {
    return position;
  }

  public Double getBalance() {
    return balance;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public String getPusher_channel() {
    return pusher_channel;
  }

  public Double getMarginPercent() {
    return marginPercent;
  }

  public String getFundingCurrency() {
    return fundingCurrency;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("QuoineTradingAccountInfo [id=");
    builder.append(id);
    builder.append(", leverageLevel=");
    builder.append(leverageLevel);
    builder.append(", equity=");
    builder.append(equity);
    builder.append(", margin=");
    builder.append(margin);
    builder.append(", currencyPairCode=");
    builder.append(currencyPairCode);
    builder.append(", pnl=");
    builder.append(pnl);
    builder.append(", position=");
    builder.append(position);
    builder.append(", balance=");
    builder.append(balance);
    builder.append(", marginPercent=");
    builder.append(marginPercent);
    builder.append("]");
    return builder.toString();
  }
}
