package org.knowm.xchange.examples.dsx.account;

import java.io.IOException;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.dsx.DSXExchangeV3;
import org.knowm.xchange.dsx.dto.account.DSXAccountInfo;
import org.knowm.xchange.dsx.service.DSXAccountService;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.examples.dsx.DSXExamplesUtils;
import org.knowm.xchange.service.account.AccountService;

/** @author Pavel Chertalev */
public class DSXAccountInfoDemoV3 {

  public static void main(String[] args) throws IOException {

    Exchange dsx = DSXExamplesUtils.createExchange(DSXExchangeV3.class);
    generic(dsx);
    //    raw(dsx);
    //    generice(dsx);
  }

  private static void generic(Exchange exchange) throws IOException {

    AccountService accountService = exchange.getAccountService();

    AccountInfo accountInfo = accountService.getAccountInfo();
    System.out.println("DSX AccountInfo as String: " + accountInfo.toString());
  }

  private static void raw(Exchange exchange) throws IOException {

    DSXAccountService accountService = (DSXAccountService) exchange.getAccountService();

    DSXAccountInfo accountInfo = accountService.getDSXAccountInfo();
    System.out.println("DSX Wallet as String: " + accountInfo.toString());
  }

  private static void generice(Exchange exchange) throws IOException {

    AccountService accountService = exchange.getAccountService();

    String transaction = accountService.withdrawFunds(Currency.BTC, new Double("0.00001"), "XXX");
    System.out.println(transaction);
  }
}
