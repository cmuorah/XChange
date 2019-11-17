package org.knowm.xchange.service.trade.params;

import javax.annotation.Nullable;
import org.knowm.xchange.currency.Currency;

public class MoneroWithdrawFundsParams extends DefaultWithdrawFundsParams {
  @Nullable public final String paymentId; // optional

  public MoneroWithdrawFundsParams(String address, Currency currency, Double amount) {
    this(address, currency, amount, null);
  }

  public MoneroWithdrawFundsParams(
      String address, Currency currency, Double amount, String paymentId) {
    super(address, currency, amount);
    this.paymentId = paymentId;
  }

  @Override
  public String toString() {
    return "MoneroWithdrawFundsParams{"
        + "address='"
        + getAddress()
        + '\''
        + ", paymentId='"
        + getPaymentId()
        + '\''
        + ", currency="
        + getCurrency()
        + ", amount="
        + getAmount()
        + ", commission="
        + getCommission()
        + '}';
  }

  @Nullable
  public String getPaymentId() {
    return paymentId;
  }
}
