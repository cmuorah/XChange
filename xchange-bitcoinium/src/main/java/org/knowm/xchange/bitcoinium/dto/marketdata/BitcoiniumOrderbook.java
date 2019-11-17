package org.knowm.xchange.bitcoinium.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Data object representing Orderbook from Bitcoinium WebService */
public final class BitcoiniumOrderbook {

  private final BitcoiniumTicker bitcoiniumTicker;
  private final CondensedOrder[] bids;
  private final CondensedOrder[] asks;

  /**
   * Constructor
   *
   * @param bitcoiniumTicker
   * @param bids
   * @param asks
   */
  public BitcoiniumOrderbook(
      @JsonProperty("ticker") BitcoiniumTicker bitcoiniumTicker,
      @JsonProperty("bids") CondensedOrder[] bids,
      @JsonProperty("asks") CondensedOrder[] asks) {

    this.bitcoiniumTicker = bitcoiniumTicker;
    this.bids = bids;
    this.asks = asks;
  }

  public CondensedOrder[] getBids() {

    return bids;
  }

  public CondensedOrder[] getAsks() {

    return asks;
  }

  public BitcoiniumTicker getBitcoiniumTicker() {

    return bitcoiniumTicker;
  }

  /**
   * This class represents not just a single order in the orderbook, but a bunch of them condensed
   * into one.
   */
  public static final class CondensedOrder {

    private final Double price;
    private final Double volume;

    /**
     * Constructor
     *
     * @param price
     * @param volume
     */
    public CondensedOrder(@JsonProperty("p") Double price, @JsonProperty("v") Double volume) {

      this.price = price;
      this.volume = volume;
    }

    public Double getPrice() {

      return price;
    }

    public Double getVolume() {

      return volume;
    }
  }
}
