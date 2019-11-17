package org.knowm.xchange.simulated;

import static org.assertj.core.api.Assertions.assertThat;
import static org.knowm.xchange.currency.Currency.BTC;
import static org.knowm.xchange.currency.Currency.USD;
import static org.knowm.xchange.currency.CurrencyPair.BTC_USD;
import static org.knowm.xchange.dto.Order.OrderStatus.NEW;
import static org.knowm.xchange.dto.Order.OrderStatus.PARTIALLY_FILLED;
import static org.knowm.xchange.dto.Order.OrderType.ASK;
import static org.knowm.xchange.dto.Order.OrderType.BID;
import static org.knowm.xchange.simulated.SimulatedExchange.ACCOUNT_FACTORY_PARAM;
import static org.knowm.xchange.simulated.SimulatedExchange.ENGINE_FACTORY_PARAM;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.account.Balance;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.MarketOrder;
import org.knowm.xchange.dto.trade.OpenOrders;
import org.knowm.xchange.dto.trade.UserTrades;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exceptions.FundsExceededException;
import org.knowm.xchange.service.trade.params.TradeHistoryParamCurrencyPair;
import org.knowm.xchange.service.trade.params.orders.OpenOrdersParamCurrencyPair;

public class TestSimulatedExchange {

  private static final Double INITIAL_BALANCE = new Double(1000);

  private SimulatedExchange exchange;
  private MatchingEngineFactory matchingEngineFactory;
  private AccountFactory accountFactory;

  @Before
  public void setup() throws IOException {

    // By default, the matching engines are scoped to each instance of the Exchange. This ensures
    // that all instances share the same engine within the scope of each test.
    accountFactory = new AccountFactory();
    matchingEngineFactory = new MatchingEngineFactory(accountFactory);

    // As a market maker, fill the order book with buy/sell orders
    mockMarket();

    // This is what we'll use for trade testing
    ExchangeSpecification exchangeSpecification =
        new ExchangeSpecification(SimulatedExchange.class);
    exchangeSpecification.setApiKey("Tester");
    exchangeSpecification.setExchangeSpecificParametersItem(
        ENGINE_FACTORY_PARAM, matchingEngineFactory);
    exchangeSpecification.setExchangeSpecificParametersItem(ACCOUNT_FACTORY_PARAM, accountFactory);
    exchange = (SimulatedExchange) ExchangeFactory.INSTANCE.createExchange(exchangeSpecification);

    // Provide an initial balance
    exchange.getAccountService().deposit(USD, INITIAL_BALANCE);
    exchange.getAccountService().deposit(BTC, INITIAL_BALANCE);
  }

  @Test
  public void testStartPosition() throws IOException {
    // When
    OrderBook orderBook = exchange.getMarketDataService().getOrderBook(BTC_USD);
    Ticker ticker = exchange.getMarketDataService().getTicker(BTC_USD);
    Balance baseBalance = exchange.getAccountService().getAccountInfo().getWallet().getBalance(BTC);
    Balance counterBalance =
        exchange.getAccountService().getAccountInfo().getWallet().getBalance(USD);

    // Then

    assertThat(orderBook.getAsks()).hasSize(4);
    assertThat(orderBook.getAsks().get(0).getLimitPrice()).isEqualTo(new Double(98));
    assertThat(orderBook.getBids()).hasSize(6);
    assertThat(orderBook.getBids().get(0).getLimitPrice()).isEqualTo(new Double(97));
    assertThat(ticker.getAsk()).isEqualTo(new Double(98));
    assertThat(ticker.getBid()).isEqualTo(new Double(97));
    assertThat(ticker.getLast()).isNull();
    assertThat(getOpenOrders().getAllOpenOrders()).isEmpty();
    assertThat(getTradeHistory(exchange).getTrades()).isEmpty();
    assertThat(baseBalance.getAvailable()).isEqualTo(INITIAL_BALANCE);
    assertThat(baseBalance.getTotal()).isEqualTo(INITIAL_BALANCE);
    assertThat(baseBalance.getFrozen()).isEqualTo(0d);
    assertThat(counterBalance.getAvailable()).isEqualTo(INITIAL_BALANCE);
    assertThat(counterBalance.getTotal()).isEqualTo(INITIAL_BALANCE);
    assertThat(counterBalance.getFrozen()).isEqualTo(0d);
  }

