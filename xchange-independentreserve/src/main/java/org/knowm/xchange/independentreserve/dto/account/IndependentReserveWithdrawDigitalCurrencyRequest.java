package org.knowm.xchange.independentreserve.dto.account;

import org.knowm.xchange.independentreserve.dto.auth.AuthAggregate;

public class IndependentReserveWithdrawDigitalCurrencyRequest extends AuthAggregate {

  public IndependentReserveWithdrawDigitalCurrencyRequest(
      String apiKey,
      Long nonce,
      Double amount,
      String withdrawalAddress,
      String comment,
      String primaryCurrencyCode,
      String destinationTag) {
    super(apiKey, nonce);
    this.parameters.put("amount", amount);
    this.parameters.put("withdrawalAddress", withdrawalAddress);
    this.parameters.put("comment", comment);
    this.parameters.put("primaryCurrencyCode", primaryCurrencyCode);
    if (destinationTag != null) {
      this.parameters.put("destinationTag", destinationTag);
    }
  }
}
