package org.knowm.xchange.binance.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public final class BinanceOrderbook {

  public final long lastUpdateId;
  public final SortedMap<Double, Double> bids;
  public final SortedMap<Double, Double> asks;

  public BinanceOrderbook(
      @JsonProperty("lastUpdateId") long lastUpdateId,
      @JsonProperty("bids") List<Object[]> bidsJson,
      @JsonProperty("asks") List<Object[]> asksJson) {
    this.lastUpdateId = lastUpdateId;
    BiConsumer<Object[], Map<Double, Double>> entryProcessor =
        (obj, col) -> {
          Double price = new Double(obj[0].toString());
          Double qty = new Double(obj[1].toString());
          col.put(price, qty);
        };

    TreeMap<Double, Double> bids = new TreeMap<>((k1, k2) -> -k1.compareTo(k2));
    TreeMap<Double, Double> asks = new TreeMap<>();

    bidsJson.stream().forEach(e -> entryProcessor.accept(e, bids));
    asksJson.stream().forEach(e -> entryProcessor.accept(e, asks));

    this.bids = Collections.unmodifiableSortedMap(bids);
    this.asks = Collections.unmodifiableSortedMap(asks);
  }
}
