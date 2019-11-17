package org.knowm.xchange.bitz.dto.marketdata;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;
import org.knowm.xchange.bitz.dto.marketdata.BitZPublicOrder.BitZOrderDeserializer;

@JsonDeserialize(using = BitZOrderDeserializer.class)
public class BitZPublicOrder {

  private final Double price;
  private final Double volume;

  public BitZPublicOrder(Double price, Double volume) {
    this.price = price;
    this.volume = volume;
  }

  public Double getPrice() {
    return price;
  }

  public Double getVolume() {
    return volume;
  }

  static class BitZOrderDeserializer extends JsonDeserializer<BitZPublicOrder> {

    @Override
    public BitZPublicOrder deserialize(JsonParser p, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
      ObjectCodec oc = p.getCodec();
      JsonNode node = oc.readTree(p);

      if (node.isArray()) {
        Double price = new Double(node.path(0).asText());
        Double volume = new Double(node.path(1).asText());

        return new BitZPublicOrder(price, volume);
      }

      return null;
    }
  }
}
