package org.knowm.xchange.bleutrade.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.knowm.xchange.bleutrade.BleutradeTestData;
import org.knowm.xchange.bleutrade.dto.account.BleutradeBalance;
import org.knowm.xchange.bleutrade.dto.account.BleutradeDepositAddress;
import org.knowm.xchange.bleutrade.dto.marketdata.BleutradeCurrency;
import org.knowm.xchange.bleutrade.dto.marketdata.BleutradeLevel;
import org.knowm.xchange.bleutrade.dto.marketdata.BleutradeMarket;
import org.knowm.xchange.bleutrade.dto.marketdata.BleutradeOrderBook;
import org.knowm.xchange.bleutrade.dto.marketdata.BleutradeTicker;
import org.knowm.xchange.bleutrade.dto.marketdata.BleutradeTrade;
import org.knowm.xchange.bleutrade.dto.trade.BleutradeOpenOrder;
import org.knowm.xchange.bleutrade.dto.trade.BleutradeOrderId;

public class BleutradeServiceTestSupport extends BleutradeTestData {

  protected static final String SPECIFICATION_USERNAME = "admin";
  protected static final String SPECIFICATION_API_KEY = "publicKey";
  protected static final String SPECIFICATION_SECRET_KEY = "secretKey";
  protected static final String EXPECTED_BLEUTRADE_TICKER_STR =
      "Ticker [currencyPair=BLEU/BTC, open=null, last=0.00101977, bid=0.00100000, ask=0.00101977, high=0.00105000, low=0.00086000,avg=0.00103455, volume=2450.97496015, quoteVolume=null, timestamp=1406632770000, bidSize=null, askSize=null]";
  protected static final String BLEUTRADE_BALANCE_STR =
      "BleutradeBalance [Currency=AUD, Balance=40.00000000, Available=10.00000000, "
          + "Pending=30.00000000, CryptoAddress=null, IsActive=true, additionalProperties={}]";
  protected static final BleutradeDepositAddress BLEUTRADE_DEPOSIT_ADDRESS =
      createDepositAddress("AUD", "Deposit Address Details");

  protected static List<BleutradeOpenOrder> expectedBleutradeOpenOrdersList() {
    return Arrays.asList(
        createBleutradeOpenOrder(
            "65489",
            "LTC_BTC",
            "BUY",
            new Double("20.00000000"),
            new Double("5.00000000"),
            "0.16549400",
            new Double("0.01268311"),
            "OPEN",
            "2014-08-03 13:55:20",
            "My optional comment, eg function id #123"),
        createBleutradeOpenOrder(
            "65724",
            "DOGE_BTC",
            "SELL",
            new Double("150491.98700000"),
            new Double("795.00000000"),
            "0.04349400",
            new Double("0.00000055"),
            "OPEN",
            "2014-07-29 18:45:17",
            "Function #123 Connect #456"));
  }

  protected static List<BleutradeTicker> expectedBleutradeTicker() {
    return Collections.unmodifiableList(
        Arrays.asList(
            createBleutradeTicker(
                "BLEU_BTC",
                new Double("0.00095000"),
                new Double("0.00105000"),
                new Double("0.00086000"),
                new Double("0.00101977"),
                new Double("0.00103455"),
                new Double("2450.97496015"),
                new Double("2.40781647"),
                "2014-07-29 11:19:30",
                new Double("0.00100000"),
                new Double("0.00101977"),
                true)));
  }

  protected static List<BleutradeTicker> expectedBleutradeTickers() {
    return Collections.unmodifiableList(
        Arrays.asList(
            createBleutradeTicker(
                "BLEU_BTC",
                new Double("0.00095000"),
                new Double("0.00105000"),
                new Double("0.00086000"),
                new Double("0.00101977"),
                new Double("0.00103455"),
                new Double("2450.97496015"),
                new Double("2.40781647"),
                "2014-07-29 11:19:30",
                new Double("0.00100000"),
                new Double("0.00101977"),
                true),
            createBleutradeTicker(
                "LTC_BTC",
                new Double("0.00095000"),
                new Double("0.01333000"),
                new Double("0.01167001"),
                new Double("0.01333000"),
                new Double("0.01235000"),
                new Double("14.46077245"),
                new Double("0.18765956"),
                "2014-07-29 11:48:02",
                new Double("0.01268311"),
                new Double("0.01333000"),
                true)));
  }

  protected static String[] expectedBleutradeTickersStr() {
    return new String[] {
      "BleutradeTicker [MarketName=BLEU_BTC, PrevDay=0.00095000, High=0.00105000, Low=0.00086000, "
          + "Last=0.00101977, Average=0.00103455, Volume=2450.97496015, BaseVolume=2.40781647, "
          + "TimeStamp=2014-07-29 11:19:30, Bid=0.00100000, Ask=0.00101977, IsActive=true, "
          + "additionalProperties={}]",
      "BleutradeTicker [MarketName=LTC_BTC, PrevDay=0.00095000, High=0.01333000, Low=0.01167001, "
          + "Last=0.01333000, Average=0.01235000, Volume=14.46077245, BaseVolume=0.18765956, "
          + "TimeStamp=2014-07-29 11:48:02, Bid=0.01268311, Ask=0.01333000, IsActive=true, "
          + "additionalProperties={}]"
    };
  }

