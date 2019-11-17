package org.knowm.xchange.coinbasepro;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.knowm.xchange.coinbasepro.dto.marketdata.CoinbaseProProductStats;
import org.knowm.xchange.coinbasepro.dto.marketdata.CoinbaseProProductTicker;
import org.knowm.xchange.coinbasepro.dto.trade.CoinbaseProFill;
import org.knowm.xchange.coinbasepro.dto.trade.CoinbaseProOrder;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.trade.*;
import si.mazi.rescu.serialization.jackson.DefaultJacksonObjectMapperFactory;
import si.mazi.rescu.serialization.jackson.JacksonObjectMapperFactory;

public class CoinbaseProAdaptersTest {

  @Test
  public void parseDateTest() {

    assertThat(CoinbaseProAdapters.parseDate("2017-05-02T15:10:03Z").getTime())
        .isEqualTo(1493737803000L);
    assertThat(CoinbaseProAdapters.parseDate("2017-05-02T15:10:03.1Z").getTime())
        .isEqualTo(1493737803100L);
    assertThat(CoinbaseProAdapters.parseDate("2017-05-02T15:10:03.12Z").getTime())
        .isEqualTo(1493737803120L);
    assertThat(CoinbaseProAdapters.parseDate("2017-05-02T15:10:03.123Z").getTime())
        .isEqualTo(1493737803123L);
    assertThat(CoinbaseProAdapters.parseDate("2017-05-02T15:10:03.1234567Z").getTime())
        .isEqualTo(1493737803123L);

    assertThat(CoinbaseProAdapters.parseDate("2017-05-02T15:10:03").getTime())
        .isEqualTo(1493737803000L);
    assertThat(CoinbaseProAdapters.parseDate("2017-05-02T15:10:03.1").getTime())
        .isEqualTo(1493737803100L);
    assertThat(CoinbaseProAdapters.parseDate("2017-05-02T15:10:03.12").getTime())
        .isEqualTo(1493737803120L);
    assertThat(CoinbaseProAdapters.parseDate("2017-05-02T15:10:03.123").getTime())
        .isEqualTo(1493737803123L);
    assertThat(CoinbaseProAdapters.parseDate("2017-05-02T15:10:03.123456").getTime())
        .isEqualTo(1493737803123L);

    assertThat(CoinbaseProAdapters.parseDate("2017-06-21T04:52:01.996Z").getTime())
        .isEqualTo(1498020721996L);
  }

  @Test
  public void testTickerAdapter() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        CoinbaseProAdaptersTest.class.getResourceAsStream(
            "/org/knowm/xchange/coinbasepro/dto/marketdata/example-ticker-data.json");
    InputStream is2 =
        CoinbaseProAdaptersTest.class.getResourceAsStream(
            "/org/knowm/xchange/coinbasepro/dto/marketdata/example-stats-data.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    CoinbaseProProductTicker coinbaseExTicker =
        mapper.readValue(is, CoinbaseProProductTicker.class);
    CoinbaseProProductStats coinbaseExStats = mapper.readValue(is2, CoinbaseProProductStats.class);

    Ticker ticker =
        CoinbaseProAdapters.adaptTicker(coinbaseExTicker, coinbaseExStats, CurrencyPair.BTC_USD);

    assertThat(ticker.getLast()).isEqualTo(246.28000000);
    assertThat(ticker.getOpen()).isEqualTo(254.04000000);
    assertThat(ticker.getBid()).isEqualTo(637);
    assertThat(ticker.getAsk()).isEqualTo(637.11);
    assertThat(ticker.getHigh()).isEqualTo(255.47000000);
    assertThat(ticker.getLow()).isEqualTo(244.29000000);
    assertThat(ticker.getVolume()).isEqualTo(4661.70407704);
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    f.setTimeZone(TimeZone.getTimeZone("UTC"));
    String dateString = f.format(ticker.getTimestamp());
    assertThat(dateString).isEqualTo("2015-04-08 20:49:06");
  }

