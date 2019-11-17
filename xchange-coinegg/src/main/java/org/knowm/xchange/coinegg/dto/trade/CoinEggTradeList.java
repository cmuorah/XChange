package org.knowm.xchange.coinegg.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.util.Date;
import org.knowm.xchange.coinegg.dto.marketdata.CoinEggTrade.Type;
import org.knowm.xchange.utils.DateUtils;

public class CoinEggTradeList {

  private final int id;
  private final Type type;
  private final Double price;
  private final Double amountOriginal;
  private final Double amountOutstanding;
  private Date datetime;

  public CoinEggTradeList(
      @JsonProperty("id") int id,
      @JsonProperty("datetime") String datetime,
      @JsonProperty("type") Type type,
      @JsonProperty("price") Double price,
      @JsonProperty("amount_original") Double amountOriginal,
      @JsonProperty("amount_outstanding") Double amountOutstanding) {

    this.id = id;
    this.type = type;
    this.price = price;
    this.amountOriginal = amountOriginal;
    this.amountOutstanding = amountOutstanding;

    try {
      this.datetime = DateUtils.fromISO8601DateString(datetime);
    } catch (InvalidFormatException e) {
      this.datetime = null;
    }
  }

  public Date getDateTime() {
    return datetime;
  }

  public int getID() {
    return id;
  }

  public Type getType() {
    return type;
  }

  public Double getPrice() {
    return price;
  }

  public Double getAmountOriginal() {
    return amountOriginal;
  }

  public Double getAmountOutstanding() {
    return amountOutstanding;
  }
}
