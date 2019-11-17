package org.knowm.xchange.okcoin.v3.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.knowm.xchange.okcoin.v3.dto.MarginMode;

@Data
public class FuturesPosition {

  /** Account Type: fixed or crossed */
  @JsonProperty("margin_mode")
  private MarginMode marginMode;

  /** ******************************** common properties ********************************* */
  /** Contract ID, e.g. “BTC-USD-180213” */
  @JsonProperty("instrument_id")
  private String instrumentId;
  /** Creation date */
  @JsonProperty("created_at")
  private String createdAt;
  /** Last margin adjusting time */
  @JsonProperty("updated_at")
  private String updatedAt;
  /** Quantity of long positions */
  @JsonProperty("long_qty")
  private Double longQty;
  /** Available positions to be closed for long positions */
  @JsonProperty("long_avail_qty")
  private Double longAvailQty;
  /** Margin for long positions */
  @JsonProperty("long_margin")
  private Double longMargin;
  /** Profit and loss ratio of long positions */
  @JsonProperty("long_pnl_ratio")
  private Double longPnlRatio;
  /** Average price for opening positions */
  @JsonProperty("long_avg_cost")
  private Double longAvgCost;
  /** Standard settlement price for long positions */
  @JsonProperty("long_settlement_price")
  private Double longSettlement_Price;
  /** realised profits */
  @JsonProperty("realised_pnl")
  private Double realisedPnl;
  /** Quantity of short positions */
  @JsonProperty("short_qty")
  private Double shortQty;
  /** Available positions to be closed for short positions */
  @JsonProperty("short_avail_qty")
  private Double shortAvailQty;
  /** Margin for short positions */
  @JsonProperty("short_margin")
  private Double shortMargin;
  /** Profit and loss ratio of short positions */
  @JsonProperty("short_pnl_ratio")
  private Double shortPnlRatio;
  /** Average price for opening positions */
  @JsonProperty("short_avg_cost")
  private Double shortAvgCost;
  /** Standard settlement price for short positions */
  @JsonProperty("short_settlement_price")
  private Double shortSettlementPrice;
  /** Profit of short positions */
  @JsonProperty("short_pnl")
  private Double shortPnl;
  /** Unrealized profits and losses of short positions */
  @JsonProperty("short_unrealised_pnl")
  private Double shortUnrealisedPnl;

  @JsonProperty("short_settled_pnl")
  private Double shortSettledPnl;
  /** Profit of long positions */
  @JsonProperty("long_pnl")
  private Double longPnl;
  /** Unrealized profits and losses of long positions */
  @JsonProperty("long_unrealised_pnl")
  private Double longUnrealisedPnl;

  @JsonProperty("long_settled_pnl")
  private Double longSettledPnl;

  /** ******************************** crossed margin mode ********************************* */

  /** Estimated liquidation price */
  @JsonProperty("liquidation_price")
  private Double liquidationPrice;
  /** Leverage */
  private Double leverage;

  /** ******************************** fixed margin mode ********************************* */

  /** Forced liquidation price for long positions */
  @JsonProperty("long_liqui_price")
  private Double longLiquiPrice;
  /** Leverage for long positions */
  @JsonProperty("long_leverage")
  private Double longLeverage;
  /** Forced liquidation price for short positions */
  @JsonProperty("short_liqui_price")
  private Double shortLiquiPrice;
  /** Leverage for short positions */
  @JsonProperty("short_leverage")
  private Double shortLeverage;
  /** Margin ratio of short positions */
  @JsonProperty("short_margin_ratio")
  private Double shortMarginRatio;
  /** Maintenance margin ratio of short positions */
  @JsonProperty("short_maint_margin_ratio")
  private Double shortMaintMarginRatio;
  /** Margin ratio of long positions */
  @JsonProperty("long_margin_ratio")
  private Double longMarginRatio;
  /** Maintenance margin ratio of long positions */
  @JsonProperty("long_maint_margin_ratio")
  private Double longMaintMarginRatio;
}
