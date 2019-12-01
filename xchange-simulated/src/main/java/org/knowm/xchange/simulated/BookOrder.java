package org.knowm.xchange.simulated;

import static java.util.UUID.randomUUID;
import static org.knowm.xchange.dto.Order.OrderType.ASK;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.Order.OrderStatus;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.trade.LimitOrder;

/**
 * An order placed on the {@link SimulatedExchange} order book.
 *
 * @author Graham Crockford
 */
@Data
@Builder
final class BookOrder {

  private static final Double INF = Double.MAX_VALUE;
  private final String apiKey;
  private final Double originalAmount;
  private final String id;
  private final Date timestamp;
  private final Double limitPrice;
  private final OrderType type;
  @Builder.Default private volatile Double cumulativeAmount;
  private volatile Double averagePrice;
  @Builder.Default private volatile Double fee;

  static BookOrder fromOrder(Order original, String apiKey) {
    return BookOrder.builder()
        .apiKey(apiKey)
        .id(randomUUID().toString())
        .limitPrice(
            original instanceof LimitOrder
                ? ((LimitOrder) original).getLimitPrice()
                : original.getType() == ASK ? 0d : INF)
        .originalAmount(original.getOriginalAmount())
        .timestamp(new Date())
        .type(original.getType())
        .build();
  }

  Double getRemainingAmount() {
    return originalAmount - (cumulativeAmount);
  }

  boolean isDone() {
    return originalAmount.compareTo(cumulativeAmount) == 0;
  }

  boolean matches(BookOrder takerOrder) {
    return type == ASK
        ? limitPrice.compareTo(takerOrder.getLimitPrice()) <= 0
        : limitPrice.compareTo(takerOrder.getLimitPrice()) >= 0;
  }

  LimitOrder toOrder(CurrencyPair currencyPair) {
    return new LimitOrder.Builder(type, currencyPair)
        .id(id)
        .averagePrice(averagePrice)
        .cumulativeAmount(cumulativeAmount)
        .fee(fee)
        .limitPrice(limitPrice)
        .orderStatus(
            cumulativeAmount.compareTo(0d) == 0
                ? OrderStatus.NEW
                : cumulativeAmount.compareTo(originalAmount) == 0
                    ? OrderStatus.FILLED
                    : OrderStatus.PARTIALLY_FILLED)
        .originalAmount(originalAmount)
        .timestamp(timestamp.getTime())
        .build();
  }
}
