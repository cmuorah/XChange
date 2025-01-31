package org.knowm.xchange.dto.trade;

import java.util.Objects;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.marketdata.Trade;
import org.knowm.xchange.service.trade.TradeService;
import org.knowm.xchange.service.trade.params.TradeHistoryParams;

/** Data object representing a user trade */
public class UserTrade extends Trade {

  private static final long serialVersionUID = -3021617981214969292L;

  /** The id of the order responsible for execution of this trade */
  private final String orderId;

  /** The fee that was charged by the exchange for this trade. */
  private final Double feeAmount;

  /** The currency in which the fee was charged. */
  private final Currency feeCurrency;

  /**
   * This constructor is called to construct user's trade objects (in {@link
   * TradeService#getTradeHistory(TradeHistoryParams)} implementations).
   *
   * @param type The trade type (BID side or ASK side)
   * @param originalAmount The depth of this trade
   * @param currencyPair The exchange identifier (e.g. "BTC/USD")
   * @param price The price (either the bid or the ask)
   * @param timestamp The timestamp of the trade
   * @param id The id of the trade
   * @param orderId The id of the order responsible for execution of this trade
   * @param feeAmount The fee that was charged by the exchange for this trade
   * @param feeCurrency The symbol of the currency in which the fee was charged
   */
  public UserTrade(
      OrderType type,
      Double originalAmount,
      CurrencyPair currencyPair,
      Double price,
      Long timestamp,
      String id,
      String orderId,
      Double feeAmount,
      Currency feeCurrency) {

    super(type, originalAmount, currencyPair, price, timestamp, id);

    this.orderId = orderId;
    this.feeAmount = feeAmount;
    this.feeCurrency = feeCurrency;
  }

  public String getOrderId() {

    return orderId;
  }

  public Double getFeeAmount() {

    return feeAmount;
  }

  public Currency getFeeCurrency() {

    return feeCurrency;
  }

  @Override
  public String toString() {
    return "UserTrade[type="
        + type
        + ", originalAmount="
        + originalAmount
        + ", currencyPair="
        + currencyPair
        + ", price="
        + price
        + ", "
        + "timestamp="
        + timestamp
        + ", id="
        + id
        + ", orderId='"
        + orderId
        + '\''
        + ", feeAmount="
        + feeAmount
        + ", feeCurrency='"
        + feeCurrency
        + '\''
        + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    UserTrade userTrade = (UserTrade) o;
    return Objects.equals(orderId, userTrade.orderId)
        && Objects.equals(feeAmount, userTrade.feeAmount)
        && Objects.equals(feeCurrency, userTrade.feeCurrency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), orderId, feeAmount, feeCurrency);
  }

  public static class Builder extends Trade.Builder {

    protected String orderId;
    protected Double feeAmount;
    protected Currency feeCurrency;

    public static Builder from(UserTrade trade) {
      return new Builder()
          .type(trade.getType())
          .originalAmount(trade.getOriginalAmount())
          .currencyPair(trade.getCurrencyPair())
          .price(trade.getPrice())
          .timestamp(trade.getTimestamp())
          .id(trade.getId())
          .orderId(trade.getOrderId())
          .feeAmount(trade.getFeeAmount())
          .feeCurrency(trade.getFeeCurrency());
    }

    @Override
    public Builder type(OrderType type) {
      return (Builder) super.type(type);
    }

    @Override
    public Builder originalAmount(Double originalAmount) {
      return (Builder) super.originalAmount(originalAmount);
    }

    @Override
    public Builder currencyPair(CurrencyPair currencyPair) {
      return (Builder) super.currencyPair(currencyPair);
    }

    @Override
    public Builder price(Double price) {
      return (Builder) super.price(price);
    }

    @Override
    public Builder timestamp(Long timestamp) {
      return (Builder) super.timestamp(timestamp);
    }

    @Override
    public Builder id(String id) {
      return (Builder) super.id(id);
    }

    public Builder orderId(String orderId) {
      this.orderId = orderId;
      return this;
    }

    public Builder feeAmount(Double feeAmount) {
      this.feeAmount = feeAmount;
      return this;
    }

    public Builder feeCurrency(Currency feeCurrency) {
      this.feeCurrency = feeCurrency;
      return this;
    }

    @Override
    public UserTrade build() {
      return new UserTrade(
          type,
          originalAmount,
          currencyPair,
          price,
          timestamp,
          id,
          orderId,
          feeAmount,
          feeCurrency);
    }
  }
}