  @Test
  public void testTradeHistoryAdapter() throws IOException {

    JacksonObjectMapperFactory factory = new DefaultJacksonObjectMapperFactory();
    ObjectMapper mapper = factory.createObjectMapper();

    InputStream is =
        getClass()
            .getResourceAsStream("/org/knowm/xchange/coinbasepro/dto/trade/example-fills.json");
    CoinbaseProFill[] fills = mapper.readValue(is, CoinbaseProFill[].class);

    UserTrades trades = CoinbaseProAdapters.adaptTradeHistory(fills);

    assertThat(trades.getUserTrades()).hasSize(1);

    UserTrade trade = trades.getUserTrades().get(0);

    assertThat(trade.getId()).isEqualTo("470768");
    assertThat(trade.getCurrencyPair()).isEqualTo(CurrencyPair.ETH_BTC);
    assertThat(trade.getPrice()).isEqualTo(0.05915000);
    assertThat(trade.getOriginalAmount()).isEqualTo(0.01000000);
    assertThat(trade.getOrderId()).isEqualTo("b4b3bbb1-e0e3-4532-9413-23123448ce35");
    assertThat(trade.getTimestamp().getTime()).isEqualTo(1493623910243L);
    assertThat(trade.getFeeAmount()).isEqualTo(0.0000017745000000);
    assertThat(trade.getType()).isEqualTo(OrderType.BID);
  }

  @Test
  public void testOrderStatusMarketOrderFilled() throws IOException {

    JacksonObjectMapperFactory factory = new DefaultJacksonObjectMapperFactory();
    ObjectMapper mapper = factory.createObjectMapper();

    InputStream is =
        getClass()
            .getResourceAsStream(
                "/org/knowm/xchange/coinbasepro/dto/order/example-market-order-filled.json");
    CoinbaseProOrder coinbaseProOrder = mapper.readValue(is, CoinbaseProOrder.class);

    Order order = CoinbaseProAdapters.adaptOrder(coinbaseProOrder);

    assertThat(order.getStatus()).isEqualTo(Order.OrderStatus.FILLED);
    assertThat(order.getId()).isEqualTo(coinbaseProOrder.getId());
    assertThat(order.getCurrencyPair()).isEqualTo((CurrencyPair.BTC_USD));
    assertThat(order.getOriginalAmount()).isEqualByComparingTo(new Double("1.00000000"));
    assertThat(order.getCumulativeAmount()).isEqualByComparingTo(new Double("0.01291771"));
    assertThat(order.getRemainingAmount())
        .isEqualByComparingTo(new Double("1.0") - (new Double("0.01291771")));
    assertThat(order.getFee()).isEqualTo(new Double("0.0249376391550000"));
    assertThat(MarketOrder.class.isAssignableFrom(order.getClass())).isTrue();
    assertThat(order.getType()).isEqualTo(OrderType.BID);
    assertThat(order.getTimestamp()).isEqualTo(new Date(1481227745508L));
    assertThat(order.getAveragePrice())
        .isEqualByComparingTo(new Double("9.9750556620000000") / (new Double("0.01291771")));
  }

  @Test
  public void testOrderStatusLimitOrderFilled() throws IOException {

    JacksonObjectMapperFactory factory = new DefaultJacksonObjectMapperFactory();
    ObjectMapper mapper = factory.createObjectMapper();

    InputStream is =
        getClass()
            .getResourceAsStream(
                "/org/knowm/xchange/coinbasepro/dto/order/example-limit-order-filled.json");
    CoinbaseProOrder coinbaseProOrder = mapper.readValue(is, CoinbaseProOrder.class);

    Order order = CoinbaseProAdapters.adaptOrder(coinbaseProOrder);

    assertThat(order.getStatus()).isEqualTo(Order.OrderStatus.FILLED);
    assertThat(order.getId()).isEqualTo("b2cdd7fe-1f4a-495e-8b96-7a4be368f43c");
    assertThat(order.getCurrencyPair()).isEqualTo((CurrencyPair.BTC_USD));
    assertThat(order.getOriginalAmount()).isEqualByComparingTo(new Double("0.07060351"));
    assertThat(order.getCumulativeAmount()).isEqualByComparingTo(new Double("0.07060351"));
    assertThat(order.getRemainingAmount()).isEqualByComparingTo(new Double("0.00000000"));
    assertThat(order.getFee()).isEqualTo(new Double("2.6256545174247500"));
    assertThat(LimitOrder.class.isAssignableFrom(order.getClass())).isTrue();
    assertThat(order.getType()).isEqualTo(OrderType.ASK);
    assertThat(order.getTimestamp()).isEqualTo(new Date(1515434144454L));
    assertThat(order.getAveragePrice())
        .isEqualByComparingTo(new Double("1050.2618069699000000") / (new Double("0.07060351")));
  }

