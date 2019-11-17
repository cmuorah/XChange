package org.knowm.xchange.bitflyer.dto.trade;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

public class BitflyerPositionJSONTest {
  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        BitflyerExecution.class.getResourceAsStream(
            "/org/knowm/xchange/bitflyer/dto/trade/example-position.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    BitflyerPosition response = mapper.readValue(is, BitflyerPosition.class);

    // then

    assertThat(response.getProductCode()).isEqualTo("FX_BTC_JPY");
    assertThat(response.getSide()).isEqualTo("BUY");
    assertThat(response.getPrice()).isEqualTo(new Double(36000));
    assertThat(response.getSize()).isEqualTo(new Double(10));
    assertThat(response.getCommission()).isEqualTo(new Double(0));
    assertThat(response.getSwapPointAccumulate()).isEqualTo(new Double(-35));
    assertThat(response.getRequireCollateral()).isEqualTo(new Double(120000));
    assertThat(response.getLeverage()).isEqualTo(new Double(3));
    assertThat(response.getPnl()).isEqualTo(new Double(965));
    assertThat(response.getOpenDate()).isEqualTo("2015-11-03T10:04:45.011");
  }
}
