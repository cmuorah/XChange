package org.knowm.xchange.examples.lakebtc.trade;

import java.io.IOException;
import java.util.Arrays;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.examples.lakebtc.LakeBTCExamplesUtils;
import org.knowm.xchange.lakebtc.dto.trade.LakeBTCOrderResponse;
import org.knowm.xchange.lakebtc.service.LakeBTCTradeServiceRaw;
import org.knowm.xchange.service.trade.TradeService;

/** Created by Cristi on 12/22/2014. */
public class LakeBTCSellOrderDemo {

  public static void main(String[] args) throws IOException {
    Exchange lakebtcExchange = LakeBTCExamplesUtils.createTestExchange();
    generic(lakebtcExchange);
    raw(lakebtcExchange);
  }

  private static void generic(Exchange lakebtcExchange) throws IOException {

    TradeService tradeService = lakebtcExchange.getTradeService();

    System.out.println("Open Orders: " + tradeService.getOpenOrders());

    // place a limit buy order
    LimitOrder limitOrder =
        new LimitOrder(
            (Order.OrderType.ASK),
            new Double(".01"),
            CurrencyPair.BTC_LTC,
            "",
            null,
            new Double("51.25"));
    String limitOrderReturnValue = tradeService.placeLimitOrder(limitOrder);
    System.out.println("Limit Order return value: " + limitOrderReturnValue);

    System.out.println("Open Orders: " + tradeService.getOpenOrders().toString());
  }

  private static void raw(Exchange lakeBtcExchange) throws IOException {
    LakeBTCTradeServiceRaw tradeService =
        (LakeBTCTradeServiceRaw) lakeBtcExchange.getTradeService();

    System.out.println("Open Orders: " + Arrays.toString(tradeService.getLakeBTCOrders()));

    // place a limit buy order
    LimitOrder limitOrder =
        new LimitOrder(
            (Order.OrderType.ASK),
            new Double(".01"),
            CurrencyPair.BTC_LTC,
            "",
            null,
            new Double("51.25"));
    LakeBTCOrderResponse limitOrderReturnValue = tradeService.placeLakeBTCLimitOrder(limitOrder);
    System.out.println("Limit Order return value: " + limitOrderReturnValue);

    System.out.println("Open Orders: " + Arrays.toString(tradeService.getLakeBTCOrders()));
  }
}
