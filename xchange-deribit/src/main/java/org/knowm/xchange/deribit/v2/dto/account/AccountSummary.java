package org.knowm.xchange.deribit.v2.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountSummary {

  /** Profit and loss */
  @JsonProperty("total_pl")
  private Double totalPl;

  /** Session unrealized profit and loss */
  @JsonProperty("session_upl")
  private Double sessionUpl;

  /** Session realized profit and loss */
  @JsonProperty("session_rpl")
  private Double sessionRpl;

  /** Session funding */
  @JsonProperty("session_funding")
  private Double sessionFunding;

  /** true when portfolio margining is enabled for user */
  @JsonProperty("portfolio_margining_enabled")
  private boolean portfolioMarginingEnabled;

  /** Options summary vega */
  @JsonProperty("options_vega")
  private Double optionsVega;

  /** Options summary theta */
  @JsonProperty("options_theta")
  private Double optionsTheta;

  /** Options session unrealized profit and Loss */
  @JsonProperty("options_session_upl")
  private Double optionsSessionUpl;

  /** Options session realized profit and Loss */
  @JsonProperty("options_session_rpl")
  private Double optionsSessionRpl;

  /** Options profit and Loss */
  @JsonProperty("options_pl")
  private Double optionsPl;

  /** Options summary gamma */
  @JsonProperty("options_gamma")
  private Double optionsGamma;

  /** Options summary delta */
  @JsonProperty("options_delta")
  private Double optionsDelta;

  /** The account's margin balance */
  @JsonProperty("margin_balance")
  private Double marginBalance;

  /** The maintenance margin. */
  @JsonProperty("maintenance_margin")
  private Double maintenanceMargin;

  /** The account's initial margin */
  @JsonProperty("initial_margin")
  private Double initialMargin;

  /** Futures session unrealized profit and Loss */
  @JsonProperty("futures_session_upl")
  private Double futuresSessionUpl;

  /** Futures session realized profit and Loss */
  @JsonProperty("futures_session_rpl")
  private Double futuresSessionRpl;

  /** Futures profit and Loss */
  @JsonProperty("futures_pl")
  private Double futuresPl;

  /** The account's current equity */
  @JsonProperty("equity")
  private Double equity;

  /** The deposit address for the account (if available) */
  @JsonProperty("deposit_address")
  private String depositAddress;

  /** The sum of position deltas */
  @JsonProperty("delta_total")
  private Double deltaTotal;

  /** The selected currency */
  @JsonProperty("currency")
  private String currency;

  /** The account's balance */
  @JsonProperty("balance")
  private Double balance;

  /** The account's available to withdrawal funds */
  @JsonProperty("available_withdrawal_funds")
  private Double availableWithdrawalFunds;

  /** The account's available funds */
  @JsonProperty("available_funds")
  private Double availableFunds;

  /** Account name (given by user) (available when parameter extended = true) */
  @JsonProperty("username")
  private String username;

  /** Account type (available when parameter extended = true) */
  @JsonProperty("type")
  private String type;

  /** Whether two factor authentication is enabled (available when parameter extended = true) */
  @JsonProperty("tfa_enabled")
  private Boolean tfaEnabled;

  /** System generated user nickname (available when parameter extended = true) */
  @JsonProperty("system_name")
  private String systemName;

  /** Account id (available when parameter extended = true) */
  @JsonProperty("id")
  private Long id;

  /** User email (available when parameter extended = true) */
  @JsonProperty("email")
  private String email;
}
