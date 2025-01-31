package org.knowm.xchange.bitcoinaverage;

import static org.knowm.xchange.currency.Currency.BTC;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.knowm.xchange.bitcoinaverage.dto.marketdata.BitcoinAverageTicker;
import org.knowm.xchange.bitcoinaverage.dto.marketdata.BitcoinAverageTickers;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.meta.CurrencyMetaData;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.meta.ExchangeMetaData;

/** Various adapters for converting from BitcoinAverage DTOs to XChange DTOs */
public final class BitcoinAverageAdapters {

  /** private Constructor */
  private BitcoinAverageAdapters() {}

  /**
   * Adapts a BitcoinAverageTicker to a Ticker Object
   *
   * @param bitcoinAverageTicker
   * @return Ticker
   */
  public static Ticker adaptTicker(
      BitcoinAverageTicker bitcoinAverageTicker, CurrencyPair currencyPair) {

    Double last = bitcoinAverageTicker.getLast();
    Double bid = bitcoinAverageTicker.getBid();
    Double ask = bitcoinAverageTicker.getAsk();
    Date timestamp = bitcoinAverageTicker.getTimestamp();
    Double volume = bitcoinAverageTicker.getVolume();

    return new Ticker.Builder()
        .currencyPair(currencyPair)
        .last(last)
        .bid(bid)
        .ask(ask)
        .volume(volume)
        .timestamp(timestamp.getTime())
        .build();
  }

  public static ExchangeMetaData adaptMetaData(
      BitcoinAverageTickers tickers, ExchangeMetaData bAMetaData) {

    Map<CurrencyPair, CurrencyPairMetaData> currencyPairs = new HashMap<>();
    for (String currency : tickers.getTickers().keySet()) {
      if (!currency.startsWith("BTC")) {
        throw new IllegalStateException("Unsupported currency: " + currency);
      }
      currencyPairs.put(new CurrencyPair(BTC, Currency.getInstance(currency.substring(3))), null);
    }
    return new ExchangeMetaData(
        currencyPairs, Collections.<Currency, CurrencyMetaData>emptyMap(), null, null, null);
  }
}
