package org.knowm.xchange.bitmex.dto.account;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

/** Test BitstampTicker JSON parsing */
public class BitmexMarginAccountJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        BitmexMarginAccountJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/bitmex/dto/account/example-margin-account.json");

    ObjectMapper mapper = new ObjectMapper();
    BitmexMarginAccount bitmexMarginAccount = mapper.readValue(is, BitmexMarginAccount.class);

    // Verify that the example data was unmarshalled correctly
    assertThat(bitmexMarginAccount.getAccount()).isEqualTo(0);
    assertThat(bitmexMarginAccount.getCurrency()).isEqualTo("string");
    assertThat(bitmexMarginAccount.getAmount()).isEqualTo(0d);
    assertThat(bitmexMarginAccount.getAvailableMargin()).isEqualTo(0d);
    assertThat(bitmexMarginAccount.getMaintMargin()).isEqualTo(0d);
    assertThat(bitmexMarginAccount.getMarginBalance()).isEqualTo(0d);
    assertThat(bitmexMarginAccount.getMarginLeverage()).isEqualTo(0d);
    assertThat(bitmexMarginAccount.getTaxableMargin()).isEqualTo(0d);
  }
}
