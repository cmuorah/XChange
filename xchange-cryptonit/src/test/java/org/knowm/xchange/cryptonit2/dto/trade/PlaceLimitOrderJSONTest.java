package org.knowm.xchange.cryptonit2.dto.trade;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

/** Test Transaction[] JSON parsing */
public class PlaceLimitOrderJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        PlaceLimitOrderJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/cryptonit2/dto/trade/example-place-limit-order.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    CryptonitOrder newOrder = mapper.readValue(is, CryptonitOrder.class);

    assertThat(newOrder.getId()).isEqualTo(1273070);
    assertThat(newOrder.getAmount()).isEqualTo(1d);
    assertThat(newOrder.getPrice()).isEqualTo(new Double("1.25"));
    assertThat(newOrder.getType()).isEqualTo(0);
  }

  @Test
  public void testError() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        PlaceLimitOrderJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/cryptonit2/dto/trade/example-place-limit-order-error.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    CryptonitOrder response = mapper.readValue(is, CryptonitOrder.class);

    assertThat(response.getErrorMessage()).isEqualTo("Minimum order size is $1");
  }
}