  @Test
  public void testOrderStatusLimitOrderSettled() throws IOException {

    final JacksonObjectMapperFactory factory = new DefaultJacksonObjectMapperFactory();
    final ObjectMapper mapper = factory.createObjectMapper();

    final InputStream is =
        getClass()
            .getResourceAsStream(
                "/org/knowm/xchange/coinbasepro/dto/order/example-limit-order-settled.json");
    final CoinbaseProOrder coinbaseProOrder = mapper.readValue(is, CoinbaseProOrder.class);

    final Order order = CoinbaseProAdapters.adaptOrder(coinbaseProOrder);

    assertThat(order.getStatus()).isEqualTo(Order.OrderStatus.FILLED);
    assertThat(order.getId()).isEqualTo("b2cdd7fe-1f4a-495e-8b96-7a4be368f43c");
    assertThat(order.getCurrencyPair()).isEqualTo((CurrencyPair.BTC_USD));
    assertThat(order.getOriginalAmount()).isEqualByComparingTo(new Double("0.07060351"));
    assertThat(order.getCumulativeAmount()).isEqualByComparingTo(new Double("0.07060351"));
    assertThat(order.getRemainingAmount()).isEqualByComparingTo(0d);
    assertThat(LimitOrder.class.isAssignableFrom(order.getClass())).isTrue();
    assertThat(order.getType()).isEqualTo(OrderType.ASK);
    assertThat(order.getTimestamp()).isEqualTo(new Date(1515434144454L));
    assertThat(order.getAveragePrice())
        .isEqualByComparingTo(new Double("1050.2618069699000000") / (new Double("0.07060351")));
  }

  @Test
  public void testOrderStatusLimitOrderNew() throws IOException {

    final JacksonObjectMapperFactory factory = new DefaultJacksonObjectMapperFactory();
    final ObjectMapper mapper = factory.createObjectMapper();

    final InputStream is =
        getClass()
            .getResourceAsStream(
                "/org/knowm/xchange/coinbasepro/dto/order/example-limit-order-new.json");
    final CoinbaseProOrder coinbaseProOrder = mapper.readValue(is, CoinbaseProOrder.class);

    final Order order = CoinbaseProAdapters.adaptOrder(coinbaseProOrder);

    assertThat(order.getStatus()).isEqualTo(Order.OrderStatus.NEW);
    assertThat(order.getId()).isEqualTo("b2cdd7fe-1f4a-495e-8b96-7a4be368f43c");
    assertThat(order.getCurrencyPair()).isEqualTo((CurrencyPair.BTC_USD));
    assertThat(order.getOriginalAmount()).isEqualByComparingTo(new Double("0.07060351"));
    assertThat(order.getCumulativeAmount()).isEqualByComparingTo(0d);
    assertThat(order.getRemainingAmount()).isEqualByComparingTo(new Double("0.07060351"));
    assertThat(order.getType()).isEqualTo(OrderType.ASK);
    assertThat(order.getTimestamp()).isEqualTo(new Date(1515434144454L));
    assertThat(order.getAveragePrice()).isEqualByComparingTo(0d);

    assertThat(LimitOrder.class.isAssignableFrom(order.getClass())).isTrue();
    LimitOrder limitOrder = (LimitOrder) order;
    assertThat(limitOrder.getLimitPrice()).isEqualByComparingTo(new Double("14839.76"));
  }

