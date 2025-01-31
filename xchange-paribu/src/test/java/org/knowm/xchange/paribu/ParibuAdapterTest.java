package org.knowm.xchange.paribu;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.paribu.dto.marketdata.ParibuTicker;

/** @author semihunaldi */
public class ParibuAdapterTest {

  @Test
  public void testTickerAdapter() throws IOException {
    // Read in the JSON from the example resources
    InputStream is =
        ParibuAdapterTest.class.getResourceAsStream(
            "/org/knowm/xchange/paribu/dto/marketdata/example-ticker-data.json");
    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    ParibuTicker paribuTicker = mapper.readValue(is, ParibuTicker.class);

    Ticker ticker = ParibuAdapters.adaptTicker(paribuTicker, new CurrencyPair("BTC", "TRY"));
    assertThat(ticker).isNotNull();
    assertThat(ticker.getLast()).isEqualTo(new Double("41400"));
    assertThat(ticker.getAsk()).isEqualTo(new Double("41450.89"));
    assertThat(ticker.getBid()).isEqualTo(new Double("41400"));
    assertThat(ticker.getVolume()).isEqualTo(new Double("2370.89"));
    assertThat(ticker.getHigh()).isEqualTo(new Double("42000"));
    assertThat(ticker.getLow()).isEqualTo(new Double("37650"));
  }
}
