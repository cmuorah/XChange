package org.knowm.xchange.bitflyer.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BitflyerOrderbook {
  private final Double mid_price;
  private final List<BitflyerOrderbookEntry> bids;
  private final List<BitflyerOrderbookEntry> asks;

  public BitflyerOrderbook(
      @JsonProperty("mid_price") Double mid_price,
      @JsonProperty("bids") List<BitflyerOrderbookEntry> bidsJson,
      @JsonProperty("asks") List<BitflyerOrderbookEntry> asksJson) {

    this.mid_price = mid_price;
    this.bids = bidsJson;
    this.asks = asksJson;
  }

  public Double getMidPrice() {
    return mid_price;
  }

  public List<BitflyerOrderbookEntry> getBids() {
    return bids;
  }

  public List<BitflyerOrderbookEntry> getAsks() {
    return asks;
  }
}
