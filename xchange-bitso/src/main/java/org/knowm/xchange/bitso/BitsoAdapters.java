package org.knowm.xchange.bitso;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.knowm.xchange.bitso.dto.account.BitsoBalance;
import org.knowm.xchange.bitso.dto.marketdata.BitsoOrderBook;
import org.knowm.xchange.bitso.dto.marketdata.BitsoTicker;
import org.knowm.xchange.bitso.dto.marketdata.BitsoTransaction;
import org.knowm.xchange.bitso.dto.trade.BitsoUserTransaction;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.marketdata.Trades.TradeSortType;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.dto.trade.UserTrades;
import org.knowm.xchange.utils.DateUtils;

public final class BitsoAdapters {

  private BitsoAdapters() {}

  public static Ticker adaptTicker(BitsoTicker t, CurrencyPair currencyPair) {

    return new Ticker.Builder()
        .currencyPair(currencyPair)
        .last(t.getLast())
        .bid(t.getBid())
        .ask(t.getAsk())
        .high(t.getHigh())
        .low(t.getLow())
        .vwap(t.getVwap())
        .volume(t.getVolume())
        .timestamp(t.getTimestamp().getTime())
        .build();
  }

  public static Wallet adaptWallet(BitsoBalance bitsoBalance) {
    // Adapt to XChange DTOs
    Balance mxnBalance =
        new Balance(
            Currency.MXN,
            bitsoBalance.getMxnBalance(),
            bitsoBalance.getMxnAvailable(),
            bitsoBalance.getMxnReserved());
    Balance btcBalance =
        new Balance(
            Currency.BTC,
            bitsoBalance.getBtcBalance(),
            bitsoBalance.getBtcAvailable(),
            bitsoBalance.getBtcReserved());

    return Wallet.Builder.from(Arrays.asList(mxnBalance, btcBalance)).build();
  }

  public static OrderBook adaptOrderBook(
      BitsoOrderBook bitsoOrderBook, CurrencyPair currencyPair, int timeScale) {

    List<LimitOrder> asks =
        createOrders(currencyPair, Order.OrderType.ASK, bitsoOrderBook.getAsks());
    List<LimitOrder> bids =
        createOrders(currencyPair, Order.OrderType.BID, bitsoOrderBook.getBids());
    Date date =
        new Date(
            bitsoOrderBook.getTimestamp()
                * timeScale); // polled order books provide a timestamp in seconds, stream in ms
    return new OrderBook(date.getTime(), asks, bids);
  }

  public static List<LimitOrder> createOrders(
      CurrencyPair currencyPair, Order.OrderType orderType, List<List<Double>> orders) {

    List<LimitOrder> limitOrders = new ArrayList<>();
    for (List<Double> ask : orders) {
      checkArgument(
          ask.size() == 2, "Expected a pair (price, amount) but got {0} elements.", ask.size());
      limitOrders.add(createOrder(currencyPair, ask, orderType));
    }
    return limitOrders;
  }

  public static LimitOrder createOrder(
      CurrencyPair currencyPair, List<Double> priceAndAmount, Order.OrderType orderType) {

    return new LimitOrder(
        orderType, priceAndAmount.get(1), currencyPair, "", null, priceAndAmount.get(0));
  }

  /**
   * Adapts a Transaction[] to a Trades Object
   *
   * @param transactions The Bitso transactions
   * @param currencyPair (e.g. BTC/MXN)
   * @return The XChange Trades
   */
  public static Trades adaptTrades(BitsoTransaction[] transactions, CurrencyPair currencyPair) {

    List<Trade> trades = new ArrayList<>();
    long lastTradeId = 0;
    for (BitsoTransaction tx : transactions) {
      Order.OrderType type;
      switch (tx.getSide()) {
        case "buy":
          type = Order.OrderType.ASK;
          break;
        case "sell":
          type = Order.OrderType.BID;
          break;
        default:
          type = null;
      }
      final long tradeId = tx.getTid();
      if (tradeId > lastTradeId) {
        lastTradeId = tradeId;
      }
      trades.add(
          new Trade(
              type,
              tx.getAmount(),
              currencyPair,
              tx.getPrice(),
              DateUtils.fromMillisUtc(tx.getDate() * 1000L).getTime(),
              String.valueOf(tradeId)));
    }

    return new Trades(trades, lastTradeId, TradeSortType.SortByID);
  }

  public static void checkArgument(boolean argument, String msgPattern, Object... msgArgs) {

    if (!argument) {
      throw new IllegalArgumentException(MessageFormat.format(msgPattern, msgArgs));
    }
  }

  public static UserTrades adaptTradeHistory(BitsoUserTransaction[] bitsoUserTransactions) {

    List<UserTrade> trades = new ArrayList<>();
    long lastTradeId = 0;
    for (BitsoUserTransaction bitsoUserTransaction : bitsoUserTransactions) {
      if (bitsoUserTransaction
          .getType()
          .equals(
              BitsoUserTransaction.TransactionType
                  .trade)) { // skip account deposits and withdrawals.
        boolean sell = bitsoUserTransaction.getMxn() > 0.0;
        Order.OrderType orderType = sell ? Order.OrderType.ASK : Order.OrderType.BID;
        Double originalAmount = bitsoUserTransaction.getBtc();
        Double price = Math.abs(bitsoUserTransaction.getPrice());
        Date timestamp = BitsoUtils.parseDate(bitsoUserTransaction.getDatetime());
        long transactionId = bitsoUserTransaction.getId();
        if (transactionId > lastTradeId) {
          lastTradeId = transactionId;
        }
        final String tradeId = String.valueOf(transactionId);
        final String orderId = String.valueOf(bitsoUserTransaction.getOrderId());
        final Double feeAmount = bitsoUserTransaction.getFee();
        final CurrencyPair currencyPair = new CurrencyPair(Currency.BTC, Currency.MXN);

        String feeCurrency =
            sell ? currencyPair.counter.getCurrencyCode() : currencyPair.base.getCurrencyCode();
        UserTrade trade =
            new UserTrade(
                orderType,
                originalAmount,
                currencyPair,
                price,
                timestamp.getTime(),
                tradeId,
                orderId,
                feeAmount,
                Currency.getInstance(feeCurrency));
        trades.add(trade);
      }
    }

    return new UserTrades(trades, lastTradeId, Trades.TradeSortType.SortByID);
  }
}