  @Test
  public void testOrderStatusStopOrderNew()
      throws JsonParseException, JsonMappingException, IOException {

    final JacksonObjectMapperFactory factory = new DefaultJacksonObjectMapperFactory();
    final ObjectMapper mapper = factory.createObjectMapper();

    final InputStream is =
        getClass()
            .getResourceAsStream(
                "/org/knowm/xchange/coinbasepro/dto/order/example-stop-order-new.json");
    final CoinbaseProOrder coinbaseProOrder = mapper.readValue(is, CoinbaseProOrder.class);

    final Order order = CoinbaseProAdapters.adaptOrder(coinbaseProOrder);

    assertThat(order.getStatus()).isEqualTo(Order.OrderStatus.NEW);
    assertThat(order.getId()).isEqualTo("853a9989-7dd9-40f8-9392-64237a9eccc4");
    assertThat(order.getCurrencyPair()).isEqualTo((CurrencyPair.BTC_EUR));
    assertThat(order.getOriginalAmount()).isEqualByComparingTo(new Double("0.01"));
    assertThat(order.getCumulativeAmount()).isEqualByComparingTo(0d);
    assertThat(order.getRemainingAmount()).isEqualByComparingTo(new Double("0.01"));
    assertThat(order.getType()).isEqualTo(OrderType.ASK);
    assertThat(order.getTimestamp()).isEqualTo(new Date(1515434144454L));
    assertThat(order.getAveragePrice()).isEqualByComparingTo(0d);

    assertThat(StopOrder.class.isAssignableFrom(order.getClass())).isTrue();
    StopOrder stop = (StopOrder) order;
    assertThat(stop.getStopPrice()).isEqualByComparingTo(new Double("6364.31"));
  }

  @Test
  public void testOrderStatusStopOrderStopped()
      throws JsonParseException, JsonMappingException, IOException {

    final JacksonObjectMapperFactory factory = new DefaultJacksonObjectMapperFactory();
    final ObjectMapper mapper = factory.createObjectMapper();

    final InputStream is =
        getClass()
            .getResourceAsStream(
                "/org/knowm/xchange/coinbasepro/dto/order/example-stop-order-stopped.json");
    final CoinbaseProOrder coinbaseProOrder = mapper.readValue(is, CoinbaseProOrder.class);

    final Order order = CoinbaseProAdapters.adaptOrder(coinbaseProOrder);

    assertThat(order.getStatus()).isEqualTo(Order.OrderStatus.STOPPED);
    assertThat(order.getId()).isEqualTo("853a9989-7dd9-40f8-9392-64237a9eccc4");
    assertThat(order.getCurrencyPair()).isEqualTo((CurrencyPair.BTC_EUR));
    assertThat(order.getOriginalAmount()).isEqualByComparingTo(new Double("0.01"));
    assertThat(order.getCumulativeAmount()).isEqualByComparingTo(0d);
    assertThat(order.getRemainingAmount()).isEqualByComparingTo(new Double("0.01"));
    assertThat(order.getType()).isEqualTo(OrderType.ASK);
    assertThat(order.getTimestamp()).isEqualTo(new Date(1515434144454L));
    assertThat(order.getAveragePrice()).isEqualByComparingTo(0d);

    assertThat(StopOrder.class.isAssignableFrom(order.getClass())).isTrue();
    StopOrder stop = (StopOrder) order;
    assertThat(stop.getStopPrice()).isEqualByComparingTo(new Double("6364.31"));
  }

  @Test
  public void testOrderStatusStopOrderFilled()
      throws JsonParseException, JsonMappingException, IOException {

    final JacksonObjectMapperFactory factory = new DefaultJacksonObjectMapperFactory();
    final ObjectMapper mapper = factory.createObjectMapper();

    final InputStream is =
        getClass()
            .getResourceAsStream(
                "/org/knowm/xchange/coinbasepro/dto/order/example-stop-order-filled.json");
    final CoinbaseProOrder coinbaseProOrder = mapper.readValue(is, CoinbaseProOrder.class);

    final Order order = CoinbaseProAdapters.adaptOrder(coinbaseProOrder);

    assertStopOrderFilled(order);
  }

