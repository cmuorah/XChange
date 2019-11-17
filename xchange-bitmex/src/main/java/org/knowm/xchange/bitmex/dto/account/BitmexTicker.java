package org.knowm.xchange.bitmex.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "symbol",
  "rootSymbol",
  "state",
  "typ",
  "listing",
  "front",
  "expiry",
  "settle",
  "relistInterval",
  "inverseLeg",
  "sellLeg",
  "buyLeg",
  "positionCurrency",
  "underlying",
  "quoteCurrency",
  "underlyingSymbol",
  "reference",
  "referenceSymbol",
  "calcInterval",
  "publishInterval",
  "publishTime",
  "maxOrderQty",
  "maxPrice",
  "lotSize",
  "tickSize",
  "multiplier",
  "settlCurrency",
  "underlyingToPositionMultiplier",
  "underlyingToSettleMultiplier",
  "quoteToSettleMultiplier",
  "isQuanto",
  "isInverse",
  "initMargin",
  "maintMargin",
  "riskLimit",
  "riskStep",
  "limit",
  "capped",
  "taxed",
  "deleverage",
  "makerFee",
  "takerFee",
  "settlementFee",
  "insuranceFee",
  "fundingBaseSymbol",
  "fundingQuoteSymbol",
  "fundingPremiumSymbol",
  "fundingTimestamp",
  "fundingInterval",
  "fundingRate",
  "indicativeFundingRate",
  "rebalanceTimestamp",
  "rebalanceInterval",
  "openingTimestamp",
  "closingTimestamp",
  "sessionInterval",
  "prevClosePrice",
  "limitDownPrice",
  "limitUpPrice",
  "bankruptLimitDownPrice",
  "bankruptLimitUpPrice",
  "prevTotalVolume",
  "totalVolume",
  "volume",
  "volume24h",
  "prevTotalTurnover",
  "totalTurnover",
  "turnover",
  "turnover24h",
  "prevPrice24h",
  "vwap",
  "highPrice",
  "lowPrice",
  "lastPrice",
  "lastPriceProtected",
  "lastTickDirection",
  "lastChangePcnt",
  "bidPrice",
  "midPrice",
  "askPrice",
  "impactBidPrice",
  "impactMidPrice",
  "impactAskPrice",
  "hasLiquidity",
  "openInterest",
  "openValue",
  "fairMethod",
  "fairBasisRate",
  "fairBasis",
  "fairPrice",
  "markMethod",
  "markPrice",
  "indicativeTaxRate",
  "indicativeSettlePrice",
  "settledPrice",
  "timestamp"
})
public class BitmexTicker {

  @JsonProperty("symbol")
  private String symbol;

  @JsonProperty("rootSymbol")
  private String rootSymbol;

  @JsonProperty("state")
  private String state;

  @JsonProperty("typ")
  private String typ;

  @JsonProperty("listing")
  private Date listing;

  @JsonProperty("front")
  private Date front;

  @JsonProperty("expiry")
  private Date expiry;

  @JsonProperty("settle")
  private Date settle;

  @JsonProperty("relistInterval")
  private String relistInterval;

  @JsonProperty("inverseLeg")
  private String inverseLeg;

  @JsonProperty("sellLeg")
  private String sellLeg;

  @JsonProperty("buyLeg")
  private String buyLeg;

  @JsonProperty("positionCurrency")
  private String positionCurrency;

  @JsonProperty("underlying")
  private String underlying;

  @JsonProperty("quoteCurrency")
  private String quoteCurrency;

  @JsonProperty("underlyingSymbol")
  private String underlyingSymbol;

  @JsonProperty("reference")
  private String reference;

  @JsonProperty("referenceSymbol")
  private String referenceSymbol;

  @JsonProperty("calcInterval")
  private String calcInterval;

  @JsonProperty("publishInterval")
  private String publishInterval;

  @JsonProperty("publishTime")
  private String publishTime;

  @JsonProperty("maxOrderQty")
  private Double maxOrderQty;

  @JsonProperty("maxPrice")
  private Double maxPrice;

  @JsonProperty("lotSize")
  private Double lotSize;

  @JsonProperty("tickSize")
  private Double tickSize;

  @JsonProperty("multiplier")
  private Double multiplier;

  @JsonProperty("settlCurrency")
  private String settlCurrency;

