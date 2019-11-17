package org.knowm.xchange.bitcoincore.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import si.mazi.rescu.ExceptionalReturnContentException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BitcoinCoreBalanceResponse {

  private Double amount = 0d;

  public Double getAmount() {
    return amount;
  }

  public void setResult(Double value) {
    amount = value;
  }

  public void setError(String value) {
    if (value != null) {
      throw new ExceptionalReturnContentException(value);
    }
  }
}
