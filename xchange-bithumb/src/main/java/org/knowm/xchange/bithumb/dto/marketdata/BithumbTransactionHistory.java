package org.knowm.xchange.bithumb.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;
import java.util.Date;
import org.apache.commons.lang3.time.FastDateFormat;
import org.knowm.xchange.bithumb.BithumbAdapters;

public class BithumbTransactionHistory {

  public static final FastDateFormat TRANSACTION_DATE_FORMAT =
      FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
  private final long contNo;
  private final String transactionDate;
  private final BithumbAdapters.OrderType type;
  private final Double unitsTraded;
  private final Double price;
  private final Double total;

  public BithumbTransactionHistory(
      @JsonProperty("cont_no") long contNo,
      @JsonProperty("transaction_date") String transactionDate,
      @JsonProperty("type") BithumbAdapters.OrderType type,
      @JsonProperty("units_traded") Double unitsTraded,
      @JsonProperty("price") Double price,
      @JsonProperty("total") Double total) {
    this.contNo = contNo;
    this.transactionDate = transactionDate;
    this.type = type;
    this.unitsTraded = unitsTraded;
    this.price = price;
    this.total = total;
  }

  public long getContNo() {
    return contNo;
  }

  public String getTransactionDate() {
    return transactionDate;
  }

  public BithumbAdapters.OrderType getType() {
    return type;
  }

  public Double getUnitsTraded() {
    return unitsTraded;
  }

  public Double getPrice() {
    return price;
  }

  public Double getTotal() {
    return total;
  }

  public Date getTimestamp() {
    try {
      return TRANSACTION_DATE_FORMAT.parse(transactionDate);
    } catch (ParseException e) {
      return null;
    }
  }

  @Override
  public String toString() {
    return "BithumbTransactionHistory{"
        + "contNo="
        + contNo
        + ", transactionDate='"
        + transactionDate
        + '\''
        + ", type='"
        + type
        + '\''
        + ", unitsTraded="
        + unitsTraded
        + ", price="
        + price
        + ", total="
        + total
        + '}';
  }
}
