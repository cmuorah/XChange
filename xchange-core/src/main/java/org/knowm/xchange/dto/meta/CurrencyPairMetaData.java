package org.knowm.xchange.dto.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Arrays;
import org.knowm.xchange.currency.Currency;

public class CurrencyPairMetaData implements Serializable {

  private static final long serialVersionUID = 4749144540694704221L;

  /** Trading fee (fraction) */
  @JsonProperty("trading_fee")
  private final Double tradingFee;

  /** Trading fee tiers by volume (fraction). Sorted in ascending order by quantity */
  @JsonProperty("fee_tiers")
  private final FeeTier[] feeTiers;

  /** Minimum trade amount */
  @JsonProperty("min_amount")
  private final Double minimumAmount;

  /** Maximum trade amount */
  @JsonProperty("max_amount")
  private final Double maximumAmount;

  /** Minimum trade amount */
  @JsonProperty("counter_min_amount")
  private final Double counterMinimumAmount;

  /** Maximum trade amount */
  @JsonProperty("counter_max_amount")
  private final Double counterMaximumAmount;

  /** Decimal places for base amount */
  @JsonProperty("base_scale")
  private final Integer baseScale;

  /** Decimal places for counter amount */
  @JsonProperty("price_scale")
  private final Integer priceScale;

  /** Amount step size. If set, any amounts must be a multiple of this */
  @JsonProperty("amount_step_size")
  private final Double amountStepSize;

  /** Currency that will be used to change for this trade. */
  private final Currency tradingFeeCurrency;

  /** Is market order type allowed on this pair. */
  private final boolean marketOrderEnabled;

  /**
   * Constructor
   *
   * @param tradingFee Trading fee (fraction)
   * @param minimumAmount Minimum trade amount
   * @param maximumAmount Maximum trade amount
   * @param priceScale Price scale
   */
  public CurrencyPairMetaData(
      Double tradingFee,
      Double minimumAmount,
      Double maximumAmount,
      Integer priceScale,
      FeeTier[] feeTiers) {
    this(
        tradingFee,
        minimumAmount,
        maximumAmount,
        null,
        null,
        null,
        priceScale,
        feeTiers,
        null,
        null,
        true);
  }

  /**
   * Constructor
   *
   * @param tradingFee Trading fee (fraction)
   * @param minimumAmount Minimum trade amount
   * @param maximumAmount Maximum trade amount
   * @param priceScale Price scale
   * @param amountStepSize Amounts must be a multiple of this amount if set.
   */
  public CurrencyPairMetaData(
      Double tradingFee,
      Double minimumAmount,
      Double maximumAmount,
      Integer priceScale,
      FeeTier[] feeTiers,
      Double amountStepSize) {
    this(
        tradingFee,
        minimumAmount,
        maximumAmount,
        null,
        null,
        null,
        priceScale,
        feeTiers,
        amountStepSize,
        null,
        true);
  }

  /**
   * Constructor
   *
   * @param tradingFee Trading fee (fraction)
   * @param minimumAmount Minimum trade amount
   * @param maximumAmount Maximum trade amount
   * @param priceScale Price scale
   * @param amountStepSize Amounts must be a multiple of this amount if set.
   */
  public CurrencyPairMetaData(
      @JsonProperty("trading_fee") Double tradingFee,
      @JsonProperty("min_amount") Double minimumAmount,
      @JsonProperty("max_amount") Double maximumAmount,
      @JsonProperty("counter_min_amount") Double counterMinimumAmount,
      @JsonProperty("counter_max_amount") Double counterMaximumAmount,
      @JsonProperty("base_scale") Integer baseScale,
      @JsonProperty("price_scale") Integer priceScale,
      @JsonProperty("fee_tiers") FeeTier[] feeTiers,
      @JsonProperty("amount_step_size") Double amountStepSize,
      @JsonProperty("trading_fee_currency") Currency tradingFeeCurrency,
      @JsonProperty("market_order_enabled") boolean marketOrderEnabled) {

    this.tradingFee = tradingFee;
    this.minimumAmount = minimumAmount;
    this.maximumAmount = maximumAmount;
    this.counterMinimumAmount = counterMinimumAmount;
    this.counterMaximumAmount = counterMaximumAmount;
    this.baseScale = baseScale;
    this.priceScale = priceScale;
    if (feeTiers != null) {
      Arrays.sort(feeTiers);
    }
    this.feeTiers = feeTiers;
    this.amountStepSize = amountStepSize;
    this.tradingFeeCurrency = tradingFeeCurrency;
    this.marketOrderEnabled = marketOrderEnabled;
  }

