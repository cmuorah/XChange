package org.knowm.xchange.cryptofacilities.dto.marketdata;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import org.junit.Test;
import org.knowm.xchange.cryptofacilities.Util;

/** @author Neil Panchen */
public class CryptoFacilitiesTickersJSONTest {

  @Test
  public void testUnmarshal1() throws IOException, ParseException {

    // Read in the JSON from the example resources
    InputStream is =
        CryptoFacilitiesTickersJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/cryptofacilities/dto/marketdata/example-tickers-data.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    CryptoFacilitiesTickers cryptoFacilitiesTickers =
        mapper.readValue(is, CryptoFacilitiesTickers.class);

    // Verify that the example data was unmarshalled correctly for fwd contract
    assertThat(cryptoFacilitiesTickers.isSuccess()).isTrue();
    assertThat(cryptoFacilitiesTickers.getTicker("F-XBT:USD-Apr16-W5").getAskSize())
        .isEqualTo(new Double("2"));
    assertThat(cryptoFacilitiesTickers.getTicker("F-XBT:USD-Apr16-W5").getLast())
        .isEqualTo(new Double("424.85"));
    assertThat(cryptoFacilitiesTickers.getTicker("F-XBT:USD-Apr16-W5").getLow24H())
        .isEqualTo(new Double("422.9"));
    assertThat(cryptoFacilitiesTickers.getTicker("F-XBT:USD-Apr16-W5").getBidSize())
        .isEqualTo(new Double("2"));
    assertThat(cryptoFacilitiesTickers.getTicker("F-XBT:USD-Apr16-W5").getSuspended()).isFalse();
    assertThat(cryptoFacilitiesTickers.getTicker("F-XBT:USD-Apr16-W5").getOpen24H())
        .isEqualTo(new Double("422.9"));
    assertThat(cryptoFacilitiesTickers.getTicker("F-XBT:USD-Apr16-W5").getHigh24H())
        .isEqualTo(new Double("424.85"));
    assertThat(cryptoFacilitiesTickers.getTicker("F-XBT:USD-Apr16-W5").getMarkPrice())
        .isEqualTo(new Double("421.7"));
    assertThat(cryptoFacilitiesTickers.getTicker("F-XBT:USD-Apr16-W5").getAsk())
        .isEqualTo(new Double("427.81"));
    assertThat(cryptoFacilitiesTickers.getTicker("F-XBT:USD-Apr16-W5").getBid())
        .isEqualTo(new Double("426.75"));
    assertThat(cryptoFacilitiesTickers.getTicker("F-XBT:USD-Apr16-W5").getLastSize())
        .isEqualTo(new Double("4"));
    assertThat(cryptoFacilitiesTickers.getTicker("F-XBT:USD-Apr16-W5").getVol24H())
        .isEqualTo(new Double("5"));

    // 2016-04-04 18:19:56 UTC

    assertThat(cryptoFacilitiesTickers.getTicker("F-XBT:USD-Apr16-W5").getLastTime())
        .isEqualTo(Util.parseDate("2016-04-04T18:19:56.000Z"));

    // Verify that the example data was unmarshalled correctly for vol index contract
    assertThat(cryptoFacilitiesTickers.isSuccess()).isTrue();
    assertThat(cryptoFacilitiesTickers.getTicker("CF-Bpi-V").getLast())
        .isEqualTo(new Double("29.31"));

    // 2016-04-05 08:49:41.116 UTC
    assertThat(cryptoFacilitiesTickers.getTicker("CF-Bpi-V").getLastTime())
        .isEqualTo(Util.parseDate("2016-04-05T08:49:41.116Z"));
  }

  @Test
  public void testUnmarshal2() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        CryptoFacilitiesTickersJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/cryptofacilities/dto/marketdata/example-ticker-data-2.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    CryptoFacilitiesTickers cryptoFacilitiesTickers =
        mapper.readValue(is, CryptoFacilitiesTickers.class);

    // Verify that the example data was unmarshalled correctly
    assertThat(cryptoFacilitiesTickers.isSuccess()).isFalse();
    assertThat(cryptoFacilitiesTickers.getTicker("F-XBT:USD-Apr16-W5")).isNull();
  }
}
