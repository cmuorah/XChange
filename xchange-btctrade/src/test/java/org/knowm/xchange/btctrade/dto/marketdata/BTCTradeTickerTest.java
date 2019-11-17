package org.knowm.xchange.btctrade.dto.marketdata;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.Test;

public class BTCTradeTickerTest {

  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  public void testBTCTradeTicker() throws IOException {

    BTCTradeTicker ticker =
        mapper.readValue(getClass().getResource("ticker.json"), BTCTradeTicker.class);
    assertEquals(new Double("3760"), ticker.getHigh());
    assertEquals(new Double("3658"), ticker.getLow());
    assertEquals(new Double("3752"), ticker.getBuy());
    assertEquals(new Double("3758"), ticker.getSell());
    assertEquals(new Double("3757"), ticker.getLast());
    assertEquals(new Double("11009.76"), ticker.getVol());
  }
}