  @Test(expected = ExchangeException.class)
  public void testInsufficientLiquidityBid() throws IOException {
    exchange
        .getTradeService()
        .placeMarketOrder(
            new MarketOrder.Builder(BID, BTC_USD).originalAmount(new Double("250")).build());
  }

  @Test(expected = ExchangeException.class)
  public void testInsufficientLiquidityAsk() throws IOException {
    exchange
        .getTradeService()
        .placeMarketOrder(
            new MarketOrder.Builder(ASK, BTC_USD).originalAmount(new Double("1002.1")).build());
  }

  @Test(expected = FundsExceededException.class)
  public void testInsufficientFundsBid() throws IOException {
    exchange
        .getTradeService()
        .placeMarketOrder(
            new MarketOrder.Builder(BID, BTC_USD).originalAmount(new Double("150")).build());
  }

  @Test(expected = FundsExceededException.class)
  public void testInsufficientFundsAsk() throws IOException {
    exchange
        .getTradeService()
        .placeMarketOrder(
            new MarketOrder.Builder(ASK, BTC_USD).originalAmount(new Double("1000.01")).build());
  }

  @Test
  public void testTradeHistoryIsolation() throws IOException {

    // Given
    ExchangeSpecification exchangeSpecification =
        new ExchangeSpecification(SimulatedExchange.class);
    exchangeSpecification.setApiKey("SomeoneElse");
    exchangeSpecification.setExchangeSpecificParametersItem(
        ENGINE_FACTORY_PARAM, matchingEngineFactory);
    Exchange someoneElsesExchange = ExchangeFactory.INSTANCE.createExchange(exchangeSpecification);

    // When
    exchange
        .getTradeService()
        .placeMarketOrder(
            new MarketOrder.Builder(ASK, BTC_USD).originalAmount(new Double("0.7")).build());

    // Then
    assertThat(exchange.getMarketDataService().getTrades(BTC_USD).getTrades()).hasSize(3);
    assertThat(someoneElsesExchange.getMarketDataService().getTrades(BTC_USD).getTrades())
        .hasSize(3);
    assertThat(getTradeHistory(exchange).getTrades()).hasSize(3);
    assertThat(getTradeHistory(someoneElsesExchange).getTrades()).isEmpty();
  }

  @Test
  public void testTradingMarketAsk() throws IOException {

    // When
    exchange
        .getTradeService()
        .placeMarketOrder(
            new MarketOrder.Builder(ASK, BTC_USD).originalAmount(new Double("0.7")).build());
    OrderBook orderBook = exchange.getMarketDataService().getOrderBook(BTC_USD);
    Ticker ticker = exchange.getMarketDataService().getTicker(BTC_USD);
    Balance baseBalance = exchange.getAccountService().getAccountInfo().getWallet().getBalance(BTC);
    Balance counterBalance =
        exchange.getAccountService().getAccountInfo().getWallet().getBalance(USD);

    // Then
    assertThat(orderBook.getAsks()).hasSize(4);
    assertThat(orderBook.getBids()).hasSize(5);
    assertThat(ticker.getAsk()).isEqualTo(new Double(98));
    assertThat(ticker.getBid()).isEqualTo(new Double(96));
    assertThat(ticker.getLast()).isEqualTo(new Double(96));
    assertThat(getTradeHistory(exchange).getTrades()).hasSize(3);

    Double expectedUsdProceeds =
        new Double(97) * (new Double("0.40")).add(new Double(96) * (new Double("0.30")));
    assertThat(baseBalance.getAvailable()).isEqualTo(INITIAL_BALANCE - (new Double("0.70")));
    assertThat(baseBalance.getTotal()).isEqualTo(INITIAL_BALANCE - (new Double("0.70")));
    assertThat(baseBalance.getFrozen()).isEqualTo(0d);
    assertThat(counterBalance.getAvailable()).isEqualTo(INITIAL_BALANCE.add(expectedUsdProceeds));
    assertThat(counterBalance.getTotal()).isEqualTo(INITIAL_BALANCE.add(expectedUsdProceeds));
    assertThat(counterBalance.getFrozen()).isEqualTo(0d);
  }

