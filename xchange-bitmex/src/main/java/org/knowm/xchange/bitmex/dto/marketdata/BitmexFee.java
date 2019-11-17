package org.knowm.xchange.bitmex.dto.marketdata;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;
import org.knowm.xchange.bitmex.dto.marketdata.BitmexFee.BitmexFeeDeserializer;

@JsonDeserialize(using = BitmexFeeDeserializer.class)
public class BitmexFee {

  private final Double volume;
  private final Double percentFee;

  public BitmexFee(Double volume, Double percentFee) {

    this.volume = volume;
    this.percentFee = percentFee;
  }

  public Double getVolume() {

    return volume;
  }

  public Double getPercentFee() {

    return percentFee;
  }

  @Override
  public String toString() {

    return "KrakenFee [volume=" + volume + ", percentFee=" + percentFee + "]";
  }

  static class BitmexFeeDeserializer extends JsonDeserializer<BitmexFee> {

    @Override
    public BitmexFee deserialize(JsonParser jsonParser, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {

      ObjectCodec oc = jsonParser.getCodec();
      JsonNode node = oc.readTree(jsonParser);
      Double volume = new Double(node.path(0).asText());
      Double fee = new Double(node.path(1).asText());

      return new BitmexFee(volume, fee);
    }
  }
}
