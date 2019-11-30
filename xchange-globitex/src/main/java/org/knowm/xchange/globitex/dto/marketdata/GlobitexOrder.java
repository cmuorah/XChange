package org.knowm.xchange.globitex.dto.marketdata;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import net.openhft.chronicle.wire.AbstractMarshallable;

import java.io.IOException;
import java.io.Serializable;

@JsonDeserialize(using = GlobitexOrder.GlobitexOrderDeserializer.class)
public class GlobitexOrder extends AbstractMarshallable implements Serializable {

  private final Double price;

  private final Double volume;

  public GlobitexOrder(Double price, Double volume) {
    this.price = price;
    this.volume = volume;
  }

  public Double getPrice() {
    return price;
  }

  public Double getVolume() {
    return volume;
  }

  @Override
  public String toString() {
    return "GlobitexOrder{" + "price=" + price + ", volume=" + volume + '}';
  }

  static class GlobitexOrderDeserializer extends JsonDeserializer<GlobitexOrder> {

    @Override
    public GlobitexOrder deserialize(JsonParser jsonParser, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {

      ObjectCodec oc = jsonParser.getCodec();
      JsonNode node = oc.readTree(jsonParser);
      if (node.isArray()) {
        Double price = new Double(node.path(0).asText());
        Double volume = new Double(node.path(1).asText());

        return new GlobitexOrder(price, volume);
      }

      return null;
    }
  }
}
