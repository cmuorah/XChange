package org.knowm.xchange.dsx.dto.account;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

/**
 * Test DSXAccountInfo JSON parsing
 *
 * @author Mikhail Wall
 */
public class DSXAccountInfoJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    InputStream is =
        DSXAccountInfoJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/dsx/dto/account/example-account-info-data.json");

    ObjectMapper mapper = new ObjectMapper();
    DSXAccountInfoReturn ai = mapper.readValue(is, DSXAccountInfoReturn.class);

    assertThat(ai.getReturnValue().getRights().isInfo()).isTrue();
    assertThat(ai.getReturnValue().getFunds().get("BTC"))
        .isEqualToComparingFieldByField(new DSXCurrencyAmount(new Double("100"), new Double("95")));
    assertThat(ai.getReturnValue().getFunds().get("USD"))
        .isEqualToComparingFieldByField(
            new DSXCurrencyAmount(new Double("10000"), new Double("9995")));
  }
}
