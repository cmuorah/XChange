package org.knowm.xchange.paymium.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.dto.trade.UserTrades;
import org.knowm.xchange.paymium.dto.account.PaymiumOrder;
import org.knowm.xchange.service.trade.TradeService;
import org.knowm.xchange.service.trade.params.TradeHistoryParamLimit;
import org.knowm.xchange.service.trade.params.TradeHistoryParamOffset;
import org.knowm.xchange.service.trade.params.TradeHistoryParams;

public class PaymiumTradeService extends PaymiumTradeServiceRaw implements TradeService {

  /**
   * Constructor
   *
   * @param exchange
   */
  public PaymiumTradeService(Exchange exchange) {
    super(exchange);
  }

  @Override
  public TradeHistoryParams createTradeHistoryParams() {
    return new PaymiumHistoryParams();
  }

  @Override
  public UserTrades getTradeHistory(TradeHistoryParams params) throws IOException {

    Long offset = null;
    Integer limit = null;

    if (params instanceof TradeHistoryParamOffset) {
      final TradeHistoryParamOffset historyParamOffset = (TradeHistoryParamOffset) params;
      offset = historyParamOffset.getOffset();
    }

    if (params instanceof TradeHistoryParamLimit) {
      final TradeHistoryParamLimit historyParamLimit = (TradeHistoryParamLimit) params;
      limit = historyParamLimit.getLimit();
    }

    List<UserTrade> userTrades = new ArrayList();
    List<PaymiumOrder> orders = getPaymiumOrders(offset, limit);

    for (PaymiumOrder order : orders) {
      Order.OrderType orderType = null;
      Currency currencyFee = null;
      Double fee = null;

      switch (order.getDirection()) {
        case "buy":
          orderType = Order.OrderType.ASK;
          currencyFee = Currency.BTC;
          fee = order.getBtcFee();
          break;
        case "sell":
          orderType = Order.OrderType.BID;
          currencyFee = Currency.EUR;
          fee = order.getCurrencyFee();
          break;
      }

      UserTrade userTrade =
          new UserTrade(
              orderType,
              order.getTradedCurrency(),
              CurrencyPair.BTC_EUR,
              order.getPrice(),
              order.getUpdatedAt().getTime(),
              order.getUuid(),
              order.getUuid(),
              fee,
              currencyFee);

      userTrades.add(userTrade);
    }

    return new UserTrades(userTrades, Trades.TradeSortType.SortByTimestamp);
  }
}