  protected static List<BleutradeLevel> expectedBleutradeLevelBuys() {
    return Collections.unmodifiableList(
        Arrays.asList(
            createBleutradeLevel(new Double("4.99400000"), new Double("3.00650900")),
            createBleutradeLevel(new Double("50.00000000"), new Double("3.50000000"))));
  }

  protected static List<BleutradeLevel> expectedBleutradeLevelSells() {
    return Collections.unmodifiableList(
        Arrays.asList(
            createBleutradeLevel(new Double("12.44147454"), new Double("5.13540000")),
            createBleutradeLevel(new Double("100.00000000"), new Double("6.25500000")),
            createBleutradeLevel(new Double("30.00000000"), new Double("6.75500001")),
            createBleutradeLevel(new Double("13.49989999"), new Double("6.76260099"))));
  }

  protected static List<BleutradeTrade> expectedBleutradeTrades() {
    return Collections.unmodifiableList(
        Arrays.asList(
            createBleutradeTrade(
                "2014-07-29 18:08:00",
                new Double("654971.69417461"),
                new Double("0.00000055"),
                new Double("0.360234432"),
                "BUY"),
            createBleutradeTrade(
                "2014-07-29 18:12:35",
                new Double("120.00000000"),
                new Double("0.00006600"),
                new Double("0.360234432"),
                "SELL")));
  }

  protected static List<BleutradeCurrency> expectedBleutradeCurrencies() {
    return Collections.unmodifiableList(
        Arrays.asList(
            createBleutradeCurrency("BTC", "Bitcoin", 2, new Double("0.00080000"), true, "BITCOIN"),
            createBleutradeCurrency(
                "LTC", "Litecoin", 4, new Double("0.02000000"), true, "BITCOIN")));
  }

  protected static String[] expectedBleutradeCurrenciesStr() {
    return new String[] {
      "BleutradeCurrency [Currency=BTC, CurrencyLong=Bitcoin, MinConfirmation=2, TxFee=0.00080000, IsActive=true, "
          + "CoinType=BITCOIN, additionalProperties={}]",
      "BleutradeCurrency [Currency=LTC, CurrencyLong=Litecoin, MinConfirmation=4, TxFee=0.02000000, IsActive=true, "
          + "CoinType=BITCOIN, additionalProperties={}]"
    };
  }

  protected static List<BleutradeMarket> expectedBleutradeMarkets() {
    return Collections.unmodifiableList(
        Arrays.asList(
            createBleutradeMarket(
                "DOGE", "BTC", "Dogecoin", "Bitcoin", new Double("0.10000000"), "DOGE_BTC", true),
            createBleutradeMarket(
                "BLEU",
                "BTC",
                "Bleutrade Share",
                "Bitcoin",
                new Double("0.00000001"),
                "BLEU_BTC",
                true)));
  }

  protected static String[] expectedBleutradeMarketsStr() {
    return new String[] {
      "BleutradeMarket [MarketCurrency=DOGE, BaseCurrency=BTC, MarketCurrencyLong=Dogecoin, BaseCurrencyLong=Bitcoin, "
          + "MinTradeSize=0.10000000, MarketName=DOGE_BTC, IsActive=true, additionalProperties={}]",
      "BleutradeMarket [MarketCurrency=BLEU, BaseCurrency=BTC, MarketCurrencyLong=Bleutrade Share, "
          + "BaseCurrencyLong=Bitcoin, MinTradeSize=1E-8, MarketName=BLEU_BTC, IsActive=true, additionalProperties={}]"
    };
  }

  protected static List<BleutradeBalance> expectedBleutradeAccountInfo() {
    return Collections.unmodifiableList(
        Arrays.asList(
            createBalance(
                new Double("10.00000000"),
                "AUD",
                new Double("40.00000000"),
                new Double("30.00000000"),
                true),
            createBalance(
                new Double("40.00000000"),
                "BTC",
                new Double("100.00000000"),
                new Double("60.00000000"),
                false),
            createBalance(
                new Double("70.00000000"),
                "BLEU",
                new Double("160.00000000"),
                new Double("90.00000000"),
                true)));
  }

  protected static BleutradeBalance createBalance(
      Double available, String currency, Double balance, Double pending, Boolean isActive) {
    BleutradeBalance bleutradeBalance = new BleutradeBalance();
    bleutradeBalance.setAvailable(available);
    bleutradeBalance.setCurrency(currency);
    bleutradeBalance.setBalance(balance);
    bleutradeBalance.setPending(pending);
    bleutradeBalance.setIsActive(isActive);

    return bleutradeBalance;
  }

