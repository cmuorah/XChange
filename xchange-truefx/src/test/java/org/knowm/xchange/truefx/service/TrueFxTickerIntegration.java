package org.knowm.xchange.truefx.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.knowm.xchange.truefx.TrueFxExchange;

public class TrueFxTickerIntegration {

  @Test
  public void fetchTickerTest() throws IOException {
    Exchange exchange = ExchangeFactory.INSTANCE.createExchange(TrueFxExchange.class.getName());
    MarketDataService service = exchange.getMarketDataService();

    Ticker ticker = service.getTicker(CurrencyPair.GBP_USD);
    assertThat(ticker.getCurrencyPair()).isEqualTo(CurrencyPair.GBP_USD);

    assertThat(ticker.getBid()).isGreaterThan(0d);
    assertThat(ticker.getHigh()).isGreaterThan(0d);
    assertThat(ticker.getAsk()).isGreaterThan(0d);
    assertThat(ticker.getLow()).isGreaterThan(0d);

    assertThat(ticker.getLast()).isNull();
    assertThat(ticker.getVwap()).isNull();
    assertThat(ticker.getVolume()).isNull();
  }
}
