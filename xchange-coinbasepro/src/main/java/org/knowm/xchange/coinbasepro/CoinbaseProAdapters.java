package org.knowm.xchange.coinbasepro;

import org.knowm.xchange.coinbasepro.dto.CoinbaseProTransfer;
import org.knowm.xchange.coinbasepro.dto.account.CoinbaseProAccount;
import org.knowm.xchange.coinbasepro.dto.marketdata.*;
import org.knowm.xchange.coinbasepro.dto.trade.*;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.Order.OrderStatus;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.marketdata.Trades.TradeSortType;
import org.knowm.xchange.dto.meta.CurrencyMetaData;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.meta.ExchangeMetaData;
import org.knowm.xchange.dto.trade.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoinbaseProAdapters {
    private static final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd'T'HH:mm:ss")
            .appendFraction(ChronoField.MICRO_OF_SECOND, 0, 9, true) // Nanoseconds = 0-9 digits of fractional second.
            .appendLiteral('Z')
            .toFormatter();
  private static Logger logger = LoggerFactory.getLogger(CoinbaseProAdapters.class);

  private CoinbaseProAdapters() {}

  public static Long parseDate(final String rawLong) {

    try {
      return LocalDateTime.parse(rawLong, formatter).toInstant(ZoneOffset.UTC).toEpochMilli();
    } catch (Exception e) {
      logger.warn("unable to parse rawLong={}", rawLong, e);
      return null;
    }
  }

  public static Ticker adaptTicker(
      CoinbaseProProductTicker ticker, CoinbaseProProductStats stats, CurrencyPair currencyPair) {

    Double last = ticker.getPrice();
    Double open = stats.getOpen();
    Double high = stats.getHigh();
    Double low = stats.getLow();
    Double buy = ticker.getBid();
    Double sell = ticker.getAsk();
    Double volume = ticker.getVolume();
    Long date = parseDate(ticker.getTime());

    return new Ticker.Builder()
        .currencyPair(currencyPair)
        .last(last)
        .open(open)
        .high(high)
        .low(low)
        .bid(buy)
        .ask(sell)
        .volume(volume)
        .timestamp(date)
        .build();
  }

  public static OrderBook adaptOrderBook(CoinbaseProProductBook book, CurrencyPair currencyPair, Long date) {
    List<LimitOrder> asks = toLimitOrderList(book.getAsks(), OrderType.ASK, currencyPair);
    List<LimitOrder> bids = toLimitOrderList(book.getBids(), OrderType.BID, currencyPair);
    return new OrderBook(date, asks, bids);
  }

  public static OrderBook adaptOrderBook(CoinbaseProProductBook book, CurrencyPair currencyPair) {
    return adaptOrderBook(book, currencyPair, null);
  }

  private static List<LimitOrder> toLimitOrderList(
      CoinbaseProProductBookEntry[] levels, OrderType orderType, CurrencyPair currencyPair) {
    List<LimitOrder> allLevels = new ArrayList<>();
    if (levels != null) {
      for (CoinbaseProProductBookEntry ask : levels) {
        allLevels.add(
            new LimitOrder(orderType, ask.getVolume(), currencyPair, "0", null, ask.getPrice()));
      }
    }
    return allLevels;
  }

  public static Wallet adaptAccountInfo(CoinbaseProAccount[] coinbaseProAccounts) {
    List<Balance> balances = new ArrayList<>(coinbaseProAccounts.length);
    for (CoinbaseProAccount coinbaseProAccount : coinbaseProAccounts) {
      balances.add(
          new Balance(
              Currency.getInstance(coinbaseProAccount.getCurrency()),
              coinbaseProAccount.getBalance(),
              coinbaseProAccount.getAvailable(),
              coinbaseProAccount.getHold()));
    }
    return Wallet.Builder.from(balances).id(coinbaseProAccounts[0].getProfile_id()).build();
  }

  @SuppressWarnings("unchecked")
  public static OpenOrders adaptOpenOrders(CoinbaseProOrder[] coinbaseExOpenOrders) {
    Stream<Order> orders = Arrays.stream(coinbaseExOpenOrders).map(CoinbaseProAdapters::adaptOrder);
    Map<Boolean, List<Order>> twoTypes =
        orders.collect(Collectors.partitioningBy(t -> t instanceof LimitOrder));
    @SuppressWarnings("rawtypes")
    List limitOrders = twoTypes.get(true);
    return new OpenOrders(limitOrders, twoTypes.get(false));
  }

  public static Order adaptOrder(CoinbaseProOrder order) {
    OrderType type = order.getSide().equals("buy") ? OrderType.BID : OrderType.ASK;
    CurrencyPair currencyPair = new CurrencyPair(order.getProductId().replace('-', '/'));
    Order.Builder builder = null;
    if (order.getType().equals("market")) {
      builder = new MarketOrder.Builder(type, currencyPair);
    } else if (order.getType().equals("limit")) {
      if (order.getStop() == null) {
        builder = new LimitOrder.Builder(type, currencyPair).limitPrice(order.getPrice());
      } else {
        builder = new StopOrder.Builder(type, currencyPair).stopPrice(order.getStopPrice());
      }
    }
    if (builder == null) {
      return null;
    }
    builder
        .orderStatus(adaptOrderStatus(order))
        .originalAmount(order.getSize())
        .id(order.getId())
        .timestamp(parseDate(order.getCreatedAt()))
        .cumulativeAmount(order.getFilledSize())
        .fee(order.getFillFees());
    double averagePrice;
    if (Math.signum(order.getFilledSize()) != 0 && Math.signum(order.getExecutedvalue()) != 0) {
      averagePrice = order.getExecutedvalue() / order.getFilledSize();
    } else {
      averagePrice = 0d;
    }
    builder.averagePrice(averagePrice);
    return builder.build();
  }

  public static OrderStatus[] adaptOrderStatuses(CoinbaseProOrder[] orders) {

    OrderStatus[] orderStatuses = new OrderStatus[orders.length];

    int i = 0;
    for (CoinbaseProOrder coinbaseProOrder : orders) {
      orderStatuses[i++] = adaptOrderStatus(coinbaseProOrder);
    }
    return orderStatuses;
  }

  /** The status from the CoinbaseProOrder object converted to xchange status */
  public static OrderStatus adaptOrderStatus(CoinbaseProOrder order) {

    if (order.getStatus().equals("pending")) {
      return OrderStatus.PENDING_NEW;
    }

    if (order.getStatus().equals("done") || order.getStatus().equals("settled")) {

      if (order.getDoneReason().equals("filled")) {
        return OrderStatus.FILLED;
      }

      if (order.getDoneReason().equals("canceled")) {
        return OrderStatus.CANCELED;
      }

      return OrderStatus.UNKNOWN;
    }

    if (Math.signum(order.getFilledSize()) == 0) {

      if (order.getStatus().equals("open") && order.getStop() != null) {
        // This is a massive edge case of a stop triggering but not immediately
        // fulfilling.  STOPPED status is only currently used by the HitBTC and
        // YoBit implementations and in both cases it looks like a
        // misunderstanding and those should return CANCELLED.  Should we just
        // remove this status?
        return OrderStatus.STOPPED;
      }

      return OrderStatus.NEW;
    }

    if (order.getFilledSize().compareTo(0d) > 0
        // if size >= filledSize order should be partially filled
        && order.getSize().compareTo(order.getFilledSize()) >= 0)
      return OrderStatus.PARTIALLY_FILLED;

    return OrderStatus.UNKNOWN;
  }

  public static Trades adaptTrades(
      List<CoinbaseProTrade> gdaxTradesList, CurrencyPair currencyPair) {
    CoinbaseProTrade[] tradeArray = new CoinbaseProTrade[gdaxTradesList.size()];
    gdaxTradesList.toArray(tradeArray);
    return CoinbaseProAdapters.adaptTrades(tradeArray, currencyPair);
  }

  public static UserTrades adaptTradeHistory(CoinbaseProFill[] coinbaseExFills) {

    List<UserTrade> trades = new ArrayList<>(coinbaseExFills.length);

    for (CoinbaseProFill fill : coinbaseExFills) {
      OrderType type = fill.getSide().equals("buy") ? OrderType.BID : OrderType.ASK;
      CurrencyPair currencyPair = new CurrencyPair(fill.getProductId().replace('-', '/'));
      UserTrade t =
          new UserTrade(
              type,
              fill.getSize(),
              currencyPair,
              fill.getPrice(),
              parseDate(fill.getCreatedAt()),
              String.valueOf(fill.getTradeId()),
              fill.getOrderId(),
              fill.getFee(),
              currencyPair.counter);
      trades.add(t);
    }

    return new UserTrades(trades, TradeSortType.SortByID);
  }

  public static Trades adaptTrades(CoinbaseProTrade[] coinbaseExTrades, CurrencyPair currencyPair) {

    List<Trade> trades = new ArrayList<>(coinbaseExTrades.length);
    for (CoinbaseProTrade trade : coinbaseExTrades) {
      // yes, sell means buy for coinbasePro reported trades..
      OrderType type = trade.getSide().equals("sell") ? OrderType.BID : OrderType.ASK;
      Trade t =
          new Trade(
              type,
              trade.getSize(),
              currencyPair,
              trade.getPrice(),
              parseDate(trade.getTimestamp()),
              String.valueOf(trade.getTradeId()));
      t.setMakerOrderId(trade.getMakerOrderId());
      t.setTakerOrderId(trade.getTakerOrderId());
      trades.add(t);
    }
    return new Trades(trades, coinbaseExTrades[0].getTradeId(), TradeSortType.SortByID);
  }

  public static CurrencyPair adaptCurrencyPair(CoinbaseProProduct product) {
    return new CurrencyPair(product.getBaseCurrency(), product.getTargetCurrency());
  }

  private static Currency adaptCurrency(CoinbaseProCurrency currency) {
    return new Currency(currency.getId());
  }

  private static int numberOfDecimals(Double value) {
    double d = value;
    return -(int) Math.round(Math.log10(d));
  }

  public static ExchangeMetaData adaptToExchangeMetaData(
      ExchangeMetaData exchangeMetaData,
      CoinbaseProProduct[] products,
      CoinbaseProCurrency[] cbCurrencies) {

    Map<CurrencyPair, CurrencyPairMetaData> currencyPairs = exchangeMetaData.getCurrencyPairs();
    Map<Currency, CurrencyMetaData> currencies = exchangeMetaData.getCurrencies();
    for (CoinbaseProProduct product : products) {
      if (!product.getStatus().equals("online")) {
        continue;
      }

      Double minSize = product.getBaseMinSize();
      Double maxSize = product.getBaseMaxSize();
      Double minMarketFunds = product.getMinMarketFunds();
      Double maxMarketFunds = product.getMaxMarketFunds();

      CurrencyPair pair = adaptCurrencyPair(product);

      CurrencyPairMetaData staticMetaData = exchangeMetaData.getCurrencyPairs().get(pair);
      int baseScale = numberOfDecimals(product.getBaseIncrement());
      int priceScale = numberOfDecimals(product.getQuoteIncrement());
      boolean marketOrderAllowed = !product.isLimitOnly();
      CurrencyPairMetaData cpmd =
          new CurrencyPairMetaData(
              0.5d, // Trading fee at Coinbase is 0.25 %
              minSize,
              maxSize,
              minMarketFunds,
              maxMarketFunds,
              baseScale,
              priceScale,
              staticMetaData != null ? staticMetaData.getFeeTiers() : null,
              null,
              pair.counter,
              marketOrderAllowed);
      currencyPairs.put(pair, cpmd);
    }

    Arrays.stream(cbCurrencies)
        .filter(currency -> currency.getStatus().equals("online"))
        .forEach(
            currency -> {
              Currency cur = adaptCurrency(currency);
              int scale = numberOfDecimals(currency.getMaxPrecision());
              // Coinbase has a 0 withdrawal fee
              currencies.put(cur, new CurrencyMetaData(scale, 0d));
            });

    return new ExchangeMetaData(
        currencyPairs,
        currencies,
        exchangeMetaData.getPublicRateLimits(),
        exchangeMetaData.getPrivateRateLimits(),
        true);
  }

  public static String adaptProductID(CurrencyPair currencyPair) {
    return currencyPair.base.getCurrencyCode() + "-" + currencyPair.counter.getCurrencyCode();
  }

  public static CoinbaseProPlaceOrder.Side adaptSide(OrderType orderType) {
    return orderType == OrderType.ASK
        ? CoinbaseProPlaceOrder.Side.sell
        : CoinbaseProPlaceOrder.Side.buy;
  }

  public static CoinbaseProPlaceOrder.Stop adaptStop(OrderType orderType) {
    return orderType == OrderType.ASK
        ? CoinbaseProPlaceOrder.Stop.loss
        : CoinbaseProPlaceOrder.Stop.entry;
  }

  public static CoinbaseProPlaceLimitOrder adaptCoinbaseProPlaceLimitOrder(LimitOrder limitOrder) {
    CoinbaseProPlaceLimitOrder.Builder builder =
        new CoinbaseProPlaceLimitOrder.Builder()
            .price(limitOrder.getLimitPrice())
            .type(CoinbaseProPlaceOrder.Type.limit)
            .productId(adaptProductID(limitOrder.getCurrencyPair()))
            .side(adaptSide(limitOrder.getType()))
            .size(limitOrder.getOriginalAmount());

    if (limitOrder.getOrderFlags().contains(CoinbaseProOrderFlags.POST_ONLY))
      builder.postOnly(true);
    if (limitOrder.getOrderFlags().contains(CoinbaseProOrderFlags.FILL_OR_KILL))
      builder.timeInForce(CoinbaseProPlaceLimitOrder.TimeInForce.FOK);
    if (limitOrder.getOrderFlags().contains(CoinbaseProOrderFlags.IMMEDIATE_OR_CANCEL))
      builder.timeInForce(CoinbaseProPlaceLimitOrder.TimeInForce.IOC);

    return builder.build();
  }

  public static CoinbaseProPlaceMarketOrder adaptCoinbaseProPlaceMarketOrder(
      MarketOrder marketOrder) {
    OrderType orderType = marketOrder.getType();
    return new CoinbaseProPlaceMarketOrder.Builder()
        .productId(adaptProductID(marketOrder.getCurrencyPair()))
        .type(CoinbaseProPlaceOrder.Type.market)
        .side(adaptSide(marketOrder.getType()))
        .funds(marketOrder.getType() == OrderType.BID ? marketOrder.getOriginalAmount() : null)
        .size(marketOrder.getType() == OrderType.ASK ? marketOrder.getOriginalAmount() : null)
        .build();
  }

  /**
   * Creates a 'stop' order. Stop limit order converts to a limit order when the stop amount is
   * triggered. The limit order can have a different price than the stop price.
   *
   * <p>If the stop order has no limit price it will execute as a market order once the stop price
   * is broken
   *
   * @param stopOrder
   * @return
   */
  public static CoinbaseProPlaceOrder adaptCoinbaseProStopOrder(StopOrder stopOrder) {
    // stop orders can also execute as 'stop limit' orders, that is converting to
    // a limit order, but a traditional 'stop' order converts to a market order
    if (stopOrder.getLimitPrice() == null) {
      return new CoinbaseProPlaceMarketOrder.Builder()
          .productId(adaptProductID(stopOrder.getCurrencyPair()))
          .type(CoinbaseProPlaceOrder.Type.market)
          .side(adaptSide(stopOrder.getType()))
          .size(stopOrder.getOriginalAmount())
          .stop(adaptStop(stopOrder.getType()))
          .stopPrice(stopOrder.getStopPrice())
          .build();
    }
    return new CoinbaseProPlaceLimitOrder.Builder()
        .productId(adaptProductID(stopOrder.getCurrencyPair()))
        .type(CoinbaseProPlaceOrder.Type.limit)
        .side(adaptSide(stopOrder.getType()))
        .size(stopOrder.getOriginalAmount())
        .stop(adaptStop(stopOrder.getType()))
        .stopPrice(stopOrder.getStopPrice())
        .price(stopOrder.getLimitPrice())
        .build();
  }

  public static FundingRecord adaptFundingRecord(
      Currency currency, CoinbaseProTransfer coinbaseProTransfer) {
    FundingRecord.Status status = FundingRecord.Status.PROCESSING;

    Long processedAt = coinbaseProTransfer.processedAt();
    Long canceledAt = coinbaseProTransfer.canceledAt();

    if (canceledAt != null) status = FundingRecord.Status.CANCELLED;
    else if (processedAt != null) status = FundingRecord.Status.COMPLETE;

    Long timestamp = coinbaseProTransfer.createdAt();

    String address = coinbaseProTransfer.getDetails().getCryptoAddress();
    if (address == null) address = coinbaseProTransfer.getDetails().getSentToAddress();

    String cryptoTransactionHash = coinbaseProTransfer.getDetails().getCryptoTransactionHash();
    String transactionHash = adaptTransactionHash(currency.getSymbol(), cryptoTransactionHash);

    return new FundingRecord(
        address,
        coinbaseProTransfer.getDetails().getDestinationTag(),
        timestamp,
        currency,
        coinbaseProTransfer.amount(),
        coinbaseProTransfer.getId(),
        transactionHash,
        coinbaseProTransfer.type(),
        status,
        null,
        null,
        null);
  }

  // crypto_transaction_link: "https://etherscan.io/tx/0x{{txId}}"
  private static String adaptTransactionHash(String currency, String transactionHash) {
    switch (currency) {
      case "ZRX":
      case "BAT":
      case "LOOM":
      case "CVC":
      case "DNT":
      case "MANA":
      case "GNT":
      case "REP":
      case "LINK":
      case "ETH":
      case "ETC":
      case "USDC":
      case "DAI":
      case "ZIL":
      case "MKR":
        transactionHash = "0x" + transactionHash;
        break;
    }
    return transactionHash;
  }
}
