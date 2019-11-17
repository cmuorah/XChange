package org.knowm.xchange.kraken.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KrakenTradeBalanceInfo {

  private final Double tradeBalance; // trade balance (combined balance of all currencies)
  private final Double margin; // initial margin amount of open positions
  private final Double unrealizedGainsLosses; // unrealized net profit/loss of open positions
  private final Double costBasis; // cost basis of open positions
  private final Double floatingValuation; // current floating valuation of open positions
  private final Double equity; // trade balance + unrealized net profit/loss
  private final Double
      freeMargin; // equity - initial margin (maximum margin available to open new positions)
  private final Double marginLevel; // (equity / initial margin) * 100

  /**
   * Constructor
   *
   * @param tradeBalance
   * @param margin
   * @param unrealizedGainsLosses
   * @param costBasis
   * @param floatingValuation
   * @param equity
   * @param freeMargin
   * @param marginLevel
   */
  public KrakenTradeBalanceInfo(
      @JsonProperty("tb") Double tradeBalance,
      @JsonProperty("m") Double margin,
      @JsonProperty("n") Double unrealizedGainsLosses,
      @JsonProperty("c") Double costBasis,
      @JsonProperty("v") Double floatingValuation,
      @JsonProperty("e") Double equity,
      @JsonProperty("mf") Double freeMargin,
      @JsonProperty("ml") Double marginLevel) {

    this.tradeBalance = tradeBalance;
    this.margin = margin;
    this.unrealizedGainsLosses = unrealizedGainsLosses;
    this.costBasis = costBasis;
    this.floatingValuation = floatingValuation;
    this.equity = equity;
    this.freeMargin = freeMargin;
    this.marginLevel = marginLevel;
  }

  public Double getTradeBalance() {

    return tradeBalance;
  }

  public Double getMargin() {

    return margin;
  }

  public Double getUnrealizedGainsLosses() {

    return unrealizedGainsLosses;
  }

  public Double getCostBasis() {

    return costBasis;
  }

  public Double getFloatingValuation() {

    return floatingValuation;
  }

  public Double getEquity() {

    return equity;
  }

  public Double getFreeMargin() {

    return freeMargin;
  }

  public Double getMarginLevel() {

    return marginLevel;
  }

  @Override
  public String toString() {

    return "KrakenTradeBalanceInfo [tradeBalance="
        + tradeBalance
        + ", margin="
        + margin
        + ", unrealizedGainsLosses="
        + unrealizedGainsLosses
        + ", costBasis="
        + costBasis
        + ", floatingValuation="
        + floatingValuation
        + ", equity="
        + equity
        + ", freeMargin="
        + freeMargin
        + ", marginLevel="
        + marginLevel
        + "]";
  }
}
