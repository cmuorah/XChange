package org.knowm.xchange.coinegg.dto.marketdata;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

public class CoinEggTickerJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        CoinEggTickerJSONTest.class.getResourceAsStream(
            "/org/xchange/coinegg/dto/marketdata/example-ticker-data.json");

    // Parse JSON Example Using Jackson
    ObjectMapper mapper = new ObjectMapper();
    CoinEggTicker coinEggTicker = mapper.readValue(is, CoinEggTicker.class);

    // Verify The Ticker Unmarshalls Correctly
    assertThat(coinEggTicker).isNotNull();

    assertThat(coinEggTicker.getHigh()).isEqualTo(new Double("22"));
    assertThat(coinEggTicker.getLow()).isEqualTo(new Double("20"));
    assertThat(coinEggTicker.getBuy()).isEqualTo(new Double("1.879"));
    assertThat(coinEggTicker.getSell()).isEqualTo(new Double("0"));
    assertThat(coinEggTicker.getLast()).isEqualTo(new Double("38800"));
    assertThat(coinEggTicker.getVolume()).isEqualTo(new Double("283.954"));
  }
}
