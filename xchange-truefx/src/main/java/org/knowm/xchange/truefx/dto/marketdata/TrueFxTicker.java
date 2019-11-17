package org.knowm.xchange.truefx.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.IOException;

@JsonPropertyOrder(
    value = {"pair", "timestamp", "bid", "bidBP", "ask", "askBP", "low", "high", "open"})
public class TrueFxTicker {
  private static final Double BASIS_POINT_MULTIPLIER = new Double("0.00001");

  private final String pair;
  private final long timestamp;
  private final Double bid;
  private final Double bidBP;
  private final Double ask;
  private final Double askBP;

  private final Double low;
  private final Double high;
  private final Double open;

  public TrueFxTicker(
      @JsonProperty("pair") String pair,
      @JsonProperty("timestamp") long timestamp,
      @JsonProperty("bid") Double bid,
      @JsonProperty("bidBP") Double bidBP,
      @JsonProperty("ask") Double ask,
      @JsonProperty("askBP") Double askBP,
      @JsonProperty("low") Double low,
      @JsonProperty("high") Double high,
      @JsonProperty("open") Double open) {
    this.pair = pair;
    this.timestamp = timestamp;
    this.bid = bid;
    this.bidBP = bidBP;
    this.ask = ask;
    this.askBP = askBP;
    this.low = low;
    this.high = high;
    this.open = open;
  }

  public String getPair() {
    return pair;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public Double getBid() {
    return bid;
  }

  public Double getBidBP() {
    return bidBP;
  }

  public Double getAsk() {
    return ask;
  }

  public Double getAskBP() {
    return askBP;
  }

  public Double getLow() {
    return low;
  }

  public Double getHigh() {
    return high;
  }

  public Double getOpen() {
    return open;
  }

  public Double calcBid() {
    return bid + (BASIS_POINT_MULTIPLIER * (bidBP));
  }

  public Double calcAsk() {
    return ask + (BASIS_POINT_MULTIPLIER * (askBP));
  }

  @Override
  public String toString() {
    return "TrueFxTicker [pair="
        + pair
        + ", bid="
        + calcBid()
        + ", ask="
        + calcAsk()
        + ", low="
        + low
        + ", high="
        + high
        + "]";
  }

  public static class TrueFxTickerDeserializer extends JsonDeserializer<TrueFxTicker> {
    private final CsvMapper mapper = new CsvMapper();
    private final CsvSchema schema = mapper.schemaFor(TrueFxTicker.class);

    @Override
    public TrueFxTicker deserialize(JsonParser parser, DeserializationContext context)
        throws IOException, JsonProcessingException {
      ArrayNode array = mapper.readerFor(TrueFxTicker.class).with(schema).readTree(parser);

      String pair = array.get(0).asText();
      long timestamp = array.get(1).asLong();
      Double bid = new Double(array.get(2).asText());
      Double bidBP = new Double(array.get(3).asText());
      Double ask = new Double(array.get(4).asText());
      Double askBP = new Double(array.get(5).asText());
      Double low = new Double(array.get(6).asText());
      Double high = new Double(array.get(7).asText());
      Double open = new Double(array.get(8).asText());

      return new TrueFxTicker(pair, timestamp, bid, bidBP, ask, askBP, low, high, open);
    }
  }
}
