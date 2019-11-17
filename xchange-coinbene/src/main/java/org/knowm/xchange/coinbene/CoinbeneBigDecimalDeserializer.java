package org.knowm.xchange.coinbene;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class CoinbeneBigDecimalDeserializer extends JsonDeserializer<Double> {

  @Override
  public Double deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException, JsonProcessingException {

    String value = jsonParser.getValueAsString();

    if ("--".equals(value)) {
      return 0d;
    } else {
      return new Double(value);
    }
  }
}
