package org.knowm.xchange.dsx;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import net.openhft.chronicle.core.Maths;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dsx.dto.account.DSXAccountInfo;
import org.knowm.xchange.dsx.dto.account.DSXCurrencyAmount;
import org.knowm.xchange.dsx.dto.marketdata.DSXExchangeInfo;
import org.knowm.xchange.dsx.dto.marketdata.DSXPairInfo;
import org.knowm.xchange.dsx.dto.marketdata.DSXTicker;
import org.knowm.xchange.dsx.dto.marketdata.DSXTrade;
import org.knowm.xchange.dsx.dto.meta.DSXMetaData;
import org.knowm.xchange.dsx.dto.trade.DSXOrder;
import org.knowm.xchange.dsx.dto.trade.DSXTradeHistoryResult;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.meta.CurrencyMetaData;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.meta.ExchangeMetaData;
import org.knowm.xchange.dto.meta.RateLimit;
import org.knowm.xchange.dto.trade.*;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** @author Mikhail Wall */
public class DSXAdapters {

  private static final Logger log = LoggerFactory.getLogger(DSXAdapters.class);
  public static DSXExchangeInfo dsxExchangeInfo;

  private DSXAdapters() {}

  public static List<LimitOrder> adaptOrders(
      List<Double[]> dSXOrders, CurrencyPair currencyPair, String orderTypeString, String id) {

    List<LimitOrder> limitOrders = new ArrayList<>();
    OrderType orderType = orderTypeString.equalsIgnoreCase("bid") ? OrderType.BID : OrderType.ASK;

    for (Double[] dsxOrder : dSXOrders) {
      limitOrders.add(adaptOrders(dsxOrder[1], dsxOrder[0], currencyPair, orderType, id));
    }

    return limitOrders;
  }

  public static LimitOrder adaptOrders(
      Double amount, Double price, CurrencyPair currencyPair, OrderType orderType, String id) {

    return new LimitOrder(orderType, amount, currencyPair, id, null, price);
  }

  public static Trade adaptTrade(DSXTrade dSXTrade, CurrencyPair currencyPair) {

    OrderType orderType =
        dSXTrade.getTradeType().equalsIgnoreCase("bid") ? OrderType.BID : OrderType.ASK;
    Double amount = dSXTrade.getAmount();
    Double price = dSXTrade.getPrice();
    Date date = DateUtils.fromMillisUtc(dSXTrade.getDate() * 1000L);

    final String tradeId = String.valueOf(dSXTrade.getTid());
    return new Trade(orderType, amount, currencyPair, price, date.getTime(), tradeId);
  }

  public static Trades adaptTrades(DSXTrade[] dSXTrades, CurrencyPair currencyPair) {

    List<Trade> tradesList = new ArrayList<>();
    long lastTradeId = 0;
    for (DSXTrade dSXTrade : dSXTrades) {

      long tradeId = dSXTrade.getTid();
      if (tradeId > lastTradeId) {
        lastTradeId = tradeId;
      }
      tradesList.add(0, adaptTrade(dSXTrade, currencyPair));
    }
    return new Trades(tradesList, lastTradeId, Trades.TradeSortType.SortByID);
  }

  public static Ticker adaptTicker(DSXTicker dSXTicker, CurrencyPair currencyPair) {

    Double last = dSXTicker.getLast();
    Double bid = dSXTicker.getSell();
    Double ask = dSXTicker.getBuy();
    Double high = dSXTicker.getHigh();
    Double low = dSXTicker.getLow();
    Double avg = dSXTicker.getAvg();
    Double volume = dSXTicker.getVol();
    Date timestamp = DateUtils.fromMillisUtc(dSXTicker.getUpdated() * 1000L);

    return new Ticker.Builder()
        .currencyPair(currencyPair)
        .last(last)
        .bid(bid)
        .ask(ask)
        .high(high)
        .low(low)
        .vwap(avg)
        .volume(volume)
        .timestamp(timestamp.getTime())
        .build();
  }

  public static Wallet adaptWallet(DSXAccountInfo dsxAccountInfo) {
    List<Balance> balances = new ArrayList<>();
    for (Entry<String, DSXCurrencyAmount> e : dsxAccountInfo.getFunds().entrySet()) {
      String currency = e.getKey();
      Double total = e.getValue().getTotal();
      Double available = e.getValue().getAvailable();
      if (available == null) {
        available = total;
      }
      balances.add(new Balance(Currency.getInstance(currency), total, available));
    }

    return Wallet.Builder.from(balances).build();
  }

  public static OpenOrders adaptOrders(Map<Long, DSXOrder> dsxOrderMap) {

    List<LimitOrder> limitOrders = new ArrayList<>();
    for (Long id : dsxOrderMap.keySet()) {
      DSXOrder dsxOrder = dsxOrderMap.get(id);
      OrderType orderType = dsxOrder.getType() == DSXOrder.Type.buy ? OrderType.BID : OrderType.ASK;
      Double price = dsxOrder.getRate();
      CurrencyPair currencyPair = adaptCurrencyPair(dsxOrder.getPair());
      Date timestamp = DateUtils.fromUnixTime(Long.parseLong(dsxOrder.getTimestampCreated()));

      limitOrders.add(
          new LimitOrder(
              orderType,
              dsxOrder.getAmount(),
              dsxOrder.getAmount() - (dsxOrder.getRemainingVolume()),
              currencyPair,
              Long.toString(id),
              timestamp.getTime(),
              price));
    }
    return new OpenOrders(limitOrders);
  }