  @Test
  public void testTradingLimitAsk() throws IOException {

    // When
    String orderId =
        exchange
            .getTradeService()
            .placeLimitOrder(
                new LimitOrder.Builder(ASK, BTC_USD)
                    .limitPrice(new Double(97))
                    .originalAmount(new Double("0.7"))
                    .build());
    OrderBook orderBook = exchange.getMarketDataService().getOrderBook(BTC_USD);
    Ticker ticker = exchange.getMarketDataService().getTicker(BTC_USD);
    Balance baseBalance = exchange.getAccountService().getAccountInfo().getWallet().getBalance(BTC);
    Balance counterBalance =
        exchange.getAccountService().getAccountInfo().getWallet().getBalance(USD);

    // THen
    assertThat(orderBook.getAsks()).hasSize(5);
    assertThat(orderBook.getBids()).hasSize(5);
    assertThat(ticker.getAsk()).isEqualTo(new Double(97));
    assertThat(ticker.getBid()).isEqualTo(new Double(96));
    assertThat(ticker.getLast()).isEqualTo(new Double(97));

    OpenOrders orders = getOpenOrders();
    assertThat(orders.getOpenOrders()).hasSize(1);
    assertThat(orders.getOpenOrders().get(0).getRemainingAmount()).isEqualTo(new Double("0.3"));
    assertThat(orders.getOpenOrders().get(0).getCumulativeAmount()).isEqualTo(new Double("0.4"));
    assertThat(orders.getOpenOrders().get(0).getAveragePrice()).isEqualTo(new Double(97));
    assertThat(orders.getOpenOrders().get(0).getId()).isEqualTo(orderId);
    assertThat(orders.getOpenOrders().get(0).getStatus()).isEqualTo(PARTIALLY_FILLED);

    assertThat(getTradeHistory(exchange).getTrades()).hasSize(1);

    Double expectedUsdProceeds = new Double(97) * (new Double("0.4"));
    assertThat(baseBalance.getTotal()).isEqualTo(INITIAL_BALANCE - (new Double("0.4")));
    assertThat(baseBalance.getFrozen()).isEqualTo(new Double("0.3"));
    assertThat(baseBalance.getAvailable()).isEqualTo(INITIAL_BALANCE - (new Double("0.7")));
    assertThat(counterBalance.getTotal()).isEqualTo(INITIAL_BALANCE.add(expectedUsdProceeds));
    assertThat(counterBalance.getFrozen()).isEqualTo(0d);
    assertThat(counterBalance.getAvailable()).isEqualTo(INITIAL_BALANCE.add(expectedUsdProceeds));
  }

  @Test
  public void testTradingMarketBid() throws IOException {

    // When
    exchange
        .getTradeService()
        .placeMarketOrder(
            new MarketOrder.Builder(BID, BTC_USD).originalAmount(new Double("0.56")).build());
    OrderBook orderBook = exchange.getMarketDataService().getOrderBook(BTC_USD);
    Ticker ticker = exchange.getMarketDataService().getTicker(BTC_USD);
    Balance baseBalance = exchange.getAccountService().getAccountInfo().getWallet().getBalance(BTC);
    Balance counterBalance =
        exchange.getAccountService().getAccountInfo().getWallet().getBalance(USD);

    // THen
    assertThat(orderBook.getAsks()).hasSize(3);
    assertThat(orderBook.getBids()).hasSize(6);
    assertThat(ticker.getAsk()).isEqualTo(new Double(99));
    assertThat(ticker.getBid()).isEqualTo(new Double(97));
    assertThat(ticker.getLast()).isEqualTo(new Double(99));
    assertThat(getTradeHistory(exchange).getTrades()).hasSize(3);

    Double expectedUsdCost =
        new Double(98) * (new Double("0.3")).add(new Double(99) * (new Double("0.26")));
    assertThat(baseBalance.getAvailable()).isEqualTo(INITIAL_BALANCE.add(new Double("0.56")));
    assertThat(baseBalance.getTotal()).isEqualTo(INITIAL_BALANCE.add(new Double("0.56")));
    assertThat(baseBalance.getFrozen()).isEqualTo(0d);
    assertThat(counterBalance.getAvailable()).isEqualTo(INITIAL_BALANCE - (expectedUsdCost));
    assertThat(counterBalance.getTotal()).isEqualTo(INITIAL_BALANCE - (expectedUsdCost));
    assertThat(counterBalance.getFrozen()).isEqualTo(0d);
  }

