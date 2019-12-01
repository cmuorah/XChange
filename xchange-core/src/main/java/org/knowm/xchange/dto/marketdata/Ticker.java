package org.knowm.xchange.dto.marketdata;

import java.io.Serializable;

import net.openhft.chronicle.wire.AbstractMarshallable;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.utils.Assert;

/**
 * A class encapsulating the information a "Ticker" can contain. Some fields can be empty if not
 * provided by the exchange.
 *
 * <p>A ticker contains data representing the latest trade.
 */
public final class Ticker extends AbstractMarshallable implements Serializable {

  private static final long serialVersionUID = -3247730106987193154L;

  private final CurrencyPair currencyPair;
  private final Double open;
  private final Double last;
  private final Double bid;
  private final Double ask;
  private final Double high;
  private final Double low;
  private final Double vwap;
  private final Double volume;
  private final Double quoteVolume;
  /** the timestamp of the ticker according to the exchange's server, null if not provided */
  private final Long timestamp;

  private final Double bidSize;
  private final Double askSize;

  /**
   * Constructor
   *
   * @param currencyPair The tradable identifier (e.g. BTC in BTC/USD)
   * @param last Last price
   * @param bid Bid price
   * @param ask Ask price
   * @param high High price
   * @param low Low price
   * @param vwap Volume Weighted Average Price
   * @param volume 24h volume in base currency
   * @param quoteVolume 24h volume in counter currency
   * @param timestamp - the timestamp of the ticker according to the exchange's server, null if not
   *     provided
   * @param bidSize The instantaneous size at the bid price
   * @param askSize The instantaneous size at the ask price
   */
  private Ticker(
      CurrencyPair currencyPair,
      Double open,
      Double last,
      Double bid,
      Double ask,
      Double high,
      Double low,
      Double vwap,
      Double volume,
      Double quoteVolume,
      Long timestamp,
      Double bidSize,
      Double askSize) {
    this.open = open;
    this.currencyPair = currencyPair;
    this.last = last;
    this.bid = bid;
    this.ask = ask;
    this.high = high;
    this.low = low;
    this.vwap = vwap;
    this.volume = volume;
    this.quoteVolume = quoteVolume;
    this.timestamp = timestamp;
    this.bidSize = bidSize;
    this.askSize = askSize;
  }

  public CurrencyPair getCurrencyPair() {

    return currencyPair;
  }

  public Double getOpen() {

    return open;
  }

  public Double getLast() {

    return last;
  }

  public Double getBid() {

    return bid;
  }

  public Double getAsk() {

    return ask;
  }

  public Double getHigh() {

    return high;
  }

  public Double getLow() {

    return low;
  }

  public Double getVwap() {

    return vwap;
  }

  public Double getVolume() {

    return volume;
  }

  public Double getQuoteVolume() {
    if (quoteVolume == null && volume != null && last != null) {
      return volume * last;
    }
    return quoteVolume;
  }

  public Long getTimestamp() {

    return timestamp;
  }

  public Double getBidSize() {
    return bidSize;
  }

  public Double getAskSize() {
    return askSize;
  }

  @Override
  public String toString() {

    return "Ticker [currencyPair="
        + currencyPair
        + ", open="
        + open
        + ", last="
        + last
        + ", bid="
        + bid
        + ", ask="
        + ask
        + ", high="
        + high
        + ", low="
        + low
        + ",avg="
        + vwap
        + ", volume="
        + volume
        + ", quoteVolume="
        + quoteVolume
        + ", timestamp="
        + timestamp
        + ", bidSize="
        + bidSize
        + ", askSize="
        + askSize
        + "]";
  }

  /**
   * Builder to provide the following to {@link Ticker}:
   *
   * <ul>
   *   <li>Provision of fluent chained construction interface
   * </ul>
   */
  public static class Builder {

    private CurrencyPair currencyPair;
    private Double open;
    private Double last;
    private Double bid;
    private Double ask;
    private Double high;
    private Double low;
    private Double vwap;
    private Double volume;
    private Double quoteVolume;
    private Long timestamp;
    private Double bidSize;
    private Double askSize;

    // Prevent repeat builds
    private boolean isBuilt = false;

    public Ticker build() {

      validateState();

      Ticker ticker =
          new Ticker(
              currencyPair,
              open,
              last,
              bid,
              ask,
              high,
              low,
              vwap,
              volume,
              quoteVolume,
              timestamp,
              bidSize,
              askSize);

      isBuilt = true;

      return ticker;
    }

    private void validateState() {

      if (isBuilt) {
        throw new IllegalStateException("The entity has been built");
      }
    }

    public Builder currencyPair(CurrencyPair currencyPair) {
      Assert.notNull(currencyPair, "Null currencyPair");
      this.currencyPair = currencyPair;
      return this;
    }

    public Builder open(Double open) {

      this.open = open;
      return this;
    }

    public Builder last(Double last) {

      this.last = last;
      return this;
    }

    public Builder bid(Double bid) {

      this.bid = bid;
      return this;
    }

    public Builder ask(Double ask) {

      this.ask = ask;
      return this;
    }

    public Builder high(Double high) {

      this.high = high;
      return this;
    }

    public Builder low(Double low) {

      this.low = low;
      return this;
    }

    public Builder vwap(Double vwap) {

      this.vwap = vwap;
      return this;
    }

    public Builder volume(Double volume) {

      this.volume = volume;
      return this;
    }

    public Builder quoteVolume(Double quoteVolume) {

      this.quoteVolume = quoteVolume;
      return this;
    }

    public Builder timestamp(Long timestamp) {

      this.timestamp = timestamp;
      return this;
    }

    public Builder bidSize(Double bidSize) {
      this.bidSize = bidSize;
      return this;
    }

    public Builder askSize(Double askSize) {
      this.askSize = askSize;
      return this;
    }
  }
}
