package org.knowm.xchange.bitmex.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;
import org.knowm.xchange.bitmex.AbstractHttpResponseAware;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "account",
  "currency",
  "riskLimit",
  "prevState",
  "state",
  "action",
  "amount",
  "pendingCredit",
  "pendingDebit",
  "confirmedDebit",
  "prevRealisedPnl",
  "prevUnrealisedPnl",
  "grossComm",
  "grossOpenCost",
  "grossOpenPremium",
  "grossExecCost",
  "grossMarkValue",
  "riskValue",
  "taxableMargin",
  "initMargin",
  "maintMargin",
  "sessionMargin",
  "targetExcessMargin",
  "varMargin",
  "realisedPnl",
  "unrealisedPnl",
  "indicativeTax",
  "unrealisedProfit",
  "syntheticMargin",
  "walletBalance",
  "marginBalance",
  "marginBalancePcnt",
  "marginLeverage",
  "marginUsedPcnt",
  "excessMargin",
  "excessMarginPcnt",
  "availableMargin",
  "withdrawableMargin",
  "timestamp",
  "grossLastValue",
  "commission"
})
public final class BitmexMarginAccount extends AbstractHttpResponseAware {

  @JsonProperty("account")
  public Integer account;

  @JsonProperty("currency")
  public String currency;

  @JsonProperty("riskLimit")
  public Double riskLimit;

  @JsonProperty("prevState")
  public String prevState;

  @JsonProperty("state")
  public String state;

  @JsonProperty("action")
  public String action;

  @JsonProperty("amount")
  public Double amount;

  @JsonProperty("pendingCredit")
  public Double pendingCredit;

  @JsonProperty("pendingDebit")
  public Double pendingDebit;

  @JsonProperty("confirmedDebit")
  public Double confirmedDebit;

  @JsonProperty("prevRealisedPnl")
  public Double prevRealisedPnl;

  @JsonProperty("prevUnrealisedPnl")
  public Double prevUnrealisedPnl;

  @JsonProperty("grossComm")
  public Double grossComm;

  @JsonProperty("grossOpenCost")
  public Double grossOpenCost;

  @JsonProperty("grossOpenPremium")
  public Double grossOpenPremium;

  @JsonProperty("grossExecCost")
  public Double grossExecCost;

  @JsonProperty("grossMarkValue")
  public Double grossMarkValue;

  @JsonProperty("riskValue")
  public Double riskValue;

  @JsonProperty("taxableMargin")
  public Double taxableMargin;

  @JsonProperty("initMargin")
  public Double initMargin;

  @JsonProperty("maintMargin")
  public Double maintMargin;

  @JsonProperty("sessionMargin")
  public Double sessionMargin;

  @JsonProperty("targetExcessMargin")
  public Double targetExcessMargin;

  @JsonProperty("varMargin")
  public Double varMargin;

  @JsonProperty("realisedPnl")
  public Double realisedPnl;

  @JsonProperty("unrealisedPnl")
  public Double unrealisedPnl;

  @JsonProperty("indicativeTax")
  public Double indicativeTax;

  @JsonProperty("unrealisedProfit")
  public Double unrealisedProfit;

  @JsonProperty("syntheticMargin")
  public Double syntheticMargin;

  @JsonProperty("walletBalance")
  public Double walletBalance;

  @JsonProperty("marginBalance")
  public Double marginBalance;

  @JsonProperty("marginBalancePcnt")
  public Double marginBalancePcnt;

  @JsonProperty("marginLeverage")
  public Double marginLeverage;

  @JsonProperty("marginUsedPcnt")
  public Double marginUsedPcnt;

  @JsonProperty("excessMargin")
  public Double excessMargin;

  @JsonProperty("excessMarginPcnt")
  public Double excessMarginPcnt;

  @JsonProperty("availableMargin")
  public Double availableMargin;

  @JsonProperty("withdrawableMargin")
  public Double withdrawableMargin;

  @JsonProperty("timestamp")
  public String timestamp;

  @JsonProperty("grossLastValue")
  public Double grossLastValue;

  @JsonProperty("commission")
  public Double commission;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<>();

  public Integer getAccount() {
    return account;
  }

  public String getCurrency() {
    return currency;
  }

  public Double getRiskLimit() {
    return riskLimit;
  }

  public String getPrevState() {
    return prevState;
  }

  public String getState() {
    return state;
  }

  public String getAction() {
    return action;
  }

  public Double getAmount() {
    return amount;
  }

  public Double getPendingCredit() {
    return pendingCredit;
  }

  public Double getPendingDebit() {
    return pendingDebit;
  }

  public Double getConfirmedDebit() {
    return confirmedDebit;
  }

  public Double getPrevRealisedPnl() {
    return prevRealisedPnl;
  }

  public Double getPrevUnrealisedPnl() {
    return prevUnrealisedPnl;
  }

  public Double getGrossComm() {
    return grossComm;
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

  public Double getGrossMarkValue() {
    return grossMarkValue;
  }

  public Double getRiskValue() {
    return riskValue;
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

  public Double getRealisedPnl() {
    return realisedPnl;
  }

  public Double getUnrealisedPnl() {
    return unrealisedPnl;
  }

  public Double getIndicativeTax() {
    return indicativeTax;
  }

  public Double getUnrealisedProfit() {
    return unrealisedProfit;
  }

  public Double getSyntheticMargin() {
    return syntheticMargin;
  }

  public Double getWalletBalance() {
    return walletBalance;
  }

  public Double getMarginBalance() {
    return marginBalance;
  }

  public Double getMarginBalancePcnt() {
    return marginBalancePcnt;
  }

  public Double getMarginLeverage() {
    return marginLeverage;
  }

  public Double getMarginUsedPcnt() {
    return marginUsedPcnt;
  }

  public Double getExcessMargin() {
    return excessMargin;
  }

  public Double getExcessMarginPcnt() {
    return excessMarginPcnt;
  }

  public Double getAvailableMargin() {
    return availableMargin;
  }

  public Double getWithdrawableMargin() {
    return withdrawableMargin;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public Double getGrossLastValue() {
    return grossLastValue;
  }

  public Double getCommission() {
    return commission;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }
}
