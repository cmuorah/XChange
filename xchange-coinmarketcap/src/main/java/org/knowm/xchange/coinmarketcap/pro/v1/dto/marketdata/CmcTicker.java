package org.knowm.xchange.coinmarketcap.pro.v1.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.knowm.xchange.utils.jackson.ISO8601DateDeserializer;

public final class CmcTicker {

  private final String symbol;
  private final Double circulatingSupply;
  private final Date lastUpdated;
  private final Double totalSupply;
  private final int cmcRank;
  private final CmcPlatform platform;
  private final List<String> tags;
  private final Date dateAdded;
  private final Map<String, CmcQuote> quoteData;
  private final Double numMarketPairs;
  private final String name;
  private final Double maxSupply;
  private final int id;
  private final String slug;

  public CmcTicker(
      @JsonProperty("symbol") String symbol,
      @JsonProperty("circulating_supply") Double circulatingSupply,
      @JsonProperty("last_updated") @JsonDeserialize(using = ISO8601DateDeserializer.class)
          Date lastUpdated,
      @JsonProperty("total_supply") Double totalSupply,
      @JsonProperty("cmc_rank") int cmcRank,
      @JsonProperty("platform") CmcPlatform platform,
      @JsonProperty("tags") List<String> tags,
      @JsonProperty("date_added") @JsonDeserialize(using = ISO8601DateDeserializer.class)
          Date dateAdded,
      @JsonProperty("quote") Map<String, CmcQuote> quoteData,
      @JsonProperty("num_market_pairs") Double numMarketPairs,
      @JsonProperty("name") String name,
      @JsonProperty("max_supply") Double maxSupply,
      @JsonProperty("id") int id,
      @JsonProperty("slug") String slug) {

    this.symbol = symbol;
    this.circulatingSupply = circulatingSupply;
    this.lastUpdated = lastUpdated;
    this.totalSupply = totalSupply;
    this.cmcRank = cmcRank;
    this.platform = platform;
    this.tags = tags;
    this.dateAdded = dateAdded;
    this.quoteData = quoteData;
    this.numMarketPairs = numMarketPairs;
    this.name = name;
    this.maxSupply = maxSupply;
    this.id = id;
    this.slug = slug;
  }

  public String getSymbol() {
    return symbol;
  }

  public Double getCirculatingSupply() {
    return circulatingSupply;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

  public Double getTotalSupply() {
    return totalSupply;
  }

  public int getCmcRank() {
    return cmcRank;
  }

  public CmcPlatform getPlatform() {
    return platform;
  }

  public List<String> getTags() {
    return tags;
  }

  public Date getDateAdded() {
    return dateAdded;
  }

  public Map<String, CmcQuote> getQuote() {
    return quoteData;
  }

  public Double getNumMarketPairs() {
    return numMarketPairs;
  }

  public String getName() {
    return name;
  }

  public Double getMaxSupply() {
    return maxSupply;
  }

  public int getId() {
    return id;
  }

  public String getSlug() {
    return slug;
  }

  @Override
  public String toString() {
    return "CmcTicker{"
        + "symbol = '"
        + symbol
        + '\''
        + ",circulating_supply = '"
        + circulatingSupply
        + '\''
        + ",last_updated = '"
        + lastUpdated
        + '\''
        + ",total_supply = '"
        + totalSupply
        + '\''
        + ",cmc_rank = '"
        + cmcRank
        + '\''
        + ",platform = '"
        + platform
        + '\''
        + ",tags = '"
        + tags
        + '\''
        + ",date_added = '"
        + dateAdded
        + '\''
        + ",quote = '"
        + quoteData
        + '\''
        + ",num_market_pairs = '"
        + numMarketPairs
        + '\''
        + ",name = '"
        + name
        + '\''
        + ",max_supply = '"
        + maxSupply
        + '\''
        + ",id = '"
        + id
        + '\''
        + ",slug = '"
        + slug
        + '\''
        + "}";
  }
}
