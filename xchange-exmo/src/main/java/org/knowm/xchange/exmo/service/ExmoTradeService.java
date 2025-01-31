package org.knowm.xchange.exmo.service;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.trade.*;
import org.knowm.xchange.exceptions.NotAvailableFromExchangeException;
import org.knowm.xchange.exmo.ExmoExchange;
import org.knowm.xchange.exmo.dto.trade.ExmoTradeHistoryParams;
import org.knowm.xchange.exmo.dto.trade.ExmoUserTrades;
import org.knowm.xchange.service.trade.TradeService;
import org.knowm.xchange.service.trade.params.*;
import org.knowm.xchange.service.trade.params.orders.OpenOrdersParams;
import org.knowm.xchange.service.trade.params.orders.OrderQueryParams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ExmoTradeService extends ExmoTradeServiceRaw implements TradeService {
  public ExmoTradeService(ExmoExchange exmoExchange) {
    super(exmoExchange);
  }

  @Override
  public OpenOrders getOpenOrders() {
    return getOpenOrders(null);
  }

  @Override
  public OpenOrders getOpenOrders(OpenOrdersParams params) {
    return new OpenOrders(openOrders());
  }

  @Override
  public String placeMarketOrder(MarketOrder marketOrder) {
    String type = marketOrder.getType().equals(Order.OrderType.BID) ? "market_buy" : "market_sell";

    return placeOrder(type, 0d, marketOrder.getCurrencyPair(), marketOrder.getOriginalAmount());
  }

  @Override
  public String placeLimitOrder(LimitOrder limitOrder) {
    String type = limitOrder.getType().equals(Order.OrderType.BID) ? "buy" : "sell";

    return placeOrder(
        type,
        limitOrder.getLimitPrice(),
        limitOrder.getCurrencyPair(),
        limitOrder.getOriginalAmount());
  }

  @Override
  public boolean cancelOrder(CancelOrderParams orderParams) {
    if (orderParams instanceof CancelOrderByIdParams) {
      CancelOrderByIdParams params = (CancelOrderByIdParams) orderParams;
      String orderId = params.getOrderId();
      Map map = exmo.orderCancel(signatureCreator, apiKey, exchange.getNonceFactory(), orderId);
      return (boolean) map.get("result");
    }

    return false;
  }

  @Override
  public UserTrades getTradeHistory(TradeHistoryParams params) {
    Integer limit = 10000;
    Long offset = 0L;
    List<CurrencyPair> currencyPairs = new ArrayList<>();

    if (params instanceof ExmoTradeHistoryParams) {
      ExmoTradeHistoryParams exmoTradeHistoryParams = (ExmoTradeHistoryParams) params;
      currencyPairs.addAll(exmoTradeHistoryParams.getCurrencyPairs());
    } else if (params instanceof TradeHistoryParamCurrencyPair) {
      TradeHistoryParamCurrencyPair tradeHistoryParamCurrencyPair =
          (TradeHistoryParamCurrencyPair) params;
      currencyPairs.add(tradeHistoryParamCurrencyPair.getCurrencyPair());
    }

    if (params instanceof TradeHistoryParamLimit) {
      limit = ((TradeHistoryParamLimit) params).getLimit();
    }

    if (params instanceof TradeHistoryParamOffset) {
      offset = ((TradeHistoryParamOffset) params).getOffset();
    }

    List<UserTrade> trades = trades(limit, offset, currencyPairs);

    return new UserTrades(trades, Trades.TradeSortType.SortByTimestamp);
  }

  @Override
  public String placeStopOrder(StopOrder stopOrder) {
    throw new NotAvailableFromExchangeException();
  }

  @Override
  /*
   * Warning: this make multiple api requests (one per parameter) so may result in you exceeding
   * your api limits
   */
  public Collection<Order> getOrder(OrderQueryParams... orderQueryParams) {
    List<Order> results = new ArrayList<>();

    for (OrderQueryParams orderQueryParam : orderQueryParams) {
      String orderId = orderQueryParam.getOrderId();

      Order.OrderType type = null;
      CurrencyPair currencyPair = null;
      String id = null;
      Long timestamp = null;
      Double totalValue = 0d;
      Double cumulativeAmount = 0d;
      Double fee = 0d;
      Order.OrderStatus status = Order.OrderStatus.UNKNOWN;

      ExmoUserTrades exmoUserTrades = userTrades(orderId);
      if (exmoUserTrades == null) continue;

      Double originalAmount = exmoUserTrades.getOriginalAmount();

      for (UserTrade userTrade : exmoUserTrades.getUserTrades()) {
        type = userTrade.getType();
        currencyPair = userTrade.getCurrencyPair();
        id = userTrade.getOrderId();

        if (timestamp == null)
          timestamp = userTrade.getTimestamp();

        // arbitrarily use the timestamp from the most recent trade
        if (timestamp < userTrade.getTimestamp())
          timestamp = userTrade.getTimestamp();

        Double amountForFill = userTrade.getOriginalAmount();
        Double priceForFill = userTrade.getPrice();
        double value = amountForFill / (priceForFill);

        cumulativeAmount = cumulativeAmount + (amountForFill);
        totalValue = totalValue + (value);
      }

      Double averagePrice = totalValue / cumulativeAmount;

      Order order =
          new MarketOrder(
              type,
              originalAmount,
              currencyPair,
              id,
              timestamp,
              averagePrice,
              cumulativeAmount,
              fee,
              status);

      results.add(order);
    }

    return results;
  }

  @Override
  public TradeHistoryParams createTradeHistoryParams() {
    return new ExmoTradeHistoryParams();
  }
}
