package org.knowm.xchange.anx.v2.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class ANXTrade {

  private final Double amount;
  private final long amountInt;
  private final String item;
  private final String priceCurrency;
  private final Double price;
  private final long priceInt;
  private final String primary;
  private final String properties;
  private final long tid;
  private final String tradeType;

  public ANXTrade(
      @JsonProperty("amount") Double amount,
      @JsonProperty("amount_int") long amountInt,
      @JsonProperty("item") String item,
      @JsonProperty("price_currency") String priceCurrency,
      @JsonProperty("price") Double price,
      @JsonProperty("price_int") long priceInt,
      @JsonProperty("primary") String primary,
      @JsonProperty("properties") String properties,
      @JsonProperty("tid") long tid,
      @JsonProperty("trade_type") String tradeType) {

    this.amount = amount;
    this.amountInt = amountInt;
    this.item = item;
    this.priceCurrency = priceCurrency;
    this.price = price;
    this.priceInt = priceInt;
    this.primary = primary;
    this.properties = properties;
    this.tid = tid;
    this.tradeType = tradeType;
  }

  public Double getAmount() {

    return amount;
  }

  public long getAmountInt() {

    return amountInt;
  }

  public String getItem() {

    return item;
  }

  public String getPriceCurrency() {

    return priceCurrency;
  }

  public Double getPrice() {

    return price;
  }

  public long getPriceInt() {

    return priceInt;
  }

  public String getPrimary() {

    return primary;
  }

  public String getProperties() {

    return properties;
  }

  public long getTid() {

    return tid;
  }

  public String getTradeType() {

    return tradeType;
  }

  @Override
  public String toString() {

    return "ANXTrade [amount="
        + amount
        + ", amountInt="
        + amountInt
        + ", item="
        + item
        + ", priceCurrency="
        + priceCurrency
        + ", price="
        + price
        + ", priceInt="
        + priceInt
        + ", primary="
        + primary
        + ", properties="
        + properties
        + ", tid="
        + tid
        + ", tradeType="
        + tradeType
        + "]";
  }
}