  @JsonProperty("underlyingToPositionMultiplier")
  private Double underlyingToPositionMultiplier;

  @JsonProperty("underlyingToSettleMultiplier")
  private Double underlyingToSettleMultiplier;

  @JsonProperty("quoteToSettleMultiplier")
  private Double quoteToSettleMultiplier;

  @JsonProperty("isQuanto")
  private Boolean isQuanto;

  @JsonProperty("isInverse")
  private Boolean isInverse;

  @JsonProperty("initMargin")
  private Double initMargin;

  @JsonProperty("maintMargin")
  private Double maintMargin;

  @JsonProperty("riskLimit")
  private BigInteger riskLimit;

  @JsonProperty("riskStep")
  private BigInteger riskStep;

  @JsonProperty("limit")
  private Double limit;

  @JsonProperty("capped")
  private Boolean capped;

  @JsonProperty("taxed")
  private Boolean taxed;

  @JsonProperty("deleverage")
  private Boolean deleverage;

  @JsonProperty("makerFee")
  private Double makerFee;

  @JsonProperty("takerFee")
  private Double takerFee;

  @JsonProperty("settlementFee")
  private Double settlementFee;

  @JsonProperty("insuranceFee")
  private Double insuranceFee;

  @JsonProperty("fundingBaseSymbol")
  private String fundingBaseSymbol;

  @JsonProperty("fundingQuoteSymbol")
  private String fundingQuoteSymbol;

  @JsonProperty("fundingPremiumSymbol")
  private String fundingPremiumSymbol;

  @JsonProperty("fundingTimestamp")
  private Date fundingTimestamp;

  @JsonProperty("fundingInterval")
  private Date fundingInterval;

  @JsonProperty("fundingRate")
  private Double fundingRate;

  @JsonProperty("indicativeFundingRate")
  private Double indicativeFundingRate;

  @JsonProperty("rebalanceTimestamp")
  private String rebalanceTimestamp;

  @JsonProperty("rebalanceInterval")
  private String rebalanceInterval;

  @JsonProperty("openingTimestamp")
  private Date openingTimestamp;

  @JsonProperty("closingTimestamp")
  private Date closingTimestamp;

  @JsonProperty("sessionInterval")
  private Date sessionInterval;

  @JsonProperty("prevClosePrice")
  private Double prevClosePrice;

  @JsonProperty("limitDownPrice")
  private Double limitDownPrice;

  @JsonProperty("limitUpPrice")
  private Double limitUpPrice;

  @JsonProperty("bankruptLimitDownPrice")
  private Double bankruptLimitDownPrice;

  @JsonProperty("bankruptLimitUpPrice")
  private Double bankruptLimitUpPrice;

  @JsonProperty("prevTotalVolume")
  private Double prevTotalVolume;

  @JsonProperty("totalVolume")
  private Double totalVolume;

  @JsonProperty("volume")
  private Double volume;

  @JsonProperty("volume24h")
  private Double volume24h;

  @JsonProperty("prevTotalTurnover")
  private BigInteger prevTotalTurnover;

  @JsonProperty("totalTurnover")
  private BigInteger totalTurnover;

  @JsonProperty("turnover")
  private BigInteger turnover;

  @JsonProperty("turnover24h")
  private BigInteger turnover24h;

  @JsonProperty("prevPrice24h")
  private BigInteger prevPrice24h;

  @JsonProperty("vwap")
  private BigInteger vwap;

  @JsonProperty("highPrice")
  private Double highPrice;

  @JsonProperty("lowPrice")
  private Double lowPrice;

  @JsonProperty("lastPrice")
  private Double lastPrice;

  @JsonProperty("lastPriceProtected")
  private Double lastPriceProtected;

  @JsonProperty("lastTickDirection")
  private String lastTickDirection;

  @JsonProperty("lastChangePcnt")
  private Double lastChangePcnt;

  @JsonProperty("bidPrice")
  private Double bidPrice;

  @JsonProperty("midPrice")
  private Double midPrice;

  @JsonProperty("askPrice")
  private Double askPrice;

  @JsonProperty("impactBidPrice")
  private Double impactBidPrice;

  @JsonProperty("impactMidPrice")
  private Double impactMidPrice;

  @JsonProperty("impactAskPrice")
  private Double impactAskPrice;

  @JsonProperty("hasLiquidity")
  private Boolean hasLiquidity;

  @JsonProperty("openInterest")
  private Double openInterest;

