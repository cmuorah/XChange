package org.knowm.xchange.ripple.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class ToPlainStringSerializer extends JsonSerializer<Double> {
  @Override
  public void serialize(
      final Double value, final JsonGenerator jgen, final SerializerProvider provider)
      throws IOException {
    jgen.writeString(value.toString());
  }
}
