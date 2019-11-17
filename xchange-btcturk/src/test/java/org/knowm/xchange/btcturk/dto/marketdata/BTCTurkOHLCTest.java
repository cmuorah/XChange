package org.knowm.xchange.btcturk.dto.marketdata;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;
import org.knowm.xchange.utils.DateUtils;

/**
 * Created by semihunaldi on 26/11/2017
 *
 * @author mertguner Updated 14.01.2019 for new OHCL values
 */
public class BTCTurkOHLCTest {
  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        BTCTurkTickerTest.class.getResourceAsStream(
            "/org/knowm/xchange/btcturk/dto/marketdata/example-ohlc-data.json");
    ObjectMapper mapper = new ObjectMapper();
    BTCTurkOHLC[] btcTurkOHLCs = mapper.readValue(is, BTCTurkOHLC[].class);

    // Verify that the example data was unmarshalled correctly
    assertThat(btcTurkOHLCs.length).isEqualTo(2);
    assertThat(DateUtils.toUTCString(btcTurkOHLCs[0].getTime()))
        .isEqualTo("2019-01-14 00:00:00 GMT");
    assertThat(btcTurkOHLCs[0].getOpen()).isEqualTo(new Double("640"));
    assertThat(btcTurkOHLCs[0].getHigh()).isEqualTo(new Double("731"));
    assertThat(btcTurkOHLCs[0].getLow()).isEqualTo(new Double("637"));
    assertThat(btcTurkOHLCs[0].getClose()).isEqualTo(new Double("709"));
    assertThat(btcTurkOHLCs[0].getVolume()).isEqualTo(new Double("9037.28969659"));
    assertThat(btcTurkOHLCs[0].getAverage()).isEqualTo(new Double("682.57"));
    assertThat(btcTurkOHLCs[0].getDailyChangeAmount()).isEqualTo(new Double("10.78"));
    assertThat(btcTurkOHLCs[0].getDailyChangePercentage()).isEqualTo(new Double("69"));
  }
}
