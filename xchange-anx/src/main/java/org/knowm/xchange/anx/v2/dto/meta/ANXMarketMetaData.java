package org.knowm.xchange.anx.v2.dto.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.meta.FeeTier;

public class ANXMarketMetaData extends CurrencyPairMetaData {

  public ANXMarketMetaData(
      @JsonProperty("trading_fee") Double tradingFee,
      @JsonProperty("min_amount") Double minimumAmount,
      @JsonProperty("max_amount") Double maximumAmount,
      @JsonProperty("price_scale") int priceScale,
      @JsonProperty("fee_tiers") FeeTier[] feeTiers) {
    super(tradingFee, minimumAmount, null, priceScale, feeTiers);
  }
}
