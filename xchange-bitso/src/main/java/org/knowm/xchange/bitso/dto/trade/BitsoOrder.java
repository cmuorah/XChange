package org.knowm.xchange.bitso.dto.trade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Date;
import org.knowm.xchange.bitso.BitsoUtils;

/** @author Piotr Ładyżyński */
public final class BitsoOrder {

  private final String id;
  private final String datetime;
  /** 0 - buy (bid); 1 - sell (ask) */
  private final int type;

  private final Double price;
  private final Double amount;
  private final String errorMessage;

  /**
   * Constructor
   *
   * @param id
   * @param datetime
   * @param type
   * @param price
   * @param amount
   */
  public BitsoOrder(
      @JsonProperty("id") String id,
      @JsonProperty("datetime") String datetime,
      @JsonProperty("type") int type,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("error") @JsonDeserialize(using = BitsoErrorDeserializer.class)
          String errorMessage) {

    this.id = id;
    this.datetime = datetime;
    this.type = type;
    this.price = price;
    this.amount = amount;
    this.errorMessage = errorMessage;
  }

  public String getDatetime() {

    return datetime;
  }

  public String getId() {

    return id;
  }

  public int getType() {

    return type;
  }

  public Double getPrice() {

    return price;
  }

  public Double getAmount() {

    return amount;
  }

  @JsonIgnore
  public Date getTime() {

    return BitsoUtils.parseDate(getDatetime());
  }

  @JsonIgnore
  public String getErrorMessage() {

    return errorMessage;
  }

  @Override
  public String toString() {

    return errorMessage != null
        ? errorMessage
        : String.format(
            "Order{id=%s, datetime=%s, type=%s, price=%s, amount=%s}",
            id, datetime, type, price, amount);
  }
}
