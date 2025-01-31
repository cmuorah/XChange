package org.knowm.xchange.anx.v2.dto.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.meta.CurrencyMetaData;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.meta.ExchangeMetaData;
import org.knowm.xchange.dto.meta.RateLimit;

public class ANXMetaData extends ExchangeMetaData {

  @JsonProperty("maker_trading_fee")
  private final Double makerTradingFee;

  @JsonProperty("taker_trading_fee")
  private final Double takerTradingFee;

  public ANXMetaData(
      @JsonProperty("currency_pairs") Map<CurrencyPair, CurrencyPairMetaData> currencyPairs,
      @JsonProperty("currencies") Map<Currency, CurrencyMetaData> currencies,
      @JsonProperty("public_rate_limits") RateLimit[] publicRateLimits,
      @JsonProperty("private_rate_limits") RateLimit[] privateRateLimits,
      @JsonProperty("share_rate_limits") Boolean shareRateLimits,
      @JsonProperty("maker_trading_fee") Double makerTradingFee,
      @JsonProperty("taker_trading_fee") Double takerTradingFee) {

    super(currencyPairs, currencies, publicRateLimits, privateRateLimits, shareRateLimits);

    this.makerTradingFee = makerTradingFee;
    this.takerTradingFee = takerTradingFee;
  }

  public Double getMakerTradingFee() {
    return makerTradingFee;
  }

  public Double getTakerTradingFee() {
    return takerTradingFee;
  }
}
