package org.knowm.xchange.dto.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.openhft.chronicle.wire.AbstractMarshallable;

import java.io.Serializable;

public class CurrencyMetaData extends AbstractMarshallable implements Serializable {

  private static final long serialVersionUID = -247899067657358542L;

  @JsonProperty("scale")
  private final Integer scale;

  /** Withdrawal fee */
  @JsonProperty("withdrawal_fee")
  private Double withdrawalFee;

  /**
   * Constructor
   *
   * @param scale
   */
  public CurrencyMetaData(
      @JsonProperty("scale") Integer scale, @JsonProperty("withdrawal_fee") Double withdrawalFee) {
    this.scale = scale;
    this.withdrawalFee = withdrawalFee;
  }

  public Integer getScale() {
    return scale;
  }

  public Double getWithdrawalFee() {
    return withdrawalFee;
  }

  @Override
  public String toString() {
    return "CurrencyMetaData [" + "scale=" + scale + ", withdrawalFee=" + withdrawalFee + "]";
  }
}
