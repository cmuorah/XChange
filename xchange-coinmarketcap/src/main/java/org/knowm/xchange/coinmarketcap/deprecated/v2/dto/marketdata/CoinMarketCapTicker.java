package org.knowm.xchange.coinmarketcap.deprecated.v2.dto.marketdata;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/** @author allenday */
@JsonDeserialize(using = CoinMarketCapTicker.CoinMarketCapTickerDeserializer.class)
public final class CoinMarketCapTicker {

  private final String id;
  private final String name;
  private final String symbol;
  private final String websiteSlug;
  private final Double rank;
  private final Double circulatingSupply;
  private final Double totalSupply;
  private final Double maxSupply;
  private final Map<String, CoinMarketCapQuote> quotes;
  private final Date lastUpdated;
  private final CoinMarketCapCurrency baseCurrency;

  private CoinMarketCapTicker(
      final String id,
      final String name,
      final String isoCode,
      final String websiteSlug,
      final Double rank,
      final Double circulatingSupply,
      final Double totalSupply,
      final Double maxSupply,
      final Map<String, CoinMarketCapQuote> quotes,
      final Date lastUpdated) {
    this.id = id;
    this.name = name;
    this.baseCurrency = new CoinMarketCapCurrency(isoCode);
    this.symbol = isoCode;
    this.websiteSlug = websiteSlug;
    this.rank = rank;
    this.circulatingSupply = circulatingSupply;
    this.totalSupply = totalSupply;
    this.maxSupply = maxSupply;
    this.quotes = quotes;
    this.lastUpdated = lastUpdated;
  }

  public String getID() {
    return id;
  }

  public String getName() {
    return name;
  }

  public CoinMarketCapCurrency getBaseCurrency() {
    return baseCurrency;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getWebsiteSlug() {
    return websiteSlug;
  }

  public Double getRank() {
    return rank;
  }

  public Double getCirculatingSupply() {
    return circulatingSupply;
  }

  public Double getTotalSupply() {
    return totalSupply;
  }

  public Double getMaxSupply() {
    return maxSupply;
  }

  public Map<String, CoinMarketCapQuote> getQuotes() {
    return quotes;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

  @Override
  public String toString() {

    return "CoinMarketCapCurrency [name=" + name + ", symbol=" + symbol + "]";
  }

  static class CoinMarketCapTickerDeserializer extends JsonDeserializer<CoinMarketCapTicker> {

    @Override
    public CoinMarketCapTicker deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {

      ObjectCodec oc = jp.getCodec();
      JsonNode node = oc.readTree(jp);

      if (node.isObject()) {
        String id = node.get("id").asText();
        String name = node.get("name").asText();
        String symbol = node.get("symbol").asText();
        String websiteSlug = node.get("website_slug").asText();
        Date lastUpdated = new Date(node.get("last_updated").asLong() * 1000);
        Double rank = new Double(node.get("rank").asInt());
        Double circulatingSupply = new Double(node.get("circulating_supply").asDouble());
        Double totalSupply = new Double(node.get("total_supply").asDouble());
        Double maxSupply = new Double(node.get("max_supply").asDouble());

        Map<String, CoinMarketCapQuote> quotes = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(
            CoinMarketCapQuote.class, new CoinMarketCapQuote.CoinMarketCapQuoteDeserializer());
        mapper.registerModule(module);
        Iterator<Map.Entry<String, JsonNode>> it = node.get("quotes").fields();
        while (it.hasNext()) {
          Map.Entry<String, JsonNode> pair = it.next();
          quotes.put(pair.getKey(), mapper.treeToValue(pair.getValue(), CoinMarketCapQuote.class));
        }

        CoinMarketCapTicker ticker =
            new CoinMarketCapTicker(
                id,
                name,
                symbol,
                websiteSlug,
                rank,
                circulatingSupply,
                totalSupply,
                maxSupply,
                quotes,
                lastUpdated);
        return ticker;
      }
      return null;
    }
  }
}
