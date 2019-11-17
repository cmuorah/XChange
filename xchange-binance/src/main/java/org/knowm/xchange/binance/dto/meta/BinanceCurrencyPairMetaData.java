package org.knowm.xchange.binance.dto.meta;

import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.meta.FeeTier;

/** @author ujjwal on 26/02/18. */
public class BinanceCurrencyPairMetaData extends CurrencyPairMetaData {
  private final Double minNotional;

  /**
   * Constructor
   *
   * @param tradingFee Trading fee (fraction)
   * @param minimumAmount Minimum trade amount
   * @param maximumAmount Maximum trade amount
   * @param priceScale Price scale
   */
  public BinanceCurrencyPairMetaData(
      Double tradingFee,
      Double minimumAmount,
      Double maximumAmount,
      Integer priceScale,
      Double minNotional,
      FeeTier[] feeTiers) {
    super(tradingFee, minimumAmount, maximumAmount, priceScale, feeTiers);
    this.minNotional = minNotional;
  }

  public Double getMinNotional() {
    return minNotional;
  }

  @Override
  public String toString() {
    return "BinanceCurrencyPairMetaData{" + "minNotional=" + minNotional + "} " + super.toString();
  }
}