  @JsonProperty("openValue")
  private Double openValue;

  @JsonProperty("fairMethod")
  private String fairMethod;

  @JsonProperty("fairBasisRate")
  private Double fairBasisRate;

  @JsonProperty("fairBasis")
  private Double fairBasis;

  @JsonProperty("fairPrice")
  private Double fairPrice;

  @JsonProperty("markMethod")
  private String markMethod;

  @JsonProperty("markPrice")
  private Double markPrice;

  @JsonProperty("indicativeTaxRate")
  private Double indicativeTaxRate;

  @JsonProperty("indicativeSettlePrice")
  private Double indicativeSettlePrice;

  @JsonProperty("settledPrice")
  private Double settledPrice;

  @JsonProperty("timestamp")
  private Date timestamp;

  @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<>();

  public String getSymbol() {
    return symbol;
  }

  public String getRootSymbol() {
    return rootSymbol;
  }

  public String getState() {
    return state;
  }

  public String getTyp() {
    return typ;
  }

  public Date getListing() {
    return listing;
  }

  public Date getFront() {
    return front;
  }

  public Date getExpiry() {
    return expiry;
  }

  public Date getSettle() {
    return settle;
  }

  public String getRelistInterval() {
    return relistInterval;
  }

  public String getInverseLeg() {
    return inverseLeg;
  }

  public String getSellLeg() {
    return sellLeg;
  }

  public String getBuyLeg() {
    return buyLeg;
  }

  public String getPositionCurrency() {
    return positionCurrency;
  }

  public String getUnderlying() {
    return underlying;
  }

  public String getQuoteCurrency() {
    return quoteCurrency;
  }

  public String getUnderlyingSymbol() {
    return underlyingSymbol;
  }

  public String getReference() {
    return reference;
  }

  public String getReferenceSymbol() {
    return referenceSymbol;
  }

  public String getCalcInterval() {
    return calcInterval;
  }

  public String getPublishInterval() {
    return publishInterval;
  }

  public String getPublishTime() {
    return publishTime;
  }

  public Double getMaxOrderQty() {
    return maxOrderQty;
  }

  public Double getMaxPrice() {
    return maxPrice;
  }

  public Double getLotSize() {
    return lotSize;
  }

  public Double getTickSize() {
    return tickSize;
  }

  public Double getMultiplier() {
    return multiplier;
  }

  public String getSettlCurrency() {
    return settlCurrency;
  }

  public Double getUnderlyingToPositionMultiplier() {
    return underlyingToPositionMultiplier;
  }

  public Double getUnderlyingToSettleMultiplier() {
    return underlyingToSettleMultiplier;
  }

  public Double getQuoteToSettleMultiplier() {
    return quoteToSettleMultiplier;
  }

  public Boolean getQuanto() {
    return isQuanto;
  }

  public Boolean getInverse() {
    return isInverse;
  }

  public Double getInitMargin() {
    return initMargin;
  }

  public Double getMaintMargin() {
    return maintMargin;
  }

  public BigInteger getRiskLimit() {
    return riskLimit;
  }

  public BigInteger getRiskStep() {
    return riskStep;
  }

  public Double getLimit() {
    return limit;
  }

  public Boolean getCapped() {
    return capped;
  }

  public Boolean getTaxed() {
    return taxed;
  }

  public Boolean getDeleverage() {
    return deleverage;
  }

  public Double getMakerFee() {
    return makerFee;
  }

  public Double getTakerFee() {
    return takerFee;
  }

  public Double getSettlementFee() {
    return settlementFee;
  }

  public Double getInsuranceFee() {
    return insuranceFee;
  }

  public String getFundingBaseSymbol() {
    return fundingBaseSymbol;
  }

  public String getFundingQuoteSymbol() {
    return fundingQuoteSymbol;
  }

  public String getFundingPremiumSymbol() {
    return fundingPremiumSymbol;
  }

  public Date getFundingTimestamp() {
    return fundingTimestamp;
  }

  public Date getFundingInterval() {
    return fundingInterval;
  }

  public Double getFundingRate() {
    return fundingRate;
  }

  public Double getIndicativeFundingRate() {
    return indicativeFundingRate;
  }

  public String getRebalanceTimestamp() {
    return rebalanceTimestamp;
  }

  public String getRebalanceInterval() {
    return rebalanceInterval;
  }

