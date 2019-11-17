package org.knowm.xchange.bitcoinium.dto.marketdata;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

/** Test BitcoiniumTicker JSON parsing */
public class BitcoiniumTickerJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        BitcoiniumTickerJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/bitcoinium/dto/marketdata/example-ticker-data.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    BitcoiniumTicker bitcoiniumTicker = mapper.readValue(is, BitcoiniumTicker.class);

    // Verify that the example data was unmarshalled correctly
    assertThat(bitcoiniumTicker.getLast()).isEqualTo(new Double("516.8"));
    assertThat(bitcoiniumTicker.getHigh()).isEqualTo(new Double("523.09"));
    assertThat(bitcoiniumTicker.getLow()).isEqualTo(new Double("508.28"));
    assertThat(bitcoiniumTicker.getVolume()).isEqualTo(new Double("3522"));
  }
}
