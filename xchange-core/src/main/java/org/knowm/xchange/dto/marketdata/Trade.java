package org.knowm.xchange.dto.marketdata;

import java.io.Serializable;
import java.util.Objects;

import net.openhft.chronicle.wire.AbstractMarshallable;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.service.marketdata.MarketDataService;

/** Data object representing a Trade */
public class Trade extends AbstractMarshallable implements Serializable {

  private static final long serialVersionUID = -4078893146776655648L;

  /** Did this trade result from the execution of a bid or a ask? */
  protected final OrderType type;

  /** Amount that was traded */
  protected final Double originalAmount;

  /** The currency pair */
  protected final CurrencyPair currencyPair;

  /** The price */
  protected final Double price;

  /** The timestamp of the trade according to the exchange's server, null if not provided */
  protected final Long timestamp;

  /** The trade id */
  protected final String id;

  private String makerOrderId;

  private String takerOrderId;

  /**
   * This constructor is called to create a public Trade object in {@link
   * MarketDataService#getTrades(org.knowm.xchange.currency.CurrencyPair, Object...)}
   * implementations) since it's missing the orderId and fee parameters.
   *
   * @param type The trade type (BID side or ASK side)
   * @param originalAmount The depth of this trade
   * @param price The price (either the bid or the ask)
   * @param timestamp The timestamp of the trade according to the exchange's server, null if not
   *     provided
   * @param id The id of the trade
   */
  public Trade(
      OrderType type,
      Double originalAmount,
      CurrencyPair currencyPair,
      Double price,
      Long timestamp,
      String id) {

    this.type = type;
    this.originalAmount = originalAmount;
    this.currencyPair = currencyPair;
    this.price = price;
    this.timestamp = timestamp;
    this.id = id;
  }

  public OrderType getType() {

    return type;
  }

  public Double getOriginalAmount() {

    return originalAmount;
  }

  public CurrencyPair getCurrencyPair() {

    return currencyPair;
  }

  public Double getPrice() {

    return price;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public String getId() {

    return id;
  }

  public String getMakerOrderId() {
    return makerOrderId;
  }

  public void setMakerOrderId(String makerOrderId) {
    this.makerOrderId = makerOrderId;
  }

  public String getTakerOrderId() {
    return takerOrderId;
  }

  public void setTakerOrderId(String takerOrderId) {
    this.takerOrderId = takerOrderId;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return this.id.equals(((Trade) o).getId());
  }

  @Override
  public int hashCode() {

    return Objects.hashCode(id);
  }

  @Override
  public String toString() {
    return "Trade{"
        + "type="
        + type
        + ", originalAmount="
        + originalAmount
        + ", currencyPair="
        + currencyPair
        + ", price="
        + price
        + ", timestamp="
        + timestamp
        + ", id='"
        + id
        + '\''
        + ", makerOrderId='"
        + makerOrderId
        + '\''
        + ", takerOrderId='"
        + takerOrderId
        + '\''
        + '}';
  }

  public static class Builder {

    protected OrderType type;
    protected Double originalAmount;
    protected CurrencyPair currencyPair;
    protected Double price;
    protected Long timestamp;
    protected String id;

    public static Builder from(Trade trade) {
      return new Builder()
          .type(trade.getType())
          .originalAmount(trade.getOriginalAmount())
          .currencyPair(trade.getCurrencyPair())
          .price(trade.getPrice())
          .timestamp(trade.getTimestamp())
          .id(trade.getId());
    }

    public Builder type(OrderType type) {

      this.type = type;
      return this;
    }

    public Builder originalAmount(Double originalAmount) {

      this.originalAmount = originalAmount;
      return this;
    }

    public Builder currencyPair(CurrencyPair currencyPair) {

      this.currencyPair = currencyPair;
      return this;
    }

    public Builder price(Double price) {

      this.price = price;
      return this;
    }

    public Builder timestamp(Long timestamp) {

      this.timestamp = timestamp;
      return this;
    }

    public Builder id(String id) {

      this.id = id;
      return this;
    }

    public Trade build() {

      return new Trade(type, originalAmount, currencyPair, price, timestamp, id);
    }
  }
}
