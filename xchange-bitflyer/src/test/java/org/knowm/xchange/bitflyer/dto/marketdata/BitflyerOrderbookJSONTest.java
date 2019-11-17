package org.knowm.xchange.bitflyer.dto.marketdata;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

public class BitflyerOrderbookJSONTest {
  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        BitflyerTicker.class.getResourceAsStream(
            "/org/knowm/xchange/bitflyer/dto/marketdata/example-orderbook.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    BitflyerOrderbook response = mapper.readValue(is, BitflyerOrderbook.class);

    // then
    assertThat(response.getMidPrice()).isEqualTo(new Double(33320));

    assertThat(response.getBids().get(0).getPrice()).isEqualTo(new Double(30000));
    assertThat(response.getBids().get(0).getSize()).isEqualTo(new Double("0.1"));
    assertThat(response.getBids().get(1).getPrice()).isEqualTo(new Double(25570));
    assertThat(response.getBids().get(1).getSize()).isEqualTo(new Double(3));

    assertThat(response.getAsks().get(0).getPrice()).isEqualTo(new Double(36640));
    assertThat(response.getAsks().get(0).getSize()).isEqualTo(new Double(5));
    assertThat(response.getAsks().get(1).getPrice()).isEqualTo(new Double(36700));
    assertThat(response.getAsks().get(1).getSize()).isEqualTo(new Double("1.2"));
  }
}
