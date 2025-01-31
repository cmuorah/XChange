package org.knowm.xchange.koinim;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.koinim.dto.marketdata.KoinimTicker;

/** @author ahmetoz */
public class KoinimAdapterTest {

  @Test
  public void testTickerAdapter() throws IOException {
    // Read in the JSON from the example resources
    InputStream is =
        KoinimAdapterTest.class.getResourceAsStream(
            "/org/knowm/xchange/koinim/dto/marketdata/example-ticker-data.json");
    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    KoinimTicker koinimTicker = mapper.readValue(is, KoinimTicker.class);

    Ticker ticker = KoinimAdapters.adaptTicker(koinimTicker, new CurrencyPair("BTC", "TRY"));
    assertThat(ticker).isNotNull();
    assertThat(ticker.getLast()).isEqualTo(new Double("63500.02000000"));
    assertThat(ticker.getAsk()).isEqualTo(new Double("63500.02000000"));
    assertThat(ticker.getBid()).isEqualTo(new Double("63500.00000000"));
    assertThat(ticker.getVolume()).isEqualTo(new Double("421.24152018"));
    assertThat(ticker.getHigh()).isEqualTo(new Double("64980.00000000"));
    assertThat(ticker.getLow()).isEqualTo(new Double("50000.00000000"));
    assertThat(ticker.getVwap()).isEqualTo(new Double("58281.67839967173"));
  }
}
