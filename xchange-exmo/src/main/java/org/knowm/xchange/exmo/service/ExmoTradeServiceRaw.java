package org.knowm.xchange.exmo.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exmo.dto.trade.ExmoUserTrades;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.join;

public class ExmoTradeServiceRaw extends BaseExmoService {
    protected ExmoTradeServiceRaw(Exchange exchange) {
        super(exchange);
    }

    protected String placeOrder(
            String type, Double price, CurrencyPair currencyPair, Double originalAmount) {
        Map map =
                exmo.orderCreate(
                        signatureCreator,
                        apiKey,
                        exchange.getNonceFactory(),
                        ExmoAdapters.format(currencyPair),
                        originalAmount,
                        price,
                        type);

        Boolean result = (Boolean) map.get("result");
        if (!result) throw new ExchangeException("Failed to place order: " + map.get("error"));

        return map.get("order_id").toString();
    }

    public List<LimitOrder> openOrders() {
        Map<String, List<Map<String, String>>> map =
                exmo.userOpenOrders(signatureCreator, apiKey, exchange.getNonceFactory());

        List<LimitOrder> openOrders = new ArrayList<>();

        for (String market : map.keySet()) {

            CurrencyPair currencyPair = adaptMarket(market);

            for (Map<String, String> order : map.get(market)) {
                Order.OrderType type = ExmoAdapters.adaptOrderType(order);
                Double amount = new Double(order.get("quantity"));
                String id = order.get("order_id");
                Double price = new Double(order.get("price"));
                long created = Long.parseLong(order.get("created"));
                openOrders.add(new LimitOrder(type, amount, currencyPair, id, created, price));
            }
        }
        return openOrders;
    }

    public ExmoUserTrades userTrades(String orderId) {
        Map<String, Object> map = exmo.orderTrades(signatureCreator, apiKey, exchange.getNonceFactory(), orderId);
        List<UserTrade> userTrades = new ArrayList<>();
        Boolean result = (Boolean) map.get("result");
        if (result != null && !result) return null;

        Double originalAmount = new Double(map.get("out_amount").toString());

        for (Map<String, Object> tradeDatum : (List<Map<String, Object>>) map.get("trades")) {
            CurrencyPair market = adaptMarket(tradeDatum.get("pair").toString());
            Map<String, String> bodge = new HashMap<>();
            for (String key : tradeDatum.keySet()) {
                bodge.put(key, tradeDatum.get(key).toString());
            }
            userTrades.add(ExmoAdapters.adaptTrade(bodge, market));
        }

        return new ExmoUserTrades(originalAmount, userTrades);
    }

    public List<UserTrade> trades(Integer limit, Long offset, Collection<CurrencyPair> currencyPairs) {
        List<String> markets = new ArrayList<>();
        for (CurrencyPair currencyPair : currencyPairs) {
            markets.add(ExmoAdapters.format(currencyPair));
        }

        Map<String, List<Map<String, String>>> map =
                exmo.userTrades(
                        signatureCreator,
                        apiKey,
                        exchange.getNonceFactory(),
                        join(markets, ","),
                        offset,
                        limit);

        List<UserTrade> trades = new ArrayList<>();
        for (String market : map.keySet()) {
            for (Map<String, String> tradeDatum : map.get(market)) {
                trades.add(ExmoAdapters.adaptTrade(tradeDatum, adaptMarket(market)));
            }
        }

        trades.sort((o1, o2) -> o2.getTimestamp().compareTo(o1.getTimestamp()));
        return trades;
    }
}
