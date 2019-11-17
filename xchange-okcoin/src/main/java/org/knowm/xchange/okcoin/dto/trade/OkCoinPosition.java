package org.knowm.xchange.okcoin.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 * Instances of this class represent all holdings related to a specific contract, e.g. `this_week`.
 * If you have 2 open positions for this week then all fields (buy/sell) will be fully populated. If
 * you have multiple contracts open (`this_week`, `next_week`, ..) then each contract will be its
 * own instance.
 */
public class OkCoinPosition {

  private final long contractId;

  private final int status;

  private final String symbol;

  private final String type;

  private final Double rate;

  private final Date createDate;

  private Double buyAmount;

  private Double buyAmountAvailable;

  private Double buyProfitReal;

  private Double buyPriceAvg;

  private Double sellAmount;

  private Double sellAmountAvailable;

  private Double sellProfitReal;

  private Double sellPriceAvg;

  public OkCoinPosition(
      @JsonProperty("contract_id") final long orderId,
      @JsonProperty("status") final int status,
      @JsonProperty("symbol") final String symbol,
      @JsonProperty("type") final String type,
      @JsonProperty("lever_rate") final Double rate,
      @JsonProperty("buy_amount") final Double buyAmount,
      @JsonProperty("buy_available") final Double buyAmountAvailable,
      @JsonProperty("buy_profit_real") final Double buyProfitReal,
      @JsonProperty("buy_price_avg") final Double buyPriceAvg,
      @JsonProperty("sell_amount") final Double sellAmount,
      @JsonProperty("sell_available") final Double sellAmountAvailable,
      @JsonProperty("sell_profit_real") final Double sellProfitReal,
      @JsonProperty("sell_price_avg") final Double sellPriceAvg,
      @JsonProperty("create_date") final Date createDate) {

    this.contractId = orderId;
    this.status = status;
    this.symbol = symbol;
    this.type = type;
    this.rate = rate;

    this.buyAmount = buyAmount;
    this.buyAmountAvailable = buyAmountAvailable;
    this.buyProfitReal = buyProfitReal;
    this.buyPriceAvg = buyPriceAvg;

    this.sellAmount = sellAmount;
    this.sellAmountAvailable = sellAmountAvailable;
    this.sellProfitReal = sellProfitReal;
    this.sellPriceAvg = sellPriceAvg;

    this.createDate = createDate;
  }

  public long getContractId() {

    return contractId;
  }

  public int getStatus() {

    return status;
  }

  public String getSymbol() {

    return symbol;
  }

  public String getType() {

    return type;
  }

  public Double getRate() {

    return rate;
  }

  public Date getCreateDate() {

    return createDate;
  }

  public Double getBuyAmount() {

    return buyAmount;
  }

  public Double getBuyAmountAvailable() {

    return buyAmountAvailable;
  }

  public Double getBuyProfitReal() {

    return buyProfitReal;
  }

  public Double getBuyPriceAvg() {

    return buyPriceAvg;
  }

  public Double getSellAmount() {

    return sellAmount;
  }

  public Double getSellAmountAvailable() {

    return sellAmountAvailable;
  }

  public Double getSellProfitReal() {

    return sellProfitReal;
  }

  public Double getSellPriceAvg() {

    return sellPriceAvg;
  }

  @Override
  public String toString() {
    return "OkCoinPosition{"
        + "contractId="
        + contractId
        + ", status="
        + status
        + ", symbol='"
        + symbol
        + '\''
        + ", type='"
        + type
        + '\''
        + ", rate="
        + rate
        + ", createDate="
        + createDate
        + ", buyAmount="
        + buyAmount
        + ", buyAmountAvailable="
        + buyAmountAvailable
        + ", buyProfitReal="
        + buyProfitReal
        + ", buyPriceAvg="
        + buyPriceAvg
        + ", sellAmount="
        + sellAmount
        + ", sellAmountAvailable="
        + sellAmountAvailable
        + ", sellProfitReal="
        + sellProfitReal
        + ", sellPriceAvg="
        + sellPriceAvg
        + '}';
  }
}
