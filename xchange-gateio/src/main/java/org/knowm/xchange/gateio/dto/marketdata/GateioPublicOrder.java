package org.knowm.xchange.gateio.dto.marketdata;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;
import org.knowm.xchange.gateio.dto.marketdata.GateioPublicOrder.GateioPublicOrderDeserializer;

@JsonDeserialize(using = GateioPublicOrderDeserializer.class)
public class GateioPublicOrder {

  private final Double price;
  private final Double amount;

  private GateioPublicOrder(Double price, final Double amount) {

    this.price = price;
    this.amount = amount;
  }

  public Double getPrice() {

    return price;
  }

  public Double getAmount() {

    return amount;
  }

  @Override
  public String toString() {

    return "GateioPublicOrder [price=" + price + ", amount=" + amount + "]";
  }

  static class GateioPublicOrderDeserializer extends JsonDeserializer<GateioPublicOrder> {

    @Override
    public GateioPublicOrder deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {

      final ObjectCodec oc = jp.getCodec();
      final JsonNode tickerNode = oc.readTree(jp);

      final Double price = new Double(tickerNode.path(0).asText());
      final Double amount = new Double(tickerNode.path(1).asText());

      return new GateioPublicOrder(price, amount);
    }
  }
}
