package org.knowm.xchange.cryptopia.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.knowm.xchange.cryptopia.Cryptopia;
import org.knowm.xchange.cryptopia.CryptopiaAdapters;
import org.knowm.xchange.cryptopia.CryptopiaExchange;
import org.knowm.xchange.cryptopia.dto.CryptopiaBaseResponse;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.UserTrade;

public class CryptopiaTradeServiceRaw extends CryptopiaBaseService {

  private final CryptopiaExchange exchange;

  public CryptopiaTradeServiceRaw(CryptopiaExchange exchange) {

    super(exchange);

    this.exchange = exchange;
  }

  private static Order.OrderType type(Map map) {
    return map.get("Type").toString().equals("Buy") ? Order.OrderType.BID : Order.OrderType.ASK;
  }

  public List<LimitOrder> getOpenOrders(CurrencyPair currencyPair, Integer count)
      throws IOException {

    CryptopiaBaseResponse<List<Map>> response =
        cryptopia.getOpenOrders(
            signatureCreator,
            new Cryptopia.GetOpenOrdersRequest(
                currencyPair == null ? null : currencyPair.toString(), count));

    List<LimitOrder> results = new ArrayList<>();
    for (Map map : response.getData()) {

      Order.OrderType type = type(map);

      Double originalAmount = new Double(map.get("Amount").toString());
      Double remaining = new Double(map.get("Remaining").toString());
      Double total = new Double(map.get("Total").toString());

      String id = map.get("OrderId").toString();
      Date timestamp = CryptopiaAdapters.convertTimestamp(map.get("TimeStamp").toString());

      // asd
      Double limitPrice = new Double(map.get("Rate").toString());
      Double averagePrice = null;
      Double cumulativeAmount = originalAmount - (remaining);
      Order.OrderStatus status = Order.OrderStatus.PENDING_NEW;

      CurrencyPair pair = new CurrencyPair(map.get("Market").toString());
      results.add(
          new LimitOrder(
              type,
              originalAmount,
              pair,
              id,
              timestamp.getTime(),
              limitPrice,
              averagePrice,
              cumulativeAmount,
              null,
              status));
    }

    return results;
  }

  public String submitTrade(
      CurrencyPair currencyPair, LimitOrder.OrderType type, Double price, Double amount)
      throws IOException {
    String rawType = type.equals(Order.OrderType.BID) ? "Buy" : "Sell";

    CryptopiaBaseResponse<Map> response =
        cryptopia.submitTrade(
            signatureCreator,
            new Cryptopia.SubmitTradeRequest(currencyPair.toString(), rawType, price, amount));

    List<Integer> filled = (List<Integer>) response.getData().get("FilledOrders");
    if (filled.isEmpty()) {
      return response.getData().get("OrderId").toString();
    } else {
      // if it fills instantly we don't get an orderId, so instead we return the 1st fillId...  far
      // from perfect because there could be many
      return filled.get(0).toString();
    }
  }

  public boolean cancel(String orderId) throws IOException {
    CryptopiaBaseResponse<List> response =
        cryptopia.cancelTrade(
            signatureCreator, new Cryptopia.CancelTradeRequest("Trade", orderId, null));
    return !response.getData().isEmpty();
  }

  public boolean cancelAll(CurrencyPair currencyPair) throws IOException {
    Long marketId = currencyPair == null ? null : exchange.tradePairId(currencyPair);
    CryptopiaBaseResponse<List> response =
        cryptopia.cancelTrade(
            signatureCreator, new Cryptopia.CancelTradeRequest("TradePair", null, marketId));
    return !response.getData().isEmpty();
  }

  public List<UserTrade> tradeHistory(CurrencyPair currencyPair, Integer count) throws IOException {
    CryptopiaBaseResponse<List<Map>> response =
        cryptopia.getTradeHistory(
            signatureCreator,
            new Cryptopia.GetTradeHistoryRequest(
                currencyPair == null ? null : currencyPair.toString(),
                count == null ? 100 : count));

    List<UserTrade> results = new ArrayList<>();
    for (Map map : response.getData()) {
      Order.OrderType type = type(map);
      Double amount = new Double(map.get("Amount").toString());
      Double price = new Double(map.get("Rate").toString());
      Date timestamp = CryptopiaAdapters.convertTimestamp(map.get("TimeStamp").toString());
      String id = map.get("TradeId").toString();
      Double fee = new Double(map.get("Fee").toString());

      CurrencyPair pair = new CurrencyPair(map.get("Market").toString());
      Currency feeCcy = pair.counter;
      results.add(new UserTrade(type, amount, pair, price, timestamp.getTime(), id, id, fee, feeCcy));
    }

    return results;
  }
}
