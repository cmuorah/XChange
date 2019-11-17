package org.knowm.xchange.coinfloor.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.coinfloor.CoinfloorExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class CoinfloorTickerIntegration {

  @Test
  public void fetchTickerTest() throws IOException {
    Exchange exchange = ExchangeFactory.INSTANCE.createExchange(CoinfloorExchange.class.getName());
    MarketDataService service = exchange.getMarketDataService();

    Ticker ticker = service.getTicker(CurrencyPair.BTC_GBP);
    assertThat(ticker.getCurrencyPair()).isEqualTo(CurrencyPair.BTC_GBP);
    assertThat(ticker.getLast()).isGreaterThan(0d);
    assertThat(ticker.getHigh()).isGreaterThan(0d);
    assertThat(ticker.getLow()).isGreaterThan(0d);
    assertThat(ticker.getVwap()).isGreaterThan(0d);
    assertThat(ticker.getVolume()).isGreaterThan(0d);
    assertThat(ticker.getBid()).isGreaterThan(0d);
    assertThat(ticker.getAsk()).isGreaterThan(0d);
  }
}
