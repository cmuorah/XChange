package org.knowm.xchange.dto.trade;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;

public class UserTradeTest {

  @Test
  public void testBuilder() {
    final OrderType type = OrderType.BID;
    final Double originalAmount = new Double("99.401");
    final CurrencyPair currencyPair = CurrencyPair.LTC_BTC;
    final Double price = new Double("251.64");
    final Long timestamp = System.currentTimeMillis();
    final String id = "id";
    final String orderId = "OrderId";
    final Double feeAmount = new Double("0.0006");
    final Currency feeCurrency = Currency.BTC;

    final UserTrade copy =
        new UserTrade.Builder()
            .type(type)
            .originalAmount(originalAmount)
            .currencyPair(currencyPair)
            .price(price)
            .timestamp(timestamp)
            .id(id)
            .orderId(orderId)
            .feeAmount(feeAmount)
            .feeCurrency(feeCurrency)
            .build();

    assertThat(copy.getType()).isEqualTo(type);
    assertThat(copy.getOriginalAmount()).isEqualTo(originalAmount);
    assertThat(copy.getCurrencyPair()).isEqualTo(currencyPair);
    assertThat(copy.getPrice()).isEqualTo(price);
    assertThat(copy.getTimestamp()).isEqualTo(timestamp);
    assertThat(copy.getId()).isEqualTo(id);
    assertThat(copy.getOrderId()).isEqualTo(orderId);
    assertThat(copy.getFeeAmount()).isEqualTo(feeAmount);
    assertThat(copy.getFeeCurrency()).isEqualTo(feeCurrency);
  }

  @Test
  public void testBuilderFrom() {
    final OrderType type = OrderType.ASK;
    final Double originalAmount = new Double("100.501");
    final CurrencyPair currencyPair = CurrencyPair.BTC_USD;
    final Double price = new Double("250.34");
    final Long timestamp = System.currentTimeMillis();
    final String id = "id";
    final String orderId = "OrderId";
    final Double feeAmount = new Double("0");
    final Currency feeCurrency = Currency.BTC;

    final UserTrade original =
        new UserTrade(
            type,
            originalAmount,
            currencyPair,
            price,
            timestamp,
            id,
            orderId,
            feeAmount,
            feeCurrency);
    final UserTrade copy = UserTrade.Builder.from(original).build();

    assertThat(copy.getType()).isEqualTo(original.getType());
    assertThat(copy.getOriginalAmount()).isEqualTo(original.getOriginalAmount());
    assertThat(copy.getCurrencyPair()).isEqualTo(original.getCurrencyPair());
    assertThat(copy.getPrice()).isEqualTo(original.getPrice());
    assertThat(copy.getTimestamp()).isEqualTo(original.getTimestamp());
    assertThat(copy.getId()).isEqualTo(original.getId());
    assertThat(copy.getOrderId()).isEqualTo(original.getOrderId());
    assertThat(copy.getFeeAmount()).isEqualTo(original.getFeeAmount());
    assertThat(copy.getFeeCurrency()).isEqualTo(original.getFeeCurrency());
  }

  @Test
  public void returnsEqualsCorrectlyWithEqualUserTrades() {
    final OrderType type = OrderType.ASK;
    final Double originalAmount = new Double("100.501");
    final CurrencyPair currencyPair = CurrencyPair.BTC_USD;
    final Double price = new Double("250.34");
    final Long timestamp = System.currentTimeMillis();
    final String id = "id";
    final String orderId = "OrderId";
    final Double feeAmount = new Double("0");
    final Currency feeCurrency = Currency.BTC;

    final UserTrade original =
        new UserTrade(
            type,
            originalAmount,
            currencyPair,
            price,
            timestamp,
            id,
            orderId,
            feeAmount,
            feeCurrency);
    final UserTrade copy =
        new UserTrade(
            type,
            originalAmount,
            currencyPair,
            price,
            timestamp,
            id,
            orderId,
            feeAmount,
            feeCurrency);

    assertEquals(original, copy);
  }

  @Test
  public void returnsEqualsCorrectlyWithUnequalUserTradesOfUserTradeAttributes() {
    final UserTrade original =
        new UserTrade(
            OrderType.ASK,
            new Double("100.501"),
            CurrencyPair.BTC_USD,
            new Double("250.34"),
            System.currentTimeMillis(),
            "id",
            "FooOrderId",
            new Double("0"),
            Currency.BTC);

    final UserTrade copy =
        new UserTrade(
            OrderType.ASK,
            new Double("100.501"),
            CurrencyPair.BTC_USD,
            new Double("250.34"),
            System.currentTimeMillis(),
            "id",
            "BarOrderId",
            new Double("0.15"),
            Currency.USD);

    assertNotEquals(original, copy);
  }

  @Test
  public void returnsEqualsCorrectlyWithUnequalUserTradesOfTradeAttributes() {
    final UserTrade original =
        new UserTrade(
            OrderType.ASK,
            new Double("100.501"),
            CurrencyPair.BTC_USD,
            new Double("250.34"),
            System.currentTimeMillis(),
            "FooTradeId",
            "OrderId",
            new Double("0"),
            Currency.BTC);

    final UserTrade copy =
        new UserTrade(
            OrderType.ASK,
            new Double("100.501"),
            CurrencyPair.BTC_USD,
            new Double("250.34"),
            System.currentTimeMillis(),
            "BarTradeId",
            "OrderId",
            new Double("0"),
            Currency.BTC);

    assertNotEquals(original, copy);
  }
}
