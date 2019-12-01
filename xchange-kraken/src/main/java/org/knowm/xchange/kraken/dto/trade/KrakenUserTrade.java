package org.knowm.xchange.kraken.dto.trade;

import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.trade.UserTrade;

import java.util.Date;

public class KrakenUserTrade extends UserTrade {

    private final Double cost;

    public KrakenUserTrade(
            OrderType type,
            Double originalAmount,
            CurrencyPair currencyPair,
            Double price,
            Date timestamp,
            String id,
            String orderId,
            Double feeAmount,
            Currency feeCurrency,
            Double cost) {
        super(
                type, originalAmount, currencyPair, price, timestamp.getTime(), id, orderId, feeAmount, feeCurrency);
        this.cost = cost;
    }

    public Double getCost() {
        return cost;
    }

    public static class Builder extends UserTrade.Builder {

        private Double cost;

        public static Builder from(KrakenUserTrade trade) {
            Builder builder = new Builder().cost(trade.getCost());
            builder
                    .orderId(trade.getOrderId())
                    .feeAmount(trade.getFeeAmount())
                    .feeCurrency(trade.getFeeCurrency());
            builder
                    .type(trade.getType())
                    .originalAmount(trade.getOriginalAmount())
                    .currencyPair(trade.getCurrencyPair())
                    .price(trade.getPrice())
                    .timestamp(trade.getTimestamp())
                    .id(trade.getId());
            return builder;
        }

        public Builder cost(Double cost) {
            this.cost = cost;
            return this;
        }

        public KrakenUserTrade build() {
            return new KrakenUserTrade(
                    type,
                    originalAmount,
                    currencyPair,
                    price,
                    new Date(timestamp),
                    id,
                    orderId,
                    feeAmount,
                    feeCurrency,
                    cost);
        }
    }
}
