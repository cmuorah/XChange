package org.knowm.xchange.paymium.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class PaymiumTrade {

  private final UUID uuid;
  private final Double traded_btc;
  private final Double traded_currency;
  private final String created_at;
  private final String currency;
  private final Double price;
  private final long created_at_int;

  public PaymiumTrade(
      @JsonProperty("uuid") UUID uuid,
      @JsonProperty("traded_btc") Double traded_btc,
      @JsonProperty("traded_currency") Double traded_currency,
      @JsonProperty("created_at") String created_at,
      @JsonProperty("currency") String currency,
      @JsonProperty("price") Double price,
      @JsonProperty("created_at_int") long created_at_int) {

    this.uuid = uuid;
    this.traded_btc = traded_btc;
    this.traded_currency = traded_currency;
    this.created_at = created_at;
    this.currency = currency;
    this.price = price;
    this.created_at_int = created_at_int;
  }

  public UUID getUuid() {

    return uuid;
  }

  public Double getTraded_btc() {

    return traded_btc;
  }

  public Double getTraded_currency() {

    return traded_currency;
  }

  public String getCreated_at() {

    return created_at;
  }

  public String getCurrency() {

    return currency;
  }

  public Double getPrice() {

    return price;
  }

  public long getCreated_at_int() {

    return created_at_int;
  }

  @Override
  public String toString() {

    return "PaymiumTrade{"
        + "uuid="
        + uuid
        + ", traded_btc="
        + traded_btc
        + ", traded_currency="
        + traded_currency
        + ", created_at='"
        + created_at
        + '\''
        + ", currency='"
        + currency
        + '\''
        + ", price="
        + price
        + ", created_at_int="
        + created_at_int
        + '}';
  }
}
