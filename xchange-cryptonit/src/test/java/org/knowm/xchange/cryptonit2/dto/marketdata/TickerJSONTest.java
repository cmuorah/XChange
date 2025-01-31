package org.knowm.xchange.cryptonit2.dto.marketdata;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

/** Test CryptonitTicker JSON parsing */
public class TickerJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        TickerJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/cryptonit2/dto/marketdata/example-ticker-data.json");

    ObjectMapper mapper = new ObjectMapper();
    CryptonitTicker cryptonitTicker = mapper.readValue(is, CryptonitTicker.class);

    // Verify that the example data was unmarshalled correctly
    assertThat(cryptonitTicker.getLast()).isEqualTo(new Double("134.89"));
    assertThat(cryptonitTicker.getHigh()).isEqualTo(new Double("138.22"));
    assertThat(cryptonitTicker.getLow()).isEqualTo(new Double("131.79"));
    assertThat(cryptonitTicker.getVwap()).isEqualTo(new Double("135.31"));
    assertThat(cryptonitTicker.getVolume()).isEqualTo(new Double("21982.44926674"));
    assertThat(cryptonitTicker.getBid()).isEqualTo(new Double("134.89"));
    assertThat(cryptonitTicker.getAsk()).isEqualTo(new Double("134.92"));
    assertThat(cryptonitTicker.getTimestamp()).isEqualTo(1381787133L);
  }
}
