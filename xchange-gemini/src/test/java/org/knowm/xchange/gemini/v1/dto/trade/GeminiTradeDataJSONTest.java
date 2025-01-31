package org.knowm.xchange.gemini.v1.dto.trade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

public class GeminiTradeDataJSONTest {

  /**
   * This test will currently fail since the JSON field "order_id" cannot be matched to a field in
   * GeminiOrderStatusResponse.
   *
   * @throws IOException
   */
  @Test
  public void testPlaceOrder() throws IOException {

    InputStream resourceAsStream =
        GeminiTradeDataJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/gemini/v1/trade/example-place-order-data.json");
    GeminiOrderStatusResponse response =
        new ObjectMapper().readValue(resourceAsStream, GeminiOrderStatusResponse.class);

    assertEquals(4003264, response.getId());
    assertEquals("btcusd", response.getSymbol());
    assertEquals(new Double("900.0"), response.getPrice());
    assertEquals(new Double("0.0"), response.getAvgExecutionPrice());
    assertEquals("sell", response.getSide());
    assertEquals("exchange limit", response.getType());
    assertEquals("1387061558.610016778", response.getTimestamp());
    assertTrue(response.isLive());
    assertFalse(response.isCancelled());
    assertFalse(response.getWasForced());
    assertEquals(new Double("0.01"), response.getOriginalAmount());
    assertEquals(new Double("0.01"), response.getRemainingAmount());
    assertEquals(new Double("0.0"), response.getExecutedAmount());
  }

  @Test
  public void testCancelOrder() throws IOException {

    InputStream resourceAsStream =
        GeminiTradeDataJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/gemini/v1/trade/example-cancel-order-data.json");
    GeminiOrderStatusResponse response =
        new ObjectMapper().readValue(resourceAsStream, GeminiOrderStatusResponse.class);

    assertEquals(4003242, response.getId());
    assertEquals("btcusd", response.getSymbol());
    assertEquals(new Double("900.0"), response.getPrice());
    assertEquals(new Double("0.0"), response.getAvgExecutionPrice());
    assertEquals("sell", response.getSide());
    assertEquals("exchange limit", response.getType());
    assertEquals("1387061342.0", response.getTimestamp());
    assertFalse(response.isLive());
    assertTrue(response.isCancelled());
    assertFalse(response.getWasForced());
    assertEquals(new Double("0.01"), response.getOriginalAmount());
    assertEquals(new Double("0.01"), response.getRemainingAmount());
    assertEquals(new Double("0.0"), response.getExecutedAmount());
  }

  @Test
  public void testOpenOrders() throws IOException {

    InputStream resourceAsStream =
        GeminiTradeDataJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/gemini/v1/trade/example-open-orders-data.json");
    GeminiOrderStatusResponse response =
        new ObjectMapper().readValue(resourceAsStream, GeminiOrderStatusResponse.class);

    assertEquals(4003242, response.getId());
    assertEquals("btcusd", response.getSymbol());
    assertEquals(new Double("900.0"), response.getPrice());
    assertEquals(new Double("0.0"), response.getAvgExecutionPrice());
    assertEquals("sell", response.getSide());
    assertEquals("exchange limit", response.getType());
    assertEquals("1387061342.0", response.getTimestamp());
    assertTrue(response.isLive());
    assertFalse(response.isCancelled());
    assertFalse(response.getWasForced());
    assertEquals(new Double("0.08"), response.getOriginalAmount());
    assertEquals(new Double("0.06"), response.getRemainingAmount());
    assertEquals(new Double("0.02"), response.getExecutedAmount());
  }

  @Test
  public void testPastTrades() throws IOException {

    InputStream resourceAsStream =
        GeminiTradeDataJSONTest.class.getResourceAsStream(
            "/org/knowm/xchange/gemini/v1/trade/example-past-trades-data.json");
    GeminiTradeResponse[] responses =
        new ObjectMapper().readValue(resourceAsStream, GeminiTradeResponse[].class);

    assertEquals(new Double("854.01"), responses[0].getPrice());
    assertEquals(new Double("0.0072077"), responses[0].getAmount());
    assertEquals(new Double("1387057315.0"), responses[0].getTimestamp());
    assertEquals("Sell", responses[0].getType());

    assertEquals(new Double("857.92"), responses[1].getPrice());
    assertEquals(new Double("0.0027923"), responses[1].getAmount());
    assertEquals(new Double("1387057259.0"), responses[1].getTimestamp());
    assertEquals("Sell", responses[1].getType());
  }
}