  public Date getOpeningTimestamp() {
    return openingTimestamp;
  }

  public Date getClosingTimestamp() {
    return closingTimestamp;
  }

  public Date getSessionInterval() {
    return sessionInterval;
  }

  public Double getPrevClosePrice() {
    return prevClosePrice;
  }

  public Double getLimitDownPrice() {
    return limitDownPrice;
  }

  public Double getLimitUpPrice() {
    return limitUpPrice;
  }

  public Double getBankruptLimitDownPrice() {
    return bankruptLimitDownPrice;
  }

  public Double getBankruptLimitUpPrice() {
    return bankruptLimitUpPrice;
  }

  public Double getPrevTotalVolume() {
    return prevTotalVolume;
  }

  public Double getTotalVolume() {
    return totalVolume;
  }

  public Double getVolume() {
    return volume;
  }

  public Double getVolume24h() {
    return volume24h;
  }

  public BigInteger getPrevTotalTurnover() {
    return prevTotalTurnover;
  }

  public BigInteger getTotalTurnover() {
    return totalTurnover;
  }

  public BigInteger getTurnover() {
    return turnover;
  }

  public BigInteger getTurnover24h() {
    return turnover24h;
  }

  public BigInteger getPrevPrice24h() {
    return prevPrice24h;
  }

  public BigInteger getVwap() {
    return vwap;
  }

  public Double getHighPrice() {
    return highPrice;
  }

  public Double getLowPrice() {
    return lowPrice;
  }

  public Double getLastPrice() {
    return lastPrice;
  }

  public Double getLastPriceProtected() {
    return lastPriceProtected;
  }

  public String getLastTickDirection() {
    return lastTickDirection;
  }

  public Double getLastChangePcnt() {
    return lastChangePcnt;
  }

  public Double getBidPrice() {
    return bidPrice;
  }

  public Double getMidPrice() {
    return midPrice;
  }

  public Double getAskPrice() {
    return askPrice;
  }

  public Double getImpactBidPrice() {
    return impactBidPrice;
  }

  public Double getImpactMidPrice() {
    return impactMidPrice;
  }

  public Double getImpactAskPrice() {
    return impactAskPrice;
  }

  public Boolean getHasLiquidity() {
    return hasLiquidity;
  }

  public Double getOpenInterest() {
    return openInterest;
  }

  public Double getOpenValue() {
    return openValue;
  }

  public String getFairMethod() {
    return fairMethod;
  }

  public Double getFairBasisRate() {
    return fairBasisRate;
  }

  public Double getFairBasis() {
    return fairBasis;
  }

  public Double getFairPrice() {
    return fairPrice;
  }

  public String getMarkMethod() {
    return markMethod;
  }

  public Double getMarkPrice() {
    return markPrice;
  }

  public Double getIndicativeTaxRate() {
    return indicativeTaxRate;
  }

  public Double getIndicativeSettlePrice() {
    return indicativeSettlePrice;
  }

