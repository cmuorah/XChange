package org.knowm.xchange.coinegg;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.coinegg.dto.accounts.CoinEggBalance;
import org.knowm.xchange.coinegg.dto.marketdata.CoinEggOrders;
import org.knowm.xchange.coinegg.dto.marketdata.CoinEggOrders.CoinEggOrder;
import org.knowm.xchange.coinegg.dto.marketdata.CoinEggTicker;
import org.knowm.xchange.coinegg.dto.marketdata.CoinEggTrade;
import org.knowm.xchange.coinegg.dto.marketdata.CoinEggTrade.Type;
import org.knowm.xchange.coinegg.dto.trade.CoinEggTradeAdd;
import org.knowm.xchange.coinegg.dto.trade.CoinEggTradeCancel;
import org.knowm.xchange.coinegg.dto.trade.CoinEggTradeView;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.dto.trade.UserTrades;

public class CoinEggAdapters {

  public static Ticker adaptTicker(CoinEggTicker coinEggTicker, CurrencyPair currencyPair) {
    Double last = coinEggTicker.getLast();
    Double bid = coinEggTicker.getSell();
    Double ask = coinEggTicker.getBuy();
    Double high = coinEggTicker.getHigh();
    Double low = coinEggTicker.getLow();
    Double volume = coinEggTicker.getVolume();

    return new Ticker.Builder()
        .currencyPair(currencyPair)
        .last(last)
        .bid(bid)
        .ask(ask)
        .high(high)
        .low(low)
        .volume(volume)
        .build();
  }

  public static LimitOrder adaptOrder(
      CoinEggOrder order, OrderType type, CurrencyPair currencyPair) {
    Double quantity = order.getQuantity();
    Double price = order.getPrice();

    return new LimitOrder.Builder(type, currencyPair)
        .originalAmount(quantity)
        .limitPrice(price)
        .build();
  }

  public static OrderBook adaptOrders(CoinEggOrders coinEggOrders, CurrencyPair currencyPair) {

    List<LimitOrder> asks =
        Stream.of(coinEggOrders.getAsks())
            .map(order -> adaptOrder(order, OrderType.ASK, currencyPair))
            .collect(Collectors.toList());

    List<LimitOrder> bids =
        Stream.of(coinEggOrders.getBids())
            .map(order -> adaptOrder(order, OrderType.BID, currencyPair))
            .collect(Collectors.toList());

    return new OrderBook(null, asks, bids);
  }

  public static Trade adaptTrade(CoinEggTrade coinEggTrade, CurrencyPair currencyPair) {
    return new Trade.Builder()
        .currencyPair(currencyPair)
        .id(String.valueOf(coinEggTrade.getTransactionID()))
        .type(coinEggTrade.getOrderType())
        .price(coinEggTrade.getPrice())
        .originalAmount(coinEggTrade.getAmount())
        .build();
  }

  public static Trades adaptTrades(CoinEggTrade[] coinEggTrades, CurrencyPair currencyPair) {
    List<Trade> trades =
        Stream.of(coinEggTrades).map(t -> adaptTrade(t, currencyPair)).collect(Collectors.toList());

    return new Trades(trades);
  }

  // TODO: Implement XAS Currency
  public static AccountInfo adaptAccountInfo(CoinEggBalance coinEggBalance, Exchange exchange) {

    String userName = exchange.getExchangeSpecification().getUserName();
    Wallet btcWallet =
        Wallet.Builder.from(
                Collections.singletonList(new Balance(Currency.BTC, coinEggBalance.getBTCBalance())))
            .id(Currency.BTC.getCurrencyCode())
            .build();
    Wallet ethWallet =
        Wallet.Builder.from(
                Collections.singletonList(new Balance(Currency.ETH, coinEggBalance.getETHBalance())))
            .id(Currency.ETH.getCurrencyCode())
            .build();
    // Wallet xasWallet = new Wallet(new Balance(Currency.XAS, coinEggBalance.getXASBalance()));

    Set<Wallet> wallets = new HashSet<>();
    wallets.add(btcWallet);
    wallets.add(ethWallet);
    // wallets.add(xasWallet);

    return new AccountInfo(userName, null, wallets);
  }

  // TODO: Cleanup Code
  // TODO: Make Use Of Adapt Trade
  public static UserTrades adaptTradeHistory(CoinEggTradeView coinEggTradeView) {
    List<UserTrade> trades = new ArrayList<>();
    Trade trade =
        new Trade.Builder()
            // .currencyPair(null)
            .id(String.valueOf(coinEggTradeView.getID()))
            .type(coinEggTradeView.getType() == Type.BUY ? OrderType.ASK : OrderType.BID)
            .price(coinEggTradeView.getPrice())
            .originalAmount(coinEggTradeView.getAmountOriginal())
            .timestamp(coinEggTradeView.getDateTime().getTime())
            .build();

    trades.add((UserTrade) UserTrade.Builder.from(trade).build());

    return new UserTrades(trades, null);
  }

  public static String adaptTradeAdd(CoinEggTradeAdd coinEggTradeAdd) {
    return String.valueOf(coinEggTradeAdd.getID());
  }

  public static boolean adaptTradeCancel(CoinEggTradeCancel coinEggTradeCancel) {
    return coinEggTradeCancel.getResult();
  }
}
