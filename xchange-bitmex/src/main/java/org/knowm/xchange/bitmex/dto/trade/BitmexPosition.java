package org.knowm.xchange.bitmex.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.bitmex.AbstractHttpResponseAware;

public class BitmexPosition extends AbstractHttpResponseAware {
  @JsonProperty("account")
  private Integer account;

  @JsonProperty("symbol")
  private String symbol;

  @JsonProperty("currency")
  private String currency;

  @JsonProperty("underlying")
  private String underlying;

  @JsonProperty("quoteCurrency")
  private String quoteCurrency;

  @JsonProperty("commission")
  private Double commission;

  @JsonProperty("initMarginReq")
  private Double initMarginReq;

  @JsonProperty("maintMarginReq")
  private Double maintMarginReq;

  @JsonProperty("riskLimit")
  private Double riskLimit;

  @JsonProperty("leverage")
  private Double leverage;

  @JsonProperty("crossMargin")
  private Boolean crossMargin;

  @JsonProperty("deleveragePercentile")
  private Double deleveragePercentile;

  @JsonProperty("rebalancedPnl")
  private Double rebalancedPnl;

  @JsonProperty("prevRealisedPnl")
  private Double prevRealisedPnl;

  @JsonProperty("prevUnrealisedPnl")
  private Double prevUnrealisedPnl;

  @JsonProperty("prevClosePrice")
  private Double prevClosePrice;

  @JsonProperty("openingTimestamp")
  private String openingTimestamp;

  @JsonProperty("openingQty")
  private Double openingQty;

  @JsonProperty("openingCost")
  private Double openingCost;

  @JsonProperty("openingComm")
  private Double openingComm;

  @JsonProperty("openOrderBuyQty")
  private Double openOrderBuyQty;

  @JsonProperty("openOrderBuyCost")
  private Double openOrderBuyCost;

  @JsonProperty("openOrderBuyPremium")
  private Double openOrderBuyPremium;

  @JsonProperty("openOrderSellQty")
  private Double openOrderSellQty;

  @JsonProperty("openOrderSellCost")
  private Double openOrderSellCost;

  @JsonProperty("openOrderSellPremium")
  private Double openOrderSellPremium;

  @JsonProperty("execBuyQty")
  private Double execBuyQty;

  @JsonProperty("execBuyCost")
  private Double execBuyCost;

  @JsonProperty("execSellQty")
  private Double execSellQty;

  @JsonProperty("execSellCost")
  private Double execSellCost;

  @JsonProperty("execQty")
  private Double execQty;

  @JsonProperty("execCost")
  private Double execCost;

  @JsonProperty("execComm")
  private Double execComm;

  @JsonProperty("currentTimestamp")
  private String currentTimestamp;

  @JsonProperty("currentQty")
  private Double currentQty;

  @JsonProperty("currentCost")
  private Double currentCost;

  @JsonProperty("currentComm")
  private Double currentComm;

  @JsonProperty("realisedCost")
  private Double realisedCost;

  @JsonProperty("unrealisedCost")
  private Double unrealisedCost;

  @JsonProperty("grossOpenCost")
  private Double grossOpenCost;

  @JsonProperty("grossOpenPremium")
  private Double grossOpenPremium;

  @JsonProperty("grossExecCost")
  private Double grossExecCost;

  @JsonProperty("isOpen")
  private Boolean isOpen;

  @JsonProperty("markPrice")
  private Double markPrice;

  @JsonProperty("markValue")
  private Double markValue;

  @JsonProperty("riskValue")
  private Double riskValue;

  @JsonProperty("homeNotional")
  private Double homeNotional;

  @JsonProperty("foreignNotional")
  private Double foreignNotional;

  @JsonProperty("posState")
  private String posState;

  @JsonProperty("posCost")
  private Double posCost;

  @JsonProperty("posCost2")
  private Double posCost2;

  @JsonProperty("posCross")
  private Double posCross;

  @JsonProperty("posInit")
  private Double posInit;

  @JsonProperty("posComm")
  private Double posComm;

  @JsonProperty("posLoss")
  private Double posLoss;

  @JsonProperty("posMargin")
  private Double posMargin;

  @JsonProperty("posMaint")
  private Double posMaint;

  @JsonProperty("posAllowance")
  private Double posAllowance;

  @JsonProperty("taxableMargin")
  private Double taxableMargin;

  @JsonProperty("initMargin")
  private Double initMargin;

  @JsonProperty("maintMargin")
  private Double maintMargin;

