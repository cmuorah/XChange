package org.knowm.xchange.cryptonit2.dto.account;

import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.service.trade.params.DefaultWithdrawFundsParams;

public class CryptoWithdrawParams extends DefaultWithdrawFundsParams {

  public CryptoWithdrawParams(String address, Currency currency, Double amount) {
    super(address, currency, amount);
  }
}
