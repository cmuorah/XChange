package org.knowm.xchange.truefx;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.truefx.dto.marketdata.TrueFxTicker;
import org.knowm.xchange.utils.jackson.CurrencyPairDeserializer;

public class TrueFxAdapters {
  public static Ticker adaptTicker(TrueFxTicker rawTicker) {
    CurrencyPair pair = CurrencyPairDeserializer.getCurrencyPairFromString(rawTicker.getPair());
    return new Ticker.Builder()
        .currencyPair(pair)
        .timestamp(rawTicker.getTimestamp())
        .bid(rawTicker.calcBid())
        .ask(rawTicker.calcAsk())
        .high(rawTicker.getHigh())
        .low(rawTicker.getLow())
        .build();
  }
}
