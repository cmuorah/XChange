package org.knowm.xchange.okcoin.v3.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.knowm.xchange.okcoin.v3.dto.MarginMode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FuturesAccountsByCurrencyResponse extends OkexResponse {
  /** Balance of the account */
  @JsonProperty("available_balance")
  private Double availableBalance;

  @JsonProperty("margin_mode")
  private MarginMode marginMode;
  /** Equity of the account, ie 2.30757371 */
  private Double equity;
  /** Liquidation mode: tier（partial）, legacy (full) */
  @JsonProperty("liqui_mode")
  private String liquiMode;
  /** Maintenance Margin Ratio, ie 0.01 */
  @JsonProperty("maint_margin_ratio")
  private Double maintMarginRatio;
  /** Margin (on hold for open orders + positions holding), ie 0.00607247 */
  private Double margin;
  /** Margin on hold for open orders, ie 0 */
  @JsonProperty("margin_for_unfilled")
  private Double marginForUnfilled;
  /** Position margi, ie 0.00607247 */
  @JsonProperty("margin_frozen")
  private Double marginFrozen;
  /** Margin ratio, ie 38.00057818 */
  @JsonProperty("margin_ratio")
  private Double marginRatio;
  /** realised profit and loss, ie 2.30759234 */
  @JsonProperty("realized_pnl")
  private Double realizedPnl;
  /** Balance of the account, ie 0 */
  @JsonProperty("total_avail_balance")
  private Double totalAvailBalance;
  /** Unrealised profit and loss, ie -0.00001863 */
  @JsonProperty("unrealized_pnl")
  private Double unrealizedPnl;
}
