package org.knowm.xchange.lgo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Before;
import org.junit.Test;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.meta.ExchangeMetaData;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.MarketOrder;
import org.knowm.xchange.lgo.LgoAdapters;
import org.knowm.xchange.lgo.LgoEnv;
import org.knowm.xchange.lgo.LgoExchange;
import org.knowm.xchange.lgo.dto.currency.LgoCurrencies;
import org.knowm.xchange.lgo.dto.product.LgoProducts;
import org.knowm.xchange.lgo.dto.product.LgoProductsTest;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LgoTradeServiceTest {

    private LgoTradeService tradeService;
    private LgoExchange exchange;

    @Before
    public void setUp() throws Exception {
        exchange = mock(LgoExchange.class);
        LgoProducts products =
                load("/org/knowm/xchange/lgo/product/example-products-data.json", LgoProducts.class);
        LgoCurrencies currencies =
                load("/org/knowm/xchange/lgo/currency/example-currencies-data.json", LgoCurrencies.class);
        ExchangeMetaData metaData = load("/lgo.json", ExchangeMetaData.class);
        when(exchange.getProducts()).thenReturn(products);
        when(exchange.getCurrencies()).thenReturn(currencies);
        when(exchange.getExchangeSpecification()).thenReturn(LgoEnv.sandboxMarkets());
        when(exchange.getExchangeMetaData())
                .thenReturn(LgoAdapters.adaptMetadata(metaData, products, currencies));
        tradeService = new LgoTradeService(exchange);
    }

    protected <T> T load(String resource, Class<T> clazz) throws java.io.IOException {
        InputStream is = LgoProductsTest.class.getResourceAsStream(resource);
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(is, clazz);
    }

    @Test
    public void acceptsCorrectLimitOrder() {
        tradeService.verifyOrder(
                new LimitOrder(
                        OrderType.ASK,
                        new Double("3"),
                        CurrencyPair.BTC_USD,
                        "",
                        System.currentTimeMillis(),
                        7000d));
    }

    @Test
    public void acceptsCorrectMarketOrder() {
        tradeService.verifyOrder(
                new MarketOrder(OrderType.BID, new Double("1000"), CurrencyPair.BTC_USD, System.currentTimeMillis()));
    }

    @Test
    public void cannotPlaceLimitOrderWithToLowBaseAmount() {

        ThrowingCallable check =
                () ->
                        tradeService.verifyOrder(
                                new LimitOrder(
                                        OrderType.ASK,
                                        new Double("0.00000001"),
                                        CurrencyPair.BTC_USD,
                                        "",
                                        System.currentTimeMillis(),
                                        7000d));

        assertThatThrownBy(check)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Unsupported amount scale 8");
    }

    @Test
    public void cannotPlaceLimitOrderWithToHighBaseAmount() {
        ThrowingCallable check =
                () ->
                        tradeService.verifyOrder(
                                new LimitOrder(
                                        OrderType.ASK,
                                        new Double("1001"),
                                        CurrencyPair.BTC_USD,
                                        "",
                                        System.currentTimeMillis(),
                                        7000d));

        assertThatThrownBy(check)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Order amount more than maximum");
    }

    @Test
    public void cannotPlaceLimitOrderWithToLowPrice() {
        ThrowingCallable check =
                () ->
                        tradeService.verifyOrder(
                                new LimitOrder(
                                        OrderType.ASK,
                                        new Double("10"),
                                        CurrencyPair.BTC_USD,
                                        "",
                                        System.currentTimeMillis(),
                                        9d));

        assertThatThrownBy(check)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Order price to low");
    }

    @Test
    public void cannotPlaceLimitOrderWithToHighPrice() {
        ThrowingCallable check =
                () ->
                        tradeService.verifyOrder(
                                new LimitOrder(
                                        OrderType.ASK,
                                        new Double("10"),
                                        CurrencyPair.BTC_USD,
                                        "",
                                        System.currentTimeMillis(),
                                        1000001d));

        assertThatThrownBy(check)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Order price to high");
    }

    @Test
    public void cannotPlaceLimitOrderWithInvalidPriceIncrement() {
        ThrowingCallable check =
                () ->
                        tradeService.verifyOrder(
                                new LimitOrder(
                                        OrderType.ASK,
                                        new Double("10"),
                                        CurrencyPair.BTC_USD,
                                        "",
                                        System.currentTimeMillis(),
                                        new Double("100.05")));

        assertThatThrownBy(check)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid price increment");
    }

    @Test
    public void cannotPlaceBidMarketOrderWithAmountToLow() {
        ThrowingCallable check =
                () ->
                        tradeService.verifyOrder(
                                new MarketOrder(
                                        OrderType.BID, new Double("0.00001"), CurrencyPair.BTC_USD, System.currentTimeMillis()));

        assertThatThrownBy(check)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Quantity to low");
    }

    @Test
    public void cannotPlaceBidMarketOrderWithAmountToHigh() {
        ThrowingCallable check =
                () ->
                        tradeService.verifyOrder(
                                new MarketOrder(
                                        OrderType.BID, new Double("1000001"), CurrencyPair.BTC_USD, System.currentTimeMillis()));

        assertThatThrownBy(check)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Quantity to high");
    }

    @Test
    public void cannotPlaceAskMarketOrderWithAmountToLow() {
        ThrowingCallable check =
                () ->
                        tradeService.verifyOrder(
                                new MarketOrder(
                                        OrderType.ASK, new Double("0.00001"), CurrencyPair.BTC_USD, System.currentTimeMillis()));

        assertThatThrownBy(check)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Quantity to low");
    }

    @Test
    public void cannotPlaceAskMarketOrderWithAmountToHigh() {
        ThrowingCallable check = () -> tradeService.verifyOrder(new MarketOrder(OrderType.ASK, new Double("1001"), CurrencyPair.BTC_USD, System.currentTimeMillis()));
        assertThatThrownBy(check)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Quantity to high");
    }
}