  @JsonProperty("sessionMargin")
  private Double sessionMargin;

  @JsonProperty("targetExcessMargin")
  private Double targetExcessMargin;

  @JsonProperty("varMargin")
  private Double varMargin;

  @JsonProperty("realisedGrossPnl")
  private Double realisedGrossPnl;

  @JsonProperty("realisedTax")
  private Double realisedTax;

  @JsonProperty("realisedPnl")
  private Double realisedPnl;

  @JsonProperty("unrealisedGrossPnl")
  private Double unrealisedGrossPnl;

  @JsonProperty("longBankrupt")
  private Double longBankrupt;

  @JsonProperty("shortBankrupt")
  private Double shortBankrupt;

  @JsonProperty("taxBase")
  private Double taxBase;

  @JsonProperty("indicativeTaxRate")
  private Double indicativeTaxRate;

  @JsonProperty("indicativeTax")
  private Double indicativeTax;

  @JsonProperty("unrealisedTax")
  private Double unrealisedTax;

  @JsonProperty("unrealisedPnl")
  private Double unrealisedPnl;

  @JsonProperty("unrealisedPnlPcnt")
  private Double unrealisedPnlPcnt;

  @JsonProperty("unrealisedRoePcnt")
  private Double unrealisedRoePcnt;

  @JsonProperty("simpleQty")
  private Double simpleQty;

  @JsonProperty("simpleCost")
  private Double simpleCost;

  @JsonProperty("simpleValue")
  private Double simpleValue;

  @JsonProperty("simplePnl")
  private Double simplePnl;

  @JsonProperty("simplePnlPcnt")
  private Double simplePnlPcnt;

  @JsonProperty("avgCostPrice")
  private Double avgCostPrice;

  @JsonProperty("avgEntryPrice")
  private Double avgEntryPrice;

  @JsonProperty("breakEvenPrice")
  private Double breakEvenPrice;

  @JsonProperty("marginCallPrice")
  private Double marginCallPrice;

  @JsonProperty("liquidationPrice")
  private Double liquidationPrice;

  @JsonProperty("bankruptPrice")
  private Double bankruptPrice;

  @JsonProperty("timestamp")
  private String timestamp;

  @JsonProperty("lastPrice")
  private Double lastPrice;

  @JsonProperty("lastValue")
  private Double lastValue;

