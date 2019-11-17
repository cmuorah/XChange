package org.knowm.xchange.btcturk.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import org.knowm.xchange.btcturk.dto.BTCTurkPair;

/** @author mertguner */
public final class BTCTurkOpenOrders {

  private final String id;
  private final Date datetime;
  private final String type;
  private final Double price;
  private final Double amount;
  private final BTCTurkPair pairsymbol;

  public BTCTurkOpenOrders(
      @JsonProperty("id") String id,
      @JsonProperty("datetime") Date datetime,
      @JsonProperty("type") String type,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("pairsymbol") BTCTurkPair pairsymbol) {
    this.id = id;
    this.datetime = datetime;
    this.type = type;
    this.price = price;
    this.amount = amount;
    this.pairsymbol = pairsymbol;
  }

  public String getId() {
    return id;
  }

  public Date getDatetime() {
    return datetime;
  }

  public String getType() {
    return type;
  }

  public Double getPrice() {
    return price;
  }

  public Double getAmount() {
    return amount;
  }

  public BTCTurkPair getPairsymbol() {
    return pairsymbol;
  }

  @Override
  public String toString() {
    return "BTCTurkOpenOrders [id="
        + id
        + ", datetime="
        + datetime
        + ", type="
        + type
        + ", price="
        + price
        + ", amount="
        + amount
        + ", pairsymbol="
        + pairsymbol
        + "]";
  }
}
