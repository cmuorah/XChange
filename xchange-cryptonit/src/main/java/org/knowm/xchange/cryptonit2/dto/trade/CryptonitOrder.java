package org.knowm.xchange.cryptonit2.dto.trade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Date;
import org.knowm.xchange.cryptonit2.CryptonitUtils;
import si.mazi.rescu.ExceptionalReturnContentException;

/** @author Matija Mazi */
public final class CryptonitOrder {

  private int id;
  private Date datetime;
  /** 0 - buy (bid); 1 - sell (ask) */
  private int type;

  private Double price;
  private Double amount;
  private String errorMessage;

  public CryptonitOrder(
      @JsonProperty("status") String status,
      @JsonProperty("reason") Object reason,
      @JsonProperty("id") int id,
      @JsonProperty("datetime") String datetime,
      @JsonProperty("type") int type,
      @JsonProperty("price") Double price,
      @JsonProperty("amount") Double amount,
      @JsonProperty("error") @JsonDeserialize(using = CryptonitErrorDeserializer.class)
          String errorMessage) {

    if ("error".equals(status)) {
      throw new ExceptionalReturnContentException(String.valueOf(reason));
    }

    this.id = id;
    this.datetime = CryptonitUtils.parseDate(datetime);
    this.type = type;
    this.price = price;
    this.amount = amount;
    this.errorMessage = errorMessage;
  }

  public Date getDatetime() {

    return datetime;
  }

  public int getId() {

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
