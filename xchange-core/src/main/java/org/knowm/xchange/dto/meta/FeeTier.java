package org.knowm.xchange.dto.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

import net.openhft.chronicle.wire.AbstractMarshallable;
import org.knowm.xchange.dto.account.Fee;

public class FeeTier extends AbstractMarshallable implements Serializable, Comparable<FeeTier> {

  private static final long serialVersionUID = -4350427635840047928L;

  @JsonProperty("begin_quantity")
  public final Double beginQuantity;

  @JsonProperty("fee")
  public Fee fee;

  public FeeTier(
      @JsonProperty("begin_quantity") Double beginQuantity, @JsonProperty("fee") Fee fee) {
    this.beginQuantity = beginQuantity;
    this.fee = fee;
  }

  @Override
  public String toString() {
    return "FeeTier [beginQuantity=" + beginQuantity + ", fee=" + fee;
  }

  @Override
  public int compareTo(FeeTier other) {
    return beginQuantity.compareTo(other.beginQuantity);
  }
}
