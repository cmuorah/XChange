package org.knowm.xchange.anx.v2.bootstrap;

import static java.lang.System.out;
import static org.knowm.xchange.currency.Currency.*;
import static org.knowm.xchange.currency.CurrencyPair.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.*;
import org.knowm.xchange.anx.v2.dto.meta.ANXMarketMetaData;
import org.knowm.xchange.anx.v2.dto.meta.ANXMetaData;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.account.Fee;
import org.knowm.xchange.dto.meta.CurrencyMetaData;
import org.knowm.xchange.dto.meta.CurrencyPairMetaData;
import org.knowm.xchange.dto.meta.FeeTier;

public class ANXGenerator {

  static ObjectMapper mapper =
      new ObjectMapper()
          .configure(SerializationFeature.INDENT_OUTPUT, true)
          .setSerializationInclusion(JsonInclude.Include.NON_NULL);

  static Set<Currency> cryptos = new HashSet<>(Arrays.asList(BTC, LTC, DOGE, STR, XRP, START, EGD));
  static Currency[] fiats = {USD, EUR, GBP, HKD, AUD, CAD, NZD, SGD, JPY, CNY};

  // counter currencies for STARTCoin - all fiats but CNY
  static Currency[] fiatsStart = {USD, EUR, GBP, HKD, AUD, CAD, NZD, SGD, JPY};

  static CurrencyPair[] pairsOther = {LTC_BTC, DOGE_BTC, STR_BTC, XRP_BTC};
  static Map<CurrencyPair, FeeTier[]> currencyPairFeeTiers = new HashMap<>();

  // base currency -> min order size
  static Map<Currency, Double> minAmount = new HashMap<>();
  static Map<Currency, Double> maxAmount = new HashMap<>();
  static Map<Currency, CurrencyMetaData> currencyMap = new TreeMap<>();

  static Set<CurrencyPair> pairs = new HashSet<>();
  static Double fee = new Double(".006");

  static {
    minAmount.put(BTC, 1.0d / 100.0);
    minAmount.put(LTC, 1.0d / 10.0);
    minAmount.put(DOGE, 1.0d * 10000.0d);
    minAmount.put(XRP, 1.0d / 100.0);
    minAmount.put(STR, 1.0d / 100.0);
    minAmount.put(START, null);
    minAmount.put(EGD, null);

    maxAmount.put(BTC, 1.0d * 100000.0d);
    maxAmount.put(LTC, 1.0d * 10000000.0d);
    maxAmount.put(DOGE, 1.0d * 10000000000.0d);
    maxAmount.put(XRP, 1.0d * 100000.0d);
    maxAmount.put(STR, 1.0d * 100000.0d);
    maxAmount.put(START, null);
    maxAmount.put(EGD, null);

    currencyPairFeeTiers.put(
        LTC_BTC,
        new FeeTier[] {
          new FeeTier(0d, new Fee(1d / 100.0, 1d / 10d)),
          new FeeTier(10d, new Fee(1d / 10000.0, 1d / 1000d))
        });
    currencyPairFeeTiers.put(
        DOGE_BTC,
        new FeeTier[] {
          new FeeTier(0d, new Fee(1d / 100000d, 1d / 10d)),
          new FeeTier(10d, new Fee(1d / 1000000d, 1d / 10000d))
        });
    FeeTier[] constantFeeTier = new FeeTier[] {new FeeTier(0d, new Fee(1d / 100.0, 1d / 10.0))};
    currencyPairFeeTiers.put(STR_BTC, constantFeeTier);
    currencyPairFeeTiers.put(XRP_BTC, constantFeeTier);

    for (Currency crypto : cryptos) {
      currencyMap.put(crypto, new CurrencyMetaData(8, null));
    }

    currencyMap.put(CNY, new CurrencyMetaData(8, null));
    for (Currency fiat : fiats) {
      if (!currencyMap.containsKey(fiat)) {
        currencyMap.put(fiat, new CurrencyMetaData(2, null));
      }
    }

    // extra currencies available, but not traded
    currencyMap.put(CHF, new CurrencyMetaData(2, null));
    currencyMap.put(NMC, new CurrencyMetaData(8, null));
    currencyMap.put(BGC, new CurrencyMetaData(8, null));
    currencyMap.put(PPC, new CurrencyMetaData(8, null));

    Collections.addAll(pairs, pairsOther);

    for (Currency base : Arrays.asList(BTC, EGD)) {
      for (Currency counter : fiats) {
        pairs.add(new CurrencyPair(base, counter));
      }
    }

    for (Currency counter : fiatsStart) {
      pairs.add(new CurrencyPair(START, counter));
    }
  }

  public static void main(String[] args) throws IOException {
    new ANXGenerator().run();
  }

  private void run() throws IOException {

    Map<CurrencyPair, CurrencyPairMetaData> map = new TreeMap<>();

    for (CurrencyPair pair : pairs) {
      handleCurrencyPair(map, pair);
    }
    // TODO add RateLimits, fees
    ANXMetaData metaData = new ANXMetaData(map, currencyMap, null, null, null, null, null);

    mapper.writeValue(out, metaData);
    out.println();
    out.flush();
  }

  private void handleCurrencyPair(
      Map<CurrencyPair, CurrencyPairMetaData> map, CurrencyPair currencyPair) {
    int amountScale = amountScale(currencyPair);
    Double minimumAmount = scaled(minAmount.get(currencyPair.base), amountScale);
    Double maximumAmount = scaled(maxAmount.get(currencyPair.base), amountScale);
    ANXMarketMetaData mmd =
        new ANXMarketMetaData(
            fee,
            minimumAmount,
            maximumAmount,
            priceScale(currencyPair),
            currencyPairFeeTiers.get(currencyPair));
    map.put(currencyPair, mmd);
  }

  Double scaled(Double value, int scale) {
    return value;
  }

  private int amountScale(CurrencyPair currencyPair) {
    return currencyMap.get(currencyPair.base.getCurrencyCode()).getScale();
  }

  int priceScale(CurrencyPair pair) {
    if (LTC_BTC.equals(pair)
        || (BTC.getCurrencyCode().equals(pair.base.getCurrencyCode())
            && !cryptos.contains(pair.counter))) {
      return 5;
    } else {
      return 8;
    }
  }
}
