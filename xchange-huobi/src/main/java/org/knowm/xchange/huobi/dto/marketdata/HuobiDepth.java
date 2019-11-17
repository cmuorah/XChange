package org.knowm.xchange.huobi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public final class HuobiDepth {

  private final long id;
  private final Date ts;
  public final SortedMap<Double, Double> bids;
  public final SortedMap<Double, Double> asks;

  public HuobiDepth(
      @JsonProperty("id") long id,
      @JsonProperty("ts") Date ts,
      @JsonProperty("bids") List<Double[]> bidsJson,
      @JsonProperty("asks") List<Double[]> asksJson) {
    this.id = id;
    this.ts = ts;

    BiConsumer<Double[], Map<Double, Double>> entryProcessor =
        (obj, col) -> {
          col.put(obj[0], obj[1]);
        };

    TreeMap<Double, Double> bids = new TreeMap<>((k1, k2) -> -k1.compareTo(k2));
    TreeMap<Double, Double> asks = new TreeMap<>();

    bidsJson.stream().forEach(e -> entryProcessor.accept(e, bids));
    asksJson.stream().forEach(e -> entryProcessor.accept(e, asks));

    this.bids = Collections.unmodifiableSortedMap(bids);
    this.asks = Collections.unmodifiableSortedMap(asks);
  }

  public long getId() {
    return id;
  }

  public Date getTs() {
    return ts;
  }

  public SortedMap<Double, Double> getBids() {
    return bids;
  }

  public SortedMap<Double, Double> getAsks() {
    return asks;
  }

  @Override
  public String toString() {
    return "HuobiDepth [id="
        + getId()
        + ", timestamp="
        + getTs()
        + ", bids="
        + getBids().toString()
        + ", asks="
        + getAsks().toString()
        + "]";
  }
}
