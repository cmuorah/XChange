package org.knowm.xchange.bitstamp.dto.account;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.knowm.xchange.bitstamp.dto.account.BitstampBalance.Balance;

/** Test BitStamp Full Depth JSON parsing */
public class WalletJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        WalletJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/bitstamp/dto/account/example-accountinfo-data.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    BitstampBalance bitstampBalance = mapper.readValue(is, BitstampBalance.class);

    Map<String, Balance> balances = new HashMap<>();
    for (Balance b : bitstampBalance.getBalances()) {
      balances.put(b.getCurrency(), b);
    }

    // Verify that the example data was unmarshalled correctly
    assertThat(balances.get("btc").getAvailable()).isEqualTo(new Double("6.99990000"));
    assertThat(balances.get("btc").getReserved()).isEqualTo(new Double("0"));
    assertThat(balances.get("btc").getBalance()).isEqualTo(new Double("6.99990000"));
    assertThat(balances.get("usd").getAvailable()).isEqualTo(new Double("0.00"));
    assertThat(balances.get("usd").getBalance()).isEqualTo(new Double("172.87"));
    assertThat(balances.get("usd").getReserved()).isEqualTo(new Double("172.87"));
    assertThat(bitstampBalance.getFee()).isEqualTo(new Double("0.5000"));
  }
}