  public Double getTradingFee() {

    return tradingFee;
  }

  public Double getMinimumAmount() {

    return minimumAmount;
  }

  public Double getMaximumAmount() {

    return maximumAmount;
  }

  public Integer getBaseScale() {
    return baseScale;
  }

  public Integer getPriceScale() {

    return priceScale;
  }

  public FeeTier[] getFeeTiers() {

    return feeTiers;
  }

  public Double getAmountStepSize() {

    return amountStepSize;
  }

  public Currency getTradingFeeCurrency() {
    return tradingFeeCurrency;
  }

  public Double getCounterMinimumAmount() {
    return counterMinimumAmount;
  }

  public Double getCounterMaximumAmount() {
    return counterMaximumAmount;
  }

  public boolean isMarketOrderEnabled() {
    return marketOrderEnabled;
  }

  public static class Builder {

    private Double tradingFee;
    private FeeTier[] feeTiers;
    private Double minimumAmount;
    private Double maximumAmount;
    private Double counterMinimumAmount;
    private Double counterMaximumAmount;
    private Integer baseScale;
    private Integer priceScale;
    private Double amountStepSize;
    private Currency tradingFeeCurrency;
    private boolean marketOrderEnabled;

    public static Builder from(CurrencyPairMetaData metaData) {
      return new Builder()
          .tradingFee(metaData.getTradingFee())
          .feeTiers(metaData.getFeeTiers())
          .minimumAmount(metaData.getMinimumAmount())
          .maximumAmount(metaData.getMaximumAmount())
          .counterMinimumAmount(metaData.getCounterMinimumAmount())
          .counterMaximumAmount(metaData.getCounterMaximumAmount())
          .baseScale(metaData.getBaseScale())
          .priceScale(metaData.getPriceScale())
          .amountStepSize(metaData.getAmountStepSize())
          .tradingFee(metaData.getTradingFee())
          .tradingFeeCurrency(metaData.getTradingFeeCurrency());
    }

    public Builder tradingFee(Double tradingFee) {
      this.tradingFee = tradingFee;
      return this;
    }

    public Builder feeTiers(FeeTier[] feeTiers) {
      this.feeTiers = feeTiers;
      return this;
    }

    public Builder minimumAmount(Double minimumAmount) {
      this.minimumAmount = minimumAmount;
      return this;
    }

    public Builder maximumAmount(Double maximumAmount) {
      this.maximumAmount = maximumAmount;
      return this;
    }

    public Builder counterMinimumAmount(Double counterMinimumAmount) {
      this.counterMinimumAmount = counterMinimumAmount;
      return this;
    }

    public Builder counterMaximumAmount(Double counterMaximumAmount) {
      this.counterMaximumAmount = counterMaximumAmount;
      return this;
    }

    public Builder baseScale(Integer baseScale) {
      this.baseScale = baseScale;
      return this;
    }

    public Builder priceScale(Integer priceScale) {
      this.priceScale = priceScale;
      return this;
    }

    public Builder amountStepSize(Double amountStepSize) {
      this.amountStepSize = amountStepSize;
      return this;
    }

    public Builder tradingFeeCurrency(Currency tradingFeeCurrency) {
      this.tradingFeeCurrency = tradingFeeCurrency;
      return this;
    }

    public Builder marketOrderEnabled(boolean marketOrderEnabled) {
      this.marketOrderEnabled = marketOrderEnabled;
      return this;
    }

    public CurrencyPairMetaData build() {
      return new CurrencyPairMetaData(
          tradingFee,
          minimumAmount,
          maximumAmount,
          counterMinimumAmount,
          counterMaximumAmount,
          baseScale,
          priceScale,
          feeTiers,
          amountStepSize,
          tradingFeeCurrency,
          marketOrderEnabled);
    }
  }

  @Override
  public String toString() {

    return "CurrencyPairMetaData [tradingFee="
        + tradingFee
        + ", minimumAmount="
        + minimumAmount
        + ", maximumAmount="
        + maximumAmount
        + ", baseScale="
        + baseScale
        + ", priceScale="
        + priceScale
        + ", amountStepSize="
        + amountStepSize
        + ", tradingFeeCurrency="
        + tradingFeeCurrency
        + "]";
  }
}
