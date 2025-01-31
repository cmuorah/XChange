package org.knowm.xchange.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import net.openhft.chronicle.wire.AbstractMarshallable;
import org.knowm.xchange.currency.CurrencyPair;

/** Data object representing an order */
public abstract class Order extends AbstractMarshallable implements Serializable{

  private static final long serialVersionUID = -8132103343647993259L;

  /** Order type i.e. bid or ask */
  private final OrderType type;
  /** Amount to be ordered / amount that was ordered */
  private final Double originalAmount;
  /** The currency pair */
  private final CurrencyPair currencyPair;
  /** An identifier that uniquely identifies the order */
  private final String id;
  /** The timestamp on the order according to the exchange's server, null if not provided */
  private final Long timestamp;
  /** Any applicable order flags */
  private final Set<IOrderFlags> flags = new HashSet<>();
  /** Status of order during it lifecycle */
  private OrderStatus status;
  /** Amount to be ordered / amount that has been matched against order on the order book/filled */
  private Double cumulativeAmount;
  /** Weighted Average price of the fills in the order */
  private Double averagePrice;
  /** The total of the fees incurred for all transactions related to this order */
  private Double fee;
  /** The leverage to use for margin related to this order */
  private String leverage = null;

  /**
   * @param type Either BID (buying) or ASK (selling)
   * @param originalAmount The amount to trade
   * @param currencyPair currencyPair The identifier (e.g. BTC/USD)
   * @param id An id (usually provided by the exchange)
   * @param timestamp the absolute time for this order according to the exchange's server, null if
   *     not provided
   */
  public Order(
      OrderType type, Double originalAmount, CurrencyPair currencyPair, String id, Long timestamp) {
    this(type, originalAmount, currencyPair, id, timestamp, null, null, null, null);
  }

  /**
   * @param type Either BID (buying) or ASK (selling)
   * @param originalAmount The amount to trade
   * @param currencyPair currencyPair The identifier (e.g. BTC/USD)
   * @param id An id (usually provided by the exchange)
   * @param timestamp the absolute time for this order according to the exchange's server, null if
   *     not provided
   * @param averagePrice the averagePrice of fill belonging to the order
   * @param cumulativeAmount the amount that has been filled
   * @param fee the fee associated with this order
   * @param status the status of the order at the exchange
   */
  public Order(
      OrderType type,
      Double originalAmount,
      CurrencyPair currencyPair,
      String id,
      Long timestamp,
      Double averagePrice,
      Double cumulativeAmount,
      Double fee,
      OrderStatus status) {

    this.type = type;
    this.originalAmount = originalAmount;
    this.currencyPair = currencyPair;
    this.id = id;
    this.timestamp = timestamp;
    this.averagePrice = averagePrice;
    this.cumulativeAmount = cumulativeAmount;
    this.fee = fee;
    this.status = status;
  }

  private static String print(Double value) {
    return value == null ? null : value.toString();
  }

  /**
   * The total of the fees incurred for all transactions related to this order
   *
   * @return null if this information is not available on the order level on the given exchange in
   *     which case you will have to navigate trades which filled this order to calculate it
   */
  public Double getFee() {
    return fee;
  }

  public void setFee(Double fee) {
    this.fee = fee;
  }

  /** @return The type (BID or ASK) */
  public OrderType getType() {

    return type;
  }

  /**
   * @return The type (PENDING_NEW, NEW, PARTIALLY_FILLED, FILLED, PENDING_CANCEL, CANCELED,
   *     PENDING_REPLACE, REPLACED, STOPPED, REJECTED or EXPIRED)
   */
  public OrderStatus getStatus() {

    return status;
  }

  /** The amount to trade */
  public Double getOriginalAmount() {

    return originalAmount;
  }

  /** The amount that has been filled */
  public Double getCumulativeAmount() {

    return cumulativeAmount;
  }

  public void setCumulativeAmount(Double cumulativeAmount) {

    this.cumulativeAmount = cumulativeAmount;
  }

  public Double getCumulativeCounterAmount() {
    if (cumulativeAmount != null && averagePrice != null && averagePrice > 0) {
      return cumulativeAmount * averagePrice;
    }
    return null;
  }

  /** @return The remaining order amount */
  public Double getRemainingAmount() {
    if (cumulativeAmount != null && originalAmount != null) {
      return originalAmount - cumulativeAmount;
    }
    return originalAmount;
  }

  /**
   * The average price of the fills in the order.
   *
   * @return null if this information is not available on the order level on the given exchange in
   *     which case you will have to navigate trades which filled this order to calculate it
   */
  public Double getAveragePrice() {

    return averagePrice;
  }

  public void setAveragePrice(Double averagePrice) {

    this.averagePrice = averagePrice;
  }

  public CurrencyPair getCurrencyPair() {

    return currencyPair;
  }

  /** @return A unique identifier (normally provided by the exchange) */
  public String getId() {

    return id;
  }

  public Long getTimestamp() {

    return timestamp;
  }

  public Set<IOrderFlags> getOrderFlags() {

    return flags;
  }

  public void setOrderFlags(Set<IOrderFlags> flags) {

    this.flags.clear();
    if (flags != null) {
      this.flags.addAll(flags);
    }
  }

  public boolean hasFlag(IOrderFlags flag) {

    return flags.contains(flag);
  }

  public void addOrderFlag(IOrderFlags flag) {

    flags.add(flag);
  }

  public void setOrderStatus(OrderStatus status) {

    this.status = status;
  }

  public String getLeverage() {
    return leverage;
  }

  public void setLeverage(String leverage) {
    this.leverage = leverage;
  }

