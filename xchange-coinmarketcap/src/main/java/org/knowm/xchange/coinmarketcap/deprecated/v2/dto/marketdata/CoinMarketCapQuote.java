package org.knowm.xchange.coinmarketcap.deprecated.v2.dto.marketdata;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

public class CoinMarketCapQuote {
  private final Double price;
  private final Double volume24h;
  private final Double marketCap;
  private final Double pctChange1h;
  private final Double pctChange24h;
  private final Double pctChange7d;

  private CoinMarketCapQuote(
      final Double price,
      final Double volume24h,
      final Double marketCap,
      final Double pctChange1h,
      final Double pctChange24h,
      final Double pctChange7d) {

    this.price = price;
    this.volume24h = volume24h;
    this.marketCap = marketCap;
    this.pctChange1h = pctChange1h;
    this.pctChange24h = pctChange24h;
    this.pctChange7d = pctChange7d;
  }

  public Double getPrice() {
    return price;
  }

  public Double getVolume24h() {
    return volume24h;
  }

  public Double getMarketCap() {
    return marketCap;
  }

  public Double getPctChange1h() {
    return pctChange1h;
  }

  public Double getPctChange24h() {
    return pctChange24h;
  }

  public Double getPctChange7d() {
    return pctChange7d;
  }

  @Override
  public String toString() {

    return "CoinMarketCapQuote [price="
        + price
        + ", volume24h="
        + volume24h
        + ", marketCap="
        + marketCap
        + "]";
  }

  static class CoinMarketCapQuoteDeserializer extends JsonDeserializer<CoinMarketCapQuote> {

    @Override
    public CoinMarketCapQuote deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {

      ObjectCodec oc = jp.getCodec();
      JsonNode node = oc.readTree(jp);

      if (node.isObject()) {
        Double price = new Double(node.get("price").asDouble());
        Double volume24h = new Double(node.get("volume_24h").asDouble());
        Double marketCap = new Double(node.get("market_cap").asDouble());

        // TODO use these to create CoinMarketCapHistoricalSpotPrice instances
        Double pctChange1h = new Double(node.get("percent_change_1h").asDouble());
        Double pctChange24h = new Double(node.get("percent_change_24h").asDouble());
        Double pctChange7d = new Double(node.get("percent_change_7d").asDouble());

        return new CoinMarketCapQuote(
            price, volume24h, marketCap, pctChange1h, pctChange24h, pctChange7d);
      }
      return null;
    }
  }
}
