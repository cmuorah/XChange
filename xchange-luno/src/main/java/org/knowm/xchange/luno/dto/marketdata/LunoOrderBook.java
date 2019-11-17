package org.knowm.xchange.luno.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class LunoOrderBook {

  public final long timestamp;
  private final TreeMap<Double, Double> bids = new TreeMap<>((k1, k2) -> -k1.compareTo(k2));
  private final TreeMap<Double, Double> asks = new TreeMap<>();

  public LunoOrderBook(
      @JsonProperty(value = "timestamp", required = true) long timestamp,
      @JsonProperty(value = "asks") Order[] asks,
      @JsonProperty(value = "bids") Order[] bids) {
    this.timestamp = timestamp;
    // we merge the orders with the same price together bei adding the volumes

    // java8 style:
    // this.asks = Stream.of(asks).collect(Collectors.toMap(o -> o.price, o -> o.volume, (v1, v2) ->
    // v1.add(v2), () -> new TreeMap<Double, Double>()));
    // this.bids = Stream.of(bids).collect(Collectors.toMap(o -> o.price, o -> o.volume, (v1, v2) ->
    // v1.add(v2), () -> new TreeMap<Double, Double>((k1, k2) -> -k1.compareTo(k2))));

    // without java8:
    addOrdersToMap(asks, this.asks);
    addOrdersToMap(bids, this.bids);
  }

  private static void addOrdersToMap(Order[] orders, Map<Double, Double> map) {
    for (Order o : orders) {
      Double v = map.get(o.price);
      map.put(o.price, v == null ? o.volume : o.volume + (v));
    }
  }

  public Date getTimestamp() {
    return new Date(timestamp);
  }

  public Map<Double, Double> getBids() {
    return Collections.unmodifiableMap(bids);
  }

  public Map<Double, Double> getAsks() {
    return Collections.unmodifiableMap(asks);
  }

  @Override
  public String toString() {
    return "LunoOrderBook [timestamp=" + getTimestamp() + ", bids=" + bids + ", asks=" + asks + "]";
  }

  public static class Order {
    public final Double price;
    public final Double volume;

    public Order(
        @JsonProperty(value = "price", required = true) Double price,
        @JsonProperty(value = "volume", required = true) Double volume) {
      this.price = price;
      this.volume = volume;
    }
  }
}