  @Override
  public String toString() {

    return "Order [type="
        + type
        + ", originalAmount="
        + print(originalAmount)
        + ", cumulativeAmount="
        + print(cumulativeAmount)
        + ", averagePrice="
        + print(averagePrice)
        + ", fee="
        + print(fee)
        + ", currencyPair="
        + currencyPair
        + ", id="
        + id
        + ", timestamp="
        + timestamp
        + ", status="
        + status
        + ", flags="
        + flags
        + "]";
  }

  @Override
  public int hashCode() {

    int hash = 7;
    hash = 83 * hash + (this.type != null ? this.type.hashCode() : 0);
    hash = 83 * hash + (this.originalAmount != null ? this.originalAmount.hashCode() : 0);
    hash = 83 * hash + (this.currencyPair != null ? this.currencyPair.hashCode() : 0);
    hash = 83 * hash + (this.id != null ? this.id.hashCode() : 0);
    hash = 83 * hash + (this.timestamp != null ? this.timestamp.hashCode() : 0);
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
    final Order other = (Order) obj;
    if (this.type != other.type) {
      return false;
    }
    if ((this.originalAmount == null)
        ? (other.originalAmount != null)
        : this.originalAmount.compareTo(other.originalAmount) != 0) {
      return false;
    }
    if (!Objects.equals(this.currencyPair, other.currencyPair)) {
      return false;
    }
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return Objects.equals(this.timestamp, other.timestamp);
  }

  public enum OrderType {

    /** Buying order (the trader is providing the counter currency) */
    BID,
    /** Selling order (the trader is providing the base currency) */
    ASK,
    /**
     * This is to close a short position when trading crypto currency derivatives such as swaps,
     * futures for CFD's.
     */
    EXIT_ASK,
    /**
     * This is to close a long position when trading crypto currency derivatives such as swaps,
     * futures for CFD's.
     */
    EXIT_BID;

    public OrderType getOpposite() {
      switch (this) {
        case BID:
          return ASK;
        case ASK:
          return BID;
        case EXIT_ASK:
          return EXIT_BID;
        case EXIT_BID:
          return EXIT_ASK;
        default:
          return null;
      }
    }
  }

  public enum OrderStatus {

    /** Initial order when instantiated */
    PENDING_NEW,
    /** Initial order when placed on the order book at exchange */
    NEW,
    /** Partially match against opposite order on order book at exchange */
    PARTIALLY_FILLED,
    /** Fully match against opposite order on order book at exchange */
    FILLED,
    /** Waiting to be removed from order book at exchange */
    PENDING_CANCEL,
    /** Order was partially canceled at exchange */
    PARTIALLY_CANCELED,
    /** Removed from order book at exchange */
    CANCELED,
    /** Waiting to be replaced by another order on order book at exchange */
    PENDING_REPLACE,
    /** Order has been replace by another order on order book at exchange */
    REPLACED,
    /** Order has been triggered at stop price */
    STOPPED,
    /** Order has been rejected by exchange and not place on order book */
    REJECTED,
    /** Order has expired it's time to live or trading session and been removed from order book */
    EXPIRED,
    /**
     * The exchange returned a state which is not in the exchange's API documentation. The state of
     * the order cannot be confirmed.
     */
    UNKNOWN;

    /** Returns true for final {@link OrderStatus} */
    public boolean isFinal() {
      switch (this) {
        case FILLED:
        case PARTIALLY_CANCELED: // Cancelled, partially-executed order is final status.
        case CANCELED:
        case REPLACED:
        case STOPPED:
        case REJECTED:
        case EXPIRED:
          return true;
        default:
          return false;
      }
    }

    /** Returns true when open {@link OrderStatus} */
    public boolean isOpen() {
      switch (this) {
        case PENDING_NEW:
        case NEW:
        case PARTIALLY_FILLED:
          return true;
        default:
          return false;
      }
    }
  }

  public interface IOrderFlags {}

  public abstract static class Builder {

    protected final Set<IOrderFlags> flags = new HashSet<>();
    protected OrderType orderType;
    protected Double originalAmount;
    protected Double cumulativeAmount;
    protected Double remainingAmount;
    protected CurrencyPair currencyPair;
    protected String id;
    protected Long timestamp;
    protected Double averagePrice;
    protected OrderStatus status;
    protected Double fee;

    protected Builder(OrderType orderType, CurrencyPair currencyPair) {

      this.orderType = orderType;
      this.currencyPair = currencyPair;
    }

    public Builder orderType(OrderType orderType) {

      this.orderType = orderType;
      return this;
    }

    public Builder orderStatus(OrderStatus status) {

      this.status = status;
      return this;
    }

    public Builder originalAmount(Double originalAmount) {

      this.originalAmount = originalAmount;
      return this;
    }

    public Builder cumulativeAmount(Double cumulativeAmount) {

      this.cumulativeAmount = cumulativeAmount;
      return this;
    }

    public Builder fee(Double fee) {

      this.fee = fee;
      return this;
    }

    public Builder remainingAmount(Double remainingAmount) {

      this.remainingAmount = remainingAmount;
      return this;
    }

    public Builder averagePrice(Double averagePrice) {

      this.averagePrice = averagePrice;
      return this;
    }

    public Builder currencyPair(CurrencyPair currencyPair) {

      this.currencyPair = currencyPair;
      return this;
    }

    public Builder id(String id) {

      this.id = id;
      return this;
    }

    public Builder timestamp(Long timestamp) {

      this.timestamp = timestamp;
      return this;
    }

    public Builder flags(Set<IOrderFlags> flags) {

      this.flags.addAll(flags);
      return this;
    }

    public Builder flag(IOrderFlags flag) {

      this.flags.add(flag);
      return this;
    }

    public abstract Order build();
  }
}
