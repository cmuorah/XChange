package org.knowm.xchange.okcoin.v3.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.knowm.xchange.okcoin.v3.dto.trade.FutureSide;

@Data
public class SwapPosition {

  /** Positions available to be closed, ie 1 */
  @JsonProperty("avail_position")
  private Double availPosition;

  /** Avg. position price, ie 11444.4 */
  @JsonProperty("avg_cost")
  private Double avgCost;

  /** Contract ID, ie BTC-USD-SWAP */
  @JsonProperty("instrument_id")
  private String instrumentId;

  /** Leverage level, ie 3 */
  private Double leverage;

  /** Estimated liquidation price, ie 0.1 */
  @JsonProperty("liquidation_price")
  private Double liquidationPrice;

  /** Maintenance Margin Ratio, ie 0.0050 */
  @JsonProperty("maint_margin_ratio")
  private Double maintMarginRatio;

  /** Margin, ie 0.0029 */
  private Double margin;

  /** Positions open, ie 1 */
  private Double position;

  /** Settlement price, ie 11444.4 */
  @JsonProperty("settlement_price")
  private Double settlementPrice;

  /** Realized PnL, ie -0.0001 */
  @JsonProperty("realized_pnl")
  private Double realizedPnl;

  /** Side, short or long */
  private FutureSide side;

  /** Creation time, ie "2019-06-25T10:43:37.728Z" */
  private String timestamp;
}
