package org.knowm.xchange.dto.trade;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;

import java.util.Set;

/**
 * DTO representing a limit order
 *
 * <p>A limit order lets you set a minimum or maximum price before your trade will be treated by the
 * exchange as a {@link MarketOrder}. There is no guarantee that your conditions will be met on the
 * exchange, so your order may not be executed. However, until you become very experienced, almost
 * all orders should be limit orders to protect yourself.
 */
public class LimitOrder extends Order implements Comparable<LimitOrder> {

    private static final long serialVersionUID = -5166848178471347541L;

    /**
     * The limit price
     */
    protected final Double limitPrice;

    /**
     * @param type           Either BID (buying) or ASK (selling)
     * @param originalAmount The amount to trade
     * @param currencyPair   The identifier (e.g. BTC/USD)
     * @param id             An id (usually provided by the exchange)
     * @param timestamp      a Long object representing the order's timestamp according to the exchange's
     *                       server, null if not provided
     * @param limitPrice     In a BID this is the highest acceptable price, in an ASK this is the lowest
     *                       acceptable price
     */
    public LimitOrder(
            OrderType type,
            Double originalAmount,
            CurrencyPair currencyPair,
            String id,
            Long timestamp,
            Double limitPrice) {

        super(type, originalAmount, currencyPair, id, timestamp);
        this.limitPrice = limitPrice;
    }

    /**
     * @param type             Either BID (buying) or ASK (selling)
     * @param originalAmount   The amount to trade
     * @param cumulativeAmount The cumulative amount
     * @param currencyPair     The identifier (e.g. BTC/USD)
     * @param id               An id (usually provided by the exchange)
     * @param timestamp        a Long object representing the order's timestamp according to the exchange's
     *                         server, null if not provided
     * @param limitPrice       In a BID this is the highest acceptable price, in an ASK this is the lowest
     *                         acceptable price
     */
    public LimitOrder(
            OrderType type,
            Double originalAmount,
            Double cumulativeAmount,
            CurrencyPair currencyPair,
            String id,
            Long timestamp,
            Double limitPrice) {

        super(
                type,
                originalAmount,
                currencyPair,
                id,
                timestamp,
                0d,
                cumulativeAmount,
                0d,
                OrderStatus.PENDING_NEW);
        this.limitPrice = limitPrice;
    }

    /**
     * @param type             Either BID (buying) or ASK (selling)
     * @param originalAmount   The amount to trade
     * @param currencyPair     The identifier (e.g. BTC/USD)
     * @param id               An id (usually provided by the exchange)
     * @param timestamp        a Long object representing the order's timestamp according to the exchange's
     *                         server, null if not provided
     * @param limitPrice       In a BID this is the highest acceptable price, in an ASK this is the lowest
     *                         acceptable price
     * @param averagePrice     the weighted average price of any fills belonging to the order
     * @param cumulativeAmount the amount that has been filled
     * @param fee              the fee associated with this order
     * @param status           the status of the order at the exchange or broker
     */
    public LimitOrder(
            OrderType type,
            Double originalAmount,
            CurrencyPair currencyPair,
            String id,
            Long timestamp,
            Double limitPrice,
            Double averagePrice,
            Double cumulativeAmount,
            Double fee,
            OrderStatus status) {

        super(
                type,
                originalAmount,
                currencyPair,
                id,
                timestamp,
                averagePrice,
                cumulativeAmount,
                fee,
                status);
        this.limitPrice = limitPrice;
    }

    /**
     * @return The limit price
     */
    public Double getLimitPrice() {

        return limitPrice;
    }

    @Override
    public String toString() {

        return "LimitOrder [limitPrice=" + printLimitPrice() + ", " + super.toString() + "]";
    }

    private String printLimitPrice() {
        return limitPrice == null ? null : limitPrice.toString();
    }

    @Override
    public int compareTo(LimitOrder limitOrder) {

        final int ret;

        if (this.getType() == limitOrder.getType()) {
            // Same side
            ret =
                    this.getLimitPrice().compareTo(limitOrder.getLimitPrice())
                            * (getType() == OrderType.BID ? -1 : 1);
        } else {
            // Keep bid side be less than ask side
            ret = this.getType() == OrderType.BID ? -1 : 1;
        }

        return ret;
    }

    @Override
    public int hashCode() {

        int hash = super.hashCode();
        hash = 59 * hash + (this.limitPrice != null ? this.limitPrice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LimitOrder other = (LimitOrder) obj;
        if (this.limitPrice == null
                ? (other.limitPrice != null)
                : this.limitPrice.compareTo(other.limitPrice) != 0) {
            return false;
        }
        return super.equals(obj);
    }

    public static class Builder extends Order.Builder {

        protected Double limitPrice;

        public Builder(OrderType orderType, CurrencyPair currencyPair) {

            super(orderType, currencyPair);
        }

        public static Builder from(Order order) {

            Builder builder =
                    new Builder(order.getType(), order.getCurrencyPair())
                            .originalAmount(order.getOriginalAmount())
                            .cumulativeAmount(order.getCumulativeAmount())
                            .timestamp(order.getTimestamp())
                            .id(order.getId())
                            .flags(order.getOrderFlags())
                            .orderStatus(order.getStatus())
                            .fee(order.getFee())
                            .averagePrice(order.getAveragePrice());
            if (order instanceof LimitOrder) {
                LimitOrder limitOrder = (LimitOrder) order;
                builder.limitPrice(limitOrder.getLimitPrice());
            }
            return builder;
        }

        @Override
        public Builder orderType(OrderType orderType) {

            return (Builder) super.orderType(orderType);
        }

        @Override
        public Builder originalAmount(Double originalAmount) {

            return (Builder) super.originalAmount(originalAmount);
        }

        @Override
        public Builder cumulativeAmount(Double originalAmount) {

            return (Builder) super.cumulativeAmount(originalAmount);
        }

        public Builder remainingAmount(Double remainingAmount) {

            return (Builder) super.remainingAmount(remainingAmount);
        }

        @Override
        public Builder currencyPair(CurrencyPair currencyPair) {

            return (Builder) super.currencyPair(currencyPair);
        }

        @Override
        public Builder id(String id) {

            return (Builder) super.id(id);
        }

        @Override
        public Builder timestamp(Long timestamp) {

            return (Builder) super.timestamp(timestamp);
        }

        @Override
        public Builder orderStatus(Order.OrderStatus status) {

            return (Builder) super.orderStatus(status);
        }

        @Override
        public Builder averagePrice(Double averagePrice) {

            return (Builder) super.averagePrice(averagePrice);
        }

        @Override
        public Builder flag(IOrderFlags flag) {

            return (Builder) super.flag(flag);
        }

        @Override
        public Builder flags(Set<IOrderFlags> flags) {

            return (Builder) super.flags(flags);
        }

        @Override
        public Builder fee(Double fee) {
            return (Builder) super.fee(fee);
        }

        public Builder limitPrice(Double limitPrice) {

            this.limitPrice = limitPrice;
            return this;
        }

        public LimitOrder build() {
            Double cumAmount;
            if(originalAmount == null || remainingAmount == null)
                    cumAmount = cumulativeAmount;
            else
                cumAmount = originalAmount - remainingAmount;
            LimitOrder order =
                    new LimitOrder(
                            orderType,
                            originalAmount,
                            currencyPair,
                            id,
                            timestamp,
                            limitPrice,
                            averagePrice,
                            cumAmount,
                            fee,
                            status);
            order.setOrderFlags(flags);
            return order;
        }
    }
}
