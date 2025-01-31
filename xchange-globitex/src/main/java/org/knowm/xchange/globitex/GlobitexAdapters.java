package org.knowm.xchange.globitex;

import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.account.Fee;
import org.knowm.xchange.dto.account.Wallet;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.dto.meta.CurrencyMetaData;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.meta.ExchangeMetaData;
import org.knowm.xchange.dto.meta.FeeTier;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.OpenOrders;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.dto.trade.UserTrades;
import org.knowm.xchange.globitex.dto.account.GlobitexAccounts;
import org.knowm.xchange.globitex.dto.marketdata.*;
import org.knowm.xchange.globitex.dto.trade.GlobitexActiveOrders;
import org.knowm.xchange.globitex.dto.trade.GlobitexUserTrade;
import org.knowm.xchange.globitex.dto.trade.GlobitexUserTrades;
import org.knowm.xchange.utils.jackson.CurrencyPairDeserializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobitexAdapters {

    public static String adaptCurrencyPairToGlobitexSymbol(CurrencyPair currencyPair) {
        String symbol = currencyPair.toString().replace("/", "");
        return convertBTCtoXBT(symbol);
    }

    private static CurrencyPair adaptGlobitexSymbolToCurrencyPair(GlobitexSymbol globitexSymbol) {
        return new CurrencyPair(
                convertXBTtoBTC(globitexSymbol.getCommodity()),
                convertXBTtoBTC(globitexSymbol.getCurrency()));
    }

    private static String convertBTCtoXBT(String symbol) {
        return (symbol.contains("BTC")) ? symbol.replace("BTC", "XBT") : symbol;
    }

    private static String convertXBTtoBTC(String symbol) {
        return (symbol.contains("XBT")) ? symbol.replace("XBT", "BTC") : symbol;
    }

    public static String adaptOrderType(Order.OrderType orderType) {
        return (orderType.equals(Order.OrderType.ASK)) ? "sell" : "buy";
    }
    //  private static CurrencyPair adaptGlobitexSymbolToCurrencyPair(
    //      String symbol, Map<Currency, CurrencyMetaData> currencies) {
    //    String counter = "";
    //
    //    for (Currency currency : currencies.keySet()) {
    //      if (symbol.endsWith(currency.toString())) {
    //        counter = currency.toString();
    //      }
    //    }
    //    if (counter.equals("")) {
    //      throw new ExchangeException("The symbol " + symbol + " doesn't exists in the exchange!");
    //    }
    //
    //    return new CurrencyPair(symbol.substring(0, symbol.length() - counter.length()), counter);
    //  }

    public static Trades adaptToTrades(GlobitexTrades globitexTrades, CurrencyPair currencyPair) {
        List<Trade> trades = new ArrayList<>();

        globitexTrades
                .getRecentTrades()
                .forEach(globitexTrade -> trades.add(adaptToTrade(globitexTrade, currencyPair)));

        return new Trades(trades, Trades.TradeSortType.SortByTimestamp);
    }

    private static Trade adaptToTrade(GlobitexTrade globitexTrade, CurrencyPair currencyPair) {
        return new Trade(
                (globitexTrade.getSide().equals("sell") ? Order.OrderType.ASK : Order.OrderType.BID),
                globitexTrade.getAmount(),
                currencyPair,
                globitexTrade.getPrice(),
                globitexTrade.getTimestamp(),
                String.valueOf(globitexTrade.getTid()));
    }

    public static Ticker adaptToTicker(GlobitexTicker globitexTicker) {
        String symbol = convertXBTtoBTC(globitexTicker.getSymbol());

        return new Ticker.Builder()
                .ask(globitexTicker.getAsk())
                .bid(globitexTicker.getBid())
                .high(globitexTicker.getHigh())
                .low(globitexTicker.getLow())
                .open(globitexTicker.getOpen())
                .quoteVolume(globitexTicker.getVolumeQuote())
                .volume(globitexTicker.getVolume())
                .currencyPair(CurrencyPairDeserializer.getCurrencyPairFromString(symbol))
                .build();
    }

    public static List<Ticker> adaptToListTicker(GlobitexTickers globitexTickers) {
        List<Ticker> tickers = new ArrayList<>();
        globitexTickers
                .getGlobitexTickerList()
                .forEach(globitexTicker -> tickers.add(adaptToTicker(globitexTicker)));
        return tickers;
    }

    public static OrderBook adaptToOrderBook(
            GlobitexOrderBook globitexOrderBook, CurrencyPair currencyPair) {
        List<LimitOrder> asks = new ArrayList<>();
        List<LimitOrder> bids = new ArrayList<>();

        globitexOrderBook
                .getAsks()
                .forEach(
                        globitexOrder -> {
                            asks.add(adaptToLimitOrder(globitexOrder, Order.OrderType.ASK, currencyPair));
                        });

        globitexOrderBook
                .getBids()
                .forEach(
                        globitexOrder -> {
                            bids.add(adaptToLimitOrder(globitexOrder, Order.OrderType.BID, currencyPair));
                        });

        return new OrderBook(null, asks, bids, true);
    }

    private static LimitOrder adaptToLimitOrder(
            GlobitexOrder globitexOrder, Order.OrderType orderType, CurrencyPair currencyPair) {
        return new LimitOrder(
                orderType, globitexOrder.getVolume(), currencyPair, null, null, globitexOrder.getPrice());
    }

    public static AccountInfo adaptToAccountInfo(GlobitexAccounts globitexAccounts) {

        return new AccountInfo(
                globitexAccounts.getAccounts().get(0).getAccount(), adaptToWallet(globitexAccounts));
    }

    private static Wallet adaptToWallet(GlobitexAccounts globitexAccounts) {
        List<Balance> balances = new ArrayList<>();

        globitexAccounts
                .getAccounts()
                .get(0)
                .getBalance()
                .forEach(
                        globitexBalance -> {
                            Balance balance =
                                    new Balance(
                                            new Currency(convertXBTtoBTC(globitexBalance.getCurrency())),
                                            globitexBalance.getAvailable() + (globitexBalance.getReserved()),
                                            globitexBalance.getAvailable(),
                                            globitexBalance.getReserved());

                            balances.add(balance);
                        });

        return Wallet.Builder.from(balances)
                .id(globitexAccounts.getAccounts().get(0).getAccount())
                .name(globitexAccounts.getAccounts().get(0).getAccount())
                .build();
    }

    public static UserTrades adaptToUserTrades(GlobitexUserTrades globitexUserTrades) {
        List<UserTrade> userTrades = new ArrayList<>();

        globitexUserTrades
                .getUserTrades()
                .forEach(globitexUserTrade -> userTrades.add(adaptToUserTrade(globitexUserTrade)));

        return new UserTrades(userTrades, Trades.TradeSortType.SortByTimestamp);
    }

    private static UserTrade adaptToUserTrade(GlobitexUserTrade globitexUserTrade) {
        return new UserTrade(
                (globitexUserTrade.getSide().equals("sell") ? Order.OrderType.ASK : Order.OrderType.BID),
                globitexUserTrade.getQuantity(),
                CurrencyPairDeserializer.getCurrencyPairFromString(
                        convertXBTtoBTC(globitexUserTrade.getSymbol())),
                globitexUserTrade.getPrice(),
                globitexUserTrade.getTimestamp(),
                String.valueOf(globitexUserTrade.getOriginalOrderId()),
                globitexUserTrade.getClientOrderId(),
                globitexUserTrade.getFee(),
                new Currency(convertXBTtoBTC(globitexUserTrade.getFeeCurrency())));
    }

    public static OpenOrders adaptToOpenOrders(GlobitexActiveOrders globitexActiveOrders) {
        List<LimitOrder> openOrders = new ArrayList<>();

        globitexActiveOrders
                .getOrders()
                .forEach(
                        globitexActiveOrder -> {
                            openOrders.add(
                                    new LimitOrder(
                                            (globitexActiveOrder.getSide().equals("sell")
                                                    ? Order.OrderType.ASK
                                                    : Order.OrderType.BID),
                                            globitexActiveOrder.getOrderQuantity(),
                                            CurrencyPairDeserializer.getCurrencyPairFromString(globitexActiveOrder.getSymbol()),
                                            globitexActiveOrder.getClientOrderId(),
                                            globitexActiveOrder.getLastTimestamp(),
                                            globitexActiveOrder.getOrderPrice(),
                                            globitexActiveOrder.getAvgPrice(),
                                            globitexActiveOrder.getCumQuantity(),
                                            null,
                                            Order.OrderStatus.valueOf(globitexActiveOrder.getOrderStatus().toUpperCase())));
                        });

        return new OpenOrders(openOrders);
    }

    public static ExchangeMetaData adaptToExchangeMetaData(GlobitexSymbols globitexSymbols) {

        Map<CurrencyPair, CurrencyPairMetaData> currencyPairs = new HashMap<>();
        Map<Currency, CurrencyMetaData> currencies = new HashMap<>();
        List<FeeTier> resultFeeTiers = new ArrayList<FeeTier>();
        resultFeeTiers.add(new FeeTier(1d, new Fee(0.001, 0.002)));

        globitexSymbols
                .getSymbols()
                .forEach(
                        globitexSymbol -> {
                            currencyPairs.put(
                                    adaptGlobitexSymbolToCurrencyPair(globitexSymbol),
                                    new CurrencyPairMetaData(
                                            0.002,
                                            globitexSymbol.getSizeMin(),
                                            null,
                                            8,
                                            resultFeeTiers.toArray(new FeeTier[0])));
                            currencies.put(
                                    new Currency(convertXBTtoBTC(globitexSymbol.getCurrency())),
                                    new CurrencyMetaData(8, null));
                            currencies.put(
                                    new Currency(convertXBTtoBTC(globitexSymbol.getCommodity())),
                                    new CurrencyMetaData(8, null));
                        });

        return new ExchangeMetaData(currencyPairs, currencies, null, null, null);
    }
}
