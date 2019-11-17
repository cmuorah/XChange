package org.knowm.xchange.service.trade.params;

import javax.annotation.Nullable;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.AddressWithTag;

public class DefaultWithdrawFundsParams implements WithdrawFundsParams {
  public final String address;

  private final String destinationTag;

  public final Currency currency;

  public final Double amount;

  @Nullable public final Double commission;

  public DefaultWithdrawFundsParams(String address, Currency currency, Double amount) {
    this(address, currency, amount, null);
  }

  public DefaultWithdrawFundsParams(AddressWithTag address, Currency currency, Double amount) {
    this(address, currency, amount, null);
  }

  public DefaultWithdrawFundsParams(
      String address, Currency currency, Double amount, Double commission) {
    this.address = address;
    this.destinationTag = null;
    this.currency = currency;
    this.amount = amount;
    this.commission = commission;
  }

  public DefaultWithdrawFundsParams(
      AddressWithTag address, Currency currency, Double amount, Double commission) {
    this.address = address.getAddress();
    this.destinationTag = address.getDestinationTag();
    this.currency = currency;
    this.amount = amount;
    this.commission = commission;
  }

  public String getAddress() {
    return address;
  }

  public String getDestinationTag() {
    return destinationTag;
  }

  public Currency getCurrency() {
    return currency;
  }

  public Double getAmount() {
    return amount;
  }

  @Nullable
  public Double getCommission() {
    return commission;
  }

  @Override
  public String toString() {
    return "DefaultWithdrawFundsParams{"
        + "address='"
        + getAddress()
        + ", destinationTag="
        + getDestinationTag()
        + '\''
        + ", currency="
        + getCurrency()
        + ", amount="
        + getAmount()
        + ", commission="
        + getCommission()
        + '}';
  }
}