  public Double getSettledPrice() {
    return settledPrice;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  @Override
  public String toString() {
    return "BitmexTicker{"
        + "symbol='"
        + symbol
        + '\''
        + ", rootSymbol='"
        + rootSymbol
        + '\''
        + ", state='"
        + state
        + '\''
        + ", typ='"
        + typ
        + '\''
        + ", listing='"
        + listing
        + '\''
        + ", front='"
        + front
        + '\''
        + ", expiry='"
        + expiry
        + '\''
        + ", settle='"
        + settle
        + '\''
        + ", relistInterval='"
        + relistInterval
        + '\''
        + ", inverseLeg='"
        + inverseLeg
        + '\''
        + ", sellLeg='"
        + sellLeg
        + '\''
        + ", buyLeg='"
        + buyLeg
        + '\''
        + ", positionCurrency='"
        + positionCurrency
        + '\''
        + ", underlying='"
        + underlying
        + '\''
        + ", quoteCurrency='"
        + quoteCurrency
        + '\''
        + ", underlyingSymbol='"
        + underlyingSymbol
        + '\''
        + ", reference='"
        + reference
        + '\''
        + ", referenceSymbol='"
        + referenceSymbol
        + '\''
        + ", calcInterval='"
        + calcInterval
        + '\''
        + ", publishInterval='"
        + publishInterval
        + '\''
        + ", publishTime='"
        + publishTime
        + '\''
        + ", maxOrderQty="
        + maxOrderQty
        + ", maxPrice="
        + maxPrice
        + ", lotSize="
        + lotSize
        + ", tickSize="
        + tickSize
        + ", multiplier="
        + multiplier
        + ", settlCurrency='"
        + settlCurrency
        + '\''
        + ", underlyingToPositionMultiplier="
        + underlyingToPositionMultiplier
        + ", underlyingToSettleMultiplier="
        + underlyingToSettleMultiplier
        + ", quoteToSettleMultiplier="
        + quoteToSettleMultiplier
        + ", isQuanto="
        + isQuanto
        + ", isInverse="
        + isInverse
        + ", initMargin="
        + initMargin
        + ", maintMargin="
        + maintMargin
        + ", riskLimit="
        + riskLimit
        + ", riskStep="
        + riskStep
        + ", limit="
        + limit
        + ", capped="
        + capped
        + ", taxed="
        + taxed
        + ", deleverage="
        + deleverage
        + ", makerFee="
        + makerFee
        + ", takerFee="
        + takerFee
        + ", settlementFee="
        + settlementFee
        + ", insuranceFee="
        + insuranceFee
        + ", fundingBaseSymbol='"
        + fundingBaseSymbol
        + '\''
        + ", fundingQuoteSymbol='"
        + fundingQuoteSymbol
        + '\''
        + ", fundingPremiumSymbol='"
        + fundingPremiumSymbol
        + '\''
        + ", fundingTimestamp='"
        + fundingTimestamp
        + '\''
        + ", fundingInterval='"
        + fundingInterval
        + '\''
        + ", fundingRate="
        + fundingRate
        + ", indicativeFundingRate="
        + indicativeFundingRate
        + ", rebalanceTimestamp='"
        + rebalanceTimestamp
        + '\''
        + ", rebalanceInterval='"
        + rebalanceInterval
        + '\''
        + ", openingTimestamp='"
        + openingTimestamp
        + '\''
        + ", closingTimestamp='"
        + closingTimestamp
        + '\''
        + ", sessionInterval='"
        + sessionInterval
        + '\''
        + ", prevClosePrice="
        + prevClosePrice
        + ", limitDownPrice="
        + limitDownPrice
        + ", limitUpPrice="
        + limitUpPrice
        + ", bankruptLimitDownPrice="
        + bankruptLimitDownPrice
        + ", bankruptLimitUpPrice="
        + bankruptLimitUpPrice
        + ", prevTotalVolume="
        + prevTotalVolume
        + ", totalVolume="
        + totalVolume
        + ", volume="
        + volume
        + ", volume24h="
        + volume24h
        + ", prevTotalTurnover="
        + prevTotalTurnover
        + ", totalTurnover="
        + totalTurnover
        + ", turnover="
        + turnover
        + ", turnover24h="
        + turnover24h
        + ", prevPrice24h="
        + prevPrice24h
        + ", vwap="
        + vwap
        + ", highPrice="
        + highPrice
        + ", lowPrice="
        + lowPrice
        + ", lastPrice="
        + lastPrice
        + ", lastPriceProtected="
        + lastPriceProtected
        + ", lastTickDirection='"
        + lastTickDirection
        + '\''
        + ", lastChangePcnt="
        + lastChangePcnt
        + ", bidPrice="
        + bidPrice
        + ", midPrice="
        + midPrice
        + ", askPrice="
        + askPrice
        + ", impactBidPrice="
        + impactBidPrice
        + ", impactMidPrice="
        + impactMidPrice
        + ", impactAskPrice="
        + impactAskPrice
        + ", hasLiquidity="
        + hasLiquidity
        + ", openInterest="
        + openInterest
        + ", openValue="
        + openValue
        + ", fairMethod='"
        + fairMethod
        + '\''
        + ", fairBasisRate="
        + fairBasisRate
        + ", fairBasis="
        + fairBasis
        + ", fairPrice="
        + fairPrice
        + ", markMethod='"
        + markMethod
        + '\''
        + ", markPrice="
        + markPrice
        + ", indicativeTaxRate="
        + indicativeTaxRate
        + ", indicativeSettlePrice="
        + indicativeSettlePrice
        + ", settledPrice="
        + settledPrice
        + ", timestamp='"
        + timestamp
        + '\''
        + ", additionalProperties="
        + additionalProperties
        + '}';
  }
}
