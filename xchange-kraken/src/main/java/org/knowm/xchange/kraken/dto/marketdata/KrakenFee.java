package org.knowm.xchange.kraken.dto.marketdata;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;
import org.knowm.xchange.kraken.dto.marketdata.KrakenFee.KrakenFeeDeserializer;

@JsonDeserialize(using = KrakenFeeDeserializer.class)
public class KrakenFee implements Comparable<KrakenFee> {

  private final Double volume;
  private final Double percentFee;

  public KrakenFee(Double volume, Double percentFee) {

    this.volume = volume;
    this.percentFee = percentFee;
  }

  public int compareTo(KrakenFee other) {
    return volume.compareTo(other.volume);
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

  static class KrakenFeeDeserializer extends JsonDeserializer<KrakenFee> {

    @Override
    public KrakenFee deserialize(JsonParser jsonParser, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {

      ObjectCodec oc = jsonParser.getCodec();
      JsonNode node = oc.readTree(jsonParser);
      Double volume = new Double(node.path(0).asText());
      Double fee = new Double(node.path(1).asText());

      return new KrakenFee(volume, fee);
    }
  }
}