  @Test
  public void testTradingLimitBid() throws IOException {

    // When
    String orderId1 =
        exchange
            .getTradeService()
            .placeLimitOrder(
                new LimitOrder.Builder(BID, BTC_USD)
                    .limitPrice(new Double(99))
                    .originalAmount(new Double("0.7"))
                    .build());
    String orderId2 =
        exchange
            .getTradeService()
            .placeLimitOrder(
                new LimitOrder.Builder(BID, BTC_USD)
                    .limitPrice(new Double(90))
                    .originalAmount(new Double("1"))
                    .build());
    OrderBook orderBook = exchange.getMarketDataService().getOrderBook(BTC_USD);
    Ticker ticker = exchange.getMarketDataService().getTicker(BTC_USD);
    Balance baseBalance = exchange.getAccountService().getAccountInfo().getWallet().getBalance(BTC);
    Balance counterBalance =
        exchange.getAccountService().getAccountInfo().getWallet().getBalance(USD);

    // THen
    assertThat(orderBook.getAsks()).hasSize(2);
    assertThat(orderBook.getBids()).hasSize(8);
    assertThat(ticker.getAsk()).isEqualTo(new Double(100));
    assertThat(ticker.getBid()).isEqualTo(new Double(99));
    assertThat(ticker.getLast()).isEqualTo(new Double(99));

    OpenOrders orders = getOpenOrders();
    assertThat(orders.getOpenOrders()).hasSize(2);
    Order order1 =
        orders.getAllOpenOrders().stream()
            .filter(o -> o.getId().equals(orderId1))
            .findFirst()
            .get();
    Order order2 =
        orders.getAllOpenOrders().stream()
            .filter(o -> o.getId().equals(orderId2))
            .findFirst()
            .get();
    assertThat(order1.getRemainingAmount()).isEqualTo(new Double("0.10"));
    assertThat(order1.getCumulativeAmount()).isEqualTo(new Double("0.60"));
    assertThat(order1.getAveragePrice()).isEqualTo(new Double("98.50"));
    assertThat(order1.getStatus()).isEqualTo(PARTIALLY_FILLED);
    assertThat(order2.getRemainingAmount()).isEqualTo(new Double(1));
    assertThat(order2.getCumulativeAmount()).isEqualTo(0d);
    assertThat(order2.getAveragePrice()).isNull();
    assertThat(order2.getStatus()).isEqualTo(NEW);

    assertThat(getTradeHistory(exchange).getTrades()).hasSize(3);

    Double expectedUsdCost =
        new Double(98) * (new Double("0.30")).add(new Double(99) * (new Double("0.30")));
    Double expectedUsdReserved =
        new Double(99) * (new Double("0.10")).add(new Double(90) * (new Double(1)));
    assertThat(baseBalance.getTotal()).isEqualTo(INITIAL_BALANCE.add(new Double("0.60")));
    assertThat(baseBalance.getFrozen()).isEqualTo(ZERO);
    assertThat(baseBalance.getAvailable()).isEqualTo(INITIAL_BALANCE.add(new Double("0.60")));
    assertThat(counterBalance.getTotal()).isEqualTo(INITIAL_BALANCE - (expectedUsdCost));
    assertThat(counterBalance.getFrozen()).isEqualTo(expectedUsdReserved);
    assertThat(counterBalance.getAvailable())
        .isEqualTo(INITIAL_BALANCE - (expectedUsdCost) - (expectedUsdReserved));
  }

  private OpenOrders getOpenOrders() throws IOException {
    OpenOrdersParamCurrencyPair params = exchange.getTradeService().createOpenOrdersParams();
    params.setCurrencyPair(BTC_USD);
    return exchange.getTradeService().getOpenOrders(params);
  }

  private UserTrades getTradeHistory(Exchange exchangeToUse) throws IOException {
    TradeHistoryParamCurrencyPair params =
        (TradeHistoryParamCurrencyPair) exchangeToUse.getTradeService().createTradeHistoryParams();
    params.setCurrencyPair(BTC_USD);
    return exchangeToUse.getTradeService().getTradeHistory(params);
  }

  private void mockMarket() throws IOException {
    ExchangeSpecification exchangeSpecification =
        new ExchangeSpecification(SimulatedExchange.class);
    exchangeSpecification.setApiKey("MarketMakers");
    exchangeSpecification.setExchangeSpecificParametersItem(
        ENGINE_FACTORY_PARAM, matchingEngineFactory);
    exchangeSpecification.setExchangeSpecificParametersItem(ACCOUNT_FACTORY_PARAM, accountFactory);
    SimulatedExchange marketMakerExchange =
        (SimulatedExchange) ExchangeFactory.INSTANCE.createExchange(exchangeSpecification);
    marketMakerExchange.getAccountService().deposit(USD, new Double(10000));
    marketMakerExchange.getAccountService().deposit(BTC, new Double(10000));
    MockMarket.mockMarket(marketMakerExchange);
  }
}
