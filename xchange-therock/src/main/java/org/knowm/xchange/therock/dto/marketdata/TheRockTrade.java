package org.knowm.xchange.therock.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class TheRockTrade {

  private final Double amount;
  private final Date date;
  private final Double price;
  private final long id;
  private final Side side;

  public TheRockTrade(
      @JsonProperty("amount") Double amount,
      @JsonProperty("date") Date date,
      @JsonProperty("price") Double price,
      @JsonProperty("id") long id,
      @JsonProperty("side") Side tradeSide) {
    this.amount = amount;
    this.date = date;
    this.price = price;
    this.id = id;
    this.side = tradeSide;
  }

  public Double getAmount() {
    return amount;
  }

  public Date getDate() {
    return date;
  }

  public Double getPrice() {
    return price;
  }

  public long getId() {
    return id;
  }

  public Side getSide() {
    return side;
  }

  @Override
  public String toString() {
    return "TheRockTrade [amount="
        + amount
        + ", date="
        + date
        + ", price="
        + price
        + ", id="
        + id
        + ", side="
        + side
        + "]";
  }

  public enum Side {
    sell,
    buy,
    close_long,
    close_short
  }
}
