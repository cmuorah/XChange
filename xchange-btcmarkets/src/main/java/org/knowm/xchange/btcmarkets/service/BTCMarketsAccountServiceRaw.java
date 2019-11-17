package org.knowm.xchange.btcmarkets.service;

import java.io.IOException;
import java.util.List;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.btcmarkets.BTCMarketsAuthenticated;
import org.knowm.xchange.btcmarkets.dto.account.BTCMarketsBalance;
import org.knowm.xchange.btcmarkets.dto.account.BTCMarketsFundtransferHistoryResponse;
import org.knowm.xchange.btcmarkets.dto.trade.BTCMarketsWithdrawCryptoRequest;
import org.knowm.xchange.btcmarkets.dto.trade.BTCMarketsWithdrawCryptoResponse;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.exceptions.ExchangeException;
import si.mazi.rescu.RestProxyFactory;
import si.mazi.rescu.SynchronizedValueFactory;

public class BTCMarketsAccountServiceRaw extends BTCMarketsBaseService {

  private static final Double AMOUNT_MULTIPLICAND = new Double("100000000");
  private static final int MAX_SCALE = 8;

  private final BTCMarketsDigest signer;
  private final BTCMarketsAuthenticated btcm;
  private final SynchronizedValueFactory<Long> nonceFactory;

  protected BTCMarketsAccountServiceRaw(Exchange exchange) {
    super(exchange);
    this.nonceFactory = exchange.getNonceFactory();
    this.btcm =
        RestProxyFactory.createProxy(
            BTCMarketsAuthenticated.class,
            exchange.getExchangeSpecification().getSslUri(),
            getClientConfig());
    this.signer = new BTCMarketsDigest(exchange.getExchangeSpecification().getSecretKey());
  }

  public List<BTCMarketsBalance> getBTCMarketsBalance() throws IOException {
    return btcm.getBalance(exchange.getExchangeSpecification().getApiKey(), nonceFactory, signer);
  }

  public String withdrawCrypto(String address, Double amount, Currency currency)
      throws IOException {
    long amountInSatoshis = Math.round(amount * AMOUNT_MULTIPLICAND);
    BTCMarketsWithdrawCryptoRequest request =
        new BTCMarketsWithdrawCryptoRequest(amountInSatoshis, address, currency.getCurrencyCode());
    BTCMarketsWithdrawCryptoResponse response =
        btcm.withdrawCrypto(
            exchange.getExchangeSpecification().getApiKey(), nonceFactory, signer, request);
    if (!response.getSuccess())
      throw new ExchangeException(
          "failed to withdraw funds: "
              + response.getErrorMessage()
              + " "
              + response.getErrorCode());

    return response.status;
  }

  public BTCMarketsFundtransferHistoryResponse fundtransferHistory() throws IOException {
    BTCMarketsFundtransferHistoryResponse response =
        btcm.fundtransferHistory(
            exchange.getExchangeSpecification().getApiKey(), nonceFactory, signer);

    if (!response.getSuccess()) {
      throw new ExchangeException(
          "failed to retrieve fundtransfer history: "
              + response.getErrorMessage()
              + " "
              + response.getErrorCode());
    }
    return response;
  }
}
