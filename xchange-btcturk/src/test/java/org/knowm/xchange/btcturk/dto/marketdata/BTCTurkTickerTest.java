package org.knowm.xchange.btcturk.dto.marketdata;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;

/**
 * @author semihunaldi Created on 26/11/2017
 * @author mertguner updated on 06.01.2019
 */
public class BTCTurkTickerTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        BTCTurkTickerTest.class.getResourceAsStream(
            "/org/knowm/xchange/btcturk/dto/marketdata/example-ticker-data.json");
    ObjectMapper mapper = new ObjectMapper();
    BTCTurkTicker btcTurkTicker = mapper.readValue(is, BTCTurkTicker.class);

    // Verify that the example data was unmarshalled correctly
    assertThat(btcTurkTicker.getPair()).isEqualTo(CurrencyPair.BTC_TRY);
    assertThat(btcTurkTicker.getHigh()).isEqualTo(new Double("20735"));
    assertThat(btcTurkTicker.getLast()).isEqualTo(new Double("20527"));
    assertThat(btcTurkTicker.getTimestamp()).isEqualTo(1546770924L);
    assertThat(btcTurkTicker.getBid()).isEqualTo(new Double("20547"));
    assertThat(btcTurkTicker.getVolume()).isEqualTo(new Double("121.43"));
    assertThat(btcTurkTicker.getLow()).isEqualTo(new Double("20416"));
    assertThat(btcTurkTicker.getAsk()).isEqualTo(new Double("20599"));
    assertThat(btcTurkTicker.getOpen()).isEqualTo(new Double("20526"));
    assertThat(btcTurkTicker.getAverage()).isEqualTo(new Double("20579.48"));
    assertThat(btcTurkTicker.getDaily()).isEqualTo(new Double("73"));
    assertThat(btcTurkTicker.getDailyPercent()).isEqualTo(new Double("0.36"));
    assertThat(btcTurkTicker.getDenominatorsymbol()).isEqualTo(Currency.TRY);
    assertThat(btcTurkTicker.getNumeratorsymbol()).isEqualTo(Currency.BTC);
  }
}