  public Integer getAccount() {
    return account;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getCurrency() {
    return currency;
  }

  public String getUnderlying() {
    return underlying;
  }

  public String getQuoteCurrency() {
    return quoteCurrency;
  }

  public Double getCommission() {
    return commission;
  }

  public Double getInitMarginReq() {
    return initMarginReq;
  }

  public Double getMaintMarginReq() {
    return maintMarginReq;
  }

  public Double getRiskLimit() {
    return riskLimit;
  }

  public Double getLeverage() {
    return leverage;
  }

  public Boolean getCrossMargin() {
    return crossMargin;
  }

  public Double getDeleveragePercentile() {
    return deleveragePercentile;
  }

  public Double getRebalancedPnl() {
    return rebalancedPnl;
  }

  public Double getPrevRealisedPnl() {
    return prevRealisedPnl;
  }

  public Double getPrevUnrealisedPnl() {
    return prevUnrealisedPnl;
  }

  public Double getPrevClosePrice() {
    return prevClosePrice;
  }

  public String getOpeningTimestamp() {
    return openingTimestamp;
  }

  public Double getOpeningQty() {
    return openingQty;
  }

  public Double getOpeningCost() {
    return openingCost;
  }

  public Double getOpeningComm() {
    return openingComm;
  }

  public Double getOpenOrderBuyQty() {
    return openOrderBuyQty;
  }

  public Double getOpenOrderBuyCost() {
    return openOrderBuyCost;
  }

  public Double getOpenOrderBuyPremium() {
    return openOrderBuyPremium;
  }

  public Double getOpenOrderSellQty() {
    return openOrderSellQty;
  }

  public Double getOpenOrderSellCost() {
    return openOrderSellCost;
  }

  public Double getOpenOrderSellPremium() {
    return openOrderSellPremium;
  }

  public Double getExecBuyQty() {
    return execBuyQty;
  }

  public Double getExecBuyCost() {
    return execBuyCost;
  }

  public Double getExecSellQty() {
    return execSellQty;
  }

  public Double getExecSellCost() {
    return execSellCost;
  }

  public Double getExecQty() {
    return execQty;
  }

  public Double getExecCost() {
    return execCost;
  }

  public Double getExecComm() {
    return execComm;
  }

  public String getCurrentTimestamp() {
    return currentTimestamp;
  }

  public Double getCurrentQty() {
    return currentQty;
  }

  public Double getCurrentCost() {
    return currentCost;
  }

  public Double getCurrentComm() {
    return currentComm;
  }

  public Double getRealisedCost() {
    return realisedCost;
  }

  public Double getUnrealisedCost() {
    return unrealisedCost;
  }

  public Double getGrossOpenCost() {
    return grossOpenCost;
  }

  public Double getGrossOpenPremium() {
    return grossOpenPremium;
  }

  public Double getGrossExecCost() {
    return grossExecCost;
  }

  public Boolean getOpen() {
    return isOpen;
  }

  public Double getMarkPrice() {
    return markPrice;
  }

  public Double getMarkValue() {
    return markValue;
  }

  public Double getRiskValue() {
    return riskValue;
  }

  public Double getHomeNotional() {
    return homeNotional;
  }

  public Double getForeignNotional() {
    return foreignNotional;
  }

  public String getPosState() {
    return posState;
  }

  public Double getPosCost() {
    return posCost;
  }

  public Double getPosCost2() {
    return posCost2;
  }

  public Double getPosCross() {
    return posCross;
  }

  public Double getPosInit() {
    return posInit;
  }

  public Double getPosComm() {
    return posComm;
  }

  public Double getPosLoss() {
    return posLoss;
  }

  public Double getPosMargin() {
    return posMargin;
  }

  public Double getPosMaint() {
    return posMaint;
  }

  public Double getPosAllowance() {
    return posAllowance;
  }

  public Double getTaxableMargin() {
    return taxableMargin;
  }

  public Double getInitMargin() {
    return initMargin;
  }

  public Double getMaintMargin() {
    return maintMargin;
  }

  public Double getSessionMargin() {
    return sessionMargin;
  }

  public Double getTargetExcessMargin() {
    return targetExcessMargin;
  }

  public Double getVarMargin() {
    return varMargin;
  }

  public Double getRealisedGrossPnl() {
    return realisedGrossPnl;
  }

  public Double getRealisedTax() {
    return realisedTax;
  }

  public Double getRealisedPnl() {
    return realisedPnl;
  }

  public Double getUnrealisedGrossPnl() {
    return unrealisedGrossPnl;
  }

  public Double getLongBankrupt() {
    return longBankrupt;
  }

  public Double getShortBankrupt() {
    return shortBankrupt;
  }

  public Double getTaxBase() {
    return taxBase;
  }

  public Double getIndicativeTaxRate() {
    return indicativeTaxRate;
  }

  public Double getIndicativeTax() {
    return indicativeTax;
  }

  public Double getUnrealisedTax() {
    return unrealisedTax;
  }

  public Double getUnrealisedPnl() {
    return unrealisedPnl;
  }

  public Double getUnrealisedPnlPcnt() {
    return unrealisedPnlPcnt;
  }

  public Double getUnrealisedRoePcnt() {
    return unrealisedRoePcnt;
  }

  public Double getSimpleQty() {
    return simpleQty;
  }

  public Double getSimpleCost() {
    return simpleCost;
  }

  public Double getSimpleValue() {
    return simpleValue;
  }

  public Double getSimplePnl() {
    return simplePnl;
  }

  public Double getSimplePnlPcnt() {
    return simplePnlPcnt;
  }

  public Double getAvgCostPrice() {
    return avgCostPrice;
  }

  public Double getAvgEntryPrice() {
    return avgEntryPrice;
  }

  public Double getBreakEvenPrice() {
    return breakEvenPrice;
  }

  public Double getMarginCallPrice() {
    return marginCallPrice;
  }

  public Double getLiquidationPrice() {
    return liquidationPrice;
  }

  public Double getBankruptPrice() {
    return bankruptPrice;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public Double getLastPrice() {
    return lastPrice;
  }

  public Double getLastValue() {
    return lastValue;
  }

  @Override
  public String toString() {
    return "BitmexPosition{"
        + "account="
        + account
        + ", symbol='"
        + symbol
        + '\''
        + ", currency='"
        + currency
        + '\''
        + ", underlying='"
        + underlying
        + '\''
        + ", quoteCurrency='"
        + quoteCurrency
        + '\''
        + ", commission="
        + commission
        + ", initMarginReq="
        + initMarginReq
        + ", maintMarginReq="
        + maintMarginReq
        + ", riskLimit="
        + riskLimit
        + ", leverage="
        + leverage
        + ", crossMargin="
        + crossMargin
        + ", deleveragePercentile="
        + deleveragePercentile
        + ", rebalancedPnl="
        + rebalancedPnl
        + ", prevRealisedPnl="
        + prevRealisedPnl
        + ", prevUnrealisedPnl="
        + prevUnrealisedPnl
        + ", prevClosePrice="
        + prevClosePrice
        + ", openingTimestamp='"
        + openingTimestamp
        + '\''
        + ", openingQty="
        + openingQty
        + ", openingCost="
        + openingCost
        + ", openingComm="
        + openingComm
        + ", openOrderBuyQty="
        + openOrderBuyQty
        + ", openOrderBuyCost="
        + openOrderBuyCost
        + ", openOrderBuyPremium="
        + openOrderBuyPremium
        + ", openOrderSellQty="
        + openOrderSellQty
        + ", openOrderSellCost="
        + openOrderSellCost
        + ", openOrderSellPremium="
        + openOrderSellPremium
        + ", execBuyQty="
        + execBuyQty
        + ", execBuyCost="
        + execBuyCost
        + ", execSellQty="
        + execSellQty
        + ", execSellCost="
        + execSellCost
        + ", execQty="
        + execQty
        + ", execCost="
        + execCost
        + ", execComm="
        + execComm
        + ", currentTimestamp='"
        + currentTimestamp
        + '\''
        + ", currentQty="
        + currentQty
        + ", currentCost="
        + currentCost
        + ", currentComm="
        + currentComm
        + ", realisedCost="
        + realisedCost
        + ", unrealisedCost="
        + unrealisedCost
        + ", grossOpenCost="
        + grossOpenCost
        + ", grossOpenPremium="
        + grossOpenPremium
        + ", grossExecCost="
        + grossExecCost
        + ", isOpen="
        + isOpen
        + ", markPrice="
        + markPrice
        + ", markValue="
        + markValue
        + ", riskValue="
        + riskValue
        + ", homeNotional="
        + homeNotional
        + ", foreignNotional="
        + foreignNotional
        + ", posState='"
        + posState
        + '\''
        + ", posCost="
        + posCost
        + ", posCost2="
        + posCost2
        + ", posCross="
        + posCross
        + ", posInit="
        + posInit
        + ", posComm="
        + posComm
        + ", posLoss="
        + posLoss
        + ", posMargin="
        + posMargin
        + ", posMaint="
        + posMaint
        + ", posAllowance="
        + posAllowance
        + ", taxableMargin="
        + taxableMargin
        + ", initMargin="
        + initMargin
        + ", maintMargin="
        + maintMargin
        + ", sessionMargin="
        + sessionMargin
        + ", targetExcessMargin="
        + targetExcessMargin
        + ", varMargin="
        + varMargin
        + ", realisedGrossPnl="
        + realisedGrossPnl
        + ", realisedTax="
        + realisedTax
        + ", realisedPnl="
        + realisedPnl
        + ", unrealisedGrossPnl="
        + unrealisedGrossPnl
        + ", longBankrupt="
        + longBankrupt
        + ", shortBankrupt="
        + shortBankrupt
        + ", taxBase="
        + taxBase
        + ", indicativeTaxRate="
        + indicativeTaxRate
        + ", indicativeTax="
        + indicativeTax
        + ", unrealisedTax="
        + unrealisedTax
        + ", unrealisedPnl="
        + unrealisedPnl
        + ", unrealisedPnlPcnt="
        + unrealisedPnlPcnt
        + ", unrealisedRoePcnt="
        + unrealisedRoePcnt
        + ", simpleQty="
        + simpleQty
        + ", simpleCost="
        + simpleCost
        + ", simpleValue="
        + simpleValue
        + ", simplePnl="
        + simplePnl
        + ", simplePnlPcnt="
        + simplePnlPcnt
        + ", avgCostPrice="
        + avgCostPrice
        + ", avgEntryPrice="
        + avgEntryPrice
        + ", breakEvenPrice="
        + breakEvenPrice
        + ", marginCallPrice="
        + marginCallPrice
        + ", liquidationPrice="
        + liquidationPrice
        + ", bankruptPrice="
        + bankruptPrice
        + ", timestamp='"
        + timestamp
        + '\''
        + ", lastPrice="
        + lastPrice
        + ", lastValue="
        + lastValue
        + '}';
  }
}
