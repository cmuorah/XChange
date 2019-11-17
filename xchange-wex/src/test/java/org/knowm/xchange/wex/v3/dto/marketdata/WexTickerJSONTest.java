package org.knowm.xchange.wex.v3.dto.marketdata;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import org.junit.Test;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.utils.DateUtils;
import org.knowm.xchange.wex.v3.WexAdapters;

/** Test WexTicker JSON parsing */
public class WexTickerJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        WexTickerJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/wex/v3/marketdata/example-ticker-data.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    WexTickerWrapper bTCETickerWrapper = mapper.readValue(is, WexTickerWrapper.class);

    // Verify that the example data was unmarshalled correctly
    assertThat(bTCETickerWrapper.getTicker(WexAdapters.getPair(CurrencyPair.BTC_USD)).getLast())
        .isEqualTo(new Double("757"));
    assertThat(bTCETickerWrapper.getTicker(WexAdapters.getPair(CurrencyPair.BTC_USD)).getHigh())
        .isEqualTo(new Double("770"));
    assertThat(bTCETickerWrapper.getTicker(WexAdapters.getPair(CurrencyPair.BTC_USD)).getLow())
        .isEqualTo(new Double("655"));
    assertThat(bTCETickerWrapper.getTicker(WexAdapters.getPair(CurrencyPair.BTC_USD)).getVol())
        .isEqualTo(new Double("17512163.25736"));

    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    f.setTimeZone(TimeZone.getTimeZone("UTC"));
    String dateString =
        f.format(
            DateUtils.fromMillisUtc(
                bTCETickerWrapper.getTicker(WexAdapters.getPair(CurrencyPair.BTC_USD)).getUpdated()
                    * 1000L));
    System.out.println(dateString);
    assertThat(dateString).isEqualTo("2013-11-23 11:13:39");
  }
}
