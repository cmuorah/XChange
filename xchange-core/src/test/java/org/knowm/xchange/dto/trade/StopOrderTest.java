package org.knowm.xchange.dto.trade;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;

public class StopOrderTest {
  @Test
  public void testBuilder() {
    final Order.OrderType type = Order.OrderType.BID;
    final Double originalAmount = new Double("99.401");
    final Double averagePrice = new Double("255.00");
    final Double cumulativeAmount = new Double("0.00");
    final CurrencyPair currencyPair = CurrencyPair.LTC_BTC;
    final Double limitPrice = new Double("251.64");
    final Double stopPrice = new Double("266.21");
    final Double fee = new Double("22.2");
    final Long timestamp = System.currentTimeMillis();
    final String id = "id";
    final Order.OrderStatus status = Order.OrderStatus.FILLED;

    final StopOrder copy =
        new StopOrder.Builder(type, currencyPair)
            .originalAmount(originalAmount)
            .averagePrice(averagePrice)
            .cumulativeAmount(cumulativeAmount)
            .limitPrice(limitPrice)
            .stopPrice(stopPrice)
            .orderStatus(status)
            .timestamp(timestamp)
            .id(id)
            .flag(TestFlags.TEST1)
            .fee(fee)
            .build();

    assertThat(copy.getType()).isEqualTo(type);
    assertThat(copy.getOriginalAmount()).isEqualTo(originalAmount);
    assertThat(copy.getAveragePrice()).isEqualTo(averagePrice);
    assertThat(copy.getCumulativeAmount()).isEqualTo(cumulativeAmount);
    assertThat(copy.getCurrencyPair()).isEqualTo(currencyPair);
    assertThat(copy.getStopPrice()).isEqualTo(stopPrice);
    assertThat(copy.getLimitPrice()).isEqualTo(limitPrice);
    assertThat(copy.getTimestamp()).isEqualTo(timestamp);
    assertThat(copy.getId()).isEqualTo(id);
    assertThat(copy.getOrderFlags()).hasSize(1);
    assertThat(copy.getOrderFlags()).containsExactly(TestFlags.TEST1);
    assertThat(copy.hasFlag(TestFlags.TEST1));
    assertThat(copy.getStatus()).isEqualTo(status);
    assertThat(copy.getFee()).isEqualTo(fee);
  }

  @Test
  public void testBuilderFrom() {
    final Order.OrderType type = Order.OrderType.ASK;
    final Double originalAmount = new Double("100.501");
    final CurrencyPair currencyPair = CurrencyPair.BTC_USD;
    final Double limitPrice = new Double("250.34");
    final Double averagePrice = new Double("255.00");
    final Double cumulativeAmount = new Double("0.00");
    final Double stopPrice = new Double("266.21");
    final Double fee = new Double("22.2");
    final Long timestamp = System.currentTimeMillis();
    final String id = "id";
    final Order.OrderStatus status = Order.OrderStatus.FILLED;

    final StopOrder original =
        new StopOrder(
            type,
            originalAmount,
            currencyPair,
            id,
            timestamp,
            stopPrice,
            limitPrice,
            averagePrice,
            cumulativeAmount,
            fee,
            status);
    original.addOrderFlag(TestFlags.TEST1);
    original.addOrderFlag(TestFlags.TEST3);
    final StopOrder copy = StopOrder.Builder.from(original).build();

    assertThat(copy).isEqualToComparingFieldByField(original);
  }

  private enum TestFlags implements Order.IOrderFlags {
    TEST1,
    TEST2,
    TEST3
  }
}
