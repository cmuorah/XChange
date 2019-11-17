package org.knowm.xchange.bitflyer.dto.account;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

public class BitflyerMarginTransactionJSONTest {
  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        BitflyerMarginTransaction.class.getResourceAsStream(
            "/org/knowm/xchange/bitflyer/dto/account/example-margin-history.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    BitflyerMarginTransaction[] response = mapper.readValue(is, BitflyerMarginTransaction[].class);

    // then
    assertThat(response.length).isEqualTo(3);

    assertThat(response[0].getAmount()).isEqualTo(new Double(-6));
    assertThat(response[0].getCurrencyCode()).isEqualTo("JPY");
    assertThat(response[0].getChange()).isEqualTo(new Double(-6));
    assertThat(response[0].getId()).isEqualTo(4995);
    assertThat(response[0].getReasonCode()).isEqualTo("CLEARING_COLL");

    assertThat(response[1].getAmount()).isEqualTo(0d);
    assertThat(response[1].getCurrencyCode()).isEqualTo("JPY");
    assertThat(response[1].getChange()).isEqualTo(new Double(2083698));
    assertThat(response[1].getId()).isEqualTo(4994);
    assertThat(response[1].getReasonCode()).isEqualTo("EXCHANGE_COLL");
  }
}
