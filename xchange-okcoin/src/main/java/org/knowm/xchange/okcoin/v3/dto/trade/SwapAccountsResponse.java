package org.knowm.xchange.okcoin.v3.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.knowm.xchange.okcoin.v3.dto.MarginMode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SwapAccountsResponse extends OkexResponse {

  private List<SwapAccountInfo> info;

  @Data
  public static class SwapAccountInfo {

    /** Equity of the account, ie 5.0327 */
    private Double equity;
    /** Balance of fixed margin account, ie 0.0000 */
    @JsonProperty("fixed_balance")
    private Double fixedBalance;
    /** Contract ID, ie BTC-USD-SWAP */
    @JsonProperty("instrument_id")
    private String instrumentId;
    /** Margin for open positions, ie 0.0059 */
    private Double margin;
    /** Initial margin on hold, ie 0.0000 */
    @JsonProperty("margin_frozen")
    private Double marginFrozen;
    /** Margin Mode: crossed / fixed */
    @JsonProperty("margin_mode")
    private MarginMode marginMode;
    /** Margin Ratio, ie 284.2374 */
    @JsonProperty("margin_ratio")
    private Double marginRatio;
    /** Realized profits and losses, ie 0.0000 */
    @JsonProperty("realized_pnl")
    private Double realizedPnl;
    /** Balance of the account, ie 5.0327 */
    @JsonProperty("total_avail_balance")
    private Double totalAvailBalance;
    /** Creation time, ie 2019-06-25T10:43:37.728Z */
    private String timestamp;
    /** Unrealized profits and losses, ie 0.0000 */
    @JsonProperty("unrealized_pnl")
    private Double unrealizedPnl;
    /** Maintenance Margin Ratio, ie 0.01 */
    @JsonProperty("maint_margin_ratio")
    private Double maintMarginRatio;
  }
}
