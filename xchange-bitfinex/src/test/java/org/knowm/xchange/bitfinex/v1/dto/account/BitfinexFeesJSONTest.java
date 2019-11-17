package org.knowm.xchange.bitfinex.v1.dto.account;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

/** Test JSON parsing for Bitfinex fees response */
public class BitfinexFeesJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        BitfinexFeesJSONTest.class.getResourceAsStream(
            "/v1/account/example-account-info-fees.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    BitfinexTradingFeeResponse[] readValues =
        mapper.readValue(is, BitfinexTradingFeeResponse[].class);
    assertEquals(2, readValues.length);
    BitfinexTradingFeeResponse readValue = readValues[0];
    BitfinexTradingFeeResponse.BitfinexTradingFeeResponseRow[] responseRows =
        readValue.getTradingFees();
    Double point1 = 10d / (100d);
    Double point2 = point1 * (2d);
    assertEquals(3, responseRows.length);
    assertEquals("BTC", responseRows[0].getCurrency());
    assertEquals("LTC", responseRows[1].getCurrency());
    assertEquals("ETH", responseRows[2].getCurrency());
    for (BitfinexTradingFeeResponse.BitfinexTradingFeeResponseRow responseRow : responseRows) {
      assertEquals(point1, responseRow.getMakerFee());
      assertEquals(point2, responseRow.getTakerFee());
    }

    readValue = readValues[1];
    responseRows = readValue.getTradingFees();
    Double point025 = 0.025;
    Double point01 = 0.01;
    assertEquals(1, responseRows.length);
    assertEquals("DGC", responseRows[0].getCurrency());
    assertEquals(point025, responseRows[0].getMakerFee());
    assertEquals(point01, responseRows[0].getTakerFee());
  }
}
