package org.knowm.xchange.gateio.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import org.knowm.xchange.gateio.dto.GateioBaseResponse;

public class GateioFunds extends GateioBaseResponse {

  private final Map<String, Double> available;
  private final Map<String, Double> locked;

  /**
   * Constructor
   *
   * @param theAvailable
   * @param theLocked
   */
  public GateioFunds(
      @JsonProperty("available") Map<String, Double> theAvailable,
      @JsonProperty("locked") Map<String, Double> theLocked,
      @JsonProperty("result") boolean result,
      @JsonProperty("message") final String message) {

    super(result, message);

    available = theAvailable == null ? new HashMap<String, Double>() : theAvailable;
    locked = theLocked == null ? new HashMap<String, Double>() : theLocked;
  }

  public Map<String, Double> getAvailableFunds() {

    return available;
  }

  public Map<String, Double> getLockedFunds() {

    return locked;
  }

  @Override
  public String toString() {

    return "BTERAccountInfoReturn [availableFunds=" + available + ", lockedFunds=" + locked + "]";
  }
}
