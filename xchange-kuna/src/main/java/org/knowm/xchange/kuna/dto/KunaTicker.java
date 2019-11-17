package org.knowm.xchange.kuna.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Ticker of crypto currency. Instances of this type are immutable, constructed with a dedicated
 * Builder implementation.
 *
 * @author Dat Bui
 */
@JsonDeserialize(builder = KunaTicker.Builder.class)
public class KunaTicker {

  private Double buy;
  private Double sell;
  private Double low;
  private Double high;
  private Double last;
  private Double vol;
  private Double price;

  /** Hide default constructor. */
  private KunaTicker() {}

  /**
   * Creates new builder.
   *
   * @return builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Returns cryptocurrency price for buy.
   *
   * @return buy price
   */
  public Double getBuy() {
    return buy;
  }

  /**
   * Returns cryptocurrency price for sale.
   *
   * @return sale price
   */
  public Double getSell() {
    return sell;
  }

  /**
   * Returns the lowest price of the trade in 24 hours.
   *
   * @return the lowest price
   */
  public Double getLow() {
    return low;
  }

  /**
   * Returns the highest price of the trade in 24 hours.
   *
   * @return the highest price
   */
  public Double getHigh() {
    return high;
  }

  /**
   * Returns price of the last trade.
   *
   * @return price of the last trade
   */
  public Double getLast() {
    return last;
  }

  /**
   * Returns volume of trading in base currency for 24 hours.
   *
   * @return volume of trading
   */
  public Double getVol() {
    return vol;
  }

  /**
   * Returns total price of trading in quote currency for 24 hours.
   *
   * @return total price of trading
   */
  public Double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "KunaTicker{"
        + "buy="
        + buy
        + ", sell="
        + sell
        + ", low="
        + low
        + ", high="
        + high
        + ", last="
        + last
        + ", vol="
        + vol
        + ", price="
        + price
        + '}';
  }

  public static class Builder {

    private KunaTicker target = new KunaTicker();

    public Builder withBuy(double buy) {
      if (buy >= 0) {
        target.buy = Double.valueOf(buy);
      } else {
        throw new IllegalArgumentException("Ticker 'buy' cannot be negative");
      }
      return this;
    }

    public Builder withSell(double sell) {
      if (sell >= 0) {
        target.sell = Double.valueOf(sell);
      } else {
        throw new IllegalArgumentException("Ticker 'sell' cannot be negative");
      }
      return this;
    }

    public Builder withLow(double low) {
      if (low >= 0) {
        target.low = Double.valueOf(low);
      } else {
        throw new IllegalArgumentException("Ticker 'low' cannot be negative");
      }
      return this;
    }

    public Builder withHigh(double high) {
      if (high >= 0) {
        target.high = Double.valueOf(high);
      } else {
        throw new IllegalArgumentException("Ticker 'high' cannot be negative");
      }
      return this;
    }

    public Builder withLast(double last) {
      if (last >= 0) {
        target.last = Double.valueOf(last);
      } else {
        throw new IllegalArgumentException("Ticker 'last' cannot be negative");
      }
      return this;
    }

    public Builder withVol(double volume) {
      if (volume >= 0) {
        target.vol = Double.valueOf(volume);
      } else {
        throw new IllegalArgumentException("Ticker 'volume' cannot be negative");
      }
      return this;
    }

    public Builder withPrice(double price) {
      if (price >= 0) {
        target.price = Double.valueOf(price);
      } else {
        throw new IllegalArgumentException("Ticker 'price' cannot be negative");
      }
      return this;
    }

    public KunaTicker build() {
      return this.target;
    }
  }
}
