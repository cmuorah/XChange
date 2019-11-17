package org.knowm.xchange.bitflyer.dto.marketdata;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

public class BitflyerTickerJSONTest {
  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        BitflyerTicker.class.getResourceAsStream(
            "/org/knowm/xchange/bitflyer/dto/marketdata/example-ticker.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    BitflyerTicker response = mapper.readValue(is, BitflyerTicker.class);

    // then
    assertThat(response.getProductCode()).isEqualTo("BTC_JPY");
    assertThat(response.getTickId()).isEqualTo(1869654);
    assertThat(response.getBestAsk()).isEqualTo(new Double(2006000));
    assertThat(response.getBestBid()).isEqualTo(new Double(2004607));
    assertThat(response.getLtp()).isEqualTo(new Double(2004925));
    assertThat(response.getVolume()).isEqualTo(new Double("164237.72426007"));
    assertThat(response.getVolumeByProduct()).isEqualTo(new Double("26644.22985322"));
  }
}
