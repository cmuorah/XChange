package org.knowm.xchange.globitex.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.openhft.chronicle.wire.AbstractMarshallable;

import java.io.Serializable;
import java.util.List;

public class GlobitexActiveOrders extends AbstractMarshallable implements Serializable {

  @JsonProperty("orders")
  private final List<GlobitexActiveOrder> orders;

  public GlobitexActiveOrders(@JsonProperty("orders") List<GlobitexActiveOrder> orders) {
    this.orders = orders;
  }

  public List<GlobitexActiveOrder> getOrders() {
    return orders;
  }

  @Override
  public String toString() {
    return "GlobitexActiveOrders{" + "orders=" + orders + '}';
  }
}
