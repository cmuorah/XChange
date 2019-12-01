package org.knowm.xchange.btcc;

import java.util.Date;
import org.knowm.xchange.btcc.dto.marketdata.BTCCTicker;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;

public class BTCCAdapters {

  public static Ticker adaptTicker(BTCCTicker btccTicker, CurrencyPair currencyPair) {

    Double last = btccTicker.getLast();
    Double high = btccTicker.getHigh();
    Double low = btccTicker.getLow();
    Double ask = btccTicker.getAskPrice();
    Double bid = btccTicker.getBidPrice();
    Double volume = btccTicker.getVolume();
    Date timestamp = new Date(btccTicker.getTimestamp());

    return new Ticker.Builder()
        .currencyPair(currencyPair)
        .last(last)
        .high(high)
        .low(low)
        .volume(volume)
        .ask(ask)
        .bid(bid)
        .timestamp(timestamp.getTime())
        .build();
  }
}
