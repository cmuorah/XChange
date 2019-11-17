package org.knowm.xchange.simulated;

import static org.knowm.xchange.currency.CurrencyPair.BTC_USD;
import static org.knowm.xchange.dto.Order.OrderType.ASK;
import static org.knowm.xchange.dto.Order.OrderType.BID;

import java.io.IOException;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.trade.LimitOrder;

class MockMarket {

  static void mockMarket(SimulatedExchange exchange) throws IOException {
    placeMMOrder(exchange, ASK, new Double(10000), new Double("200"));
    placeMMOrder(exchange, ASK, new Double(100), new Double("0.1"));
    placeMMOrder(exchange, ASK, new Double(99), new Double("0.05"));
    placeMMOrder(exchange, ASK, new Double(99), new Double("0.25"));
    placeMMOrder(exchange, ASK, new Double(98), new Double("0.3"));
    // ----
    placeMMOrder(exchange, BID, new Double(97), new Double("0.4"));
    placeMMOrder(exchange, BID, new Double(96), new Double("0.25"));
    placeMMOrder(exchange, BID, new Double(96), new Double("0.25"));
    placeMMOrder(exchange, BID, new Double(95), new Double("0.6"));
    placeMMOrder(exchange, BID, new Double(94), new Double("0.7"));
    placeMMOrder(exchange, BID, new Double(93), new Double("0.8"));
    placeMMOrder(exchange, BID, new Double(1), new Double("1002"));
  }

  static void placeMMOrder(
      SimulatedExchange exchange, OrderType orderType, Double price, Double amount)
      throws IOException {
    exchange
        .getTradeService()
        .placeLimitOrderUnrestricted(
            new LimitOrder.Builder(orderType, BTC_USD)
                .limitPrice(price)
                .originalAmount(amount)
                .build());
  }
}
