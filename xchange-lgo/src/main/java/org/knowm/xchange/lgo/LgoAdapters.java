package org.knowm.xchange.lgo;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.meta.CurrencyMetaData;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.meta.ExchangeMetaData;
import org.knowm.xchange.dto.meta.FeeTier;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.MarketOrder;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.dto.trade.UserTrades;
import org.knowm.xchange.lgo.dto.WithCursor;
import org.knowm.xchange.lgo.dto.currency.LgoCurrencies;
import org.knowm.xchange.lgo.dto.currency.LgoCurrency;
import org.knowm.xchange.lgo.dto.key.LgoKey;
import org.knowm.xchange.lgo.dto.order.LgoPlaceLimitOrder;
import org.knowm.xchange.lgo.dto.order.LgoPlaceMarketOrder;
import org.knowm.xchange.lgo.dto.order.LgoPlaceOrder;
import org.knowm.xchange.lgo.dto.product.LgoProduct;
import org.knowm.xchange.lgo.dto.product.LgoProducts;
import org.knowm.xchange.lgo.dto.trade.LgoUserTrade;
import org.knowm.xchange.lgo.dto.trade.LgoUserTrades;

public final class LgoAdapters {

  private LgoAdapters() {}

  public static ExchangeMetaData adaptMetadata(
      ExchangeMetaData metaData, LgoProducts products, LgoCurrencies currencies) {
    Map<CurrencyPair, CurrencyPairMetaData> currencyPairs = metaData.getCurrencyPairs();
    Map<Currency, CurrencyMetaData> currency = metaData.getCurrencies();
    for (LgoCurrency lgoCurrency : currencies.getCurrencies()) {
      currency.put(Currency.getInstance(lgoCurrency.getCode()), new CurrencyMetaData(lgoCurrency.getDecimals(), null));
    }
    for (LgoProduct product : products.getProducts()) {
      Double minAmount = product.getBase().getLimits().getMin();
      Double maxAmount = product.getBase().getLimits().getMax();
      Integer baseScale = currency.get(Currency.getInstance(product.getBase().getId())).getScale();
      Integer priceScale =
          currency.get(Currency.getInstance(product.getQuote().getId())).getScale();
      Double increment = product.getQuote().getIncrement();
      currencyPairs.put(
          toPair(product),
          new CurrencyPairMetaData(
              null,
              minAmount,
              maxAmount,
              null,
              null,
              baseScale,
              priceScale,
              new FeeTier[0],
              increment,
              Currency.USD,
              true));
    }
    return metaData;
  }

  private static CurrencyPair toPair(LgoProduct product) {
    return new CurrencyPair(
        Currency.getInstance(product.getBase().getId()),
        Currency.getInstance(product.getQuote().getId()));
  }

  public static Stream<LgoKey> adaptKeysIndex(String indexFile) {
    String[] all = indexFile.split("(true|false)");
    Spliterator<String> spliterator =
        Spliterators.spliterator(all, Spliterator.IMMUTABLE | Spliterator.NONNULL);
    return StreamSupport.stream(spliterator, true).map(LgoAdapters::parseSummary);
  }

  private static LgoKey parseSummary(String rawSummary) {
    String[] summary = rawSummary.split(" ");
    return new LgoKey(summary[0], Instant.parse(summary[1]), Instant.parse(summary[2]));
  }

  public static LgoPlaceOrder adaptLimitOrder(LimitOrder limitOrder) {
    String product = adaptCurrencyPair(limitOrder.getCurrencyPair());
    String side = adaptOrderType(limitOrder.getType());
    return new LgoPlaceLimitOrder(
        0,
        side,
        product,
        limitOrder.getOriginalAmount(),
        limitOrder.getLimitPrice(),
        Instant.ofEpochMilli(limitOrder.getTimestamp()));
  }

  public static LgoPlaceOrder adaptMarketOrder(MarketOrder marketOrder) {
    String product = adaptCurrencyPair(marketOrder.getCurrencyPair());
    String side = adaptOrderType(marketOrder.getType());
    return new LgoPlaceMarketOrder(
        0, side, product, marketOrder.getOriginalAmount(), Instant.ofEpochMilli(marketOrder.getTimestamp()));
  }

  public static String adaptOrderType(OrderType type) {
    return type == OrderType.BID ? "B" : "S";
  }

  public static String adaptCurrencyPair(CurrencyPair currencyPair) {
    return String.format(
        "%s-%s", currencyPair.base.getCurrencyCode(), currencyPair.counter.getCurrencyCode());
  }

  private static UserTrade adaptUserTrade(LgoUserTrade lgoUserTrade) {
    OrderType type = adaptUserTradeType(lgoUserTrade);
    CurrencyPair currencyPair = adaptProductId(lgoUserTrade.getProductId());
    Date creationDate = lgoUserTrade.getCreationDate();
    return new UserTrade(
        type,
        lgoUserTrade.getQuantity(),
        currencyPair,
        lgoUserTrade.getPrice(),
        creationDate.getTime(),
        lgoUserTrade.getId(),
        lgoUserTrade.getOrderId(),
        lgoUserTrade.getFees(),
        currencyPair.counter);
  }

  public static CurrencyPair adaptProductId(String productId) {
    String[] pair = productId.split("-");
    return new CurrencyPair(pair[0], pair[1]);
  }

  public static OrderType adaptUserTradeType(LgoUserTrade trade) {
    boolean bidSide = buyerTaker(trade) || sellerMaker(trade);
    return bidSide ? OrderType.BID : OrderType.ASK;
  }

  private static boolean sellerMaker(LgoUserTrade trade) {
    return trade.getSide().equals("S") && trade.getLiquidity().equals("M");
  }

  private static boolean buyerTaker(LgoUserTrade trade) {
    return trade.getSide().equals("B") && trade.getLiquidity().equals("T");
  }

  public static UserTrades adaptUserTrades(WithCursor<LgoUserTrades> lastTrades) {
    List<UserTrade> trades =
        lastTrades.getResult().getTrades().stream()
            .map(LgoAdapters::adaptUserTrade)
            .collect(Collectors.toList());
    return new UserTrades(trades, 0L, Trades.TradeSortType.SortByID, lastTrades.getNextPage());
  }
}