  protected static BleutradeDepositAddress createDepositAddress(String currency, String address) {
    BleutradeDepositAddress depositAddress = new BleutradeDepositAddress();
    depositAddress.setCurrency(currency);
    depositAddress.setAddress(address);

    return depositAddress;
  }

  protected static BleutradeTicker createBleutradeTicker(
      String marketName,
      Double prevDay,
      Double high,
      Double low,
      Double last,
      Double average,
      Double volume,
      Double baseVolume,
      String timestamp,
      Double bid,
      Double ask,
      Boolean isActive) {

    BleutradeTicker ticker = new BleutradeTicker();
    ticker.setMarketName(marketName);
    ticker.setPrevDay(prevDay);
    ticker.setHigh(high);
    ticker.setLow(low);
    ticker.setLast(last);
    ticker.setAverage(average);
    ticker.setVolume(volume);
    ticker.setBaseVolume(baseVolume);
    ticker.setTimeStamp(timestamp);
    ticker.setBid(bid);
    ticker.setAsk(ask);
    ticker.setIsActive(isActive);

    return ticker;
  }

  protected static BleutradeOrderBook createBleutradeOrderBook(
      List<BleutradeLevel> buy, List<BleutradeLevel> sell) {
    BleutradeOrderBook bleutradeOrderBook = new BleutradeOrderBook();
    bleutradeOrderBook.setBuy(buy);
    bleutradeOrderBook.setSell(sell);

    return bleutradeOrderBook;
  }

  protected static BleutradeLevel createBleutradeLevel(Double quantity, Double rate) {
    BleutradeLevel level = new BleutradeLevel();
    level.setQuantity(quantity);
    level.setRate(rate);

    return level;
  }

  protected static BleutradeTrade createBleutradeTrade(
      String timestamp, Double quantity, Double price, Double total, String orderType) {
    BleutradeTrade bleutradeTrade = new BleutradeTrade();
    bleutradeTrade.setTimeStamp(timestamp);
    bleutradeTrade.setQuantity(quantity);
    bleutradeTrade.setPrice(price);
    bleutradeTrade.setTotal(total);
    bleutradeTrade.setOrderType(orderType);

    return bleutradeTrade;
  }

  protected static BleutradeCurrency createBleutradeCurrency(
      String currency,
      String currencyLong,
      Integer minConfirmation,
      Double txFee,
      Boolean isActive,
      String coinType) {

    BleutradeCurrency bleutradeCurrency = new BleutradeCurrency();
    bleutradeCurrency.setCurrency(currency);
    bleutradeCurrency.setCurrencyLong(currencyLong);
    bleutradeCurrency.setMinConfirmation(minConfirmation);
    bleutradeCurrency.setTxFee(txFee);
    bleutradeCurrency.setIsActive(isActive);
    bleutradeCurrency.setCoinType(coinType);

    return bleutradeCurrency;
  }

  protected static BleutradeMarket createBleutradeMarket(
      String marketCurrency,
      String baseCurrency,
      String marketCurrencyLong,
      String baseCurrencyLong,
      Double minTradeSize,
      String marketName,
      Boolean isActive) {
    BleutradeMarket bleutradeMarket = new BleutradeMarket();
    bleutradeMarket.setMarketCurrency(marketCurrency);
    bleutradeMarket.setBaseCurrency(baseCurrency);
    bleutradeMarket.setMarketCurrencyLong(marketCurrencyLong);
    bleutradeMarket.setBaseCurrencyLong(baseCurrencyLong);
    bleutradeMarket.setMinTradeSize(minTradeSize);
    bleutradeMarket.setMarketName(marketName);
    bleutradeMarket.setIsActive(isActive);

    return bleutradeMarket;
  }

  protected static BleutradeOpenOrder createBleutradeOpenOrder(
      String orderId,
      String exchange,
      String type,
      Double quantity,
      Double quantityRemaining,
      String quantityBaseTraded,
      Double price,
      String status,
      String created,
      String comments) {
    BleutradeOpenOrder bleutradeOpenOrder = new BleutradeOpenOrder();
    bleutradeOpenOrder.setOrderId(orderId);
    bleutradeOpenOrder.setExchange(exchange);
    bleutradeOpenOrder.setType(type);
    bleutradeOpenOrder.setQuantity(quantity);
    bleutradeOpenOrder.setQuantityRemaining(quantityRemaining);
    bleutradeOpenOrder.setQuantityBaseTraded(quantityBaseTraded);
    bleutradeOpenOrder.setPrice(price);
    bleutradeOpenOrder.setStatus(status);
    bleutradeOpenOrder.setCreated(created);
    bleutradeOpenOrder.setComments(comments);

    return bleutradeOpenOrder;
  }

  protected static BleutradeOrderId createBleutradeOrderId(String orderId) {
    BleutradeOrderId bleutradeOrderId = new BleutradeOrderId();
    bleutradeOrderId.setOrderid(orderId);

    return bleutradeOrderId;
  }
}
