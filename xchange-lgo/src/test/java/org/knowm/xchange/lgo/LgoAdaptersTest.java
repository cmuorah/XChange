package org.knowm.xchange.lgo;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import org.apache.commons.io.IOUtils;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.meta.CurrencyMetaData;
import org.knowm.xchange.dto.meta.ExchangeMetaData;
import org.knowm.xchange.dto.meta.RateLimit;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.MarketOrder;
import org.knowm.xchange.dto.trade.UserTrade;
import org.knowm.xchange.dto.trade.UserTrades;
import org.knowm.xchange.lgo.dto.WithCursor;
import org.knowm.xchange.lgo.dto.currency.LgoCurrencies;
import org.knowm.xchange.lgo.dto.currency.LgoCurrency;
import org.knowm.xchange.lgo.dto.key.LgoKey;
import org.knowm.xchange.lgo.dto.order.LgoPlaceLimitOrder;
import org.knowm.xchange.lgo.dto.order.LgoPlaceMarketOrder;
import org.knowm.xchange.lgo.dto.order.LgoPlaceOrder;
import org.knowm.xchange.lgo.dto.product.*;
import org.knowm.xchange.lgo.dto.trade.LgoUserTrade;
import org.knowm.xchange.lgo.dto.trade.LgoUserTrades;

public class LgoAdaptersTest {

  private SimpleDateFormat dateFormat;

  @Before
  public void setUp() {
    dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
  }

  @Test
  public void adaptsMetadata() {
    ExchangeMetaData metaData = LgoAdapters.adaptMetadata(emptyMeta(), products(), currencies());

    assertThat(metaData).isNotNull();
    assertThat(metaData.getCurrencies()).hasSize(2).containsKeys(Currency.BTC, Currency.USD);
    assertThat(metaData.getCurrencies().get(Currency.BTC))
        .isEqualToComparingFieldByField(new CurrencyMetaData(8, null));
    assertThat(metaData.getCurrencies().get(Currency.USD))
        .isEqualToComparingFieldByField(new CurrencyMetaData(4, null));
    assertThat(metaData.getCurrencyPairs()).hasSize(1).containsKeys(CurrencyPair.BTC_USD);
  }

  @Test
  public void adaptsKeysIndex() throws IOException {
    InputStream is =
        LgoAdaptersTest.class.getResourceAsStream("/org/knowm/xchange/lgo/key/index.txt");
    String indexFile = IOUtils.toString(is, StandardCharsets.US_ASCII);

    List<LgoKey> keys = LgoAdapters.adaptKeysIndex(indexFile).collect(Collectors.toList());

    assertThat(keys).hasSize(2);
    assertThat(keys.get(0))
        .isEqualToComparingFieldByField(
            new LgoKey(
                "7b5dd30f-47cc-4c72-938b-199b13bc6f72",
                Instant.parse("2019-07-16T09:13:54Z"),
                Instant.parse("2019-07-16T10:13:54Z")));
    assertThat(keys.get(1))
        .isEqualToComparingFieldByField(
            new LgoKey(
                "684700ae-8bc7-4315-8aec-b69ca778339a",
                Instant.parse("2019-07-16T10:03:54Z"),
                Instant.parse("2019-07-16T11:03:54Z")));
  }

  @Test
  public void adaptsBidLimitOrder() {
    long now = System.currentTimeMillis();
    LimitOrder limitOrder = new LimitOrder(OrderType.BID, new Double("1"), CurrencyPair.BTC_USD, null, now, new Double("6000"));
    LgoPlaceOrder bidOrder = LgoAdapters.adaptLimitOrder(limitOrder);

    assertThat(bidOrder)
        .isEqualToComparingFieldByField(
            new LgoPlaceLimitOrder(
                0, "B", "BTC-USD", new Double("1"), new Double("6000"), Instant.ofEpochMilli(now)));
  }

  @Test
  public void adaptsAskLimitOrder() {
    long timestamp = System.currentTimeMillis();
    LimitOrder limitOrder =
        new LimitOrder(
            OrderType.ASK,
            new Double("1"),
            CurrencyPair.BTC_USD,
            null,
            timestamp,
            new Double("6000"));

    LgoPlaceOrder bidOrder = LgoAdapters.adaptLimitOrder(limitOrder);
    assertThat(bidOrder).isEqualToComparingFieldByField(new LgoPlaceLimitOrder(0, "S", "BTC-USD", new Double("1"), new Double("6000"), Instant.ofEpochMilli(timestamp)));
  }

