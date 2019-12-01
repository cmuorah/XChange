package org.knowm.xchange.coinsuper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.knowm.xchange.coinsuper.dto.CoinsuperResponse;
import org.knowm.xchange.coinsuper.dto.account.CoinsuperUserAssetInfo;
import org.knowm.xchange.coinsuper.dto.marketdata.CoinsuperOrderbook;
import org.knowm.xchange.coinsuper.dto.marketdata.CoinsuperOrderbook.Ask;
import org.knowm.xchange.coinsuper.dto.marketdata.CoinsuperOrderbook.Bid;
import org.knowm.xchange.coinsuper.dto.marketdata.CoinsuperTicker;
import org.knowm.xchange.coinsuper.dto.trade.CoinsuperGenericOrder;
import org.knowm.xchange.coinsuper.dto.trade.OrderDetail;
import org.knowm.xchange.coinsuper.dto.trade.OrderList;
import org.knowm.xchange.coinsuper.utils.CommonUtil;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderStatus;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trades.TradeSortType;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.dto.trade.UserTrades;

public class CoinsuperAdapters {

  private CoinsuperAdapters() {}

  /**
   * @param pair
   * @return
   */
  public static String toSymbol(CurrencyPair pair) {
    if (pair.equals(CurrencyPair.IOTA_BTC)) {
      return "IOTABTC";
    }
    return pair.base.getCurrencyCode() + pair.counter.getCurrencyCode();
  }

  /**
   * @param currency
   * @return
   */
  public static String toSymbol(Currency currency) {
    if (Currency.IOT.equals(currency)) {
      return "IOTA";
    }
    return currency.getSymbol();
  }

  public static String toMarket(CurrencyPair currencyPair) {
    return currencyPair.base.getCurrencyCode() + currencyPair.counter.getCurrencyCode();
  }

  /**
   * @param coinsuperTicker
   * @return
   */
  public static Ticker convertTicker(CoinsuperTicker coinsuperTicker) {
    return new Ticker.Builder()
        .ask(coinsuperTicker.getPrice())
        .bid(coinsuperTicker.getPrice())
        .high(coinsuperTicker.getPrice())
        .low(coinsuperTicker.getPrice())
        .volume(coinsuperTicker.getVolume())
        .last(coinsuperTicker.getPrice())
        .timestamp(CommonUtil.timeStampToDate(coinsuperTicker.getTimestamp()).getTime())
        .build();
  }

  public static OrderBook adaptOrderBook(
      CoinsuperResponse<CoinsuperOrderbook> coinsuperOrderbook, CurrencyPair currencyPair) {
    List<LimitOrder> asks = new ArrayList<LimitOrder>();
    List<LimitOrder> bids = new ArrayList<LimitOrder>();

    for (Ask coinsuperAsk : coinsuperOrderbook.getData().getResult().getAsks()) {
      asks.add(
          new LimitOrder(
              OrderType.ASK,
              new Double(coinsuperAsk.getQuantity()),
              currencyPair,
              null,
              null,
              new Double(coinsuperAsk.getLimitPrice())));
    }

    for (Bid coinsuperBid : coinsuperOrderbook.getData().getResult().getBids()) {
      bids.add(
          new LimitOrder(
              OrderType.BID,
              new Double(coinsuperBid.getQuantity()),
              currencyPair,
              null,
              null,
              new Double(coinsuperBid.getLimitPrice())));
    }

    return new OrderBook(System.currentTimeMillis(), asks, bids);
  }

  /**
   * @param coinsuperBalances
   * @return
   */
  public static AccountInfo convertBalance(
      CoinsuperResponse<CoinsuperUserAssetInfo> coinsuperBalances) {
    List<Balance> balances = new ArrayList<Balance>();

    ArrayList<String> currencies =
        new ArrayList<String>(
            Arrays.asList(
                "AAB", "AMR", "BCH", "BTC", "BUC", "CCCX", "CEEK", "CEN", "DASH", "DX", "EOS",
                "ETC", "ETH", "ETK", "HOLD", "IOVC", "LTC", "MEDX", "NEO", "NEWOS", "OMG", "PRL",
                "QTUM", "RLM", "TEST", "THRT", "USD", "UST", "XCCC", "XEM", "XRP"));

    for (String currency : currencies) {
      balances.add(
          new Balance.Builder()
              .currency(Currency.getInstance(currency))
              .available(
                  coinsuperBalances
                      .getData()
                      .getResult()
                      .getAsset()
                      .getAnyAssetBalance(currency)
                      .getAvailable())
              .total(
                  coinsuperBalances
                      .getData()
                      .getResult()
                      .getAsset()
                      .getAnyAssetBalance(currency)
                      .getTotal())
              .frozen(new Double("0"))
              .build());
    }

    return new AccountInfo(Wallet.Builder.from(balances).build());
  }

  /**
   * There is no method to discern market versus limit order type - so this returns a generic
   * GenericOrder as a status
   *
   * @param
   * @return
   */
  public static CoinsuperGenericOrder adaptOrder(String orderId, OrderList orderList) {
    Double averagePrice = new Double(orderList.getPriceLimit());
    Double cumulativeAmount = new Double(orderList.getQuantity());
    Double totalFee = new Double(orderList.getFee());

    Double amount = new Double(orderList.getQuantity());
    OrderType action = OrderType.ASK;
    if (orderList.getAction().equals("Buy")) {
      action = OrderType.BID;
    }
    // Order Status UNDEAL:Not Executed，PARTDEAL:Partially Executed，DEAL:Order Complete，CANCEL:
    // Canceled
    OrderStatus orderStatus = OrderStatus.PENDING_NEW;
    if (orderList.getState().equals("UNDEAL")) {
      orderStatus = OrderStatus.PENDING_NEW;
    } else if (orderList.getState().equals("Canceled")) {
      orderStatus = OrderStatus.CANCELED;
    }

    CoinsuperGenericOrder coinsuperGenericOrder =
        new CoinsuperGenericOrder(
            action,
            amount,
            new CurrencyPair(orderList.getSymbol()),
            orderId,
            CommonUtil.timeStampToDate(orderList.getUtcCreate()),
            averagePrice,
            cumulativeAmount,
            totalFee,
            orderStatus);

    return coinsuperGenericOrder;
  }

  public static UserTrades adaptTradeHistory(CoinsuperResponse<List<OrderDetail>> OrderDetails) {
    List<UserTrade> trades = new ArrayList<>();
    long lastTradeId = 0;

    for (OrderDetail orderDetail : OrderDetails.getData().getResult()) {
      OrderType orderType = OrderType.BID;

      if (orderDetail.getAction().equals("SELL")) {
        orderType = OrderType.ASK;
      }

      UserTrade trade =
          new UserTrade(
              orderType,
              Math.abs(orderDetail.getAmount()),
              new CurrencyPair(orderDetail.getSymbol()),
              Math.abs(orderDetail.getPriceLimit()),
              System.currentTimeMillis(),
              Long.toString(orderDetail.getOrderNo()),
              Long.toString(orderDetail.getOrderNo()),
              orderDetail.getFee(),
              Currency.getInstance(orderDetail.getSymbol().toUpperCase()));
      lastTradeId = orderDetail.getOrderNo();
      trades.add(trade);
    }
    return new UserTrades(trades, lastTradeId, TradeSortType.SortByID);
  }
}
