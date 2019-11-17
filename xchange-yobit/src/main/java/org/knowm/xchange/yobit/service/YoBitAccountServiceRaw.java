package org.knowm.xchange.yobit.service;

import java.io.IOException;
import java.util.*;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.service.account.AccountService;
import org.knowm.xchange.service.trade.params.DefaultWithdrawFundsParams;
import org.knowm.xchange.yobit.YoBit;
import org.knowm.xchange.yobit.YoBitAdapters;
import org.knowm.xchange.yobit.YoBitExchange;
import org.knowm.xchange.yobit.dto.BaseYoBitResponse;

public abstract class YoBitAccountServiceRaw extends YoBitBaseService<YoBit>
    implements AccountService {

  public YoBitAccountServiceRaw(YoBitExchange exchange) {
    super(YoBit.class, exchange);
  }

  public AccountInfo getInfo() throws IOException {
    BaseYoBitResponse response =
        service.getInfo(
            exchange.getExchangeSpecification().getApiKey(),
            signatureCreator,
            "getInfo",
            exchange.getNonceFactory());

    if (!response.success) throw new ExchangeException("failed to get account info");

    Map walletData = response.returnData;

    Map funds = (Map) walletData.get("funds");
    if (funds == null) funds = new HashMap();

    Map fundsIncludingOrders = (Map) walletData.get("funds_incl_orders");
    if (fundsIncludingOrders == null) fundsIncludingOrders = new HashMap();

    Collection<Wallet> wallets = new ArrayList<>();

    for (Object key : funds.keySet()) {
      Currency currency = YoBitAdapters.adaptCurrency(key.toString());

      Double amountAvailable = new Double(funds.get(key).toString());
      Double amountIncludingOrders = new Double(fundsIncludingOrders.get(key).toString());

      Balance balance =
          new Balance(
              currency,
              amountIncludingOrders,
              amountAvailable,
              amountIncludingOrders - (amountAvailable),
              0d,
              0d,
              0d,
              0d);

      wallets.add(
          Wallet.Builder.from(Collections.singletonList(balance))
              .id(currency.getCurrencyCode())
              .build());
    }

    return new AccountInfo(wallets);
  }

  public BaseYoBitResponse withdrawCoinsToAddress(DefaultWithdrawFundsParams params)
      throws IOException {
    DefaultWithdrawFundsParams defaultWithdrawFundsParams = params;

    BaseYoBitResponse response =
        service.withdrawCoinsToAddress(
            exchange.getExchangeSpecification().getApiKey(),
            signatureCreator,
            "WithdrawCoinsToAddress",
            exchange.getNonceFactory(),
            defaultWithdrawFundsParams.getCurrency().getCurrencyCode(),
            defaultWithdrawFundsParams.getAmount(),
            defaultWithdrawFundsParams.getAddress());

    if (!response.success) throw new ExchangeException("failed to withdraw funds");
    return response;
  }

  public BaseYoBitResponse getDepositAddress(Currency currency) throws IOException {
    boolean needNew = false; // todo: implement this option

    return service.getDepositAddress(
        exchange.getExchangeSpecification().getApiKey(),
        signatureCreator,
        "GetDepositAddress",
        exchange.getNonceFactory(),
        currency.getCurrencyCode(),
        needNew);
  }
}
