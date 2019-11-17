package org.knowm.xchange.btcmarkets.dto.marketdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Date;
import java.util.List;
import org.knowm.xchange.utils.jackson.UnixTimestampDeserializer;

public class BTCMarketsOrderBook {

  private String currency;

  private String instrument;

  @JsonDeserialize(using = UnixTimestampDeserializer.class)
  private Date timestamp;

  /** (price, amount) pairs in units of 10e-8 */
  private List<Double[]> bids;

  /** (price, amount) pairs in units of 10e-8 */
  private List<Double[]> asks;

  public String getCurrency() {
    return currency;
  }

  public String getInstrument() {
    return instrument;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public List<Double[]> getBids() {
    return bids;
  }

  public List<Double[]> getAsks() {
    return asks;
  }

  @Override
  public String toString() {
    return String.format(
        "BTCMarketsOrderBook{currency='%s', instrument='%s', timestamp=%s, bids=%d, asks=%d}",
        currency, instrument, timestamp, bids.size(), asks.size());
  }
}