  @Test
  public void adaptsBidMarketOrder() {
    long now = System.currentTimeMillis();
    MarketOrder marketOrder = new MarketOrder(OrderType.BID, new Double("1"), CurrencyPair.BTC_USD, null, now);

    LgoPlaceOrder bidOrder = LgoAdapters.adaptMarketOrder(marketOrder);

    assertThat(bidOrder)
        .isEqualToComparingFieldByField(
            new LgoPlaceMarketOrder(0, "B", "BTC-USD", new Double("1"), Instant.ofEpochMilli(now)));
  }

  @Test
  public void adaptsAskMarketOrder() {
    long timestamp = System.currentTimeMillis();
    MarketOrder marketOrder =
        new MarketOrder(OrderType.ASK, new Double("1"), CurrencyPair.BTC_USD, null, timestamp);

    LgoPlaceOrder bidOrder = LgoAdapters.adaptMarketOrder(marketOrder);

    assertThat(bidOrder)
        .isEqualToComparingFieldByField(
            new LgoPlaceMarketOrder(0, "S", "BTC-USD", new Double("1"), Instant.ofEpochMilli(timestamp)));
  }

  @Test
  public void adaptsTradeType() {
    assertThat(LgoAdapters.adaptUserTradeType(lgoTrade("B", "T"))).isEqualTo(OrderType.BID);
    assertThat(LgoAdapters.adaptUserTradeType(lgoTrade("B", "M"))).isEqualTo(OrderType.ASK);
    assertThat(LgoAdapters.adaptUserTradeType(lgoTrade("S", "T"))).isEqualTo(OrderType.ASK);
    assertThat(LgoAdapters.adaptUserTradeType(lgoTrade("S", "M"))).isEqualTo(OrderType.BID);
  }

  @Test
  public void adaptsProductId() {
    assertThat(LgoAdapters.adaptProductId("BTC-USD")).isEqualTo(CurrencyPair.BTC_USD);
  }

  @Test
  public void adaptsUserTrades() throws IOException, ParseException {
    InputStream is =
        LgoProductsTest.class.getResourceAsStream(
            "/org/knowm/xchange/lgo/trade/example-trades-data.json");
    ObjectMapper mapper = new ObjectMapper();
    WithCursor<LgoUserTrades> lastTrades =
        mapper.readValue(is, new TypeReference<WithCursor<LgoUserTrades>>() {});

    UserTrades userTrades = LgoAdapters.adaptUserTrades(lastTrades);

    assertThat(userTrades.getNextPageCursor()).isEqualTo("aGVsbG8=");
    assertThat(userTrades.getUserTrades()).hasSize(2);
    assertThat(userTrades.getUserTrades().get(0))
        .isEqualToComparingFieldByField(
            new UserTrade(
                OrderType.ASK,
                new Double("0.00500000"),
                CurrencyPair.BTC_USD,
                new Double("3854.0000"),
                dateFormat.parse("2019-03-05T16:37:17.220Z").getTime(),
                "2",
                "155180383648300001",
                new Double("0.0096"),
                Currency.USD));
    assertThat(userTrades.getUserTrades().get(1))
        .isEqualToComparingFieldByField(
            new UserTrade(
                OrderType.BID,
                new Double("0.00829566"),
                CurrencyPair.BTC_USD,
                new Double("2410.9000"),
                dateFormat.parse("2019-06-20T15:37:21.855Z").getTime(),
                "2477363",
                "156104504046400001",
                new Double("0.0100"),
                Currency.USD));
  }

  private LgoUserTrade lgoTrade(String side, String liquidity) {
    return new LgoUserTrade(
        "1",
        "2",
        "BTC-USD",
        new Double("1"),
        new Double("1"),
        null,
        new Double("1"),
        side,
        liquidity);
  }

  private ExchangeMetaData emptyMeta() {
    return new ExchangeMetaData(
        new HashMap<>(), new HashMap<>(), new RateLimit[0], new RateLimit[0], true);
  }

  private LgoCurrencies currencies() {
    return new LgoCurrencies(
        Lists.newArrayList(
            new LgoCurrency("Bitcoin", "BTC", 8), new LgoCurrency("Dollar", "USD", 4)));
  }

  private LgoProducts products() {
    return new LgoProducts(
        Lists.newArrayList(
            new LgoProduct(
                "BTC-USD",
                new LgoProductTotal(limit("10", "50000000")),
                new LgoProductCurrency("BTC", null, limit("0.001", "1000")),
                new LgoProductCurrency("USD", new Double("0.10"), limit("10", "1000000")))));
  }

  private LgoLimit limit(String min, String max) {
    return new LgoLimit(new Double(min), new Double(max));
  }
}
