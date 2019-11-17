package org.knowm.xchange.ccex.dto.ticker;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;
import org.knowm.xchange.ccex.dto.ticker.CCEXPrice.CCEXPriceDeserializer;

@JsonDeserialize(using = CCEXPriceDeserializer.class)
public class CCEXPrice {

  private final Double high;
  private final Double low;
  private final Double avg;
  private final Double lastbuy;
  private final Double lastsell;
  private final Double buy;
  private final Double sell;
  private final Double lastprice;
  private final int updated;

  private CCEXPrice(
      Double high,
      Double low,
      Double avg,
      Double lastbuy,
      Double lastsell,
      Double buy,
      Double sell,
      Double lastprice,
      int updated) {

    this.high = high;
    this.low = low;
    this.avg = avg;
    this.lastbuy = lastbuy;
    this.lastsell = lastsell;
    this.buy = buy;
    this.sell = sell;
    this.lastprice = lastprice;
    this.updated = updated;
  }

  public Double getHigh() {
    return high;
  }

  public Double getLow() {
    return low;
  }

  public Double getAvg() {
    return avg;
  }

  public Double getLastbuy() {
    return lastbuy;
  }

  public Double getLastsell() {
    return lastsell;
  }

  public Double getBuy() {
    return buy;
  }

  public Double getSell() {
    return sell;
  }

  public Double getLastprice() {
    return lastprice;
  }

  public int getUpdated() {
    return updated;
  }

  @Override
  public String toString() {
    return "CCEXPrice [high="
        + high
        + ", low="
        + low
        + ", avg="
        + avg
        + ", lastbuy="
        + lastbuy
        + ", lastsell="
        + lastsell
        + ", buy="
        + buy
        + ", sell="
        + sell
        + ", lastprice="
        + lastprice
        + ", updated="
        + updated
        + "]";
  }

  static class CCEXPriceDeserializer extends JsonDeserializer<CCEXPrice> {

    private static Double getNumberIfPresent(JsonNode numberNode) {

      final String numberString = numberNode.asText();
      return numberString.isEmpty() ? null : new Double(numberString);
    }

    public static CCEXPrice deserializeFromNode(JsonNode tickerNode) {

      final Double high = getNumberIfPresent(tickerNode.path("high"));
      final Double low = getNumberIfPresent(tickerNode.path("low"));
      final Double avg = getNumberIfPresent(tickerNode.path("avg"));
      final Double lastbuy = getNumberIfPresent(tickerNode.path("lastbuy"));
      final Double lastsell = getNumberIfPresent(tickerNode.path("lastsell"));
      final Double buy = getNumberIfPresent(tickerNode.path("buy"));
      final Double sell = getNumberIfPresent(tickerNode.path("sell"));
      final Double lastprice = getNumberIfPresent(tickerNode.path("lastprice"));
      final int updated = tickerNode.path("updated").asInt();

      return new CCEXPrice(high, low, avg, lastbuy, lastsell, buy, sell, lastprice, updated);
    }

    @Override
    public CCEXPrice deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {

      final ObjectCodec oc = jp.getCodec();
      final JsonNode tickerNode = oc.readTree(jp);

      return deserializeFromNode(tickerNode);
    }
  }
}