  public static UserTrades adaptTradeHistory(Map<Long, DSXTradeHistoryResult> tradeHistory) {

    List<UserTrade> trades = new ArrayList<>(tradeHistory.size());
    for (Entry<Long, DSXTradeHistoryResult> entry : tradeHistory.entrySet()) {
      DSXTradeHistoryResult result = entry.getValue();
      OrderType type =
          result.getType() == DSXTradeHistoryResult.Type.buy ? OrderType.BID : OrderType.ASK;
      Double price = result.getRate();
      Double originalAmount = result.getAmount();
      Date timeStamp = DateUtils.fromMillisUtc(result.getTimestamp() * 1000L);
      String orderId = String.valueOf(result.getOrderId());
      String tradeId = String.valueOf(entry.getKey());
      CurrencyPair currencyPair = adaptCurrencyPair(result.getPair());
      Double feeAmount = result.getCommission();
      Currency feeCurrency = adaptCurrency(result.getCommissionCurrency());
      trades.add(
          new UserTrade(
              type,
              originalAmount,
              currencyPair,
              price,
              timeStamp.getTime(),
              tradeId,
              orderId,
              feeAmount,
              feeCurrency));
    }
    return new UserTrades(trades, Trades.TradeSortType.SortByTimestamp);
  }

  public static CurrencyPair adaptCurrencyPair(String dsxCurrencyPair) {
    if (dsxExchangeInfo == null) {
      throw new ExchangeException("DSX exchange info not initialized yet.");
    }
    DSXPairInfo dsxPairInfo = dsxExchangeInfo.getPairs().get(dsxCurrencyPair);
    if (dsxPairInfo == null) {
      throw new ExchangeException("Not supported DSX pair: " + dsxCurrencyPair);
    }
    return new CurrencyPair(dsxPairInfo.baseCurrency, dsxPairInfo.quotedCurrency);
  }

  public static Currency adaptCurrency(String dsxCurrency) {
    return Currency.getInstance(dsxCurrency.toUpperCase());
  }

  public static List<CurrencyPair> adaptCurrencyPair(Iterable<String> dsxPairs) {

    List<CurrencyPair> pairs = new ArrayList<>();
    for (String dsxPair : dsxPairs) {
      pairs.add(adaptCurrencyPair(dsxPair));
    }

    return pairs;
  }

  public static String currencyPairToMarketName(CurrencyPair currencyPair) {

    String base = currencyPair.base.getCurrencyCode();
    String counter = currencyPair.counter.getCurrencyCode();
    String marketName = (base + counter).toLowerCase();
    marketName =
        marketName.replace("bch", "bcc"); // temp bodge while the exchange moves from bcc to bch
    return marketName;
  }

  public static ExchangeMetaData toMetaData(
      DSXExchangeInfo dsxExchangeInfo, DSXMetaData dsxMetaData) {

    Map<CurrencyPair, CurrencyPairMetaData> currencyPairs = new HashMap<>();
    Map<Currency, CurrencyMetaData> currencies = new HashMap<>();

    if (dsxExchangeInfo != null) {
      for (Entry<String, DSXPairInfo> e : dsxExchangeInfo.getPairs().entrySet()) {
        String marketName = e.getKey();

        CurrencyPair pair = adaptCurrencyPair(marketName);
        CurrencyPairMetaData marketMetaData = toMarketMetaData(e.getValue());
        currencyPairs.put(pair, marketMetaData);

        addCurrencyMetaData(pair.base, currencies, dsxMetaData);
        addCurrencyMetaData(pair.counter, currencies, dsxMetaData);
      }
    }

    RateLimit[] publicRateLimits =
        new RateLimit[] {new RateLimit(dsxMetaData.publicInfoCacheSeconds, 1, TimeUnit.SECONDS)};
    return new ExchangeMetaData(currencyPairs, currencies, publicRateLimits, null, false);
  }

  private static void addCurrencyMetaData(
      Currency symbol, Map<Currency, CurrencyMetaData> currencies, DSXMetaData dsxMetaData) {

    if (!currencies.containsKey(symbol)) {
      Double withdrawalFee =
          dsxMetaData.getCurrencies().get(symbol) == null
              ? null
              : dsxMetaData.getCurrencies().get(symbol).getWithdrawalFee();
      currencies.put(symbol, new CurrencyMetaData(dsxMetaData.amountScale, withdrawalFee));
    }
  }

  public static CurrencyPairMetaData toMarketMetaData(DSXPairInfo info) {

    int priceScale = info.getDecimalsPrice();
    Double minimumAmount = withScale(info.getMinAmount(), info.getDecimalVolume());
    Double maximumAmount = withScale(info.getMaxPrice(), info.getDecimalVolume());
    Double feeFraction = info.getFee() / 100.0;

    return new CurrencyPairMetaData(feeFraction, minimumAmount, maximumAmount, priceScale, null);
  }

  private static Double withScale(Double value, int priceScale) {
    return Maths.roundN(value, priceScale);
  }

  public static LimitOrder createLimitOrder(
      MarketOrder marketOrder, DSXExchangeInfo dsxExchangeInfo) {
    DSXPairInfo dsxPairInfo =
        dsxExchangeInfo.getPairs().get(currencyPairToMarketName(marketOrder.getCurrencyPair()));
    Double limitPrice =
        marketOrder.getType() == OrderType.BID
            ? dsxPairInfo.getMaxPrice()
            : dsxPairInfo.getMinPrice();
    return LimitOrder.Builder.from(marketOrder).limitPrice(limitPrice).build();
  }
}