  @Test
  public void testOrderStatusLimitOrderPending() throws IOException {

    final JacksonObjectMapperFactory factory = new DefaultJacksonObjectMapperFactory();
    final ObjectMapper mapper = factory.createObjectMapper();

    final InputStream is =
        getClass()
            .getResourceAsStream(
                "/org/knowm/xchange/coinbasepro/dto/order/example-limit-order-pending.json");
    final CoinbaseProOrder coinbaseProOrder = mapper.readValue(is, CoinbaseProOrder.class);

    final Order order = CoinbaseProAdapters.adaptOrder(coinbaseProOrder);

    assertLimitOrderPending(order);
  }

  @Test
  public void testOrders() throws JsonParseException, JsonMappingException, IOException {
    final JacksonObjectMapperFactory factory = new DefaultJacksonObjectMapperFactory();
    final ObjectMapper mapper = factory.createObjectMapper();

    InputStream is =
        new SequenceInputStream(
            IOUtils.toInputStream("[", StandardCharsets.UTF_8),
            new SequenceInputStream(
                getClass()
                    .getResourceAsStream(
                        "/org/knowm/xchange/coinbasepro/dto/order/example-limit-order-pending.json"),
                new SequenceInputStream(
                    IOUtils.toInputStream(", ", StandardCharsets.UTF_8),
                    new SequenceInputStream(
                        getClass()
                            .getResourceAsStream(
                                "/org/knowm/xchange/coinbasepro/dto/order/example-stop-order-filled.json"),
                        IOUtils.toInputStream("]", StandardCharsets.UTF_8)))));

    final CoinbaseProOrder[] coinbaseProOrders = mapper.readValue(is, CoinbaseProOrder[].class);

    OpenOrders openOrders = CoinbaseProAdapters.adaptOpenOrders(coinbaseProOrders);

    assertThat(openOrders.getOpenOrders()).hasSize(1);
    assertThat(openOrders.getHiddenOrders()).hasSize(1);
    assertStopOrderFilled(openOrders.getHiddenOrders().get(0));
    assertLimitOrderPending(openOrders.getOpenOrders().get(0));
  }

  private void assertStopOrderFilled(final Order order) {
    assertThat(order.getStatus()).isEqualTo(Order.OrderStatus.FILLED);
    assertThat(order.getId()).isEqualTo("a9098e25-9d4d-4e2c-ab5e-8c057cc4cbee");
    assertThat(order.getCurrencyPair()).isEqualTo((CurrencyPair.BTC_EUR));
    assertThat(order.getOriginalAmount()).isEqualByComparingTo(new Double("0.08871972"));
    assertThat(order.getCumulativeAmount()).isEqualByComparingTo(new Double("0.08871972"));
    assertThat(order.getRemainingAmount()).isEqualByComparingTo(0d);
    assertThat(order.getType()).isEqualTo(OrderType.BID);
    assertThat(order.getTimestamp()).isEqualTo(new Date(1515434144454L));
    assertThat(order.getAveragePrice())
        .isEqualByComparingTo(new Double("639.3107535312") / (new Double("0.08871972")));

    assertThat(StopOrder.class.isAssignableFrom(order.getClass())).isTrue();
    StopOrder stop = (StopOrder) order;
    assertThat(stop.getStopPrice()).isEqualByComparingTo(new Double("7205"));
  }

  private void assertLimitOrderPending(final Order order) {
    assertThat(order.getStatus()).isEqualTo(Order.OrderStatus.PENDING_NEW);
    assertThat(order.getId()).isEqualTo("b2cdd7fe-1f4a-495e-8b96-7a4be368f43c");
    assertThat(order.getCurrencyPair()).isEqualTo((CurrencyPair.BTC_USD));
    assertThat(order.getOriginalAmount()).isEqualByComparingTo(new Double("0.07060351"));
    assertThat(order.getCumulativeAmount()).isEqualByComparingTo(0d);
    assertThat(order.getRemainingAmount()).isEqualByComparingTo(new Double("0.07060351"));
    assertThat(LimitOrder.class.isAssignableFrom(order.getClass())).isTrue();
    assertThat(order.getType()).isEqualTo(OrderType.ASK);
    assertThat(order.getTimestamp()).isEqualTo(new Date(1515434144454L));
    assertThat(order.getAveragePrice()).isEqualByComparingTo(0d);
  }
}
