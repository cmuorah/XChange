package org.knowm.xchange.kraken.dto.marketdata;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;
import org.knowm.xchange.kraken.dto.marketdata.KrakenPublicOrder.KrakenOrderDeserializer;

@JsonDeserialize(using = KrakenOrderDeserializer.class)
public class KrakenPublicOrder {

  private final Double price;
  private final Double volume;
  private final long timestamp;

  public KrakenPublicOrder(Double price, Double volume, long timestamp) {

    this.price = price;
    this.volume = volume;
    this.timestamp = timestamp;
  }

  public Double getPrice() {

    return price;
  }

  public Double getVolume() {

    return volume;
  }

  public long getTimestamp() {

    return timestamp;
  }

  @Override
  public String toString() {

    return "KrakenOrder [price=" + price + ", volume=" + volume + ", timestamp=" + timestamp + "]";
  }

  static class KrakenOrderDeserializer extends JsonDeserializer<KrakenPublicOrder> {

    @Override
    public KrakenPublicOrder deserialize(JsonParser jsonParser, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {

      ObjectCodec oc = jsonParser.getCodec();
      JsonNode node = oc.readTree(jsonParser);
      if (node.isArray()) {
        Double price = new Double(node.path(0).asText());
        Double volume = new Double(node.path(1).asText());
        long timestamp = node.path(2).asLong();

        return new KrakenPublicOrder(price, volume, timestamp);
      }

      return null;
    }
  }
}
