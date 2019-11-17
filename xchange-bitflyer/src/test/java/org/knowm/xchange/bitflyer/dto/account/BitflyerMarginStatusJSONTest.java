package org.knowm.xchange.bitflyer.dto.account;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

public class BitflyerMarginStatusJSONTest {
  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        BitflyerMarginStatus.class.getResourceAsStream(
            "/org/knowm/xchange/bitflyer/dto/account/example-margin-status.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    BitflyerMarginStatus response = mapper.readValue(is, BitflyerMarginStatus.class);

    // then
    assertThat(response.getCollateral()).isEqualTo(new Double(100000));
    assertThat(response.getKeepRate()).isEqualTo(5.000);
    assertThat(response.getOpenPositionPnl()).isEqualTo(new Double(-715));
    assertThat(response.getRequireCollateral()).isEqualTo(new Double(19857));
  }
}
