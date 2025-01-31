package org.knowm.xchange.lgo.service;

import java.io.IOException;
import java.util.Random;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.MarketOrder;
import org.knowm.xchange.dto.trade.UserTrades;
import org.knowm.xchange.lgo.LgoAdapters;
import org.knowm.xchange.lgo.LgoErrorAdapter;
import org.knowm.xchange.lgo.LgoExchange;
import org.knowm.xchange.lgo.dto.LgoException;
import org.knowm.xchange.lgo.dto.WithCursor;
import org.knowm.xchange.lgo.dto.product.LgoProduct;
import org.knowm.xchange.lgo.dto.product.LgoProductCurrency;
import org.knowm.xchange.lgo.dto.trade.LgoUserTrades;
import org.knowm.xchange.service.trade.TradeService;
import org.knowm.xchange.service.trade.params.*;

public class LgoTradeService extends LgoTradeServiceRaw implements TradeService {

  private final Random random;

  public LgoTradeService(LgoExchange exchange) {
    super(exchange);
    random = new Random();
  }

  @Override
  public UserTrades getTradeHistory(TradeHistoryParams params) throws IOException {
    CurrencyPair productId = getProductId(params);
    Integer maxResults = getMaxResults(params);
    String page = getPage(params);
    TradeHistoryParamsSorted.Order sort = getSort(params);
    try {
      WithCursor<LgoUserTrades> lgoTrades =
          super.getLastTrades(
              random.nextLong(), exchange.getSignatureService(), productId, maxResults, page, sort);
      return LgoAdapters.adaptUserTrades(lgoTrades);
    } catch (LgoException e) {
      throw LgoErrorAdapter.adapt(e);
    }
  }

  private TradeHistoryParamsSorted.Order getSort(TradeHistoryParams params) {
    if (!(params instanceof TradeHistoryParamsSorted)) {
      return TradeHistoryParamsSorted.Order.desc;
    }
    return ((TradeHistoryParamsSorted) params).getOrder();
  }

  private String getPage(TradeHistoryParams params) {
    if (!(params instanceof TradeHistoryParamNextPageCursor)) {
      return null;
    }
    return ((TradeHistoryParamNextPageCursor) params).getNextPageCursor();
  }

  private CurrencyPair getProductId(TradeHistoryParams params) {
    if (!(params instanceof TradeHistoryParamCurrencyPair)) {
      return null;
    }
    return ((TradeHistoryParamCurrencyPair) params).getCurrencyPair();
  }

  private int getMaxResults(TradeHistoryParams params) {
    if (!(params instanceof TradeHistoryParamLimit)) {
      return 100;
    }
    return ((TradeHistoryParamLimit) params).getLimit();
  }

  @Override
  public TradeHistoryParams createTradeHistoryParams() {
    return new LgoTradeHistoryParams();
  }

  @Override
  public void verifyOrder(MarketOrder marketOrder) {
    LgoProduct product = getProduct(marketOrder.getCurrencyPair());
    LgoProductCurrency currencyToCheck =
        OrderType.BID.equals(marketOrder.getType()) ? product.getQuote() : product.getBase();
    if (currencyToCheck.getLimits().getMin().compareTo(marketOrder.getRemainingAmount()) > 0) {
      throw new IllegalArgumentException("Quantity to low");
    }
    if (currencyToCheck.getLimits().getMax().compareTo(marketOrder.getRemainingAmount()) < 0) {
      throw new IllegalArgumentException("Quantity to high");
    }
  }

  @Override
  public void verifyOrder(LimitOrder limitOrder) {
    super.verifyOrder(limitOrder);
    LgoProduct product = getProduct(limitOrder.getCurrencyPair());
    if (product.getBase().getLimits().getMax().compareTo(limitOrder.getOriginalAmount()) < 0) {
      throw new IllegalArgumentException("Order amount more than maximum");
    }
    if (product.getQuote().getLimits().getMin().compareTo(limitOrder.getLimitPrice()) > 0) {
      throw new IllegalArgumentException("Order price to low");
    }
    if (product.getQuote().getLimits().getMax().compareTo(limitOrder.getLimitPrice()) < 0) {
      throw new IllegalArgumentException("Order price to high");
    }
    if (limitOrder.getLimitPrice() % product.getQuote().getIncrement() != 0) {
      throw new IllegalArgumentException("Invalid price increment");
    }
  }

  private LgoProduct getProduct(CurrencyPair currencyPair) {
    for (LgoProduct product : exchange.getProducts().getProducts()) {
      if (product.getBase().getId().equalsIgnoreCase(currencyPair.base.getCurrencyCode())
          && product.getQuote().getId().equalsIgnoreCase(currencyPair.counter.getCurrencyCode())) {
        return product;
      }
    }
    throw new IllegalArgumentException("Product not supported " + currencyPair.toString());
  }
}
