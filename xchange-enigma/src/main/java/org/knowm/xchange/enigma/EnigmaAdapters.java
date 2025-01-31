package org.knowm.xchange.enigma;

import static org.knowm.xchange.utils.jackson.CurrencyPairDeserializer.getCurrencyPairFromString;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.enigma.dto.account.EnigmaBalance;
import org.knowm.xchange.enigma.dto.marketdata.EnigmaOrderBook;
import org.knowm.xchange.enigma.dto.marketdata.EnigmaTicker;
import org.knowm.xchange.enigma.dto.marketdata.EnigmaTransaction;
import org.knowm.xchange.enigma.dto.trade.EnigmaExecutedQuote;
import org.knowm.xchange.enigma.dto.trade.EnigmaOrderSubmission;

public final class EnigmaAdapters {

  private EnigmaAdapters() {}

  public static AccountInfo adaptAccountInfo(EnigmaBalance enigmaBalance, String userName) {

    List<Balance> balances =
        enigmaBalance.getBalances().entrySet().stream()
            .map(
                balanceEntry ->
                    new Balance(
                        Currency.getInstance(balanceEntry.getKey().toUpperCase()),
                        balanceEntry.getValue()))
            .collect(Collectors.toList());

    return new AccountInfo(userName, Wallet.Builder.from(balances).build());
  }

  public static Trade adaptTrade(EnigmaExecutedQuote enigmaTrade) {

    return new Trade.Builder()
        .currencyPair(getCurrencyPairFromString(enigmaTrade.getProductName()))
        .price(enigmaTrade.getPrice())
        .originalAmount(enigmaTrade.getQuantity())
        .timestamp(enigmaTrade.getCreatedAt().getTime())
        .type(enigmaTrade.getSide().equals("sell") ? Order.OrderType.ASK : Order.OrderType.BID)
        .build();
  }

  public static Trade adaptTrade(EnigmaOrderSubmission enigmaTrade) {
    return new Trade.Builder()
        .id(String.valueOf(enigmaTrade.getId()))
        .currencyPair(getCurrencyPairFromString(enigmaTrade.getProductName()))
        .price(enigmaTrade.getPrice())
        .originalAmount(enigmaTrade.getQuantity())
        .timestamp(enigmaTrade.getSent().getTime())
        .type(enigmaTrade.getSide().equals("sell") ? Order.OrderType.ASK : Order.OrderType.BID)
        .build();
  }

  public static Trades adaptTrades(List<Trade> trades) {
    return new Trades(trades);
  }

  public static Trades adaptTrades(EnigmaTransaction[] transactions, CurrencyPair currencyPair) {
    return new Trades(
        Arrays.stream(transactions)
            .filter(
                enigmaTransaction ->
                    enigmaTransaction
                        .getProductName()
                        .equals(currencyPair.toString().replace("/", "-")))
            .map(
                enigmaTransaction ->
                    new Trade.Builder()
                        .id(String.valueOf(enigmaTransaction.getOrderId()))
                        .currencyPair(currencyPair)
                        .price(enigmaTransaction.getPrice())
                        .originalAmount(enigmaTransaction.getQuantity())
                        .timestamp(enigmaTransaction.getSentAt().getTime())
                        .type(
                            enigmaTransaction.getSide().equals("sell")
                                ? Order.OrderType.ASK
                                : Order.OrderType.BID)
                        .build())
            .collect(Collectors.toList()));
  }

  public static Ticker adaptTicker(EnigmaTicker enigmaTicker, CurrencyPair currencyPair) {

    Double open = enigmaTicker.getOpen();
    Double last = enigmaTicker.getLast();
    Double bid = enigmaTicker.getBid();
    Double ask = enigmaTicker.getAsk();
    Double bidSize = enigmaTicker.getBidQty();
    Double askSize = enigmaTicker.getAskQty();

    return new Ticker.Builder()
        .currencyPair(currencyPair)
        .open(open)
        .last(last)
        .bid(bid)
        .ask(ask)
        .bidSize(bidSize)
        .askSize(askSize)
        .build();
  }

  public static OrderBook adaptOrderBook(
      EnigmaOrderBook enigmaOrderBook, CurrencyPair currencyPair) {
    List<LimitOrder> asks =
        createOrders(currencyPair, Order.OrderType.ASK, enigmaOrderBook.getAsks());
    List<LimitOrder> bids =
        createOrders(currencyPair, Order.OrderType.BID, enigmaOrderBook.getBids());
    return new OrderBook(enigmaOrderBook.getTimestamp().getTime(), asks, bids);
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

  public static void checkArgument(boolean argument, String msgPattern, Object... msgArgs) {

    if (!argument) {
      throw new IllegalArgumentException(MessageFormat.format(msgPattern, msgArgs));
    }
  }
}
