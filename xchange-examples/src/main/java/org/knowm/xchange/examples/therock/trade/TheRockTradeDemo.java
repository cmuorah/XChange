package org.knowm.xchange.examples.therock.trade;

import java.io.IOException;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.examples.therock.TheRockExampleUtils;
import org.knowm.xchange.therock.service.TheRockTradeService;

public class TheRockTradeDemo {

  public static final CurrencyPair BTC_EUR = CurrencyPair.BTC_EUR;

  public static void main(String[] args) throws Exception {
    Exchange theRockExchange = TheRockExampleUtils.createTestExchange();
    generic(theRockExchange);
  }

  private static void generic(Exchange theRockExchange) throws IOException, InterruptedException {
    // create
    TheRockTradeService tradeService = (TheRockTradeService) theRockExchange.getTradeService();
    Double amount = new Double("0.01");
    Double price = new Double("50.0");
    LimitOrder limitOrder = new LimitOrder(OrderType.BID, amount, BTC_EUR, null, null, price);
    String id = tradeService.placeLimitOrder(limitOrder);
    Thread.sleep(3000);
  }
}
