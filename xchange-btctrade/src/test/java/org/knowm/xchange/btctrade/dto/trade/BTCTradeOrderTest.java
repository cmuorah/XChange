package org.knowm.xchange.btctrade.dto.trade;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.Test;

public class BTCTradeOrderTest {

  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  public void test() throws IOException {

    BTCTradeOrder order =
        mapper.readValue(getClass().getResource("fetch_order.json"), BTCTradeOrder.class);
    assertEquals("16622499", order.getId());
    assertEquals("2014-09-14 11:08:31", order.getDatetime());
    assertEquals("sell", order.getType());
    assertEquals(new Double("2935.1"), order.getPrice());
    assertEquals(new Double("0.01"), order.getAmountOriginal());
    assertEquals(new Double("0"), order.getAmountOutstanding());
    assertEquals("closed", order.getStatus());

    BTCTradeTrade[] trades = order.getTrades();
    assertEquals(1, trades.length);

    assertEquals("3512013", trades[0].getTradeId());
    assertEquals(new Double("0.01"), trades[0].getAmount());
    assertEquals(new Double("2935.1"), trades[0].getPrice());
    assertEquals("2014-09-14 11:08:31", trades[0].getDatetime());
    assertEquals(new Double("0"), trades[0].getFee());
  }
}
