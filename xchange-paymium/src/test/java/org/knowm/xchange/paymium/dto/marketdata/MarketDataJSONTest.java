package org.knowm.xchange.paymium.dto.marketdata;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

public class MarketDataJSONTest {

  @Test
  public void testPaymiumTickerRequest()
      throws JsonParseException, JsonMappingException, IOException {

    // Read in the JSON from the example resources
    InputStream is =
        MarketDataJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/paymium/dto/marketdata/Example_TickerData.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    PaymiumTicker PaymiumTicker = mapper.readValue(is, PaymiumTicker.class);

    assertEquals(PaymiumTicker.getCurrency(), "EUR");
    assertEquals(PaymiumTicker.getAsk(), new Double("20.4"));
    assertEquals(PaymiumTicker.getBid(), new Double("20.1"));
    assertEquals(PaymiumTicker.getHigh(), new Double("20.74"));
    assertEquals(PaymiumTicker.getLow(), new Double("20.2"));
    assertEquals(PaymiumTicker.getPrice(), new Double("20.2"));
    assertEquals(PaymiumTicker.getVolume(), new Double("148.80193218"));
  }

  @Test
  public void testPaymiumDepthRequest()
      throws JsonParseException, JsonMappingException, IOException {

    // Read in the JSON from the example resources
    InputStream is =
        MarketDataJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/paymium/dto/marketdata/Example_DepthData.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    PaymiumMarketDepth PaymiumMarketDepth = mapper.readValue(is, PaymiumMarketDepth.class);

    assertEquals(PaymiumMarketDepth.getAsks().get(0).getAmount(), new Double("0.48762"));
    assertEquals(PaymiumMarketDepth.getAsks().get(0).getPrice(), new Double("24.48996"));
    assertEquals(PaymiumMarketDepth.getBids().get(0).getAmount(), new Double("0.77372456"));
    assertEquals(PaymiumMarketDepth.getBids().get(0).getPrice(), new Double("24.05"));
  }

  @Test
  public void testPaymiumTradesRequest()
      throws JsonParseException, JsonMappingException, IOException {

    // Read in the JSON from the example resources
    InputStream is =
        MarketDataJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/paymium/dto/marketdata/Example_TradesData.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    PaymiumTrade[] PaymiumTrades = mapper.readValue(is, PaymiumTrade[].class);

    assertEquals(PaymiumTrades[0].getPrice(), new Double("5.0"));
    assertEquals(PaymiumTrades[0].getTraded_btc(), new Double("980.0"));
    assertEquals(PaymiumTrades[0].getTraded_currency(), new Double("4940.0"));
  }
}
