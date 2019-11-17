package org.knowm.xchange.poloniex.dto.trade;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapLikeType;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class PoloniexTradableBalanceTest {
  @Test
  public void testUnmarshal() throws IOException {
    // Read in the JSON from the example resources
    InputStream is =
        PoloniexAccountBalanceTest.class.getResourceAsStream(
            "/org/knowm/xchange/poloniex/dto/trade/trade-tradable-balances.json");
    ObjectMapper mapper = new ObjectMapper();
    JavaType stringType = mapper.getTypeFactory().constructType(String.class, String.class);
    MapLikeType mapType =
        mapper.getTypeFactory().constructMapLikeType(HashMap.class, String.class, Double.class);
    MapLikeType mapType2 =
        mapper.getTypeFactory().constructMapLikeType(HashMap.class, stringType, mapType);
    Map<String, Map<String, Double>> balances = mapper.readValue(is, mapType2);

    assertThat(balances.size()).isEqualTo(3);
    Map<String, Double> btc_dash = balances.get("BTC_DASH");
    assertThat(btc_dash.size()).isEqualTo(2);
    assertThat(btc_dash.get("BTC")).isEqualTo(new Double("8.50274777"));
    assertThat(btc_dash.get("DASH")).isEqualTo(new Double("654.05752077"));

    Map<String, Double> btc_ltc = balances.get("BTC_LTC");
    assertThat(btc_ltc.size()).isEqualTo(2);
    assertThat(btc_ltc.get("BTC")).isEqualTo(new Double("8.50274777"));
    assertThat(btc_ltc.get("LTC")).isEqualTo(new Double("1214.67825290"));

    Map<String, Double> btc_xmr = balances.get("BTC_XMR");
    assertThat(btc_xmr.size()).isEqualTo(2);
    assertThat(btc_xmr.get("BTC")).isEqualTo(new Double("8.50274777"));
    assertThat(btc_xmr.get("XMR")).isEqualTo(new Double("3696.84685650"));
  }
}
