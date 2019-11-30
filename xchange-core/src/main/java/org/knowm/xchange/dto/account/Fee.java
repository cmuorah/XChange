package org.knowm.xchange.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.openhft.chronicle.wire.AbstractMarshallable;

import java.io.Serializable;

public final class Fee extends AbstractMarshallable implements Serializable {

  private static final long serialVersionUID = -6235230375777573680L;

  @JsonProperty("maker_fee")
  private final Double makerFee;

  @JsonProperty("taker_fee")
  private final Double takerFee;

  public Fee(Double makerFee, Double takerFee) {
    this.makerFee = makerFee;
    this.takerFee = takerFee;
  }

  public Double getMakerFee() {
    return makerFee;
  }

  public Double getTakerFee() {
    return takerFee;
  }

  @Override
  public String toString() {
    return "Fee [makerFee=" + makerFee + ", takerFee=" + takerFee + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Fee other = (Fee) obj;
    return other.makerFee.equals(makerFee) && other.takerFee.equals(takerFee);
  }

  @Override
  public int hashCode() {
    return makerFee.hashCode() + 31 * takerFee.hashCode();
  }
}
